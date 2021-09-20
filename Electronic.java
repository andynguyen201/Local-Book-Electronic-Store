package estoresearch;
public class Electronic extends Product
{        
    private String maker;

    //a method that put all informations given into an object
    //use to store in ArrayList
    public Electronic(String id, String desc, double price, int year, String maker) throws Exception
    {
        super(id, desc, price, year);
        this.maker = maker;
    }

    public String getMaker()
    {
        return maker;
    }

    @Override
    public String output()
    {
        return("type = \"electronics\"\n" + super.output() + "maker = " + "\"" + maker + "\"");
    }

    @Override
    public String toString()
    {
        return("Type = Electronics\n" + super.toString() + "Maker = " + maker);
    }
}