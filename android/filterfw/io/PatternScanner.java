package android.filterfw.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/PatternScanner.class */
public class PatternScanner {
    private Pattern mIgnorePattern;
    private String mInput;
    private int mOffset = 0;
    private int mLineNo = 0;
    private int mStartOfLine = 0;

    public PatternScanner(String str) {
        this.mInput = str;
    }

    public PatternScanner(String str, Pattern pattern) {
        this.mInput = str;
        this.mIgnorePattern = pattern;
        skip(this.mIgnorePattern);
    }

    public boolean atEnd() {
        return this.mOffset >= this.mInput.length();
    }

    public String eat(Pattern pattern, String str) {
        String tryEat = tryEat(pattern);
        if (tryEat == null) {
            throw new RuntimeException(unexpectedTokenMessage(str));
        }
        return tryEat;
    }

    public int lineNo() {
        return this.mLineNo;
    }

    public boolean peek(Pattern pattern) {
        if (this.mIgnorePattern != null) {
            skip(this.mIgnorePattern);
        }
        Matcher matcher = pattern.matcher(this.mInput);
        matcher.region(this.mOffset, this.mInput.length());
        return matcher.lookingAt();
    }

    public void skip(Pattern pattern) {
        Matcher matcher = pattern.matcher(this.mInput);
        matcher.region(this.mOffset, this.mInput.length());
        if (matcher.lookingAt()) {
            updateLineCount(this.mOffset, matcher.end());
            this.mOffset = matcher.end();
        }
    }

    public String tryEat(Pattern pattern) {
        if (this.mIgnorePattern != null) {
            skip(this.mIgnorePattern);
        }
        Matcher matcher = pattern.matcher(this.mInput);
        matcher.region(this.mOffset, this.mInput.length());
        String str = null;
        if (matcher.lookingAt()) {
            updateLineCount(this.mOffset, matcher.end());
            this.mOffset = matcher.end();
            str = this.mInput.substring(matcher.start(), matcher.end());
        }
        if (str != null && this.mIgnorePattern != null) {
            skip(this.mIgnorePattern);
        }
        return str;
    }

    public String unexpectedTokenMessage(String str) {
        return "Unexpected token on line " + (this.mLineNo + 1) + " after '" + this.mInput.substring(this.mStartOfLine, this.mOffset) + "' <- Expected " + str + "!";
    }

    public void updateLineCount(int i, int i2) {
        while (i < i2) {
            if (this.mInput.charAt(i) == '\n') {
                this.mLineNo++;
                this.mStartOfLine = i + 1;
            }
            i++;
        }
    }
}
