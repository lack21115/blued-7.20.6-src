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
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextPlanet$initText$1.class */
final class FitemMsgTextPlanet$initText$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ FitemMsgTextPlanet a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ Integer d;
    final /* synthetic */ Context e;
    final /* synthetic */ TextView f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextPlanet$initText$1(FitemMsgTextPlanet fitemMsgTextPlanet, String str, String str2, Integer num, Context context, TextView textView) {
        super(1);
        this.a = fitemMsgTextPlanet;
        this.b = str;
        this.c = str2;
        this.d = num;
        this.e = context;
        this.f = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextPlanet this$0, Context context, TextView tv, String goods_icon, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(goods_icon, "$goods_icon");
        FrameLayout frameLayout = (FrameLayout) this$0.a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, goods_icon);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a("恭喜 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1.1
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
        String k = this.a.k();
        if (k != null) {
            buildSpannableString.a(k, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1$2$1
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
        buildSpannableString.a(" 派遣飞船成功，获得了 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1.3
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
        String str = this.b;
        if (str != null) {
            buildSpannableString.a(Intrinsics.a(str, (Object) " "), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1$4$1
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
        final String str2 = this.c;
        if (str2 != null) {
            final FitemMsgTextPlanet fitemMsgTextPlanet = this.a;
            final Context context = this.e;
            final TextView textView = this.f;
            buildSpannableString.a(new ColorDrawable(), 0, 0, FitemMsgGift.b.c(), FitemMsgGift.b.b(), new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextPlanet$initText$1$nhLSFrCBbCA0_g-NxhmZre1uxN8
                @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
                public final void drawFinish(int i, int i2) {
                    FitemMsgTextPlanet$initText$1.a(FitemMsgTextPlanet.this, context, textView, str2, i, i2);
                }
            });
        }
        Integer num = this.d;
        if (num != null && num.intValue() > 1) {
            buildSpannableString.a(Intrinsics.a(" X", (Object) this.d), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1.6
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.a;
                }
            });
        }
        String str3 = this.a.e().msgContent;
        boolean z = true;
        if (str3 != null) {
            z = str3.length() == 0;
        }
        if (z) {
            return;
        }
        buildSpannableString.a(Intrinsics.a(" ", (Object) this.a.e().msgContent), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet$initText$1.7
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
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
