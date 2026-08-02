import java.io.*;
import java.util.*;

public class KingKeykhosrowsMystery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            long a = Long.parseLong(tok.nextToken());
            long b = Long.parseLong(tok.nextToken());

            long g = gcd(a, b);
            long lcm = a / g * b; // avoid overflow by dividing first

            sb.append(lcm).append('\n');
        }

        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
