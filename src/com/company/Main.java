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

        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.requests);

        System.out.println(new Date().getTime() - t + " ms");
    }

    private int find(int value, int[] array, int left, int right) {
        int midpoint = 0;
        while (right >= left) {
            midpoint = (left + right) / 2;
            if (value == array[midpoint]) return midpoint;
            if (array[midpoint] > value) right = midpoint - 1;
            if (array[midpoint] < value) left = midpoint + 1;
        }
        return left;
    }

    private void run() throws IOException {

    }

}

class RecentCounter {
    int count = 0;
    ArrayList<Integer> requests = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {}

    public int ping(int t) {
        requests.add(t);
        return requests.size() - find(t - 3000, requests, 0, requests.size() - 1);
    }

    // с запоминанием последней позиции, самый быстрый способ
    public int ping_lifeHack(int t) {
        while (count < requests.size() && requests.get(count) < t - 3000) count++;
        requests.add(t);
        return requests.size() - count;
    }

    // поиск через очередь(выпихиваем все элементы что не входят в наш интервал)
    public int ping_Queue(int t) {
        int rem = t - 3000;
        q.add(t);
        while (q.peek() < rem) q.remove();
        return q.size();
    }

    //линейный перебор всего/ скользящее окно
    public int ping_line(int t) {
        requests.add(t);

        int count = 0;
        for (int i = requests.size() - 1; i >= 0; i--) {
            if (requests.get(i) >= t - 3000 && requests.get(i) <= t) count++;
        }
        return count;
    }

    // нечеткий поиск, возвращает индекс где ближе всего искомое значение(left right можно поигратся)
    private int find(int value, ArrayList<Integer> array, int left, int right) {
        while (right >= left) {
            int midpoint = (left + right) / 2;
            if (array.get(midpoint) == value) return midpoint;
            if (array.get(midpoint) > value) right = midpoint - 1;
            if (array.get(midpoint) < value) left = midpoint + 1;
        }
        return left;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

