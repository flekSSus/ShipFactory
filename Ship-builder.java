class ShipBuilder implements VehicleBuilder
{
    private String id_;
    private String name_;
    private String type_;
    private double maxSpeed_;
    private int crewSize_;
    
    @Override
    public void setId(String id)
    {
        id_=id;   
    }

    @Override
    public void setName(String name)
    {
        name_=name;  
    }

    @Override
    public void setType(String type)
    {
        type_=type;  
    }

    @Override
    public void setMaxSpeed(double maxSpeed)
    {
        maxSpeed_=maxSpeed; 
    }

    @Override
    public void setCrewSize(int crewSize)
    {
        crewSize_=crewSize;   
    }
    
    public Ship getVehicle()
    {
        return new Ship(id_,name_,type_,maxSpeed_,crewSize_);
    }
}
