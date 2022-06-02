package algo;

public class PalindromeDetector {
    public static void main(String[] args) {
        String msg = "A man, a plan, a canal: Panama";
        StringBuilder builder = new StringBuilder();
        for(int ch : msg.toCharArray()){
            if(!Character.isAlphabetic(ch) || !Character.isDigit(ch)) continue;
            ch = Character.toLowerCase(ch);
            builder.append((char)ch);
        }
        System.out.println(isPalindrome(builder.toString()));
    }

    private static boolean isPalindrome(String str) {
        int leftPtr,rightPtr;
        leftPtr=0;
        rightPtr=str.length()-1;
        char[] arr = str.toCharArray();
        while(leftPtr<=rightPtr){
            char leftChar = arr[leftPtr];
            char rightChar = arr[rightPtr];
            System.out.println("leftChar = "+leftChar+", rightChar = " + rightChar);
            if(leftChar == rightChar) { leftPtr++; rightPtr--; }
            else return false;
        }
        return true;
    }
}
