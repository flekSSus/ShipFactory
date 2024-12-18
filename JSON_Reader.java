import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.ArrayList;

class JSON_Reader
{

    String filePath;
    
    JSON_Reader()
    {
        filePath=" ";
    }
    JSON_Reader(String _filePath)
    {
        filePath=_filePath;
    }

    public void ReadJSON(List list)
    {
        try
        {
            ObjectMapper objM=new ObjectMapper();
            CollectionType listType=objM.getTypeFactory().constructCollectionType(ArrayList.class,Ship.class);
            ArrayList<Vehicle> ships=objM.readValue(new File(filePath),listType);

            for(Vehicle i: ships)
            {
                list.add(i);
            }


        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
}
