package com.blued.android.module.live_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.module.live_china.model.LiveMedalData;
import com.blued.android.module.live_china.model.LiveMedalExtraData;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.ui.mvp.presenter.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMedalWallPresenter.class */
public final class LiveMedalWallPresenter extends MvpPresenter {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14040a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMedalWallPresenter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.blued.android.module.ui.mvp.presenter.MvpPresenter
    public void a(IFetchDataListener fetchDataListener) {
        Intrinsics.e(fetchDataListener, "fetchDataListener");
    }

    public final void a(String uid, final IRequestHost iRequestHost) {
        Intrinsics.e(uid, "uid");
        LiveRoomHttpUtils.k(uid, new BluedUIHttpResponse<BluedEntity<LiveMedalData, LiveMedalExtraData>>() { // from class: com.blued.android.module.live_china.presenter.LiveMedalWallPresenter$getUserBadger$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IRequestHost.this);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveMedalData, LiveMedalExtraData> bluedEntity) {
                LiveMedalData liveMedalData;
                if (bluedEntity == null) {
                    return;
                }
                if (bluedEntity.extra != null) {
                    LiveMedalExtraData liveMedalExtraData = bluedEntity.extra;
                    ArrayList<String> desc = liveMedalExtraData.getDesc();
                    if (!(desc == null || desc.isEmpty()) && (liveMedalData = bluedEntity.data.get(0)) != null) {
                        liveMedalData.setDesc(liveMedalExtraData.getDesc());
                    }
                }
                LiveEventBus.get("LIVE_MEDAL_DATA", LiveMedalData.class).post(bluedEntity.data.get(0));
            }
        }, n());
    }
}
