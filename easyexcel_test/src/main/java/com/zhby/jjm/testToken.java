package test;

import com.epoint.gm.SM4CryptoUtil;
import com.epoint.token.TokenAuthUtil;

public class testToken
{

    public static void main(String[] args) {
        
        String appKey="test";
        String appsecrets="test123";
        long timeout =30L;//秒
        String token = TokenAuthUtil.createToken(appKey, appsecrets, timeout);
        System.out.println("token:"+token);
        
        boolean flag = TokenAuthUtil.validateToken(token, appKey, appsecrets);
        System.out.println("flag:"+flag);
        
        String plainText="111";
        String secretKey="1234567812345678";//必须是十六位
        String cipherText = SM4CryptoUtil.encrypt_Ecb_Padding(secretKey, plainText);
        System.out.println("密文: " + cipherText);

        String plainText2 = SM4CryptoUtil.decrypt_Ecb_Padding(secretKey, cipherText);
        System.out.println("明文: " + plainText2);
        System.out.println("");
        
    }

}
