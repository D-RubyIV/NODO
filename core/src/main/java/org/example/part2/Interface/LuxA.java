package org.example.part2.Interface;

public class LuxA implements Cars, Transportation{
    @Override
    public String getName() {
        return from;
    }

    @Override
    public String getPrice() {
        return "";
    }

    @Override
    public String getType() {
        return Type;
    }
}
