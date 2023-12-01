package java.text;

import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;

/* loaded from: source-2895416-dex2jar.jar:java/text/BreakIterator.class */
public abstract class BreakIterator implements Cloneable {
    public static final int DONE = -1;
    NativeBreakIterator wrapped;

    protected BreakIterator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BreakIterator(NativeBreakIterator nativeBreakIterator) {
        this.wrapped = nativeBreakIterator;
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableBreakIteratorLocales();
    }

    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    public static BreakIterator getCharacterInstance(Locale locale) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getCharacterInstance(locale));
    }

    public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    public static BreakIterator getLineInstance(Locale locale) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getLineInstance(locale));
    }

    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    public static BreakIterator getSentenceInstance(Locale locale) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getSentenceInstance(locale));
    }

    public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    public static BreakIterator getWordInstance(Locale locale) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getWordInstance(locale));
    }

    public Object clone() {
        try {
            BreakIterator breakIterator = (BreakIterator) super.clone();
            breakIterator.wrapped = (NativeBreakIterator) this.wrapped.clone();
            return breakIterator;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public abstract int current();

    public abstract int first();

    public abstract int following(int i);

    public abstract CharacterIterator getText();

    public boolean isBoundary(int i) {
        return this.wrapped.isBoundary(i);
    }

    public abstract int last();

    public abstract int next();

    public abstract int next(int i);

    public int preceding(int i) {
        return this.wrapped.preceding(i);
    }

    public abstract int previous();

    public void setText(String str) {
        if (str == null) {
            throw new NullPointerException("newText == null");
        }
        this.wrapped.setText(str);
    }

    public abstract void setText(CharacterIterator characterIterator);
}
