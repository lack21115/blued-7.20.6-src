package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMusicSheetModel;
import com.blued.android.module.live_china.model.LiveMusicSheetModelExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMusicPresent.class */
public class LiveMusicPresent extends MvpPresenter {
    private String h;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        m();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        LiveRoomHttpUtils.x(new BluedUIHttpResponse<BluedEntity<LiveMusicSheetModel, LiveMusicSheetModelExtra>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMusicPresent.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveMusicPresent.this.a("LIVE_MUSIC_SHEET", (String) new ArrayList());
                AppMethods.a((CharSequence) str);
                LiveMusicPresent.this.b("LIVE_MUSIC_SHEET", false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMusicPresent.this.d_("LIVE_MUSIC_SHEET");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveMusicSheetModel, LiveMusicSheetModelExtra> bluedEntity) {
                if (bluedEntity != null) {
                    if (bluedEntity.extra != null) {
                        LiveMusicPresent.this.h = bluedEntity.extra.collect_sheet_id;
                    }
                    LiveMusicPresent.this.a("LIVE_MUSIC_SHEET", (String) bluedEntity.data);
                } else {
                    LiveMusicPresent.this.a("LIVE_MUSIC_SHEET", (String) new ArrayList());
                }
                LiveMusicPresent.this.b("LIVE_MUSIC_SHEET", true);
            }
        });
    }
}
