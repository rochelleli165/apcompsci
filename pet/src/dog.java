public class dog extends pet{
    private String breed;
    public dog(String n, String b){
        super(n, "ruff");
        breed = b;
    }
    public String getBreed() {
        return breed;
    }
    public String toString(){
        return getName() + getSound() + breed;
    }
}

