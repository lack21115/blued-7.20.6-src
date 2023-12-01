package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLKey.class */
public class CLKey extends CLContainer {
    private static ArrayList<String> g;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        g = arrayList;
        arrayList.add("ConstraintSets");
        g.add("Variables");
        g.add("Generate");
        g.add(TypedValues.TransitionType.NAME);
        g.add("KeyFrames");
        g.add(TypedValues.AttributesType.NAME);
        g.add("KeyPositions");
        g.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0L);
        cLKey.setEnd(str.length() - 1);
        cLKey.set(cLElement);
        return cLKey;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.f2071a.size() > 0) {
            return this.f2071a.get(0);
        }
        return null;
    }

    public void set(CLElement cLElement) {
        if (this.f2071a.size() > 0) {
            this.f2071a.set(0, cLElement);
        } else {
            this.f2071a.add(cLElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(b());
        a(sb, i);
        String content = content();
        if (this.f2071a.size() <= 0) {
            return content + ": <> ";
        }
        sb.append(content);
        sb.append(": ");
        if (g.contains(content)) {
            i2 = 3;
        }
        if (i2 > 0) {
            sb.append(this.f2071a.get(0).toFormattedJSON(i, i2 - 1));
        } else {
            String json = this.f2071a.get(0).toJSON();
            if (json.length() + i < e) {
                sb.append(json);
            } else {
                sb.append(this.f2071a.get(0).toFormattedJSON(i, i2 - 1));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (this.f2071a.size() <= 0) {
            return b() + content() + ": <> ";
        }
        return b() + content() + ": " + this.f2071a.get(0).toJSON();
    }
}
