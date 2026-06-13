class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validateDuplication(board, "row", i)) {
                return false;
            }
            if (!validateDuplication(board, "col", i)) {
                return false;
            }
            if (!validateDuplication(board, "square", i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateDuplication(char[][] board, String mode, int param) {
        Set<Character> set = new HashSet();
        char value;
        for (int i = 0; i < 9; i++) {
            if (mode == "row") {
                value = board[param][i];
            } else if (mode == "col") {
                value = board[i][param];
            } else {
                value = board[(param / 3) * 3 + i / 3][(i % 3) + 3 * (param % 3)];
            }

            if (value != '.') {
                if (set.contains(value)) {
                    return false;
                }
                set.add(value);
            }
        }

        return true;
    }
}
