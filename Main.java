import java.util.Collections;
import java.util.Iterator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main
{
    private static ExcelManager exM= ExcelManager.getInstance();

    public static void main(String [] args) throws Exception
    {

        
        List ships=new List();

        Scanner scanner = new Scanner(System.in);
        int choice=1;

        SecretKey skey=Encryptor.GenerateKey();

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Read from file");
            System.out.println("2. Read from console");
            System.out.println("3. Write in file");
            System.out.println("4. Write in console");
            System.out.println("5. Remove element");
            System.out.println("6. Clear");
            System.out.println("7. Output using iterators");
            System.out.println("8. Sort by name");
            System.out.println("9. Read from XML file");
            System.out.println("10. Write in XML file");
            System.out.println("11. Read from JSON file");
            System.out.println("12. Write in JSON file");
            System.out.println("13. Encrypt file");
            System.out.println("14. Decrypt file");
            System.out.println("15. Archivate in JAR");
            System.out.println("16. Archivate in ZIP");
            System.out.println("17. Export to Excel");
            System.out.println("18. Import from Excel");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); 
                continue; 
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                {
                    String fileName;
                    System.out.print("\nEnter file name: ");
                    fileName=scanner.nextLine();
                    FReader fr=new FReader(fileName); 
                    fr.ReadFile(ships);
                    System.out.println("Success!\n");
                }
                    break;
                case 2:
                {
                    FReader fr= new FReader();   
                    fr.ReadConsole(ships,scanner);
                    System.out.println("Success!\n");
                }
                    break;
                case 3:
                {
                    String fileName;
                    System.out.print("\nEnter file name: ");
                    fileName=scanner.nextLine();
                    FWriter fw= new FWriter(fileName); 
                    fw.WriteFile(ships);
                    System.out.println("Success!\n");
                }
                    break;
                case 4:
                {
                    FWriter fw= new FWriter();   
                    System.out.println("\nShips: ");
                    fw.WriteConsole(ships);
                    System.out.println("Success!\n");
                }
                    break;
                case 5:
                {
                    BufferedReader br2= new BufferedReader(new InputStreamReader(System.in));
                    String id=" ";

                    System.out.print("\nEnter id of element: ");
                    id=br2.readLine();
                    if(ships.containsID(id))
                    {
                        ships.remove(ships.indexOf_ID(id));
                    }
                    else
                    {
                        System.out.println("No such element");
                    }
                }
                    break;
                case 6:
                {
                    ships.clear();
                    System.out.println("Success!\n");
                }
                    break;
                case 7:
                {
                    Iterator<Vehicle> begin= ships.iterator();

                    System.out.println("\nShips: \n");
                    while(begin.hasNext())
                    {
                        System.out.println(begin.next());
                    }
                }
                    break;
                case 8:
                {
                    Collections.sort(ships,(o1,o2)->o1.Get_Name().compareTo(o2.Get_Name()));
                    System.out.println("Success!");
                }
                    break;
                case 9:
                {
                    String filePath;

                    System.out.print("\nEnter xml-file name/path: ");

                    filePath=scanner.nextLine();
                    XML_Reader xml_r=new XML_Reader(filePath);
                    xml_r.ReadXML(ships);

                    System.out.println("Success!");
                }
                    break;
                case 10:
                {
                    String filePath;

                    System.out.println("\nEnter xml-file name/path: ");

                    filePath=scanner.nextLine();
                    XML_Writer xml_w=new XML_Writer(filePath);

                    xml_w.WriteXML(ships);

                    System.out.println("Success!");

                }
                    break;
                case 11:
                {
                    String filePath;

                    System.out.println("\nEnter json-file name/path");

                    filePath=scanner.nextLine();
                    JSON_Reader json_r=new JSON_Reader(filePath);

                    json_r.ReadJSON(ships);

                    System.out.println("Success!");
                }
                    break;
                case 12:
                {
                    String filePath;

                    System.out.println("\nEnter json-file name/path");

                    filePath=scanner.nextLine();
                    JSON_Writer json_w=new JSON_Writer(filePath);

                    json_w.WriteJSON(ships);

                    System.out.println("Success!");

                }
                    break;
                case 13:
                {
                    String filePath;
                    Encryptor encr=new Encryptor();

                    System.out.println("\nEnter file to encrypt");

                    filePath=scanner.nextLine();
                    try
                    {
                        encr.Encrypt(filePath,skey);                    

                        System.out.println("Success!");
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                    break;
                case 14:
                {
                    String filePath;
                    Decryptor decr=new Decryptor();

                    System.out.println("\nEnter file to decrypt(*.enc)");

                    filePath=scanner.nextLine();
                    try
                    {
                        decr.Decrypt(filePath,skey);                    

                        System.out.println("Success!");
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                    break;
                 case 15:
                 {
                    String mainName;
                    ArrayList<String> classes;
                    String classStr;
                    String jarName;

                    System.out.println("Enter JAR-file name");
                    jarName=scanner.nextLine();
                    System.out.println("Enter Main class name");
                    mainName=scanner.nextLine();
                    System.out.println("Enter all classes names(Main.class List.class) in one line");
                    classStr=scanner.nextLine();
                    classes=new ArrayList<String>(Arrays.asList(classStr.split(" ")));
                    
                    var jc=new JarCreator();
                    jc.Set_MainClass(mainName);
                    jc.Set_Classes(classes);
                    jc.Set_JarName(jarName);
                    jc.CreateJar();
                    
                    System.out.println("Success");
                    
                 }
                    break;
                 case 16:
                 {
                    String zipName;
                    ArrayList<String>classes;
                    String classStr;

                    System.out.println("Enter ZIP-file name");
                    zipName=scanner.nextLine();
                    System.out.println("Enter all classes names(Main.class List.class) in one line");
                    classStr=scanner.nextLine();
                    classes=new ArrayList<String>(Arrays.asList(classStr.split(" ")));
                    
                    var zc=new ZipCreator();
                    zc.Set_ZipName(zipName);
                    zc.Set_Classes(classes);
                    zc.CreateZip();

                    System.out.println("Success!");
                    
                 }
                    break;
                 case 17:
                 {
                    exM.toExcel(ships);    
                    System.out.println("Success!");
                 }
                    break;
                 case 18:
                 {
                    List shps= exM.importFromExcel("excel.txt");
                    System.out.println("Success!");

                 }
                 case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);


        scanner.close();

    }
}
