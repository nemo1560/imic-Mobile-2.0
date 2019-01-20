package com.example.hhh.imicmo2.Entities;

public class Jobs {
    private String LocationId;

    private String Experience;

    private String Description;

    private String LocationName;

    private String CorporationId;

    private String Job_Description;

    private String CareerId;

    private String TypeOfWorkId;

    private String Salary;

    private String JobRecruitmentId;

    private String TypeName;

    private String Deadline;

    private String CareerName;

    private String Title;

    public String getLocationId ()
    {
        return LocationId;
    }

    public void setLocationId (String LocationId)
    {
        this.LocationId = LocationId;
    }

    public String getExperience ()
    {
        return Experience;
    }

    public void setExperience (String Experience)
    {
        this.Experience = Experience;
    }

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getLocationName ()
    {
        return LocationName;
    }

    public void setLocationName (String LocationName)
    {
        this.LocationName = LocationName;
    }

    public String getCorporationId ()
    {
        return CorporationId;
    }

    public void setCorporationId (String CorporationId)
    {
        this.CorporationId = CorporationId;
    }

    public String getJob_Description ()
    {
        return Job_Description;
    }

    public void setJob_Description (String Job_Description)
    {
        this.Job_Description = Job_Description;
    }

    public String getCareerId ()
    {
        return CareerId;
    }

    public void setCareerId (String CareerId)
    {
        this.CareerId = CareerId;
    }

    public String getTypeOfWorkId ()
    {
        return TypeOfWorkId;
    }

    public void setTypeOfWorkId (String TypeOfWorkId)
    {
        this.TypeOfWorkId = TypeOfWorkId;
    }

    public String getSalary ()
    {
        return Salary;
    }

    public void setSalary (String Salary)
    {
        this.Salary = Salary;
    }

    public String getJobRecruitmentId ()
    {
        return JobRecruitmentId;
    }

    public void setJobRecruitmentId (String JobRecruitmentId)
    {
        this.JobRecruitmentId = JobRecruitmentId;
    }

    public String getTypeName ()
    {
        return TypeName;
    }

    public void setTypeName (String TypeName)
    {
        this.TypeName = TypeName;
    }

    public String getDeadline ()
    {
        return Deadline;
    }

    public void setDeadline (String Deadline)
    {
        this.Deadline = Deadline;
    }

    public String getCareerName ()
    {
        return CareerName;
    }

    public void setCareerName (String CareerName)
    {
        this.CareerName = CareerName;
    }

    public String getTitle ()
    {
        return Title;
    }

    public void setTitle (String Title)
    {
        this.Title = Title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LocationId = "+LocationId+", Experience = "+Experience+", Description = "+Description+", LocationName = "+LocationName+", CorporationId = "+CorporationId+", Job_Description = "+Job_Description+", CareerId = "+CareerId+", TypeOfWorkId = "+TypeOfWorkId+", Salary = "+Salary+", JobRecruitmentId = "+JobRecruitmentId+", TypeName = "+TypeName+", Deadline = "+Deadline+", CareerName = "+CareerName+", Title = "+Title+"]";
    }

}
