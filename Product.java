package estoresearch;
public class Product 
{
    private String id;
    private String desc;
    private double price;
    private int year;

    public Product(String id, String desc, double price, int year) throws Exception
    {
        if(desc.isEmpty() == false)
        {
            this.id = id;
            this.price = price; 
            this.desc = desc;
            this.year = year;
        }
        else
        {
            throw new Exception();
        }
    }

    public String getID()
    {
        return id;
    }
    public String getDesc() 
    {
        return desc;
    }
    public double getPrice()
    {
        return price;
    }
    public int getYear()
    {
        return year;
    }

    public String output()
    {
        return ("productID = " + "\"" + id+ "\"" + "\n" + "description = " + "\"" + desc + "\"" + "\n" + "price = " + "\"" + price + "\"" + "\n" + "year = " + "\"" + year + "\"" + "\n");
    }

    public String toString()
    {
        return ("ID = " + id + "\n" + "Description = " + desc + "\n" + "Price = " + price + "\n" + "Year = " + year + "\n");
    }
}