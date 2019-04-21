package com.designpattern.creational.abstractfactory;

interface Animal {
    String getAnimal();

    String makeSound();
}

class Duck implements Animal {

    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}

class Dog implements Animal {

    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Bark";
    }
}

class Bear implements Animal {

    @Override
    public String getAnimal() {
        return "Bear";
    }

    @Override
    public String makeSound() {
        return "Gurr";
    }
}

interface Color {
    String getColor();
}

class Brown implements Color {

    @Override
    public String getColor() {
        return "brown";
    }

}

class Red implements Color {

    @Override
    public String getColor() {
        return "red";
    }

}

interface AbstractFactory<T> {
    T create(String type);
}

class AnimalFactory implements AbstractFactory<Animal> {
    public Animal create(String type) {
        Animal animal = null;
        switch (type) {
            case "dog":
                animal = new Dog();
                break;
            case "duck":
                animal = new Duck();
                break;
            case "bear":
                animal = new Bear();
        }
        return animal;
    }
}

class ColorFactory implements AbstractFactory<Color> {
    public Color create(String type) {
        Color color = null;
        switch (type) {
            case "brown":
                color = new Brown();
                break;
            case "red":
                color = new Red();
        }
        return color;
    }
}

class factoryProvider {
     public static AbstractFactory getFactory(String type) {
         AbstractFactory abstractFactory = null;
        switch (type) {
            case "animal":
                abstractFactory = new AnimalFactory();
                break;
            case "color":
                abstractFactory = new ColorFactory();
        }
        return abstractFactory;
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = factoryProvider.getFactory("animal");
        Animal a = (Animal)factory.create("dog");
        System.out.println(a.makeSound());

    }
}

