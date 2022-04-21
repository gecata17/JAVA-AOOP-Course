package com.jetbrains;

public class RouteCipherTest {
    public static void main(String[] args) {
        //representation of the class Route cipher

        // example of encrypting for negative key
        RouteCipher encryptTextNegativeKey = new RouteCipher(-5);
        System.out.print("With key: " + encryptTextNegativeKey.toString() + " ");
        String encryptedTextNegative = encryptTextNegativeKey.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED");
        System.out.println(encryptedTextNegative);
        System.out.println();

        // example of encrypting for positive key
        RouteCipher encryptTextPositiveKey = new RouteCipher(5);
        System.out.print("With key: " + encryptTextPositiveKey.toString() + " ");
        String encryptedTextPositive = encryptTextPositiveKey.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED");
        System.out.println(encryptedTextPositive);
        System.out.println();

        // example of decrypting for negative key
        RouteCipher decryptNegativeKey = new RouteCipher(-4);
        System.out.print("With key: " + decryptNegativeKey.toString() + " ");
        String decryptedTextNegative = decryptNegativeKey.decrypt("XEAHSIHTIEIXTXTLTSPN");
        System.out.println(decryptedTextNegative);
        System.out.println();

        // example of decrypting for positive key
        RouteCipher decryptPositiveKey = new RouteCipher(4);
        System.out.print("With key: " + decryptPositiveKey.toString() + " ");
        String decryptedTextPositive = decryptPositiveKey.decrypt("TIEIXTXXEAHSIHSPNTLT");
        System.out.println(decryptedTextPositive);
        System.out.println();
    }
}
