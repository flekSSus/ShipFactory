import java.io.*;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;


class Decryptor
{

    String algorithmStr="AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public void Decrypt(String filePath,SecretKey skey)throws Exception
    {
        Cipher c=Cipher.getInstance(TRANSFORMATION);
        c.init(Cipher.DECRYPT_MODE,skey);

        File encFile=new File(filePath);
        File decrFile=new File(encFile.getAbsolutePath().replace(".enc", ""));

        try (FileInputStream fis=new FileInputStream(encFile);FileOutputStream fos=new FileOutputStream(decrFile)) 
        {
            byte[] inBytes=new byte[(int)encFile.length()];
            fis.read(inBytes);
            byte[] outBytes=c.doFinal(inBytes);
            fos.write(outBytes);
        }        
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    
}
