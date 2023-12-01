package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/is.class */
public final class is {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator f41537a = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/is$a.class */
    static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? is.a((List) obj, (List) obj2) : obj instanceof Set ? is.a((Set) obj, (Set) obj2) : obj instanceof Map ? is.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? is.a((byte[]) obj, (byte[]) obj2) : is.a((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy((Object) byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), (Object) bArr, i, remaining);
        return remaining;
    }

    public static int a(List list, List list2) {
        int a2 = a(list.size(), list2.size());
        if (a2 != 0) {
            return a2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return 0;
            }
            int compare = f41537a.compare(list.get(i2), list2.get(i2));
            if (compare != 0) {
                return compare;
            }
            i = i2 + 1;
        }
    }

    public static int a(Map map, Map map2) {
        int a2 = a(map.size(), map2.size());
        if (a2 != 0) {
            return a2;
        }
        TreeMap treeMap = new TreeMap(f41537a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f41537a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f41537a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f41537a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int a2 = a(set.size(), set2.size());
        if (a2 != 0) {
            return a2;
        }
        TreeSet treeSet = new TreeSet(f41537a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f41537a);
        treeSet2.addAll(set2);
        Iterator<E> it = treeSet.iterator();
        Iterator<E> it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f41537a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    public static int a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a2 = a(bArr.length, bArr2.length);
        if (a2 != 0) {
            return a2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return 0;
            }
            int a3 = a(bArr[i2], bArr2[i2]);
            if (a3 != 0) {
                return a3;
            }
            i = i2 + 1;
        }
    }

    public static String a(byte b) {
        return Integer.toHexString((b | 256) & 511).toUpperCase().substring(1);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        return m12025a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m12026a(byteBuffer));
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        int i2 = arrayOffset;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            if (i3 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(a(array[i3]));
            i2 = i3 + 1;
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m12025a(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m12026a(ByteBuffer byteBuffer) {
        if (m12025a(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }
}
