import java.util.*;

public class Main {

    static int[][] light = new int[3][3];

    static void toggle(int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            light[x][y] ^= 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initially all lights are ON
        for (int i = 0; i < 3; i++) {
            Arrays.fill(light[i], 1);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int press = sc.nextInt();

                if (press % 2 == 1) {
                    toggle(i, j);
                    toggle(i - 1, j);
                    toggle(i + 1, j);
                    toggle(i, j - 1);
                    toggle(i, j + 1);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(light[i][j]);
            }
            System.out.println();
        }
    }
}
