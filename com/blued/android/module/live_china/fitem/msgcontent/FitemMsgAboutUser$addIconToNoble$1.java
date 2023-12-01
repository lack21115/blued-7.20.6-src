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
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgAboutUser$addIconToNoble$1.class */
public final class FitemMsgAboutUser$addIconToNoble$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FitemMsgAboutUser f12550a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f12551c;
    final /* synthetic */ Context d;
    final /* synthetic */ TextView e;
    final /* synthetic */ LiveNobleModel f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgAboutUser$addIconToNoble$1(FitemMsgAboutUser fitemMsgAboutUser, int i, int i2, Context context, TextView textView, LiveNobleModel liveNobleModel) {
        super(1);
        this.f12550a = fitemMsgAboutUser;
        this.b = i;
        this.f12551c = i2;
        this.d = context;
        this.e = textView;
        this.f = liveNobleModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgAboutUser this$0, Context context, int i, int i2, TextView tv, LiveNobleModel badgeModel, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(badgeModel, "$badgeModel");
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
        String nameplate_img = badgeModel.getNameplate_img();
        if (nameplate_img == null || nameplate_img.length() == 0) {
            return;
        }
        IRequestHost iRequestHost = this$0.f10935a.b;
        String nameplate_img2 = badgeModel.getNameplate_img();
        Intrinsics.a((Object) nameplate_img2);
        ImageLoader.a(iRequestHost, nameplate_img2).g().g(-1).a(imageView);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        int i;
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        ColorDrawable colorDrawable = new ColorDrawable();
        i = this.f12550a.g;
        final int i2 = this.b;
        final int i3 = this.f12551c;
        final FitemMsgAboutUser fitemMsgAboutUser = this.f12550a;
        final Context context = this.d;
        final TextView textView = this.e;
        final LiveNobleModel liveNobleModel = this.f;
        buildSpannableString.a(colorDrawable, 0, i, i2, i3, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgAboutUser$addIconToNoble$1$BZujAQ1NSStZhqkFttUFAoSdSy8
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i4, int i5) {
                FitemMsgAboutUser$addIconToNoble$1.a(FitemMsgAboutUser.this, context, i2, i3, textView, liveNobleModel, i4, i5);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
