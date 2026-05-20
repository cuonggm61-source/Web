public class Binary{

    public static String toBinary(int n)
    {
        if (n == 0) {
            return "";
        }
        int remainder = n % 2;
        String higherBits = toBinary(n / 2);
        return higherBits + remainder;
    }

    public static void main(String[] args)
    {
        int n =  6;

        System.out.println("So "+ n+" co dang nhi phan la: "+toBinary(n));
    }
}