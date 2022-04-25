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
        System.out.println(solution.decToBaseK(34, 6));
        System.out.println(solution.sumBase(34, 6));

        System.out.println(solution.decToBaseK(10, 10));
        System.out.println(solution.sumBase(10, 10));

        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

class Solution {
    public int sumBase(int n, int k) {
        return (n / k > 0 ? sumBase(n / k, k) : 0) + (n % k);
    }

    StringBuilder decToBaseK(int n, int k) {
        return new StringBuilder()
                .append(n / k > 0 ? decToBaseK(n / k, k) : "")
                .append(n % k);
    }
}


