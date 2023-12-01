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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextWishing$setSpanToWinning$1.class */
final class FitemMsgTextWishing$setSpanToWinning$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FitemMsgTextWishing f12665a;
    final /* synthetic */ LiveGiftModel b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f12666c;
    final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextWishing$setSpanToWinning$1(FitemMsgTextWishing fitemMsgTextWishing, LiveGiftModel liveGiftModel, Context context, TextView textView) {
        super(1);
        this.f12665a = fitemMsgTextWishing;
        this.b = liveGiftModel;
        this.f12666c = context;
        this.d = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextWishing this$0, Context context, TextView tv, LiveGiftModel giftModel, int i, int i2) {
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

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a("恭喜", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$setSpanToWinning$1.1
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
        buildSpannableString.a(' ' + this.f12665a.k() + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$setSpanToWinning$1.2
            public final void a(DslSpanBuilder addText) {
                Intrinsics.e(addText, "$this$addText");
                Context d = AppInfo.d();
                Intrinsics.c(d, "getAppContext()");
                addText.a(d, R.color.syc_dark_ffd452);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                a(dslSpanBuilder);
                return Unit.f42314a;
            }
        });
        buildSpannableString.a((char) 22312 + ((Object) this.b.source) + ((Object) this.b.sourceEvent) + "获得 " + ((Object) this.b.name) + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$setSpanToWinning$1.3
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
        final FitemMsgTextWishing fitemMsgTextWishing = this.f12665a;
        final Context context = this.f12666c;
        final TextView textView = this.d;
        final LiveGiftModel liveGiftModel = this.b;
        buildSpannableString.a(new ColorDrawable(), 0, 0, c2, b, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextWishing$setSpanToWinning$1$BZJ1seJ1ZZ017Znt8O6qyfJQkH4
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i, int i2) {
                FitemMsgTextWishing$setSpanToWinning$1.a(FitemMsgTextWishing.this, context, textView, liveGiftModel, i, i2);
            }
        });
        if (this.b.getDisplayCount() > 1) {
            buildSpannableString.a(Intrinsics.a(" X", (Object) Integer.valueOf(this.b.getDisplayCount())), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$setSpanToWinning$1.5
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffd452);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.f42314a;
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
