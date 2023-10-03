public class guineapig {
  public static void main(String[] args) {
    String itemRepresentation = " apple : ";
    String[] parts = itemRepresentation.trim().split(":"); // parses itemRepresentation
    System.out.println(parts.length);
    String description = parts[0].trim();
    String expirationDate = parts[1].trim();
    System.out.println("description: " + description);
    System.out.println("expirationDate: " + expirationDate);

    // int testIntDate = Integer.parseInt(expirationDate.trim());
  }
}
