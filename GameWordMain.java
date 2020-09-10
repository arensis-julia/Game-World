import java.io.IOException;
import java.util.*;

enum GameState {
    GAMESTART, LOGINPAGE, MAINMENU, _1PGAMES, _2PGAMES, VIEWMANUAL, GAMEEND, _2PLOGIN   // , VIEWSCORE
}

public class GameWordMain {
    public static Scanner scan = new Scanner(System.in);
    public static GameState gameState = GameState.GAMESTART;
    public static Game game;

    public static void main(String[] args) {
        User player1 = new User();
        User player2 = new User();

        while(true) {
            /* GAME START */
            if(gameState == GameState.GAMESTART) {
                Screen.printStartPage();
                Screen.pause();
                gameState = GameState.LOGINPAGE;
            }

            /* LOGIN PAGE */
            else if(gameState == GameState.LOGINPAGE) {
                player1 = new User();
                player2 = new User();

                while(true) {
                    Screen.clear();
                    Screen.printLogo();
                    System.out.println("1. Login");
                    System.out.println("2. Sign Up");
                    System.out.println("3. Exit");
                    System.out.print(">>> ");
                    int opt = scan.nextInt();
                    // 1. Login
                    if(opt == 1) {
                        Screen.clear();
                        Screen.printLogin();
                        AccountManager.readAccountList();
                        String id = AccountManager.login();
                        if(id == null)     Screen.pause();
                        else {
                            gameState = GameState.MAINMENU;
                            player1.setId(id);
                            break;
                        }
                    }
                    // 2. Sign Up
                    else if(opt == 2) {
                        Screen.clear();
                        Screen.printSignUp();
                        AccountManager.readAccountList();
                        AccountManager.signup();
                        Screen.pause();
                        break;
                    }
                    // 3. Exit
                    else if(opt == 3) {
                        gameState = GameState.GAMEEND;
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            /* MAIN MENU */
            else if(gameState == GameState.MAINMENU) {
                Screen.clear();
                Screen.printLogo();
                System.out.println("Hello " + player1.getId() + ", nice to meet you!");
                System.out.println("Please choose one of the options.");
                System.out.println("1. One Player");
                System.out.println("2. Two Players");
                System.out.println("3. Game Manual");
                System.out.println("4. Logout");
                System.out.println("5. Exit");
                System.out.print(">>> ");

                while(true) {
                    int opt = scan.nextInt();
                    // 1. One Player
                    if(opt == 1) {
                        gameState = GameState._1PGAMES;
                        break;
                    }
                    // 2. Two Players
                    else if(opt == 2) {
                        gameState = GameState._2PLOGIN;
                        break;
                    }
                    // 3. Game Manual
                    else if(opt == 3) {
                        gameState = GameState.VIEWMANUAL;
                        break;
                    }
                    // // Score Board
                    // else if(opt == 4) {
                    //     gameState = GameState.VIEWSCORE;
                    //     break;
                    // }
                    // 4. Logout
                    else if(opt == 4) {
                        gameState = GameState.GAMESTART;
                        break;
                    }
                    // 5. Exit
                    else if(opt == 5) {
                        gameState = GameState.GAMEEND;
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            /* VIEW MANUAL */
            else if(gameState == GameState.VIEWMANUAL) {
                Screen.clear();
                Screen.printLogo();
                System.out.println("Choose one of the game manuals.");
                System.out.println("0. Back");
                System.out.println("1. Lexio");
                System.out.print(">>> ");
                
                while(true) {
                    int opt = scan.nextInt();
                    // 0. Back
                    if(opt == 0) {
                        gameState = GameState.MAINMENU;
                        break;
                    }
                    // 1. Lexio
                    else if(opt == 1) {
                        Screen.clear();
                        Manual.lexioManual();
                        Screen.pause();
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            // /* VIEW SCORE */
            // else if(gameState == GameState.VIEWSCORE) {
            //     Screen.clear();
            //     Screen.printLogo();
            //     System.out.println("Choose one of the game scores.");
            //     System.out.println("0. Back");
            //     System.out.println("1. Lexio");
            //     System.out.print(">>> ");

            //     while(true) {
            //         int opt = scan.nextInt();
            //         // 0. Back
            //         if(opt == 0) {
            //             gameState = GameState.MAINMENU;
            //             break;
            //         }
            //         // 1. Lexio
            //         else if(opt == 1) {
            //             Screen.clear();
            //             Screen.printLexioScoreTitle();
            //             ScoreBoard.printScoreBoard(GameType.LEXIO);
            //             Screen.pause();
            //             break;
            //         }
            //         // error
            //         else    System.out.print("Invalid value! Try again.\n>>> ");
            //     }
            // }

            /* 1P GAMES */
            else if(gameState == GameState._1PGAMES) {
                Screen.clear();
                Screen.printLogo();
                System.out.println("Please choose the game you want to play.");
                System.out.println("0. Back");
                System.out.println("1. Lexio");
                System.out.print(">>> ");
                while(true) {
                    int opt = scan.nextInt();
                    // 0. Back
                    if(opt == 0) {
                        gameState = GameState.MAINMENU;
                        break;
                    }
                    // 1. Lexio
                    else if(opt == 1) {
                        Screen.clear();
                        game = new Lexio();
                        game.run(player1);
                        Screen.pause();
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            /* 2P GAMES */
            else if(gameState == GameState._2PGAMES) {
                Screen.clear();
                Screen.printLogo();
                System.out.println("Please choose the game you want to play.");
                System.out.println("0. Back");
                System.out.println("1. Lexio");
                System.out.print(">>> ");
                while(true) {
                    int opt = scan.nextInt();
                    // 0. Back
                    if(opt == 0) {
                        gameState = GameState.MAINMENU;
                        break;
                    }
                    // 1. Lexio
                    else if(opt == 1) {
                        Screen.clear();
                        game = new Lexio();
                        game.run(player1, player2);
                        Screen.pause();
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            /* 2P LOGIN */
            else if(gameState == GameState._2PLOGIN) {
                while(true) {
                    Screen.clear();
                    Screen.printLogo();
                    System.out.println("1. Player2 Login");
                    System.out.println("2. Player2 Sign Up");
                    System.out.println("3. Exit");
                    System.out.print(">>> ");
                    int opt = scan.nextInt();
                    // 1. Login
                    if(opt == 1) {
                        Screen.clear();
                        Screen.printLogin();
                        AccountManager.readAccountList();
                        String id = AccountManager.login();
                        if(id == null || id == player1.getId())     Screen.pause();
                        else {
                            gameState = GameState._2PGAMES;
                            player2.setId(id);
                            break;
                        }
                    }
                    // 2. Sign Up
                    else if(opt == 2) {
                        Screen.clear();
                        Screen.printSignUp();
                        AccountManager.readAccountList();
                        AccountManager.signup();
                        Screen.pause();
                        break;
                    }
                    // 3. Exit
                    else if(opt == 3) {
                        gameState = GameState.MAINMENU;
                        break;
                    }
                    // error
                    else    System.out.print("Invalid value! Try again.\n>>> ");
                }
            }

            /* GAME END */
            else if(gameState == GameState.GAMEEND) {
                Screen.clear();
                Screen.printEnd();
                return;
            }
        }
    }
}