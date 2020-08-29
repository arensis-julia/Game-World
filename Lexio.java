import java.io.*;
import java.util.*;

public class Lexio extends Game {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<LexioPlayer> players = new ArrayList<LexioPlayer>();
    private ArrayList<LexioTile> deck = new ArrayList<LexioTile>();
    private int playerNum;
    private int maxTileNum;
    private int maxTileRange;

    /* INITIALIZING */

    public void initialize(User... user) {
        for(int i=0; i<user.length; i++) {
            users.add(user[i]);
            LexioPlayer p = new LexioPlayer(user[i], false);
            players.add(p);
        }

        playerNum = 0;
		maxTileNum = 0;
		maxTileRange = 0;
    }

    void createComputers() {
        int size = players.size();
        for(int i=0; i<=playerNum - size; i++) {
            User comp = new User();
            comp.setId("Computer-" + i);
            LexioPlayer c = new LexioPlayer(comp, true);
            players.add(c);
        }
    }

    void createDeck() {
        if(playerNum == 3) {
            maxTileNum = 12;
            maxTileRange = 9;
        }
        else if(playerNum == 4) {
            maxTileNum = 13;
            maxTileRange = 13;
        }
        else {
            maxTileNum = 12;
            maxTileRange = 15;
        }

        for(int i=1; i<=maxTileRange; i++) {
            for(LexioSymbol s : LexioSymbol.values())
                deck.add(new LexioTile(s, i));
        }

        Collections.shuffle(deck);
    }

    void distributeDeck() {
        for(int i=0; i<playerNum; i++) {
            for(int j=0; j<maxTileNum; j++)
                players.get(i).addHands(deck.get(i * maxTileNum + j));
            players.get(i).setHands(players.get(i).getHands());
        }
    }

    /* INTERFACE */

    String mergeString(String a, String b, String delim) {
        String[] aList = a.split("\\n");
        String[] bList = b.split("\\n");
        String[] combinedList = new String[aList.length];
        for(int i=0; i<combinedList.length; i++)    combinedList[i] = aList[i] + delim + bList[i];
        
        return String.join("\n", combinedList);
    }

    String showTiles(ArrayList<LexioTile> tiles) {
        String str = "";

        for(int i=0; i<tiles.size(); i++)   str += " ____";
        str += " \n|";
        for(int i=0; i<tiles.size(); i++)   str += " " + tiles.get(i).getSymbol().getImg() + "  |";
        str += "\n|";
        for(int i=0; i<tiles.size(); i++)   str += " " + tiles.get(i).getSymbol().getColor() + String.format("%02d", tiles.get(i).getNum()) + tiles.get(i).getSymbol().getColorEnd() + " |";
        str += "\n|";
        for(int i=0; i<tiles.size(); i++)   str += "____|";

        return str;
    }

    String showPlayerInfo(LexioPlayer currentPlayer) {
        String playerInfo = "";

        playerInfo += " ___________________________________ \n"
                    + "|                                   |\n" 
                    + "|             [PLAYERS]             |\n" 
                    + "|                                   |\n";

        for(int i=0; i<playerNum; i++) {
            LexioPlayer p = players.get(i);
            int handsSize = players.get(i).getHands().size();

            if(players.get(i) == currentPlayer)     continue;
            playerInfo += "| [" + p.getUser().getId() + ": " + p.getChips() + "]";
            for(int j=0; j<30-p.getUser().getId().length()-Integer.toString(p.getChips()).length(); j++)  playerInfo += " ";
            
            playerInfo += "|\n| ";
            for(int j=0; j<handsSize; j++)       playerInfo += " _";
            for(int j=handsSize*2+1; j<35; j++)  playerInfo += " ";
            playerInfo += "|\n| ";
            for(int j=0; j<handsSize; j++)       playerInfo += "|_";
            playerInfo += "| : " + handsSize;
            for(int j=handsSize*2+5+Integer.toString(handsSize).length(); j<35; j++)    playerInfo += " ";
            playerInfo += "|\n";
            
            playerInfo += "|                                   |\n";
        }

        for(int i=playerNum; i < 5; i++)
            playerInfo += "|                                   |\n"
                        + "|                                   |\n"
                        + "|                                   |\n"
                        + "|                                   |\n";

        playerInfo += "|___________________________________|\n";

        return playerInfo;
    }

