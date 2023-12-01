package java.text;

import java.io.Serializable;
import java.text.AttributedCharacterIterator;

/* loaded from: source-2895416-dex2jar.jar:java/text/Format.class */
public abstract class Format implements Serializable, Cloneable {
    private static final long serialVersionUID = -299282585814624189L;

    /* loaded from: source-2895416-dex2jar.jar:java/text/Format$Field.class */
    public static class Field extends AttributedCharacterIterator.Attribute {
        private static final long serialVersionUID = 276966692217360283L;

        /* JADX INFO: Access modifiers changed from: protected */
        public Field(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean upTo(String str, ParsePosition parsePosition, StringBuffer stringBuffer, char c2) {
        int index = parsePosition.getIndex();
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        while (index < length) {
            int i = index + 1;
            char charAt = str.charAt(index);
            if (charAt == '\'') {
                if (z) {
                    stringBuffer.append('\'');
                }
                z2 = !z2;
                z = true;
            } else if (charAt == c2 && !z2) {
                parsePosition.setIndex(i);
                return true;
            } else {
                z = false;
                stringBuffer.append(charAt);
            }
            index = i;
        }
        parsePosition.setIndex(index);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean upToWithQuotes(String str, ParsePosition parsePosition, StringBuffer stringBuffer, char c2, char c3) {
        int index = parsePosition.getIndex();
        int length = str.length();
        int i = 1;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (index >= length) {
                throw new IllegalArgumentException("Unmatched braces in the pattern");
            }
            int i2 = index + 1;
            char charAt = str.charAt(index);
            boolean z3 = z2;
            if (charAt == '\'') {
                z3 = !z2;
            }
            int i3 = i;
            if (!z3) {
                int i4 = i;
                if (charAt == c2) {
                    i4 = i - 1;
                }
                if (i4 == 0) {
                    parsePosition.setIndex(i2);
                    return true;
                }
                i3 = i4;
                if (charAt == c3) {
                    i3 = i4 + 1;
                }
            }
            stringBuffer.append(charAt);
            index = i2;
            i = i3;
            z = z3;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final String format(Object obj) {
        return format(obj, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        return new AttributedString(format(obj)).getIterator();
    }

    public Object parseObject(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Object parseObject = parseObject(str, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("Parse failure", parsePosition.getErrorIndex());
        }
        return parseObject;
    }

    public abstract Object parseObject(String str, ParsePosition parsePosition);
}
