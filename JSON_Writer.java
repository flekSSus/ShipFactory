import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class JSON_Writer
{
    String filePath;

    JSON_Writer()
    {
        filePath=" ";
    }
    JSON_Writer(String _filePath)
    {
        filePath=_filePath;
    }

    public void WriteJSON(List ships)
    {
        try
        {
            ObjectMapper objM=new ObjectMapper();

            for(int i=0;i<ships.size();++i)
            {
                objM.writeValue(new File(filePath),ships.get(i));
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }


   
}