    String showCombinationInfo() {
        String combiInfo = "";

        combiInfo += " ____________________________________________________\n"
                    + "|                                                    |\n"
                    + "|                   [COMBINATION]                    |\n"
                    + "|                                                    |\n"
                    + "| SINGLE            " + LexioSymbol.CLOUD.getColor() + "13" + LexioSymbol.CLOUD.getColorEnd() + " < " + LexioSymbol.STAR.getColor() + "13" + LexioSymbol.STAR.getColorEnd() + " < " + LexioSymbol.MOON.getColor() + "13" + LexioSymbol.MOON.getColorEnd() + " < " + LexioSymbol.SUN.getColor() + "13" + LexioSymbol.SUN.getColorEnd() + "                |\n"
                    + "|                                                    |\n"
                    + "| PAIR              " + LexioSymbol.STAR.getColor() + "4 " + LexioSymbol.MOON.getColor() + "4" + LexioSymbol.MOON.getColorEnd() + " < " + LexioSymbol.SUN.getColor() + "11 " + LexioSymbol.CLOUD.getColor() + "11" + LexioSymbol.CLOUD.getColorEnd() + "                      |\n"
                    + "|                                                    |\n"
                    + "| TRIPLE            " + LexioSymbol.MOON.getColor() + "5" + LexioSymbol.SUN.getColor() + " 5 " + LexioSymbol.CLOUD.getColor() + "5" + LexioSymbol.CLOUD.getColorEnd() + " < " + LexioSymbol.MOON.getColor() + "7 " + LexioSymbol.STAR.getColor() + "7 " + LexioSymbol.CLOUD.getColor() + "7" + LexioSymbol.CLOUD.getColorEnd() + "                    |\n"
                    + "|                                                    |\n"
                    + "| STRAIGHT          " + LexioSymbol.SUN.getColor() + "1 " + LexioSymbol.MOON.getColor() + "2 " + LexioSymbol.STAR.getColor() + "3 " + LexioSymbol.CLOUD.getColor() + "4 " + LexioSymbol.MOON.getColor() + "5" + LexioSymbol.MOON.getColorEnd() + "                        |\n"
                    + "|                                                    |\n"
                    + "| FLUSH             " + LexioSymbol.SUN.getColor() + "1 15 13 6 3" + LexioSymbol.SUN.getColorEnd() + "                      |\n"
                    + "|                                                    |\n"
                    + "| FULL HOUSE        " + LexioSymbol.MOON.getColor() + "8 " + LexioSymbol.STAR.getColor() + "8 " + LexioSymbol.CLOUD.getColor() + "8" + LexioSymbol.SUN.getColor() + " 3 " + LexioSymbol.STAR.getColor() + "3" + LexioSymbol.STAR.getColorEnd() + "                        |\n"
                    + "|                                                    |\n"
                    + "| FOUR CARD         " + LexioSymbol.SUN.getColor() + "15 " + LexioSymbol.STAR.getColor() + "15 " + LexioSymbol.MOON.getColor() + "15 " + LexioSymbol.CLOUD.getColor() + "15 10" + LexioSymbol.CLOUD.getColorEnd() + "                   |\n"
                    + "|                                                    |\n"
                    + "| STRAIGHT FLUSH    " + LexioSymbol.CLOUD.getColor() + "5 6 7 8 9" + LexioSymbol.CLOUD.getColorEnd() + "                        |\n"
                    + "|                                                    |\n"
                    + "|____________________________________________________|\n";

        return combiInfo;
    }

