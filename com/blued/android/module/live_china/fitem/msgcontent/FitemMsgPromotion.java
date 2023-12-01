package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgPromotion.class */
public final class FitemMsgPromotion extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgPromotion(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgPromotion this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        Object obj = this$0.e().msgMapExtra.get("link");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        liveRoomFunctionItemModel.setLink((String) obj);
        Object obj2 = this$0.e().msgMapExtra.get("link_type");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        liveRoomFunctionItemModel.setLink_type((int) ((Long) obj2).longValue());
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_promotion;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        if (e().msgMapExtra == null) {
            e().msgMapExtra = new HashMap();
        }
        if (!e().msgMapExtra.containsKey("live_chat_frame_model")) {
            LiveBubbleBgModel liveBubbleBgModel = new LiveBubbleBgModel("", "", 1, CollectionsKt.d("#9923E166", "#9923E166"), CollectionsKt.d("#BBA9FF", "#D5C8FF"));
            Map<String, Object> map = e().msgMapExtra;
            Intrinsics.c(map, "msg.msgMapExtra");
            map.put("live_chat_frame_model", liveBubbleBgModel);
        }
        super.a(context, vh, list, i);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView != null) {
            textView.setText(e().msgContent);
        }
        if (e().msgMapExtra.containsKey("link_type") && !Intrinsics.a(e().msgMapExtra.get("link_type"), (Object) 0L)) {
            vh.d(R.id.iv_arrows);
            TextView textView2 = (TextView) vh.a(R.id.live_msg_content_text);
            if (textView2 != null) {
                textView2.setClickable(false);
            }
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgPromotion$rm1HS7prNdAkd4TDUDyHzpzQDM4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemMsgPromotion.a(FitemMsgPromotion.this, view);
                }
            });
            return;
        }
        vh.c(R.id.iv_arrows);
        TextView textView3 = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView3 != null) {
            textView3.setClickable(false);
        }
        View view = vh.itemView;
        if (view == null) {
            return;
        }
        view.setClickable(false);
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
