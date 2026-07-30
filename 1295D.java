import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long phi(long n) {
        long result = n;

        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }

        if (n > 1)
            result -= result / n;

        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {
            long a = fs.nextLong();
            long m = fs.nextLong();

            long g = gcd(a, m);
            out.append(phi(m / g)).append('\n');
        }

        System.out.print(out);
    }
}
