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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        long t = new Date().getTime();
//        new Main().run();
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(solution.findOcurrences("we will we will rock you", "we", "will")));

        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> strings = new ArrayList<>();

        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) strings.add(words[i + 2]);
        }

        return strings.toArray(new String[0]);
    }

    //через regex не доделанно, не раб 2й пример
    public String[] findOcurrences1(String text, String first, String second) {
        ArrayList<String> strings = new ArrayList<>();
        Pattern pattern = Pattern.compile(first + " " + second + " (\\S*)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) strings.add(matcher.group(1));

        return strings.toArray(new String[0]);
    }
}

