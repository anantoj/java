package shoe_shop;

public class Shoe{
    private String name;
    private String category;
    private String releaseDate;
    private int price;
    private String code;

    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public String getReleaseDate(){
        return releaseDate;
    }
    public int getPrice(){
        return price;
    }
    public String getCode(){
        return code;
    }

    public Shoe(String name, String category, String releaseDate, int price){
        this.name = name;
        this.category = category;
        this.releaseDate = releaseDate;
        this.price = price;
    }


}   