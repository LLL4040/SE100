package wordladder;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class GreetingTest {
    @Test
    public void getId() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals(1, ladder.getId());
    }

    @Test
    public void getBeg() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals("data", ladder.getBeg());
    }

    @Test
    public void getEnd() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals("code", ladder.getEnd());
    }

    @Test
    public void readDict() {
        HashSet<String> dict = new HashSet<>();
        String path = "smalldict.txt";
        dict.add("hit");
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        dict.add("succeed");
        assertEquals(dict, Greeting.readDict(path));
    }

    @Test
    public void hasOneDif() {
        String a = "data";
        String b = "date";
        String c = "dat";
        String d = "code";
        boolean result1 = true;
        boolean result2 = false;
        assertEquals(result1, Greeting.hasOneDif(a, b));
        assertEquals(result2, Greeting.hasOneDif(a, a));
        assertEquals(result2, Greeting.hasOneDif(a, c));
        assertEquals(result2, Greeting.hasOneDif(a, d));
    }

    @Test
    public void replaceOneChar() {
        String a = "data";
        String b = "date";
        assertEquals(b, Greeting.replaceOneChar(a, 3, "e"));
        assertEquals(a, Greeting.replaceOneChar(a, 10, "e"));
        assertEquals(a, Greeting.replaceOneChar(a, -10, "e"));
    }

    @Test
    public void searchLayer() {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("hit");
        String end1 = "cog";
        String end2 = "hot";
        String end3 = "hao";

        HashSet<String> dict0 = new HashSet<>();
        //准备小字典
        String path = "smalldict.txt";
        HashSet<String> dict = new HashSet<>();
        dict = Greeting.readDict(path);

        //准备正确输出
        LinkedList<LinkedList<String>> result = new LinkedList<>();

        //空字典
        assertEquals(result, Greeting.searchLayer(queue, end1, dict0));

        //hit -> hot
        dict = Greeting.readDict(path);
        LinkedList<String> layer1 = new LinkedList<>();
        layer1.add("hit");
        result.add(layer1);
        assertEquals(result, Greeting.searchLayer(queue, end2, dict));

        //hit -> cog
        dict = Greeting.readDict(path);
        queue.add("hit");
        LinkedList<String> layer2 = new LinkedList<>();
        layer2.add("hot");
        result.add(layer2);
        LinkedList<String> layer3 = new LinkedList<>();
        layer3.add("dot");
        layer3.add("lot");
        result.add(layer3);
        LinkedList<String> layer4 = new LinkedList<>();
        layer4.add("dog");
        result.add(layer4);
        assertEquals(result, Greeting.searchLayer(queue, end1, dict));

        //没有ladder
        dict = Greeting.readDict(path);
        queue.removeFirst();
        queue.add("hit");
        layer4.add("log");
        LinkedList<String> layer5 = new LinkedList<>();
        layer5.add("cog");
        result.add(layer5);
        assertEquals(result, Greeting.searchLayer(queue, end3, dict));
    }

    @Test
    public void findLadder() {
        String path = "smalldict.txt";
        String beg1 = "HHH";
        String beg2 = "succeed";
        String beg3 = "hit";
        String end = "cog";
        //单词必须都在字典里
        assertEquals("首尾单词都必须在字典内，请重新输入", Greeting.findLadder(beg1, end, path));
        //单词不可以相同
        assertEquals("首尾单词不可以相同，请重新输入", Greeting.findLadder(end, end, path));
        //单词长度必须相等
        assertEquals("首尾单词长度必须相等，请重新输入", Greeting.findLadder(beg2, end, path));

        //hit -> cog
        assertEquals("cog->dog->dot->hot->hit", Greeting.findLadder(beg3, end, path));
    }
}