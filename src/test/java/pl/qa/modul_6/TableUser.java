package pl.qa.modul_6;

import com.microsoft.playwright.Locator;

public class TableUser {
    private final String firstName;
    private final String lastName;
    private final String userEmail;
    private final String due;
    private final String website;
    private final Locator action;

    public TableUser(String firstName, String lastName, String userEmail, String due, String website, Locator action) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.due = due;
        this.website = website;
        this.action = action;
    }

    // Gettery zgodnie z konwencją JavaBeans
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserEmail() { return userEmail; }
    public String getDue() { return due; }
    public String getWebsite() { return website; }
    public Locator getAction() { return action; }
}
