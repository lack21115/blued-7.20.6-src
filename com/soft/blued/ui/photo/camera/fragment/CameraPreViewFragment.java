package com.soft.blued.ui.photo.camera.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.media.selector.fragment.MediaBaseFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.photo.camera.contract.ICameraPreView;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.presenter.CameraPreViewPresenter;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/fragment/CameraPreViewFragment.class */
public class CameraPreViewFragment extends MediaBaseFragment<ICameraPreView, CameraPreViewPresenter> implements ICameraPreView {

    /* renamed from: a  reason: collision with root package name */
    private View f19331a;
    private RelativeLayout d;
    private ImageView e;
    private View f;
    private ShapeTextView g;
    private CommonTopTitleNoTrans h;

    public static void a(Object obj, CameraModel cameraModel, int i) {
        if (cameraModel == null) {
            return;
        }
        boolean z = obj instanceof Fragment;
        if ((z ? ((Fragment) obj).getContext() : (Context) obj) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("camera_model_key", cameraModel);
        if (obj instanceof Activity) {
            TerminalActivity.a((Activity) obj, CameraPreViewFragment.class, bundle, i);
        } else if (z) {
            TerminalActivity.a((Fragment) obj, CameraPreViewFragment.class, bundle, i);
        } else {
            TerminalActivity.d((Context) obj, CameraPreViewFragment.class, bundle);
        }
    }

    private void f() {
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        int a2 = AppInfo.l - DensityUtils.a(AppInfo.d(), 60.0f);
        layoutParams.width = a2;
        layoutParams.height = (int) (a2 / 1.0f);
        this.d.setLayoutParams(layoutParams);
    }

    public void A() {
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public IRequestHost a() {
        return getFragmentActive();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void a(int i) {
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void a(final Bitmap bitmap) {
        a(new Runnable() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreViewFragment.this.e == null || bitmap == null) {
                    return;
                }
                CameraPreViewFragment.this.e.setImageBitmap(bitmap);
            }
        });
    }

    public void a(Runnable runnable) {
        postSafeRunOnUiThread(runnable);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraBaseView
    public void a(String str) {
        CommonTopTitleNoTrans findViewById = this.f19331a.findViewById(R.id.top_title);
        this.h = findViewById;
        findViewById.a();
        this.h.d();
        this.h.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonAlertDialog.a(CameraPreViewFragment.this.getActivity(), (String) null, CameraPreViewFragment.this.getResources().getString(R.string.av_confirm_quit_verify), CameraPreViewFragment.this.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        UserRelationshipUtils.a("", new int[0]);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        this.h.setCenterText(str);
    }

    public void a(boolean z) {
    }

    public boolean a(Bundle bundle) {
        return false;
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void b() {
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.f.getHeight(), DensityUtils.a(this.c, 315.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CameraPreViewFragment.this.f.setLayoutParams(layoutParams);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((CameraPreViewPresenter) CameraPreViewFragment.this.b).c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CameraPreViewFragment.this.g.setVisibility(0);
                CameraPreViewFragment.this.f.setVisibility(0);
            }
        });
        ofInt.setDuration(2000L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void b(Bitmap bitmap) {
        ImageView imageView = this.e;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public void b(Bundle bundle) {
        this.d = (RelativeLayout) this.f19331a.findViewById(R.id.camera_pre_root_v);
        this.e = (ImageView) this.f19331a.findViewById(R.id.camera_pre_img);
        this.f = this.f19331a.findViewById(R.id.img_cover_layer);
        this.g = this.f19331a.findViewById(R.id.tv_cover_text);
        f();
        c();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void b(String str) {
        this.g.setText(str);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void c() {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void c(String str) {
        CommonAlertDialog.a(this.c, this.c.getResources().getString(2131887885), str, this.c.getResources().getString(R.string.av_contact_service), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                AdultVerifyFragment.a(CameraPreViewFragment.this.c);
            }
        }, this.c.getResources().getString(R.string.av_again_take_photo), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ServiceHelper.f19954a.a(CameraPreViewFragment.this.c);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraPreView
    public void d() {
        this.h.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public CameraPreViewPresenter B() {
        return new CameraPreViewPresenter();
    }

    @Override // com.soft.blued.ui.photo.camera.contract.ICameraBaseView
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public boolean onBackPressed() {
        getActivity().setResult(0);
        getActivity().finish();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f19331a;
        if (view == null) {
            this.f19331a = layoutInflater.inflate(R.layout.camera_pre_view, viewGroup, false);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19331a.getParent()).removeView(this.f19331a);
        }
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return this.f19331a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((CameraPreViewPresenter) this.b).a();
    }

    public void x() {
    }
}
