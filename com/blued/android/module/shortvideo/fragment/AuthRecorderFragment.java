package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.internal.util.cm.PowerMenuConstants;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthRecorderView;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter;
import com.blued.android.module.shortvideo.utils.StvGuideUtils;
import com.blued.android.module.shortvideo.utils.TimeDownUtils;
import com.blued.android.module.shortvideo.view.AuthProgressBar;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/AuthRecorderFragment.class */
public class AuthRecorderFragment extends ShortVideoBaseFragment<IAuthRecorderView, AuthRecorderPresenter> implements View.OnClickListener, IAuthRecorderView, TimeDownUtils.ITimeDownCallBack {
    Runnable b = new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.AuthRecorderFragment.4
        @Override // java.lang.Runnable
        public void run() {
            if (AuthRecorderFragment.this.s == null || AuthRecorderFragment.this.s.getVisibility() != 0) {
                return;
            }
            AuthRecorderFragment.this.s.setVisibility(8);
            AuthRecorderFragment.this.i();
        }
    };
    private PowerManager.WakeLock c;
    private TextView n;
    private TextView o;
    private GLSurfaceView p;
    private LinearLayout q;
    private AuthProgressBar r;
    private View s;
    private View t;
    private TimeDownUtils u;

    private void a(int i, boolean z) {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("auth_upload_state", z);
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public static void a(final Object obj, final int i, final int i2) {
        if (obj instanceof Fragment) {
            ((Fragment) obj).getContext();
        } else {
            Context context = (Context) obj;
        }
        if (AppMethods.f()) {
            PermissionHelper.c(new PermissionCallbacks() { // from class: com.blued.android.module.shortvideo.fragment.AuthRecorderFragment.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    Bundle bundle = new Bundle();
                    bundle.putInt("from", i);
                    TerminalActivity.a(bundle);
                    TerminalActivity.b(bundle);
                    Object obj2 = obj;
                    if (obj2 instanceof Activity) {
                        TerminalActivity.a((Activity) obj2, AuthRecorderFragment.class, bundle, i2);
                    } else if (obj2 instanceof Fragment) {
                        TerminalActivity.a((Fragment) obj2, AuthRecorderFragment.class, bundle, i2);
                    } else {
                        TerminalActivity.a((Context) obj2, AuthRecorderFragment.class, bundle, i2);
                    }
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        } else {
            AppMethods.d(R.string.video_sdcard_not_exit);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public GLSurfaceView a() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public AuthRecorderPresenter c(Bundle bundle) {
        return new AuthRecorderPresenter(bundle);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(float f) {
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void a(Runnable runnable) {
        postSafeRunOnUiThread(runnable);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void a(boolean z) {
        a(-1, z);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public BaseFragment b() {
        return this;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        this.p = (GLSurfaceView) this.m.findViewById(R.id.svCameraNoFilter);
        this.q = (LinearLayout) this.m.findViewById(R.id.count_down_layout);
        this.n = (TextView) this.m.findViewById(R.id.count_down_text);
        this.r = (AuthProgressBar) this.m.findViewById(R.id.video_progressbar);
        this.o = (TextView) this.m.findViewById(R.id.cancel_btn);
        this.s = this.m.findViewById(R.id.fl_cover);
        this.t = this.m.findViewById(R.id.iv_close);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        if (!StvGuideUtils.c()) {
            this.s.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        StvGuideUtils.d();
        this.s.postDelayed(this.b, 10000L);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void c() {
        a(0, false);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView
    public void c(boolean z) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void d() {
        View view = this.s;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        i();
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void e() {
        AuthProgressBar authProgressBar = this.r;
        if (authProgressBar != null) {
            authProgressBar.setVisibility(0);
            this.r.a();
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthRecorderView
    public void f() {
        b(true);
        AuthProgressBar authProgressBar = this.r;
        if (authProgressBar != null) {
            authProgressBar.b();
            this.r.setVisibility(4);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.o.setOnClickListener(this);
        this.u = new TimeDownUtils(this.n, 3, this);
    }

    public void i() {
        View view = this.s;
        if (view != null) {
            view.removeCallbacks(this.b);
        }
        LinearLayout linearLayout = this.q;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TimeDownUtils timeDownUtils = this.u;
        if (timeDownUtils != null) {
            timeDownUtils.a();
        }
    }

    @Override // com.blued.android.module.shortvideo.utils.TimeDownUtils.ITimeDownCallBack
    public void j() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.AuthRecorderFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (AuthRecorderFragment.this.n != null) {
                    AuthRecorderFragment.this.n.setText(AuthRecorderFragment.this.getString(R.string.auth_start));
                }
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.AuthRecorderFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (AuthRecorderFragment.this.q != null) {
                    AuthRecorderFragment.this.q.setVisibility(8);
                }
                if (AuthRecorderFragment.this.k != 0) {
                    ((AuthRecorderPresenter) AuthRecorderFragment.this.k).h();
                }
            }
        }, 800L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.cancel_btn) {
            c();
        } else if (view.getId() == R.id.iv_close) {
            this.s.setVisibility(8);
            i();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = ((PowerManager) getActivity().getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER)).newWakeLock(536870938, "RecorderActivity");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, R.layout.auth_recorder_v, viewGroup, bundle);
        return this.m;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        View view = this.s;
        if (view != null) {
            view.removeCallbacks(this.b);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        TimeDownUtils timeDownUtils = this.u;
        if (timeDownUtils != null) {
            timeDownUtils.b();
        }
        AuthProgressBar authProgressBar = this.r;
        if (authProgressBar != null) {
            authProgressBar.b();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        AuthProgressBar authProgressBar = this.r;
        if (authProgressBar != null) {
            authProgressBar.setVisibility(4);
        }
        try {
            this.c.acquire();
        } catch (Exception e) {
            Log.e("RecorderActivity", "wake lock acquire fail", e);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        try {
            this.c.release();
        } catch (Exception e) {
            Log.e("RecorderActivity", "wake lock release fail", e);
        }
    }
}
