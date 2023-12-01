package com.blued.android.module.live_china.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveMusicListPresent.class */
public class LiveMusicListPresent extends MvpPresenter {
    private IFetchDataListener j;
    private String k;
    private int l;
    private String m;
    private boolean n;
    private int i = 1;
    BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveMusicSongModel>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveMusicListPresent.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<LiveMusicSongModel> bluedEntityA) {
            if (bluedEntityA == null) {
                return;
            }
            if (bluedEntityA.data != null && LiveMusicListPresent.this.j != null) {
                LiveMusicListPresent.this.j.a("MUSIC_SHEET_SONGS", bluedEntityA.data);
            }
            if (LiveMusicListPresent.this.j != null) {
                LiveMusicListPresent.this.j.b(bluedEntityA.hasMore());
            }
            if (LiveMusicListPresent.this.j != null) {
                LiveMusicListPresent.this.j.a(true);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            AppMethods.a((CharSequence) str);
            if (LiveMusicListPresent.this.i > 1) {
                LiveMusicListPresent.c(LiveMusicListPresent.this);
            }
            if (LiveMusicListPresent.this.j != null) {
                LiveMusicListPresent.this.j.a(false);
                return true;
            }
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            if (LiveMusicListPresent.this.j != null) {
                LiveMusicListPresent.this.j.a();
            }
        }
    };

    static /* synthetic */ int c(LiveMusicListPresent liveMusicListPresent) {
        int i = liveMusicListPresent.i;
        liveMusicListPresent.i = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        Log.i("==abcd", "onFetchData :  sheetId:" + this.k);
        this.i = 1;
        if (this.n && !TextUtils.isEmpty(this.m)) {
            d(iFetchDataListener);
        } else if (TextUtils.isEmpty(this.k)) {
        } else {
            c(iFetchDataListener);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.i++;
        if (this.n && !TextUtils.isEmpty(this.m)) {
            d(iFetchDataListener);
        } else if (TextUtils.isEmpty(this.k)) {
        } else {
            c(iFetchDataListener);
        }
    }

    public void c(IFetchDataListener iFetchDataListener) {
        this.j = iFetchDataListener;
        LiveRoomHttpUtils.a(this.k, this.l, this.i, this.h);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public boolean c() {
        return false;
    }

    public void d(IFetchDataListener iFetchDataListener) {
        this.j = iFetchDataListener;
        LiveRoomHttpUtils.b(this.m, this.i, this.h);
    }
}
