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
    private static String f33039a = CameraPresenter.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private CameraModel f33040c;
    private Runnable d = new Runnable() { // from class: com.soft.blued.ui.photo.camera.presenter.CameraPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            ICameraView n = CameraPresenter.this.n();
            if (n != null) {
                if (n.d()) {
                    n.a().setFacing(CameraPresenter.this.f33040c.d());
                } else {
                    AppInfo.n().postDelayed(CameraPresenter.this.d, 300L);
                }
            }
        }
    };

    public CameraPresenter() {
        if (this.f33040c == null) {
            this.f33040c = new CameraModel();
        }
    }

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void U_() {
        ICameraView n = n();
        if (n == null || !n.d()) {
            return;
        }
        if (n.e()) {
            n.b();
        } else {
            n.c();
        }
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                return;
            }
            activity.setResult(-1, intent);
            activity.finish();
            return;
        }
        ICameraView n = n();
        if (n != null) {
            n.g();
        }
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Bundle bundle) {
        ICameraView n = n();
        if (n == null) {
            StvLogUtils.a(f33039a + "ICameraView == null!!!", new Object[0]);
            return;
        }
        Bundle arguments = n.getArguments();
        if (arguments != null) {
            this.f33040c.a(arguments.getInt("from"));
            n.a(this.f33040c.a(n.getActivity()));
            n.b(this.f33040c.b(n.getActivity()));
            n.a().setFacing(this.f33040c.d());
            return;
        }
        StvLogUtils.a(f33039a + " bundle == null!!!", new Object[0]);
        n.getActivity().finish();
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void a(boolean z, String str) {
        ICameraView n = n();
        if (n == null || n.f() == null || !n.f().isAdded()) {
            return;
        }
        n.b(z);
        if (z) {
            CameraModel cameraModel = this.f33040c;
            if (cameraModel != null) {
                cameraModel.a(str);
            }
            CameraModel cameraModel2 = new CameraModel();
            cameraModel2.a(this.f33040c);
            BluedCameraView a2 = n.a();
            if (a2 != null) {
                cameraModel2.b(a2.getFacing());
            }
            CameraPreViewFragment.a(n.f(), cameraModel2, 1);
        }
    }

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void a(String[] strArr) {
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void b() {
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void b(Bundle bundle) {
    }

    public void c() {
        ICameraView n = n();
        if (n == null || !n.d()) {
            return;
        }
        if (n.e()) {
            n.b();
        } else {
            n.c();
        }
    }

    @Override // com.soft.blued.ui.photo.camera.view.BluedCameraView.OperationCallback
    public void d() {
        ICameraView n = n();
        if (n == null || n.f() == null || !n.f().isAdded()) {
            return;
        }
        n.a(true);
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void h() {
    }
}
