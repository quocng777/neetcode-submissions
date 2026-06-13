class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validateDuplication(board, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateDuplication(char[][] board, int param) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> squareSet = new HashSet<>();
        char rowValue;
        char colValue;
        char squareValue;
        for (int i = 0; i < 9; i++) {
            rowValue = board[param][i];
            colValue = board[i][param];
            squareValue = board[(param / 3) * 3 + i / 3][(i % 3) + 3 * (param % 3)];
            if (
                checkDuplication(rowSet, rowValue)
                || checkDuplication(colSet, colValue)
                || checkDuplication(squareSet, squareValue)
            ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkDuplication(Set<Character> set, char value) {
         if (value != '.') {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }
}
