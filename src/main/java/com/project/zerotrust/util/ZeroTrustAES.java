package com.project.zerotrust.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ZeroTrustAES {

    private static final String SECRET_KEY = "Your16CharSecret";

    public static String encrypt(String strToEncrypt) throws Exception{
        SecretKeySpec secretkey = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretkey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
    }

    public static String decrypt(String strToDecrypt) throws Exception{
        SecretKeySpec secretkey = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretkey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
}
