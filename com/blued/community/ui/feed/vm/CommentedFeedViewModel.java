package com.blued.community.ui.feed.vm;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/vm/CommentedFeedViewModel.class */
public final class CommentedFeedViewModel extends BaseListViewModel<BluedIngSelfFeed> {
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        FeedHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.ui.feed.vm.CommentedFeedViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA == null) {
                    return;
                }
                CommentedFeedViewModel.this.loadListSucceed(bluedEntityA.data, bluedEntityA.hasMore());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                CommentedFeedViewModel.this.loadListFailed();
            }
        }, String.valueOf(getMPage()), String.valueOf(getMPageSize()), (IRequestHost) null);
    }
}
