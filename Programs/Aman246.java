public class Aman246 {
    // https://youtu.be/XtmW3a8Q9M4?list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY
    public static void main(String[] args) {
        int score[] = new int[] { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        String[] words = new String[] { "dog", "cat", "dad", "good" };
        int feq[] = new int[] { 1, 1, 1, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(MaxScore(score, words, 0, feq));
    }

    public static int MaxScore(int Score[], String words[], int indx, int freq[]) {

        if (indx == words.length) {
            return 0;
        }

        int scoreNo = MaxScore(Score, words, indx + 1, freq);

        int score = 0;
        boolean canContribute = true;
        for (int i = 0; i < words[indx].length(); i++) {
            char ch = words[indx].charAt(i);
            int indexOfChar = ch - 'a';
            if (freq[indexOfChar] > 0) {
                score = score + Score[indexOfChar];
            } else {
                canContribute = false;
            }
            freq[indexOfChar]--;

        }
        int scoreYes = 0;

        if (canContribute) {

            scoreYes = score + MaxScore(Score, words, indx + 1, freq);

        }
        for (int i = 0; i < words[indx].length(); i++) { // reset frequecny if not using word
            char ch = words[indx].charAt(i);
            int indexOfChar = ch - 'a';
            freq[indexOfChar]++;

        }

        return Math.max(scoreNo, scoreYes);
    }

}
