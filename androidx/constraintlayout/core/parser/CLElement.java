package androidx.constraintlayout.core.parser;

import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLElement.class */
public class CLElement {
    protected static int e = 80;
    protected static int f = 2;

    /* renamed from: a  reason: collision with root package name */
    private final char[] f2024a;
    protected long b = -1;

    /* renamed from: c  reason: collision with root package name */
    protected long f2025c = Long.MAX_VALUE;
    protected CLContainer d;
    private int g;

    public CLElement(char[] cArr) {
        this.f2024a = cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(StringBuilder sb, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            sb.append(' ');
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        if (CLParser.f2029a) {
            return a() + " -> ";
        }
        return "";
    }

    public String content() {
        String str = new String(this.f2024a);
        long j = this.f2025c;
        if (j != Long.MAX_VALUE) {
            long j2 = this.b;
            if (j >= j2) {
                return str.substring((int) j2, ((int) j) + 1);
            }
        }
        long j3 = this.b;
        return str.substring((int) j3, ((int) j3) + 1);
    }

    public CLElement getContainer() {
        return this.d;
    }

    public long getEnd() {
        return this.f2025c;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.g;
    }

    public long getStart() {
        return this.b;
    }

    public boolean isDone() {
        return this.f2025c != Long.MAX_VALUE;
    }

    public boolean isStarted() {
        return this.b > -1;
    }

    public boolean notStarted() {
        return this.b == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.d = cLContainer;
    }

    public void setEnd(long j) {
        if (this.f2025c != Long.MAX_VALUE) {
            return;
        }
        this.f2025c = j;
        if (CLParser.f2029a) {
            PrintStream printStream = System.out;
            printStream.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.d;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    public void setLine(int i) {
        this.g = i;
    }

    public void setStart(long j) {
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toFormattedJSON(int i, int i2) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toJSON() {
        return "";
    }

    public String toString() {
        long j = this.b;
        long j2 = this.f2025c;
        if (j > j2 || j2 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f2025c + ")";
        }
        String substring = new String(this.f2024a).substring((int) this.b, ((int) this.f2025c) + 1);
        return a() + " (" + this.b + " : " + this.f2025c + ") <<" + substring + ">>";
    }
}
