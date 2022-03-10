package com.example.surfingpatrol;


/**
 *
 */

// Class of help methods
public class Helpers {
    /*
    Generates a unique ID for each user to be saved on firebase
    * */
    public static String generateId(String username) {
        String id = "";
        for (int i = 0; i < username.length(); i++) {
            id += "" + ((int) username.charAt(i));

        }
        return id;
    }
}
