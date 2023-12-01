package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.model.LiveEmojiModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgText$setSpanToText$1.class */
public final class FitemMsgText$setSpanToText$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ FitemMsgText a;
    final /* synthetic */ Context b;
    final /* synthetic */ TextView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgText$setSpanToText$1(FitemMsgText fitemMsgText, Context context, TextView textView) {
        super(1);
        this.a = fitemMsgText;
        this.b = context;
        this.c = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgText this$0, Context context, int i, int i2, TextView tv, LiveEmojiModel liveEmojiModel, int i3, int i4) {
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
        String emoji_url = liveEmojiModel.getEmoji_url();
        if (emoji_url == null || emoji_url.length() == 0) {
            return;
        }
        IRequestHost iRequestHost = this$0.a.b;
        String emoji_url2 = liveEmojiModel.getEmoji_url();
        Intrinsics.a((Object) emoji_url2);
        ImageLoader.a(iRequestHost, emoji_url2).a(imageView);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a(Intrinsics.a(this.a.k(), (Object) "："), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText$setSpanToText$1.1
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.biao_live_msg_name_3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.a;
            }
        });
        final LiveEmojiModel t = this.a.t();
        if (t == null) {
            String str = this.a.e().msgContent;
            Intrinsics.c(str, "msg.msgContent");
            DslSpannableStringBuilder.DefaultImpls.a(buildSpannableString, str, null, 2, null);
            return;
        }
        final int g = (int) ((this.a.g() * t.getEmoji_w()) / t.getEmoji_h());
        final int g2 = this.a.g();
        final FitemMsgText fitemMsgText = this.a;
        final Context context = this.b;
        final TextView textView = this.c;
        buildSpannableString.a(new ColorDrawable(), 0, 0, g, g2, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgText$setSpanToText$1$oc4zNmjMFKLGaC6VvfjlE4pRrcw
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i, int i2) {
                FitemMsgText$setSpanToText$1.a(FitemMsgText.this, context, g, g2, textView, t, i, i2);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
