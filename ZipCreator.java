import java.util.ArrayList;
import java.util.zip.*;
import java.io.*;

class ZipCreator
{

    String zipName;
    ArrayList<String> files;
    
    ZipCreator()
    {
        zipName=" ";
        files=new ArrayList<String>();
    }

    public void Set_ZipName(String name)
    {
        zipName=name;
    }
    public void Set_Classes(ArrayList<String> arr)
    {
        for(String file:arr)
        {
            files.add(file);
        }
    }

    public void CreateZip()
    {
        try(var zos=new ZipOutputStream(new FileOutputStream(zipName)))
        {
            
            for(String file:files)
            {
                AddFile(new File(file),zos);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    private void AddFile(File file,ZipOutputStream zip)throws IOException
    {
        FileInputStream fis=new FileInputStream(file); 
        var entry=new ZipEntry(file.getName());
        zip.putNextEntry(entry);

        byte[] buffer=new byte[1024];
        while(true)
        {
            int count=fis.read(buffer);
            if(count==-1)
                break;
            zip.write(buffer,0,count);
        }
    }
    
}
