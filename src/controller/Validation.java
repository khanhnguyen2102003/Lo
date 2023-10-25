package controller;


import java.util.Random;

class Validation {

    public boolean checkUserName(String userName) {
        if (userName.matches("\\d{10}")) {
            return true; 
        }
        return false; 
    }

 public static boolean checkPassword(String string) {
    if (string.length() < 8 || string.length() > 31) {
        return false;
    }

    if (string.matches(".*\\d.*") && string.matches(".*[a-zA-Z].*")) {
        return true;
    }

    return false;
}

    public String randomCaptcha() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        int length = 6;

        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            captcha.append(characters.charAt(index));
        }

        return captcha.toString();
    }
}
