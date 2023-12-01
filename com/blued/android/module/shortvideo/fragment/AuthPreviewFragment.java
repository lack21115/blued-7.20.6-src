package com.blued.android.module.shortvideo.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthPreviewView;
import com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/AuthPreviewFragment.class */
public class AuthPreviewFragment extends ShortVideoBaseFragment<IAuthPreviewView, AuthPreviewPresenter> implements View.OnClickListener, IAuthPreviewView {
    private LinearLayout b;
    private LinearLayout c;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private VideoView t;
    private ImageView u;
    private Context v;

    private void a(int i, boolean z) {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("auth_upload_state", z);
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public static void a(BaseFragment baseFragment, String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("video_path", str);
        bundle.putInt("from", i);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.a(baseFragment, AuthPreviewFragment.class, bundle, i2);
    }

    private void i() {
        this.r.setText(getString(R.string.auth_prompt_top));
    }

    private void j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.v);
        builder.setMessage(getString(R.string.auth_stop_video_upload));
        builder.setTitle(getString(R.string.hint));
        builder.setPositiveButton(getString(R.string.auth_over), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.AuthPreviewFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (AuthPreviewFragment.this.k != 0) {
                    ((AuthPreviewPresenter) AuthPreviewFragment.this.k).h();
                }
                dialogInterface.dismiss();
                AuthPreviewFragment.this.a(false);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.AuthPreviewFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        g();
        if (this.k != 0) {
            ((AuthPreviewPresenter) this.k).h();
        }
        b();
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void T_() {
        a(100.0f);
        a(true);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public VideoView a() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public AuthPreviewPresenter c(Bundle bundle) {
        return new AuthPreviewPresenter(bundle);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(final float f) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.shortvideo.fragment.AuthPreviewFragment.3
            @Override // java.lang.Runnable
            public void run() {
                AuthPreviewFragment.this.b.setVisibility(0);
                AuthPreviewFragment.this.c.setVisibility(8);
                TextView textView = AuthPreviewFragment.this.p;
                textView.setText(AuthPreviewFragment.this.getString(R.string.uploading) + f + "%");
            }
        });
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(Runnable runnable, long j) {
        postDelaySafeRunOnUiThread(runnable, j);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.r.setText(getString(R.string.auth_error_top));
        } else {
            this.r.setText(str);
        }
        this.n.setEnabled(true);
        this.o.setEnabled(true);
    }

    public void a(boolean z) {
        a(-1, z);
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void b() {
        a(0, false);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        this.u = (ImageView) this.m.findViewById(R.id.iv_back);
        this.n = (TextView) this.m.findViewById(R.id.upload_btn);
        this.o = (TextView) this.m.findViewById(R.id.re_recorder_btn);
        this.b = (LinearLayout) this.m.findViewById(R.id.upload_video_layout);
        this.c = (LinearLayout) this.m.findViewById(R.id.upload_btn_layout);
        this.p = (TextView) this.m.findViewById(R.id.upload_video_text);
        this.q = (TextView) this.m.findViewById(R.id.upload_video_cancel);
        this.r = (TextView) this.m.findViewById(R.id.prompt_top);
        this.s = (ImageView) this.m.findViewById(R.id.video_play_btn);
        this.t = (VideoView) this.m.findViewById(R.id.stv_auth_videoview);
        i();
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void c() {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView
    public void c(boolean z) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void d() {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.v);
        builder.setTitle(getString(R.string.hint));
        builder.setMessage(getString(R.string.auth_notify_fail));
        builder.setPositiveButton(getString(R.string.auth_notify_try_again), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.AuthPreviewFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (AuthPreviewFragment.this.k != 0) {
                    ((AuthPreviewPresenter) AuthPreviewFragment.this.k).j();
                }
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.AuthPreviewFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                AuthPreviewFragment.this.k();
            }
        });
        builder.create().show();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.u.setOnClickListener(this);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        j();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.upload_btn) {
            if (this.k != 0) {
                this.n.setEnabled(false);
                this.o.setEnabled(false);
                a(30.0f);
                ((AuthPreviewPresenter) this.k).i();
            }
        } else if (id == R.id.re_recorder_btn) {
            k();
        } else if (id == R.id.upload_video_cancel) {
            j();
        } else if (id == R.id.iv_back) {
            j();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(19);
        super.onCreate(bundle);
        this.v = getContext();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.a(layoutInflater, R.layout.auth_upload_video_v, viewGroup, bundle);
        return this.m;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
    }
}
