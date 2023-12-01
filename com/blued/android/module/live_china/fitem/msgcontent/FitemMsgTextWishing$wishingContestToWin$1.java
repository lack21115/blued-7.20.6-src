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
import com.blued.android.module.live_china.model.LiveWishContestContentModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextWishing$wishingContestToWin$1.class */
final class FitemMsgTextWishing$wishingContestToWin$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ LiveWishContestContentModel a;
    final /* synthetic */ FitemMsgTextWishing b;
    final /* synthetic */ Context c;
    final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextWishing$wishingContestToWin$1(LiveWishContestContentModel liveWishContestContentModel, FitemMsgTextWishing fitemMsgTextWishing, Context context, TextView textView) {
        super(1);
        this.a = liveWishContestContentModel;
        this.b = fitemMsgTextWishing;
        this.c = context;
        this.d = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextWishing this$0, Context context, TextView tv, LiveWishContestContentModel msgModel, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(msgModel, "$msgModel");
        FrameLayout frameLayout = (FrameLayout) this$0.a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        String str = msgModel.giftImage;
        Intrinsics.c(str, "msgModel.giftImage");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, str);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a("星之许愿池：恭喜  ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToWin$1.1
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
        String name = LiveCloakingUtil.a(this.a.userName, this.a.isHide);
        Intrinsics.c(name, "name");
        buildSpannableString.a(name, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToWin$1.2
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
        int i = this.a.type;
        String str = i != 0 ? i != 1 ? "许愿争夺战" : "疯狂争夺战" : "许愿争夺战";
        buildSpannableString.a(" 夺取了本轮" + str + "的胜利，获得 " + ((Object) this.a.giftName) + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToWin$1.3
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
        final FitemMsgTextWishing fitemMsgTextWishing = this.b;
        final Context context = this.c;
        final TextView textView = this.d;
        final LiveWishContestContentModel liveWishContestContentModel = this.a;
        buildSpannableString.a(new ColorDrawable(), 0, 0, c, b, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextWishing$wishingContestToWin$1$4QSPkNfLGEayjdX8qM8gXxA_Xlw
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i2, int i3) {
                FitemMsgTextWishing$wishingContestToWin$1.a(FitemMsgTextWishing.this, context, textView, liveWishContestContentModel, i2, i3);
            }
        });
        buildSpannableString.a(Intrinsics.a(" X", (Object) Integer.valueOf(this.a.giftCount)), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToWin$1.5
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

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
