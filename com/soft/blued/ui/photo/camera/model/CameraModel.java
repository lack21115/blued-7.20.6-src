package com.soft.blued.ui.photo.camera.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.login.face.AVConfig;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/model/CameraModel.class */
public class CameraModel implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f19339a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f19340c;

    public int a() {
        return this.f19339a;
    }

    public String a(Context context) {
        return a() == 1 ? AVConfig.a().b().face_title : a() == 2 ? context.getResources().getString(R.string.av_take_id_card) : "";
    }

    public void a(int i) {
        this.f19339a = i;
    }

    public void a(final BluedUIHttpResponse bluedUIHttpResponse, final IRequestHost iRequestHost) {
        if (TextUtils.isEmpty(g())) {
            if (bluedUIHttpResponse != null) {
                bluedUIHttpResponse.onFinish();
                return;
            }
            return;
        }
        BluedUIHttpResponse<BluedEntityA<BluedAlbum>> bluedUIHttpResponse2 = new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.photo.camera.model.CameraModel.1

            /* renamed from: a  reason: collision with root package name */
            boolean f19341a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    AppMethods.d(2131887272);
                    return;
                }
                QiniuUploadUtils.a(CameraModel.this.b(), (BluedAlbum) bluedEntityA.getSingleData(), new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.photo.camera.model.CameraModel.1.1
                    public void a(String str) {
                        AppMethods.d(2131887272);
                        if (bluedUIHttpResponse != null) {
                            bluedUIHttpResponse.onFinish();
                        }
                    }

                    public void a(String str, double d) {
                    }

                    public void a(String str, String str2) {
                        if (CameraModel.this.a() == 1) {
                            LoginRegisterHttpUtils.b(bluedUIHttpResponse, iRequestHost, str);
                        } else if (CameraModel.this.a() == 2) {
                            LoginRegisterHttpUtils.a(bluedUIHttpResponse, iRequestHost, str);
                        }
                    }

                    public boolean a() {
                        return false;
                    }
                });
            }

            public boolean onUIFailure(int i, String str) {
                this.f19341a = true;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                BluedUIHttpResponse bluedUIHttpResponse3 = bluedUIHttpResponse;
                if (bluedUIHttpResponse3 != null) {
                    bluedUIHttpResponse3.onFinish();
                }
            }
        };
        if (a() == 1) {
            LoginRegisterHttpUtils.a(bluedUIHttpResponse2, iRequestHost);
        } else if (a() == 2) {
            LoginRegisterHttpUtils.b(bluedUIHttpResponse2, iRequestHost);
        }
    }

    public void a(CameraModel cameraModel) {
        if (cameraModel != null) {
            a(cameraModel.a());
            a(cameraModel.b());
            b(cameraModel.c());
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public String b(Context context) {
        return a() == 1 ? AVConfig.a().b().face_tips : a() == 2 ? context.getResources().getString(R.string.av_take_idcard_hint) : "";
    }

    public void b(int i) {
        this.f19340c = i;
    }

    public int c() {
        return this.f19340c;
    }

    public String c(Context context) {
        return context.getResources().getString(2131886377);
    }

    public int d() {
        int i = 1;
        if (a() != 1) {
            a();
            i = 0;
        }
        b(i);
        return i;
    }

    public int e() {
        if (a() == 1) {
            return R.drawable.camera_default_face_bg;
        }
        if (a() == 2) {
            return R.drawable.cover_id_card;
        }
        return 0;
    }

    public int f() {
        if (a() == 1) {
            return R.string.av_identify_face;
        }
        if (a() == 2) {
            return R.string.av_identify_idcard;
        }
        return 0;
    }

    public String g() {
        if (a() == 1) {
            return "/blued/faceplus/face";
        }
        if (a() == 2) {
            return "/blued/faceplus/ocidcard";
        }
        return null;
    }
}
