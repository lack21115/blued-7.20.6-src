package java.text;

import com.anythink.core.common.c.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/text/MessageFormat.class */
public class MessageFormat extends Format {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("argumentNumbers", int[].class), new ObjectStreamField("formats", Format[].class), new ObjectStreamField("locale", Locale.class), new ObjectStreamField("maxOffset", Integer.TYPE), new ObjectStreamField("offsets", int[].class), new ObjectStreamField("pattern", String.class)};
    private static final long serialVersionUID = 6479157306784022952L;
    private int[] argumentNumbers;
    private Format[] formats;
    private Locale locale;
    private transient int maxArgumentIndex;
    private int maxOffset;
    private transient String[] strings;

    /* loaded from: source-2895416-dex2jar.jar:java/text/MessageFormat$Field.class */
    public static class Field extends Format.Field {
        public static final Field ARGUMENT = new Field("message argument field");
        private static final long serialVersionUID = 7899943957617360810L;

        protected Field(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/text/MessageFormat$FieldContainer.class */
    public static class FieldContainer {
        AttributedCharacterIterator.Attribute attribute;
        int end;
        int start;
        Object value;

        public FieldContainer(int i, int i2, AttributedCharacterIterator.Attribute attribute, Object obj) {
            this.start = i;
            this.end = i2;
            this.attribute = attribute;
            this.value = obj;
        }
    }

    public MessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    public MessageFormat(String str, Locale locale) {
        this.locale = locale;
        applyPattern(str);
    }

    private void appendQuoted(StringBuffer stringBuffer, String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            char charAt = str.charAt(i2);
            if (charAt == '{' || charAt == '}') {
                stringBuffer.append('\'');
                stringBuffer.append(charAt);
                stringBuffer.append('\'');
            } else {
                stringBuffer.append(charAt);
            }
            i = i2 + 1;
        }
    }

    private String decodeDecimalFormat(StringBuffer stringBuffer, Format format) {
        stringBuffer.append(",number");
        if (format.equals(NumberFormat.getNumberInstance(this.locale))) {
            return null;
        }
        if (format.equals(NumberFormat.getIntegerInstance(this.locale))) {
            stringBuffer.append(",integer");
            return null;
        } else if (format.equals(NumberFormat.getCurrencyInstance(this.locale))) {
            stringBuffer.append(",currency");
            return null;
        } else if (format.equals(NumberFormat.getPercentInstance(this.locale))) {
            stringBuffer.append(",percent");
            return null;
        } else {
            stringBuffer.append(',');
            return ((DecimalFormat) format).toPattern();
        }
    }

    private String decodeSimpleDateFormat(StringBuffer stringBuffer, Format format) {
        if (format.equals(DateFormat.getTimeInstance(2, this.locale))) {
            stringBuffer.append(",time");
            return null;
        } else if (format.equals(DateFormat.getDateInstance(2, this.locale))) {
            stringBuffer.append(",date");
            return null;
        } else if (format.equals(DateFormat.getTimeInstance(3, this.locale))) {
            stringBuffer.append(",time,short");
            return null;
        } else if (format.equals(DateFormat.getDateInstance(3, this.locale))) {
            stringBuffer.append(",date,short");
            return null;
        } else if (format.equals(DateFormat.getTimeInstance(1, this.locale))) {
            stringBuffer.append(",time,long");
            return null;
        } else if (format.equals(DateFormat.getDateInstance(1, this.locale))) {
            stringBuffer.append(",date,long");
            return null;
        } else if (format.equals(DateFormat.getTimeInstance(0, this.locale))) {
            stringBuffer.append(",time,full");
            return null;
        } else if (format.equals(DateFormat.getDateInstance(0, this.locale))) {
            stringBuffer.append(",date,full");
            return null;
        } else {
            stringBuffer.append(",date,");
            return ((SimpleDateFormat) format).toPattern();
        }
    }

    public static String format(String str, Object... objArr) {
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    break;
                }
                if (objArr[i2] == null) {
                    objArr[i2] = "null";
                }
                i = i2 + 1;
            }
        }
        return new MessageFormat(str).format(objArr);
    }

    private StringBuffer formatImpl(Object[] objArr, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldContainer> list) {
        FieldPosition fieldPosition2 = new FieldPosition(0);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > this.maxOffset) {
                break;
            }
            stringBuffer.append(this.strings[i2]);
            int length = stringBuffer.length();
            if (objArr == null || this.argumentNumbers[i2] >= objArr.length) {
                stringBuffer.append('{');
                stringBuffer.append(this.argumentNumbers[i2]);
                stringBuffer.append('}');
                handleArgumentField(length, stringBuffer.length(), this.argumentNumbers[i2], fieldPosition, list);
            } else {
                Object obj = objArr[this.argumentNumbers[i2]];
                NumberFormat numberFormat = this.formats[i2];
                if (numberFormat == null || obj == null) {
                    if (obj instanceof Number) {
                        numberFormat = NumberFormat.getInstance();
                    } else if (obj instanceof Date) {
                        numberFormat = DateFormat.getInstance();
                    } else {
                        stringBuffer.append(obj);
                        handleArgumentField(length, stringBuffer.length(), this.argumentNumbers[i2], fieldPosition, list);
                    }
                }
                if (numberFormat instanceof ChoiceFormat) {
                    MessageFormat messageFormat = new MessageFormat(numberFormat.format(obj));
                    messageFormat.setLocale(this.locale);
                    messageFormat.format(objArr, stringBuffer, fieldPosition2);
                    handleArgumentField(length, stringBuffer.length(), this.argumentNumbers[i2], fieldPosition, list);
                    handleFormat(numberFormat, obj, length, list);
                } else {
                    numberFormat.format(obj, stringBuffer, fieldPosition2);
                    handleArgumentField(length, stringBuffer.length(), this.argumentNumbers[i2], fieldPosition, list);
                    handleFormat(numberFormat, obj, length, list);
                }
            }
            i = i2 + 1;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            stringBuffer.append(this.strings[this.maxOffset + 1]);
        }
        return stringBuffer;
    }

    private void handleArgumentField(int i, int i2, int i3, FieldPosition fieldPosition, List<FieldContainer> list) {
        if (list != null) {
            list.add(new FieldContainer(i, i2, Field.ARGUMENT, Integer.valueOf(i3)));
        } else if (fieldPosition != null && fieldPosition.getFieldAttribute() == Field.ARGUMENT && fieldPosition.getEndIndex() == 0) {
            fieldPosition.setBeginIndex(i);
            fieldPosition.setEndIndex(i2);
        }
    }

    private void handleFormat(Format format, Object obj, int i, List<FieldContainer> list) {
        if (list == null) {
            return;
        }
        AttributedCharacterIterator formatToCharacterIterator = format.formatToCharacterIterator(obj);
        while (formatToCharacterIterator.getIndex() != formatToCharacterIterator.getEndIndex()) {
            int runStart = formatToCharacterIterator.getRunStart();
            int runLimit = formatToCharacterIterator.getRunLimit();
            for (AttributedCharacterIterator.Attribute attribute : formatToCharacterIterator.getAttributes().keySet()) {
                list.add(new FieldContainer(i + runStart, i + runLimit, attribute, formatToCharacterIterator.getAttribute(attribute)));
            }
            formatToCharacterIterator.setIndex(runLimit);
        }
    }

    private int match(String str, ParsePosition parsePosition, boolean z, String[] strArr) {
        int i;
        int i2;
        int length = str.length();
        int index = parsePosition.getIndex();
        while (index < length && Character.isWhitespace(str.charAt(index))) {
            index++;
        }
        int length2 = strArr.length;
        while (true) {
            int i3 = length2 - 1;
            i = -1;
            if (i3 < 0) {
                break;
            }
            length2 = i3;
            if (str.regionMatches(true, index, strArr[i3], 0, strArr[i3].length())) {
                i = i3;
                break;
            }
        }
        if (i == -1) {
            return -1;
        }
        int i4 = index;
        int length3 = strArr[i].length();
        while (true) {
            i2 = i4 + length3;
            if (i2 >= length || !Character.isWhitespace(str.charAt(i2))) {
                break;
            }
            i4 = i2;
            length3 = 1;
        }
        if (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '}' || (!z && charAt == ',')) {
                parsePosition.setIndex(i2 + 1);
                return i;
            }
            return -1;
        }
        return -1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01f4 -> B:21:0x00b4). Please submit an issue!!! */
    private Format parseVariable(String str, ParsePosition parsePosition) {
        char charAt;
        int length = str.length();
        int index = parsePosition.getIndex();
        if (index >= length || !((charAt = str.charAt(index)) == '}' || charAt == ',')) {
            throw new IllegalArgumentException("Missing element format");
        }
        parsePosition.setIndex(index + 1);
        if (charAt == '}') {
            return null;
        }
        int match = match(str, parsePosition, false, new String[]{g.a.g, "date", "number", "choice"});
        if (match == -1) {
            throw new IllegalArgumentException("Unknown element format");
        }
        StringBuffer stringBuffer = new StringBuffer();
        char charAt2 = str.charAt(parsePosition.getIndex() - 1);
        switch (match) {
            case 0:
            case 1:
                if (charAt2 == '}') {
                    return match == 1 ? DateFormat.getDateInstance(2, this.locale) : DateFormat.getTimeInstance(2, this.locale);
                }
                int match2 = match(str, parsePosition, true, new String[]{"full", "long", "medium", "short"});
                if (match2 == -1) {
                    Format.upToWithQuotes(str, parsePosition, stringBuffer, '}', '{');
                    return new SimpleDateFormat(stringBuffer.toString(), this.locale);
                }
                switch (match2) {
                    case 0:
                        match2 = 0;
                        break;
                    case 1:
                        match2 = 1;
                        break;
                    case 2:
                        match2 = 2;
                        break;
                    case 3:
                        match2 = 3;
                        break;
                }
                return match == 1 ? DateFormat.getDateInstance(match2, this.locale) : DateFormat.getTimeInstance(match2, this.locale);
            case 2:
                if (charAt2 == '}') {
                    return NumberFormat.getInstance(this.locale);
                }
                int match3 = match(str, parsePosition, true, new String[]{"currency", "percent", "integer"});
                if (match3 == -1) {
                    Format.upToWithQuotes(str, parsePosition, stringBuffer, '}', '{');
                    return new DecimalFormat(stringBuffer.toString(), new DecimalFormatSymbols(this.locale));
                }
                switch (match3) {
                    case 0:
                        return NumberFormat.getCurrencyInstance(this.locale);
                    case 1:
                        return NumberFormat.getPercentInstance(this.locale);
                    default:
                        return NumberFormat.getIntegerInstance(this.locale);
                }
            default:
                try {
                    Format.upToWithQuotes(str, parsePosition, stringBuffer, '}', '{');
                } catch (IllegalArgumentException e) {
                }
                return new ChoiceFormat(stringBuffer.toString());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i;
        int i2 = 1;
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.argumentNumbers = (int[]) readFields.get("argumentNumbers", (Object) null);
        this.formats = (Format[]) readFields.get("formats", (Object) null);
        this.locale = (Locale) readFields.get("locale", (Object) null);
        this.maxOffset = readFields.get("maxOffset", 0);
        int[] iArr = (int[]) readFields.get("offsets", (Object) null);
        String str = (String) readFields.get("pattern", (Object) null);
        if (this.maxOffset < 0) {
            i = str.length() > 0 ? 1 : 0;
        } else {
            int i3 = this.maxOffset;
            if (iArr[this.maxOffset] != str.length()) {
                i2 = 2;
            }
            i = i2 + i3;
        }
        this.strings = new String[i];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 > this.maxOffset) {
                break;
            }
            this.strings[i6] = str.substring(i4, iArr[i6]);
            i4 = iArr[i6];
            i5 = i6 + 1;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            this.strings[this.strings.length - 1] = str.substring(i4, str.length());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("argumentNumbers", this.argumentNumbers);
        putFields.put("formats", this.formats);
        putFields.put("locale", this.locale);
        putFields.put("maxOffset", this.maxOffset);
        int i = 0;
        int[] iArr = new int[this.maxOffset + 1];
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > this.maxOffset) {
                break;
            }
            i += this.strings[i3].length();
            iArr[i3] = i;
            sb.append(this.strings[i3]);
            i2 = i3 + 1;
        }
        if (this.maxOffset + 1 < this.strings.length) {
            sb.append(this.strings[this.maxOffset + 1]);
        }
        putFields.put("offsets", iArr);
        putFields.put("pattern", sb.toString());
        objectOutputStream.writeFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
        r0.setIndex(r0 - 1);
        r0.add(parseVariable(r7, r0));
        r15 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ef, code lost:
        if (r10 < r14.length) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f2, code lost:
        r15 = new int[r14.length * 2];
        java.lang.System.arraycopy(r14, 0, r15, 0, r14.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0107, code lost:
        r0 = r10 + 1;
        r15[r10] = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0115, code lost:
        if (r8 <= r9) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0118, code lost:
        r11 = r8;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0177, code lost:
        r8 = r0;
        r11 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyPattern(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.MessageFormat.applyPattern(java.lang.String):void");
    }

    @Override // java.text.Format
    public Object clone() {
        MessageFormat messageFormat = (MessageFormat) super.clone();
        Format[] formatArr = new Format[this.formats.length];
        int length = this.formats.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                messageFormat.formats = formatArr;
                return messageFormat;
            }
            length = i;
            if (this.formats[i] != null) {
                formatArr[i] = (Format) this.formats[i].clone();
                length = i;
            }
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj instanceof MessageFormat) {
                MessageFormat messageFormat = (MessageFormat) obj;
                z = false;
                if (this.maxOffset == messageFormat.maxOffset) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 > this.maxOffset) {
                            return this.locale.equals(messageFormat.locale) && Arrays.equals(this.strings, messageFormat.strings) && Arrays.equals(this.formats, messageFormat.formats);
                        }
                        z = false;
                        if (this.argumentNumbers[i2] != messageFormat.argumentNumbers[i2]) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return z;
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format((Object[]) obj, stringBuffer, fieldPosition);
    }

    public final StringBuffer format(Object[] objArr, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return formatImpl(objArr, stringBuffer, fieldPosition, null);
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        formatImpl((Object[]) obj, stringBuffer, new FieldPosition(0), arrayList);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        Iterator<FieldContainer> it = arrayList.iterator();
        while (it.hasNext()) {
            FieldContainer next = it.next();
            attributedString.addAttribute(next.attribute, next.value, next.start, next.end);
        }
        return attributedString.getIterator();
    }

    public Format[] getFormats() {
        return (Format[]) this.formats.clone();
    }

    public Format[] getFormatsByArgumentIndex() {
        Format[] formatArr = new Format[this.maxArgumentIndex + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.maxOffset + 1) {
                return formatArr;
            }
            formatArr[this.argumentNumbers[i2]] = this.formats[i2];
            i = i2 + 1;
        }
    }

    public Locale getLocale() {
        return this.locale;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > this.maxOffset) {
                break;
            }
            int hashCode = i + this.argumentNumbers[i3] + this.strings[i3].hashCode();
            i = hashCode;
            if (this.formats[i3] != null) {
                i = hashCode + this.formats[i3].hashCode();
            }
            i2 = i3 + 1;
        }
        int i4 = i;
        if (this.maxOffset + 1 < this.strings.length) {
            i4 = i + this.strings[this.maxOffset + 1].hashCode();
        }
        int i5 = i4;
        if (this.locale != null) {
            i5 = i4 + this.locale.hashCode();
        }
        return i5;
    }

    public Object[] parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Object[] parse = parse(str, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("Parse failure", parsePosition.getErrorIndex());
        }
        return parse;
    }

    public Object[] parse(String str, ParsePosition parsePosition) {
        String parseObject;
        if (str == null) {
            return EmptyArray.OBJECT;
        }
        ParsePosition parsePosition2 = new ParsePosition(0);
        int index = parsePosition.getIndex();
        Object[] objArr = new Object[this.maxArgumentIndex + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > this.maxOffset) {
                int i3 = index;
                if (this.maxOffset + 1 < this.strings.length) {
                    String str2 = this.strings[this.maxOffset + 1];
                    if (!str.startsWith(str2, index)) {
                        parsePosition.setErrorIndex(index);
                        return null;
                    }
                    i3 = index + str2.length();
                }
                parsePosition.setIndex(i3);
                return objArr;
            }
            String str3 = this.strings[i2];
            if (!str.startsWith(str3, index)) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            int length = index + str3.length();
            Format format = this.formats[i2];
            if (format != null) {
                parsePosition2.setIndex(length);
                parseObject = format.parseObject(str, parsePosition2);
                if (parsePosition2.getErrorIndex() != -1) {
                    parsePosition.setErrorIndex(length);
                    return null;
                }
                index = parsePosition2.getIndex();
            } else if (i2 + 1 < this.strings.length) {
                index = str.indexOf(this.strings[i2 + 1], length);
                if (index == -1) {
                    parsePosition.setErrorIndex(length);
                    return null;
                }
                parseObject = str.substring(length, index);
            } else {
                parseObject = str.substring(length);
                index = str.length();
            }
            objArr[this.argumentNumbers[i2]] = parseObject;
            i = i2 + 1;
        }
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public void setFormat(int i, Format format) {
        this.formats[i] = format;
    }

    public void setFormatByArgumentIndex(int i, Format format) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.maxOffset + 1) {
                return;
            }
            if (this.argumentNumbers[i3] == i) {
                this.formats[i3] = format;
            }
            i2 = i3 + 1;
        }
    }

    public void setFormats(Format[] formatArr) {
        int length = this.formats.length;
        int i = length;
        if (formatArr.length < length) {
            i = formatArr.length;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            this.formats[i3] = formatArr[i3];
            i2 = i3 + 1;
        }
    }

    public void setFormatsByArgumentIndex(Format[] formatArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= formatArr.length) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.maxOffset + 1) {
                    if (this.argumentNumbers[i4] == i2) {
                        this.formats[i4] = formatArr[i2];
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > this.maxOffset) {
                return;
            }
            Format format = this.formats[i2];
            if (format instanceof DecimalFormat) {
                try {
                    this.formats[i2] = new DecimalFormat(((DecimalFormat) format).toPattern(), new DecimalFormatSymbols(locale));
                } catch (NullPointerException e) {
                    this.formats[i2] = null;
                }
            } else if (format instanceof SimpleDateFormat) {
                try {
                    this.formats[i2] = new SimpleDateFormat(((SimpleDateFormat) format).toPattern(), locale);
                } catch (NullPointerException e2) {
                    this.formats[i2] = null;
                }
            }
            i = i2 + 1;
        }
    }

    public String toPattern() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > this.maxOffset) {
                if (this.maxOffset + 1 < this.strings.length) {
                    appendQuoted(stringBuffer, this.strings[this.maxOffset + 1]);
                }
                return stringBuffer.toString();
            }
            appendQuoted(stringBuffer, this.strings[i2]);
            stringBuffer.append('{');
            stringBuffer.append(this.argumentNumbers[i2]);
            Format format = this.formats[i2];
            String str = null;
            if (format instanceof ChoiceFormat) {
                stringBuffer.append(",choice,");
                str = ((ChoiceFormat) format).toPattern();
            } else if (format instanceof DecimalFormat) {
                str = decodeDecimalFormat(stringBuffer, format);
            } else if (format instanceof SimpleDateFormat) {
                str = decodeSimpleDateFormat(stringBuffer, format);
            } else if (format != null) {
                throw new IllegalArgumentException("Unknown format");
            }
            if (str != null) {
                boolean z = false;
                int length = str.length();
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    char charAt = str.charAt(i4);
                    boolean z2 = z;
                    if (charAt == '\'') {
                        z2 = !z;
                    }
                    char c = charAt;
                    int i5 = i3;
                    if (!z2) {
                        int i6 = i3;
                        if (charAt == '{') {
                            i6 = i3 + 1;
                        }
                        c = charAt;
                        i5 = i6;
                        if (charAt == '}') {
                            if (i6 > 0) {
                                i5 = i6 - 1;
                                c = charAt;
                            } else {
                                stringBuffer.append("'}");
                                c = '\'';
                                i5 = i6;
                            }
                        }
                    }
                    stringBuffer.append(c);
                    i4++;
                    i3 = i5;
                    z = z2;
                }
            }
            stringBuffer.append('}');
            i = i2 + 1;
        }
    }
}
