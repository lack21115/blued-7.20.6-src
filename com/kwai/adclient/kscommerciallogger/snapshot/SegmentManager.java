package com.kwai.adclient.kscommerciallogger.snapshot;

import android.text.TextUtils;
import android.util.LruCache;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/snapshot/SegmentManager.class */
public enum SegmentManager {
    Instance;
    
    private static final int expiredThresholds = 900000;
    private long lastAutoClearTime;
    private LruCache<String, Set<c>> mSnapshots;
    private boolean isDebug = false;
    private boolean hasInit = false;

    SegmentManager() {
    }

    private void autoClear() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null || lruCache.size() == 0 || System.currentTimeMillis() - this.lastAutoClearTime < 900000) {
            return;
        }
        this.lastAutoClearTime = System.currentTimeMillis();
        for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
            String key = entry.getKey();
            Set<c> value = entry.getValue();
            if (value != null) {
                Iterator<c> it = value.iterator();
                this.mSnapshots.remove(key);
                while (it.hasNext()) {
                    if (this.lastAutoClearTime - it.next().Gg() >= 900000) {
                        it.remove();
                    }
                }
                if (value.size() > 0) {
                    this.mSnapshots.put(key, value);
                }
            }
        }
    }

    public final int cacheLimit() {
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache == null) {
            return 0;
        }
        return lruCache.maxSize();
    }

    @Deprecated
    public final void clearBySegment(String str) {
        if (TextUtils.isEmpty(str) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
                clearBySegment(entry.getKey(), str);
            }
        }
    }

    public final void clearBySegment(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            c cVar = new c(str2);
            if (set != null && set.contains(cVar)) {
                this.mSnapshots.remove(str);
                set.remove(cVar);
                if (set.size() > 0) {
                    this.mSnapshots.put(str, set);
                }
            }
            autoClear();
        }
    }

    public final void clearBySessionId(String str) {
        if (TextUtils.isEmpty(str) || this.mSnapshots == null) {
            return;
        }
        synchronized (this) {
            this.mSnapshots.remove(str);
            autoClear();
        }
    }

    public final void init(int i, boolean z) {
        synchronized (this) {
            if (!this.hasInit) {
                this.isDebug = z;
                if (i > 0) {
                    this.mSnapshots = new LruCache<String, Set<c>>(i) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.1
                        private static int d(Set<c> set) {
                            return set.size();
                        }

                        @Override // android.util.LruCache
                        protected final /* synthetic */ int sizeOf(String str, Set<c> set) {
                            return d(set);
                        }
                    };
                }
                this.hasInit = true;
            }
        }
    }

    public final boolean isOverThreshold() {
        synchronized (this) {
            if (cacheLimit() > 0 && segmentSize() != 0) {
                return BigDecimal.valueOf((double) (((float) segmentSize()) / ((float) cacheLimit()))).setScale(2, RoundingMode.HALF_UP).doubleValue() >= 0.7d;
            }
            return false;
        }
    }

    public final JSONArray justLoadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache != null && lruCache.size() != 0) {
            synchronized (this) {
                Set<c> set = this.mSnapshots.get(str);
                if (set != null) {
                    for (c cVar : set) {
                        jSONArray.put(cVar.fi(str));
                    }
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }

    public final JSONArray loadInfoBySessionId(String str) {
        JSONArray jSONArray = new JSONArray();
        LruCache<String, Set<c>> lruCache = this.mSnapshots;
        if (lruCache != null && lruCache.size() != 0) {
            synchronized (this) {
                Set<c> set = this.mSnapshots.get(str);
                if (set != null) {
                    for (c cVar : set) {
                        jSONArray.put(cVar.fi(str));
                    }
                    this.mSnapshots.remove(str);
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }

    public final c loadSegment(String str, String str2) {
        return loadSegment(str, str2, 10);
    }

    public final c loadSegment(String str, String str2, int i) {
        c next;
        if (this.mSnapshots == null) {
            if (this.hasInit || !this.isDebug) {
                return new a("empty");
            }
            throw new IllegalStateException("you need init first");
        }
        synchronized (this) {
            Set<c> set = this.mSnapshots.get(str);
            if (set != null) {
                Iterator<c> it = set.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    }
                } while (!next.getName().equals(str2));
                return next;
            }
            c cVar = new c(str2, i);
            if (set != null) {
                this.mSnapshots.remove(str);
                set.add(cVar);
                this.mSnapshots.put(str, set);
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(cVar);
                this.mSnapshots.put(str, linkedHashSet);
            }
            autoClear();
            return cVar;
        }
    }

    public final String loadSessionId() {
        return UUID.randomUUID().toString();
    }

    public final d loadSpan(String str, String str2) {
        return loadSpan(str, str2, "span");
    }

    public final d loadSpan(String str, String str2, String str3) {
        return loadSegment(str, str2).fh(str3);
    }

    public final Map.Entry<String, Integer> mostUsedSegmentInfo() {
        Map.Entry<String, Integer> entry;
        String name;
        Integer valueOf;
        synchronized (this) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Set<c>> entry2 : this.mSnapshots.snapshot().entrySet()) {
                for (c cVar : entry2.getValue()) {
                    Integer num = (Integer) hashMap.get(cVar.getName());
                    if (num == null) {
                        name = cVar.getName();
                        valueOf = 1;
                    } else {
                        name = cVar.getName();
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    hashMap.put(name, valueOf);
                }
            }
            entry = (Map.Entry) Collections.max(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, Integer>>() { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.2
                private static int a(Map.Entry<String, Integer> entry3, Map.Entry<String, Integer> entry4) {
                    return entry3.getValue().compareTo(entry4.getValue());
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Map.Entry<String, Integer> entry3, Map.Entry<String, Integer> entry4) {
                    return a(entry3, entry4);
                }
            });
        }
        return entry;
    }

    public final int segmentSize() {
        synchronized (this) {
            if (this.mSnapshots == null) {
                return 0;
            }
            return this.mSnapshots.size();
        }
    }

    public final int size() {
        synchronized (this) {
            if (this.mSnapshots == null) {
                return 0;
            }
            return this.mSnapshots.snapshot().size();
        }
    }
}
