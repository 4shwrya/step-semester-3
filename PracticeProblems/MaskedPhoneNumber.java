public class MaskedPhoneNumber {

    static String maskPhone(String phone) {

        if (phone.length() != 10)
            return "Invalid phone number";

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i)))
                return "Invalid phone number";
        }

        StringBuilder result = new StringBuilder("XXXXXX");

        result.insert(6, "-");
        result.append(phone.substring(6));

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(maskPhone("9876543210"));
        System.out.println(maskPhone("98765"));
    }
}
