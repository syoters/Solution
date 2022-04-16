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
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("b", "abc"));
        System.out.println(new Solution().isSubsequence("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));
        System.out.println(new Date().getTime() - t + " ms");
    }

    private void run() throws IOException {

    }

}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int is = 0;
        for (int it = 0; it < t.length(); it++) {
            if (s.charAt(is) == t.charAt(it)) is++;
            if (is == s.length()) return true;
        }

        return false;
    }


    public boolean isSubsequence1(String s, String t) {
        StringBuilder sb = new StringBuilder();
//        sb.append("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append(".*").append(s.charAt(i)).append("+");
        }
        sb.append(".*");

        return t.matches(sb.toString());
    }
}

