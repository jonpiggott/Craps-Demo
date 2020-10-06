/**
 * @author Jon Piggott
 * Unit 4 - Chapter 3 - Problem 1
 * This is a program designed to simulate games of craps. The program will take two "dice
 * rolls" and compare them to the rules of the game of craps and attribute wins and losses
 * accordingly. It will display the wins and losses and the probability of winning.
 */

import java.util.Random;

public class CrapsGame {
        public static void main(String[] args) {

                Random randNum =  new Random();
                int range = 6;

                double wins = 0;
                double losses = 0;
                int rollTotal;
                int point;

                for(int count = 0; count < 10000; count++) {

                        int dice1 = randNum.nextInt(range) + 1;
                        int dice2 = randNum.nextInt(range) + 1;

                        int comeOutRoll = dice1 + dice2;

                        if (comeOutRoll == 7 || comeOutRoll == 11) {
                                wins++;
                        } else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
                                losses++;
                        } else {
                                do
                                {
                                        point = comeOutRoll;
                                        int dice3 = randNum.nextInt(range) + 1;
                                        int dice4 = randNum.nextInt(range) + 1;
                                        rollTotal = dice3 + dice4;

                                        if (rollTotal == point) {
                                                wins++;
                                        } else if (rollTotal == 7) {
                                                losses++;
                                        }
                                } while (rollTotal != point && rollTotal != 7);
                        }
                }

                double probability = (wins / (wins + losses)) * 100.00;

                System.out.println("Wins: " + (int)wins + " Losses: " + (int)losses);
                System.out.println("Probability of winning: " + probability + "%");
        }
}
