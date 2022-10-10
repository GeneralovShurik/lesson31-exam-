package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Шифр Цезаря
        // Дана зашифрованная фраза, содержащая в себе только символы английского алфавита в верхнем регистре и знаки пробела.
        // Известно, что в качестве алгоритма шифрования использовался Шифр Цезаря.
        // Расшифруйте заданную фразу, если известно, что для смещения использовался ключ k = 4 со сдвигом вправо.

        // Y -> Z -> A -> B -> C
        System.out.println(shifrTsezarya("NEZE ETTPMGEXMSRW EVI XCTMGEPPC GSQTMPIH XS FCXIGSHI XLEX GER VYR SR ERC NEZE ZMVXYEP QEGLMRI VIKEVHPIWW SJ XLI YRHIVPCMRK GSQTYXIV EVGLMXIGXYVI"));



        //  Умная сортировка
        int[] myList = {-2, -6, -1, 12, 8, 2, 3, -1, 85, -1, 14, 99, 73, 51};
        sort(myList);
        for (int e: myList) {

            System.out.println(e);
        }



       // Камень, ножницы, бумага, 1..2..3!

        Random random = new Random();

        int player1Score = 0;
        int player2Score = 0;

        while (player1Score != 10 && player2Score != 10) {
            File file = new File("results.txt");
            FileWriter fw = new FileWriter("results.txt");
            FileReader fr = new FileReader("results.txt");
            Thread player1 = new Thread(() -> {
                synchronized (fw) {
                    String string = "";
                    int rand = random.nextInt(3) + 1;
                    if (rand == 1) {
                        string = "P";
                    }
                    if (rand == 2) {
                        string = "S";
                    }
                    if (rand == 3) {
                        string = "R";
                    }
                    try {
                        fw.write("1" + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread player2 = new Thread(() -> {
                synchronized (fw) {
                    String string = "";
                    int rand = random.nextInt(3) + 1;
                    if (rand == 1) {
                        string = "P";
                    }
                    if (rand == 2) {
                        string = "S";
                    }
                    if (rand == 3) {
                        string = "R";
                    }
                    try {
                        fw.write("2" + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            player1.start();
            player1.join();
            player2.start();
            player2.join();

            fw.flush();
            fw.close();

            char[] chars = new char[4];
            fr.read(chars);
            fr.close();
            System.out.println(chars);

            if (chars[0] == '1') {
                if (chars[1] == 'P' && chars[3] == 'S') {
                    player2Score++;
                }
                if (chars[1] == 'S' && chars[3] == 'P') {
                    player1Score++;
                }
                if (chars[1] == 'S' && chars[3] == 'R') {
                    player2Score++;
                }
                if (chars[1] == 'R' && chars[3] == 'S') {
                    player1Score++;
                }
                if (chars[1] == 'P' && chars[3] == 'R') {
                    player1Score++;
                }
                if (chars[1] == 'R' && chars[3] == 'P') {
                    player2Score++;
                }
            }
            if (chars[0] == '2') {
                if (chars[1] == 'P' && chars[3] == 'S') {
                    player1Score++;
                }
                if (chars[1] == 'S' && chars[3] == 'P') {
                    player2Score++;
                }
                if (chars[1] == 'S' && chars[3] == 'R') {
                    player1Score++;
                }
                if (chars[1] == 'R' && chars[3] == 'S') {
                    player2Score++;
                }
                if (chars[1] == 'P' && chars[3] == 'R') {
                    player1Score++;
                }
                if (chars[1] == 'R' && chars[3] == 'P') {
                    player2Score++;
                }
            }
        }
        if (player1Score == 10) {
            System.out.println("Player #1 wins");
            return;
        }
        if (player2Score == 10) {
            System.out.println("Player #2 wins");
        }
    }

    public static String shifrTsezarya (String s){
            int k = 4;
            StringBuilder sb = new StringBuilder(s.length());
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    c -= k;
                    if (c < 'A') {
                        c += 26;
                    }
                }
                sb.append(c);
            }
            return sb.toString();
        }

        public static void sort (int [] myList){
            for (int i = 0; i < myList.length - 1; i++) {
                if(myList [i] != -1) {
                    for (int j = i + 1; j < myList.length; j++) {

                        if (myList[i] > myList[j] && myList[j] != -1) {
                            int temp = myList[i];
                            myList[i] = myList[j];
                            myList[j] = temp;
                        }
                    }
                }
        }
    }
}













