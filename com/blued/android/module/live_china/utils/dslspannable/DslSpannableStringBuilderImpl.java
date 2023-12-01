package com.blued.android.module.live_china.utils.dslspannable;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/DslSpannableStringBuilderImpl.class */
public final class DslSpannableStringBuilderImpl implements DslSpannableStringBuilder {
    private final SpannableStringBuilder a = new SpannableStringBuilder();

    public final SpannableStringBuilder a() {
        return this.a;
    }

    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder
    public void a(int i, int i2, int i3, int i4, int i5) {
        a(i, i2, i3, i4, i5, (VerticalCenterImageSpan.SpanDrawCallback) null);
    }

    public void a(int i, int i2, int i3, int i4, int i5, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback) {
        Drawable drawable = ContextCompat.getDrawable(AppInfo.d(), i);
        if (drawable == null) {
            return;
        }
        a(drawable, i2, i3, i4, i5, spanDrawCallback);
    }

    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder
    public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        Intrinsics.e(drawable, "drawable");
        a(drawable, i, i2, i3, i4, (VerticalCenterImageSpan.SpanDrawCallback) null);
    }

    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder
    public void a(Drawable drawable, int i, int i2, int i3, int i4, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback) {
        Intrinsics.e(drawable, "drawable");
        this.a.append(LiveTextSpanExKt.a("1", drawable, new IntRange(0, 1), i, i2, i3, i4, spanDrawCallback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.CharSequence] */
    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder
    public void a(String text, Function1<? super DslSpanBuilder, Unit> function1) {
        Intrinsics.e(text, "text");
        DslSpanBuilderImpl dslSpanBuilderImpl = new DslSpanBuilderImpl();
        if (function1 != null) {
            function1.invoke(dslSpanBuilderImpl);
        }
        Object a = dslSpanBuilderImpl.a() ? LiveTextSpanExKt.a((CharSequence) text, new IntRange(0, text.length()), dslSpanBuilderImpl.b()) : text;
        Object obj = a;
        if (dslSpanBuilderImpl.k()) {
            obj = LiveTextSpanExKt.b(a, new IntRange(0, text.length()), dslSpanBuilderImpl.l());
        }
        Object obj2 = obj;
        if (dslSpanBuilderImpl.f()) {
            obj2 = LiveTextSpanExKt.a(obj, new IntRange(0, text.length()), dslSpanBuilderImpl.g());
        }
        Object obj3 = obj2;
        if (dslSpanBuilderImpl.c()) {
            obj3 = LiveTextSpanExKt.a((CharSequence) obj2, new IntRange(0, text.length()), dslSpanBuilderImpl.b(), dslSpanBuilderImpl.d(), dslSpanBuilderImpl.e());
        }
        Object obj4 = obj3;
        if (dslSpanBuilderImpl.h()) {
            obj4 = LiveTextSpanExKt.a((CharSequence) obj3, dslSpanBuilderImpl.i(), new IntRange(0, text.length()));
        }
        Object obj5 = obj4;
        if (dslSpanBuilderImpl.j()) {
            obj5 = LiveTextSpanExKt.a((CharSequence) obj4, new IntRange(0, text.length()));
        }
        this.a.append((CharSequence) ((CharSequence) obj5));
    }
}
