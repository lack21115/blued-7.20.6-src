package com.blued.android.module.live_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveUserFeedPhotoExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveShowPhotosPresenter.class */
public class LiveShowPhotosPresenter extends MvpPresenter {
    private int h = 1;
    private int i = 1;
    private int j = 0;
    private boolean k = false;
    private boolean l = false;
    private List<String> m;
    private List<String> n;

    static /* synthetic */ int b(LiveShowPhotosPresenter liveShowPhotosPresenter) {
        int i = liveShowPhotosPresenter.h;
        liveShowPhotosPresenter.h = i + 1;
        return i;
    }

    static /* synthetic */ int e(LiveShowPhotosPresenter liveShowPhotosPresenter) {
        int i = liveShowPhotosPresenter.i;
        liveShowPhotosPresenter.i = i + 1;
        return i;
    }

    public void a(int i) {
        this.j = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.add(fragmentActivity.getResources().getString(R.string.live_album));
        this.m.add(fragmentActivity.getResources().getString(R.string.live_posts));
        this.n = new ArrayList();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        int i = this.j;
        if (i == 0) {
            this.h = 1;
            c(iFetchDataListener);
        } else if (i != 1) {
        } else {
            this.i = 1;
            this.n.clear();
            d(iFetchDataListener);
        }
    }

    public void b(int i) {
        a(i);
        int i2 = this.j;
        if (i2 == 0) {
            e();
        } else if (i2 != 1) {
        } else {
            if (this.n.isEmpty()) {
                e();
            } else {
                a("changed_folder_name", (String) this.n, false);
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        int i = this.j;
        if (i == 0) {
            c(iFetchDataListener);
        } else if (i != 1) {
        } else {
            d(iFetchDataListener);
        }
    }

    public void c(final IFetchDataListener iFetchDataListener) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<String>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveShowPhotosPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    LiveShowPhotosPresenter.this.k = false;
                    return;
                }
                iFetchDataListener.a("album_data_list", bluedEntityA.data);
                LiveShowPhotosPresenter.this.k = bluedEntityA.hasMore();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(LiveShowPhotosPresenter.this.k);
                }
                if (LiveShowPhotosPresenter.this.k) {
                    LiveShowPhotosPresenter.b(LiveShowPhotosPresenter.this);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveShowPhotosPresenter.this.k = false;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                iFetchDataListener.a(z);
            }
        }, this.h, g());
    }

    public void d(final IFetchDataListener iFetchDataListener) {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<String, LiveUserFeedPhotoExtra>>(g()) { // from class: com.blued.android.module.live_china.presenter.LiveShowPhotosPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveShowPhotosPresenter.this.l = false;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                iFetchDataListener.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<String, LiveUserFeedPhotoExtra> bluedEntity) {
                boolean z = false;
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.isEmpty()) {
                    LiveShowPhotosPresenter.this.l = false;
                    return;
                }
                LiveShowPhotosPresenter.this.n.addAll(bluedEntity.data);
                iFetchDataListener.a("feed_data_list", bluedEntity.data);
                if (bluedEntity.extra == null) {
                    LiveShowPhotosPresenter.this.l = false;
                } else {
                    LiveShowPhotosPresenter liveShowPhotosPresenter = LiveShowPhotosPresenter.this;
                    if (bluedEntity.extra.has_more == 1) {
                        z = true;
                    }
                    liveShowPhotosPresenter.l = z;
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(LiveShowPhotosPresenter.this.l);
                }
                if (LiveShowPhotosPresenter.this.l) {
                    LiveShowPhotosPresenter.e(LiveShowPhotosPresenter.this);
                }
            }
        }, this.i, g());
    }

    public List<String> m() {
        return this.m;
    }
}
