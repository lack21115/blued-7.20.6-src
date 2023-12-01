package java.util.regex;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/util/regex/PatternSyntaxException.class */
public class PatternSyntaxException extends IllegalArgumentException {
    private static final long serialVersionUID = -3864639126226059218L;
    private String desc;
    private int index;
    private String pattern;

    public PatternSyntaxException(String str, String str2, int i) {
        this.index = -1;
        this.desc = str;
        this.pattern = str2;
        this.index = i;
    }

    public String getDescription() {
        return this.desc;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.desc != null) {
            sb.append(this.desc);
        }
        if (this.index >= 0) {
            if (this.desc != null) {
                sb.append(' ');
            }
            sb.append("near index ");
            sb.append(this.index);
            sb.append(':');
        }
        if (this.pattern != null) {
            sb.append('\n');
            sb.append(this.pattern);
            if (this.index >= 0) {
                char[] cArr = new char[this.index];
                Arrays.fill(cArr, ' ');
                sb.append('\n');
                sb.append(cArr);
                sb.append('^');
            }
        }
        return sb.toString();
    }

    public String getPattern() {
        return this.pattern;
    }
}
