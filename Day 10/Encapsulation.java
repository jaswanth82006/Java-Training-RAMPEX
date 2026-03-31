class BankAccount{
    private double balance;
    public void setBalance(double amt){
        if(amt>0)
        this.balance+=amt;
        else
            System.out.println("Invalid Amount");
    }
    public double getBalance(){
        return balance;
    }
    public void withdrawel(double amt){
        if(amt>0 && amt<=balance)
            this.balance-=amt;
        else
            System.out.println("Invalid Amount");
    }



}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount b= new BankAccount();
        b.setBalance(1000.64);
        System.out.println("Available Balace: "+b.getBalance());
        b.withdrawel(500.50);
        System.out.println("Available Balace: "+b.getBalance());
        
        
    }
}
