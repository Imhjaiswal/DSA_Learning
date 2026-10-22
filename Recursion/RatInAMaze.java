package Recursion;
import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    List<String> findpath (int maze[][], int m, int n) {
        List<String> list = new ArrayList<>();
        boolean visited[][] = new boolean[m][n];

        if (m == 0 || n == 0) return list;

        if (maze[0][0] == 1 && maze[m-1][n-1] == 1) solve(0, 0, maze, m, n, list, "", visited);

        return list;
    }

    void solve (int row, int col, int maze[][], int m, int n, List<String> ans, String path, boolean visited[][]) {
        if (row == m-1 && col == n-1) {
            ans.add(path);
            return;
        }
        // MARK AS VISITED
        visited[row][col] = true;

        // DOWN
        if ((row+1 < m) && (maze[row+1][col] == 1) && !visited[row+1][col]) {
            solve(row+1, col, maze, m, n, ans, path+"D", visited);
        }
        // LEFT
        if ((col-1 >= 0) && maze[row][col-1] == 1 && !visited[row][col-1]) {
            solve(row, col-1, maze, m, n, ans, path+"L", visited);
        }
        // RIGHT
        if ((col+1 < n) && maze[row][col+1] == 1 && !visited[row][col+1]) {
            solve(row, col+1, maze, m, n, ans, path+"R", visited);
        }
        // UP
        if ((row-1 >= 0) && (maze[row-1][col] == 1) && !visited[row-1][col]) {
            solve(row-1, col, maze, m, n, ans, path+"U", visited);
        }

        // BACKTRACK
        visited[row][col] = false;
    }
}
