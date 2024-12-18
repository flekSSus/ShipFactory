import java.io.*;

class FWriter
{
        
        String filePath_string;
        
        FWriter()
        {
            filePath_string=" ";   
        }
        FWriter(String filePath)
        {
            filePath_string=filePath;
        }

        public void WriteFile(List list)
        {
            try(BufferedWriter bWr= new BufferedWriter(new FileWriter(filePath_string)))
            {
                bWr.write(list.size()+"\n");
                for(int i=0;i<list.size();++i)    
                {
                    Vehicle tmp= list.get(i);
                    bWr.write(tmp.Get_Id()+" "+tmp.Get_Name()+" "+tmp.Get_Type()+" "+tmp.Get_Speed()+" "+tmp.Get_Crew_Size()+"\n");       
                }
            }
            catch(IOException e)
            {
                 System.out.println(e);
            }

        }

        public void WriteConsole(List list)
        {
            System.out.println(list.size());
            for(int i=0;i<list.size();++i)    
            {
                Vehicle tmp= list.get(i);
                System.out.println(tmp.Get_Id()+" "+tmp.Get_Name()+" "+tmp.Get_Type()+" "+tmp.Get_Speed()+" "+tmp.Get_Crew_Size()+"\n");       
            }
            
        }
        

}
