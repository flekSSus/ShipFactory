interface VehicleBuilder
{
    void setId(String id);
    void setName(String name);
    void setType(String type);
    void setMaxSpeed(double maxSpeed);
    void setCrewSize(int crewSize);

    Vehicle getVehicle();
}
