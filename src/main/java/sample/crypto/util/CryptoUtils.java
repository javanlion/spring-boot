/**
 * @author Dzhavanshir Ielchiev
 * Date: 6/16/2016
 * Time: 4:22 PM
 */

package sample.crypto.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CryptoUtils {
    private static final String defaultKey = "01$emUlaTor)*78";
    private static final String algorithm = "Blowfish";

    public static String encryptData(String data, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(UTF_8), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] base64 = Base64.encodeBase64(cipher.doFinal(data.getBytes(UTF_8)));
        return new String(base64);
    }

    public static String encryptData(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return encryptData(data, defaultKey);
    }

    public static String decryptData(String data, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(UTF_8), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(data.getBytes(UTF_8)));
        return new String(bytes);
    }

    public static String decryptData(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return decryptData(data, defaultKey);
    }

}
