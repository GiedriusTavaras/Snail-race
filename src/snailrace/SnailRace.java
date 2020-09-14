/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snailrace;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tavar
 */
public class SnailRace {
//    

    public static class Snail extends Thread {

        private String pav;
        int distance;
        int speed;

        public Snail(String pav, int speed) {
            this.pav = pav;
            this.distance = 0;
            this.speed = speed;
        }

        public void run() {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            LocalTime x = java.time.LocalTime.now();
            System.out.println(pav + " started the race at the time: " + x);
            int trackLength = 100;
            int checkPointPassed = 1;
            for (int i = 0; i <= 1000; i++) {
                distance += speed;
                System.out.println(pav + " distance = " + distance);
                if (Math.round(Math.random() * 5) >= 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SnailRace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (checkPointPassed * 30 <= distance) {
                    System.out.println(pav + " has passed the " + checkPointPassed + "th check point at distance = " + distance + " and at the time: " + java.time.LocalTime.now());
                    checkPointPassed++;
                } else if (distance >= 100) {
                    LocalTime z = java.time.LocalTime.now();
                    Date date2 = new Date();
                    int time = (int) (date2.getTime() - date.getTime());
                    System.out.println(pav + "------------------ finished ---------------------- at the time : " + z);
                    System.out.println(time + " milliseconds" + " is " + pav + "'s " + " = total race time! ! !");
                    break;
                }
//                for (int k = 0; k < 8 - 1; k++) {
//                    for (int j = k + 1; j < 8; j++) {
//                        if (time[k] > time[j]) {
//                            int t = time[j];
//                            time[j] = t;
//                        }
//                    }
//
//                }
            }

        }

    


}

    public static void main(String[] args) {
        Snail a = new Snail("Bob", (int) Math.round(Math.random() * 5 + 1));
        Snail b = new Snail("Fred", (int) Math.round(Math.random() * 5 + 1));
        Snail c = new Snail("Mihkel", (int) Math.round(Math.random() * 5 + 1));
        Snail d = new Snail("Joe", (int) Math.round(Math.random() * 5 + 1));
        Snail e = new Snail("Ell", (int) Math.round(Math.random() * 5 + 1));
        Snail f = new Snail("Garry", (int) Math.round(Math.random() * 5 + 1));
        Snail g = new Snail("Shreck", (int) Math.round(Math.random() * 5 + 1));
        Snail h = new Snail("Morty", (int) Math.round(Math.random() * 5 + 1));

        Snail[] SnailRace = {a, b, c, d, e, f, g, h};

        for (int i = 0; i < SnailRace.length; i++) {
            SnailRace[i].start();
        }
    }

}
