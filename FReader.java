import java.util.Scanner;
import java.io.*;
import java.lang.NumberFormatException;

class FReader
{

    private String _filePath;

    FReader()
    {
        _filePath=" ";        
    }

    FReader(String filePath)
    {
        _filePath=filePath;   
    }

    public void ReadFile(List list)
    {
        try(BufferedReader bReadF=new BufferedReader(new FileReader(_filePath)))
        {
            VehicleBuilder builder= new ShipBuilder(); 
                
            Integer size=Integer.parseInt(bReadF.readLine());
            String tmpStr;
            String[] fields;
            for(int i=0;i<size.intValue();++i)
            {
                tmpStr=bReadF.readLine();      
                fields= tmpStr.split(" ");
                Integer crew_size;
                try
                {
                    crew_size=Integer.parseInt(fields[4]);
                    builder.setCrewSize(crew_size);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input");
                    crew_size=0;
                }

                Double max_speed;
                try
                {
                    max_speed=Double.parseDouble(fields[3]);
                    builder.setMaxSpeed(max_speed);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input");
                    max_speed=Double.valueOf(0);
                }

                builder.setId(fields[0]);
                builder.setName(fields[1]);
                builder.setType(fields[2]);
                Vehicle ship= builder.getVehicle();

                list.add(ship);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);    
        }        
    }
    public void ReadConsole(List list,Scanner scanner)
    {
        try
        {
            VehicleBuilder builder= new ShipBuilder(); 
            
            System.out.print("Enter the number of instanses: ");
            Integer size=Integer.parseInt(scanner.nextLine());

            System.out.println("Enter ship characteristics:");

            String tmpStr;
            for(int i=0;i<size.intValue();++i)
            {
                System.out.print("Enter ship ID: ");
                tmpStr=scanner.nextLine();      
                builder.setId(tmpStr);    

                System.out.print("Enter ship Name: ");
                tmpStr=scanner.nextLine();      
                builder.setName(tmpStr);    

                System.out.print("Enter ship Type: ");
                tmpStr=scanner.nextLine();      
                builder.setType(tmpStr);    

                System.out.print("Enter ship Crew Size: ");
                tmpStr=scanner.nextLine();      
                Integer crew_size;
                try
                {
                    crew_size=Integer.parseInt(tmpStr);
                    builder.setCrewSize(crew_size);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input");
                    crew_size=0;
                }

                System.out.print("Enter ship Max Speed: ");
                tmpStr=scanner.nextLine();      
                Double max_speed;
                try
                {
                    max_speed=Double.parseDouble(tmpStr);
                    builder.setMaxSpeed(max_speed);    
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Incorrect input");
                    max_speed=Double.valueOf(0);
                }

                Vehicle ship= builder.getVehicle();
                list.add(ship);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
 
    }

}







