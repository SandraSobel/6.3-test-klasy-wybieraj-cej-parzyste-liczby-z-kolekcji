package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();
    public Forum(){
        theForumUserList.add(new ForumUser(1001,"user1",'M',1995,10,5,0));
        theForumUserList.add(new ForumUser(1002,"user2",'F',1998,9,16,7));
        theForumUserList.add(new ForumUser(1004,"user3",'M',1999,2,2,2));
        theForumUserList.add(new ForumUser(1005,"user4",'F',2002,4,28,0));
        theForumUserList.add(new ForumUser(1006,"user5",'M',2001,11,12,4));
        theForumUserList.add(new ForumUser(1007,"user6",'F',1993,12,18,5));
        theForumUserList.add(new ForumUser(1008,"user7",'M',1991,3,31,1));

    }
    public List<ForumUser> getUserList() {
       return new ArrayList<>(theForumUserList);
    }
}
