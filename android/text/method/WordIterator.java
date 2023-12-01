package android.text.method;

import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/WordIterator.class */
public class WordIterator implements Selection.PositionIterator {
    private static final int WINDOW_WIDTH = 50;
    private BreakIterator mIterator;
    private int mOffsetShift;
    private String mString;

    public WordIterator() {
        this(Locale.getDefault());
    }

    public WordIterator(Locale locale) {
        this.mIterator = BreakIterator.getWordInstance(locale);
    }

    private void checkOffsetIsValid(int i) {
        if (i < 0 || i > this.mString.length()) {
            throw new IllegalArgumentException("Invalid offset: " + (this.mOffsetShift + i) + ". Valid range is [" + this.mOffsetShift + ", " + (this.mString.length() + this.mOffsetShift) + "]");
        }
    }

    private boolean isAfterLetterOrDigit(int i) {
        return i >= 1 && i <= this.mString.length() && Character.isLetterOrDigit(this.mString.codePointBefore(i));
    }

    private boolean isOnLetterOrDigit(int i) {
        return i >= 0 && i < this.mString.length() && Character.isLetterOrDigit(this.mString.codePointAt(i));
    }

    @Override // android.text.Selection.PositionIterator
    public int following(int i) {
        int following;
        int i2 = i - this.mOffsetShift;
        do {
            following = this.mIterator.following(i2);
            if (following == -1) {
                return -1;
            }
            i2 = following;
        } while (!isAfterLetterOrDigit(following));
        return this.mOffsetShift + following;
    }

    public int getBeginning(int i) {
        int i2 = i - this.mOffsetShift;
        checkOffsetIsValid(i2);
        if (isOnLetterOrDigit(i2)) {
            return this.mIterator.isBoundary(i2) ? this.mOffsetShift + i2 : this.mIterator.preceding(i2) + this.mOffsetShift;
        } else if (isAfterLetterOrDigit(i2)) {
            return this.mIterator.preceding(i2) + this.mOffsetShift;
        } else {
            return -1;
        }
    }

    public int getEnd(int i) {
        int i2 = i - this.mOffsetShift;
        checkOffsetIsValid(i2);
        if (isAfterLetterOrDigit(i2)) {
            return this.mIterator.isBoundary(i2) ? this.mOffsetShift + i2 : this.mIterator.following(i2) + this.mOffsetShift;
        } else if (isOnLetterOrDigit(i2)) {
            return this.mIterator.following(i2) + this.mOffsetShift;
        } else {
            return -1;
        }
    }

    @Override // android.text.Selection.PositionIterator
    public int preceding(int i) {
        int preceding;
        int i2 = i - this.mOffsetShift;
        do {
            preceding = this.mIterator.preceding(i2);
            if (preceding == -1) {
                return -1;
            }
            i2 = preceding;
        } while (!isOnLetterOrDigit(preceding));
        return this.mOffsetShift + preceding;
    }

    public void setCharSequence(CharSequence charSequence, int i, int i2) {
        this.mOffsetShift = Math.max(0, i - 50);
        int min = Math.min(charSequence.length(), i2 + 50);
        if (charSequence instanceof SpannableStringBuilder) {
            this.mString = ((SpannableStringBuilder) charSequence).substring(this.mOffsetShift, min);
        } else {
            this.mString = charSequence.subSequence(this.mOffsetShift, min).toString();
        }
        this.mIterator.setText(this.mString);
    }
}
