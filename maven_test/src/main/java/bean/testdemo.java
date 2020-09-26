package bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class testdemo {
    public static final String KEY_MD5 = "MD5";
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password="123456";
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(password.getBytes());
        password= md5.digest().toString();
        System.out.println(password);
    }
}
