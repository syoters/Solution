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
//        System.out.println(solution.totalHammingDistanceTest(new int[]{4, 14, 2}));
//        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 4}));
        System.out.println(solution.totalHammingDistanceTest(new int[]{6, 1, 8, 6, 8}));
        System.out.println("------");
        System.out.println(solution.totalHammingDistance0(new int[]{6, 1, 8, 6, 8}));

//        Scanner file = new Scanner(new File("test.txt"));
//        String Snums[] = file.nextLine().split(",");
//        int nums[] = new int[Snums.length];
//        for (int i = 0; i < Snums.length; i++) {
//            nums[i] = Integer.parseInt(Snums[i]);
//        }
//        System.out.println(solution.totalHammingDistance(nums));
//        System.out.println(solution.totalHammingDistance0(nums)); //вот тут мой код запарывается по времени
        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

class Solution {
    /*
        477 . Общее расстояние Хэмминга
        Расстояние Хэмминга между двумя целыми числами — это количество позиций,
        в которых соответствующие биты различны.
        Учитывая целочисленный массив nums, вернуть сумму расстояний Хэмминга
        между всеми парами целых чисел в nums
    */

    // мой код считает, но долго
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                sum += HammingDistance(nums[i], nums[i1]);
            }
        }
        return sum;
    }

    private int HammingDistance(int a, int b) {
        int n = a ^ b;
        int sum = 0;
        while (n > 0) {
            if ((n & 1) == 1) sum++;  //if (n % 2 == 1)
            n >>= 1;
        }
        return sum;
    }

    //код из подсказок
    public int totalHammingDistance0(int[] nums) {
        long mask = 1L << 31;
        int totalans = 0;
        while (mask != 0) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((mask & nums[i]) >= 1) count++;
            }
            mask = mask >> 1;
            //количество чисел с установленным данным битом * количество чисел с неустановленным данным битом
            totalans = totalans + ((nums.length - count) * (count));
        }
        return totalans;
    }

    int totalHammingDistanceTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(getBin(nums[i], 4));
        }
        System.out.println();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int n = nums[i] ^ nums[i1];
                System.out.print(getBin(n, 4));
                System.out.print("\t" + nums[i] + " vs " + nums[i1]);
                System.out.println("\t" + HammingDistance(nums[i], nums[i1]));
                sum += HammingDistance(nums[i], nums[i1]);
            }
        }
        System.out.println();

        return sum;
    }

    private String getBin(int num, int digit) {
        return String.format("%" + digit + "s", Integer.toString(num, 2))
                .replaceAll(" ", "0");
    }
}


