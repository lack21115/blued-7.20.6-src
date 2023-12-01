package c.t.m.g;

import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x5.class */
public class x5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4012a;

    public x5(String str) {
        this.f4012a = a(str);
    }

    public static x5 b(String str) {
        return new x5(str);
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(String str) {
        if (str != null) {
            return str;
        }
        throw null;
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        Object next;
        if (it.hasNext() && (next = it.next()) != null) {
            sb.append(next.toString());
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(this.f4012a);
                sb.append(next2.toString());
            }
        }
        return sb;
    }
}
