package net.theothervc.jgame.util;

public class Algorithms {

    public static int euclid(int a, int b) {
        if (a==0) {
            return b;
        }
        return euclid(b%a,a);
    }

}
