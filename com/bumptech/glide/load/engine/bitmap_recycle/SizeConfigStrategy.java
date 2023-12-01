package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy.class */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f20813a;
    private static final Bitmap.Config[] b;

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f20814c;
    private static final Bitmap.Config[] d;
    private static final Bitmap.Config[] e;
    private final KeyPool f = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> g = new GroupedLinkedMap<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20815a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f20815a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20815a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20815a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20815a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy$Key.class */
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        int f20816a;
        private final KeyPool b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f20817c;

        public Key(KeyPool keyPool) {
            this.b = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.b.a(this);
        }

        public void a(int i, Bitmap.Config config) {
            this.f20816a = i;
            this.f20817c = config;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Key) {
                Key key = (Key) obj;
                z = false;
                if (this.f20816a == key.f20816a) {
                    z = false;
                    if (Util.a(this.f20817c, key.f20817c)) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            int i = this.f20816a;
            Bitmap.Config config = this.f20817c;
            return (i * 31) + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.a(this.f20816a, this.f20817c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy$KeyPool.class */
    public static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: a */
        public Key b() {
            return new Key(this);
        }

        public Key a(int i, Bitmap.Config config) {
            Key c2 = c();
            c2.a(i, config);
            return c2;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        Bitmap.Config[] configArr2 = configArr;
        if (Build.VERSION.SDK_INT >= 26) {
            configArr2 = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr2[configArr2.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f20813a = configArr2;
        b = configArr2;
        f20814c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.h.get(config);
        TreeMap treeMap = navigableMap;
        if (navigableMap == null) {
            treeMap = new TreeMap();
            this.h.put(config, treeMap);
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
        Key a2 = this.f.a(i, config);
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
                this.f.a(a2);
                return this.f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i = AnonymousClass1.f20815a[config.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : e : d : f20814c : f20813a;
        }
        return b;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a() {
        Bitmap a2 = this.g.a();
        if (a2 != null) {
            a(Integer.valueOf(Util.a(a2)), a2);
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Key b2 = b(Util.a(i, i2, config), config);
        Bitmap a2 = this.g.a((GroupedLinkedMap<Key, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f20816a), a2);
            a2.reconfigure(i, i2, config);
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void a(Bitmap bitmap) {
        Key a2 = this.f.a(Util.a(bitmap), bitmap.getConfig());
        this.g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = a3.get(Integer.valueOf(a2.f20816a));
        int i = a2.f20816a;
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i, int i2, Bitmap.Config config) {
        return a(Util.a(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(Bitmap bitmap) {
        return a(Util.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int c(Bitmap bitmap) {
        return Util.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
