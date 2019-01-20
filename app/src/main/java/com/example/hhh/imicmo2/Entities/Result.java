package com.example.hhh.imicmo2.Entities;

import java.io.Serializable;

public class Result implements Serializable{
    private String Email;

    private String PassWord;

    private String FullName;

    private String Address;

    private String Mobile;

    private String UserName;

    private String ProfileId;

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

    public String getPassWord ()
{
    return PassWord;
}

    public void setPassWord (String PassWord)
    {
        this.PassWord = PassWord;
    }

    public String getFullName ()
    {
        return FullName;
    }

    public void setFullName (String FullName)
    {
        this.FullName = FullName;
    }

    public String getAddress ()
{
    return Address;
}

    public void setAddress (String Address)
    {
        this.Address = Address;
    }

    public String getMobile ()
    {
        return Mobile;
    }

    public void setMobile (String Mobile)
    {
        this.Mobile = Mobile;
    }

    public String getUserName ()
    {
        return UserName;
    }

    public void setUserName (String UserName)
    {
        this.UserName = UserName;
    }

    public String getProfileId ()
    {
        return ProfileId;
    }

    public void setProfileId (String ProfileId)
    {
        this.ProfileId = ProfileId;
    }

}

