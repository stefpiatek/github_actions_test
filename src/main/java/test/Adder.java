package test;

import org.springframework.stereotype.Component;

@Component
public class Adder {

    public int add(int first, int two) {
        return first + two;
    }
}
