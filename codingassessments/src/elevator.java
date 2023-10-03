public class elevator {
    public static void main(String[] args){
        int[] weights = {40, 40, 100, 80, 20};
        int[] floors = {3, 3, 2, 2, 3};
        int weight_limit = 200;
        System.out.println(solution(weights, floors, weight_limit));

    }
    public static int solution(int[] weights, int[] floors, int weight_limit){
        int time = 0;
        int weight = 0;
        int maxFloor = 0;
        for(int i = 0; i < weights.length; i++){
            if(weight + weights[i] > weight_limit){
                time += (maxFloor-1) * 2;
                weight = 0;
                maxFloor = 0;
            }
            weight = weight + weights[i];
            if(floors[i] > maxFloor){
                maxFloor = floors[i];
            }
        }
        time += (maxFloor-1)*2;

        return time;
    }
}
