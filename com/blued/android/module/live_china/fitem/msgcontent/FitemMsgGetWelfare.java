package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGetWelfare.class */
public final class FitemMsgGetWelfare extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGetWelfare(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgGetWelfare this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        short s = this$0.e().msgType;
        if (s == -10001) {
            this$0.g();
        } else if (s != -10000) {
        } else {
            this$0.f();
        }
    }

    private final void f() {
        LiveRoomPreferences.G();
        LiveSetDataObserver.a().v();
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_TODAY_WELFARE_TOAST_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
    }

    private final void g() {
        LiveRoomPreferences.I();
        LiveSetDataObserver.a().v();
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_GLOW_STICK_TOAST_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_get_welfare;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        int i2 = R.id.live_msg_content_text;
        short s = e().msgType;
        vh.a(i2, s != -10001 ? s != -10000 ? R.string.live_gift_task_tip_1 : R.string.live_gift_task_tip_1 : R.string.live_gift_task_tip_2).a(R.id.live_msg_content_text, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGetWelfare$u62BUOlnp0CG1Mzg29xSBZ7MYy4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgGetWelfare.a(FitemMsgGetWelfare.this, view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
