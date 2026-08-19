import java.io.*;
import java.util.*;

public class FlippingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == 1) totalOnes++;
        }

        // Kadane's algorithm on b[i] = +1 if a[i]==0 else -1, non-empty subarray required
        int maxEndingHere = (a[0] == 0) ? 1 : -1;
        int maxSoFar = maxEndingHere;

        for (int i = 1; i < n; i++) {
            int val = (a[i] == 0) ? 1 : -1;
            maxEndingHere = Math.max(val, maxEndingHere + val);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println(totalOnes + maxSoFar);
    }
}
