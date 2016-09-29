/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md5cal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lizzi
 */
public class MD5 {

    public MD5(String str, String result) {
        this.str = str;
        this.result = result;
    }

    private String str;
    private String result;

    public String getResult() throws NoSuchAlgorithmException {
        if (this.str.equals("")){
            return this.result = "请输入数据!";
        }
        else{
        byte[] res = this.str.getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5".toUpperCase());
        byte[] result = md.digest(res);
        for (int i = 0; i < result.length; i++) {
            md.update(result[i]);
        }
        byte[] hash = md.digest();
        StringBuffer d = new StringBuffer("");
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
            if (v < 16) {
                d.append("0");
            }
            d.append(Integer.toString(v, 16).toUpperCase());
        }
        return this.result = d.toString();
    }
    }

    public void setStr(String res) {
        this.str = res;
    }

    MD5() {
        result = null;
        str = null;
    }

}

