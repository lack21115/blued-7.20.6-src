package android.text;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.EasyEditSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.SpellCheckSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TtsSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Printer;
import android.widget.ExpandableListView;
import com.android.internal.R;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import libcore.icu.ICU;

/* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils.class */
public class TextUtils {
    public static final int ABSOLUTE_SIZE_SPAN = 16;
    public static final int ALIGNMENT_SPAN = 1;
    public static final int ANNOTATION = 18;
    public static final int BACKGROUND_COLOR_SPAN = 12;
    public static final int BULLET_SPAN = 8;
    public static final int CAP_MODE_CHARACTERS = 4096;
    public static final int CAP_MODE_SENTENCES = 16384;
    public static final int CAP_MODE_WORDS = 8192;
    public static final int EASY_EDIT_SPAN = 22;
    private static final char FIRST_RIGHT_TO_LEFT = 1424;
    public static final int FIRST_SPAN = 1;
    public static final int FOREGROUND_COLOR_SPAN = 2;
    public static final int LAST_SPAN = 24;
    public static final int LEADING_MARGIN_SPAN = 10;
    public static final int LOCALE_SPAN = 23;
    public static final int QUOTE_SPAN = 9;
    public static final int RELATIVE_SIZE_SPAN = 3;
    public static final int SCALE_X_SPAN = 4;
    public static final int SPELL_CHECK_SPAN = 20;
    public static final int STRIKETHROUGH_SPAN = 5;
    public static final int STYLE_SPAN = 7;
    public static final int SUBSCRIPT_SPAN = 15;
    public static final int SUGGESTION_RANGE_SPAN = 21;
    public static final int SUGGESTION_SPAN = 19;
    public static final int SUPERSCRIPT_SPAN = 14;
    private static final String TAG = "TextUtils";
    public static final int TEXT_APPEARANCE_SPAN = 17;
    public static final int TTS_SPAN = 24;
    public static final int TYPEFACE_SPAN = 13;
    public static final int UNDERLINE_SPAN = 6;
    public static final int URL_SPAN = 11;
    private static final char ZWNBS_CHAR = 65279;
    static final char[] ELLIPSIS_NORMAL = {8230};
    private static final String ELLIPSIS_STRING = new String(ELLIPSIS_NORMAL);
    static final char[] ELLIPSIS_TWO_DOTS = {8229};
    private static final String ELLIPSIS_TWO_DOTS_STRING = new String(ELLIPSIS_TWO_DOTS);
    public static final Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR = new Parcelable.Creator<CharSequence>() { // from class: android.text.TextUtils.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharSequence createFromParcel(Parcel parcel) {
            String str;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (readString == null) {
                str = null;
            } else {
                str = readString;
                if (readInt != 1) {
                    SpannableString spannableString = new SpannableString(readString);
                    while (true) {
                        int readInt2 = parcel.readInt();
                        if (readInt2 == 0) {
                            return spannableString;
                        }
                        switch (readInt2) {
                            case 1:
                                TextUtils.readSpan(parcel, spannableString, new AlignmentSpan.Standard(parcel));
                                break;
                            case 2:
                                TextUtils.readSpan(parcel, spannableString, new ForegroundColorSpan(parcel));
                                break;
                            case 3:
                                TextUtils.readSpan(parcel, spannableString, new RelativeSizeSpan(parcel));
                                break;
                            case 4:
                                TextUtils.readSpan(parcel, spannableString, new ScaleXSpan(parcel));
                                break;
                            case 5:
                                TextUtils.readSpan(parcel, spannableString, new StrikethroughSpan(parcel));
                                break;
                            case 6:
                                TextUtils.readSpan(parcel, spannableString, new UnderlineSpan(parcel));
                                break;
                            case 7:
                                TextUtils.readSpan(parcel, spannableString, new StyleSpan(parcel));
                                break;
                            case 8:
                                TextUtils.readSpan(parcel, spannableString, new BulletSpan(parcel));
                                break;
                            case 9:
                                TextUtils.readSpan(parcel, spannableString, new QuoteSpan(parcel));
                                break;
                            case 10:
                                TextUtils.readSpan(parcel, spannableString, new LeadingMarginSpan.Standard(parcel));
                                break;
                            case 11:
                                TextUtils.readSpan(parcel, spannableString, new URLSpan(parcel));
                                break;
                            case 12:
                                TextUtils.readSpan(parcel, spannableString, new BackgroundColorSpan(parcel));
                                break;
                            case 13:
                                TextUtils.readSpan(parcel, spannableString, new TypefaceSpan(parcel));
                                break;
                            case 14:
                                TextUtils.readSpan(parcel, spannableString, new SuperscriptSpan(parcel));
                                break;
                            case 15:
                                TextUtils.readSpan(parcel, spannableString, new SubscriptSpan(parcel));
                                break;
                            case 16:
                                TextUtils.readSpan(parcel, spannableString, new AbsoluteSizeSpan(parcel));
                                break;
                            case 17:
                                TextUtils.readSpan(parcel, spannableString, new TextAppearanceSpan(parcel));
                                break;
                            case 18:
                                TextUtils.readSpan(parcel, spannableString, new Annotation(parcel));
                                break;
                            case 19:
                                TextUtils.readSpan(parcel, spannableString, new SuggestionSpan(parcel));
                                break;
                            case 20:
                                TextUtils.readSpan(parcel, spannableString, new SpellCheckSpan(parcel));
                                break;
                            case 21:
                                TextUtils.readSpan(parcel, spannableString, new SuggestionRangeSpan(parcel));
                                break;
                            case 22:
                                TextUtils.readSpan(parcel, spannableString, new EasyEditSpan(parcel));
                                break;
                            case 23:
                                TextUtils.readSpan(parcel, spannableString, new LocaleSpan(parcel));
                                break;
                            case 24:
                                TextUtils.readSpan(parcel, spannableString, new TtsSpan(parcel));
                                break;
                            default:
                                throw new RuntimeException("bogus span encoding " + readInt2);
                        }
                    }
                }
            }
            return str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharSequence[] newArray(int i) {
            return new CharSequence[i];
        }
    };
    private static Object sLock = new Object();
    private static char[] sTemp = null;
    private static String[] EMPTY_STRING_ARRAY = new String[0];
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils$EllipsizeCallback.class */
    public interface EllipsizeCallback {
        void ellipsized(int i, int i2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils$Reverser.class */
    private static class Reverser implements CharSequence, GetChars {
        private int mEnd;
        private CharSequence mSource;
        private int mStart;

        public Reverser(CharSequence charSequence, int i, int i2) {
            this.mSource = charSequence;
            this.mStart = i;
            this.mEnd = i2;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return AndroidCharacter.getMirror(this.mSource.charAt((this.mEnd - 1) - i));
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            TextUtils.getChars(this.mSource, this.mStart + i, this.mStart + i2, cArr, i3);
            AndroidCharacter.mirror(cArr, 0, i2 - i);
            int i4 = i2 - i;
            int i5 = (i2 - i) / 2;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i5) {
                    return;
                }
                char c2 = cArr[i3 + i7];
                cArr[i3 + i7] = cArr[((i3 + i4) - i7) - 1];
                cArr[((i3 + i4) - i7) - 1] = c2;
                i6 = i7 + 1;
            }
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mEnd - this.mStart;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            char[] cArr = new char[i2 - i];
            getChars(i, i2, cArr, 0);
            return new String(cArr);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return subSequence(0, length()).toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils$SimpleStringSplitter.class */
    public static class SimpleStringSplitter implements StringSplitter, Iterator<String> {
        private char mDelimiter;
        private int mLength;
        private int mPosition;
        private String mString;

        public SimpleStringSplitter(char c2) {
            this.mDelimiter = c2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mPosition < this.mLength;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public String next() {
            int indexOf = this.mString.indexOf(this.mDelimiter, this.mPosition);
            int i = indexOf;
            if (indexOf == -1) {
                i = this.mLength;
            }
            String substring = this.mString.substring(this.mPosition, i);
            this.mPosition = i + 1;
            return substring;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // android.text.TextUtils.StringSplitter
        public void setString(String str) {
            this.mString = str;
            this.mPosition = 0;
            this.mLength = this.mString.length();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils$StringSplitter.class */
    public interface StringSplitter extends Iterable<String> {
        void setString(String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextUtils$TruncateAt.class */
    public enum TruncateAt {
        START,
        MIDDLE,
        END,
        MARQUEE,
        END_SMALL
    }

    private TextUtils() {
    }

    public static CharSequence commaEllipsize(CharSequence charSequence, TextPaint textPaint, float f, String str, String str2) {
        return commaEllipsize(charSequence, textPaint, f, str, str2, TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }

    public static CharSequence commaEllipsize(CharSequence charSequence, TextPaint textPaint, float f, String str, String str2, TextDirectionHeuristic textDirectionHeuristic) {
        MeasuredText obtain = MeasuredText.obtain();
        try {
            int length = charSequence.length();
            if (setPara(obtain, textPaint, charSequence, 0, length, textDirectionHeuristic) <= f) {
                return charSequence;
            }
            char[] cArr = obtain.mChars;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i;
                if (cArr[i2] == ',') {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
            int i4 = i + 1;
            int i5 = 0;
            String str3 = "";
            int i6 = 0;
            int i7 = 0;
            float[] fArr = obtain.mWidths;
            MeasuredText obtain2 = MeasuredText.obtain();
            int i8 = 0;
            while (i8 < length) {
                int i9 = (int) (i6 + fArr[i8]);
                int i10 = i7;
                int i11 = i5;
                String str4 = str3;
                int i12 = i4;
                if (cArr[i8] == ',') {
                    int i13 = i7 + 1;
                    int i14 = i4 - 1;
                    String str5 = i14 == 1 ? " " + str : " " + String.format(str2, Integer.valueOf(i14));
                    obtain2.setPara(str5, 0, str5.length(), textDirectionHeuristic);
                    i10 = i13;
                    i11 = i5;
                    str4 = str3;
                    i12 = i14;
                    if (i9 + obtain2.addStyleRun(textPaint, obtain2.mLen, null) <= f) {
                        i11 = i8 + 1;
                        i10 = i13;
                        str4 = str5;
                        i12 = i14;
                    }
                }
                i8++;
                i7 = i10;
                i5 = i11;
                str3 = str4;
                i4 = i12;
                i6 = i9;
            }
            MeasuredText.recycle(obtain2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
            spannableStringBuilder.insert(0, charSequence, 0, i5);
            return spannableStringBuilder;
        } finally {
            MeasuredText.recycle(obtain);
        }
    }

    public static CharSequence concat(CharSequence... charSequenceArr) {
        boolean z;
        if (charSequenceArr.length == 0) {
            return "";
        }
        if (charSequenceArr.length == 1) {
            return charSequenceArr[0];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            z = false;
            if (i2 >= charSequenceArr.length) {
                break;
            } else if (charSequenceArr[i2] instanceof Spanned) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= charSequenceArr.length) {
                break;
            }
            sb.append(charSequenceArr[i4]);
            i3 = i4 + 1;
        }
        if (!z) {
            return sb.toString();
        }
        SpannableString spannableString = new SpannableString(sb);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= charSequenceArr.length) {
                return new SpannedString(spannableString);
            }
            int length = charSequenceArr[i7].length();
            if (charSequenceArr[i7] instanceof Spanned) {
                copySpansFrom((Spanned) charSequenceArr[i7], 0, length, Object.class, spannableString, i5);
            }
            i5 += length;
            i6 = i7 + 1;
        }
    }

    public static void copySpansFrom(Spanned spanned, int i, int i2, Class cls, Spannable spannable, int i3) {
        Class cls2 = cls;
        if (cls == null) {
            cls2 = Object.class;
        }
        Object[] spans = spanned.getSpans(i, i2, cls2);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= spans.length) {
                return;
            }
            int spanStart = spanned.getSpanStart(spans[i5]);
            int spanEnd = spanned.getSpanEnd(spans[i5]);
            int spanFlags = spanned.getSpanFlags(spans[i5]);
            int i6 = spanStart;
            if (spanStart < i) {
                i6 = i;
            }
            int i7 = spanEnd;
            if (spanEnd > i2) {
                i7 = i2;
            }
            spannable.setSpan(spans[i5], (i6 - i) + i3, (i7 - i) + i3, spanFlags);
            i4 = i5 + 1;
        }
    }

    public static boolean delimitedStringContains(String str, char c2, String str2) {
        boolean z;
        if (isEmpty(str) || isEmpty(str2)) {
            z = false;
        } else {
            int i = -1;
            int length = str.length();
            while (true) {
                int indexOf = str.indexOf(str2, i + 1);
                if (indexOf == -1) {
                    return false;
                }
                if (indexOf > 0) {
                    i = indexOf;
                    if (str.charAt(indexOf - 1) != c2) {
                        continue;
                    }
                }
                int length2 = indexOf + str2.length();
                z = true;
                if (length2 == length) {
                    break;
                }
                i = indexOf;
                if (str.charAt(length2) == c2) {
                    return true;
                }
            }
        }
        return z;
    }

    static boolean doesNotNeedBidi(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (charSequence.charAt(i) >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean doesNotNeedBidi(char[] cArr, int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return true;
            }
            if (cArr[i4] >= FIRST_RIGHT_TO_LEFT) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    public static void dumpSpans(CharSequence charSequence, Printer printer, String str) {
        if (!(charSequence instanceof Spanned)) {
            printer.println(str + ((Object) charSequence) + ": (no spans)");
            return;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, charSequence.length(), Object.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= spans.length) {
                return;
            }
            Object obj = spans[i2];
            printer.println(str + ((Object) charSequence.subSequence(spanned.getSpanStart(obj), spanned.getSpanEnd(obj))) + ": " + Integer.toHexString(System.identityHashCode(obj)) + " " + obj.getClass().getCanonicalName() + " (" + spanned.getSpanStart(obj) + "-" + spanned.getSpanEnd(obj) + ") fl=#" + spanned.getSpanFlags(obj));
            i = i2 + 1;
        }
    }

    public static CharSequence ellipsize(CharSequence charSequence, TextPaint textPaint, float f, TruncateAt truncateAt) {
        return ellipsize(charSequence, textPaint, f, truncateAt, false, null);
    }

    public static CharSequence ellipsize(CharSequence charSequence, TextPaint textPaint, float f, TruncateAt truncateAt, boolean z, EllipsizeCallback ellipsizeCallback) {
        return ellipsize(charSequence, textPaint, f, truncateAt, z, ellipsizeCallback, TextDirectionHeuristics.FIRSTSTRONG_LTR, truncateAt == TruncateAt.END_SMALL ? ELLIPSIS_TWO_DOTS_STRING : ELLIPSIS_STRING);
    }

    public static CharSequence ellipsize(CharSequence charSequence, TextPaint textPaint, float f, TruncateAt truncateAt, boolean z, EllipsizeCallback ellipsizeCallback, TextDirectionHeuristic textDirectionHeuristic, String str) {
        int breakText;
        int length = charSequence.length();
        MeasuredText obtain = MeasuredText.obtain();
        try {
            if (setPara(obtain, textPaint, charSequence, 0, charSequence.length(), textDirectionHeuristic) <= f) {
                if (ellipsizeCallback != null) {
                    ellipsizeCallback.ellipsized(0, 0);
                }
                return charSequence;
            }
            float measureText = f - textPaint.measureText(str);
            int i = length;
            if (measureText < 0.0f) {
                breakText = 0;
            } else if (truncateAt == TruncateAt.START) {
                i = length - obtain.breakText(length, false, measureText);
                breakText = 0;
            } else if (truncateAt == TruncateAt.END || truncateAt == TruncateAt.END_SMALL) {
                breakText = obtain.breakText(length, true, measureText);
            } else {
                i = length - obtain.breakText(length, false, measureText / 2.0f);
                breakText = obtain.breakText(i, true, measureText - obtain.measure(i, length));
            }
            if (ellipsizeCallback != null) {
                ellipsizeCallback.ellipsized(breakText, i);
            }
            char[] cArr = obtain.mChars;
            Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
            int i2 = length - (i - breakText);
            if (z) {
                if (i2 > 0) {
                    int i3 = breakText + 1;
                    cArr[breakText] = str.charAt(0);
                    breakText = i3;
                }
                while (breakText < i) {
                    cArr[breakText] = 65279;
                    breakText++;
                }
                String str2 = new String(cArr, 0, length);
                if (spanned == null) {
                    return str2;
                }
                SpannableString spannableString = new SpannableString(str2);
                copySpansFrom(spanned, 0, length, Object.class, spannableString, 0);
                return spannableString;
            } else if (i2 == 0) {
                MeasuredText.recycle(obtain);
                return "";
            } else if (spanned == null) {
                StringBuilder sb = new StringBuilder(str.length() + i2);
                sb.append(cArr, 0, breakText);
                sb.append(str);
                sb.append(cArr, i, length - i);
                return sb.toString();
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(charSequence, 0, breakText);
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.append(charSequence, i, length);
                return spannableStringBuilder;
            }
        } finally {
            MeasuredText.recycle(obtain);
        }
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static CharSequence expandTemplate(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (charSequenceArr.length > 9) {
            throw new IllegalArgumentException("max of 9 values are supported");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= spannableStringBuilder.length()) {
                    break;
                }
                if (spannableStringBuilder.charAt(i2) == '^') {
                    char charAt = spannableStringBuilder.charAt(i2 + 1);
                    if (charAt == '^') {
                        spannableStringBuilder.delete(i2 + 1, i2 + 2);
                        i = i2 + 1;
                    } else if (Character.isDigit(charAt)) {
                        int numericValue = Character.getNumericValue(charAt) - 1;
                        if (numericValue < 0) {
                            throw new IllegalArgumentException("template requests value ^" + (numericValue + 1));
                        }
                        if (numericValue >= charSequenceArr.length) {
                            throw new IllegalArgumentException("template requests value ^" + (numericValue + 1) + "; only " + charSequenceArr.length + " provided");
                        }
                        spannableStringBuilder.replace(i2, i2 + 2, charSequenceArr[numericValue]);
                        i = i2 + charSequenceArr[numericValue].length();
                    }
                }
                i = i2 + 1;
            } catch (IndexOutOfBoundsException e) {
            }
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0107, code lost:
        if (r0 == '!') goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getCapsMode(java.lang.CharSequence r4, int r5, int r6) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextUtils.getCapsMode(java.lang.CharSequence, int, int):int");
    }

    public static void getChars(CharSequence charSequence, int i, int i2, char[] cArr, int i3) {
        Class<?> cls = charSequence.getClass();
        if (cls == String.class) {
            ((String) charSequence).getChars(i, i2, cArr, i3);
        } else if (cls == StringBuffer.class) {
            ((StringBuffer) charSequence).getChars(i, i2, cArr, i3);
        } else if (cls == StringBuilder.class) {
            ((StringBuilder) charSequence).getChars(i, i2, cArr, i3);
        } else if (charSequence instanceof GetChars) {
            ((GetChars) charSequence).getChars(i, i2, cArr, i3);
        } else {
            while (i < i2) {
                cArr[i3] = charSequence.charAt(i);
                i++;
                i3++;
            }
        }
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        int i;
        int i2 = 1;
        boolean z = SystemProperties.getBoolean(Settings.Global.DEVELOPMENT_FORCE_RTL, false);
        if (locale != null && !locale.equals(Locale.ROOT)) {
            String script = ICU.addLikelySubtags(locale).getScript();
            if (script == null) {
                i = getLayoutDirectionFromFirstChar(locale);
            } else if (script.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || script.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                i = 0;
                if (!z) {
                    return 1;
                }
            }
            return i;
        }
        if (!z) {
            i2 = 0;
        }
        return i2;
    }

    public static int getOffsetAfter(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        if (i == length || i == length - 1) {
            return length;
        }
        char charAt = charSequence.charAt(i);
        if (charAt < 55296 || charAt > 56319) {
            i2 = i + 1;
        } else {
            char charAt2 = charSequence.charAt(i + 1);
            i2 = (charAt2 < 56320 || charAt2 > 57343) ? i + 1 : i + 2;
        }
        int i3 = i2;
        if (charSequence instanceof Spanned) {
            ReplacementSpan[] replacementSpanArr = (ReplacementSpan[]) ((Spanned) charSequence).getSpans(i2, i2, ReplacementSpan.class);
            int i4 = 0;
            while (true) {
                i3 = i2;
                if (i4 >= replacementSpanArr.length) {
                    break;
                }
                int spanStart = ((Spanned) charSequence).getSpanStart(replacementSpanArr[i4]);
                int spanEnd = ((Spanned) charSequence).getSpanEnd(replacementSpanArr[i4]);
                int i5 = i2;
                if (spanStart < i2) {
                    i5 = i2;
                    if (spanEnd > i2) {
                        i5 = spanEnd;
                    }
                }
                i4++;
                i2 = i5;
            }
        }
        return i3;
    }

    public static int getOffsetBefore(CharSequence charSequence, int i) {
        int i2;
        if (i == 0 || i == 1) {
            return 0;
        }
        char charAt = charSequence.charAt(i - 1);
        if (charAt < 56320 || charAt > 57343) {
            i2 = i - 1;
        } else {
            char charAt2 = charSequence.charAt(i - 2);
            i2 = (charAt2 < 55296 || charAt2 > 56319) ? i - 1 : i - 2;
        }
        int i3 = i2;
        if (charSequence instanceof Spanned) {
            ReplacementSpan[] replacementSpanArr = (ReplacementSpan[]) ((Spanned) charSequence).getSpans(i2, i2, ReplacementSpan.class);
            int i4 = 0;
            while (true) {
                i3 = i2;
                if (i4 >= replacementSpanArr.length) {
                    break;
                }
                int spanStart = ((Spanned) charSequence).getSpanStart(replacementSpanArr[i4]);
                int spanEnd = ((Spanned) charSequence).getSpanEnd(replacementSpanArr[i4]);
                int i5 = i2;
                if (spanStart < i2) {
                    i5 = i2;
                    if (spanEnd > i2) {
                        i5 = spanStart;
                    }
                }
                i4++;
                i2 = i5;
            }
        }
        return i3;
    }

    public static CharSequence getReverse(CharSequence charSequence, int i, int i2) {
        return new Reverser(charSequence, i, i2);
    }

    public static int getTrimmedLength(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length || charSequence.charAt(i) > ' ') {
                break;
            }
            i2 = i + 1;
        }
        while (length > i && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length - i;
    }

    public static String htmlEncode(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
            i = i2 + 1;
        }
    }

    public static int indexOf(CharSequence charSequence, char c2) {
        return indexOf(charSequence, c2, 0);
    }

    public static int indexOf(CharSequence charSequence, char c2, int i) {
        return charSequence.getClass() == String.class ? ((String) charSequence).indexOf(c2, i) : indexOf(charSequence, c2, i, charSequence.length());
    }

    public static int indexOf(CharSequence charSequence, char c2, int i, int i2) {
        int i3;
        Class<?> cls = charSequence.getClass();
        if (!(charSequence instanceof GetChars) && cls != StringBuffer.class && cls != StringBuilder.class && cls != String.class) {
            while (i < i2) {
                i3 = i;
                if (charSequence.charAt(i) != c2) {
                    i++;
                }
            }
            return -1;
        }
        char[] obtain = obtain(500);
        loop1: while (true) {
            int i4 = i;
            if (i4 >= i2) {
                recycle(obtain);
                return -1;
            }
            int i5 = i4 + 500;
            i = i5;
            if (i5 > i2) {
                i = i2;
            }
            getChars(charSequence, i4, i, obtain, 0);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < i - i4) {
                    if (obtain[i7] == c2) {
                        recycle(obtain);
                        i3 = i7 + i4;
                        break loop1;
                    }
                    i6 = i7 + 1;
                }
            }
        }
        return i3;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        return indexOf(charSequence, charSequence2, 0, charSequence.length());
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return indexOf(charSequence, charSequence2, i, charSequence.length());
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        int length = charSequence2.length();
        if (length != 0) {
            char charAt = charSequence2.charAt(0);
            while (true) {
                int indexOf = indexOf(charSequence, charAt, i);
                i = -1;
                if (indexOf > i2 - length) {
                    break;
                }
                i = -1;
                if (indexOf < 0) {
                    break;
                } else if (regionMatches(charSequence, indexOf, charSequence2, 0, length)) {
                    return indexOf;
                } else {
                    i = indexOf + 1;
                }
            }
        }
        return i;
    }

    public static boolean isDigitsOnly(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isGraphic(char c2) {
        int type = Character.getType(c2);
        return (type == 15 || type == 16 || type == 19 || type == 0 || type == 13 || type == 14 || type == 12) ? false : true;
    }

    public static boolean isGraphic(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            int type = Character.getType(charSequence.charAt(i2));
            if (type != 15 && type != 16 && type != 19 && type != 0 && type != 13 && type != 14 && type != 12) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isPrintableAscii(char c2) {
        return (' ' <= c2 && c2 <= '~') || c2 == '\r' || c2 == '\n';
    }

    public static boolean isPrintableAsciiOnly(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!isPrintableAscii(charSequence.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static CharSequence join(Iterable<CharSequence> iterable) {
        return join(Resources.getSystem().getText(R.string.list_delimeter), iterable);
    }

    public static String join(CharSequence charSequence, Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : iterable) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public static String join(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Object obj = objArr[i2];
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
            i = i2 + 1;
        }
    }

    public static int lastIndexOf(CharSequence charSequence, char c2) {
        return lastIndexOf(charSequence, c2, charSequence.length() - 1);
    }

    public static int lastIndexOf(CharSequence charSequence, char c2, int i) {
        return charSequence.getClass() == String.class ? ((String) charSequence).lastIndexOf(c2, i) : lastIndexOf(charSequence, c2, 0, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
        r10 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int lastIndexOf(java.lang.CharSequence r6, char r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextUtils.lastIndexOf(java.lang.CharSequence, char, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0.length < r3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] obtain(int r3) {
        /*
            java.lang.Object r0 = android.text.TextUtils.sLock
            r4 = r0
            r0 = r4
            monitor-enter(r0)
            char[] r0 = android.text.TextUtils.sTemp     // Catch: java.lang.Throwable -> L23
            r5 = r0
            r0 = 0
            android.text.TextUtils.sTemp = r0     // Catch: java.lang.Throwable -> L23
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            r0 = r5
            if (r0 == 0) goto L1c
            r0 = r5
            r4 = r0
            r0 = r5
            int r0 = r0.length
            r1 = r3
            if (r0 >= r1) goto L21
        L1c:
            r0 = r3
            char[] r0 = com.android.internal.util.ArrayUtils.newUnpaddedCharArray(r0)
            r4 = r0
        L21:
            r0 = r4
            return r0
        L23:
            r5 = move-exception
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.TextUtils.obtain(int):char[]");
    }

    public static long packRangeInLong(int i, int i2) {
        return (i << 32) | i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readSpan(Parcel parcel, Spannable spannable, Object obj) {
        spannable.setSpan(obj, parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recycle(char[] cArr) {
        if (cArr.length > 1000) {
            return;
        }
        synchronized (sLock) {
            sTemp = cArr;
        }
    }

    public static boolean regionMatches(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        boolean z;
        int i4 = i3 * 2;
        if (i4 < i3) {
            throw new IndexOutOfBoundsException();
        }
        char[] obtain = obtain(i4);
        getChars(charSequence, i, i + i3, obtain, 0);
        getChars(charSequence2, i2, i2 + i3, obtain, i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            z = true;
            if (i6 >= i3) {
                break;
            } else if (obtain[i6] != obtain[i6 + i3]) {
                z = false;
                break;
            } else {
                i5 = i6 + 1;
            }
        }
        recycle(obtain);
        return z;
    }

    public static <T> T[] removeEmptySpans(T[] tArr, Spanned spanned, Class<T> cls) {
        Object[] objArr;
        int i;
        Object[] objArr2 = null;
        int i2 = 0;
        int i3 = 0;
        while (i3 < tArr.length) {
            T t = tArr[i3];
            if (spanned.getSpanStart(t) == spanned.getSpanEnd(t)) {
                objArr = objArr2;
                i = i2;
                if (objArr2 == null) {
                    objArr = (Object[]) Array.newInstance((Class<?>) cls, tArr.length - 1);
                    System.arraycopy(tArr, 0, objArr, 0, i3);
                    i = i3;
                }
            } else {
                objArr = objArr2;
                i = i2;
                if (objArr2 != null) {
                    objArr2[i2] = t;
                    i = i2 + 1;
                    objArr = objArr2;
                }
            }
            i3++;
            objArr2 = objArr;
            i2 = i;
        }
        if (objArr2 != null) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
            System.arraycopy(objArr2, 0, tArr2, 0, i2);
            return tArr2;
        }
        return tArr;
    }

    public static CharSequence replace(CharSequence charSequence, String[] strArr, CharSequence[] charSequenceArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                break;
            }
            int indexOf = indexOf(spannableStringBuilder, strArr[i2]);
            if (indexOf >= 0) {
                spannableStringBuilder.setSpan(strArr[i2], indexOf, strArr[i2].length() + indexOf, 33);
            }
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= strArr.length) {
                return spannableStringBuilder;
            }
            int spanStart = spannableStringBuilder.getSpanStart(strArr[i4]);
            int spanEnd = spannableStringBuilder.getSpanEnd(strArr[i4]);
            if (spanStart >= 0) {
                spannableStringBuilder.replace(spanStart, spanEnd, charSequenceArr[i4]);
            }
            i3 = i4 + 1;
        }
    }

    private static float setPara(MeasuredText measuredText, TextPaint textPaint, CharSequence charSequence, int i, int i2, TextDirectionHeuristic textDirectionHeuristic) {
        float f;
        measuredText.setPara(charSequence, i, i2, textDirectionHeuristic);
        Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
        int i3 = i2 - i;
        if (spanned != null) {
            float f2 = 0.0f;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                f = f2;
                if (i5 >= i3) {
                    break;
                }
                int nextSpanTransition = spanned.nextSpanTransition(i5, i3, MetricAffectingSpan.class);
                f2 += measuredText.addStyleRun(textPaint, (MetricAffectingSpan[]) removeEmptySpans((MetricAffectingSpan[]) spanned.getSpans(i5, nextSpanTransition, MetricAffectingSpan.class), spanned, MetricAffectingSpan.class), nextSpanTransition - i5, null);
                i4 = nextSpanTransition;
            }
        } else {
            f = measuredText.addStyleRun(textPaint, i3, null);
        }
        return f;
    }

    public static String[] split(String str, String str2) {
        return str.length() == 0 ? EMPTY_STRING_ARRAY : str.split(str2, -1);
    }

    public static String[] split(String str, Pattern pattern) {
        return str.length() == 0 ? EMPTY_STRING_ARRAY : pattern.split(str, -1);
    }

    public static CharSequence stringOrSpannedString(CharSequence charSequence) {
        CharSequence charSequence2;
        if (charSequence == null) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
            if (!(charSequence instanceof SpannedString)) {
                return charSequence instanceof Spanned ? new SpannedString(charSequence) : charSequence.toString();
            }
        }
        return charSequence2;
    }

    public static String substring(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return ((String) charSequence).substring(i, i2);
        }
        if (charSequence instanceof StringBuilder) {
            return ((StringBuilder) charSequence).substring(i, i2);
        }
        if (charSequence instanceof StringBuffer) {
            return ((StringBuffer) charSequence).substring(i, i2);
        }
        char[] obtain = obtain(i2 - i);
        getChars(charSequence, i, i2, obtain, 0);
        String str = new String(obtain, 0, i2 - i);
        recycle(obtain);
        return str;
    }

    public static int unpackRangeEndFromLong(long j) {
        return (int) (ExpandableListView.PACKED_POSITION_VALUE_NULL & j);
    }

    public static int unpackRangeStartFromLong(long j) {
        return (int) (j >>> 32);
    }

    public static void writeToParcel(CharSequence charSequence, Parcel parcel, int i) {
        if (!(charSequence instanceof Spanned)) {
            parcel.writeInt(1);
            if (charSequence != null) {
                parcel.writeString(charSequence.toString());
                return;
            } else {
                parcel.writeString(null);
                return;
            }
        }
        parcel.writeInt(0);
        parcel.writeString(charSequence.toString());
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, charSequence.length(), Object.class);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= spans.length) {
                parcel.writeInt(0);
                return;
            }
            Object obj = spans[i3];
            Object obj2 = spans[i3];
            CharacterStyle characterStyle = obj2;
            if (obj2 instanceof CharacterStyle) {
                characterStyle = ((CharacterStyle) obj2).getUnderlying();
            }
            if (characterStyle instanceof ParcelableSpan) {
                ParcelableSpan parcelableSpan = (ParcelableSpan) characterStyle;
                int spanTypeId = parcelableSpan.getSpanTypeId();
                if (spanTypeId < 1 || spanTypeId > 24) {
                    Log.e(TAG, "external class \"" + parcelableSpan.getClass().getSimpleName() + "\" is attempting to use the frameworks-only ParcelableSpan interface");
                } else {
                    parcel.writeInt(spanTypeId);
                    parcelableSpan.writeToParcel(parcel, i);
                    writeWhere(parcel, spanned, obj);
                }
            }
            i2 = i3 + 1;
        }
    }

    private static void writeWhere(Parcel parcel, Spanned spanned, Object obj) {
        parcel.writeInt(spanned.getSpanStart(obj));
        parcel.writeInt(spanned.getSpanEnd(obj));
        parcel.writeInt(spanned.getSpanFlags(obj));
    }
}
