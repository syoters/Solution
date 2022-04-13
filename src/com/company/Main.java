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
        new Main().run();
        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {
        int i = -7;
//        System.out.println(new int[]{5, 7, 1, 4}[(i + ((Math.abs((int) i / 4))+1) * 4) % 4]);
        System.out.println(new int[]{5, 7, 1, 4}[(i + 4 * 5) % 4]);
        System.out.println(Arrays.toString(decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(decrypt(new int[]{5, 7, 1, 4}, 0)));
        System.out.println(Arrays.toString(decrypt(new int[]{2, 4, 9, 3}, -2)));
    }

    public int[] decrypt(int[] code, int k) {
        int res[] = new int[code.length];
        int zn = (k >= 0 ? 1 : -1);

        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            for (int j = 0; j < k * zn; j++) {
                sum += code[(i + zn * (j + 1) + code.length) % code.length];
            }
            res[i] = sum;
        }
        return res;
    }

}

