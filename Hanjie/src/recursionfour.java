public class recursionfour {
    public static void main(String[] args){
        int[] a = {2, 4, 8};
        System.out.println(groupSum(0, a, 10));
        int[] b = {2, 4, 2};
        System.out.println(split53(b));
        int[] c = {2, 5, 3};
        System.out.println(splitArray(c));



    }
    public static boolean groupSum(int start, int[] nums, int target){

            if(start >= nums.length) {
                return target == 0;
            }

            if(groupSum(start+1, nums, target - nums[start]) == true) {
                return true;
            }

            if(groupSum(start+1, nums, target) == true) {
                return true;
            }
            return false;
    }
    public static boolean split53(int[] a){
        int i = 0;
        int fives = 0;
        int threes = 0;
        return helper(a, i, fives, threes);
    }
    public static boolean helper(int[] a, int i, int fives, int threes){
        if(i < a.length){
            if(fives == threes){
                return true;
            }
            return false;
        }
        if(a[i] % 5 == 0){
            return(helper(a, i++, fives + a[i], threes));
        }
        if(a[i] % 3 == 0){
            return(helper(a, i++, fives, threes + a[i]));
        }
        else{
            return helper(a, i++, fives + a[i], threes) || helper(a, i++, fives, threes + a[i]);
        }
    }
    public static boolean splitArray(int[] a){
        int i = 0;
        int x = 0;
        int y = 0;
        return helperarray(a, i, x, y);
    }
    public static boolean helperarray(int[] a, int i, int x, int y){
        if(i >= a.length){
            if(x == y){
                return true;
            }
            else {
                return false;
            }
        }
        if(helperarray(a, i++, x + a[i], y)) {
            return true;
        }

        if(helperarray(a, i++, x, y + a[i])) {
            return true;
        }

        return false;
    }


}
