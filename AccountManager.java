import java.util.*;
import java.io.*;

public class AccountManager {
    private static HashMap<String, String> accounts = new HashMap<String, String>();    // ID, PW

    static void saveAccountsInfo(String id, String pw) {
        FileWriter fileWriter = null;
        try {
            String path = java.net.URLDecoder.decode(AccountManager.class.getResource("accounts.txt").getPath(), "UTF-8");
            fileWriter = new FileWriter(path, true);
            String newAccount = id + " " + pw + "\r\n";
            fileWriter.write("\n" + newAccount);
        } catch (UnsupportedEncodingException e) {
            System.out.println("[ERROR] Invalid encoding mode");
        } catch (IOException e) {
            System.out.println("[ERROR] IOException");
        } finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("[ERROR] IOException");
                }
            }
        }
    }
    
    public static void readAccountList() {      // get account list from file (accounts.txt)
        String path = null;

        accounts.clear();
        // put accounts info
        try {
            path = java.net.URLDecoder.decode(AccountManager.class.getResource("accounts.txt").getPath(), "UTF-8");
            File accountFile = new File(path);
            Scanner scan = new Scanner(accountFile);
            
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String id = line.split(" ")[0];
                String pw = line.split(" ")[1];
                accounts.put(id, pw);
            }

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] File not found: " + path);
        } catch (UnsupportedEncodingException e) {
            System.out.println("[ERROR] Invalid encoding mode");
        }
    }

    public static String login() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        System.out.print("ID: ");
        String id = scan.nextLine();
        if(!accounts.containsKey(id))
            flag = false;
        
        System.out.print("PW: ");
        String pw = scan.nextLine();
        if(!pw.equals(accounts.get(id)))
            flag = false;

        // scan.close();

        if(!flag) {
            System.out.println("\n[ERROR] Wrong ID or PASSWORD");
            return null;
        }
        else    return id;
    }

    public static void signup() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        String id = null, pw = null;
        
        System.out.println("Please enter 'EXIT' to exit this session.");
        while(flag) {
            System.out.print("ID: ");
            id = scan.nextLine();
            if(id.equals("EXIT"))
                return;
            if(id.indexOf(" ") != -1) {
                System.out.println("\n[ERROR] Invalid ID: space not allowed\n");
                continue;
            }
            if(accounts.containsKey(id)) {
                System.out.println("\n[ERROR] Already used\n");
                continue;
            }
            flag = false;
        }

        flag = true;
        while(flag) {
            System.out.print("PW: ");
            pw = scan.nextLine();
            if(pw.equals("EXIT"))
                return;
            if(pw.indexOf(" ") != -1) {
                System.out.println("\n[ERROR] Invalid PW: space not allowed\n");
                continue;
            }
            flag = false;
        }
        // scan.close();
        
        accounts.put(id, pw);
        saveAccountsInfo(id, pw);
    }
}