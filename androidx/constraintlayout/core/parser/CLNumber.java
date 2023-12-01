package androidx.constraintlayout.core.parser;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLNumber.class */
public class CLNumber extends CLElement {

    /* renamed from: a  reason: collision with root package name */
    float f2074a;

    public CLNumber(float f) {
        super(null);
        this.f2074a = Float.NaN;
        this.f2074a = f;
    }

    public CLNumber(char[] cArr) {
        super(cArr);
        this.f2074a = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.f2074a)) {
            this.f2074a = Float.parseFloat(content());
        }
        return this.f2074a;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.f2074a)) {
            this.f2074a = Integer.parseInt(content());
        }
        return (int) this.f2074a;
    }

    public boolean isInt() {
        float f = getFloat();
        return ((float) ((int) f)) == f;
    }

    public void putValue(float f) {
        this.f2074a = f;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i, int i2) {
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

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        float f = getFloat();
        int i = (int) f;
        if (i == f) {
            return "" + i;
        }
        return "" + f;
    }
}
