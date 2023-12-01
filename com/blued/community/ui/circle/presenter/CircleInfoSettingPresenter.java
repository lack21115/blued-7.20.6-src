package com.blued.community.ui.circle.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleInfoSettingPresenter.class */
public class CircleInfoSettingPresenter extends MvpPresenter {
    private MyCircleModel h;
    private String i;
    private String j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.community.ui.circle.presenter.CircleInfoSettingPresenter.3
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                CircleInfoSettingPresenter.this.b("upload_photo", false);
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                CircleInfoSettingPresenter.this.e(str2);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            MyCircleModel myCircleModel = (MyCircleModel) bundle.getSerializable("circle_data");
            this.h = myCircleModel;
            if (TextUtils.isEmpty(myCircleModel.description)) {
                this.h.description = AppUtils.a(R.string.circle_description_default);
            }
            a("circle_details", (String) this.h);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(String str) {
        this.j = str;
        if (TextUtils.isEmpty(this.i)) {
            e("");
        } else {
            m();
        }
    }

    public void e(final String str) {
        CircleHttpUtils.b(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleInfoSettingPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                CircleInfoSettingPresenter.this.b("upload_photo", true);
                if (z) {
                    AppMethods.d(R.string.circle_header_description_upload_success);
                    if (!TextUtils.isEmpty(str)) {
                        CircleInfoSettingPresenter.this.h.cover = str;
                    }
                    CircleInfoSettingPresenter.this.h.description = CircleInfoSettingPresenter.this.j;
                    LiveEventBus.get("circle_info_modify").post(CircleInfoSettingPresenter.this.h);
                    CircleInfoSettingPresenter.this.i();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, n(), str, this.j, g());
    }

    public void f(String str) {
        this.i = str;
    }

    public void m() {
        CommunityHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleInfoSettingPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String str) {
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            CircleInfoSettingPresenter.this.a(CircleInfoSettingPresenter.this.i, bluedEntityA.data.get(0));
                            return bluedEntityA;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bluedEntityA;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                CircleInfoSettingPresenter.this.b("upload_photo", false);
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                CircleInfoSettingPresenter.this.d_("upload_photo");
            }
        });
    }

    public String n() {
        return this.h.circle_id;
    }

    public String o() {
        return TextUtils.isEmpty(this.i) ? this.h.cover : this.i;
    }

    public String p() {
        return this.h.description;
    }

    public boolean q() {
        return this.k;
    }
}
