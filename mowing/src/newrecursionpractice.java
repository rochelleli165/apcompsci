public class newrecursionpractice {
    public static void main(String[] args){
        System.out.println(bunnyears(2));
        int[] a = {-5, -2, 11};
        System.out.println(array11(a, 0));
        System.out.println("The maximum output is " + maxproduct(a, 0 , false));
    }
    public static int bunnyears(int a){
        if(a == 0){
            return 0;
        }
        else{
            return 2 + bunnyears(a-1);
        }
    }
    public static int array11(int[] a, int b){
        if(b == a.length-1){
            if(a[b] != 11) {
                return 0;
            }
            else{
                return 1;
            }
        }
        else if (a[b] == 11){
            return 1+array11(a, b+1);
        }
        else {
            return array11(a, b+1);
        }
    }
    public static int maxproduct(int[] nums, int b, boolean negative){
        int negatives = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] <  0){
                negatives++;
            }
        }
        if(negatives % 2 == 0){
            int a = nums[b];
            if(a == 0){
                a = 1;
            }
            if(b == nums.length-1){
                return nums[b];
            }
            else {
                return a * maxproduct(nums, b + 1, false);
            }
        }
        else{
            int a = nums[b];
            if(!negative) {
                int smallest = Integer.MIN_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] < 0 && nums[i] > smallest) {
                        smallest = nums[i];
                    }
                }
                if (a == smallest) {
                    a = 1;
                }
                negative = true;
            }
            if(b == nums.length-1){
                return nums[b];
            }
            else {
                return a * maxproduct(nums, b + 1, false);
            }

        }

    }

}
