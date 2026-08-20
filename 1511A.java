import java.io.*;
import java.util.*;

public class ReviewSite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            for (int i = 0; i < n; i++) {
                int r = Integer.parseInt(st.nextToken());
                if (r != 2) count++;
            }
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
