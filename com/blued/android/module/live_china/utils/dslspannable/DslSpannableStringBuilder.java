package com.blued.android.module.live_china.utils.dslspannable;

import android.graphics.drawable.Drawable;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/DslSpannableStringBuilder.class */
public interface DslSpannableStringBuilder {

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/DslSpannableStringBuilder$DefaultImpls.class */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(DslSpannableStringBuilder dslSpannableStringBuilder, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addText");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            dslSpannableStringBuilder.a(str, function1);
        }
    }

    void a(int i, int i2, int i3, int i4, int i5);

    void a(Drawable drawable, int i, int i2, int i3, int i4);

    void a(Drawable drawable, int i, int i2, int i3, int i4, VerticalCenterImageSpan.SpanDrawCallback spanDrawCallback);

    void a(String str, Function1<? super DslSpanBuilder, Unit> function1);
}
