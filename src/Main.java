public class Main {
    public static void main(String[] args){
        parenthesesCheck("()()()()()()(((((()");
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int rightCount = 0;
        int leftCount = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                leftCount++;
            }
            if (str.charAt(i) == ')') {
                rightCount++;
            }
            if (rightCount > leftCount){
                return false;
            }
        }

        return (leftCount == rightCount);
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String str = Integer.toString(num);
        String totalString = "";
        for (int i = 0; i < str.length(); i++){
            totalString = totalString + str.charAt(str.length()-1-i);
        }
        return totalString;
    }


    // 3. encryptThis
    public static String encryptThis(String str){
        String totalString = "";
        int ascii;
        int charNum = 0;
        int lastChar = 0;
        int twoIndex = 0;

        for (int i = 0; i < str.length(); i++){
            charNum++;

            for (int j = i; j < str.length(); j++){
                if (str.charAt(j) == ' '){
                    lastChar = j-1;
                    break;
                }
                if (j == str.length()-1){
                    lastChar = j;
                }
            }

            if (str.charAt(i) == ' '){
                charNum = 0;
            }
            if (charNum == 1){
                ascii = str.charAt(i);
                totalString = totalString + ascii;
            }

            else if (charNum == 2){
                twoIndex = i;
                totalString = totalString + str.charAt(lastChar);
            }

            else if (i == lastChar){
                totalString = totalString + str.charAt(twoIndex);
            }
            else{
                totalString = totalString + str.charAt(i);
            }


        }

        return totalString;


    }



    // 4. decipherThis
    public static String decipherThis(String str){
        String totalString = "";
        String num = "";
        int lastChar = 0;
        int count = 0;
        int twoIndex = 0;

        for (int i = 0; i < str.length(); i++){
            count++;
            if (str.charAt(i) == ' '){
                count = 0;
            }

            for (int j = i; j < str.length(); j++){
                if (str.charAt(j) == ' '){
                    lastChar = j-1;
                    break;
                }
                if (j == str.length()-1){
                    lastChar = j;
                }
            }

            if (Character.isDigit(str.charAt(i))){
                num = "";
                for (int k = i; k < str.length(); k++){
                    if (Character.isDigit(str.charAt(k))){
                        num = num + str.charAt(k);
                    }
                    else{
                        break;
                    }
                }
                int ascii = Integer.parseInt(num);
                totalString = totalString + (char) ascii;
                i+=num.length()-1;
            }

            else if (count == 2){
                twoIndex = i;
                totalString = totalString + str.charAt(lastChar);
            }

            else if (i == lastChar){
                totalString = totalString + str.charAt(twoIndex);
            }

            else{
                totalString = totalString + str.charAt(i);
            }


        }

        return totalString;
    }

}