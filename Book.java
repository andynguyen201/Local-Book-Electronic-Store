package estoresearch;
public class Book extends Product
{
    private String author;
    private String pub;

    //a method that put all informations given into an object
    //use to store in ArrayList
    public Book(String id, String desc, double price, int year, String author, String pub) throws Exception
    {
        super(id, desc, price, year);
        this.author = author;
        this.pub = pub;
    }

    //retrieve specific informations when needed

    public String getAuthor()
    {
        return author;
    }

    public String getPub()
    {
        return pub;
    }

    @Override
    public String output()
    {
        return("type = \"book\"\n" + super.output() + "authors = " + "\"" + author + "\"" + "\n" + "publisher = " + "\"" + pub + "\"");
    }

    @Override
    public String toString()
    {
        return("Type = Books\n" + super.toString() + "Author = " + author + "\n" + "Publisher = " + pub);
    }
}