package com.kodilla.testing.forum.statistics;

public class StatisticsClass {
    public int usersQuantity;
    public int postsQuantity;
    public int commentsQuantity;
    public int averagePostPerUser;
    public int averageCommentsPerUser;
    public int averageCommentsPerPost;
    private Statistics statistics;

    public StatisticsClass(Statistics statistics){
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        averagePostPerUser = 10/statistics.usersNames().size(); // liczba postów jednego użytkownika?? / liczbę użytkowników
        averageCommentsPerUser = 10/statistics.usersNames().size(); // ? liczba komentarzy jednego użytkownika
        averageCommentsPerPost = 10/statistics.postsCount(); // ? liczba kometarzy przy jednym poście
    }

    public void showStatistics() {
        System.out.println("Liczba użytkowników: " +  usersQuantity);
        System.out.println("Liczba postów "  + postsQuantity );
        System.out.println("Liczba komentarzy: " +  commentsQuantity);
        System.out.println("Średnia liczba postów na użytkownika: " +  averagePostPerUser);
        System.out.println("Średnia liczba komentarzy na użytkownika: " +  averageCommentsPerUser);
        System.out.println("Średnia liczba komentarzy na post: " +  averageCommentsPerPost);

    }



}
