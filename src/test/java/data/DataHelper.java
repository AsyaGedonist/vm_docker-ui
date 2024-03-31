package data;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper(){}
    @Value
    @Setter
    @Getter
    public static class SignUpData {
        private String email;
        private String name;
        private String password;

        public SignUpData(String email, String name, String password){
            this.email = email;
            this.name = name;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }
        public String getName() {
            return name;
        }
        public String getPassword() {
            return password;
        }
    }

    static Faker faker = new Faker(new Locale("en"));

    public static String generateEmail() {
        var email = faker.internet().emailAddress();
        return email;
    }

    public static String generateName() {
        var name = faker.name().username();
        return name;
    }

    public static String generatePassword() {
        var pass = faker.internet().password();
        return pass;
    }

    public static SignUpData getUser() {
        return new SignUpData(
                generateEmail(),
                generateName(),
                generatePassword());
    }

}
