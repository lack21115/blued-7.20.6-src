package com.blued.android.module.live_china.presenter;

import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IFollowView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFollowPresenter.class */
public class LiveFollowPresenter {

    /* renamed from: a  reason: collision with root package name */
    private IFollowView f14019a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f14020c;

    public LiveFollowPresenter(IFollowView iFollowView, IRequestHost iRequestHost, long j) {
        this.f14019a = iFollowView;
        this.f14020c = iRequestHost;
        this.b = j;
    }

    public void a(final String str) {
        LiveRoomInfo a2 = LiveRoomInfo.a();
        LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.presenter.LiveFollowPresenter.1
            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void Q_() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str2) {
                LiveFollowPresenter.this.f14019a.a(str, str2);
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
        a2.a((Context) null, iAddOrRemoveAttentionDone, str, "liveanchor_" + this.b, this.f14020c);
    }
}
