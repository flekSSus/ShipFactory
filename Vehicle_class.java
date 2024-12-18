import java.io.*;

abstract class Vehicle
{
    protected String id_str;
    protected String name_str;
    protected String type_str;
    protected double max_speed_d;
    protected int crew_size_i;
 
    Vehicle()
    {
        id_str="n/i";
        name_str="n/i";
        type_str="n/i";
        max_speed_d=0;
        crew_size_i=0;
    }
    
    Vehicle(String id, String name,String type, double max_speed,int crew_size) 
    {
        id_str=id;
        name_str=name;
        type_str=type;
        max_speed_d=max_speed;
        crew_size_i=crew_size;
    }
    
    abstract public String toString();

    abstract public void GetInfo(Writer writer);
    abstract public String Get_Id();
    abstract public String Get_Name();
    abstract public String Get_Type();
    abstract public double Get_Speed();
    abstract public int Get_Crew_Size();

    abstract public void Set_Id(String id);
    abstract public void Set_Name(String name);
    abstract public void Set_Type(String type);
    abstract public void Set_Speed(double max_speed);
    abstract public void Set_Crew_Size(int crew_size);

}




