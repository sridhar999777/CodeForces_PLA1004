import java.io.*;

public class Strobogrammatic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        // rotation map: -1 means "no valid rotation exists for this symbol"
        int[] rot = new int[128];
        for (int i = 0; i < 128; i++) rot[i] = -1;
        rot['0'] = '0';
        rot['1'] = '1';
        rot['2'] = '2';
        rot['5'] = '5';
        rot['8'] = '8';
        rot['6'] = '9';
        rot['9'] = '6';
        rot['3'] = 'E';   // '3' upside down looks like 'E' on a 7-segment display
        rot['E'] = '3';
        // 4, 7, A, b, C, d, F have no valid rotated image -> stay -1

        long cost = 0;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            char x = s.charAt(lo);
            char y = s.charAt(hi);
            int rx = rot[x];
            int ry = rot[y];
            if (rx != -1 && rx == y) {
                // pair already valid, no change needed
            } else if (rx != -1 || ry != -1) {
                cost += 1; // change just one side to match
            } else {
                cost += 2; // neither side has a valid rotation, must change both
            }
            lo++;
            hi--;
        }
        if (lo == hi) {
            // middle character (odd length) must map to itself
            char m = s.charAt(lo);
            int rm = rot[m];
            if (rm == -1 || rm != m) {
                cost += 1;
            }
        }

        System.out.println(cost);
    }
}
