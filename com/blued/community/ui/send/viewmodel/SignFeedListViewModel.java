package com.blued.community.ui.send.viewmodel;

import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.model.FeedBubbleListExtra;
import com.blued.community.ui.feed.model.FeedBubbleListGuideExtra;
import com.blued.community.utils.CityHelper;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/viewmodel/SignFeedListViewModel.class */
public final class SignFeedListViewModel extends BaseListViewModel<BluedIngSelfFeed> {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f20089a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f20090c;
    private boolean d = true;
    private FeedBubbleListGuideExtra e;
    private FeedBubbleListGuideExtra f;

    public final void a(Bundle bundle) {
        this.f20089a = bundle;
        if (bundle == null) {
            return;
        }
        a(bundle.getString("feed_ids", "").toString());
        b(bundle.getString("bubble_state", "").toString());
    }

    public final void a(FeedBubbleListGuideExtra feedBubbleListGuideExtra) {
        this.e = feedBubbleListGuideExtra;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final boolean a() {
        return this.d;
    }

    public final FeedBubbleListGuideExtra b() {
        return this.e;
    }

    public final void b(FeedBubbleListGuideExtra feedBubbleListGuideExtra) {
        this.f = feedBubbleListGuideExtra;
    }

    public final void b(String str) {
        this.f20090c = str;
    }

    public final FeedBubbleListGuideExtra c() {
        return this.f;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, FeedBubbleListExtra>>() { // from class: com.blued.community.ui.send.viewmodel.SignFeedListViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    SignFeedListViewModel.this.loadListFailed();
                }
                SignFeedListViewModel.this.a("");
                SignFeedListViewModel.this.b("");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, FeedBubbleListExtra> bluedEntity) {
                FeedBubbleListExtra feedBubbleListExtra;
                if (bluedEntity != null) {
                    SignFeedListViewModel.this.loadListSucceed(bluedEntity.data, bluedEntity.hasMore());
                }
                if (bluedEntity == null || (feedBubbleListExtra = bluedEntity.extra) == null) {
                    return;
                }
                SignFeedListViewModel signFeedListViewModel = SignFeedListViewModel.this;
                boolean z = true;
                if (feedBubbleListExtra.is_today_sent() != 1) {
                    z = false;
                }
                signFeedListViewModel.a(z);
                signFeedListViewModel.a(feedBubbleListExtra.getTick_state_popup());
                signFeedListViewModel.b(feedBubbleListExtra.getTick_state_release());
            }
        }, getMPage(), "list", CityHelper.a().c(), CityHelper.a().e(), this.b, this.f20090c, (IRequestHost) null);
    }
}
