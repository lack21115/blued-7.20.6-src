package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGift$setSpanToRandom$1.class */
final class FitemMsgGift$setSpanToRandom$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ FitemMsgGift a;
    final /* synthetic */ Context b;
    final /* synthetic */ LiveGiftModel c;
    final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGift$setSpanToRandom$1(FitemMsgGift fitemMsgGift, Context context, LiveGiftModel liveGiftModel, TextView textView) {
        super(1);
        this.a = fitemMsgGift;
        this.b = context;
        this.c = liveGiftModel;
        this.d = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgGift this$0, Context context, TextView tv, LiveGiftModel giftModel, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(giftModel, "$giftModel");
        FrameLayout frameLayout = (FrameLayout) this$0.a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        String str = giftModel.random_static;
        Intrinsics.c(str, "giftModel.random_static");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, str);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a(this.a.k() + ' ' + this.b.getResources().getString(R.string.Live_SendPresent_send) + ' ' + ((Object) this.c.name) + ' ' + this.b.getResources().getString(R.string.live_random_gift_msg_get) + ' ' + ((Object) this.c.random_name) + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToRandom$1.1
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.biao_live_msg_name_0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.a;
            }
        });
        int c = FitemMsgGift.b.c();
        int b = FitemMsgGift.b.b();
        final FitemMsgGift fitemMsgGift = this.a;
        final Context context = this.b;
        final TextView textView = this.d;
        final LiveGiftModel liveGiftModel = this.c;
        buildSpannableString.a(new ColorDrawable(), 0, 0, c, b, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGift$setSpanToRandom$1$GgvNrLbFhtiYD0oT6GRBclYIHD8
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i, int i2) {
                FitemMsgGift$setSpanToRandom$1.a(FitemMsgGift.this, context, textView, liveGiftModel, i, i2);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
