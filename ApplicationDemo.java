// import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

class User{
    private int userID;
    private String name;
    private String dateOfBirth;
    private String Address;
    private String PAN;

    public User(){}

    public User(int userID, String name, String dateOfBirth, String address, String pAN) {
        this.userID = userID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        Address = address;
        PAN = pAN;
    }

}

class Admin extends User{
    private String dateOfJoining;
    private int salary;
    private String permissibleOperations;

    public Admin(){}

    public Admin(int userID, String name, String dateOfBirth, String address, String pAN, String dateOfJoining,
            int salary, String permissibleOperations) {
        super(userID, name, dateOfBirth, address, pAN);
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.permissibleOperations = permissibleOperations;
    }
    
}

class General extends User{
    private String dateOfJoining;
    private int salary;
    private int dutyHourPerDay;
    
    public General(){}

    public General(int userID, String name, String dateOfBirth, String address, String pAN, String dateOfJoining,
            int salary, int dutyHourPerDay) {
        super(userID, name, dateOfBirth, address, pAN);
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.dutyHourPerDay = dutyHourPerDay;
    }
}

class Item{
    protected int itemCode;
    private int price;
    private int AvailableQty;

    public int getItemCode() {
        return itemCode;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailableQty() {
        return AvailableQty;
    }

    public Item(){}

    public Item(int itemCode, int price, int availableQty) {
        this.itemCode = itemCode;
        this.price = price;
        AvailableQty = availableQty;
    }

    public boolean checkItemCode(int itemCode) {
        return this.itemCode == itemCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int availableQty) {
        AvailableQty = availableQty;
    }

    public void modifyStock(int quantity) {
        AvailableQty -=quantity; 
    }

    public void display() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Price: " + price);
        System.out.println("AvailableQty: " + AvailableQty);
    }
}

class FoodItem extends Item{
    private String dateOfExpiry;

    public FoodItem() {}

    public FoodItem(int itemCode, int price, int availableQty, String dateOfExpiry) {
        super(itemCode, price, availableQty);
        this.dateOfExpiry = dateOfExpiry;
    }

    public boolean checkItemCode(int itemCode) {
        return this.itemCode==itemCode;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Date of Exp: " + dateOfExpiry);
    }
}

class NonFoodItem extends Item{
    
    private int returnCount;

    public NonFoodItem() {}

    public NonFoodItem(int itemCode, int price, int availableQty, int returnCount) {
        super(itemCode, price, availableQty);
        this.returnCount = returnCount;
    }

    public boolean checkItemCode(int itemCode) {
        return this.itemCode == itemCode;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Date of Exp: " + returnCount);
    }
}

class Sell {
    
    private int dateOfSell;
    private int itemCode;
    private int quantity;
    private int totalAmount;
    
