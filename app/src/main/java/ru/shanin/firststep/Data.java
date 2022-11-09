package ru.shanin.firststep;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Data {
    private static final int count = 0;
    private final String arg1;
    private final String arg2;
    private final String arg3;
    private final int args4;

    public Data(String arg1, String arg2, String arg3) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.args4 = (int) (Math.random() * 900 + 100);
    }

    @NonNull
    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }

}

class NewData {

    private static String genNumber() {
        String digits = "0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++)
            result.append(digits.charAt((int) (Math.random() * 10)));
        return result.toString();
    }

    public static String genPhoneNumber() {
        return "+79" + genNumber();
    }

    private static String genString(int length) {
        String alphabetInUpperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String alphabetInLowerCase = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder result = new StringBuilder();
        result.append(alphabetInUpperCase.charAt((int) (Math.random() * 26)));
        for (int i = 0; i < length - 1; i++)
            result.append(alphabetInLowerCase.charAt((int) (Math.random() * 26)));
        return result.toString();
    }

    public static String genFirstName() {
        return genString(8);
    }

    public static String genSecondName() {
        return genString(6);
    }
}
