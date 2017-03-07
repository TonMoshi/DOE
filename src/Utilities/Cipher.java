/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.BBDD.Query;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Cipher {

    private String ciphrable;

    public Cipher(String ciphrable) throws UnsupportedEncodingException {

        try {

            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(ciphrable.getBytes("UTF-8"));
            byte[] digest = md.digest();

            StringBuffer hexString = new StringBuffer();  

            for (int i = 0; i < digest.length; i++) {
                if ((0xff & digest[i]) < 0x10) {
                    hexString.append("0"
                            + Integer.toHexString((0xFF & digest[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & digest[i]));
                }
            }
            this.ciphrable = new String(hexString);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (UnsupportedEncodingException ex) {
        //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    @Override
    public String toString() {

        return ciphrable;
    }
}
