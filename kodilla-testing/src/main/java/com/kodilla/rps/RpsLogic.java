package com.kodilla.rps;

public class RpsLogic {
    // 0 = Draw, 1 = Player wins, 2 = Computer wins
    public static int determineWinner(int playerMove,int computerMove){
        if (playerMove == computerMove){
            return 0;
        }
        // Winning conditions for the player:
        // 1 (Rock) beats 3 (Scissors)
        // 2 (Paper) beats 1 (Rock)
        // 3 (Scissors) beats 2 (Paper)
        if ((playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2)) {
            return 1;
        }
        return 2;
    }
}
