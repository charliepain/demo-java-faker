package org.example;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.*;

public class DemoFaker {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Name name = faker.name();
        // https://dius.github.io/java-faker/apidocs/index.html
        System.out.println("Classe Name");
        // Chaque appel est indépendant
        System.out.printf("name.firstName(): %s\n", name.firstName());
        System.out.printf("name.lastName(): %s\n", name.lastName());
        System.out.printf("name.fullName(): %s\n", name.name());

        System.out.println();

        System.out.println("Autres exemples");
        System.out.printf("faker.internet().emailAddress(): %s\n", faker.internet().emailAddress());
        System.out.printf("faker.phoneNumber().cellPhone(): %s\n", faker.phoneNumber().cellPhone());
        System.out.printf("faker.business().creditCardNumber(): %s\n", faker.business().creditCardNumber());
        System.out.printf("faker.pokemon().name(): %s\n", faker.pokemon().name());
        System.out.printf("faker.harryPotter().character(): %s\n", faker.harryPotter().character());

        System.out.println();

        System.out.println("Locale");
        Faker russianFaker = new Faker(new Locale("ru"));
        Faker chineseFaker = new Faker(new Locale("zh-CN"));
        System.out.printf("russianFaker.name().fullName(): %s\n", russianFaker.name().fullName());
        System.out.printf("chineseFaker.name().fullName(): %s\n", chineseFaker.name().fullName());
        System.out.printf("chineseFaker.job().field(): %s\n", chineseFaker.job().field());

        System.out.println();

        // Graine pour garantir mêmes sorties à chaque exécution
        Faker seededFaker = new Faker(new Random(42));
        System.out.println("Couleurs");
        for (int i = 1; i <= 10; i++) {
            // Pas de garantie d'unicité
            System.out.printf("%d. %s\n", i, seededFaker.color().name());
        }

    }
}