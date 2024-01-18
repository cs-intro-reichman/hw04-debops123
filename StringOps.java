public class StringOps {
	public static void main(String[] args) {
	
	}
	
	private static char characterToLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }

    private static char characterToUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char)(c - 32);
        }
        return c;
    }

    private static boolean characterIsVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static String capVowelsLowRest (String string) {
        String result = "";

        for (int i = 0; i < string.length(); ++i) {
            if (characterIsVowel(string.charAt(i))) {
                result += characterToUpperCase(string.charAt(i));
            } else {
                result += characterToLowerCase(string.charAt(i));
            }
        }
        return result;
    }

    public static String camelCase (String string) {
        String result = "";

        for (int i = 0; i < string.length(); ++i) {
            while (string.charAt(i) == ' ') {
                ++i;
            }

            // we found first character already, make first character
            // of new word uppercase
            if (result != "" && string.charAt(i - 1) == ' ') {
                result += characterToUpperCase(string.charAt(i));
            } else {
                result += characterToLowerCase(string.charAt(i));
            }
        }
        return result;
    }
    public static int[] allIndexOf (String string, char chr) {
        int indexOfCharacter = -1;
        int indexesFound = 0;

        do {
            indexOfCharacter = string.indexOf(chr, indexOfCharacter + 1);
            if (indexOfCharacter != -1) {
                indexesFound++;
            }
        } while (indexOfCharacter != -1);


        int[] result = new int[indexesFound];
        int indexIndex = 0;

        do {
            indexOfCharacter = string.indexOf(chr, indexOfCharacter + 1);
            if (indexOfCharacter != -1) {
                result[indexIndex++] = indexOfCharacter;
            }
        } while (indexOfCharacter != -1); 

        return result;
    }
}
