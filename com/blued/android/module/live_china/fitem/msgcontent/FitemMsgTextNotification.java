package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.os.BatteryManager;
import android.view.View;
import android.widget.TextView;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextNotification.class */
public final class FitemMsgTextNotification extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextNotification(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    private final void a(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = Context.this.getString(R.string.live_on_being_manager);
                Intrinsics.c(string, "context.getString(R.string.live_on_being_manager)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.k()}, 1));
                Intrinsics.c(format, "format(format, *args)");
                buildSpannableString.a(format, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToManager$1.1
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextNotification this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    private final void b(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToCancelManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = Context.this.getString(R.string.live_removed_your_manager);
                Intrinsics.c(string, "context.getString(R.stri…ive_removed_your_manager)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.k()}, 1));
                Intrinsics.c(format, "format(format, *args)");
                buildSpannableString.a(format, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToCancelManager$1.1
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemMsgTextNotification this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(LiveRoomManager.a().f());
    }

    private final void c(final Context context, TextView textView) {
        Map mapValue = MsgPackHelper.getMapValue(e().msgMapExtra, "mute_profile");
        if (mapValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String?, kotlin.Any?>");
        }
        final String stringValue = MsgPackHelper.getStringValue(mapValue, "name");
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToMute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = Context.this.getString(R.string.live_forbade_to_speak);
                Intrinsics.c(string, "context.getString(R.string.live_forbade_to_speak)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.k(), stringValue}, 2));
                Intrinsics.c(format, "format(format, *args)");
                buildSpannableString.a(format, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToMute$1.1
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
        });
    }

    private final void d(final Context context, TextView textView) {
        Map mapValue = MsgPackHelper.getMapValue(e().msgMapExtra, "mute_profile");
        if (mapValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String?, kotlin.Any?>");
        }
        final String stringValue = MsgPackHelper.getStringValue(mapValue, "name");
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToCancelMute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = Context.this.getString(R.string.live_released_to_speak);
                Intrinsics.c(string, "context.getString(R.string.live_released_to_speak)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.k(), stringValue}, 2));
                Intrinsics.c(format, "format(format, *args)");
                buildSpannableString.a(format, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToCancelMute$1.1
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
        });
    }

    private final void e(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToKickOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a(Intrinsics.a(FitemMsgTextNotification.this.k(), (Object) " "), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToKickOut$1.1
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.f42314a;
                    }
                });
                String string = context.getResources().getString(R.string.live_kick_user);
                Intrinsics.c(string, "context.resources.getStr…(R.string.live_kick_user)");
                buildSpannableString.a(string, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToKickOut$1.2
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.syc_dark_d0d0d0);
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
        });
    }

    private final void f(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToUpgradeRich$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                String str;
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                String string = Context.this.getResources().getString(R.string.live_chat_congratulations);
                Intrinsics.c(string, "context.resources.getStr…ive_chat_congratulations)");
                DslSpannableStringBuilder.DefaultImpls.a(buildSpannableString, string, null, 2, null);
                final Context context2 = Context.this;
                buildSpannableString.a(' ' + this.k() + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToUpgradeRich$1.1
                    {
                        super(1);
                    }

                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        addText.a(Context.this, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.f42314a;
                    }
                });
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string2 = Context.this.getString(R.string.live_chat_upgrade);
                Intrinsics.c(string2, "context.getString(R.string.live_chat_upgrade)");
                switch (this.e().fromRichLevel) {
                    case 30:
                        str = "神壕1级";
                        break;
                    case 31:
                        str = "神壕2级";
                        break;
                    case 32:
                        str = "神壕3级";
                        break;
                    case 33:
                        str = "神壕4级";
                        break;
                    case 34:
                        str = "神壕5级";
                        break;
                    case 35:
                        str = "神壕6级";
                        break;
                    default:
                        str = String.valueOf(this.e().fromRichLevel);
                        break;
                }
                String format = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.c(format, "format(format, *args)");
                if (this.e().fromRichLevel == 35) {
                    format = "财富等级升为【神壕6级】，获赠1,588,888弯豆";
                }
                DslSpannableStringBuilder.DefaultImpls.a(buildSpannableString, format, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.f42314a;
            }
        });
        this.f10935a.a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextNotification$dkMooskDN_ngida_xH8NycJWXL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgTextNotification.a(FitemMsgTextNotification.this, view);
            }
        });
    }

    private final void g(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToUpgradeLive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                String str;
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                String string = Context.this.getResources().getString(R.string.live_chat_congratulations);
                Intrinsics.c(string, "context.resources.getStr…ive_chat_congratulations)");
                DslSpannableStringBuilder.DefaultImpls.a(buildSpannableString, string, null, 2, null);
                final Context context2 = Context.this;
                buildSpannableString.a(' ' + this.k() + ' ', new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification$setSpanToUpgradeLive$1.1
                    {
                        super(1);
                    }

                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        addText.a(Context.this, R.color.biao_live_msg_name_3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.f42314a;
                    }
                });
                try {
                    int intValue = MsgPackHelper.getIntValue(this.e().msgMapExtra, BatteryManager.EXTRA_LEVEL);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string2 = Context.this.getString(R.string.live_record_level_msg);
                    Intrinsics.c(string2, "context.getString(R.string.live_record_level_msg)");
                    str = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(intValue)}, 1));
                    Intrinsics.c(str, "format(format, *args)");
                } catch (Exception e) {
                    str = "主播等级升级！";
                }
                DslSpannableStringBuilder.DefaultImpls.a(buildSpannableString, str, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.f42314a;
            }
        });
        this.f10935a.a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextNotification$o_TMQ1ffIg3vh2tHGzFsOKJAR38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgTextNotification.b(FitemMsgTextNotification.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_notification;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        short s = e().msgType;
        if (s == 102) {
            f(context, textView);
        } else if (s == 155) {
            g(context, textView);
        } else if (s == 232) {
            e(context, textView);
        } else {
            switch (s) {
                case 106:
                    a(context, textView);
                    return;
                case 107:
                    b(context, textView);
                    return;
                case 108:
                    c(context, textView);
                    return;
                case 109:
                    d(context, textView);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
