import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import org.w3c.dom.*;


public class XML_Writer
{
    
    String filePath;

    XML_Writer()
    {
        filePath=" ";
    }
    XML_Writer(String _filePath)
    {
        filePath=_filePath;
    }

    public void WriteXML(List ships)
    {

        try(BufferedWriter bWr= new BufferedWriter(new FileWriter(filePath)))
        {

            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder=factory.newDocumentBuilder();
            Document doc=dbuilder.newDocument();

            Element rootEl=doc.createElement("ships");
            doc.appendChild(rootEl);
            
            for(int i=0;i<ships.size();++i)
            {
                Element shipEl=doc.createElement("ship");
                Element idEl=doc.createElement("id");
                Element nameEl=doc.createElement("name");
                Element typeEl=doc.createElement("type");
                Element max_speedEl=doc.createElement("max_speed");
                Element crew_sizeEl=doc.createElement("crew_size");

                rootEl.appendChild(shipEl);

                shipEl.appendChild(idEl);
                idEl.appendChild(doc.createTextNode(ships.get(i).Get_Id()));

                shipEl.appendChild(nameEl);
                nameEl.appendChild(doc.createTextNode(ships.get(i).Get_Name()));

                shipEl.appendChild(typeEl);
                typeEl.appendChild(doc.createTextNode(ships.get(i).Get_Type()));

                shipEl.appendChild(max_speedEl);
                max_speedEl.appendChild(doc.createTextNode(Double.toString(ships.get(i).Get_Speed())));
                
                shipEl.appendChild(crew_sizeEl);
                crew_sizeEl.appendChild(doc.createTextNode(Integer.toString(ships.get(i).Get_Crew_Size())));
                
                TransformerFactory trFactory=TransformerFactory.newInstance();
                Transformer tr=trFactory.newTransformer();

                DOMSource dsource=new DOMSource(doc);

                StreamResult result=new StreamResult(new File(filePath));

                tr.transform(dsource, result);                    


            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }





}
