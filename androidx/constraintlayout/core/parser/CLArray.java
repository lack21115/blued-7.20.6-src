package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLArray.class */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i2 > 0 || json.length() + i >= e) {
            sb.append("[\n");
            Iterator<CLElement> it = this.f2071a.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (z) {
                    z = false;
                } else {
                    sb.append(",\n");
                }
                a(sb, f + i);
                sb.append(next.toFormattedJSON(f + i, i2 - 1));
            }
            sb.append("\n");
            a(sb, i);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(b() + "[");
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2071a.size()) {
                return ((Object) sb) + "]";
            }
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.f2071a.get(i2).toJSON());
            i = i2 + 1;
        }
    }
}
