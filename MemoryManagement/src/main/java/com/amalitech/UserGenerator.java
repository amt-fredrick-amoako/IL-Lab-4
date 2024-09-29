package com.amalitech;

import net.datafaker.Faker;

public class UserGenerator {
    private UserGenerator() {}

    private final static Faker faker = new Faker();

    public static User generateUser() {
        System.out.println("Generating user");
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();
        return new User(name, email, phone, street, city, state, zipCode);
    }
}
