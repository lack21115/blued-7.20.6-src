package com.soft.blued.ui.share.auto;

import android.content.Context;
import com.app.share.auto.IShareService;
import com.app.share.model.ShareEntity;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.HelloHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.share.ShareToPlatform;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.utils.ShareCoreUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share/auto/ShareServiceConfigImpl.class */
public class ShareServiceConfigImpl implements IShareService {
    @Override // com.app.share.auto.IShareService
    public String a() {
        return "SHARE_MAIN";
    }

    @Override // com.app.share.auto.IShareService
    public void a(long j, String[] strArr, String[] strArr2, String str) {
        LiveMsgSendManager.a().a(j, strArr, strArr2, str);
    }

    @Override // com.app.share.auto.IShareService
    public void a(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener, ShareEntity shareEntity) {
        new ShareToPlatform(context, null, null, shareOptionsItemClickListener).a(shareEntity);
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareEntity shareEntity, int i, String str) {
        InstantLog.a(ShareToPlatform.d(shareEntity), i, str, ShareToPlatform.e(shareEntity));
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareEntity shareEntity, String str, int i) {
        BluedIngSelfFeed c2 = ShareToPlatform.c(shareEntity);
        FeedProtos.ShareChannel shareChannel = FeedProtos.ShareChannel.UNKNOWN_SHARE_CHANNEL;
        switch (i) {
            case 2131887268:
                shareChannel = FeedProtos.ShareChannel.SHARE_FEED;
                break;
            case 2131891709:
                shareChannel = FeedProtos.ShareChannel.SHARE_FRIEND;
                break;
            case 2131892070:
                shareChannel = FeedProtos.ShareChannel.SHARE_QQ;
                break;
            case 2131892078:
                shareChannel = FeedProtos.ShareChannel.SHARE_WEIBO;
                break;
            case 2131892085:
                shareChannel = FeedProtos.ShareChannel.SHARE_WECHAT;
                break;
            case 2131892088:
                shareChannel = FeedProtos.ShareChannel.SHARE_FRIEND_CLUB;
                break;
        }
        EventTrackFeed.a(FeedProtos.Event.SHARE_TO_CLICK, shareChannel, EventTrackFeed.a(shareEntity), str, c2);
    }

    @Override // com.app.share.auto.IShareService
    public void a(FeedProtos.Event event, FeedProtos.ShareChannel shareChannel, String str, String str2, String str3, String str4, String str5, FeedProtos.SourcePage sourcePage, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, boolean z4, FeedProtos.FeedType feedType) {
        EventTrackFeed.a(event, shareChannel, str, str2, str3, str4, str5, sourcePage, str6, z, str7, z2, z3, str8, z4, (BluedIngSelfFeed) null, feedType);
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareToMsgEntity shareToMsgEntity, long j, short s, String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
        ChatHelperV4.a().a(shareToMsgEntity, j, s, str, str2, i, i2, i3, i4, i5, str3);
    }

    @Override // com.app.share.auto.IShareService
    public void b() {
        HelloHttpUtils.a();
    }

    @Override // com.app.share.auto.IShareService
    public void b(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener, ShareEntity shareEntity) {
        new ShareToPlatform(context, shareBackLister, popWindowSetting, shareOptionsItemClickListener).b(shareEntity);
    }
}
