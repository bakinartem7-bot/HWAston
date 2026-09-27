public class Main {
    public static void main(String[] args) {
        Integer a = Integer.valueOf("127");
        int b = Integer.parseInt("127");
        Integer c = b;
        System.out.println(a == c);

        Integer x = Integer.valueOf("128");
        int y = Integer.parseInt("128");
        Integer z = y;
        System.out.println(x == z);
    }
}