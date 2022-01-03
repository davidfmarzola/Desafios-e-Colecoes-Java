import java.util.*;

class InfixaParaPosfixa {
    public static void main(String[] args) {
        int numCasos = MyIO.readInt(), j = 0;
        String expressao = "";
        char auxiliar;
        String stringFromCharArray = "";

        while (j++ < numCasos) {
            expressao = MyIO.readLine();
            expressao = expressao.replace("(", "");
            expressao = expressao.replace(")", "");
            char[] charArray = expressao.toCharArray();
            for (int i = 0; i < charArray.length - 1; i++) {
                if (charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '*' ||
                        charArray[i] == '/' || charArray[i] == '^') {
                    // swap
                    auxiliar = charArray[i];
                    charArray[i] = charArray[i + 1];
                    charArray[i + 1] = auxiliar;
                    i++;
                }
                stringFromCharArray = new String(charArray);
            }
            System.out.println(stringFromCharArray);
        }
    }
}
