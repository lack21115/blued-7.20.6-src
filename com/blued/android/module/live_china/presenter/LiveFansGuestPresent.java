package com.blued.android.module.live_china.presenter;

import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveFansGuestPresent.class */
public class LiveFansGuestPresent extends MvpPresenter {
    public void a(FragmentManager fragmentManager, long j, short s, String str, LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null) {
            Logger.a("ddrb", "LiveGiftModel is null ");
        } else {
            LiveGiftPayTools.a().a(h(), fragmentManager, s, j, 1, g(), liveGiftModel, str, "", 1, new LiveGiftPayTools.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.presenter.LiveFansGuestPresent.3
                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a() {
                    LiveRefreshUIObserver.a().b(true);
                }

                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a(final LiveGiftModel liveGiftModel2, final LiveGiftModel liveGiftModel3, List<LiveGiftModel> list) {
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.presenter.LiveFansGuestPresent.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.a("ddrb", "onGiftStatus ----- ");
                            KeyboardUtils.a(LiveFansGuestPresent.this.h());
                            liveGiftModel2.sendGiftStatus = liveGiftModel3.sendGiftStatus;
                            if (liveGiftModel3.sendGiftStatus == 3) {
                                LiveFansGuestPresent.this.a("LIVE_FANS_ADDED", (String) liveGiftModel3);
                                Logger.a("ddrb", "onGiftStatus ===== ");
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(String str, long j) {
        LiveRoomHttpUtils.b(str, j + "", new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(null) { // from class: com.blued.android.module.live_china.presenter.LiveFansGuestPresent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansInfoModel> bluedEntityA) {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    LiveRoomManager.a().a(bluedEntityA.data.get(0));
                    LiveFansGuestPresent.this.a("LIVE_FANS_INFO", (String) bluedEntityA.data.get(0));
                }
                LiveFansGuestPresent.this.b("LIVE_FANS_INFO", true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                AppMethods.a((CharSequence) str2);
                LiveFansGuestPresent.this.b("LIVE_FANS_INFO", false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveFansGuestPresent.this.d_("LIVE_FANS_INFO");
            }
        }, (IRequestHost) null);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntityA<LiveGiftModel>>(null) { // from class: com.blued.android.module.live_china.presenter.LiveFansGuestPresent.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveFansGuestPresent.this.a("LIVE_FANS_TICKET", (String) bluedEntityA.data.get(0));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, (IRequestHost) null);
    }
}
