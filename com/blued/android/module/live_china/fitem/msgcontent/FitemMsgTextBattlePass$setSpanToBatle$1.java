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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextBattlePass$setSpanToBatle$1.class */
public final class FitemMsgTextBattlePass$setSpanToBatle$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FitemMsgTextBattlePass f12608a;
    final /* synthetic */ Integer b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f12609c;
    final /* synthetic */ Integer d;
    final /* synthetic */ String e;
    final /* synthetic */ Context f;
    final /* synthetic */ TextView g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextBattlePass$setSpanToBatle$1(FitemMsgTextBattlePass fitemMsgTextBattlePass, Integer num, String str, Integer num2, String str2, Context context, TextView textView) {
        super(1);
        this.f12608a = fitemMsgTextBattlePass;
        this.b = num;
        this.f12609c = str;
        this.d = num2;
        this.e = str2;
        this.f = context;
        this.g = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextBattlePass this$0, Context context, TextView tv, String goods_icon, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(goods_icon, "$goods_icon");
        FrameLayout frameLayout = (FrameLayout) this$0.f10935a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        FitemMsgGift.Companion companion = FitemMsgGift.b;
        IRequestHost iRequestHost = this$0.f10935a.b;
        Intrinsics.c(iRequestHost, "viewHolder.requestHost");
        companion.a(context, iRequestHost, tv, frameLayout, i, i2, goods_icon);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        String b;
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        buildSpannableString.a("恭喜 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1.1
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
        String k = this.f12608a.k();
        if (k != null) {
            buildSpannableString.a(k, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1$2$1
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.f42314a;
                }
            });
        }
        buildSpannableString.a(" 领取", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1.3
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
        Integer num = this.b;
        if (num != null) {
            FitemMsgTextBattlePass fitemMsgTextBattlePass = this.f12608a;
            int intValue = num.intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            b = fitemMsgTextBattlePass.b(intValue);
            sb.append(b);
            sb.append(' ');
            buildSpannableString.a(sb.toString(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1$4$1
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.f42314a;
                }
            });
        }
        buildSpannableString.a("战令奖励", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1.5
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
        Integer num2 = this.b;
        if (num2 != null) {
            String str = this.e;
            num2.intValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append((Object) str);
            sb2.append(' ');
            buildSpannableString.a(sb2.toString(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1$6$1
                public final void a(DslSpanBuilder addText) {
                    Intrinsics.e(addText, "$this$addText");
                    Context d = AppInfo.d();
                    Intrinsics.c(d, "getAppContext()");
                    addText.a(d, R.color.syc_dark_ffef5f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                    a(dslSpanBuilder);
                    return Unit.f42314a;
                }
            });
        }
        final String str2 = this.f12609c;
        if (str2 != null) {
            final FitemMsgTextBattlePass fitemMsgTextBattlePass2 = this.f12608a;
            final Context context = this.f;
            final TextView textView = this.g;
            buildSpannableString.a(new ColorDrawable(), 0, 0, FitemMsgGift.b.c(), FitemMsgGift.b.b(), new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextBattlePass$setSpanToBatle$1$FVTZRpupbdWG2_23tzWg8FYPaz8
                @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
                public final void drawFinish(int i, int i2) {
                    FitemMsgTextBattlePass$setSpanToBatle$1.a(FitemMsgTextBattlePass.this, context, textView, str2, i, i2);
                }
            });
        }
        Integer num3 = this.d;
        if (num3 == null || num3.intValue() <= 1) {
            return;
        }
        buildSpannableString.a(Intrinsics.a(" X", (Object) this.d), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass$setSpanToBatle$1.8
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

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
