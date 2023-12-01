package java.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/text/ChoiceFormat.class */
public class ChoiceFormat extends NumberFormat {
    private static final long serialVersionUID = 1795184449645032964L;
    private String[] choiceFormats;
    private double[] choiceLimits;

    public ChoiceFormat(String str) {
        applyPattern(str);
    }

    public ChoiceFormat(double[] dArr, String[] strArr) {
        setChoices(dArr, strArr);
    }

    public static final double nextDouble(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        long doubleToLongBits = d == 0.0d ? 0L : Double.doubleToLongBits(d);
        return Double.longBitsToDouble(d < 0.0d ? doubleToLongBits - 1 : doubleToLongBits + 1);
    }

    public static double nextDouble(double d, boolean z) {
        return z ? nextDouble(d) : previousDouble(d);
    }

    public static final double previousDouble(double d) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        long doubleToLongBits = d == 0.0d ? Long.MIN_VALUE : Double.doubleToLongBits(d);
        return Double.longBitsToDouble(d <= 0.0d ? doubleToLongBits + 1 : doubleToLongBits - 1);
    }

    private int skipWhitespace(String str, int i) {
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public void applyPattern(String str) {
        double nextDouble;
        double[] dArr = new double[5];
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        ParsePosition parsePosition = new ParsePosition(0);
        while (true) {
            int skipWhitespace = skipWhitespace(str, i2);
            if (skipWhitespace >= length) {
                if (i == dArr.length) {
                    this.choiceLimits = dArr;
                } else {
                    this.choiceLimits = new double[i];
                    System.arraycopy(dArr, 0, this.choiceLimits, 0, i);
                }
                this.choiceFormats = new String[arrayList.size()];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        return;
                    }
                    this.choiceFormats[i4] = (String) arrayList.get(i4);
                    i3 = i4 + 1;
                }
            } else {
                parsePosition.setIndex(skipWhitespace);
                Number parse = numberFormat.parse(str, parsePosition);
                int skipWhitespace2 = skipWhitespace(str, parsePosition.getIndex());
                if (parsePosition.getErrorIndex() == -1 && skipWhitespace2 < length) {
                    char charAt = str.charAt(skipWhitespace2);
                    double[] dArr2 = dArr;
                    if (i == dArr.length) {
                        dArr2 = new double[i * 2];
                        System.arraycopy(dArr, 0, dArr2, 0, i);
                    }
                    switch (charAt) {
                        case '#':
                        case 8804:
                            nextDouble = parse.doubleValue();
                            break;
                        case '<':
                            nextDouble = nextDouble(parse.doubleValue());
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character '" + charAt + "' in template: " + str);
                    }
                    if (i > 0 && nextDouble <= dArr2[i - 1]) {
                        throw new IllegalArgumentException("Bad template: " + str);
                    }
                    stringBuffer.setLength(0);
                    parsePosition.setIndex(skipWhitespace2 + 1);
                    upTo(str, parsePosition, stringBuffer, '|');
                    i2 = parsePosition.getIndex();
                    dArr2[i] = nextDouble;
                    arrayList.add(stringBuffer.toString());
                    i++;
                    dArr = dArr2;
                }
            }
        }
        this.choiceLimits = EmptyArray.DOUBLE;
        this.choiceFormats = EmptyArray.STRING;
    }

    @Override // java.text.NumberFormat, java.text.Format
    public Object clone() {
        ChoiceFormat choiceFormat = (ChoiceFormat) super.clone();
        choiceFormat.choiceLimits = (double[]) this.choiceLimits.clone();
        choiceFormat.choiceFormats = (String[]) this.choiceFormats.clone();
        return choiceFormat;
    }

    @Override // java.text.NumberFormat
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChoiceFormat) {
            ChoiceFormat choiceFormat = (ChoiceFormat) obj;
            return Arrays.equals(this.choiceLimits, choiceFormat.choiceLimits) && Arrays.equals(this.choiceFormats, choiceFormat.choiceFormats);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        return r9;
     */
    @Override // java.text.NumberFormat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.StringBuffer format(double r6, java.lang.StringBuffer r8, java.text.FieldPosition r9) {
        /*
            r5 = this;
            r0 = r5
            double[] r0 = r0.choiceLimits
            int r0 = r0.length
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
        L9:
            r0 = r10
            if (r0 < 0) goto L33
            r0 = r5
            double[] r0 = r0.choiceLimits
            r1 = r10
            r0 = r0[r1]
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L2a
            r0 = r8
            r1 = r5
            java.lang.String[] r1 = r1.choiceFormats
            r2 = r10
            r1 = r1[r2]
            java.lang.StringBuffer r0 = r0.append(r1)
            r9 = r0
        L27:
            r0 = r9
            return r0
        L2a:
            r0 = r10
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            goto L9
        L33:
            r0 = r8
            r9 = r0
            r0 = r5
            java.lang.String[] r0 = r0.choiceFormats
            int r0 = r0.length
            if (r0 == 0) goto L27
            r0 = r8
            r1 = r5
            java.lang.String[] r1 = r1.choiceFormats
            r2 = 0
            r1 = r1[r2]
            java.lang.StringBuffer r0 = r0.append(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.ChoiceFormat.format(double, java.lang.StringBuffer, java.text.FieldPosition):java.lang.StringBuffer");
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(j, stringBuffer, fieldPosition);
    }

    public Object[] getFormats() {
        return this.choiceFormats;
    }

    public double[] getLimits() {
        return this.choiceLimits;
    }

    @Override // java.text.NumberFormat
    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.choiceLimits.length) {
                return i;
            }
            long doubleToLongBits = Double.doubleToLongBits(this.choiceLimits[i3]);
            i += ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits)) + this.choiceFormats[i3].hashCode();
            i2 = i3 + 1;
        }
    }

    @Override // java.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.choiceFormats.length) {
                parsePosition.setErrorIndex(index);
                return new Double(Double.NaN);
            } else if (str.startsWith(this.choiceFormats[i2], index)) {
                parsePosition.setIndex(this.choiceFormats[i2].length() + index);
                return new Double(this.choiceLimits[i2]);
            } else {
                i = i2 + 1;
            }
        }
    }

    public void setChoices(double[] dArr, String[] strArr) {
        if (dArr.length != strArr.length) {
            throw new IllegalArgumentException("limits.length != formats.length: " + dArr.length + " != " + strArr.length);
        }
        this.choiceLimits = dArr;
        this.choiceFormats = strArr;
    }

    public String toPattern() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.choiceLimits.length) {
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append('|');
            }
            String valueOf = String.valueOf(previousDouble(this.choiceLimits[i2]));
            String valueOf2 = String.valueOf(this.choiceLimits[i2]);
            if (valueOf.length() < valueOf2.length()) {
                sb.append(valueOf);
                sb.append('<');
            } else {
                sb.append(valueOf2);
                sb.append('#');
            }
            boolean z = this.choiceFormats[i2].indexOf(124) != -1;
            if (z) {
                sb.append('\'');
            }
            sb.append(this.choiceFormats[i2]);
            if (z) {
                sb.append('\'');
            }
            i = i2 + 1;
        }
    }
}
