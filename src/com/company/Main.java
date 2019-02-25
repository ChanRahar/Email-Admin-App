package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Email em1 = new Email("John", "Doe");

        em1.setAlternateEmail("jd@company.com");
        System.out.println(em1.getAlternateEmail());

        System.out.println(em1.getInfo());
    }
}
