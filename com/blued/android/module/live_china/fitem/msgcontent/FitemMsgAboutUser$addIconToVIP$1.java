package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgAboutUser$addIconToVIP$1.class */
public final class FitemMsgAboutUser$addIconToVIP$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ FitemMsgAboutUser a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Context d;
    final /* synthetic */ TextView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgAboutUser$addIconToVIP$1(FitemMsgAboutUser fitemMsgAboutUser, int i, int i2, Context context, TextView textView) {
        super(1);
        this.a = fitemMsgAboutUser;
        this.b = i;
        this.c = i2;
        this.d = context;
        this.e = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgAboutUser this$0, Context context, int i, int i2, TextView tv, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        FrameLayout frameLayout = (FrameLayout) this$0.a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = tv.getPaddingLeft() + i3;
        layoutParams.topMargin = tv.getPaddingTop() + i4;
        imageView.setLayoutParams(layoutParams);
        frameLayout.addView(imageView);
        String str = this$0.e().vip_frame;
        if (str == null || str.length() == 0) {
            return;
        }
        IRequestHost iRequestHost = this$0.a.b;
        String str2 = this$0.e().vip_frame;
        Intrinsics.a((Object) str2);
        ImageLoader.a(iRequestHost, str2).g().g(-1).a(imageView);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        int i;
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        ColorDrawable colorDrawable = new ColorDrawable();
        i = this.a.g;
        final int i2 = this.b;
        final int i3 = this.c;
        final FitemMsgAboutUser fitemMsgAboutUser = this.a;
        final Context context = this.d;
        final TextView textView = this.e;
        buildSpannableString.a(colorDrawable, 0, i, i2, i3, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgAboutUser$addIconToVIP$1$SZgKfj0W8QbSdKvEzUz9ZYorKP4
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i4, int i5) {
                FitemMsgAboutUser$addIconToVIP$1.a(FitemMsgAboutUser.this, context, i2, i3, textView, i4, i5);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
