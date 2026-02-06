import java.util.ArrayList;

public class Aman84 {

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
        ArrayList<String> hPaths = new ArrayList<String>();
        ArrayList<String> vPaths = new ArrayList<String>();
        ArrayList<String> dPaths = new ArrayList<String>();
        ArrayList<String> allPaths = new ArrayList<String>();
        if (srcCol < destCol) {
            hPaths = GetMazePath(srcRow, srcCol + 1, destRow, destCol);
        }

        if (srcRow < destRow) {
            vPaths = GetMazePath(srcRow + 1, srcCol, destRow, destCol);
        }
        if (srcRow < destRow && srcCol < destCol) {
            dPaths = GetMazePath(srcRow + 1, srcCol + 1, destRow, destCol);
        }
        for (int i = 0; i < hPaths.size(); i++) {
            allPaths.add("h" + hPaths.get(i));
        }
        for (int i = 0; i < vPaths.size(); i++) {
            allPaths.add("v" + vPaths.get(i));
        }
        for (int i = 0; i < dPaths.size(); i++) {
            allPaths.add("d" + dPaths.get(i));
        }

        return allPaths;
    }
}

// 00 01 02

// 10 11 12

// 20 21 22