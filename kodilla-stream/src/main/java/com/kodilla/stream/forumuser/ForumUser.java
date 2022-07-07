package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final Integer ID;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postsQuantity;
    public ForumUser(final int ID, final String username, final char sex, final int yearOfBirth, final
                     int monthOfBirth, final int dayOfBirth, final int postsQuantity) {
        this.ID = ID;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsQuantity = postsQuantity;

    }

    public Integer getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getYearOfBirth(){
        return dateOfBirth.getYear();
    }
    public int getMonthOfBirth(){
        return dateOfBirth.getMonthValue();
    }
    public int getDayOfBirth(){
        return dateOfBirth.getDayOfMonth();
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }
    @Override
    public String toString(){
        return "Username - " + username + ", sex - " + sex + ", Date of birth - " + dateOfBirth + ", post quantity - " + postsQuantity;
    }
}
