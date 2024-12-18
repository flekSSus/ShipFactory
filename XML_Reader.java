import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

class XML_Reader
{
    
    String xml_name;

    XML_Reader()
    {
        xml_name=" ";
    }
    XML_Reader(String xml)
    {
        xml_name=xml;
    }

    public void ReadXML(List ships)
    {
        try
        {
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            DocumentBuilder builder= factory.newDocumentBuilder(); 
            Document doc= builder.parse(new File(xml_name));
            
            NodeList nodes_list=doc.getElementsByTagName("ship");
            
            for(int i=0;i<nodes_list.getLength();++i)
            {
                Element el=(Element)nodes_list.item(i);
                String id=el.getElementsByTagName("id").item(0).getTextContent();
                String name=el.getElementsByTagName("name").item(0).getTextContent();
                String type=el.getElementsByTagName("type").item(0).getTextContent();
                double max_speed;
                int crew_size;
                try
                {
                    max_speed=Double.parseDouble(el.getElementsByTagName("max_speed").item(0).getTextContent());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input. Default value is 0.0");
                    max_speed=0.0;
                }

                try
                {
                    crew_size=Integer.parseInt(el.getElementsByTagName("crew_size").item(0).getTextContent());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input. Default value is 0");
                    crew_size=0;
                }
                
                ships.add(new Ship(id,name,type,max_speed,crew_size));
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



}
