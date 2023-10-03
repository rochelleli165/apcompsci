public class main {
    public static void main(String[] args) {
        apple a = new apple("red", 1, "fuji");

        a.setColor("green");
        a.setWeight(10);
        a.setType("granny smith");

        System.out.println(a.getColor());
        System.out.println(a.getWeight());
        System.out.println(a.getType());

        System.out.println(a);

        fruits b = new fruits("orange", 3);

        b.setColor("yellow");
        b.setWeight(20);

        System.out.println(b.getColor());
        System.out.println(b.getWeight());

        System.out.println(b);
    }
}
