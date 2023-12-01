package com.blued.android.module.live_china.presenter;

import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IFollowView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFollowPresenter.class */
public class LiveFollowPresenter {
    private IFollowView a;
    private long b;
    private IRequestHost c;

    public LiveFollowPresenter(IFollowView iFollowView, IRequestHost iRequestHost, long j) {
        this.a = iFollowView;
        this.c = iRequestHost;
        this.b = j;
    }

    public void a(final String str) {
        LiveRoomInfo a = LiveRoomInfo.a();
        LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.presenter.LiveFollowPresenter.1
            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void Q_() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str2) {
                LiveFollowPresenter.this.a.a(str, str2);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str2) {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void d() {
            }
        };
        a.a((Context) null, iAddOrRemoveAttentionDone, str, "liveanchor_" + this.b, this.c);
    }
}
