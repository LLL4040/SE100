package WordLadder;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class WordLadderTest {

    @Test
    public void readDict() {
        HashSet<String> dict = new HashSet<>();
        String path = "D:\\Java\\wordLadderTest\\src\\test\\java\\WordLadder\\smalldict.txt";
        dict.add("hit");
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        dict.add("succeed");
        assertEquals(dict, WordLadder.readDict(path));
    }

    @Test
    public void hasOneDif() {
        String a = "data";
        String b = "date";
        String c = "dat";
        String d = "code";
        boolean result1 = true;
        boolean result2 = false;
        assertEquals(result1, WordLadder.hasOneDif(a, b));
        assertEquals(result2, WordLadder.hasOneDif(a, a));
        assertEquals(result2, WordLadder.hasOneDif(a, c));
        assertEquals(result2, WordLadder.hasOneDif(a, d));
    }

    @Test
    public void replaceOneChar() {
        String a = "data";
        String b = "date";
        assertEquals(b, WordLadder.replaceOneChar(a, 3, "e"));
        assertEquals(a, WordLadder.replaceOneChar(a, 10, "e"));
        assertEquals(a, WordLadder.replaceOneChar(a, -10, "e"));
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
        String path = "D:\\Java\\wordLadderTest\\src\\test\\java\\WordLadder\\smalldict.txt";
        HashSet<String> dict = new HashSet<>();
        dict = WordLadder.readDict(path);

        //准备正确输出
        LinkedList<LinkedList<String>> result = new LinkedList<>();

        //空字典
        assertEquals(result, WordLadder.searchLayer(queue, end1, dict0));

        //hit -> hot
        dict = WordLadder.readDict(path);
        LinkedList<String> layer1 = new LinkedList<>();
        layer1.add("hit");
        result.add(layer1);
        assertEquals(result, WordLadder.searchLayer(queue, end2, dict));

        //hit -> cog
        dict = WordLadder.readDict(path);
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
        assertEquals(result, WordLadder.searchLayer(queue, end1, dict));

        //没有ladder
        dict = WordLadder.readDict(path);
        queue.removeFirst();
        queue.add("hit");
        layer4.add("log");
        LinkedList<String> layer5 = new LinkedList<>();
        layer5.add("cog");
        result.add(layer5);
        assertEquals(result, WordLadder.searchLayer(queue, end3, dict));
    }

    @Test
    public void findLadder() {
        String path = "D:\\Java\\wordLadderTest\\src\\test\\java\\WordLadder\\smalldict.txt";
        String beg1 = "HHH";
        String beg2 = "succeed";
        String beg3 = "hit";
        String end = "cog";
        LinkedList<String> result1 = new LinkedList<>();
        //单词必须都在字典里
        assertEquals(result1, WordLadder.findLadder(beg1, end, path));
        //单词不可以相同
        assertEquals(result1, WordLadder.findLadder(end, end, path));
        //单词长度必须相等
        assertEquals(result1, WordLadder.findLadder(beg2, end, path));

        //hit -> cog
        result1.add("cog");
        result1.add("dog");
        result1.add("dot");
        result1.add("hot");
        result1.add("hit");
        assertEquals(result1, WordLadder.findLadder(beg3, end, path));
    }
}