package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.os.BatteryManager;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextBattlePass.class */
public final class FitemMsgTextBattlePass extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextBattlePass(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    private final void a(Context context, TextView textView) {
        Object obj;
        Object obj2;
        Object obj3;
        String obj4;
        String k = k();
        if (k == null || k.length() == 0) {
            return;
        }
        if (e().msgMapExtra == null) {
            View view = this.f10935a.itemView;
            Intrinsics.c(view, "viewHolder.itemView");
            BluedViewExKt.a(view);
            return;
        }
        Map<String, Object> map = e().msgMapExtra;
        Integer num = null;
        String obj5 = (map == null || (obj = map.get("goods_name")) == null) ? null : obj.toString();
        Map<String, Object> map2 = e().msgMapExtra;
        String obj6 = (map2 == null || (obj2 = map2.get("goods_icon")) == null) ? null : obj2.toString();
        Map<String, Object> map3 = e().msgMapExtra;
        if (map3 != null && (obj3 = map3.get("goods_count")) != null && (obj4 = obj3.toString()) != null) {
            num = Integer.valueOf(Integer.parseInt(obj4));
        }
        LiveTextSpanExKt.a(textView, new FitemMsgTextBattlePass$setSpanToBonus$1(this, obj5, obj6, num, context, textView));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextBattlePass$oVXeDQd-YV6eZsdEfTRiCExKl0c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgTextBattlePass.a(FitemMsgTextBattlePass.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextBattlePass this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(int i) {
        return i < 10 ? Intrinsics.a("LV.0", (Object) Integer.valueOf(i)) : Intrinsics.a("LV.", (Object) Integer.valueOf(i));
    }

    private final void b(Context context, TextView textView) {
        Object obj;
        String obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String obj6;
        String k = k();
        if (k == null || k.length() == 0) {
            return;
        }
        if (e().msgMapExtra == null) {
            View view = this.f10935a.itemView;
            Intrinsics.c(view, "viewHolder.itemView");
            BluedViewExKt.a(view);
            return;
        }
        Map<String, Object> map = e().msgMapExtra;
        Integer num = null;
        Integer valueOf = (map == null || (obj = map.get(BatteryManager.EXTRA_LEVEL)) == null || (obj2 = obj.toString()) == null) ? null : Integer.valueOf(Integer.parseInt(obj2));
        Map<String, Object> map2 = e().msgMapExtra;
        String obj7 = (map2 == null || (obj3 = map2.get("goods_name")) == null) ? null : obj3.toString();
        Map<String, Object> map3 = e().msgMapExtra;
        String obj8 = (map3 == null || (obj4 = map3.get("goods_icon")) == null) ? null : obj4.toString();
        Map<String, Object> map4 = e().msgMapExtra;
        if (map4 != null && (obj5 = map4.get("goods_count")) != null && (obj6 = obj5.toString()) != null) {
            num = Integer.valueOf(Integer.parseInt(obj6));
        }
        LiveTextSpanExKt.a(textView, new FitemMsgTextBattlePass$setSpanToBatle$1(this, valueOf, obj8, num, obj7, context, textView));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextBattlePass$P-LcKr4OVQJhkb5VnJKhT8iMVZY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgTextBattlePass.b(FitemMsgTextBattlePass.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemMsgTextBattlePass this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_battle_pass;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        boolean z;
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        a(false);
        super.a(context, vh, list, i);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        Map<String, Object> map = e().msgMapExtra;
        if (map == null) {
            z = false;
        } else {
            Object obj = map.get("bonus");
            if (obj == null) {
                z = false;
            } else {
                String obj2 = obj.toString();
                if (obj2 == null) {
                    z = false;
                } else {
                    z = false;
                    if (Integer.parseInt(obj2) == 1) {
                        z = true;
                    }
                }
            }
        }
        if (z) {
            a(context, textView);
        } else {
            b(context, textView);
        }
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
