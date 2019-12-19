package demo.字符串去重;

public class NonRepeatString {

    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {

            char charWord = str.charAt(i);

            int firstPosition = str.indexOf(charWord);

            int lastPosition = str.lastIndexOf(charWord);

            if (firstPosition == lastPosition || firstPosition == i) {

                sb.append(charWord);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NonRepeatString nonRepeatString = new NonRepeatString();
        System.out.println(nonRepeatString.removeRepeatChar("asdasfdasd"));
    }
}
