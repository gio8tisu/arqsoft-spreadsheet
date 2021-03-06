package edu.upc.etsetb.arqsoft.miniexceljc.util;

public class AlphabeticRadixConverter {

    public static String toAlphabeticRadix(int num){
        if (num == 0)
            return "A";
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append((char) (num % 26 + 0x41));
            num = num / 26;
        }
        return builder.reverse().toString();
    }

    public static int fromAlphabeticRadix(String a){
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            res = res * 26 + (int) a.charAt(i) - 0x41;
        }
        return res;
    }
}
