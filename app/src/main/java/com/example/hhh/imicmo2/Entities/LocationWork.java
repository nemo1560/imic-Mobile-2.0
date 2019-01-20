package com.example.hhh.imicmo2.Entities;

public class LocationWork {
    private String LocationId;

    private String LocationDescription;

    private String LocationName;

    public String getLocationId ()
    {
        return LocationId;
    }

    public void setLocationId (String LocationId)
    {
        this.LocationId = LocationId;
    }

    public String getLocationDescription ()
    {
        return LocationDescription;
    }

    public void setLocationDescription (String LocationDescription)
    {
        this.LocationDescription = LocationDescription;
    }

    public String getLocationName ()
    {
        return LocationName;
    }

    public void setLocationName (String LocationName)
    {
        this.LocationName = LocationName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LocationId = "+LocationId+", LocationDescription = "+LocationDescription+", LocationName = "+LocationName+"]";
    }
}
