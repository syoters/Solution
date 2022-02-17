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
    public static void main(String[] args) throws FileNotFoundException {
        int charCount = 0;
        int sumFreq = 0;
        String codeStr = "";
        String text = "Let me introduce myself. My name is Mariya I am a 20-year-old student from Donetsk. I study at the university in my native town and my future profession is bookkeeping. I live with my parents and my elder sister Lena. We are a friendly family. Lena is 2 years older than me. We share our room and tell all our secrets to each other. "
                +
                "We are very much alike: open-hearted, smart and merry. That s why we have a lot of friends. I like organizing parties for our friends as we often gather together, discuss our plans and have fun. My hobby is music. I play the guitar and write my own songs. They say, I have a nice voice. My family and friends often ask me to sing to guitar their favorite songs. Cooking is also my hobby. My Mom cooks very well. She has taught me how to cook a lot of delicious dishes from Ukrainian and Russian cuisine. My favorite dish is French soup, which I cook for the whole family. "
                +
                "In the evening, I often watch TV with my family and discuss my plans for the next day. On weekends, I often meet my friends or stay at home and read books. I like novels by Dariya Dontsova. I sometimes discuss her style and ideas with my sister. Literature, cooking, TV - I have a lot of topics to talk about and make new friends.";

        Map<String, String> codeMap = new HashMap<>();
        final int m[] = {1, 2, 3, 4, 5};
        m[0]++;
        System.out.println(m[0]);


//        try (Scanner in = new Scanner(System.in)) {
        try (Scanner in = new Scanner(new FileInputStream("res\\someFile0.txt"))) {
            String unitLine[] = in.nextLine().split(" ");
            charCount = Integer.parseInt(unitLine[0]);
            sumFreq = Integer.parseInt(unitLine[1]);
            for (int i = 0; i < charCount; i++) {
                unitLine = in.nextLine().split(": ");
                codeMap.put(unitLine[1], unitLine[0]);
            }
            codeStr = in.nextLine();
        }

        Node parentNode = Node.createTree(codeMap);
        System.out.println(Node.getDeCodeFromNode(codeStr, parentNode));
//        System.out.println(Node.getDeCodeFromMap(codeStr, codeMap, sumFreq));


//        Node.createTree(text);

    }

}

class Node {
    Node parent = null;
    Node left = null;
    Node right = null;
    private int frequency = 0;
    char charr = 0;

    public Node() {
    }

    public Node(Node parent, Node left, Node right, int frequency, char charr) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.frequency = frequency;
        this.charr = charr;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return String.format("%s\t[p %s|l %s|r %s] = %d",
                charr,
                parent != null ? parent.charr : "0",
                left != null ? left.charr : "0",
                right != null ? right.charr : "0",
                frequency);
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String getCode() {
        if (!isLeaf()) return "";
        return getCode1(this);
    }

    private String getCode1(Node startNode) {
        StringBuilder sb = new StringBuilder();
        while (startNode != null && startNode.parent != null) {
            if (startNode == startNode.parent.left) sb.append("0");
            else sb.append("1");
            startNode = startNode.parent;
        }
        return sb.reverse().toString();
    }

    public static String getDeCodeFromMap(String codeStr, Map<String, String> codeMap, int sumFreq) {
        StringBuilder resStrSb = new StringBuilder();
        String currStr;
        for (int i = 0; i < sumFreq; i++) {
            int i1 = 0;
            while (!codeMap.containsKey(currStr = codeStr.substring(i, i + i1 + 1))) i1++;
            resStrSb.append(codeMap.get(currStr));
            i += i1;
        }
        return resStrSb.toString();
    }

    public static String getDeCodeFromNode(String codeStr, Node headNode) {
        StringBuilder deCodeSb = new StringBuilder();
        Node temp = headNode;
        for (int i = 0; i < codeStr.length(); i++) {
            if (codeStr.charAt(i) == '1') temp = temp.right;
            else temp = temp.left;
            if (temp.isLeaf()) {
                deCodeSb.append(temp.charr);
                temp = headNode;
            }
        }
        return deCodeSb.toString();
    }


    public static Node createTree(String str) {
        Queue<Node> nodeQueue = new PriorityQueue<>(Comparator.comparing(Node::getFrequency));
        Map<Character, Node> nodeMap = new HashMap<>();
        int freqChars[] = new int[128];
        int charCount = 0;
        str.chars().forEach(ch -> freqChars[ch]++);
        for (int i = 0; i < freqChars.length; i++) {
            if (freqChars[i] != 0) {
                charCount++;
                Node newNode = new Node(null, null, null, freqChars[i], (char) i);
                nodeQueue.offer(newNode);
                nodeMap.put((char) i, newNode);
            }
        }

//        nodeMap.values().stream()  // вывод частоты встречаемых символов
//                .sorted(Comparator.comparing(Node::getFrequency).reversed())
//                .forEach(e -> System.out.printf("%s: %d\n", e.charr, e.getFrequency()));
//        System.out.println();

        int sumFreq = 0;
        if (charCount == 1) {   // обработка строки из одинакового символа - костыль
            sumFreq = str.length();
            System.out.printf("%d %d\n", charCount, sumFreq);
            System.out.printf("%s: %s\n", str.charAt(0), 0);
            for (int i = 0; i < str.length(); i++) System.out.print("0");
            return null;
        }
        while (nodeQueue.size() > 1) {
            Node a = nodeQueue.poll();
            Node b = nodeQueue.poll();
            if (a != null && b != null) {
                Node newNode = new Node(null, a, b, a.getFrequency() + b.getFrequency(), (char) 0);
                nodeQueue.offer(newNode);
                a.parent = newNode;
                b.parent = newNode;
                sumFreq += a.getFrequency() + b.getFrequency();
            }
        }

        System.out.printf("%d %d\n", charCount, sumFreq);
        nodeMap.values().stream()
                .sorted(Comparator.comparing(Node::getFrequency).reversed().thenComparing(Node::getCode))
//                .forEach(e -> System.out.printf("%s: %d\t%s\n", e.charr, e.getFrequency(), e.getCode()));
                .forEach(e -> System.out.printf("%s: %s\n", e.charr, e.getCode()));

        String codeStr = str.chars()  // кодированная строка
                .mapToObj(ch -> nodeMap.get((char) ch).getCode())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(codeStr);

//        System.out.println(Node.getDeCode(nodeQueue.peek(), codeStr));
//        System.out.printf("было байт %d\n", str.length());
//        System.out.printf("стало байт %d", codeStr.length() / 8);

        return null;
    }


    public static Node createTree(Map<String, String> codeMap) {
        Node parentNode = new Node();
        for (Map.Entry<String, String> entry : codeMap.entrySet()) {
            Node newNode = new Node();
            Node currNode = parentNode;
            for (int i = 0; i < entry.getKey().length(); i++) {
                char bit = entry.getKey().charAt(i);

                newNode = new Node();
                if (bit == '0') {
                    if (currNode.left == null) {
                        currNode.left = newNode;
                        newNode.parent = currNode;
                        currNode = currNode.left;
                    } else currNode = currNode.left;
                } else {
                    if (currNode.right == null) {
                        currNode.right = newNode;
                        newNode.parent = currNode;
                        currNode = currNode.right;
                    } else
                        currNode = currNode.right;
                }
            }
            newNode.charr = entry.getValue().charAt(0);
        }

        return parentNode;
    }

    public void printNodes() {
        printNodes(this);
    }

    private void printNodes(Node startNode) {
        System.out.println(startNode);
        if (!startNode.isLeaf()) {
            printNodes(startNode.left);
            printNodes(startNode.right);
        }
    }

}




