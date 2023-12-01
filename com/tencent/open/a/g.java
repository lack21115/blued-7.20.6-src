package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/g.class */
public class g implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f24547a;
    private AtomicInteger b;

    public g() {
        this.f24547a = null;
        this.b = null;
        this.f24547a = new ConcurrentLinkedQueue<>();
        this.b = new AtomicInteger(0);
    }

    public int a() {
        return this.b.get();
    }

    public int a(String str) {
        int length = str.length();
        this.f24547a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i = length;
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i3 = 0;
            int i4 = i;
            int i5 = i2;
            while (true) {
                i2 = i5;
                i = i4;
                if (length2 > 0) {
                    int i6 = i4 > length2 ? length2 : i4;
                    int i7 = i3 + i6;
                    next.getChars(i3, i7, cArr, i5);
                    i4 -= i6;
                    i5 += i6;
                    length2 -= i6;
                    if (i4 == 0) {
                        writer.write(cArr, 0, length);
                        i4 = length;
                        i3 = i7;
                        i5 = 0;
                    } else {
                        i3 = i7;
                    }
                }
            }
        }
        if (i2 > 0) {
            writer.write(cArr, 0, i2);
        }
        writer.flush();
    }

    public void b() {
        this.f24547a.clear();
        this.b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f24547a.iterator();
    }
}
