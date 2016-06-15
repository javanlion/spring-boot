package controller;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
public class CryptoController {

    private static final String privateKey = "01$emUlaTor)*78";

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/encrypt")
    public String encrypt(Map<String, Object> model,
                          @RequestParam Map<String, String> allRequestParams)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        String encryptedKey = allRequestParams.get("decryptedValue");
        if (encryptedKey != null) {
            SecretKey secretKey = new SecretKeySpec(privateKey.getBytes(UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] bytes = Base64.encodeBase64(cipher.doFinal(encryptedKey.getBytes(UTF_8)));

            model.put("encryptedValue", new String(bytes));
        }

        return "encrypt";
    }

    @RequestMapping("/decrypt")
    public String decrypt(Map<String, Object> model,
                              @RequestParam Map<String, String> allRequestParams)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        String encryptedKey = allRequestParams.get("encryptedValue");
        if (encryptedKey != null) {
            SecretKey secretKey = new SecretKeySpec(privateKey.getBytes(UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] bytes = Base64.decodeBase64(cipher.doFinal(encryptedKey.getBytes(UTF_8)));

            model.put("decryptedValue", new String(bytes));
        }

        return "decrypt";
    }
}
