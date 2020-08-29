public class Manual {
    public static void lexioManual() {
        // num of players
        System.out.println("[NUMBER OF PLAYERS]\n"
                        + "                |  Three  |  Four  |  Five  |\n"
                        + "================|=========|========|========|\n"
                        + " Tile Range     |  1 ~ 9  | 1 ~ 13 | 1 ~ 15 |\n"
                        + "----------------|---------|--------|--------|\n"
                        + " Num. of Tiles  |    12   |   13   |   12   |\n");
        // tiles
        System.out.println("[TILES]\n"
                        + LexioSymbol.SUN.getImg() + "  > " + LexioSymbol.MOON.getImg() + "  > " + LexioSymbol.STAR.getImg() + "  > " + LexioSymbol.CLOUD.getImg() + "\n"
                        + LexioSymbol.SUN.getImg() + "\t2 > 1 > 15 > 14 > 13 > 12 > ... > 3\n"
                        + LexioSymbol.MOON.getImg() + "\t2 > 1 > 15 > 14 > 13 > 12 > ... > 3\n"
                        + LexioSymbol.STAR.getImg() + "\t2 > 1 > 15 > 14 > 13 > 12 > ... > 3\n"
                        + LexioSymbol.CLOUD.getImg() + "\t2 > 1 > 15 > 14 > 13 > 12 > ... > 3\n");
        // combination
        System.out.println("[COMBINATIONS]\n"
                        + "                     ____     ____     ____\n"
                        + "                    | " + LexioSymbol.STAR.getImg() + "  |   | " + LexioSymbol.MOON.getImg() + "  |   | " + LexioSymbol.SUN.getImg() + "  |\n"
                        + "1. Single           | " + LexioSymbol.STAR.getColor() + "10" + LexioSymbol.STAR.getColorEnd() + " | < | " + LexioSymbol.MOON.getColor() + "13" + LexioSymbol.MOON.getColorEnd() + " | < | " + LexioSymbol.SUN.getColor() + "13" + LexioSymbol.SUN.getColorEnd() + " |\n"
                        + "                    |____|   |____|   |____|\n"
                        + "                     ____ ____     ____ ____\n"
                        + "                    | " + LexioSymbol.STAR.getImg() + "  | " + LexioSymbol.MOON.getImg() + "  |   | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |\n"
                        + "2. One Pair         | " + LexioSymbol.STAR.getColor() + "04" + LexioSymbol.STAR.getColorEnd() + " | " + LexioSymbol.MOON.getColor() + "04" + LexioSymbol.MOON.getColorEnd() + " | < | " + LexioSymbol.SUN.getColor() + "11" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "11" + LexioSymbol.CLOUD.getColorEnd() + " |\n"
                        + "                    |____|____|   |____|____|\n"
                        + "                     ____ ____ ____     ____ ____ ____\n"
                        + "                    | " + LexioSymbol.MOON.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |   | " + LexioSymbol.MOON.getImg() + "  | " + LexioSymbol.STAR.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |\n"
                        + "3. Triple           | " + LexioSymbol.MOON.getColor() + "05" + LexioSymbol.MOON.getColorEnd() + " | " + LexioSymbol.SUN.getColor() + "05" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "05" + LexioSymbol.CLOUD.getColorEnd() + " | < | " + LexioSymbol.MOON.getColor() + "07" + LexioSymbol.MOON.getColorEnd() + " | " + LexioSymbol.STAR.getColor() + "07" + LexioSymbol.STAR.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "07" + LexioSymbol.CLOUD.getColorEnd() + " |\n"
                        + "                    |____|____|____|   |____|____|____|\n"
                        + "                     ____ ____ ____ ____ ____\n"
                        + "                    | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.MOON.getImg() + "  | " + LexioSymbol.STAR.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.MOON.getImg() + "  |\n"
                        + "4. Straight         | " + LexioSymbol.SUN.getColor() + "01" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.MOON.getColor() + "02" + LexioSymbol.MOON.getColorEnd() + " | " + LexioSymbol.STAR.getColor() + "03" + LexioSymbol.STAR.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "04" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.MOON.getColor() + "05" + LexioSymbol.MOON.getColorEnd() + " |\n"
                        + "                    |____|____|____|____|____|\n"
                        + "                     ____ ____ ____ ____ ____\n"
                        + "                    | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  |\n"
                        + "5. Flush            | " + LexioSymbol.SUN.getColor() + "01" + LexioSymbol.SUN.getColorEnd() +" | " + LexioSymbol.SUN.getColor() + "15" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.SUN.getColor() + "13" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.SUN.getColor() + "06" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.SUN.getColor() + "03" + LexioSymbol.SUN.getColorEnd() + " |\n"
                        + "                    |____|____|____|____|____|\n"
                        + "                     ____ ____ ____ ____ ____\n"
                        + "                    | " + LexioSymbol.MOON.getImg() + "  | " + LexioSymbol.STAR.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.STAR.getImg() + "  |\n"
                        + "6. Full House       | " + LexioSymbol.MOON.getColor() + "08" + LexioSymbol.MOON.getColorEnd() + " | " + LexioSymbol.STAR.getColor() + "08" + LexioSymbol.STAR.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "08" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.SUN.getColor() + "03" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.STAR.getColor() + "03" + LexioSymbol.STAR.getColorEnd() + " |\n"
                        + "                    |____|____|____|____|____|\n"
                        + "                     ____ ____ ____ ____     ____\n"
                        + "                    | " + LexioSymbol.SUN.getImg() + "  | " + LexioSymbol.STAR.getImg() + "  | " + LexioSymbol.MOON.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |   | " + LexioSymbol.CLOUD.getImg() + "  |\n"
                        + "7. Four Card        | " + LexioSymbol.SUN.getColor() + "15" + LexioSymbol.SUN.getColorEnd() + " | " + LexioSymbol.STAR.getColor() + "15" + LexioSymbol.STAR.getColorEnd() + " | " + LexioSymbol.MOON.getColor() + "15" + LexioSymbol.MOON.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "15" + LexioSymbol.CLOUD.getColorEnd() + " | + | " + LexioSymbol.CLOUD.getColor() + "10" + LexioSymbol.CLOUD.getColorEnd() + " |\n"
                        + "                    |____|____|____|____|   |____|\n"
                        + "                     ____ ____ ____ ____ ____\n"
                        + "                    | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |\n"
                        + "8. Straight Flush   | " + LexioSymbol.CLOUD.getColor() + "05" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "06" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "07" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "08" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "09" + LexioSymbol.CLOUD.getColorEnd() + " |\n"
                        + "                    |____|____|____|____|____|");
        
        Screen.clear();
        Screen.pause();
        
        // game rules
        System.out.println("[GAME RULES]\n"
                        + "1. Shuffle every tile randomly.\n"
                        + "2. Distribute tiles and chips and do not show them to the other players.\n"
                        + "3. The player who has " + LexioSymbol.CLOUD.getImg() + LexioSymbol.CLOUD.getColor() + " 3" + LexioSymbol.CLOUD.getColorEnd() + " begins first.\n"
                        + "    - " + LexioSymbol.CLOUD.getImg() + LexioSymbol.CLOUD.getColor() + " 3" + LexioSymbol.CLOUD.getColorEnd() + " card is not required to be hand-in for the first turn.\n"
                        + "    - First player can choose any combination/number of tiles.\n"
                        + "4. Next player should hand-in the same number of tiles with stronger combination.\n"
                        + "5. If player has no tiles or is not willing to hand-in, player can 'PASS'.\n"
                        + "    - Even if you 'PASS' previously, you are allowed to play when the turn makes it back around to you.\n"
                        + "    - 'PASS' is not permanent.\n"
                        + "6. If all other players announce 'PASS', the last player will become the first player.\n"
                        + "7. The round ends immediately when at least one of the player has no more tile left.\n"
                        + "8. Calculate the score.\n");
        // calculating score
        System.out.println("[CALCULATING SCORE]\n"
                        + "Number of chips per player: 64\n"
                        + "1st place: Recieves chips from every player for each remaining tile count.\n"
                        + "2nd place: Recieves chips from 3rd, 4th, 5th players for each tile difference.\n"
                        + "3rd place: Recieves chips from 4th, 5th players for each tile difference.\n"
                        + "4th place: Recieves chips from 5th player for tile difference.\n"
                        + "5th place: Next Chance.\n"
                        + "However, if you have the tile with number 2 at the end, you lose chips TWICE of your tiles.\n");
        // how to do
        System.out.println("[HOW TO DO]\n"
                        + "HAND-IN: input the indices of the wanted tiles.\n"
                        + "    e.g. if " + LexioSymbol.CLOUD.getImg() + LexioSymbol.CLOUD.getColor() + " 5, 6, 8" + LexioSymbol.CLOUD.getColorEnd() + " wanted:\n"
                        + "     ____ ____ ____ ____ ____\n"
                        + "    | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  | " + LexioSymbol.CLOUD.getImg() + "  |\n"
                        + "    | " + LexioSymbol.CLOUD.getColor() + "05" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "06" + LexioSymbol.CLOUD.getColorEnd() +" | " + LexioSymbol.CLOUD.getColor() + "07" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "08" + LexioSymbol.CLOUD.getColorEnd() + " | " + LexioSymbol.CLOUD.getColor() + "09" + LexioSymbol.CLOUD.getColorEnd() + " |\n"
                        + "    |____|____|____|____|____|\n"
                        + "        0    1    2    3    4\n"
                        + "    >>> 0 1 3                       <--- input\n\n"
                        + "PASS: input one of these words - PASS, Pass, pass, P, p\n"
                        + "    e.g.\n"
                        + "    >>> PASS\n");
    }
}