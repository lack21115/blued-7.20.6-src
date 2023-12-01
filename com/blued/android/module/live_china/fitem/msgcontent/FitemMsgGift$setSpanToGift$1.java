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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGift$setSpanToGift$1.class */
public final class FitemMsgGift$setSpanToGift$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ FitemMsgGift a;
    final /* synthetic */ Context b;
    final /* synthetic */ LiveGiftModel c;
    final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGift$setSpanToGift$1(FitemMsgGift fitemMsgGift, Context context, LiveGiftModel liveGiftModel, TextView textView) {
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
        String str = giftModel.images_static;
        Intrinsics.c(str, "giftModel.images_static");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, str);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        int i;
        int i2;
        int i3;
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a(this.a.k() + ' ' + this.b.getResources().getString(R.string.Live_SendPresent_send) + ' ' + ((Object) this.c.name) + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToGift$1.1
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
        buildSpannableString.a(new ColorDrawable(), 0, 0, c, b, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGift$setSpanToGift$1$emMi843hXt36QtSFHkFPoRnHq_Y
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i4, int i5) {
                FitemMsgGift$setSpanToGift$1.a(FitemMsgGift.this, context, textView, liveGiftModel, i4, i5);
            }
        });
        if (this.c.isReward) {
            buildSpannableString.a("（来自求开播）", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToGift$1.3
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffd452);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
        i = this.a.d;
        if (i <= 0) {
            this.a.d = this.c.getDisplayCount();
        }
        i2 = this.a.d;
        if (i2 > 1) {
            i3 = this.a.d;
            buildSpannableString.a(Intrinsics.a(" X", (Object) Integer.valueOf(i3)), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToGift$1.4
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.biao_live_msg_name_8);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
        if (this.c.is_help_wish_list) {
            buildSpannableString.a("，帮助主播实现心愿", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToGift$1.5
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.white);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
