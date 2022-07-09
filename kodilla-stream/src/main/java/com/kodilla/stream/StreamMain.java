package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer,ForumUser> theResultMapOfUsers = forum.getUserList().stream()
                .filter(user->user.getSex()=='M')
                .filter(date->
                        (date.getYearOfBirth() <= new Date().getYear()+2001-122)    ||
                        (  (date.getYearOfBirth() == new Date().getYear()+2002-122) &&
                           (date.getMonthOfBirth() <= new Date().getMonth()+1)    ) ||
                        (  ((date.getYearOfBirth() == new Date().getYear()+2002-122) &&
                           (date.getMonthOfBirth() == new Date().getMonth()+1 ))  &&
                           (date.getDayOfBirth() <= new Date().getDate() ) )  )
                .filter(posts->posts.getPostsQuantity()>=1)
                .collect(Collectors.toMap(ForumUser::getID,forumuser->forumuser));

        theResultMapOfUsers.entrySet().stream()
                .map(entry->entry.getKey()+" -> "+entry.getValue()).forEach(System.out::println);





    }
}
