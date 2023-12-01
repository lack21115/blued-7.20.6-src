package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGuide.class */
public final class FitemMsgGuide extends FitemMsgBase {
    private final LiveChattingModel b;
    private String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGuide(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
        this.c = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgGuide this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        String str = this$0.c;
        switch (str.hashCode()) {
            case 49494:
                if (str.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                    LiveRefreshUIObserver.a().v();
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "recharge");
                    return;
                }
                return;
            case 49495:
                if (str.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                    LiveRefreshUIObserver.a().j();
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "present");
                    return;
                }
                return;
            case 49496:
                if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                    LiveRefreshUIObserver.a().n();
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_group");
                    return;
                }
                return;
            case 49497:
                if (str.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                    LiveRefreshUIObserver.a().m();
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_club");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_content_guide;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        if (e().msgMapExtra != null && e().msgMapExtra.containsKey("guideType")) {
            Object obj = e().msgMapExtra.get("guideType");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.c = (String) obj;
        }
        String str = this.c;
        if (str == null || str.length() == 0) {
            View view = vh.itemView;
            Intrinsics.c(view, "vh.itemView");
            BluedViewExKt.a(view);
            return;
        }
        vh.a(R.id.live_msg_content_text, (CharSequence) e().msgContent).c(R.id.live_msg_content_text, false).a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGuide$ChgqYLPSNGOgvhrAtU7b_-0xHuw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgGuide.a(FitemMsgGuide.this, view2);
            }
        });
        String str2 = this.c;
        switch (str2.hashCode()) {
            case 49494:
                if (str2.equals(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "recharge");
                    return;
                }
                return;
            case 49495:
                if (str2.equals(LiveGuideType.GUIDE_TYPE_BEG_GIFT)) {
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "present");
                    return;
                }
                return;
            case 49496:
                if (str2.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS_GROUP)) {
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_group");
                    EventTrackLive.a(LiveProtos.Event.LIVE_FANS_GROUP_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                    return;
                }
                return;
            case 49497:
                if (str2.equals(LiveGuideType.GUIDE_TYPE_JOIN_FANS)) {
                    EventTrackLive.o(LiveProtos.Event.LIVE_SCREEN_GUIDE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "fans_club");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }
}
