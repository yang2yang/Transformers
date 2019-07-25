package learnmap;

/**
 * @author qingli.ding
 * @date 2019/7/25
 */
public class Test {

    public static void main(String[] args) {
        //LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(5, Level.INFO);
        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap();

        lruLinkedHashMap.put(1, 1);
        lruLinkedHashMap.put(2, 2);
        lruLinkedHashMap.put(3, 3);
        System.out.println(lruLinkedHashMap.keySet());

        lruLinkedHashMap.put(4, 4);
        lruLinkedHashMap.put(5, 5);
        System.out.println(lruLinkedHashMap.keySet());
        //这里不能get(1),不然会导致1的key重新变成最新
        //System.out.println("after put(5,5)," + lruLinkedHashMap.get(1));

        lruLinkedHashMap.put(6, 6);
        System.out.println(lruLinkedHashMap.keySet());

        System.out.println("after put(6,6)," + lruLinkedHashMap.get(1));
        lruLinkedHashMap.put(7, 7);
        System.out.println("after put(7,7)," + lruLinkedHashMap.get(1));
    }
}
