package learnmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 基于LinkedHashMap实现LRU算法的数据结构
 *
 * @author shane
 * @date 2019/7/25
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private Logger logger = Logger.getLogger("LRULinkedHashMap");

    private Integer maxSize;

    /**
     * 调用super构造函数来改变accessOrder为true
     * 默认设置maxSize为5
     */
    public LRULinkedHashMap() {
        super(10, 0.75f, true);
        this.maxSize = 5;
        logger.setLevel(Level.OFF);
    }

    /**
     * 调用super构造函数来改变accessOrder为true
     *
     * @param maxSize
     */
    public LRULinkedHashMap(Integer maxSize, Level level) {
        super(10, 0.75f, true);
        this.maxSize = maxSize;
        logger.setLevel(level);
    }

    /**
     * LinkedHashMap自身为缓存实现预留的接口，接口会在put或者putAll时进行调用，
     * 返回true表示删除最少访问的entry，返回false表示删除最少访问的entry
     *
     * @param eldest 最少访问的entry
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        logger.info("eldest.getKey():" + eldest.getKey());
        return this.size() > maxSize;
    }

}
