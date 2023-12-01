package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/SizeConfigStrategy.class */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] a = {Bitmap.Config.ARGB_8888, null};
    private static final Bitmap.Config[] b = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] c = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] d = {Bitmap.Config.ALPHA_8};
    private final KeyPool e = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> f = new GroupedLinkedMap<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.glide.SizeConfigStrategy$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/SizeConfigStrategy$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/SizeConfigStrategy$Key.class */
    public static final class Key implements Poolable {
        int a;
        private final KeyPool b;
        private Bitmap.Config c;

        public Key(KeyPool keyPool) {
            this.b = keyPool;
        }

        @Override // com.blued.android.core.imagecache.glide.Poolable
        public void a() {
            this.b.a(this);
        }

        public void a(int i, Bitmap.Config config) {
            this.a = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                Key key = (Key) obj;
                z = false;
                if (this.a == key.a) {
                    z = false;
                    if (Util.a(this.c, key.c)) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            int i = this.a;
            Bitmap.Config config = this.c;
            return (i * 31) + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.a(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/SizeConfigStrategy$KeyPool.class */
    public static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.core.imagecache.glide.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        public Key a(int i, Bitmap.Config config) {
            Key c = c();
            c.a(i, config);
            return c;
        }
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.g.get(config);
        TreeMap treeMap = navigableMap;
        if (navigableMap == null) {
            treeMap = new TreeMap();
            this.g.put(config, treeMap);
        }
        return treeMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = a2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                a2.remove(num);
                return;
            } else {
                a2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    private Key b(int i, Bitmap.Config config) {
        Key a2 = this.e.a(i, config);
        Bitmap.Config[] b2 = b(config);
        int length = b2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = b2[i3];
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey == null || ceilingKey.intValue() > i * 8) {
                i2 = i3 + 1;
            } else if (ceilingKey.intValue() != i || (config2 != null ? !config2.equals(config) : config != null)) {
                this.e.a(a2);
                return this.e.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        int i = AnonymousClass1.a[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : d : c : b : a;
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public Bitmap a() {
        Bitmap a2 = this.f.a();
        if (a2 != null) {
            a(Integer.valueOf(Util.a(a2)), a2);
        }
        return a2;
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Key b2 = b(Util.a(i, i2, config), config);
        Bitmap a2 = this.f.a((GroupedLinkedMap<Key, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.a), a2);
            a2.reconfigure(i, i2, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public void a(Bitmap bitmap) {
        Key a2 = this.e.a(Util.a(bitmap), bitmap.getConfig());
        this.f.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = a3.get(Integer.valueOf(a2.a));
        int i = a2.a;
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public String b(int i, int i2, Bitmap.Config config) {
        return a(Util.a(i, i2, config), config);
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public String b(Bitmap bitmap) {
        return a(Util.a(bitmap), bitmap.getConfig());
    }

    @Override // com.blued.android.core.imagecache.glide.LruPoolStrategy
    public int c(Bitmap bitmap) {
        return Util.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.g.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.g.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
