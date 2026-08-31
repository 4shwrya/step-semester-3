public class ReverseCustomerName {

    static String reverseCustomerName(String name) {

        String reverse = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }

        return reverse;
    }

    public static void main(String[] args) {

        String name = "Sunil";

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}
