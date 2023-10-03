public class bricks {
    public static void main (String[] args) {
        makeBricks (3,1,8);
        makeBricks (3, 1, 9);
        makeBricks (4,2,9);
    }

    public static void makeBricks (int small, int big, int goal) {
        int bigcounter = big;
        int smallcounter = small;
        if (big < 0 || small == goal) {
            System.out.println (true);
        }
        else {
            int answer =0;
            boolean progress = true;
            while (big > 0 && progress) {
                big--;
                answer += 5;
                if (answer == goal ) {
                    progress = false;
                    System.out.println(true);
                }
                while (small > 0 && progress) {
                    answer += 1;
                    small--;
                    if (answer == goal ) {
                        progress = false;
                        System.out.println(true);
                    }
                    if (small == 0 && progress) {
                        answer = answer - (smallcounter);
                    }
                }
            }

            if (progress) {
                System.out.println(false);
            }
        }
    }
}
