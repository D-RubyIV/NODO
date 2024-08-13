package org.example.part5;

class CustomBalance extends Exception{
    public CustomBalance(String message) {
        super(message);
    }
}
class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
}

class Bank{
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void withDraw(double balance) throws CustomBalance {
        if (this.balance < balance){
            throw new CustomBalance("aaa");
        }
        if (balance < 0){
            throw new InvalidInputException("Invalid input parameter");
        }
        this.balance =  this.balance - balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class CustomException {
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        try{
            bank.withDraw(-1);
        }
        catch (InvalidInputException ex){
            System.out.println("LOI 2");
            System.out.println(ex.getMessage());
        }
        catch (CustomBalance ex){
            System.out.println("LOI 1");
            System.out.println(ex.getMessage());
        }
        System.out.println(bank.getBalance());
    }
}
