package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/AtomicLongMap.class */
public final class AtomicLongMap<K> implements Serializable {
    @NullableDecl
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>() { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            @Override // com.google.common.base.Function
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    public long addAndGet(K k, long j) {
        AtomicLong atomicLong;
        do {
            AtomicLong atomicLong2 = this.map.get(k);
            atomicLong = atomicLong2;
            if (atomicLong2 == null) {
                AtomicLong putIfAbsent = this.map.putIfAbsent(k, new AtomicLong(j));
                atomicLong = putIfAbsent;
                if (putIfAbsent == null) {
                    return j;
                }
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 == 0) {
                    break;
                }
                long j3 = j2 + j;
                if (atomicLong.compareAndSet(j2, j3)) {
                    return j3;
                }
            }
        } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
        return j;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        Map<K, Long> map2 = map;
        if (map == null) {
            map2 = createAsMap();
            this.asMap = map2;
        }
        return map2;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public long decrementAndGet(K k) {
        return addAndGet(k, -1L);
    }

    public long get(K k) {
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    public long getAndAdd(K k, long j) {
        AtomicLong atomicLong;
        do {
            AtomicLong atomicLong2 = this.map.get(k);
            atomicLong = atomicLong2;
            if (atomicLong2 == null) {
                AtomicLong putIfAbsent = this.map.putIfAbsent(k, new AtomicLong(j));
                atomicLong = putIfAbsent;
                if (putIfAbsent == null) {
                    return 0L;
                }
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 == 0) {
                    break;
                } else if (atomicLong.compareAndSet(j2, j2 + j)) {
                    return j2;
                }
            }
        } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
        return 0L;
    }

    public long getAndDecrement(K k) {
        return getAndAdd(k, -1L);
    }

    public long getAndIncrement(K k) {
        return getAndAdd(k, 1L);
    }

    public long incrementAndGet(K k) {
        return addAndGet(k, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(K k, long j) {
        AtomicLong atomicLong;
        do {
            AtomicLong atomicLong2 = this.map.get(k);
            atomicLong = atomicLong2;
            if (atomicLong2 == null) {
                AtomicLong putIfAbsent = this.map.putIfAbsent(k, new AtomicLong(j));
                atomicLong = putIfAbsent;
                if (putIfAbsent == null) {
                    return 0L;
                }
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 == 0) {
                    break;
                } else if (atomicLong.compareAndSet(j2, j)) {
                    return j2;
                }
            }
        } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    long putIfAbsent(K k, long j) {
        AtomicLong atomicLong;
        do {
            AtomicLong atomicLong2 = this.map.get(k);
            atomicLong = atomicLong2;
            if (atomicLong2 == null) {
                AtomicLong putIfAbsent = this.map.putIfAbsent(k, new AtomicLong(j));
                atomicLong = putIfAbsent;
                if (putIfAbsent == null) {
                    return 0L;
                }
            }
            long j2 = atomicLong.get();
            if (j2 != 0) {
                return j2;
            }
        } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
        return 0L;
    }

    public long remove(K k) {
        long j;
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j = atomicLong.get();
            if (j == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j, 0L));
        this.map.remove(k, atomicLong);
        return j;
    }

    boolean remove(K k, long j) {
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return false;
        }
        long j2 = atomicLong.get();
        if (j2 != j) {
            return false;
        }
        if (j2 == 0 || atomicLong.compareAndSet(j2, 0L)) {
            this.map.remove(k, atomicLong);
            return true;
        }
        return false;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    public boolean removeIfZero(K k) {
        return remove(k, 0L);
    }

    boolean replace(K k, long j, long j2) {
        boolean z = false;
        if (j == 0) {
            if (putIfAbsent(k, j2) == 0) {
                z = true;
            }
            return z;
        }
        AtomicLong atomicLong = this.map.get(k);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j, j2);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> it = this.map.values().iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().get();
        }
    }

    public String toString() {
        return this.map.toString();
    }
}
