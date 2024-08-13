package org.example.part5;

// Custom unchecked exception
class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

public class ExampleUnchecked {
    public void doSomethingElse() {
        throw new MyUncheckedException("An error occurred in doSomethingElse");
    }

    public static void main(String[] args) {
        ExampleUnchecked example = new ExampleUnchecked();

        System.out.println("CHECK START RUN");

         try {
             example.doSomethingElse();
         } catch (MyUncheckedException e) {
             System.out.println("Caught unchecked exception: " + e.getMessage());
         }
        System.out.println("OK");
    }
}
