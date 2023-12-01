package java.util.regex;

/* loaded from: source-2895416-dex2jar.jar:java/util/regex/Matcher.class */
public final class Matcher implements MatchResult {
    private long address;
    private boolean anchoringBounds = true;
    private int appendPos;
    private String input;
    private boolean matchFound;
    private int[] matchOffsets;
    private Pattern pattern;
    private int regionEnd;
    private int regionStart;
    private boolean transparentBounds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matcher(Pattern pattern, CharSequence charSequence) {
        usePattern(pattern);
        reset(charSequence);
    }

    private void appendEvaluated(StringBuffer stringBuffer, String str) {
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt == '\\' && !z) {
                z = true;
            } else if (charAt == '$' && !z) {
                z2 = true;
            } else if (charAt < '0' || charAt > '9' || !z2) {
                stringBuffer.append(charAt);
                z2 = false;
                z = false;
            } else {
                stringBuffer.append(group(charAt - '0'));
                z2 = false;
            }
            i = i2 + 1;
        }
        if (z) {
            throw new ArrayIndexOutOfBoundsException(str.length());
        }
    }

    private static native void closeImpl(long j);

    private void ensureMatch() {
        if (!this.matchFound) {
            throw new IllegalStateException("No successful match so far");
        }
    }

    private static native boolean findImpl(long j, String str, int i, int[] iArr);

    private static native boolean findNextImpl(long j, String str, int[] iArr);

    private static native int groupCountImpl(long j);

    private static native boolean hitEndImpl(long j);

    private static native boolean lookingAtImpl(long j, String str, int[] iArr);

    private static native boolean matchesImpl(long j, String str, int[] iArr);

    private static native long openImpl(long j);

    public static String quoteReplacement(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == '\\' || charAt == '$') {
                sb.append('\\');
            }
            sb.append(charAt);
            i = i2 + 1;
        }
    }

    private static native boolean requireEndImpl(long j);

    private Matcher reset(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (i < 0 || i2 < 0 || i > charSequence.length() || i2 > charSequence.length() || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        this.input = charSequence.toString();
        this.regionStart = i;
        this.regionEnd = i2;
        resetForInput();
        this.matchFound = false;
        this.appendPos = 0;
        return this;
    }

    private void resetForInput() {
        synchronized (this) {
            setInputImpl(this.address, this.input, this.regionStart, this.regionEnd);
            useAnchoringBoundsImpl(this.address, this.anchoringBounds);
            useTransparentBoundsImpl(this.address, this.transparentBounds);
        }
    }

    private static native void setInputImpl(long j, String str, int i, int i2);

    private static native void useAnchoringBoundsImpl(long j, boolean z);

    private static native void useTransparentBoundsImpl(long j, boolean z);

    public Matcher appendReplacement(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.input.substring(this.appendPos, start()));
        appendEvaluated(stringBuffer, str);
        this.appendPos = end();
        return this;
    }

    public StringBuffer appendTail(StringBuffer stringBuffer) {
        if (this.appendPos < this.regionEnd) {
            stringBuffer.append(this.input.substring(this.appendPos, this.regionEnd));
        }
        return stringBuffer;
    }

    @Override // java.util.regex.MatchResult
    public int end() {
        return end(0);
    }

    @Override // java.util.regex.MatchResult
    public int end(int i) {
        ensureMatch();
        return this.matchOffsets[(i * 2) + 1];
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                closeImpl(this.address);
            }
        } finally {
            super.finalize();
        }
    }

    public boolean find() {
        synchronized (this) {
            this.matchFound = findNextImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public boolean find(int i) {
        if (i < 0 || i > this.input.length()) {
            throw new IndexOutOfBoundsException("start=" + i + "; length=" + this.input.length());
        }
        synchronized (this) {
            this.matchFound = findImpl(this.address, this.input, i, this.matchOffsets);
        }
        return this.matchFound;
    }

    @Override // java.util.regex.MatchResult
    public String group() {
        return group(0);
    }

    @Override // java.util.regex.MatchResult
    public String group(int i) {
        ensureMatch();
        int i2 = this.matchOffsets[i * 2];
        int i3 = this.matchOffsets[(i * 2) + 1];
        if (i2 == -1 || i3 == -1) {
            return null;
        }
        return this.input.substring(i2, i3);
    }

    @Override // java.util.regex.MatchResult
    public int groupCount() {
        int groupCountImpl;
        synchronized (this) {
            groupCountImpl = groupCountImpl(this.address);
        }
        return groupCountImpl;
    }

    public boolean hasAnchoringBounds() {
        return this.anchoringBounds;
    }

    public boolean hasTransparentBounds() {
        return this.transparentBounds;
    }

    public boolean hitEnd() {
        boolean hitEndImpl;
        synchronized (this) {
            hitEndImpl = hitEndImpl(this.address);
        }
        return hitEndImpl;
    }

    public boolean lookingAt() {
        synchronized (this) {
            this.matchFound = lookingAtImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public boolean matches() {
        synchronized (this) {
            this.matchFound = matchesImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public Pattern pattern() {
        return this.pattern;
    }

    public Matcher region(int i, int i2) {
        return reset(this.input, i, i2);
    }

    public int regionEnd() {
        return this.regionEnd;
    }

    public int regionStart() {
        return this.regionStart;
    }

    public String replaceAll(String str) {
        reset();
        StringBuffer stringBuffer = new StringBuffer(this.input.length());
        while (find()) {
            appendReplacement(stringBuffer, str);
        }
        return appendTail(stringBuffer).toString();
    }

    public String replaceFirst(String str) {
        reset();
        StringBuffer stringBuffer = new StringBuffer(this.input.length());
        if (find()) {
            appendReplacement(stringBuffer, str);
        }
        return appendTail(stringBuffer).toString();
    }

    public boolean requireEnd() {
        boolean requireEndImpl;
        synchronized (this) {
            requireEndImpl = requireEndImpl(this.address);
        }
        return requireEndImpl;
    }

    public Matcher reset() {
        return reset(this.input, 0, this.input.length());
    }

    public Matcher reset(CharSequence charSequence) {
        return reset(charSequence, 0, charSequence.length());
    }

    @Override // java.util.regex.MatchResult
    public int start() {
        return start(0);
    }

    @Override // java.util.regex.MatchResult
    public int start(int i) throws IllegalStateException {
        ensureMatch();
        return this.matchOffsets[i * 2];
    }

    public MatchResult toMatchResult() {
        ensureMatch();
        return new MatchResultImpl(this.input, this.matchOffsets);
    }

    public String toString() {
        return getClass().getName() + "[pattern=" + pattern() + " region=" + regionStart() + "," + regionEnd() + " lastmatch=" + (this.matchFound ? group() : "") + "]";
    }

    public Matcher useAnchoringBounds(boolean z) {
        synchronized (this) {
            this.anchoringBounds = z;
            useAnchoringBoundsImpl(this.address, z);
        }
        return this;
    }

    public Matcher usePattern(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern == null");
        }
        this.pattern = pattern;
        synchronized (this) {
            if (this.address != 0) {
                closeImpl(this.address);
                this.address = 0L;
            }
            this.address = openImpl(pattern.address);
        }
        if (this.input != null) {
            resetForInput();
        }
        this.matchOffsets = new int[(groupCount() + 1) * 2];
        this.matchFound = false;
        return this;
    }

    public Matcher useTransparentBounds(boolean z) {
        synchronized (this) {
            this.transparentBounds = z;
            useTransparentBoundsImpl(this.address, z);
        }
        return this;
    }
}
