package org.example;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class DemoFakeValuesService {
    public static void main(String[] args) {
        FakeValuesService f =  new FakeValuesService( new Locale("en-GB"), new RandomService());
        System.out.println("bothify()");
        System.out.printf("f.bothify(\"????##@gmail.com\"): %s\n", f.bothify("????##@gmail.com"));
        System.out.printf("f.bothify(\"????##@gmail.com\"): %s\n", f.bothify("????##@gmail.com"));
        System.out.printf("f.bothify(\"????##@gmail.com\"): %s\n", f.bothify("????##@gmail.com"));

        System.out.println("regexify()");
        System.out.printf("f.regexify(\"[a-z1-9]{10}\"): %s\n", f.regexify("[a-z1-9]{10}"));
        System.out.printf("f.regexify(\"[a-z1-9]{10}\"): %s\n", f.regexify("[a-z1-9]{10}"));
        System.out.printf("f.regexify(\"[a-z1-9]{10}\"): %s\n",  f.regexify("[a-z1-9]{10}"));
    }
}
