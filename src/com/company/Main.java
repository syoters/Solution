//        Charset w1251 = Charset.forName("Windows-1251");
//        args = new String[]{"C:\\someFile3.txt", "C:\\someFile1.txt", "C:\\someFile2.txt"};
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < 2; i++) args[i] = in.nextLine();
//        args = new String[]{"C:\\someFile3.txt", "C:\\someFile1.txt", "C:\\someFile2.txt"};
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//            for (int i = 0; i < 2; i++) args[i] = bf.readLine();}
//        String fileName;
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//        fileName = bf.readLine();}

//<pre class='language-java line-numbers'><code>
//
//</code></pre>

//"jopa".chars().map(c -> c + '1').toArray()

//while (b != 0) b = a % (a = b);  // нод
//return a;

package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long t = new Date().getTime();
//        new Main().run();
        Solution solution = new Solution();
        System.out.println(solution.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(solution.minTimeToVisitAllPoints(new int[][]{{0, 0}, {3, 2}, {3, 4}, {-1, 0}}));

        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

//1266 . Минимальное время посещения всех точек
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int summ = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
//            System.out.println(dx + "\t" + dy + "\t" + Math.max(dx, dy));
            summ += Math.max(dx, dy);
        }
        return summ;
    }
}
