package com.soft.blued.ui.photo.camera.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.media.selector.fragment.MediaBaseFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.photo.camera.contract.ICameraView;
import com.soft.blued.ui.photo.camera.presenter.CameraPresenter;
import com.soft.blued.ui.photo.camera.view.BluedCameraView;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/fragment/CameraFragment.class */
public class CameraFragment extends MediaBaseFragment<ICameraView, CameraPresenter> implements View.OnClickListener, ICameraView {

    /* renamed from: a  reason: collision with root package name */
    private View f33017a;
    private RelativeLayout d;
    private BluedCameraView e;
    private View f;
    private View g;
    private View h;
    private TextView i;
    private Dialog j;
    private Dialog k;
    private int l;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        UserRelationshipUtils.a("", new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        l();
    }

    public static void a(final Object obj, final int i, final int i2) {
        if ((obj instanceof Fragment ? ((Fragment) obj).getContext() : (Context) obj) == null) {
            return;
        }
        PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraFragment.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Bundle bundle = new Bundle();
                bundle.putInt("from", i);
                Object obj2 = obj;
                if (obj2 instanceof Activity) {
                    TerminalActivity.a((Activity) obj2, CameraFragment.class, bundle, i2);
                } else if (obj2 instanceof Fragment) {
                    TerminalActivity.a((Fragment) obj2, CameraFragment.class, bundle, i2);
                } else {
                    TerminalActivity.d((Context) obj2, CameraFragment.class, null);
                }
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        AppUtils.a(AppInfo.d());
        BluedPreferences.b(0L);
    }

    private void j() {
        this.j = DialogUtils.a(getContext(), false);
    }

    private void k() {
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        int a2 = AppInfo.l - DensityUtils.a(getContext(), 60.0f);
        layoutParams.width = a2;
        layoutParams.height = (int) (a2 / 1.0f);
        this.d.setLayoutParams(layoutParams);
    }

    private void l() {
        CommonAlertDialog.a(getActivity(), "", this.f15554c.getResources().getString(R.string.av_abort_confirm_text), this.f15554c.getResources().getString(R.string.av_abort), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.-$$Lambda$CameraFragment$cNtQLnHegC9Y5JD6JCP1Rwp6PIk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraFragment.a(dialogInterface, i);
            }
        }, this.f15554c.getResources().getString(R.string.av_continue_verify), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private void m() {
        View view = this.f;
        if (view != null) {
            view.setEnabled(false);
        }
    }

    private void n() {
        View view = this.f;
        if (view != null) {
            view.setEnabled(true);
        }
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void A() {
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public BluedCameraView a() {
        return this.e;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraBaseView
    public void a(String str) {
        ((TextView) this.f33017a.findViewById(2131372754)).setText(str);
    }

    @Override // com.blued.android.module.media.selector.contract.IBaseView
    public void a(boolean z) {
        if (z) {
            Dialog dialog = this.j;
            if (dialog != null) {
                DialogUtils.a(dialog);
            }
            m();
            return;
        }
        Dialog dialog2 = this.j;
        if (dialog2 != null) {
            DialogUtils.b(dialog2);
        }
        n();
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public boolean a(Bundle bundle) {
        return false;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public void b() {
        BluedCameraView bluedCameraView = this.e;
        if (bluedCameraView == null || !bluedCameraView.b()) {
            return;
        }
        this.e.takePicture();
        m();
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void b(Bundle bundle) {
        this.d = (RelativeLayout) this.f33017a.findViewById(R.id.camera_root_v);
        this.e = (BluedCameraView) this.f33017a.findViewById(R.id.camera);
        View findViewById = this.f33017a.findViewById(R.id.take_picture);
        this.f = findViewById;
        findViewById.setOnClickListener(this);
        this.i = (TextView) this.f33017a.findViewById(R.id.camera_tips);
        View findViewById2 = this.f33017a.findViewById(R.id.abort_verify);
        this.g = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.-$$Lambda$CameraFragment$z9L90BEEyyX5-6x8PrcJgBxn-Fc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFragment.this.b(view);
            }
        });
        View findViewById3 = this.f33017a.findViewById(2131364443);
        this.h = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.-$$Lambda$CameraFragment$abQmg6U2n-ERCZj3pRaq1IdjxNg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFragment.this.a(view);
            }
        });
        j();
        k();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public void b(String str) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public void b(boolean z) {
        a(false);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public void c() {
        if (this.k == null) {
            this.k = CommonAlertDialog.a(getContext(), (String) null, getString(2131886879), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    CameraFragment.this.i();
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraFragment.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    CameraFragment.this.i();
                }
            }, 0);
        }
        this.k.show();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public boolean d() {
        BluedCameraView bluedCameraView = this.e;
        if (bluedCameraView != null) {
            return bluedCameraView.b();
        }
        return false;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public boolean e() {
        BluedCameraView bluedCameraView = this.e;
        if (bluedCameraView != null) {
            return bluedCameraView.isCameraOpened();
        }
        return false;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public BaseFragment f() {
        return this;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraView
    public void g() {
        BluedCameraView bluedCameraView;
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null || (bluedCameraView = this.e) == null) {
            return;
        }
        relativeLayout.removeView(bluedCameraView);
        this.d.addView(this.e);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraBaseView
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    /* renamed from: h */
    public CameraPresenter B() {
        return new CameraPresenter();
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        View view = this.f;
        if (view == null || view.isEnabled()) {
            l();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == 2131370580 && this.b != 0) {
            ((CameraPresenter) this.b).c();
        }
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f33017a;
        if (view == null) {
            this.f33017a = layoutInflater.inflate(R.layout.camera_view, viewGroup, false);
            if (getArguments() != null) {
                this.l = getArguments().getInt("from");
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f33017a.getParent()).removeView(this.f33017a);
        }
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f33017a;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        BluedCameraView bluedCameraView = this.e;
        if (bluedCameraView != null) {
            bluedCameraView.d();
        }
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        BluedCameraView bluedCameraView = this.e;
        if (bluedCameraView != null) {
            bluedCameraView.c();
        }
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g();
        if (this.e == null || this.b == 0) {
            return;
        }
        this.e.a((BluedCameraView.OperationCallback) this.b);
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void x() {
    }
}
