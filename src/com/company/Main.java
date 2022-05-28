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

// 976. Largest Perimeter Triangle
public class Main {
    public static void main(String[] args) throws IOException {
        long t = new Date().getTime();
//        new Main().run();
        Solution solution = new Solution();
        System.out.println(solution.largestPerimeter(new int[]{3, 2, 3, 4}));
        System.out.println(solution.largestPerimeter(new int[]{3, 6, 2, 3}));
        System.out.println(solution.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(solution.largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 3;

        while (n >= 0) {
            if (nums[n] + nums[n + 1] > nums[n + 2]) return nums[n] + nums[n + 1] + nums[n + 2];
            n--;
        }
        return 0;
    }
}