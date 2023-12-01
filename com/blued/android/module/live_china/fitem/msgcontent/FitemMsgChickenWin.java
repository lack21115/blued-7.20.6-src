package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.view.View;
import com.alipay.sdk.cons.c;
import com.alipay.sdk.util.l;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgChickenWin.class */
public final class FitemMsgChickenWin extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgChickenWin(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void a(String str) {
        this.a.a(R.id.live_msg_content_text, LiveUtils.a((CharSequence) new SpannableString(str), "#FFD228", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef linkUrl, Ref.BooleanRef linkHalfOpen, BaseViewHolder vh, View view) {
        Intrinsics.e(linkUrl, "$linkUrl");
        Intrinsics.e(linkHalfOpen, "$linkHalfOpen");
        Intrinsics.e(vh, "$vh");
        String str = (String) linkUrl.a;
        if (!linkHalfOpen.a) {
            LiveSetDataObserver.a().f((String) linkUrl.a);
            return;
        }
        Object a = vh.a.a("isHost", (String) false);
        Intrinsics.c(a, "vh.adapter.getVar(\"isHost\", false)");
        if (((Boolean) a).booleanValue()) {
            LiveSetDataObserver.a().b((String) linkUrl.a, 0);
        } else {
            LiveRefreshUIObserver.a().b((String) linkUrl.a, 0);
        }
    }

    private final void f() {
        int i;
        String k = k();
        Object obj = e().msgMapExtra.get(l.c);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) obj).intValue();
        int i2 = 3;
        if (intValue == 1) {
            i = R.string.live_chicken_win_msg;
        } else if (intValue == 2) {
            i = R.string.live_chicken_lose_msg;
            i2 = 5;
        } else if (intValue == 3) {
            i = R.string.live_chicken_tie_msg;
            i2 = 0;
        } else if (intValue != 4) {
            i = -1;
            i2 = -1;
        } else {
            i = R.string.live_chicken_all_win_msg;
        }
        if (i == -1) {
            this.a.a(R.id.live_msg_content_text, (CharSequence) "");
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = AppInfo.d().getResources().getString(i);
        Intrinsics.c(string, "getAppContext().resources.getString(strId)");
        String format = String.format(string, Arrays.copyOf(new Object[]{k}, 1));
        Intrinsics.c(format, "format(format, *args)");
        e().msgContent = format;
        e().msgTimestamp = System.currentTimeMillis();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgChickenWin$setLiveChickenWinToResult$1
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(AppInfo.d().getResources().getColor(R.color.syc_dark_FFD228));
                ds.setUnderlineText(false);
                ds.clearShadowLayer();
            }
        }, i2, k.length() + i2, 33);
        this.a.a(R.id.live_msg_content_text, spannableStringBuilder);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_chicken_win;
    }

    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.lang.String] */
    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        if (e().msgMapExtra == null) {
            vh.a(R.id.live_msg_content_text, "").a(R.id.live_msg_content_text, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgChickenWin$D_5eq2ohkGCpHuJS_zs545mJYIE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemMsgChickenWin.a(view);
                }
            });
            return;
        }
        Object obj = e().msgMapExtra.get(c.b);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            f();
        } else {
            a(str);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (e().msgMapExtra.get("link_url") != null && (e().msgMapExtra.get("link_url") instanceof String)) {
            Object obj2 = e().msgMapExtra.get("link_url");
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            objectRef.a = (String) obj2;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (e().msgMapExtra.get("link_half_open") != null && (e().msgMapExtra.get("link_half_open") instanceof Boolean)) {
            Object obj3 = e().msgMapExtra.get("link_half_open");
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            booleanRef.a = ((Boolean) obj3).booleanValue();
        }
        vh.a(R.id.live_msg_content_text, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgChickenWin$WQh5-9u8lGxdb0fYsmBUDZwlHro
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgChickenWin.a(Ref.ObjectRef.this, booleanRef, vh, view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
