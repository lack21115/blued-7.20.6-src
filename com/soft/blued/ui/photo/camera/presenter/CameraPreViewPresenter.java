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
    private static String f19344a = CameraPreViewPresenter.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private CameraModel f19345c;
    private int d = 0;
    private AdultVerifyModel e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/presenter/CameraPreViewPresenter$AV_RESULT.class */
    public interface AV_RESULT {
    }

    public void a() {
        ICameraPreView iCameraPreView = (ICameraPreView) n();
        if (this.f19345c == null || iCameraPreView == null) {
            return;
        }
        iCameraPreView.a(true);
        iCameraPreView.b();
        this.f19345c.a(new BluedUIHttpResponse<BluedEntity<AdultVerifyModel, BluedEntityBaseExtra>>() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter.1

            /* renamed from: a  reason: collision with root package name */
            String f19346a;

            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            public boolean onUIFailure(int i, String str) {
                if (i != 4036712) {
                    CameraPreViewPresenter.this.d = 2;
                    return super.onUIFailure(i, str);
                }
                CameraPreViewPresenter.this.d = 3;
                this.f19346a = str;
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                ICameraPreView iCameraPreView2 = (ICameraPreView) CameraPreViewPresenter.this.n();
                if (iCameraPreView2 != null) {
                    iCameraPreView2.a(false);
                }
                int i = CameraPreViewPresenter.this.d;
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    if (CameraPreViewPresenter.this.f19345c.a() == 1) {
                        ((ICameraPreView) CameraPreViewPresenter.this.n()).c(this.f19346a);
                    }
                }
                if (iCameraPreView2 != null) {
                    iCameraPreView2.d();
                }
            }

            public void onUIStart() {
                super.onUIStart();
                this.f19346a = "";
                CameraPreViewPresenter.this.d = 0;
            }

            public void onUIUpdate(BluedEntity<AdultVerifyModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                CameraPreViewPresenter.this.e = (AdultVerifyModel) bluedEntity.getSingleData();
                CameraPreViewPresenter.this.d = 1;
            }
        }, iCameraPreView.a());
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    public void a(Bundle bundle) {
        ICameraPreView iCameraPreView = (ICameraPreView) n();
        if (iCameraPreView == null) {
            StvLogUtils.a(f19344a + "ICameraPreView == null!!!", new Object[0]);
            return;
        }
        Bundle arguments = iCameraPreView.getArguments();
        if (arguments == null) {
            iCameraPreView.getActivity().finish();
            return;
        }
        CameraModel cameraModel = (CameraModel) arguments.getSerializable("camera_model_key");
        this.f19345c = cameraModel;
        if (cameraModel == null) {
            iCameraPreView.getActivity().finish();
            return;
        }
        int e = cameraModel.e();
        if (e != 0) {
            iCameraPreView.b(CameraImageUtils.a(e));
        }
        int f = this.f19345c.f();
        if (f != 0) {
            iCameraPreView.a(f);
        }
        CameraContents.f14621a.execute(new Runnable() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                ICameraPreView iCameraPreView2 = (ICameraPreView) CameraPreViewPresenter.this.n();
                if (iCameraPreView2 != null) {
                    iCameraPreView2.a(BitmapFactory.decodeFile(CameraPreViewPresenter.this.f19345c.b()));
                }
            }
        });
        iCameraPreView.a(this.f19345c.a(iCameraPreView.getActivity()));
        iCameraPreView.b(this.f19345c.c(iCameraPreView.getActivity()));
    }

    public void b() {
        ICameraPreView iCameraPreView = (ICameraPreView) n();
        if (iCameraPreView != null) {
            Intent intent = new Intent();
            intent.putExtra("KEY_AV_MODEL", this.e);
            intent.putExtra("KEY_FILE_PATH", this.f19345c.b());
            iCameraPreView.getActivity().setResult(-1, intent);
            iCameraPreView.getActivity().finish();
        }
    }

    public void b(Bundle bundle) {
    }

    public void c() {
        int i = this.d;
        if (i == 0) {
            if (n() != null) {
                ((ICameraPreView) n()).b();
            }
        } else if (i == 1) {
            b();
        } else if (n() != null) {
            ((ICameraPreView) n()).c();
        }
    }

    public void h() {
    }
}
