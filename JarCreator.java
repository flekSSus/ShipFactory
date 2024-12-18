import java.util.jar.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;

class JarCreator
{

    private String _MAIN_CLASS;
    private ArrayList<String> classes;
    private String jarName;

    JarCreator()
    {
        classes=new ArrayList<String>();
        _MAIN_CLASS=" ";    
    }
    JarCreator(String main_class_str)
    {
        _MAIN_CLASS=main_class_str;
    }

    public void Set_MainClass(String mainclass)
    {
        _MAIN_CLASS=mainclass;
    }

    public void Set_Classes(ArrayList<String> arr)
    {
        for(int i=0;i<arr.size();++i)
        {
            classes.add(arr.get(i));
        }
    }
    public void Set_JarName(String jarname)
    {
        jarName=jarname;
    }

    private Manifest CreateManifest()
    {
        Manifest manif=new Manifest(); 
        manif.getMainAttributes().put(Attributes.Name.MAIN_CLASS,_MAIN_CLASS.trim());
        manif.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION,"1.0");
        return manif;
    }

    private void AddFile(File file, JarOutputStream jarOut) throws IOException
    {
        String filePath=file.getPath().replace("\\","/");
        var entry=new JarEntry(filePath);
        jarOut.putNextEntry(entry);
        try(var bi=new BufferedInputStream(new FileInputStream(file)))
        {
            byte[] buffer=new byte[1024];    
            while(true)
            {
                int count=bi.read(buffer);
                if(count==-1)
                    break;
                jarOut.write(buffer,0,count);
            }
            jarOut.closeEntry();
        }

    }

    public void CreateJar()
    {
        try(JarOutputStream jos=new JarOutputStream(new FileOutputStream(jarName)))
        {
            Manifest manif=CreateManifest();

            jos.putNextEntry(new JarEntry("MANIFEST.MF"));
            manif.write(jos);
            for(int i=0;i<classes.size();++i)
            {
                AddFile(new File(classes.get(i)),jos);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
    }






}
