package com.blued.android.module.yy_china.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.common.view.CenterAlignUrlImageSpan;
import com.blued.android.module.yy_china.view.FansFontSpan;
import com.blued.android.module.yy_china.view.GradientFontSpan;
import com.blued.android.module.yy_china.view.ShapeTextFontSpan;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYTextSpanComputer.class */
public final class YYTextSpanComputer {
    private final SpannableStringBuilder a;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYTextSpanComputer$Builder.class */
    public static final class Builder {
        private final ArrayList<SpannableString> a = new ArrayList<>();
        private final ArrayList<CharacterStyle> b = new ArrayList<>();

        public final Builder a(Context con, String mes, int i, int i2) {
            Intrinsics.e(con, "con");
            Intrinsics.e(mes, "mes");
            SpannableString spannableString = new SpannableString(mes);
            ShapeTextFontSpan shapeTextFontSpan = new ShapeTextFontSpan(con, i, i2);
            spannableString.setSpan(shapeTextFontSpan, 0, mes.length(), 33);
            this.a.add(spannableString);
            this.b.add(shapeTextFontSpan);
            return this;
        }

        public final Builder a(Context con, String mes, int i, String levelName, boolean z) {
            Intrinsics.e(con, "con");
            Intrinsics.e(mes, "mes");
            Intrinsics.e(levelName, "levelName");
            SpannableString spannableString = new SpannableString(mes);
            FansFontSpan fansFontSpan = new FansFontSpan(con, i, levelName, z);
            spannableString.setSpan(fansFontSpan, 0, mes.length(), 33);
            this.a.add(spannableString);
            this.b.add(fansFontSpan);
            return this;
        }

        public final Builder a(Drawable newBitmap) {
            Intrinsics.e(newBitmap, "newBitmap");
            SpannableString spannableString = new SpannableString("1");
            CenterAlignImageSpan centerAlignImageSpan = new CenterAlignImageSpan(newBitmap);
            spannableString.setSpan(centerAlignImageSpan, 0, 1, 33);
            this.a.add(spannableString);
            this.b.add(centerAlignImageSpan);
            return this;
        }

        public final Builder a(TextView tv, IRequestHost iRequestHost, int i, int i2, String url) {
            Intrinsics.e(tv, "tv");
            Intrinsics.e(url, "url");
            SpannableString spannableString = new SpannableString("1");
            CenterAlignUrlImageSpan centerAlignUrlImageSpan = new CenterAlignUrlImageSpan(new WeakReference(tv), iRequestHost, i, i2, url);
            spannableString.setSpan(centerAlignUrlImageSpan, 0, 1, 33);
            this.a.add(spannableString);
            this.b.add(centerAlignUrlImageSpan);
            return this;
        }

        public final Builder a(String mes) {
            Intrinsics.e(mes, "mes");
            this.a.add(new SpannableString(mes));
            this.b.add(null);
            return this;
        }

        public final Builder a(String mes, int i, int i2) {
            Intrinsics.e(mes, "mes");
            SpannableString spannableString = new SpannableString(mes);
            GradientFontSpan gradientFontSpan = new GradientFontSpan(i, i2);
            spannableString.setSpan(gradientFontSpan, 0, mes.length(), 33);
            this.a.add(spannableString);
            this.b.add(gradientFontSpan);
            return this;
        }

        public final YYTextSpanComputer a(Paint paint, int i) {
            Intrinsics.e(paint, "paint");
            return new YYTextSpanComputer(this, paint, i, null);
        }

        public final ArrayList<SpannableString> a() {
            return this.a;
        }

        public final void a(SpannableString spa, CharacterStyle span) {
            Intrinsics.e(spa, "spa");
            Intrinsics.e(span, "span");
            this.a.add(spa);
            this.b.add(span);
        }

        public final ArrayList<CharacterStyle> b() {
            return this.b;
        }

        public final YYTextSpanComputer c() {
            return new YYTextSpanComputer(this, null);
        }
    }

    public YYTextSpanComputer() {
        this.a = new SpannableStringBuilder();
    }

    private YYTextSpanComputer(Builder builder) {
        this();
        for (SpannableString spannableString : builder.a()) {
            a().append((CharSequence) spannableString);
        }
    }

