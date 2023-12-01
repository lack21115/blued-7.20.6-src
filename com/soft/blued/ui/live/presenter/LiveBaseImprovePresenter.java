package com.soft.blued.ui.live.presenter;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.soft.blued.http.LiveHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/presenter/LiveBaseImprovePresenter.class */
public abstract class LiveBaseImprovePresenter extends MvpPresenter {
    public final int h = 0;
    public final int i = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum, final int i) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter.2
            public void a(String str2) {
                int i2 = i;
                if (i2 == 0) {
                    LiveBaseImprovePresenter.this.b("LIVE_CARD_FRONT_UPLOAD", true);
                } else if (i2 != 1) {
                } else {
                    LiveBaseImprovePresenter.this.b("LIVE_CARD_BACK_UPLOAD", true);
                }
            }

            public void a(String str2, double d) {
            }

            public void a(String str2, String str3) {
                Log.v("pk", "七牛上传成功：" + i);
                LiveBaseImprovePresenter.this.a(i, str2);
            }

            public boolean a() {
                return false;
            }
        });
    }

    public abstract void a(int i, String str);

    public void a(Context context, final String str, final int i) {
        LiveHttpUtils.a(context, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(g()) { // from class: com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveBaseImprovePresenter.this.a(str, (BluedAlbum) bluedEntityA.data.get(0), i);
                Log.v("pk", "获取token成功：" + i);
            }

            public boolean onUIFailure(int i2, String str2) {
                int i3 = i;
                if (i3 == 0) {
                    LiveBaseImprovePresenter.this.b("LIVE_CARD_FRONT_UPLOAD", true);
                } else if (i3 == 1) {
                    LiveBaseImprovePresenter.this.b("LIVE_CARD_BACK_UPLOAD", true);
                }
                AppMethods.a(str2);
                return true;
            }

            public void onUIFinish() {
            }

            public void onUIStart() {
            }
        }, g());
    }

    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }
}
