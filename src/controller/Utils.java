package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import model.User;

public class Utils {

    private Validation valid;

    public Utils() {
        valid = new Validation();
    }

    private String getInput(String promt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(promt);
        return sc.nextLine();
    }

    public String getWordLanguage(Locale language, String text) {
        ResourceBundle bundle = ResourceBundle.getBundle("language/" + language, language);
        String value = bundle.getString(text);
        return value;

    }

    public void logIn(ArrayList<User> dataUser, Locale language) {
        String userName;
        do {
            userName = getInput(getWordLanguage(language, "EnterUser"));

            if (!valid.checkUserName(userName)) {
                System.out.println(getWordLanguage(language, "NoticeWrongUser"));
            }
        } while (!valid.checkUserName(userName));

        String passWord;
        boolean passwordCorrect = false;
        do {
            passWord = getInput(getWordLanguage(language, "EnterPassword"));
            if (valid.checkPassword(passWord)) {
                passwordCorrect = true;
            } else {
                System.out.println(getWordLanguage(language, "NoticeWrongPass"));
            }
        } while (!passwordCorrect);

        capchar(language);
        dataUser.add(new User(userName, passWord));
        System.out.println(getWordLanguage(language, "NoticeLogIn"));
    }

    public void capchar(Locale language) {
        String captcha, input;

        do {
            captcha = valid.randomCaptcha();
            System.out.println(getWordLanguage(language, "Captcha") + captcha);
            input = getInput(getWordLanguage(language, "EnterCap"));

            if (!input.equals(captcha)) {
                System.out.println(getWordLanguage(language, "CaptchaIncorrectNoctice"));
            }
        } while (!input.equals(captcha));
    }
}
