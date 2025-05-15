import model.Board;
import model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;
import static util.BoardTemplate.BOARD_TEMPLATE;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var option = -1;
        while (true) {
            displayMenu();
            option = scanner.nextInt();
            processMenuOption(option, positions);
        }
    }

    private static void displayMenu() {
        System.out.println("Selecione uma das opções a seguir");
        System.out.println("1 - Iniciar um novo Jogo");
        System.out.println("2 - Colocar um novo número");
        System.out.println("3 - Remover um número");
        System.out.println("4 - Visualizar jogo atual");
        System.out.println("5 - Verificar status do jogo");
        System.out.println("6 - Limpar jogo");
        System.out.println("7 - Finalizar jogo");
        System.out.println("8 - Sair");
    }

    private static void processMenuOption(int option, Map<String, String> positions) {
        switch (option) {
            case 1 -> startGame(positions);
            case 2 -> inputNumber();
            case 3 -> removeNumber();
            case 4 -> showCurrentGame();
            case 5 -> showGameStatus();
            case 6 -> clearGame();
            case 7 -> finishGame();
            case 8 -> System.exit(0);
            default -> System.out.println("Opção inválida, selecione uma das opções do menu");
        }
    }

    private static void showCurrentGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + (isNull(col.get(i).getActual()) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo está assim:");
        System.out.printf(BOARD_TEMPLATE + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }
        System.out.printf("Status do jogo: %s\n", board.getStatus().getLabel());
        System.out.println(board.hasErrors() ? "O jogo contém erros" : "O jogo não contém erros");
    }

    private static void clearGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }
        board.reset();
        System.out.println("Jogo limpo.");
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }
        if (board.gameIsFinished()) {
            System.out.println("Parabéns! Você concluiu o jogo.");
            board = null;
        } else {
            System.out.println("O jogo ainda não foi finalizado ou contém erros.");
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            List<Space> row = new ArrayList<>();
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String key = i + "," + j;
                String[] config = positions.getOrDefault(key, "0,false").split(",");
                int value = Integer.parseInt(config[0]);
                boolean fixed = Boolean.parseBoolean(config[1]);
                row.add(new Space(value, fixed));
            }
            spaces.add(row);
        }

        board = new Board(spaces);
        System.out.println("Novo jogo iniciado.");
    }

    private static int getPosition(String label) {
        return getPosition(label, 0, 8);
    }

    private static int getPosition(String label, int min, int max) {
        int value;
        do {
            System.out.printf("Informe a %s (%d-%d): ", label, min, max);
            value = scanner.nextInt();
        } while (value < min || value > max);
        return value;
    }

    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        int row = getPosition("linha");
        int col = getPosition("coluna");
        int value = getPosition("número", 1, 9);

        if (!board.changeValue(row, col, value)) {
            System.out.println("Não é possível alterar um valor fixo.");
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        int row = getPosition("linha");
        int col = getPosition("coluna");

        if (!board.clearValue(row, col)) {
            System.out.println("Não é possível remover um valor fixo.");
        }
    }
}
