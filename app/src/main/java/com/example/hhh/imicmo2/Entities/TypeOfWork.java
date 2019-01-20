package com.example.hhh.imicmo2.Entities;

public class TypeOfWork
{
    private String TypeOfWorkName;

    private String TypeOfWorkId;

    private String TypeOfWorkDescription;

    public String getTypeOfWorkName ()
    {
        return TypeOfWorkName;
    }

    public void setTypeOfWorkName (String TypeOfWorkName)
    {
        this.TypeOfWorkName = TypeOfWorkName;
    }

    public String getTypeOfWorkId ()
    {
        return TypeOfWorkId;
    }

    public void setTypeOfWorkId (String TypeOfWorkId)
    {
        this.TypeOfWorkId = TypeOfWorkId;
    }

    public String getTypeOfWorkDescription ()
    {
        return TypeOfWorkDescription;
    }

    public void setTypeOfWorkDescription (String TypeOfWorkDescription)
    {
        this.TypeOfWorkDescription = TypeOfWorkDescription;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TypeOfWorkName = "+TypeOfWorkName+", TypeOfWorkId = "+TypeOfWorkId+", TypeOfWorkDescription = "+TypeOfWorkDescription+"]";
    }
}