    void showUserScreen(LexioPlayer currentPlayer, LexioTileCombination lastCombi) {
        System.out.println("                         ///\n"
                        + "                        ///      /////// \\\\\\  ///     /////   ///////\n"
                        + "                       ///      ///       \\\\\\///      ///    //   //\n"
                        + "                      ///      ///////     \\|//      ///    //   //\n"
                        + "                     ///      ///         //|\\\\     ///    //   //\n"
                        + "                    ///////  ///////     /// \\\\\\  /////   ///////\n"
                        + "                                              \\\\\\");
        
        String description = mergeString(showPlayerInfo(currentPlayer), showCombinationInfo(), "");
        System.out.println(description);

        Collections.sort(currentPlayer.getHands());
        ArrayList<LexioTile> curHands = currentPlayer.getHands();

        if(lastCombi == null) {
            System.out.println("\n[YOU: " + currentPlayer.getChips() + "]");
            String delim = "                              ";
            System.out.printf(showTiles(curHands));
            System.out.println();
            for(int i=0; i<curHands.size(); i++)    System.out.print("    " + i);
            System.out.print("\n\n");
        }

        else {
            System.out.println("\n[LAST COMBINATION]            [YOU: " + currentPlayer.getChips() + "]");
            String delim = "";
            for(int i=0; i<5*(6-lastCombi.getCombination().size())-1; i++)  delim += " ";
            System.out.printf(mergeString(showTiles(lastCombi.getCombination()), showTiles(curHands), delim));
            System.out.println();
            for(int i=0; i<30; i++)     System.out.print(" ");
            for(int i=0; i<curHands.size(); i++)    System.out.print("    " + i);
        }

        System.out.print("\n\n");
    }


    /* UTILS */

    int defineCombinationRank(ArrayList<LexioTile> c) {
        int rank = -1;

        // single
        if(c.size() == 1)   rank = 0;
        
        // pair
        else if((c.size() == 2) && (c.get(0).getNum() == c.get(1).getNum()))     rank = 1;

        // triple
        else if((c.size() == 3) && (c.get(0).getNum() == c.get(1).getNum()) && (c.get(0).getNum() == c.get(2).getNum()))    rank = 2;

        else if(c.size() == 5) {
            Collections.sort(c);
            LexioTile tmp0 = c.get(0);
            LexioTile tmp1 = c.get(1);
            LexioTile tmp2 = c.get(2);
            LexioTile tmp3 = c.get(3);
            LexioTile tmp4 = c.get(4);

            // four card
            if((tmp1.getNum() == tmp2.getNum()) && (tmp2.getNum() == tmp3.getNum()) && ((tmp0.getNum() == tmp1.getNum()) || (tmp3.getNum() == tmp4.getNum())))          rank = 6;

            // full house
            else if((tmp0.getNum() == tmp1.getNum()) && (tmp3.getNum() == tmp4.getNum()) && ((tmp0.getNum() == tmp2.getNum()) || (tmp4.getNum() == tmp2.getNum())))     rank = 5;

            // flush
            else if((tmp0.getSymbol() == tmp1.getSymbol()) && (tmp1.getSymbol() == tmp2.getSymbol()) && (tmp2.getSymbol() == tmp3.getSymbol()) && (tmp3.getSymbol() == tmp4.getSymbol())) {
                // straight flush
                if((tmp0.getNum()+1 == tmp1.getNum()) && (tmp1.getNum()+1 == tmp2.getNum()) && (tmp2.getNum()+1 == tmp3.getNum()) && (tmp3.getNum()+1 == tmp4.getNum()))    rank = 7;
                else    rank = 4;
            }
            
            // straight
            if((tmp0.getNum()+1 == tmp1.getNum()) && (tmp1.getNum()+1 == tmp2.getNum()) && (tmp2.getNum()+1 == tmp3.getNum()) && (tmp3.getNum()+1 == tmp4.getNum()))        rank = 3;
        }

        // not a combination
        else    rank = -1;

        return rank;
    }

    void calculateScore() {
        Collections.sort(players);

        // 1st place
        for(int i=1; i<playerNum; i++) {
            int chip = players.get(i).getChips();
            if(players.get(i).getHands().get(0).getNum() == 2)      chip *= 2;
            players.get(0).addChips(chip);
            players.get(i).removeChips(chip);
        }

        // 2nd place
        for(int i=2; i<playerNum; i++) {
            int chip = players.get(i).getChips() - players.get(1).getChips();
            if(players.get(i).getHands().get(0).getNum() == 2)      chip *= 2;
            players.get(1).addChips(chip);
            players.get(i).removeChips(chip);
        }

        // 3rd place
        for(int i=3; i<playerNum; i++) {
            int chip = players.get(i).getChips() - players.get(2).getChips();
            if(players.get(i).getHands().get(0).getNum() == 2)      chip *= 2;
            players.get(2).addChips(chip);
            players.get(i).removeChips(chip);
        }

        // 4th place
        if(playerNum > 3) {
            for(int i=4; i<playerNum; i++) {
                int chip = players.get(i).getChips() - players.get(3).getChips();
                if(players.get(i).getHands().get(0).getNum() == 2)      chip *= 2;
                players.get(3).addChips(chip);
                players.get(i).removeChips(chip);
            }
        }
    }


