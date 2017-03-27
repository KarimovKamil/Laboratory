package ru.kpfu.itis.utils;


public interface HashGenerator {

    /**
     * Encode the raw password
     * @param password Raw password
     * @return Encoded password
     */
    String encode(String password);

    /**
     * Verify the raw password matches the encoded password
     * @param rawPassword Raw password
     * @param encodedPassword Encoded password
     * @return True if the passwords match, false if they do not.
     */
    boolean match(String rawPassword, String encodedPassword);
}
