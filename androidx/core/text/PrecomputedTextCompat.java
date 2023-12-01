package androidx.core.text;

import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/PrecomputedTextCompat.class */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2567a = new Object();
    private static Executor b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f2568c;
    private final Params d;
    private final int[] e;
    private final PrecomputedText f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/PrecomputedTextCompat$Params.class */
    public static final class Params {

        /* renamed from: a  reason: collision with root package name */
        final PrecomputedText.Params f2569a;
        private final TextPaint b;

        /* renamed from: c  reason: collision with root package name */
        private final TextDirectionHeuristic f2570c;
        private final int d;
        private final int e;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/PrecomputedTextCompat$Params$Builder.class */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f2571a;
            private TextDirectionHeuristic b;

            /* renamed from: c  reason: collision with root package name */
            private int f2572c;
            private int d;

            public Builder(TextPaint textPaint) {
                this.f2571a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2572c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.f2572c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.b = null;
                }
            }

            public Params build() {
                return new Params(this.f2571a, this.b, this.f2572c, this.d);
            }

            public Builder setBreakStrategy(int i) {
                this.f2572c = i;
                return this;
            }

            public Builder setHyphenationFrequency(int i) {
                this.d = i;
                return this;
            }

            public Builder setTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

        public Params(PrecomputedText.Params params) {
            this.b = params.getTextPaint();
            this.f2570c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.f2569a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2569a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2569a = null;
            }
            this.b = textPaint;
            this.f2570c = textDirectionHeuristic;
            this.d = i;
            this.e = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Params) {
                Params params = (Params) obj;
                if (equalsWithoutTextDirection(params)) {
                    return Build.VERSION.SDK_INT < 18 || this.f2570c == params.getTextDirection();
                }
                return false;
            }
            return false;
        }

        public boolean equalsWithoutTextDirection(Params params) {
            if ((Build.VERSION.SDK_INT < 23 || (this.d == params.getBreakStrategy() && this.e == params.getHyphenationFrequency())) && this.b.getTextSize() == params.getTextPaint().getTextSize() && this.b.getTextScaleX() == params.getTextPaint().getTextScaleX() && this.b.getTextSkewX() == params.getTextPaint().getTextSkewX()) {
                if ((Build.VERSION.SDK_INT < 21 || (this.b.getLetterSpacing() == params.getTextPaint().getLetterSpacing() && TextUtils.equals(this.b.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()))) && this.b.getFlags() == params.getTextPaint().getFlags()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (!this.b.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                            return false;
                        }
                    } else if (Build.VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                        return false;
                    }
                    return this.b.getTypeface() == null ? params.getTextPaint().getTypeface() == null : this.b.getTypeface().equals(params.getTextPaint().getTypeface());
                }
                return false;
            }
            return false;
        }

        public int getBreakStrategy() {
            return this.d;
        }

        public int getHyphenationFrequency() {
            return this.e;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.f2570c;
        }

        public TextPaint getTextPaint() {
            return this.b;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.hash(Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocales(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.f2570c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return ObjectsCompat.hash(Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.f2570c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            if (Build.VERSION.SDK_INT < 18 && Build.VERSION.SDK_INT < 17) {
                return ObjectsCompat.hash(Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTypeface(), this.f2570c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            return ObjectsCompat.hash(Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.f2570c, Integer.valueOf(this.d), Integer.valueOf(this.e));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.b.getTextSize());
            sb.append(", textScaleX=" + this.b.getTextScaleX());
            sb.append(", textSkewX=" + this.b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.b.getTextLocale());
            }
            sb.append(", typeface=" + this.b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2570c);
            sb.append(", breakStrategy=" + this.d);
            sb.append(", hyphenationFrequency=" + this.e);
            sb.append(i.d);
            return sb.toString();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/PrecomputedTextCompat$PrecomputedTextFutureTask.class */
    static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback.class */
        static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {

            /* renamed from: a  reason: collision with root package name */
            private Params f2573a;
            private CharSequence b;

            PrecomputedTextCallback(Params params, CharSequence charSequence) {
                this.f2573a = params;
                this.b = charSequence;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.b, this.f2573a);
            }
        }

        PrecomputedTextFutureTask(Params params, CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.f2568c = precomputedText;
        this.d = params;
        this.e = null;
        this.f = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    private PrecomputedTextCompat(CharSequence charSequence, Params params, int[] iArr) {
        this.f2568c = new SpannableString(charSequence);
        this.d = params;
        this.e = iArr;
        this.f = null;
    }

    public static PrecomputedTextCompat create(CharSequence charSequence, Params params) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && params.f2569a != null) {
                PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(PrecomputedText.create(charSequence, params.f2569a), params);
                TraceCompat.endSection();
                return precomputedTextCompat;
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= arrayList.size()) {
                    break;
                }
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
                i2 = i3 + 1;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            } else if (Build.VERSION.SDK_INT >= 21) {
                new StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            PrecomputedTextCompat precomputedTextCompat2 = new PrecomputedTextCompat(charSequence, params, iArr);
            TraceCompat.endSection();
            return precomputedTextCompat2;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence charSequence, Params params, Executor executor) {
        PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
        Executor executor2 = executor;
        if (executor == null) {
            synchronized (f2567a) {
                if (b == null) {
                    b = Executors.newFixedThreadPool(1);
                }
                executor2 = b;
            }
        }
        executor2.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f2568c.charAt(i);
    }

    public int getParagraphCount() {
        return Build.VERSION.SDK_INT >= 29 ? this.f.getParagraphCount() : this.e.length;
    }

    public int getParagraphEnd(int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        return Build.VERSION.SDK_INT >= 29 ? this.f.getParagraphEnd(i) : this.e[i];
    }

    public int getParagraphStart(int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f.getParagraphStart(i);
        }
        if (i == 0) {
            return 0;
        }
        return this.e[i - 1];
    }

    public Params getParams() {
        return this.d;
    }

    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.f2568c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2568c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2568c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2568c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f.getSpans(i, i2, cls) : (T[]) this.f2568c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2568c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f2568c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f.removeSpan(obj);
        } else {
            this.f2568c.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f.setSpan(obj, i, i2, i3);
        } else {
            this.f2568c.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f2568c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2568c.toString();
    }
}