    private YYTextSpanComputer(Builder builder, Paint paint, int i) {
        this();
        float f;
        String spannableString;
        Drawable drawable;
        int size = builder.b().size();
        int i2 = 0;
        boolean z = false;
        while (true) {
            float f2 = 0.0f;
            boolean z2 = z;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                i2 = i3 + 1;
                if (z2) {
                    this.a.append((CharSequence) builder.a().get(i3));
                } else {
                    CharacterStyle characterStyle = builder.b().get(i3);
                    if (characterStyle == null) {
                        f = f2 + ((int) paint.measureText(builder.a().get(i3).toString())) + 1;
                        this.a.append((CharSequence) builder.a().get(i3));
                        z = z2;
                    } else if (characterStyle instanceof CenterAlignImageSpan) {
                        f = ((CenterAlignImageSpan) characterStyle).getDrawable() instanceof BitmapDrawable ? f2 + ((BitmapDrawable) drawable).getBitmap().getWidth() + 2 : f2;
                        this.a.append((CharSequence) builder.a().get(i3));
                        z = z2;
                    } else if (characterStyle instanceof CenterAlignUrlImageSpan) {
                        f = f2 + ((CenterAlignUrlImageSpan) characterStyle).b();
                        this.a.append((CharSequence) builder.a().get(i3));
                        z = z2;
                    } else if (characterStyle instanceof FansFontSpan) {
                        f = f2 + ((FansFontSpan) characterStyle).d() + 2;
                        this.a.append((CharSequence) builder.a().get(i3));
                        z = z2;
                    } else if (characterStyle instanceof ShapeTextFontSpan) {
                        ShapeTextFontSpan shapeTextFontSpan = (ShapeTextFontSpan) characterStyle;
                        Intrinsics.c(builder.a().get(i3).toString(), "builder.spStrs[i].toString()");
                        f = f2 + shapeTextFontSpan.a(spannableString);
                        this.a.append((CharSequence) builder.a().get(i3));
                        z = z2;
                    } else {
                        z = z2;
                        f = f2;
                        if (characterStyle instanceof GradientFontSpan) {
                            String spannableString2 = builder.a().get(i3).toString();
                            Intrinsics.c(spannableString2, "builder.spStrs[i].toString()");
                            float measureText = paint.measureText(spannableString2);
                            float f3 = i;
                            if (f2 > f3) {
                                this.a.append((CharSequence) builder.a().get(i3));
                                z = z2;
                                f = f2;
                            } else {
                                f = f2 + measureText;
                                if (f / f3 > 0.0f) {
                                    int length = (int) (((f3 - f2) / measureText) * spannableString2.length());
                                    int length2 = length >= spannableString2.length() ? spannableString2.length() : length;
                                    SpannableString spannableString3 = new SpannableString(spannableString2.subSequence(0, length2));
                                    GradientFontSpan gradientFontSpan = (GradientFontSpan) characterStyle;
                                    spannableString3.setSpan(new GradientFontSpan(gradientFontSpan.a(), gradientFontSpan.b()), 0, length2, 33);
                                    this.a.append((CharSequence) spannableString3);
                                    SpannableString spannableString4 = new SpannableString(spannableString2.subSequence(length2, spannableString2.length()));
                                    if (length2 == 0) {
                                        spannableString4.setSpan(new GradientFontSpan(gradientFontSpan.a(), gradientFontSpan.b()), 0, spannableString4.length(), 33);
                                    } else {
                                        spannableString4.setSpan(new GradientFontSpan(gradientFontSpan.b(), gradientFontSpan.b()), 0, spannableString4.length(), 33);
                                    }
                                    this.a.append((CharSequence) spannableString4);
                                } else {
                                    this.a.append((CharSequence) builder.a().get(i3));
                                }
                                z = true;
                            }
                        }
                    }
                    z2 = z;
                    f2 = f;
                    if (f / i > 0.0f) {
                        break;
                    }
                }
            }
        }
    }

    public /* synthetic */ YYTextSpanComputer(Builder builder, Paint paint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, paint, i);
    }

    public /* synthetic */ YYTextSpanComputer(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final SpannableStringBuilder a() {
        return this.a;
    }
}
