package com.example.hhh.imicmo2.Entities;

public class Careers {
    private String CareerDescription;

    private String CareerId;

    private String CareerName;

    public String getCareerDescription ()
    {
        return CareerDescription;
    }

    public void setCareerDescription (String CareerDescription)
    {
        this.CareerDescription = CareerDescription;
    }

    public String getCareerId ()
    {
        return CareerId;
    }

    public void setCareerId (String CareerId)
    {
        this.CareerId = CareerId;
    }

    public String getCareerName ()
    {
        return CareerName;
    }

    public void setCareerName (String CareerName)
    {
        this.CareerName = CareerName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CareerDescription = "+CareerDescription+", CareerId = "+CareerId+", CareerName = "+CareerName+"]";
    }

}
