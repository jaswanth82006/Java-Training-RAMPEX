import java.util.Scanner;

class Locker{
    private int lockerId;
    private boolean isLocked;
    private int pin;
    private String storedItems;

    Locker(int id,int pin){
        this.lockerId=id;
        this.pin=pin;
        this.isLocked=true;
    }

    public void storeItem(String item, int pin){
        if(pin == this.pin){
            if(!isLocked){
            this.storedItems=item;
            System.out.println("Successfully Stored: "+storedItems); }
            else
                System.out.println("is Locked!");
        }
           
        else
            System.out.println("Invalid Pin");

    }


    public void retriveItem(int pin){
         if(pin == this.pin){
            if(!isLocked){
                if(storedItems!=null){
                    System.out.println("Successfully Retrived: "+storedItems);
                    this.storedItems=null;}
                else
                    System.out.println("Locker is Empty");
         }
            else
                System.out.println("is Locked!");
        
        }
        else
            System.out.println("Invalid Pin");
    }

    public void lockerInfo(){
        System.out.println("------\nLocker Id: "+lockerId);
        System.out.println("Is Locked: "+isLocked);
        System.out.println("Stored Item: "+storedItems+"\n --------");
    }

    
    public void unLock(int pin){
         if(pin == this.pin){
            System.out.println("Successfully Unlocked");
            this.isLocked=false; }
        else
            System.out.println("Invalid Pin");
    }

     public void lock(){
        this.isLocked=true; 
        System.out.println("Locked");
    }





}


public class LockerSystem {
    public static void main(String[] args) {
        Locker l = new Locker(01, 1234) ;
        l.storeItem("Moblie", 124);
        l.unLock(1234);
        l.storeItem("Laptop", 1234);
        l.lockerInfo();
        l.retriveItem(1234);
        l.lock();
        l.lockerInfo();
       
    }
}
