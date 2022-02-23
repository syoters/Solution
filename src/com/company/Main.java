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
        int a[], b[], k = 13;
        try (Scanner in = new Scanner(new FileInputStream("test.txt"))) {
//        try (Scanner in = new Scanner(System.in)) {
            a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
//        try (BufferedReader bf = new BufferedReader(new FileReader("test.txt"))) {
//            a = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            b = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        }
        for (int i = 0; i < 15; i++) {
            System.out.print(find1(i, a, 1, a.length - 1) + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
        System.out.println();

        int p[];
        p = findSum(17, a, 1, a.length - 1);
        System.out.println(Arrays.toString(p) + "\t" + a[p[0]] + " " + a[p[1]]);
        p = findSumBin(17, a, 1, a.length - 1);
        System.out.println(Arrays.toString(p) + "\t" + a[p[0]] + " " + a[p[1]]);

    }

    private int[] findSum(int value, int[] sortArray, int left, int right) {
        while (right > left) {
            int sum = sortArray[left] + sortArray[right];
//            System.out.println(left + "\t" + right + "\t" + sum);  // отладка
            if (sum == value) return new int[]{left, right};
            if (sum < value) left++;
            if (sum > value) right--;
        }
        return new int[]{-1, -1};
    }

    private int[] findSumBin(int value, int[] sortArray, int left, int right) {
        while (right > left) {
            int sum = sortArray[left] + sortArray[right];
            System.out.println("[" + left + " " + right + "]\t" + sortArray[left] + " " + sortArray[right] + "\t" + sum);  // отладка
            if (sum == value) return new int[]{left, right};
            if (sum < value) left = (left + right) / 2;
            if (sum > value) right = (left + right) / 2;
        }
        return new int[]{-1, -1};
    }

    private int find1(int value, int[] array, int left, int right) {
        while (right >= left) {
            int midpoint = (left + right) / 2;
            if (value == array[midpoint]) return midpoint;

            if (array[midpoint] > value) right = midpoint - 1;
            if (array[midpoint] < value) left = midpoint + 1;
        }
        return -1;
    }

    private int find(int value, int[] array, int left, int right) {
        if (right < left) return -1;
        int midpoint = (left + right) / 2;
        if (value == array[midpoint]) return midpoint;

        if (array[midpoint] > value) return find(value, array, left, midpoint - 1);
        if (array[midpoint] < value) return find(value, array, midpoint + 1, right);

        return -1;
    }

}




