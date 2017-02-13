package com.alexpol.alexminiapp;

public class Location
{
     private String street;
     private String city;
     private String state;
     private String country;
     private String postal;
     private int number;

     public Location()
     {
          street = "NO_STREET_NAME";
          number = 0;
          city = "NO_CITY_NAME";
          state = "NO_STATE/PROVINCE_NAME";
          country = "NO_COUNTRY_NAME";
          postal = "NO_POSTAL_CODE";
     }

     public Location(String addName, int addNum, String addCity, String addState, String addCountry)
     {
          street = addName;
          number = addNum;
          city = addCity;
          state = addState;
          country = addCountry;
     }

     public void setAddress(String addName, int addNum, String addCity, String addState, String addCountry)
     {
          street = addName;
          number = addNum;
          city = addCity;
          state = addState;
          country = addCountry;
     }

     public void setStreet(String addName)
     {
          street = addName;
     }

     public void setStreetNumber(int addNum)
     {
          number = addNum;
     }

     public void setCity(String addCity)
     {
          city = addCity;
     }

     public void setCountry(String addCountry)
     {
          country = addCountry;
     }

     public String getStreet()
     {
          return street;
     }

     public int getStreetNumber()
     {
          return number;
     }

     public String getCity()
     {
          return city;
     }

     public String getCountry()
     {
          return country;
     }

     public String getPostal()
     {
          return postal;
     }

     public String getFormattedAddress()
     {
          return (city + " " + state);
     }
}
