package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/BidiFormatter.class */
public final class BidiFormatter {
    private final boolean f;
    private final int g;
    private final TextDirectionHeuristicCompat h;

    /* renamed from: a  reason: collision with root package name */
    static final TextDirectionHeuristicCompat f2560a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String d = Character.toString(8206);
    private static final String e = Character.toString(8207);
    static final BidiFormatter b = new BidiFormatter(false, 2, f2560a);

    /* renamed from: c  reason: collision with root package name */
    static final BidiFormatter f2561c = new BidiFormatter(true, 2, f2560a);

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/BidiFormatter$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2562a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private TextDirectionHeuristicCompat f2563c;

        public Builder() {
            a(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            a(BidiFormatter.a(locale));
        }

        public Builder(boolean z) {
            a(z);
        }

        private void a(boolean z) {
            this.f2562a = z;
            this.f2563c = BidiFormatter.f2560a;
            this.b = 2;
        }

        private static BidiFormatter b(boolean z) {
            return z ? BidiFormatter.f2561c : BidiFormatter.b;
        }

        public BidiFormatter build() {
            return (this.b == 2 && this.f2563c == BidiFormatter.f2560a) ? b(this.f2562a) : new BidiFormatter(this.f2562a, this.b, this.f2563c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f2563c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.b |= 2;
                return this;
            }
            this.b &= -3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/BidiFormatter$DirectionalityEstimator.class */
    public static class DirectionalityEstimator {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f2564a = new byte[1792];
        private final CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2565c;
        private final int d;
        private int e;
        private char f;

        static {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 1792) {
                    return;
                }
                f2564a[i2] = Character.getDirectionality(i2);
                i = i2 + 1;
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.b = charSequence;
            this.f2565c = z;
            this.d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f2564a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 >= this.d) {
                    this.e = i;
                    this.f = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.b;
                this.e = i2 + 1;
                char charAt2 = charSequence.charAt(i2);
                this.f = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f;
                    do {
                        int i3 = this.e;
                        if (i3 < this.d) {
                            CharSequence charSequence2 = this.b;
                            this.e = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f = charAt;
                        }
                    } while (charAt != c2);
                }
            }
        }

        private byte f() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.b;
                int i3 = i2 - 1;
                this.e = i3;
                char charAt2 = charSequence.charAt(i3);
                this.f = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f;
                    do {
                        int i4 = this.e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.b;
                            int i5 = i4 - 1;
                            this.e = i5;
                            charAt = charSequence2.charAt(i5);
                            this.f = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.e = i;
            this.f = '>';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i = this.e;
                if (i >= this.d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.b;
                this.e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i = this.e;
            do {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.b;
                int i3 = i2 - 1;
                this.e = i3;
                charAt = charSequence.charAt(i3);
                this.f = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.e = i;
            this.f = ';';
            return (byte) 13;
        }

        int a() {
            this.e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e < this.d && i == 0) {
                byte c2 = c();
                if (c2 != 0) {
                    if (c2 == 1 || c2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (c2 != 9) {
                        switch (c2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int b() {
            this.e = this.d;
            int i = 0;
            int i2 = 0;
            while (this.e > 0) {
                byte d = d();
                if (d != 0) {
                    if (d == 1 || d == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            i2 = i;
                        }
                    } else if (d != 9) {
                        switch (d) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                    break;
                                } else {
                                    i2 = i;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i == 0) {
                    return -1;
                } else {
                    if (i2 == 0) {
                        i2 = i;
                    }
                }
            }
            return 0;
        }

        byte c() {
            char charAt = this.b.charAt(this.e);
            this.f = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.b, this.e);
                this.e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.e++;
            byte a2 = a(this.f);
            byte b = a2;
            if (this.f2565c) {
                char c2 = this.f;
                if (c2 == '<') {
                    return e();
                }
                b = a2;
                if (c2 == '&') {
                    b = g();
                }
            }
            return b;
        }

        byte d() {
            char charAt = this.b.charAt(this.e - 1);
            this.f = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.b, this.e);
                this.e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.e--;
            byte a2 = a(this.f);
            byte b = a2;
            if (this.f2565c) {
                char c2 = this.f;
                if (c2 == '>') {
                    return f();
                }
                b = a2;
                if (c2 == ';') {
                    b = h();
                }
            }
            return b;
        }
    }

    BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f = z;
        this.g = i;
        this.h = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).b();
    }

    private String a(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.f || !(isRtl || a(charSequence) == 1)) ? this.f ? (!isRtl || a(charSequence) == -1) ? e : "" : "" : d;
    }

    static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).a();
    }

    private String b(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.f || !(isRtl || b(charSequence) == 1)) ? this.f ? (!isRtl || b(charSequence) == -1) ? e : "" : "" : d;
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean getStereoReset() {
        return (this.g & 2) != 0;
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.h.isRtl(charSequence, 0, charSequence.length());
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.f;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.h, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.f) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.h, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.h, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.h, z);
    }
}
