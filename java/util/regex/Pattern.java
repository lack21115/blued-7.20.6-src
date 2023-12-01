package java.util.regex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/regex/Pattern.class */
public final class Pattern implements Serializable {
    public static final int CANON_EQ = 128;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int DOTALL = 32;
    public static final int LITERAL = 16;
    public static final int MULTILINE = 8;
    public static final int UNICODE_CASE = 64;
    public static final int UNIX_LINES = 1;
    private static final long serialVersionUID = 5073258162644648461L;
    transient long address;
    private final int flags;
    private final String pattern;

    private Pattern(String str, int i) throws PatternSyntaxException {
        if ((i & 128) != 0) {
            throw new UnsupportedOperationException("CANON_EQ flag not supported");
        }
        if ((i & (-128)) != 0) {
            throw new IllegalArgumentException("Unsupported flags: " + (i & (-128)));
        }
        this.pattern = str;
        this.flags = i;
        compile();
    }

    private static native void closeImpl(long j);

    public static Pattern compile(String str) {
        return new Pattern(str, 0);
    }

    public static Pattern compile(String str, int i) throws PatternSyntaxException {
        return new Pattern(str, i);
    }

    private void compile() throws PatternSyntaxException {
        if (this.pattern == null) {
            throw new NullPointerException("pattern == null");
        }
        String str = this.pattern;
        if ((this.flags & 16) != 0) {
            str = quote(this.pattern);
        }
        this.address = compileImpl(str, this.flags & 47);
    }

    private static native long compileImpl(String str, int i);

    public static boolean matches(String str, CharSequence charSequence) {
        return new Matcher(new Pattern(str, 0), charSequence).matches();
    }

    public static String quote(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\Q");
        int i = 0;
        while (true) {
            int i2 = i;
            int indexOf = str.indexOf("\\E", i2);
            if (indexOf < 0) {
                return sb.append(str.substring(i2)).append("\\E").toString();
            }
            sb.append(str.substring(i2, indexOf + 2)).append("\\\\E\\Q");
            i = indexOf + 2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        compile();
    }

    protected void finalize() throws Throwable {
        try {
            closeImpl(this.address);
        } finally {
            super.finalize();
        }
    }

    public int flags() {
        return this.flags;
    }

    public Matcher matcher(CharSequence charSequence) {
        return new Matcher(this, charSequence);
    }

    public String pattern() {
        return this.pattern;
    }

    public String[] split(CharSequence charSequence) {
        return split(charSequence, 0);
    }

    public String[] split(CharSequence charSequence, int i) {
        return Splitter.split(this, this.pattern, charSequence.toString(), i);
    }

    public String toString() {
        return this.pattern;
    }
}
