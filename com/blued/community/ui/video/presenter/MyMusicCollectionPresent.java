package com.blued.community.ui.video.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.ui.video.model.VideoScanMusic;
import com.blued.community.utils.UserInfoUtils;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/MyMusicCollectionPresent.class */
public class MyMusicCollectionPresent extends MvpPresenter {
    private int h = 1;
    private int i = 30;
    private boolean j;
    private String k;

    static /* synthetic */ int c(MyMusicCollectionPresent myMusicCollectionPresent) {
        int i = myMusicCollectionPresent.h;
        myMusicCollectionPresent.h = i - 1;
        return i;
    }

    private void c(final IFetchDataListener iFetchDataListener) {
        if (this.h == 1) {
            this.j = true;
        }
        if (this.j) {
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<VideoScanMusic>>(g()) { // from class: com.blued.community.ui.video.presenter.MyMusicCollectionPresent.1
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<VideoScanMusic> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        MyMusicCollectionPresent.this.j = false;
                    } else {
                        iFetchDataListener.a("collection_list", bluedEntityA.data);
                        MyMusicCollectionPresent.this.j = bluedEntityA.hasMore();
                    }
                    iFetchDataListener.b(MyMusicCollectionPresent.this.j);
                }

                public void onUIFinish(boolean z) {
                    if (!z && MyMusicCollectionPresent.this.h != 1) {
                        MyMusicCollectionPresent.c(MyMusicCollectionPresent.this);
                    }
                    iFetchDataListener.a(z);
                }
            }, UserInfoUtils.c(), this.k, this.h, this.i, g());
        }
    }

    public void a(IFetchDataListener iFetchDataListener) {
        this.h = 1;
        c(iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        this.h++;
        c(iFetchDataListener);
    }

    public void d(String str) {
        FeedHttpUtils.f(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.video.presenter.MyMusicCollectionPresent.2
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, str, g());
    }

    public void e(String str) {
        this.k = str;
    }
}
