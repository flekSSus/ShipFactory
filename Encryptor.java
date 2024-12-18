import java.io.*;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;


class Encryptor
{
    
    private static String algorithmName="AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static int keySize=128;

    public static SecretKey GenerateKey()throws Exception
    {
        KeyGenerator keyGen=KeyGenerator.getInstance(algorithmName);

        keyGen.init(keySize,new SecureRandom());
        return keyGen.generateKey();
    }

    public static void Encrypt(String filePath, SecretKey skey)
    {

        File inFile=new File(filePath);
        File encFile=new File(inFile.getAbsolutePath() + ".enc");

        try (FileInputStream fis=new FileInputStream(inFile);FileOutputStream fos=new FileOutputStream(encFile))
        {
            Cipher c=Cipher.getInstance(TRANSFORMATION);
            c.init(Cipher.ENCRYPT_MODE, skey);

        
            byte[] inBytes=new byte[(int) inFile.length()];
            fis.read(inBytes);
            byte[] outBytes = c.doFinal(inBytes);
            fos.write(outBytes);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
}
