package com.amazon;

public class SearchList {

    String name;
    String price;

    public SearchList (String name, String price){

        this.name=name;
        this.price=price;

    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getPrice()
    {
        return this.price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }

}
