package concurrent.lessonreadwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ErrorCache1<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        // 读缓存
        try {
            r.lock();
            v = m.get(key);
            // 缓存中存在，返回
            if (v != null) {
                return v;
            }
            // 在没有解开读锁的情况下，直接获取了写锁。
            // 这种操作被称为锁的升级。Java中对于锁的升级不支持。会导致w.lock获取写锁阻塞
            w.lock();
            try {
                // 再次验证
                // 其他线程可能已经查询过数据库
                v = m.get(key);
                if (v == null) {
                    // 查询数据库
                    //省略代码无数
                    v = (V) new Object();
                    m.put(key, v);
                }
            } finally {
                w.unlock();
            }
        } finally {
            r.unlock();
        }

        return v;
    }
}
