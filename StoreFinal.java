import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Assignment04_20190808020 {}

class Product {
    private String name;
    private double price;

    public Product(String name, double price)
            throws InvalidPriceException, InvalidPurchaseException,
            InvalidAmountException{
        this.name = name;
        this.price = price;
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

    public void setPrice(double price) throws InvalidPriceException{
        if(price >= 0)
            this.price = price;
        else
            throw new InvalidPriceException(price);
    }

    @Override
    public String toString(){
        return name + " @ " + price;
    }
}

class FoodProduct extends Product{
    private int calories;
    private boolean gluten;
    private boolean dairy;
    private boolean meat;

    public FoodProduct(String name, double price, int calories,
                       boolean gluten, boolean dairy, boolean meat)
            throws InvalidAmountException{
        super(name, price);
        this.calories = calories;
        this.gluten = gluten;
        this.dairy = dairy;
        this.meat = meat;
    }

    public int getCalories(){
        return calories;
    }

    public void setCalories(int calories) throws InvalidAmountException{
        if(calories >= 0)
            this.calories = calories;
        else
            throw new InvalidAmountException(calories);
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

class ClothingProduct extends Product{
    private String size;

    public ClothingProduct(String name, double price, String size){
        super(name, price);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }
}

class Customer {
    private String name;
    private HashMap<Product, Integer> proCount;
    private HashMap<Store, HashMap<Product, Integer>> storeMap;

    public Customer(String name){
        this.name = name;
        this.storeMap = new HashMap<>();
        this.proCount = new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addToCart(Store store, Product product, int count)
            throws ProductNotFoundException, InvalidAmountException{
        try{
            store.purchase(product, count);
            if(!proCount.containsKey(product)) {
                proCount.put(product, count);
                storeMap.put(store, proCount);
            }
            else if(proCount.containsKey(product)){
                proCount.put(product, (proCount.get(product) + count));
                storeMap.put(store, proCount);
            }
        }
        catch (InvalidPurchaseException ex){
            System.out.println("ERROR: " + ex);
        }
        catch(ProductNotFoundException ex1){
            System.out.println("ERROR: " + ex1);
        }
    }

    /**
     * I tried a lot of code style, but most of the time it failed. Finally
     * I used to the stringbuilder object for this receipt loop so that
     * additionally Receipt process added step by step for each product
     * */

    public String receipt(Store store){
        StringBuilder receiptList = new StringBuilder();

        if(!storeMap.containsKey(store)){
            throw new StoreNotFoundException(store.getName());
        }else{
            receiptList.append("Customer receipt for " + store.getName() + " \n\n");
            HashMap<Product, Integer> newMap;
            for (HashMap.Entry<Store, HashMap<Product, Integer>> e: storeMap.entrySet()) {
                newMap = e.getValue();
                for (Product f : newMap.keySet()){
                    receiptList.append(f.getName()).
                            append(" @ ").append(f.getPrice()).append(" X ").append(newMap.get(f)).
                            append(" ... ").append(f.getPrice() * newMap.get(f)).append("\n");
                }
            }
        }

        return receiptList.toString() + "\n---------------------------------"
                + "\nTotal Due - " + getTotalDue(store) + "\n";
    }

    public double getTotalDue(Store store) throws StoreNotFoundException{
        double totalDue = 0;
        if(!storeMap.containsKey(store)){
            throw new StoreNotFoundException(store.getName());
        }else{
            HashMap<Product, Integer> newMap;
            for (HashMap.Entry<Store, HashMap<Product, Integer>> e: storeMap.entrySet()) {
                newMap = e.getValue();
                for (Product f : newMap.keySet()){
                    totalDue += f.getPrice() * newMap.get(f);
                }
            }
        }
        return totalDue;
    }

    public double pay(Store store, double amount)
            throws NotEnoughPaymentException, StoreNotFoundException{
        if(amount < getTotalDue(store)){
            throw new NotEnoughPaymentException(amount, getTotalDue(store));
        }
        else if(!storeMap.containsKey(store)){
            throw new StoreNotFoundException(store.getName());
        }
        else{
            double total = getTotalDue(store);
            System.out.println("Thank you, for your business.");
            storeMap.remove(store);
            return amount - total;
        }
    }
}

class Store{
    private String name;
    private String website;
    private int count;
    private HashMap<String, Customer> listCustomer;
    private HashMap<Product, Integer> listProduct;

    public Store(String name, String website){
        this.name = name;
        this.website = website;
        listCustomer = new HashMap<String, Customer>();
        listProduct = new HashMap<Product, Integer>();
    }

    public int getCount(){return listProduct.size();}

    public int getProductCount(Product product) throws ProductNotFoundException{
        if(listProduct.containsKey(product)){
            return listProduct.get(product);
        }
        else
            throw new ProductNotFoundException(product.getName());
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

    public void addToInventory(Product product, int amount)
            throws InvalidAmountException{
        if(!listProduct.containsKey(product)){
            listProduct.put(product, amount);
        }
        else if(listProduct.containsKey(product)){
            listProduct.put(product, listProduct.get(product) + amount);
        }
        else if(amount < 0){
            throw new InvalidAmountException(amount);
        }
    }

    public double purchase(Product product, int amount)
            throws InvalidAmountException, ProductNotFoundException{
        if(!listProduct.containsKey(product))
            throw new ProductNotFoundException(product.getName());
        else if(amount < 0)
            throw new InvalidAmountException(amount);
        else if(amount > listProduct.get(product))
            throw new InvalidAmountException(amount);

        else {
            listProduct.put(product, (listProduct.get(product) - amount));
            return amount * product.getPrice();
        }
    }

    public void addCustomer(Customer customer, String phone){
        listCustomer.put(phone, customer);
    }


    public Customer getCustomer(String phone)
            throws CustomerNotFoundException{
        if(listCustomer.containsKey(phone)){
            return listCustomer.get(phone);
        }else
            throw new CustomerNotFoundException(phone);
    }

    public void removeProduct(Product product)
            throws ProductNotFoundException{
        if(listProduct.containsKey(product)){
            listProduct.remove(product);
        }else
            throw new ProductNotFoundException(product.getName());
    }
}

class StoreNotFoundException extends RuntimeException{
    private String name;

    public StoreNotFoundException(String name){
        this.name = name;
    }

    public String toString(){
        return "StoreNotFoundException: " + name;
    }
}

class InvalidPriceException extends RuntimeException{
    private double price;

    public InvalidPriceException(double price){

        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return "InvalidPriceException: " + price;
    }
}

class InvalidAmountException extends RuntimeException{
    private int amount;

    public InvalidAmountException(int amount){

        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public String toString(){
        return "InvalidAmountException: " + amount;
    }
}

class InvalidPurchaseException extends RuntimeException{
    private int amount;
    private int remaining;

    public InvalidPurchaseException(int amount, int remaining){
        this.amount = amount;
        this.remaining = remaining;
    }

    public int getAmount(){
        return amount;
    }

    public int getRemaining(){
        return remaining;
    }

    public String toString(){
        return "InvalidPurchaseException: " + amount + " requested, "
                + remaining + " remaining.";
    }
}

class NotEnoughPaymentException extends RuntimeException{
    private double amount;
    private double due;

    public NotEnoughPaymentException(double amount, double due){

        this.amount = amount;
        this.due = due;
    }

    public double getAmount(){
        return amount;
    }

    public double getDue(){
        return due;
    }

    public String toString(){
        return "NotEnoughPaymentException: " + due + " due, but only "
                + amount + " given.";
    }
}

class ProductNotFoundException extends RuntimeException{
    private String name;

    public ProductNotFoundException(String name){

        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "ProductNotFoundException: " + name;
    }
}

class CustomerNotFoundException extends RuntimeException{
    private String phone;

    public CustomerNotFoundException(String phone){

        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public String toString(){
        return "CustomerNotFoundException: " + phone;
    }
}
