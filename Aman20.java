import java.util.ArrayList;

public class Aman20 {

    public static void main(String[] args) {
        ArrayList<String> str = GetMazePath(0, 0, 2, 2);

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
    }

    public static ArrayList<String> GetMazePath(int srcRow, int srcCol, int destRow, int destCol) {
        if (srcCol == destCol && srcRow == destRow) {
            ArrayList<String> str = new ArrayList<>();
            str.add("");
            return str;
        }

        ArrayList<String> allPaths = new ArrayList<String>();

        for (int i = 1; i <= destRow - srcRow; i++) {
            ArrayList<String> hPaths = GetMazePath(srcRow + i, srcCol, destRow, destCol);
            for (int j = 0; j < hPaths.size(); j++) {
                allPaths.add("h" + i + hPaths.get(j));
            }
        }

        for (int i = 1; i <= destCol - srcCol; i++) {
            ArrayList<String> hPaths = GetMazePath(srcRow, srcCol + i, destRow, destCol);
            for (int j = 0; j < hPaths.size(); j++) {
                allPaths.add("v" + i + hPaths.get(j));
            }
        }

        return allPaths;
    }
}

// 00 01 02

// 10 11 12

// 20 21 22