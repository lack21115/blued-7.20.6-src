package com.blued.android.module.live_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveOnlineUserEntity;
import com.blued.android.module.live_china.model.LiveOnlineUserEntityExtra;
import com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.ui.mvp.presenter.MvpPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveOnLineUserPresenter.class */
public final class LiveOnLineUserPresenter extends MvpPresenter {
    private final int a = 1;
    private final int b = 2;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveOnLineUserPresenter$OnLineUserDataSuccess.class */
    public interface OnLineUserDataSuccess {
        void a(BluedEntity<LiveOnlineUserEntity, LiveOnlineUserEntityExtra> bluedEntity);
    }

    public final int a() {
        return this.a;
    }

    public final void a(final IRequestHost requestActive, int i, int i2, final OnLineUserDataSuccess onLineUserDataSuccess) {
        Intrinsics.e(requestActive, "requestActive");
        Intrinsics.e(onLineUserDataSuccess, "onLineUserDataSuccess");
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveOnlineUserEntity, LiveOnlineUserEntityExtra>>(onLineUserDataSuccess) { // from class: com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter$getOnLineUserList$1
            final /* synthetic */ LiveOnLineUserPresenter.OnLineUserDataSuccess b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = onLineUserDataSuccess;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str) {
                return super.onUIFailure(i3, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveOnlineUserEntity, LiveOnlineUserEntityExtra> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                this.b.a(bluedEntity);
            }
        }, requestActive, LiveRoomManager.a().e(), i, i2);
    }

    @Override // com.blued.android.module.ui.mvp.presenter.MvpPresenter
    public void a(IFetchDataListener fetchDataListener) {
        Intrinsics.e(fetchDataListener, "fetchDataListener");
    }

    public final int b() {
        return this.b;
    }
}
