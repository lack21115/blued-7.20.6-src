package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgRemind.class */
public final class FitemMsgRemind extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgRemind(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgRemind this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        short s = this$0.e().msgType;
        if (s == 103) {
            this$0.g();
        } else if (s == 104) {
            this$0.h();
        } else if (s != 224) {
        } else {
            this$0.q();
        }
    }

    private final boolean f() {
        int i;
        BaseViewHolder baseViewHolder = this.a;
        int i2 = R.id.iv_icon;
        short s = e().msgType;
        if (s == 103) {
            i = R.drawable.live_msg_content_attention;
        } else if (s == 104) {
            i = R.drawable.live_msg_content_chat;
        } else if (s != 224) {
            return false;
        } else {
            i = R.drawable.live_msg_content_pk;
        }
        baseViewHolder.c(i2, i);
        return true;
    }

    private final void g() {
        if (e().liveChatListFollowed) {
            this.a.itemView.setEnabled(false);
            return;
        }
        this.a.itemView.setEnabled(false);
        LiveSetDataObserver.a().l();
        InstantLog.a("live_follow_guide_click");
        LiveEventBus.get("live_msg_daily_task_complete").post(103);
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_GUIDE_CLICK, String.valueOf(LiveRoomManager.a().d()), LiveRoomManager.a().g());
            EventTrackLive.a(LiveProtos.Event.LIVE_MSG_GUIDE_FOLLOW_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
    }

    private final void h() {
        LiveSetDataObserver.a().j();
        if (Intrinsics.a((Object) e().msgContent, (Object) AppInfo.d().getString(R.string.live_say_hello))) {
            EventTrackLive.a(LiveProtos.Event.LIVE_SUPPORT_ANCHOR_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        } else {
            InstantLog.a("live_chat_guide_click");
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_MSG_GUIDE_CHAT_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    private final void q() {
        BaseFragment baseFragment = (BaseFragment) this.a.a.a("BaseFragment", (String) null);
        if (baseFragment == null) {
            return;
        }
        if (baseFragment instanceof RecordingOnliveFragment) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            ((RecordingOnliveFragment) baseFragment).d(LiveRoomInfo.a().G(), 0);
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveRefreshUIObserver.a().b(LiveRoomInfo.a().G(), 0);
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_remind;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        vh.a(R.id.live_msg_content_text, (CharSequence) e().msgContent).b(R.id.iv_icon, f()).a(R.id.live_msg_content_text, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgRemind$-RwLpgGdVFxDNf-z9mnPH-RDi6Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgRemind.a(FitemMsgRemind.this, view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
