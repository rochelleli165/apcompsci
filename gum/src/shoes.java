public class shoes {
    public static void main(String[] args){
        shoe abhita = new shoe("Nike", 8, "orange");
        shoe mahir = new shoe();

        System.out.println(abhita.getColor());
        System.out.println(mahir.getBrand());

        mahir.setColor("purple");
        System.out.println(mahir.getColor());
    }

}
