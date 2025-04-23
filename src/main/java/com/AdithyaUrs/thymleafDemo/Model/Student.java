package com.AdithyaUrs.thymleafDemo.Model;

import java.util.List;

public class Student
{
    private String FirstName, LastName , country , favProgLang;
    private List<String> knownOS;

    public Student() {}

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getFavProgLang()
    {
        return favProgLang;
    }

    public void setFavProgLang(String favProgLang)
    {
        this.favProgLang = favProgLang;
    }

    public List<String> getKnownOS()
    {
        return knownOS;
    }

    public void setKnownOS(List<String> knownOS)
    {
        this.knownOS = knownOS;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", country='" + country + '\'' +
                ", favProgLang='" + favProgLang + '\'' +
                ", knownOS=" + knownOS +
                '}';
    }
}
