package com.ag.lld.patterns.builder;

public class Student {

    private final String name;
    private final int age;
    private final double psp;
    private final int gradYear;
    private final String org;


    private Student(String name, int age, double psp, int gradYear, String org) {
        this.name = name;
        this.age = age;
        this.psp = psp;
        this.gradYear = gradYear;
        this.org = org;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", psp=" + psp +
                ", gradYear=" + gradYear +
                ", org='" + org + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private String name;
        private int age;
        private double psp;
        private int gradYear;
        private String org;


        public StudentBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public StudentBuilder setOrg(String org) {
            this.org = org;
            return this;
        }

        public Student build(){
            return new Student(this.name, this.age, this.psp, this.gradYear, this.org);
        }
    }


}
