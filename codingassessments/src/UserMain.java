public class UserMain {
    public static void main(String[] args){
        User x = new User("hi", "123xyz");
        ForumUser y = new ForumUser("good", "h");
        System.out.println(x.toString());
        System.out.println(y.toString());
        y.makePost("h", "hi");
        y.makePost("hi", "hi");
        y.toggleBan();
        y.makePost("h", "hi");

        System.out.println(y.toString());

    }
}
