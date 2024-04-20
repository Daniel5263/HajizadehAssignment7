public class DirectedOrUndirected {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        System.out.println("Is the matrix a directed graph? " + DirectedGraph(matrix));
    }
    public static boolean DirectedGraph(int[][] matrix) {
        int n = matrix.length;

        if (n != matrix[0].length) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
