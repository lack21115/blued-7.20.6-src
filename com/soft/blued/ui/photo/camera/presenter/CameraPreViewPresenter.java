package com.soft.blued.ui.photo.camera.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.contract.ICameraPreView;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/presenter/CameraPreViewPresenter.class */
public class CameraPreViewPresenter extends MediaBasePresent<ICameraPreView> {

    /* renamed from: a  reason: collision with root package name */
    private static String f33035a = CameraPreViewPresenter.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private CameraModel f33036c;
    private int d = 0;
    private AdultVerifyModel e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/presenter/CameraPreViewPresenter$AV_RESULT.class */
    public interface AV_RESULT {
    }

    public void a() {
        ICameraPreView n = n();
        if (this.f33036c == null || n == null) {
            return;
        }
        n.a(true);
        n.b();
        this.f33036c.a(new BluedUIHttpResponse<BluedEntity<AdultVerifyModel, BluedEntityBaseExtra>>() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter.1

            /* renamed from: a  reason: collision with root package name */
            String f33037a;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i != 4036712) {
                    CameraPreViewPresenter.this.d = 2;
                    return super.onUIFailure(i, str);
                }
                CameraPreViewPresenter.this.d = 3;
                this.f33037a = str;
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                ICameraPreView n2 = CameraPreViewPresenter.this.n();
                if (n2 != null) {
                    n2.a(false);
                }
                int i = CameraPreViewPresenter.this.d;
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    if (CameraPreViewPresenter.this.f33036c.a() == 1) {
                        CameraPreViewPresenter.this.n().c(this.f33037a);
                    }
                }
                if (n2 != null) {
                    n2.d();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                this.f33037a = "";
                CameraPreViewPresenter.this.d = 0;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<AdultVerifyModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                CameraPreViewPresenter.this.e = bluedEntity.getSingleData();
                CameraPreViewPresenter.this.d = 1;
            }
        }, n.a());
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Bundle bundle) {
        ICameraPreView n = n();
        if (n == null) {
            StvLogUtils.a(f33035a + "ICameraPreView == null!!!", new Object[0]);
            return;
        }
        Bundle arguments = n.getArguments();
        if (arguments == null) {
            n.getActivity().finish();
            return;
        }
        CameraModel cameraModel = (CameraModel) arguments.getSerializable("camera_model_key");
        this.f33036c = cameraModel;
        if (cameraModel == null) {
            n.getActivity().finish();
            return;
        }
        int e = cameraModel.e();
        if (e != 0) {
            n.b(CameraImageUtils.a(e));
        }
        int f = this.f33036c.f();
        if (f != 0) {
            n.a(f);
        }
        CameraContents.f28311a.execute(new Runnable() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                ICameraPreView n2 = CameraPreViewPresenter.this.n();
                if (n2 != null) {
                    n2.a(BitmapFactory.decodeFile(CameraPreViewPresenter.this.f33036c.b()));
                }
            }
        });
        n.a(this.f33036c.a(n.getActivity()));
        n.b(this.f33036c.c(n.getActivity()));
    }

    public void b() {
        ICameraPreView n = n();
        if (n != null) {
            Intent intent = new Intent();
            intent.putExtra("KEY_AV_MODEL", this.e);
            intent.putExtra("KEY_FILE_PATH", this.f33036c.b());
            n.getActivity().setResult(-1, intent);
            n.getActivity().finish();
        }
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void b(Bundle bundle) {
    }

    public void c() {
        int i = this.d;
        if (i == 0) {
            if (n() != null) {
                n().b();
            }
        } else if (i == 1) {
            b();
        } else if (n() != null) {
            n().c();
        }
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void h() {
    }
}
