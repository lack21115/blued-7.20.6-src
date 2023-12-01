package com.soft.blued.ui.photo.camera.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.soft.blued.ui.photo.camera.contract.ICameraView;
import com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.view.BluedCameraView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/presenter/CameraPresenter.class */
public class CameraPresenter extends MediaBasePresent<ICameraView> implements PermissionCallbacks, BluedCameraView.OperationCallback {

    /* renamed from: a  reason: collision with root package name */
    private static String f19348a = CameraPresenter.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private CameraModel f19349c;
    private Runnable d = new Runnable() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            ICameraView iCameraView = (ICameraView) CameraPresenter.this.n();
            if (iCameraView != null) {
                if (iCameraView.d()) {
                    iCameraView.a().setFacing(CameraPresenter.this.f19349c.d());
                } else {
                    AppInfo.n().postDelayed(CameraPresenter.this.d, 300L);
                }
            }
        }
    };

    public CameraPresenter() {
        if (this.f19349c == null) {
            this.f19349c = new CameraModel();
        }
    }

    public void U_() {
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView == null || !iCameraView.d()) {
            return;
        }
        if (iCameraView.e()) {
            iCameraView.b();
        } else {
            iCameraView.c();
        }
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                return;
            }
            activity.setResult(-1, intent);
            activity.finish();
            return;
        }
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView != null) {
            iCameraView.g();
        }
    }

    public void a(Bundle bundle) {
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView == null) {
            StvLogUtils.a(f19348a + "ICameraView == null!!!", new Object[0]);
            return;
        }
        Bundle arguments = iCameraView.getArguments();
        if (arguments != null) {
            this.f19349c.a(arguments.getInt("from"));
            iCameraView.a(this.f19349c.a(iCameraView.getActivity()));
            iCameraView.b(this.f19349c.b(iCameraView.getActivity()));
            iCameraView.a().setFacing(this.f19349c.d());
            return;
        }
        StvLogUtils.a(f19348a + " bundle == null!!!", new Object[0]);
        iCameraView.getActivity().finish();
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void a(boolean z, String str) {
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView == null || iCameraView.f() == null || !iCameraView.f().isAdded()) {
            return;
        }
        iCameraView.b(z);
        if (z) {
            CameraModel cameraModel = this.f19349c;
            if (cameraModel != null) {
                cameraModel.a(str);
            }
            CameraModel cameraModel2 = new CameraModel();
            cameraModel2.a(this.f19349c);
            BluedCameraView a2 = iCameraView.a();
            if (a2 != null) {
                cameraModel2.b(a2.getFacing());
            }
            CameraPreViewFragment.a(iCameraView.f(), cameraModel2, 1);
        }
    }

    public void a(String[] strArr) {
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void b() {
    }

    public void b(Bundle bundle) {
    }

    public void c() {
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView == null || !iCameraView.d()) {
            return;
        }
        if (iCameraView.e()) {
            iCameraView.b();
        } else {
            iCameraView.c();
        }
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void d() {
        ICameraView iCameraView = (ICameraView) n();
        if (iCameraView == null || iCameraView.f() == null || !iCameraView.f().isAdded()) {
            return;
        }
        iCameraView.a(true);
    }

    public void h() {
    }
}
