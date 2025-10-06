import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args){
        int balance = 100;
        int bet;
        int payout;
        String playagain = "yes";
        String[] row ;
        System.out.println("--------------------------------");
        System.out.println("| WELCOME TO THE JAVA GAMBLING |");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("| symbols :: 🎁 🐽 🤚 🎨 📷 |");
        System.out.println("------------------------------");
        Scanner scanner = new Scanner(System.in);
        while (balance >0) {
            System.out.println("CURRENT BALANCE : $"+balance);
            System.out.print("ENTER THE AMOUNT YOU WANT TO BET :$");
            bet = scanner.nextInt();
            scanner.nextLine();
            if (bet > balance) {
                System.out.println("BET CANT BE PLACED DUE TO INSUFFICIENT BALANCE : ");
                continue;
            } else if (bet < 0) {
                System.out.println("BET CAN NOT BE IN NAGATIVE VALUE");
                continue;
            }else {
                balance-=bet;

            }
            System.out.println("YOU GOT ----");
            row = spinrow();
            printrow(row);
            payout = getpayout(row,bet);
            if(payout >0){
                System.out.println("YOU WON $"+payout);
                balance += payout;
            }else{
                System.out.println("TRY AGAIN !!");
            }
            System.out.println("YOUR TOTAL BALANCE IS "+balance);
            System.out.print("WANNA PLAY AGAIN ?? (YES / NO) : ");
            playagain = scanner.nextLine().toLowerCase();
            if(!playagain.equals("yes")){
                break;
            }
        }
        System.out.println("THANKS FOR PLAYING !!    ");
    }
    static String[] spinrow(){
        String[] symbols = {"🎁","🐽" ,"🤚", "🎨" ,"📷"};
        String[] row = new String[3];
        Random random = new Random();
        for(int  i = 0; i<3;i++){
            row[i]= symbols[random.nextInt(symbols.length)];
        }
        return row;
    }
    static void printrow(String[] row){
        System.out.println("--------------");
        System.out.println(" "+String.join(" | ",row));
        System.out.println("--------------");
    }
    static int getpayout(String[] row,int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🎁" -> bet * 2;
                case "🐽" -> bet * 5;
                case "🤚" -> bet * 10;
                case "🎨" -> bet * 20;
                case "📷" -> bet * 30;
                default -> 0;
            };
        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🎁" -> bet * 2;
                case "🐽" -> bet * 3;
                case "🤚" -> bet * 4;
                case "🎨" -> bet * 5;
                case "📷" -> bet * 10;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🎁" -> bet * 2;
                case "🐽" -> bet * 3;
                case "🤚" -> bet * 4;
                case "🎨" -> bet * 5;
                case "📷" -> bet * 10;
                default -> 0;
            };
        }
        return 0;

    }
}