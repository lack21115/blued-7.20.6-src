package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextPlanet.class */
public final class FitemMsgTextPlanet extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextPlanet(LiveChattingModel msg) {
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
        LiveTextSpanExKt.a(textView, new FitemMsgTextPlanet$initText$1(this, obj5, obj6, num, context, textView));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextPlanet$j-ftgAexs3pusI7IjI11RZjF37I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgTextPlanet.a(FitemMsgTextPlanet.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextPlanet this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_planet;
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
            LiveBubbleBgModel liveBubbleBgModel = new LiveBubbleBgModel("", "", 1, CollectionsKt.d("#003FC1AF", "#0078FF7F"), CollectionsKt.d("#5CCBFF"));
            liveBubbleBgModel.chat_frame_icon_src = R.drawable.live_planet_msg_icon;
            Map<String, Object> map = e().msgMapExtra;
            Intrinsics.c(map, "msg.msgMapExtra");
            map.put("live_chat_frame_model", liveBubbleBgModel);
        }
        super.a(context, vh, list, i);
        this.f10935a.d(R.id.live_msg_background_shade_root).c(R.id.live_msg_background_shade, R.drawable.live_planet_msg_background);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        a(context, textView);
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
