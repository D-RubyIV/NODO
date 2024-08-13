package org.example.part5;

// Custom checked exception
class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}

public class ExampleChecked {
    public void doSomething() throws MyCheckedException {
        throw new MyCheckedException("An error occurred in doSomething");
    }

    public static void main(String[] args) throws MyCheckedException {
        ExampleChecked example = new ExampleChecked();

        System.out.println("CHECK START RUN");

        example.doSomething();

        System.out.println("OK");
    }
}
