package com.blued.android.module.live_china.view;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilderImpl;
import com.blued.android.module.live_china.utils.dslspannable.MiddleIMarginImageSpan;
import io.noties.markwon.core.spans.CustomTypefaceSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveTextSpanExKt.class */
public final class LiveTextSpanExKt {
    public static final CharSequence a(CharSequence charSequence, Typeface typeface, IntRange range) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(typeface, "typeface");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new CustomTypefaceSpan(typeface), range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }

    public static final CharSequence a(CharSequence charSequence, Drawable drawable, IntRange range, int i, int i2, int i3, int i4, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(drawable, "drawable");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        int i5 = i3;
        if (i3 == 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        int i6 = i4;
        if (i4 == 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        drawable.setBounds(0, 0, i5, i6);
        spannableString.setSpan(new MiddleIMarginImageSpan(drawable, i, i2, spanDrawCallback), range.a(), range.b(), 17);
        return spannableString;
    }

    public static final CharSequence a(CharSequence charSequence, IntRange range) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new StrikethroughSpan(), range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }

    public static final CharSequence a(CharSequence charSequence, IntRange range, float f) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new RelativeSizeSpan(f), range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }

    public static final CharSequence a(CharSequence charSequence, IntRange range, int i) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i), range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }

    public static final CharSequence a(CharSequence charSequence, IntRange range, final int i, final boolean z, final Function0<Unit> function0) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.view.LiveTextSpanExKt$toClickSpan$1$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                Function0<Unit> function02 = function0;
                if (function02 == null) {
                    return;
                }
                function02.invoke();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(i);
                ds.setUnderlineText(z);
            }
        }, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }

    public static final void a(TextView textView, Function1<? super DslSpannableStringBuilder, Unit> init) {
        DslSpannableStringBuilderImpl dslSpannableStringBuilderImpl;
        Intrinsics.e(textView, "<this>");
        Intrinsics.e(init, "init");
        Object tag = textView.getTag(R.id.live_msg_span);
        if (tag == null || !(tag instanceof DslSpannableStringBuilderImpl)) {
            dslSpannableStringBuilderImpl = new DslSpannableStringBuilderImpl();
            textView.setTag(R.id.live_msg_span, dslSpannableStringBuilderImpl);
        } else {
            dslSpannableStringBuilderImpl = (DslSpannableStringBuilderImpl) tag;
        }
        init.invoke(dslSpannableStringBuilderImpl);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(dslSpannableStringBuilderImpl.a());
    }

    public static final CharSequence b(CharSequence charSequence, IntRange range, int i) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new BackgroundColorSpan(i), range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
        return spannableString;
    }
}
