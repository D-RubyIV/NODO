package org.example.part2.Static;

import java.util.List;

public final class Const {
    private String subject;
    private List<Web> webList;



    public Const(String subject) {
        this.subject = subject;
    }

    public class Web{
        public String web = "Web1";
        public String web2 = "Web2";

    }

    public void print(){
        System.out.println(subject);
//        System.out.println(Web.web);

    }


}
