public class main {
    public static void main(String[] args) {
        dog Romeo = new dog("Romeo", "Samoyed");
        cat Juliet = new cat("Juliet", 4);

        pet[] array = new pet[2];
        array[0] = Romeo;
        array[1] = Juliet;

        System.out.println(Juliet.getName());
        System.out.println(Juliet.getSound());
        Juliet.reduceLives();
        System.out.println(Juliet);

        System.out.println(Romeo.getName());
        System.out.println(Romeo.getSound());
        System.out.println(Romeo.getBreed());
        System.out.println(Romeo);

        System.out.println(array[0].getName());
        System.out.println(array[1].getName());
        System.out.println(array[0].getSound());
        System.out.println(array[1].getSound());
        System.out.println(array[0]);
        System.out.println(array[1]);

        //the other ones don't work because it either didn't get overwritten or it's not in the pet file

    }
}

