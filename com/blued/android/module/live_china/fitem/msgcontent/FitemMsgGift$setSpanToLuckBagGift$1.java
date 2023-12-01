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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGift$setSpanToLuckBagGift$1.class */
final class FitemMsgGift$setSpanToLuckBagGift$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FitemMsgGift f12566a;
    final /* synthetic */ LiveGiftModel b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f12567c;
    final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGift$setSpanToLuckBagGift$1(FitemMsgGift fitemMsgGift, LiveGiftModel liveGiftModel, Context context, TextView textView) {
        super(1);
        this.f12566a = fitemMsgGift;
        this.b = liveGiftModel;
        this.f12567c = context;
        this.d = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgGift this$0, Context context, TextView tv, LiveGiftModel giftModel, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(giftModel, "$giftModel");
        FrameLayout frameLayout = (FrameLayout) this$0.f10935a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.f10935a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        String str = giftModel.images_static;
        Intrinsics.c(str, "giftModel.images_static");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemMsgGift this$0, Context context, TextView tv, LiveGiftModel giftModel, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(giftModel, "$giftModel");
        FrameLayout frameLayout = (FrameLayout) this$0.f10935a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.f10935a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        String str = giftModel.luck_bag_img;
        Intrinsics.c(str, "giftModel.luck_bag_img");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, str);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a(' ' + this.f12566a.k() + " 开启 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToLuckBagGift$1.1
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.biao_live_msg_name_0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.f42314a;
            }
        });
        int c2 = FitemMsgGift.b.c();
        int b = FitemMsgGift.b.b();
        final FitemMsgGift fitemMsgGift = this.f12566a;
        final Context context = this.f12567c;
        final TextView textView = this.d;
        final LiveGiftModel liveGiftModel = this.b;
        buildSpannableString.a(new ColorDrawable(), 0, 0, c2, b, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGift$setSpanToLuckBagGift$1$WxZh-PvJ7hM-F-CU9HazmaMNF5E
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i, int i2) {
                FitemMsgGift$setSpanToLuckBagGift$1.a(FitemMsgGift.this, context, textView, liveGiftModel, i, i2);
            }
        });
        buildSpannableString.a(" 获得了 " + ((Object) this.b.desc) + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToLuckBagGift$1.3
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.biao_live_msg_name_0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.f42314a;
            }
        });
        int c3 = FitemMsgGift.b.c();
        int b2 = FitemMsgGift.b.b();
        final FitemMsgGift fitemMsgGift2 = this.f12566a;
        final Context context2 = this.f12567c;
        final TextView textView2 = this.d;
        final LiveGiftModel liveGiftModel2 = this.b;
        buildSpannableString.a(new ColorDrawable(), 0, 0, c3, b2, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGift$setSpanToLuckBagGift$1$k5Xb8u1r9NbF9ucuLfUHhay5Hyc
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i, int i2) {
                FitemMsgGift$setSpanToLuckBagGift$1.b(FitemMsgGift.this, context2, textView2, liveGiftModel2, i, i2);
            }
        });
        buildSpannableString.a(" 送给主播", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToLuckBagGift$1.5
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.biao_live_msg_name_0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.f42314a;
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