    /* COMPUTER */

    void checkCombination(ArrayList<LexioTileCombination> possibleCombi, ArrayList<ArrayList<LexioTile>> tmpCombi, LexioTileCombination lastCombi) {
        ArrayList<LexioTile> lc = null;
        int lcRank = -1;

        if(lastCombi != null) {
            lc = lastCombi.getCombination();
            lcRank = lastCombi.getRank().ordinal();
        }

        for(int i=0; i<tmpCombi.size(); i++) {
            ArrayList<LexioTile> c = tmpCombi.get(i);
            int cRank = defineCombinationRank(c);
            Collections.sort(c);

            if(cRank == -1)     continue;

            // single
            else if(cRank == 0) {
                if((lcRank < 0) || (c.get(0).compareTo(lc.get(0)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.SINGLE));
            }
            
            // pair
            else if(cRank == 1) {
                if((lcRank < 1) || (c.get(1).compareTo(lc.get(1)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.PAIR));
            }
            
            // triple
            else if(cRank == 2) {
                if((lcRank < 2) || (c.get(2).compareTo(lc.get(2)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.TRIPLE));
            }
            
            // four card
            else if(cRank == 6) {
                if((lcRank < 6) || (c.get(2).compareTo(lc.get(2)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.FOURCARD));
            }

            // full house
            else if(cRank == 5) {
                if((lcRank < 5) || (c.get(2).compareTo(lc.get(2)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.FULLHOUSE));
            }

            // flush
            else if(cRank == 4) {
                if((lcRank < 4) || (c.get(4).compareTo(lc.get(4)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.FLUSH));
            }
            
            // straight
            else if(cRank == 3) {
                if((lcRank < 3) || (c.get(4).compareTo(lc.get(4)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.STRAIGHT));
            }

            // straight flush
            else if(cRank == 7) {
                if((lcRank < 7) || (c.get(4).compareTo(lc.get(4)) == 1))    possibleCombi.add(new LexioTileCombination(c, LexioRank.STRAIGHTFLUSH));
            }
        }
    }

    void generateCombination(ArrayList<ArrayList<LexioTile>> tmpCombi, ArrayList<LexioTile> hands, boolean[] visited, int start, int n, int r) {      // nCr
        if(r == 0) {
            ArrayList<LexioTile> c = new ArrayList<LexioTile>();
            for(int i=0; i<hands.size(); i++) {
                if(visited[i] == true)
                    c.add(hands.get(i));
            }
            tmpCombi.add(c);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            generateCombination(tmpCombi, hands, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

    ArrayList<LexioTileCombination> getPossibleCombination(ArrayList<LexioTile> hands, LexioTileCombination lastCombi) {
        int[] combiNum = { 1, 2, 3, 5 };    // number of tiles for every combinations
        ArrayList<LexioTileCombination> possibleCombi = new ArrayList<LexioTileCombination>();
        ArrayList<ArrayList<LexioTile>> tmpCombi = new ArrayList<ArrayList<LexioTile>>();

        for(int i=0; i<4; i++) {
            if(lastCombi.getCombination().size() > combiNum[i])  continue;
            boolean[] visited = new boolean[i];
            generateCombination(tmpCombi, hands, visited, 0, hands.size(), combiNum[i]);
        }
        checkCombination(possibleCombi, tmpCombi, lastCombi);

        return possibleCombi;
    }

    LexioTileCombination computerDecision(LexioPlayer computer, LexioTileCombination lastCombi) {
        ArrayList<LexioTileCombination> possibleCombi = getPossibleCombination(computer.getHands(), lastCombi);
        if(possibleCombi.size() == 0)   return null;
        
        Random rand = new Random(possibleCombi.size() + 1);
        int idx = rand.nextInt();
        if(idx == possibleCombi.size())     return null;
        else    return possibleCombi.get(idx);
    }


    /* GAME PLAY */

    public void run(User... user) {
        LexioPlayer currentPlayer;
        LexioPlayer lastPlayer;
        LexioPlayer nextPlayer;
        LexioTileCombination lastCombi = null;
        int passCount = 0;
        Scanner scan = new Scanner(System.in);

        initialize(user);
        
        while(true) {
            System.out.print("How Many players do you want? Choose between 3 and 5.\n>>> ");
            playerNum = scan.nextInt();
            if(playerNum < 3 || playerNum > 5)      System.out.print("Invalid value! Try again.\n>>> ");
            else    break;
        }

        createComputers();
        createDeck();
        distributeDeck();

        Screen.clear();

        currentPlayer = players.get(0);
        lastPlayer = currentPlayer;
        while(true) {
            // computer
            if(currentPlayer.isComputer) {
                LexioTileCombination combi = computerDecision(currentPlayer, lastCombi);
                if(combi != null) {
                    System.out.println(currentPlayer.getUser().getId() + " card's combination is: " + combi.getRank().name());
                    System.out.println(showTiles(combi.getCombination()));
                    for(int i=0; i<combi.getCombination().size(); i++)   currentPlayer.removeHands(combi.getCombination().get(i));
                    lastCombi = combi;
                    lastPlayer = currentPlayer;
                    passCount = 0;
                }
                else {
                    System.out.println(currentPlayer.getUser().getId() + " PASS");
                    passCount += 1;
                }
            }

            // human
            else {
                showUserScreen(currentPlayer, lastCombi);

                // get combination
                System.out.print("Choose indices for your combination.\n>>> ");
                LexioTileCombination combi = null;
                while(true) {
                    String input = scan.nextLine();
                    if(input == "PASS" || input == "Pass" || input == "pass" || input == "P" || input == "p") {
                        if(lastPlayer == currentPlayer)     System.out.print("[ERROR] You are the first player!\n>>> ");
                        else {
                            passCount += 1;
                            break;
                        }
                    }
                    else if(input == null)  System.out.print("[ERROR] Invalid Combination! Try again.\n>>> ");
                    else {
                        String[] idxString = input.split(" ");
                        if(idxString.length == 0 || idxString.length == 4 || idxString.length > 5)    System.out.print("[ERROR] Invalid input! Try again.\n>>> ");
                        else {
                            int[] idx = new int[idxString.length];
                            ArrayList<LexioTile> c = null;
                            
                            for(int i=0; i<idxString.length; i++)   idx[i] = Integer.parseInt(idxString[i]);
                            for(int i=0; i<idx.length; i++)         c.add(currentPlayer.getHands().get(i));
                            
                            int rank = defineCombinationRank(c);
                            if(rank < -1)   System.out.print("[ERROR] Invalid Combination! Try again.\n>>> ");
                            else if(lastCombi.getRank().ordinal() != rank)  System.out.print("[ERROR] Your combination does not match with the last combination! Try again\n>>> ");
                            else {
                                passCount = 0;
                                combi.setCombination(c);
                                combi.setRank(LexioRank.values()[rank]);
                                for(int i=0; i<c.size(); i++)   currentPlayer.removeHands(c.get(i));
                            }
                        }
                    }
                }

                lastCombi = combi;
                lastPlayer = currentPlayer;

                if(passCount == playerNum - 1)  System.out.println("Now, you are the first player. Choose any combination you like.\n>>> ");
                
                Screen.clear();
            }

            // next player
            if(passCount == playerNum - 1) {
                lastCombi = null;
                lastPlayer = currentPlayer;
                nextPlayer = currentPlayer;
            }
            else    nextPlayer = players.get(players.indexOf(currentPlayer) + 1);

            // game end
            if(currentPlayer.getHands().size() == 0) {
                calculateScore();
                Screen.clear();
                System.out.println("=============================== SCORE ===============================");
                for(int i=0; i<playerNum; i++) {
                    System.out.println(" " + players.get(i).getUser().getId() + " : " + players.get(i).getChips());
                    if(!players.get(i).isComputer) {
                        players.get(i).getUser().setScore(players.get(i).getChips());
                    }
                }
                System.out.println("=====================================================================");
                break;
            }
        }
    }
}