import java.io.*;
import java.util.*;

public class BinaryPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int odd = 0, evenGood = 0, evenBad = 0;

            for (int i = 0; i < n; i++) {
                String s = br.readLine().trim();
                int len = s.length();
                if (len % 2 == 1) {
                    odd++;
                } else {
                    int zeroCount = 0;
                    for (int j = 0; j < len; j++) {
                        if (s.charAt(j) == '0') zeroCount++;
                    }
                    if (zeroCount % 2 == 0) evenGood++;
                    else evenBad++;
                }
            }

            int ans = n - ((odd == 0 && evenBad % 2 == 1) ? 1 : 0);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
