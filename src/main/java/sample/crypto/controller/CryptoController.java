package sample.crypto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

import static sample.crypto.util.CryptoUtils.decryptData;
import static sample.crypto.util.CryptoUtils.encryptData;

@Controller
public class CryptoController {

    @Value("${application.message:Hello World}")//default value is [Hello World]
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/encrypt")
    public String encrypt(Map<String, Object> model,
                          @RequestParam Map<String, String> allRequestParams) throws Exception {

        String decryptedValue = allRequestParams.get("decryptedValue");
        if (decryptedValue != null) {
            model.put("encryptedValue", encryptData(decryptedValue));
            model.put("decryptedValue", decryptedValue);
        }

        return "encrypt";
    }

    @RequestMapping("/decrypt")
    public String decrypt(Map<String, Object> model,
                          @RequestParam Map<String, String> allRequestParams) throws Exception {

        String encryptedValue = allRequestParams.get("encryptedValue");
        if (encryptedValue != null) {
            model.put("decryptedValue", decryptData(encryptedValue));
            model.put("encryptedValue", encryptedValue);
        }

        return "decrypt";
    }
}
