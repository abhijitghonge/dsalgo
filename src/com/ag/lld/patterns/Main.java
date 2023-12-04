package com.ag.lld.patterns;

public class Main {
    public static void main(String[] args) {
       Student student = Student
               .builder()
               .setAge(42)
               .setGradYear(2003)
               .setName("Abhijit Ghonge")
               .setPsp(100)
               .setOrg("Wissen")
               .build();

        System.out.println(student);
    }
}
