import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.example.UserController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;


public class UserControllerTest {

    private static UserController userController;

    @BeforeAll
    static void setup() {
        try {
            userController = new UserController();

            Faker faker = new Faker(new Locale("en-GB"), new Random(42));
            FakeValuesService fs = new FakeValuesService(new Locale("en-GB"), new RandomService(new Random(42)));

            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
            writer.write("name, email, password");
            writer.newLine();

            for (int i = 1; i <= 50; i++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();

                String name = firstName + " " + lastName;
                String email = fs.bothify(String.join(".", firstName.toLowerCase(), lastName.toLowerCase()) + "##@gmail.com");
                String password = faker.internet().password(
                        8,
                        16,
                        true,
                        false,
                        true);

                userController.add(name,email,password);

                writer.append(String.join(", ", name, email, password));
                writer.newLine();

            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void connectTest() {
        // Valid login
        assertTrue(userController.connect("rolland.aufderhar04@gmail.com", "da9UA7lFE"));
        // Invalid user
        assertFalse(userController.connect("charlie.peng42@gmail.com", "securePassword"));
        // Invalid password
        assertFalse(userController.connect("christoper.becker93@gmail.com", "wrongPassword"));
    }

}
