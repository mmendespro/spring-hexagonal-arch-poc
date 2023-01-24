package net.local.demo.hexagonal.application.domain.valueObjects;

public class Money {
    
    private float value;

    public Money(float value) {
        this.value = value;
    }
    
    public void increase(float incValue) {
        value += incValue;
    }

    public void decrease(float decValue) {
        value -= decValue;
    }

    public float getValue() {
        return value;
    }
}
