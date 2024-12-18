import java.util.Iterator;
import java.util.ArrayList;
import java.util.AbstractList;

class List extends AbstractList<Vehicle>
{
    ArrayList<Vehicle> arr_vehicle= new ArrayList<Vehicle>();

    @Override
    public int size()
    {
        return arr_vehicle.size();  
    }

    @Override
    public Vehicle set(int index,Vehicle obj)
    {
        return arr_vehicle.set(index,obj);   
    }

    @Override
    public boolean add(Vehicle obj1)
    {
        return arr_vehicle.add(obj1);   
    }
    @Override
    public void clear()
    {
        arr_vehicle.clear();  
    }
    @Override
    public Iterator<Vehicle> iterator()
    {
        return arr_vehicle.iterator();
    }
    boolean contains(Vehicle obj1)
    {
        return arr_vehicle.contains(obj1);  
    }
    boolean containsID(String id)
    {
        for(Vehicle el:arr_vehicle) 
        {
            if(el.Get_Id().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public Vehicle get(int i)
    {
        return arr_vehicle.get(i); 
    }
    @Override
    public Vehicle remove(int i)
    {
        return arr_vehicle.remove(i);  
    }
    @Override
    public int indexOf(Object obj1)
    {
        return arr_vehicle.indexOf(obj1);
    }
   
    public int indexOf_ID(String id)
    {
        for(Vehicle el:arr_vehicle)
        {
            if(el.Get_Id().equals(id)) 
                return arr_vehicle.indexOf(el);
        }
        return -1;
    }




}
