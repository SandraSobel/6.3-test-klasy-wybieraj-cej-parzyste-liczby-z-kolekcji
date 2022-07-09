package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = forum.getUserList().stream()

                .filter(user->user.getSex()=='M')

                .filter(date->(date.getYearOfBirth() < LocalDate.now().getYear()-20)||
                        ((date.getYearOfBirth() == LocalDate.now().getYear()-20)
                                && date.getMonthOfBirth() <= LocalDate.now().getMonthValue())||
                        (date.getYearOfBirth() == LocalDate.now().getYear()-20
                                && date.getMonthOfBirth() == LocalDate.now().getMonthValue()
                                && date.getDayOfBirth() <= LocalDate.now().getDayOfMonth()) )

                .filter(posts->posts.getPostsQuantity()>=1)
                .collect(Collectors.toMap(ForumUser::getID,forumuser->forumuser));

        theResultMapOfUsers.entrySet().stream()
                .map(entry->entry.getKey()+" -> "+entry.getValue()).forEach(System.out::println);





    }
}
