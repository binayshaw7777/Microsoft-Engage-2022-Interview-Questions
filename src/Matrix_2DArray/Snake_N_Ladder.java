//Snake and Ladder Reference Image: https://media.istockphoto.com/vectors/snakes-and-ladders-vector-id455302535?k=20&m=455302535&s=612x612&w=0&h=WrXKoYiMMjK2woKY_RJUdECKb8Jc6FhdNlf2UkBm0uw=

package Matrix_2DArray;

import java.util.HashMap;
import java.util.Scanner;

public class Snake_N_Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> snake = new HashMap<>();
        HashMap<Integer, Integer> ladder = new HashMap<>();

        addSnakes(snake);
        addLadders(ladder);

        int position = 1;

        while (position != 100) {
            System.out.println("Current position: " + position);
            System.out.println("Enter your step: ");
            int roll = sc.nextInt();
            if (roll > 0 && roll < 7) {
                position += roll;

                position = checkSnake(position, snake);
                position = checkLadder(position, ladder);
            } else {
                System.out.println("Step must be in the range of 1 - 6");
            }
        }

        System.out.println("Won!");

    }

    private static int checkLadder(int position, HashMap<Integer, Integer> ladder) {
        if (ladder.containsKey(position)) {
            int jump = ladder.get(position);
            System.out.println("You found a ladder! ");
            return jump;
        }
        return position;
    }

    private static int checkSnake(int position, HashMap<Integer, Integer> snake) {
        if (snake.containsKey(position)) {
            int bit = snake.get(position);
            System.out.println("You were bitten by a snake!");
            return bit;
        }
        return position;
    }

    private static void addLadders(HashMap<Integer, Integer> ladder) {
        ladder.put(3, 38);
        ladder.put(5, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(71, 91);
        ladder.put(80, 100);
    }

    private static void addSnakes(HashMap<Integer, Integer> snake) {
        snake.put(17, 7);
        snake.put(62, 19);
        snake.put(87, 24);
        snake.put(54, 34);
        snake.put(64, 60);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);
    }
}
