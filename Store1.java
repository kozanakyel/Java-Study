 /**
 * @author: Uğur AKYEL
 * @since: 06.03.2020
 */

public class Assignment01_20190808020{}

/**
 * Product class defines product with name,price and count
 *@param name:Product name, price:Product price, count:Product counts
 */  

class Product {      
    private String name;
    private double price;
    private int count;

    public Product(String name, double price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName(){
        return name;
    } 

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getCount(){
        return count;
    }
    
    /*
     *addToInventory increase amonut
     *@param amount define to given product amount and update amount
     */
    
    public void addToInventory(int amount){
        if(amount >= 0)
            this.count += amount;            
    }
    
    /*
     *purchase metod decrease amount
     */
    
    public double purchase(int amount){
        if(amount < 0 || amount > count){
            return 0;
        }
        else{
            this.count -= amount;
            return amount * price;
        }        
    }

    @Override
    public String toString(){
       return "Product " + name + " has " + count + " remaining "; 
    }
}

/*
 * FoodProduct a type of Product that is eating
 *@param gluten,calories,dairy,meat define the food product
 */

class FoodProduct extends Product{
    private int calories;
    private boolean gluten;
    private boolean dairy;
    private boolean meat;

    public FoodProduct(String name, double price, int count, 
            int calories, boolean gluten, boolean dairy, boolean meat){
        super(name, price, count);
        this.calories = calories;
        this.gluten = gluten;
        this.dairy = dairy;
        this.meat = meat;
    }

    public int getCalories(){
        return calories;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }

    public boolean containsGluten(){
        return gluten;
    }

    public boolean containsDairy(){
        return dairy;
    }

    public boolean containsMeat(){
        return meat;
    }
}

/*
 * ClothingProduct class, a type of Product that is eating
 *@param size define small,large or medium size 
 */

class ClothingProduct extends Product{
    private String size;

    public ClothingProduct(String name, double price, int count, String size){
        super(name, price, count);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }  
}

/*
 *Customer class define a customer object
 */

class Customer {
    private String name;

    public Customer(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }  
}

/*
 *ClubCustomer child of Customer 
 */

class ClubCustomer extends Customer{
    private String phone;

    public ClubCustomer(String name, String phone){
        super(name);
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}

/*
 *Store class define a product list, store name and store website
 *@param website, name, count
 */

class Store {
    private String name;
    private String website;
    private int count;
    private Product[] proList;     

    public Store(String name, String website, int count){
        this.name = name;
        this.website = website;
        proList = new Product[count];
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public int getInventorySize(){
        return proList.length;
    }

    /*
     *getCount metod define how many items in the productlist
     */
    
    public int getCount(){
        int counter = 0;
        for(int i = 0; i < proList.length; i++){
            if(proList[i] != null)
                counter++;
        }
        return counter;
    }
    
    /*
     *addProduct metod add a new product to the store
     *@param product is a new product for store
     */
    
    public void addProduct(Product product){        
        int counter = 0;
        boolean ex = true;
        while(ex && counter < proList.length){
            if(proList[counter] == null){
                proList[counter] = product;
                ex = false;
            }
            counter++;
        }
    }
    
    /*
     *getProduct metod shows the spesific product in the store
     *@param int index that wanted spesific product
     */
    
    public Product getProduct(int index){
        if(index < 0 || index > proList.length)
            return null;
        else
            return proList[index];
    }
}

 



