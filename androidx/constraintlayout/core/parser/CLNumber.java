package androidx.constraintlayout.core.parser;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLNumber.class */
public class CLNumber extends CLElement {

    /* renamed from: a  reason: collision with root package name */
    float f2026a;

    public CLNumber(float f) {
        super(null);
        this.f2026a = Float.NaN;
        this.f2026a = f;
    }

    public CLNumber(char[] cArr) {
        super(cArr);
        this.f2026a = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.f2026a)) {
            this.f2026a = Float.parseFloat(content());
        }
        return this.f2026a;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.f2026a)) {
            this.f2026a = Integer.parseInt(content());
        }
        return (int) this.f2026a;
    }

    public boolean isInt() {
        float f = getFloat();
        return ((float) ((int) f)) == f;
    }

    public void putValue(float f) {
        this.f2026a = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        a(sb, i);
        float f = getFloat();
        int i3 = (int) f;
        if (i3 == f) {
            sb.append(i3);
        } else {
            sb.append(f);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f = getFloat();
        int i = (int) f;
        if (i == f) {
            return "" + i;
        }
        return "" + f;
    }
}
