public class PlaySpace {

    public static void main (String[] args) {

        System.out.print(puzzle(22,11));

    }

        public static int puzzle(int i, int j) {
            if (i == j) {
                return 0;
            } else {
                return 1 + puzzle(i - 2, j - 1);
            }
        }
}

