public class ShortestDistance {
    public static int shortestXYDist(char[][] grid, int N,
                                     int M)
    {
        // Create a 2D array to store distances.
        // Initialize with a large value.
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            // Initialize with a large value (indicating
            // infinity).
            Arrays.fill(dist[i], 1_000_000_000);
        }

        // Check top and left directions for 'X' cells.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'X') {
                    // Set distance to 0 for 'X' cells.
                    dist[i][j] = 0;
                }
                else {
                    if (i > 0) {
                        // Check above cell.
                        dist[i][j] = Math.min(
                            dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        // Check left cell.
                        dist[i][j] = Math.min(
                            dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        // Check bottom and right directions for 'X' cells.
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (grid[i][j] == 'X') {
                    // Set distance to 0 for 'X' cells.
                    dist[i][j] = 0;
                }
                else {
                    if (i < N - 1) {
                        // Check below cell.
                        dist[i][j] = Math.min(
                            dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j < M - 1) {
                        // Check right cell.
                        dist[i][j] = Math.min(
                            dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
        }

        // Initialize the minimum distance with a large
        // value.
        int ans = 1_000_000_000;

        // Find the minimum distance to 'Y' cells.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'Y') {
                    // Update the minimum distance.
                    ans = Math.min(ans, dist[i][j]);
                }
            }
        }

        // Return the minimum distance.
        return ans;
    }

    // Drivers code
    public static void main(String[] args)
    {
        int N = 4;
        int M = 4;
        char[][] grid = { { 'X', 'O', 'O', 'O' },
                          { 'O', 'Y', 'O', 'Y' },
                          { 'X', 'X', 'O', 'O' },
                          { 'O', 'Y', 'O', 'O' } };

        int minDistance = shortestXYDist(grid, N, M);

        // Function call
        System.out.println(
            "Minimum distance from 'X' to 'Y': "
            + minDistance);
    }
}
