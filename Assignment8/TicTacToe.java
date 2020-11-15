import java.util.*;

/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think.
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
    private static final Random RANDOM = new Random();

    private static final String USER_NAME = "Joyce";
    private static final String USER_SYMBOL = "X";
    private static final String COMPUTER = "Computer";
    private static final String COMPUTER_SYMBOL = "O";
    private static final Map<String, String> SYMBOL = new HashMap<String, String>() {{
        put(USER_NAME, USER_SYMBOL);
        put(COMPUTER, COMPUTER_SYMBOL);
    }};

    private static final String BOARD_FORMATTER =
                    "%s | %s | %s\n" +
                    "- + - + -\n" +
                    "%s | %s | %s\n" +
                    "- + - + -\n" +
                    "%s | %s | %s\n";
    private static final String[] CHECK = new String[]{ "-", "-", "-", "-", "-", "-", "-", "-", "-"};

    private static final ArrayList<Integer> AVAILABLE_SLOT = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) {
        printGameBoard(CHECK);

        try(Scanner scan = new Scanner(System.in);) {
            while (!AVAILABLE_SLOT.isEmpty()) {
                System.out.format("Enter your placement from %s: ", AVAILABLE_SLOT);
                int pos = scan.nextInt();
                if (!AVAILABLE_SLOT.contains(pos)) {
                    System.out.printf("Slot %d is occupied. ", pos);
                    continue;
                }

                check(pos, USER_NAME);
                if(checkWinner() != null) {
                    System.out.println("Congratulations you won!");
                    return;
                } else if (AVAILABLE_SLOT.isEmpty()) {
                    break;
                }

                check(AVAILABLE_SLOT.get(RANDOM.nextInt(AVAILABLE_SLOT.size())), COMPUTER);
                if(checkWinner() != null) {
                    System.out.println("CPU wins! Sorry:(");
                    return;
                }
            }
        }

        System.out.println("CAT!");
    }

    public static void printGameBoard(String[] check) {
        System.out.println(String.format(BOARD_FORMATTER, check));
    }

    public static void check(int pos, String user) {
        CHECK[pos - 1] = SYMBOL.get(user);

        AVAILABLE_SLOT.remove((Integer) pos);

        printGameBoard(CHECK);
    }

    public static String checkWinner() {
        String symbol = null;
        // Check row
        if (CHECK[0].equals(CHECK[1]) && CHECK[1].equals(CHECK[2])) {
            symbol = CHECK[0];
        } else if (CHECK[3].equals(CHECK[4]) && CHECK[4].equals(CHECK[5])) {
            symbol = CHECK[3];
        } else if (CHECK[6].equals(CHECK[7]) && CHECK[7].equals(CHECK[8])) {
            symbol = CHECK[6];
        } else if (CHECK[0].equals(CHECK[3]) && CHECK[3].equals(CHECK[6])) {
            symbol = CHECK[0];
        } else if (CHECK[1].equals(CHECK[4]) && CHECK[4].equals(CHECK[7])) {
            symbol = CHECK[1];
        } else if (CHECK[2].equals(CHECK[5]) && CHECK[5].equals(CHECK[8])) {
            symbol = CHECK[2];
        } else if (CHECK[0].equals(CHECK[4]) && CHECK[4].equals(CHECK[8])) {
            symbol = CHECK[0];
        } else if (CHECK[2].equals(CHECK[4]) && CHECK[4].equals(CHECK[6])) {
            symbol = CHECK[2];
        }

        if (null == symbol || "-".equals(symbol)) {
            return null;
        } else {
            return USER_SYMBOL.equals(symbol) ? USER_NAME : COMPUTER;
        }
    }
}