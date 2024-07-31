class Solution {
    int totalBooks;
    int madeShelfWidth;

    // Helper function to find the minimum height of the shelf
    public int findMinHeight(int bookIndex, int[][] books, int currShelfWidth, int currShelfHeight, int[][] dp) {
        // Base case: last book
        if (bookIndex == totalBooks - 1) {
            if (books[bookIndex][0] <= currShelfWidth) {
                return Math.max(currShelfHeight, books[bookIndex][1]);
            }
            return currShelfHeight + books[bookIndex][1];
        }

        // Check if result is already computed
        if (dp[bookIndex][currShelfWidth] != 0) {
            return dp[bookIndex][currShelfWidth];
        }

        int sameShelf = Integer.MAX_VALUE;

        // Option 1: Place the current book on the same shelf
        if (books[bookIndex][0] <= currShelfWidth) {
            sameShelf = findMinHeight(bookIndex + 1, books, currShelfWidth - books[bookIndex][0], Math.max(currShelfHeight, books[bookIndex][1]), dp);
        }

        // Option 2: Place the current book on a new shelf
        int newShelf = currShelfHeight + findMinHeight(bookIndex + 1, books, madeShelfWidth - books[bookIndex][0], books[bookIndex][1], dp);

        // Memoize and return the minimum of both options
        dp[bookIndex][currShelfWidth] = Math.min(sameShelf, newShelf);
        return dp[bookIndex][currShelfWidth];
    }

    // Main function to calculate the minimum height of the bookshelf
    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalBooks = books.length;
        madeShelfWidth = shelfWidth;
        int[][] dp = new int[totalBooks][shelfWidth + 1];
        return findMinHeight(0, books, shelfWidth, 0, dp);
    }
}
