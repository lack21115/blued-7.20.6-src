package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGuideMarketingCampaignNotice.class */
public final class FitemMsgGuideMarketingCampaignNotice extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGuideMarketingCampaignNotice(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef url, BaseViewHolder vh, View view) {
        Intrinsics.e(url, "$url");
        Intrinsics.e(vh, "$vh");
        CharSequence charSequence = (CharSequence) url.a;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        Object a = vh.a.a("isHost", (String) null);
        Intrinsics.c(a, "vh.adapter.getVar<Boolean?>(\"isHost\", null)");
        if (((Boolean) a).booleanValue()) {
            LiveSetDataObserver.a().b((String) url.a, 0);
        } else {
            LiveRefreshUIObserver.a().b((String) url.a, 0);
        }
        EventTrackLive.m(LiveProtos.Event.LIVE_SCREEN_ACTIVITY_NOTICE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) url.a);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_marketing_campaign_notice;
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.String] */
    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = "";
        Map<String, Object> map = e().msgMapExtra;
        if (!(map == null || map.isEmpty()) && e().msgMapExtra.containsKey("url") && (e().msgMapExtra.get("url") instanceof String)) {
            Object obj = e().msgMapExtra.get("url");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            objectRef.a = (String) obj;
        }
        int i2 = R.id.live_msg_content_arrow;
        CharSequence charSequence = (CharSequence) objectRef.a;
        vh.b(i2, true ^ (charSequence == null || charSequence.length() == 0)).a(R.id.live_msg_content_text, (CharSequence) e().msgContent).c(R.id.live_msg_content_text, false).a(R.id.live_msg_content_root, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGuideMarketingCampaignNotice$4uLW3RAT55wKwMctDbjAU0PkN3k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgGuideMarketingCampaignNotice.a(Ref.ObjectRef.this, vh, view);
            }
        });
        EventTrackLive.m(LiveProtos.Event.LIVE_SCREEN_ACTIVITY_NOTICE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) objectRef.a);
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
