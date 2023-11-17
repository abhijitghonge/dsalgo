package com.ag.lld;

public class Student {
    // write the code of student class here
    int age;
    String name;

    public void display(){
        System.out.printf("My name is %s. I am %d years old%n", this.name, this.age);
    }

    public void sayHello(String inName){
        System.out.printf("%s says hello to %s%n", this.name, inName);
    }

}

