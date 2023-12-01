package androidx.constraintlayout.core.parser;

import com.huawei.hms.ads.fw;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLToken.class */
public class CLToken extends CLElement {

    /* renamed from: a  reason: collision with root package name */
    int f2035a;
    Type g;
    char[] h;
    char[] i;
    char[] j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLToken$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2036a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Type.values().length];
            f2036a = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2036a[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2036a[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2036a[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLToken$Type.class */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.f2035a = 0;
        this.g = Type.UNKNOWN;
        this.h = fw.Code.toCharArray();
        this.i = "false".toCharArray();
        this.j = b.l.toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        if (this.g == Type.TRUE) {
            return true;
        }
        if (this.g == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + SimpleComparison.GREATER_THAN_OPERATION, this);
    }

    public Type getType() {
        return this.g;
    }

    public boolean isNull() throws CLParsingException {
        if (this.g == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + SimpleComparison.GREATER_THAN_OPERATION, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        a(sb, i);
        sb.append(content());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (CLParser.f2029a) {
            return SimpleComparison.LESS_THAN_OPERATION + content() + SimpleComparison.GREATER_THAN_OPERATION;
        }
        return content();
    }

    public boolean validate(char c2, long j) {
        boolean z;
        int i = AnonymousClass1.f2036a[this.g.ordinal()];
        boolean z2 = false;
        if (i == 1) {
            boolean z3 = false;
            if (this.h[this.f2035a] == c2) {
                z3 = true;
            }
            z = z3;
            if (z3) {
                z = z3;
                if (this.f2035a + 1 == this.h.length) {
                    setEnd(j);
                    z = z3;
                }
            }
        } else if (i == 2) {
            boolean z4 = false;
            if (this.i[this.f2035a] == c2) {
                z4 = true;
            }
            z = z4;
            if (z4) {
                z = z4;
                if (this.f2035a + 1 == this.i.length) {
                    setEnd(j);
                    z = z4;
                }
            }
        } else if (i == 3) {
            if (this.j[this.f2035a] == c2) {
                z2 = true;
            }
            z = z2;
            if (z2) {
                z = z2;
                if (this.f2035a + 1 == this.j.length) {
                    setEnd(j);
                    z = z2;
                }
            }
        } else if (i != 4) {
            z = false;
        } else {
            char[] cArr = this.h;
            int i2 = this.f2035a;
            if (cArr[i2] == c2) {
                this.g = Type.TRUE;
            } else if (this.i[i2] == c2) {
                this.g = Type.FALSE;
            } else {
                z = false;
                if (this.j[i2] == c2) {
                    this.g = Type.NULL;
                }
            }
            z = true;
        }
        this.f2035a++;
        return z;
    }
}
