/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Faker;

import com.github.javafaker.Faker;
import java.util.Locale;

/**
 *
 * @author wufan
 */
public class FakerUtl {
    /**
     * language
     */
    private static final String LANGUAGE = "en";

    private static Faker faker = new Faker(new Locale(FakerUtl.LANGUAGE));
    
    public static double randomDoubleNum(int decimal,int min, int max) {
        return faker.number().randomDouble(decimal, min, max);
    }

    public static int randomIntNum(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    // ====================== random name ===================================

    public static String fullName() {
        return faker.name().fullName();
    }

    public static String name() {
        return faker.name().name();
    }

    public static String appName() {
        return faker.app().name();
    }

    public static String food() {
        return faker.food().ingredient();
    }

    public static String title() {
        return faker.name().title();
    }

    public static String streetAddress() {
        return faker.address().streetAddress();
    }

    public static String cityName() {
        return faker.address().cityName();
    }

    public static String country() {
        return faker.address().country();
    }
    
     public static String company() {
        return faker.company().name();
    }
     
      public static String job() {
        return faker.job().title();
    }

}
