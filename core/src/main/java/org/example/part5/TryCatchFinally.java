package org.example.part5;

public class TryCatchFinally {
    public static void main(String[] args) {
        try{

            try{
                String name = "ABC";
                System.out.println("Đang parse INT");
                Integer.parseInt(name);
            }
            catch (NumberFormatException ex){
                System.out.println("Exception NumberFormatException");
            }

           int a = 5;
           int c = a /0;

        }
        catch (ArithmeticException ex){
            System.out.println("Exception By Zezo");
        }
        finally {
            System.out.println("Khối bắt buộc chạy");
        }
    }
}
