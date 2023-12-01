package android.content.res;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Annotation;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/content/res/StringBlock.class */
public final class StringBlock {
    private static final String TAG = "AssetManager";
    private static final boolean localLOGV = false;
    private final long mNative;
    private SparseArray<CharSequence> mSparseStrings;
    private CharSequence[] mStrings;
    private final boolean mUseSparse;
    StyleIDs mStyleIDs = null;
    private final boolean mOwnsNative = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/res/StringBlock$Height.class */
    public static class Height implements LineHeightSpan.WithDensity {
        private static float sProportion = 0.0f;
        private int mSize;

        public Height(int i) {
            this.mSize = i;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            chooseHeight(charSequence, i, i2, i3, i4, fontMetricsInt, null);
        }

        @Override // android.text.style.LineHeightSpan.WithDensity
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt, TextPaint textPaint) {
            Rect rect;
            int i5 = this.mSize;
            int i6 = i5;
            if (textPaint != null) {
                i6 = (int) (i5 * textPaint.density);
            }
            if (fontMetricsInt.bottom - fontMetricsInt.top < i6) {
                fontMetricsInt.top = fontMetricsInt.bottom - i6;
                fontMetricsInt.ascent -= i6;
                return;
            }
            if (sProportion == 0.0f) {
                Paint paint = new Paint();
                paint.setTextSize(100.0f);
                paint.getTextBounds("ABCDEFG", 0, 7, new Rect());
                sProportion = rect.top / paint.ascent();
            }
            int ceil = (int) Math.ceil((-fontMetricsInt.top) * sProportion);
            if (i6 - fontMetricsInt.descent >= ceil) {
                fontMetricsInt.top = fontMetricsInt.bottom - i6;
                fontMetricsInt.ascent = fontMetricsInt.descent - i6;
            } else if (i6 < ceil) {
                int i7 = -i6;
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                fontMetricsInt.descent = 0;
                fontMetricsInt.bottom = 0;
            } else {
                int i8 = -ceil;
                fontMetricsInt.ascent = i8;
                fontMetricsInt.top = i8;
                int i9 = fontMetricsInt.top + i6;
                fontMetricsInt.descent = i9;
                fontMetricsInt.bottom = i9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/res/StringBlock$StyleIDs.class */
    public static final class StyleIDs {
        private int boldId = -1;
        private int italicId = -1;
        private int underlineId = -1;
        private int ttId = -1;
        private int bigId = -1;
        private int smallId = -1;
        private int subId = -1;
        private int supId = -1;
        private int strikeId = -1;
        private int listItemId = -1;
        private int marqueeId = -1;

        StyleIDs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringBlock(long j, boolean z) {
        this.mNative = j;
        this.mUseSparse = z;
    }

    public StringBlock(byte[] bArr, int i, int i2, boolean z) {
        this.mNative = nativeCreate(bArr, i, i2);
        this.mUseSparse = z;
    }

    public StringBlock(byte[] bArr, boolean z) {
        this.mNative = nativeCreate(bArr, 0, bArr.length);
        this.mUseSparse = z;
    }

    private static void addParagraphSpan(Spannable spannable, Object obj, int i, int i2) {
        int length = spannable.length();
        int i3 = i;
        if (i != 0) {
            i3 = i;
            if (i != length) {
                i3 = i;
                if (spannable.charAt(i - 1) != '\n') {
                    while (true) {
                        i--;
                        i3 = i;
                        if (i <= 0) {
                            break;
                        } else if (spannable.charAt(i - 1) == '\n') {
                            i3 = i;
                            break;
                        }
                    }
                }
            }
        }
        int i4 = i2;
        if (i2 != 0) {
            i4 = i2;
            if (i2 != length) {
                i4 = i2;
                if (spannable.charAt(i2 - 1) != '\n') {
                    int i5 = i2;
                    while (true) {
                        int i6 = i5 + 1;
                        i4 = i6;
                        if (i6 >= length) {
                            break;
                        } else if (spannable.charAt(i6 - 1) == '\n') {
                            i4 = i6;
                            break;
                        } else {
                            i5 = i6;
                        }
                    }
                }
            }
        }
        spannable.setSpan(obj, i3, i4, 51);
    }

    private CharSequence applyStyles(String str, int[] iArr, StyleIDs styleIDs) {
        int indexOf;
        if (iArr.length == 0) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return new SpannedString(spannableString);
            }
            int i3 = iArr[i2];
            if (i3 == styleIDs.boldId) {
                spannableString.setSpan(new StyleSpan(1), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.italicId) {
                spannableString.setSpan(new StyleSpan(2), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.underlineId) {
                spannableString.setSpan(new UnderlineSpan(), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.ttId) {
                spannableString.setSpan(new TypefaceSpan("monospace"), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.bigId) {
                spannableString.setSpan(new RelativeSizeSpan(1.25f), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.smallId) {
                spannableString.setSpan(new RelativeSizeSpan(0.8f), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.subId) {
                spannableString.setSpan(new SubscriptSpan(), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.supId) {
                spannableString.setSpan(new SuperscriptSpan(), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.strikeId) {
                spannableString.setSpan(new StrikethroughSpan(), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
            } else if (i3 == styleIDs.listItemId) {
                addParagraphSpan(spannableString, new BulletSpan(10), iArr[i2 + 1], iArr[i2 + 2] + 1);
            } else if (i3 == styleIDs.marqueeId) {
                spannableString.setSpan(TextUtils.TruncateAt.MARQUEE, iArr[i2 + 1], iArr[i2 + 2] + 1, 18);
            } else {
                String nativeGetString = nativeGetString(this.mNative, i3);
                if (nativeGetString.startsWith("font;")) {
                    String subtag = subtag(nativeGetString, ";height=");
                    if (subtag != null) {
                        addParagraphSpan(spannableString, new Height(Integer.parseInt(subtag)), iArr[i2 + 1], iArr[i2 + 2] + 1);
                    }
                    String subtag2 = subtag(nativeGetString, ";size=");
                    if (subtag2 != null) {
                        spannableString.setSpan(new AbsoluteSizeSpan(Integer.parseInt(subtag2), true), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                    String subtag3 = subtag(nativeGetString, ";fgcolor=");
                    if (subtag3 != null) {
                        spannableString.setSpan(getColor(subtag3, true), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                    String subtag4 = subtag(nativeGetString, ";color=");
                    if (subtag4 != null) {
                        spannableString.setSpan(getColor(subtag4, true), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                    String subtag5 = subtag(nativeGetString, ";bgcolor=");
                    if (subtag5 != null) {
                        spannableString.setSpan(getColor(subtag5, false), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                    String subtag6 = subtag(nativeGetString, ";face=");
                    if (subtag6 != null) {
                        spannableString.setSpan(new TypefaceSpan(subtag6), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                } else if (nativeGetString.startsWith("a;")) {
                    String subtag7 = subtag(nativeGetString, ";href=");
                    if (subtag7 != null) {
                        spannableString.setSpan(new URLSpan(subtag7), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                    }
                } else if (nativeGetString.startsWith("annotation;")) {
                    int length = nativeGetString.length();
                    int indexOf2 = nativeGetString.indexOf(59);
                    while (true) {
                        int i4 = indexOf2;
                        if (i4 < length && (indexOf = nativeGetString.indexOf(61, i4)) >= 0) {
                            int indexOf3 = nativeGetString.indexOf(59, indexOf);
                            int i5 = indexOf3;
                            if (indexOf3 < 0) {
                                i5 = length;
                            }
                            spannableString.setSpan(new Annotation(nativeGetString.substring(i4 + 1, indexOf), nativeGetString.substring(indexOf + 1, i5)), iArr[i2 + 1], iArr[i2 + 2] + 1, 33);
                            indexOf2 = i5;
                        }
                    }
                }
            }
            i = i2 + 3;
        }
    }

    private static CharacterStyle getColor(String str, boolean z) {
        int i = -16777216;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("@")) {
                Resources system = Resources.getSystem();
                int identifier = system.getIdentifier(str.substring(1), "color", "android");
                i = -16777216;
                if (identifier != 0) {
                    ColorStateList colorStateList = system.getColorStateList(identifier);
                    if (z) {
                        return new TextAppearanceSpan(null, 0, 0, colorStateList, null);
                    }
                    i = colorStateList.getDefaultColor();
                }
            } else {
                i = Color.getHtmlColor(str);
            }
        }
        return z ? new ForegroundColorSpan(i) : new BackgroundColorSpan(i);
    }

    private static native long nativeCreate(byte[] bArr, int i, int i2);

    private static native void nativeDestroy(long j);

    private static native int nativeGetSize(long j);

    private static native String nativeGetString(long j, int i);

    private static native int[] nativeGetStyle(long j, int i);

    private static String subtag(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return null;
        }
        int length = indexOf + str2.length();
        int indexOf2 = str.indexOf(59, length);
        return indexOf2 < 0 ? str.substring(length) : str.substring(length, indexOf2);
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (this.mOwnsNative) {
                nativeDestroy(this.mNative);
            }
        }
    }

    public CharSequence get(int i) {
        synchronized (this) {
            if (this.mStrings != null) {
                CharSequence charSequence = this.mStrings[i];
                if (charSequence != null) {
                    return charSequence;
                }
            } else if (this.mSparseStrings != null) {
                CharSequence charSequence2 = this.mSparseStrings.get(i);
                if (charSequence2 != null) {
                    return charSequence2;
                }
            } else {
                int nativeGetSize = nativeGetSize(this.mNative);
                if (!this.mUseSparse || nativeGetSize <= 250) {
                    this.mStrings = new CharSequence[nativeGetSize];
                } else {
                    this.mSparseStrings = new SparseArray<>();
                }
            }
            String nativeGetString = nativeGetString(this.mNative, i);
            CharSequence charSequence3 = nativeGetString;
            int[] nativeGetStyle = nativeGetStyle(this.mNative, i);
            if (nativeGetStyle != null) {
                if (this.mStyleIDs == null) {
                    this.mStyleIDs = new StyleIDs();
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= nativeGetStyle.length) {
                        break;
                    }
                    int i4 = nativeGetStyle[i3];
                    if (i4 != this.mStyleIDs.boldId && i4 != this.mStyleIDs.italicId && i4 != this.mStyleIDs.underlineId && i4 != this.mStyleIDs.ttId && i4 != this.mStyleIDs.bigId && i4 != this.mStyleIDs.smallId && i4 != this.mStyleIDs.subId && i4 != this.mStyleIDs.supId && i4 != this.mStyleIDs.strikeId && i4 != this.mStyleIDs.listItemId && i4 != this.mStyleIDs.marqueeId) {
                        String nativeGetString2 = nativeGetString(this.mNative, i4);
                        if (nativeGetString2.equals("b")) {
                            this.mStyleIDs.boldId = i4;
                        } else if (nativeGetString2.equals("i")) {
                            this.mStyleIDs.italicId = i4;
                        } else if (nativeGetString2.equals("u")) {
                            this.mStyleIDs.underlineId = i4;
                        } else if (nativeGetString2.equals("tt")) {
                            this.mStyleIDs.ttId = i4;
                        } else if (nativeGetString2.equals("big")) {
                            this.mStyleIDs.bigId = i4;
                        } else if (nativeGetString2.equals("small")) {
                            this.mStyleIDs.smallId = i4;
                        } else if (nativeGetString2.equals("sup")) {
                            this.mStyleIDs.supId = i4;
                        } else if (nativeGetString2.equals("sub")) {
                            this.mStyleIDs.subId = i4;
                        } else if (nativeGetString2.equals("strike")) {
                            this.mStyleIDs.strikeId = i4;
                        } else if (nativeGetString2.equals(AppIconSetting.LARGE_ICON_URL)) {
                            this.mStyleIDs.listItemId = i4;
                        } else if (nativeGetString2.equals("marquee")) {
                            this.mStyleIDs.marqueeId = i4;
                        }
                    }
                    i2 = i3 + 3;
                }
                charSequence3 = applyStyles(nativeGetString, nativeGetStyle, this.mStyleIDs);
            }
            if (this.mStrings != null) {
                this.mStrings[i] = charSequence3;
            } else {
                this.mSparseStrings.put(i, charSequence3);
            }
            return charSequence3;
        }
    }
}
