package androidx.constraintlayout.core.parser;

import com.alipay.sdk.util.i;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLObject.class */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLObject$CLObjectIterator.class */
    class CLObjectIterator implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        CLObject f2075a;
        int b = 0;

        public CLObjectIterator(CLObject cLObject) {
            this.f2075a = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f2075a.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.f2075a.f2071a.get(this.b);
            this.b++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(b());
        sb.append("{\n");
        Iterator<CLElement> it = this.f2071a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(",\n");
            }
            sb.append(next.toFormattedJSON(f + i, i2 - 1));
        }
        sb.append("\n");
        a(sb, i);
        sb.append(i.d);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(b() + "{ ");
        Iterator<CLElement> it = this.f2071a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }
}
