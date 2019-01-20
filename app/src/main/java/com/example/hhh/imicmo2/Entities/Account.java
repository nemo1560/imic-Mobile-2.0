package com.example.hhh.imicmo2.Entities;

public class Account
{
    private Result Result;

    private String ReturnCode;

    private String ErrorMessage;

    private String TotalRecord;

    public Result getResult ()
    {
        return Result;
    }

    public void setResult (Result Result)
    {
        this.Result = Result;
    }

    public String getReturnCode ()
    {
        return ReturnCode;
    }

    public void setReturnCode (String ReturnCode)
    {
        this.ReturnCode = ReturnCode;
    }

    public String getErrorMessage ()
    {
        return ErrorMessage;
    }

    public void setErrorMessage (String ErrorMessage)
    {
        this.ErrorMessage = ErrorMessage;
    }

    public String getTotalRecord ()
    {
        return TotalRecord;
    }

    public void setTotalRecord (String TotalRecord)
    {
        this.TotalRecord = TotalRecord;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Result = "+Result+", ReturnCode = "+ReturnCode+", ErrorMessage = "+ErrorMessage+", TotalRecord = "+TotalRecord+"]";
    }
}
