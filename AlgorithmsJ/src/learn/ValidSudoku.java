package algo;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        String[][] board={{"5","3",".",".","7",".",".",".","."}
                         ,{"6",".",".","1","9","5",".",".","."}
                         ,{".","9","8",".",".",".",".","6","."}
                         ,{"8",".",".",".","6",".",".",".","3"}
                         ,{"4",".",".","8",".","3",".",".","1"}
                         ,{"7",".",".",".","2",".",".",".","6"}
                         ,{".","6",".",".",".",".","2","8","."}
                         ,{"3",".",".","4","1","9",".",".","5"}
                         ,{".",".",".",".","8",".",".","7","9"}};

        System.out.println(validateSudoku(board));
    }

    private static boolean validateSudoku(String[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[][] box = new HashSet[3][3];
        /** initialize the arrays to empty array sets */
        init(rows); init(cols); init(box);

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                /** empty position */
                if(board[row][col].equals(".")) continue;
                String number = board[row][col];
                /** check duplicates in the row */
                if(rows[row].contains(number)) return false;
                /** check duplicates in the col */
                if(cols[col].contains(number)) return false;
                /** validate the boxes */
                int boxX = row/3; int boxY = col/3;
                if(box[boxX][boxY].contains(number)) return false;
                /** all the conditions are not violated, add the element to the sets */
                rows[row].add(number);
                cols[col].add(number);
                box[boxX][boxY].add(number);
            }
        }
        return true;
    }

    public static void init(Set[] arr){
        for(int i=0;i<arr.length;i++) arr[i]=new HashSet();
    }

    public static void init(Set[][] arr){
        for(int i=0;i<arr.length;i++) init(arr[i]);
    }
}