    public int getDateOfSell() {
        return dateOfSell;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public Sell(){}

    public Sell(int dateOfSell, int itemCode, int quantity, int totalAmount) {
        this.dateOfSell = dateOfSell;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public void display() {
        System.out.println("Date of Sell" + dateOfSell);
        System.out.println("Item code" + itemCode);
        System.out.println("Quantity" + quantity);
        System.out.println("Total Amount" + totalAmount);
    }


}

class Return {
    private int dateOfReturn;
    private int itemCode;
    private int quantity;
    private int returnAmount;

    public int getDateOfReturn() {
        return dateOfReturn;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public Return(){}

    public Return(int dateOfReturn, int itemCode, int quantity, int returnAmount) {
        this.dateOfReturn = dateOfReturn;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.returnAmount = returnAmount;
    }


}

public class ApplicationDemo {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        ArrayList <Item> itemList = new ArrayList<Item>(); 
        ArrayList <FoodItem> foodItemList = new ArrayList<FoodItem>(); 
        ArrayList <NonFoodItem> nonFoodItemList = new ArrayList<NonFoodItem>(); 
        ArrayList <Sell> sellItemList = new ArrayList<Sell>(); 
        ArrayList <Return> returnItemList = new ArrayList<Return>(); 
        while(true){
            System.out.println("1. Admin User \n2. General User \n3. exit\n");
            int ch1 = input.nextInt();
            if(ch1==1){
                System.out.println("1. addNewStock \n2. deleteStock \n3. modifyStock \n");
                int ch2 = input.nextInt();
                if(ch2 == 1){
                    System.out.print("Item Code: ");
                    int itemCode = input.nextInt();
                    System.out.print("Price: ");
                    int price = input.nextInt();
                    System.out.print("Available Quantity: ");
                    int availableQty = input.nextInt();
                    System.out.println("1. Food Item \n2. Non Food Item\n");
                    int ch3 = input.nextInt();
                    input.nextLine();
                    if(ch3== 1){
                        System.out.print("dateOfExpiry: ");
                        String dateOfExpiry = input.nextLine(); 
                        FoodItem fi = new FoodItem(itemCode, price, availableQty, dateOfExpiry);
                        foodItemList.add(fi);
                        itemList.add(fi);
                    }
                    else{
                        System.out.print("returnCount: ");
                        int returnCount = input.nextInt();
                        NonFoodItem nfi = new NonFoodItem(itemCode, price, availableQty, returnCount);
                        nonFoodItemList.add(nfi);
                        itemList.add(nfi);
                    }
                }
                else if(ch2==2){
                    System.out.print("itemCode: ");
                    int itemCode = input.nextInt();
                    System.out.println("1. Food Item \n2. Non Food Item");
                    int ch3 = input.nextInt();
                    if(ch3==1){
                        for(FoodItem fi : foodItemList){
                            if(fi.checkItemCode(itemCode)==true){
                                foodItemList.remove(fi);
                                itemList.remove(fi);
                                break;
                            }
                        }
                    }
                    else{
                        for (NonFoodItem nfi : nonFoodItemList) {
                            if (nfi.checkItemCode(itemCode) == true) {
                                foodItemList.remove(nfi);
                                itemList.remove(nfi);
                                break;
                            }
                        }
                    }
                }
                else if(ch2==3){
                    System.out.println("1. price \n2. availableQty");
                    int ch3 = input.nextInt();
                    System.out.print("Item Code: ");
                    int itemCode = input.nextInt();
                    if(ch3==1){
                        System.out.println("Enter New Price");
                        int price = input.nextInt();
                        for(Item it: itemList){
                            if(it.checkItemCode(itemCode)==true){
                                it.setPrice(price);
                                break;
                                // if(it instanceof FoodItem) foodItemList.remove(it);
                                // else nonFoodItemList.remove(it);
                            }
                        }
                    }
                    else{
                        System.out.println("availableQty");
                        int availableQty = input.nextInt();
                        for (Item it : itemList) {
                            if (it.checkItemCode(itemCode) == true) {
                                it.setQty(availableQty);
                                break;
                                // if(it instanceof FoodItem) foodItemList.remove(it);
                                // else nonFoodItemList.remove(it);
                            }
                        }
                    }

                }

            }
            else if(ch1==2){
                System.out.println("1. Sell Item \n2. return Item \n3. display Stock \n4. display Sell");
                int ch2 = input.nextInt();
                if(ch2== 1){
                    System.out.println("Date of Sell(DDMMYYYY)");
                    // input.nextLine();
                    int dateOfSell = input.nextInt();
                    System.out.print("Item Code: ");
                    int itemCode = input.nextInt();
                    Item it = null;
                    for(Item i: itemList){
                        if(i.checkItemCode(itemCode)==true) it = i;
                    }
                    if(it==null) continue;
                    System.out.print("quantity: ");
                    int quantity = input.nextInt();
                    while(it.getAvailableQty() < quantity){
                        System.out.println("not enough qty. enter again!!");
                        quantity = input.nextInt();
                    }
                    int totalAmount = it.getPrice() * quantity;
                    Sell si = new Sell(dateOfSell, itemCode, quantity, totalAmount);
                    sellItemList.add(si);
                    it.modifyStock(quantity);
                }
                else if(ch2==2){
                    System.out.print("Date of Return(DDMMYYYY: ");
                    // input.nextLine();
                    int dateOfReturn = input.nextInt();
                    System.out.print("Item Code: ");
                    int itemCode = input.nextInt();
                    Item it = null;
                    for (Item i : itemList) {
                        if (i.checkItemCode(itemCode) == true &&  i instanceof NonFoodItem)
                            it = i;
                        else if(i.checkItemCode(itemCode) == true && i instanceof FoodItem){
                            System.out.println("Food item cant return");
                        }
                    }
                    if(it==null) continue;
                    System.out.print("quantity: ");
                    int quantity = input.nextInt();
                    while (it.getAvailableQty() < quantity) {
                        System.out.println("not enough qty. enter again!!");
                        quantity = input.nextInt();
                    }
                    int returnAmount = it.getPrice() * quantity;
                    Return si = new Return(dateOfReturn, itemCode, quantity, returnAmount);
                    returnItemList.add(si);
                    it.modifyStock(quantity);
                }
                else if(ch2==3){
                    System.out.print("Item Code: ");
                    int itemCode = input.nextInt();
                    for(Item it: itemList){
                        if(it.checkItemCode(itemCode)==true){
                            it.display();
                            break;
                        }
                    }
                }
                else{
                    System.out.print("Start date(DDMMYYYY): ");
                    int startDate = input.nextInt();
                    System.out.print("End date: ");
                    int endDate = input.nextInt();
                    for(Sell it: sellItemList){
                        if(it.getDateOfSell()>startDate && it.getDateOfSell()<endDate){
                            it.display();
                        }
                    }
                }
            }
            else{
                return;
            }
        }
    }
}
