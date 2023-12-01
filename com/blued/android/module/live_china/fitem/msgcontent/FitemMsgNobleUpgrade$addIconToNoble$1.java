package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgNobleUpgrade$addIconToNoble$1.class */
final class FitemMsgNobleUpgrade$addIconToNoble$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f12577a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FitemMsgNobleUpgrade f12578c;
    final /* synthetic */ Context d;
    final /* synthetic */ TextView e;
    final /* synthetic */ Ref.ObjectRef<String> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgNobleUpgrade$addIconToNoble$1(int i, int i2, FitemMsgNobleUpgrade fitemMsgNobleUpgrade, Context context, TextView textView, Ref.ObjectRef<String> objectRef) {
        super(1);
        this.f12577a = i;
        this.b = i2;
        this.f12578c = fitemMsgNobleUpgrade;
        this.d = context;
        this.e = textView;
        this.f = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgNobleUpgrade this$0, Context context, int i, int i2, TextView tv, Ref.ObjectRef nameplate_img, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(nameplate_img, "$nameplate_img");
        FrameLayout frameLayout = (FrameLayout) this$0.f10935a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = tv.getPaddingLeft() + i3;
        layoutParams.topMargin = tv.getPaddingTop() + i4;
        imageView.setLayoutParams(layoutParams);
        frameLayout.addView(imageView);
        ImageLoader.a(this$0.f10935a.b, (String) nameplate_img.f42545a).g().g(-1).a(imageView);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        ColorDrawable colorDrawable = new ColorDrawable();
        int a2 = FitemMsgGift.b.a();
        final int i = this.f12577a;
        final int i2 = this.b;
        final FitemMsgNobleUpgrade fitemMsgNobleUpgrade = this.f12578c;
        final Context context = this.d;
        final TextView textView = this.e;
        final Ref.ObjectRef<String> objectRef = this.f;
        buildSpannableString.a(colorDrawable, 0, a2, i, i2, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgNobleUpgrade$addIconToNoble$1$VmXHRD8i9d1iELlgucXfaepKnF8
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i3, int i4) {
                FitemMsgNobleUpgrade$addIconToNoble$1.a(FitemMsgNobleUpgrade.this, context, i, i2, textView, objectRef, i3, i4);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
