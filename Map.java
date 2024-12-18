import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

class Map extends AbstractMap
{
    HashMap<Integer,Vehicle> map_ships = new HashMap<Integer,Vehicle>(); 

    
    @Override
    public Set<Map.Entry<Integer, Vehicle>> entrySet()
    {
        return map_ships.entrySet();
    }
    public Vehicle put(Integer key,Vehicle value)
    {
        return map_ships.put(key,value);
    }
    @Override
    public Vehicle get(Object key)
    {
       return map_ships.get(key);
    }
    @Override
    public int size()
    {
       return map_ships.size();   
    }
    @Override
    public Vehicle remove(Object key)
    {
        return map_ships.remove(key);  
    }


}
