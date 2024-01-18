public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String input = "Hello, World!";
        
        System.out.println("Capitalize Vowels, Lowercase Rest: " + capVowelsLowRest(input));
        System.out.println("Camel Case: " + camelCase(input));
        System.out.println("All Indexes of 'o': " + Arrays.toString(allIndexOf(input, 'o')));
    }

    public static String capVowelsLowRest(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (isVowel(currentChar)) {
                result.append(Character.toUpperCase(currentChar));
            } else {
                result.append(Character.toLowerCase(currentChar));
            }
        }

        return result.toString();
    }

    public static String camelCase(String string) {
        StringBuilder result = new StringBuilder();

        boolean capitalizeNext = false;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (Character.isLetter(currentChar)) {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            } else {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    public static int[] allIndexOf(String string, char chr) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                result[index++] = i;
            }
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}