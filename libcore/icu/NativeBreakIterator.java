package libcore.icu;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeBreakIterator.class */
public final class NativeBreakIterator implements Cloneable {
    private static final int BI_CHAR_INSTANCE = 1;
    private static final int BI_LINE_INSTANCE = 3;
    private static final int BI_SENT_INSTANCE = 4;
    private static final int BI_WORD_INSTANCE = 2;
    private final long address;
    private CharacterIterator charIterator = new StringCharacterIterator("");
    private String string;
    private final int type;

    private NativeBreakIterator(long j, int i) {
        this.address = j;
        this.type = i;
    }

    private static native synchronized long cloneImpl(long j);

    private static native synchronized void closeImpl(long j);

    private static native synchronized int currentImpl(long j, String str);

    private static native synchronized int firstImpl(long j, String str);

    private static native synchronized int followingImpl(long j, String str, int i);

    public static NativeBreakIterator getCharacterInstance(Locale locale) {
        return new NativeBreakIterator(getCharacterInstanceImpl(locale.toLanguageTag()), 1);
    }

    private static native long getCharacterInstanceImpl(String str);

    public static NativeBreakIterator getLineInstance(Locale locale) {
        return new NativeBreakIterator(getLineInstanceImpl(locale.toLanguageTag()), 3);
    }

    private static native long getLineInstanceImpl(String str);

    public static NativeBreakIterator getSentenceInstance(Locale locale) {
        return new NativeBreakIterator(getSentenceInstanceImpl(locale.toLanguageTag()), 4);
    }

    private static native long getSentenceInstanceImpl(String str);

    public static NativeBreakIterator getWordInstance(Locale locale) {
        return new NativeBreakIterator(getWordInstanceImpl(locale.toLanguageTag()), 2);
    }

    private static native long getWordInstanceImpl(String str);

    private static native synchronized boolean isBoundaryImpl(long j, String str, int i);

    private static native synchronized int lastImpl(long j, String str);

    private static native synchronized int nextImpl(long j, String str, int i);

    private static native synchronized int precedingImpl(long j, String str, int i);

    private static native synchronized int previousImpl(long j, String str);

    private void setText(String str, CharacterIterator characterIterator) {
        this.string = str;
        this.charIterator = characterIterator;
        setTextImpl(this.address, this.string);
    }

    private static native synchronized void setTextImpl(long j, String str);

    public Object clone() {
        NativeBreakIterator nativeBreakIterator = new NativeBreakIterator(cloneImpl(this.address), this.type);
        nativeBreakIterator.string = this.string;
        nativeBreakIterator.charIterator = this.charIterator;
        return nativeBreakIterator;
    }

    public int current() {
        return currentImpl(this.address, this.string);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NativeBreakIterator) {
            NativeBreakIterator nativeBreakIterator = (NativeBreakIterator) obj;
            return this.type == nativeBreakIterator.type && this.charIterator.equals(nativeBreakIterator.charIterator);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            closeImpl(this.address);
        } finally {
            super.finalize();
        }
    }

    public int first() {
        return firstImpl(this.address, this.string);
    }

    public int following(int i) {
        return followingImpl(this.address, this.string, i);
    }

    public CharacterIterator getText() {
        this.charIterator.setIndex(currentImpl(this.address, this.string));
        return this.charIterator;
    }

    public boolean hasText() {
        return this.string != null;
    }

    public int hashCode() {
        return 42;
    }

    public boolean isBoundary(int i) {
        return isBoundaryImpl(this.address, this.string, i);
    }

    public int last() {
        return lastImpl(this.address, this.string);
    }

    public int next() {
        return nextImpl(this.address, this.string, 1);
    }

    public int next(int i) {
        return nextImpl(this.address, this.string, i);
    }

    public int preceding(int i) {
        return precedingImpl(this.address, this.string, i);
    }

    public int previous() {
        return previousImpl(this.address, this.string);
    }

    public void setText(String str) {
        setText(str, new StringCharacterIterator(str));
    }

    public void setText(CharacterIterator characterIterator) {
        StringBuilder sb = new StringBuilder();
        char first = characterIterator.first();
        while (true) {
            char c = first;
            if (c == 65535) {
                setText(sb.toString(), characterIterator);
                return;
            } else {
                sb.append(c);
                first = characterIterator.next();
            }
        }
    }
}
