package org.example.part2.Static;

import static org.example.part2.Static.ImportStatic.*;

public class Main {
    public static void main(String[] args) {
        // Call Static Varible
        System.out.println(StaticVarible.name);
        // Call Static Method
        StaticMethod.callMe();
        // Call Var of Static Class;
//        System.out.println(Const.Web.web);
//        // Call Import Static
//        System.out.println(USER_NAME);
////        System.out.println(PASSWORD);
//           Const.Web s = new Const.Web() ;
//          ;
//        System.out.println( Const.Web.web);
    }
}
