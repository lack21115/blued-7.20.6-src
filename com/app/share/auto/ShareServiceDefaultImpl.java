package com.app.share.auto;

import android.content.Context;
import com.app.share.model.ShareEntity;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.utils.ShareCoreUtils;

/* loaded from: source-8756600-dex2jar.jar:com/app/share/auto/ShareServiceDefaultImpl.class */
class ShareServiceDefaultImpl implements IShareService {
    @Override // com.app.share.auto.IShareService
    public String a() {
        return null;
    }

    @Override // com.app.share.auto.IShareService
    public void a(long j, String[] strArr, String[] strArr2, String str) {
    }

    @Override // com.app.share.auto.IShareService
    public void a(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener, ShareEntity shareEntity) {
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareEntity shareEntity, int i, String str) {
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareEntity shareEntity, String str, int i) {
    }

    @Override // com.app.share.auto.IShareService
    public void a(FeedProtos.Event event, FeedProtos.ShareChannel shareChannel, String str, String str2, String str3, String str4, String str5, FeedProtos.SourcePage sourcePage, String str6, boolean z, String str7, boolean z2, boolean z3, String str8, boolean z4, FeedProtos.FeedType feedType) {
    }

    @Override // com.app.share.auto.IShareService
    public void a(ShareToMsgEntity shareToMsgEntity, long j, short s, String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
    }

    @Override // com.app.share.auto.IShareService
    public void b() {
    }

    @Override // com.app.share.auto.IShareService
    public void b(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener, ShareEntity shareEntity) {
    }
}
