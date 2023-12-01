package com.opos.exoplayer.core.f.f;

import android.media.TtmlUtils;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/f/c.class */
final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f11693a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11694c;
    public final long d;
    public final long e;
    public final b f;
    public final String g;
    private final String[] h;
    private final HashMap<String, Integer> i;
    private final HashMap<String, Integer> j;
    private List<c> k;

    private c(String str, String str2, long j, long j2, b bVar, String[] strArr, String str3) {
        this.f11693a = str;
        this.b = str2;
        this.f = bVar;
        this.h = strArr;
        this.f11694c = str2 != null;
        this.d = j;
        this.e = j2;
        this.g = (String) com.opos.exoplayer.core.i.a.a(str3);
        this.i = new HashMap<>();
        this.j = new HashMap<>();
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = spannableStringBuilder.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = length;
            if (spannableStringBuilder.charAt(i5) == ' ') {
                int i7 = i5 + 1;
                int i8 = i7;
                while (true) {
                    i4 = i8;
                    if (i4 >= spannableStringBuilder.length() || spannableStringBuilder.charAt(i4) != ' ') {
                        break;
                    }
                    i8 = i4 + 1;
                }
                int i9 = i4 - i7;
                i6 = length;
                if (i9 > 0) {
                    spannableStringBuilder.delete(i5, i5 + i9);
                    i6 = length - i9;
                }
            }
            i5++;
            length = i6;
        }
        int i10 = length;
        if (length > 0) {
            i10 = length;
            if (spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
                i10 = length - 1;
            }
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            i = i10;
            i2 = i - 1;
            if (i12 >= i2) {
                break;
            }
            i10 = i;
            if (spannableStringBuilder.charAt(i12) == '\n') {
                int i13 = i12 + 1;
                i10 = i;
                if (spannableStringBuilder.charAt(i13) == ' ') {
                    spannableStringBuilder.delete(i13, i12 + 2);
                    i10 = i2;
                }
            }
            i11 = i12 + 1;
        }
        int i14 = i;
        int i15 = 0;
        if (i > 0) {
            i14 = i;
            i15 = 0;
            if (spannableStringBuilder.charAt(i2) == ' ') {
                spannableStringBuilder.delete(i2, i);
                i14 = i2;
                i15 = 0;
            }
        }
        while (true) {
            i3 = i14 - 1;
            if (i15 >= i3) {
                break;
            }
            int i16 = i14;
            if (spannableStringBuilder.charAt(i15) == ' ') {
                int i17 = i15 + 1;
                i16 = i14;
                if (spannableStringBuilder.charAt(i17) == '\n') {
                    spannableStringBuilder.delete(i15, i17);
                    i16 = i3;
                }
            }
            i15++;
            i14 = i16;
        }
        if (i14 > 0 && spannableStringBuilder.charAt(i3) == '\n') {
            spannableStringBuilder.delete(i3, i14);
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    public static c a(String str) {
        return new c(null, e.a(str), com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, null, null, "");
    }

    public static c a(String str, long j, long j2, b bVar, String[] strArr, String str2) {
        return new c(str, null, j, j2, bVar, strArr, str2);
    }

    private void a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.i.clear();
        this.j.clear();
        String str2 = this.g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.f11694c && z) {
            a(str, map).append((CharSequence) this.b);
        } else if ("br".equals(this.f11693a) && z) {
            a(str, map).append('\n');
        } else if (!TtmlUtils.TAG_METADATA.equals(this.f11693a) && a(j)) {
            boolean equals = "p".equals(this.f11693a);
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a()) {
                    break;
                }
                a(i2).a(j, z || equals, str, map);
                i = i2 + 1;
            }
            if (equals) {
                e.a(a(str, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private void a(Map<String, b> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        b a2;
        if (i == i2 || (a2 = e.a(this.f, this.h, map)) == null) {
            return;
        }
        e.a(spannableStringBuilder, i, i2, a2);
    }

    private void a(Map<String, b> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.j.entrySet()) {
            String key = entry.getKey();
            a(map, map2.get(key), this.i.containsKey(key) ? this.i.get(key).intValue() : 0, entry.getValue().intValue());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a()) {
                    a(i2).a(map, map2);
                    i = i2 + 1;
                }
            }
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f11693a);
        if (z || equals) {
            long j = this.d;
            if (j != com.anythink.expressad.exoplayer.b.b) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != com.anythink.expressad.exoplayer.b.b) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.k == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return;
            }
            this.k.get(i2).a(treeSet, z || equals);
            i = i2 + 1;
        }
    }

    public int a() {
        List<c> list = this.k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public c a(int i) {
        List<c> list = this.k;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<com.opos.exoplayer.core.f.b> a(long j, Map<String, b> map, Map<String, d> map2) {
        TreeMap treeMap = new TreeMap();
        a(j, false, this.g, (Map<String, SpannableStringBuilder>) treeMap);
        a(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            d dVar = map2.get(entry.getKey());
            arrayList.add(new com.opos.exoplayer.core.f.b(a((SpannableStringBuilder) entry.getValue()), null, dVar.f11696c, dVar.d, dVar.e, dVar.b, Integer.MIN_VALUE, dVar.f));
        }
        return arrayList;
    }

    public void a(c cVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(cVar);
    }

    public boolean a(long j) {
        if (this.d == com.anythink.expressad.exoplayer.b.b && this.e == com.anythink.expressad.exoplayer.b.b) {
            return true;
        }
        if (this.d > j || this.e != com.anythink.expressad.exoplayer.b.b) {
            if (this.d != com.anythink.expressad.exoplayer.b.b || j >= this.e) {
                return this.d <= j && j < this.e;
            }
            return true;
        }
        return true;
    }

    public long[] b() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }
}
