package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
   try(Scanner scanner = new Scanner(System.in)){
       RpsGame rpsGame = new RpsGame(scanner);
       rpsGame.start();
   }
    }
}
