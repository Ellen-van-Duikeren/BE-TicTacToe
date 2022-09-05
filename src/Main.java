import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nWelkom bij boter, kaas en eieren");

        //Stap 1: Maak een bord
        Field[] board = new Field[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = new Field(Integer.toString(i));
        }

        // Bord printen
        printBoard(board);

        //players instantieren
        Player playerA = new Player("Henk", "X");
        Player playerB = new Player("Annie", "O");

        // new game object instantieren
        Game game = new Game(playerA, playerB);

        // variabelen
        boolean hasWon = false;

        //Stap 6: Herhaal stappen 2 t/m 5
        while(!hasWon) {
            //Stap 2: Geef een speler de mogelijkheid om een symbool te zetten
            Scanner userInput = new Scanner(System.in);
            System.out.println("Op welk veld wil je een " + game.getCurrentPlayer().getToken() + " plaatsen? Geef een nummer van 0 t/m 8:");
            int selectedField = userInput.nextInt();

            String currentPlayerToken = game.getCurrentPlayer().getToken();
            board[selectedField].setToken(currentPlayerToken);

            // of in verkorte maar minder leesbare versie:
            //board[selectedField].setToken(game.getCurrentPlayer().getToken()) = currentPlayer.getToken();

            // Bord printen
            printBoard(board);

            //Stap 3: Kijk of een speler heeft gewonnen
            //Stap 5: Kijk of een speler heeft gewonnen
            hasWon = game.hasPlayerWon(board);

            // Stap 4: Wissel speler
            game.switchPlayer();

            // punten geven aan winnende player
            if(hasWon) {
                game.getCurrentPlayer().setScore(+1);
            }
        }

        System.out.println("\nGefeliciteerd. " + game.getCurrentPlayer().getName() + " heeft gewonnen.");
        System.out.println("\nSpeler " + playerA.getName() + "heeft een score van: " + playerA.getScore() + ".");
        System.out.println("Speler " + playerB.getName() + "heeft een score van: " + playerB.getScore() + ".");


    }

    // methodes
    public static void printBoard(Field[] board) {
        System.out.println("-----------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i].getToken());
            boolean endOfRow = (i + 1) % 3 == 0; // aan het einde van een rij hoeft geen | en gaan we naar de volgende regel
            if (!endOfRow) {
                System.out.print(" | ");
            } else {
                System.out.println("\n-----------");
            }
        }
    }

} // closing main class
