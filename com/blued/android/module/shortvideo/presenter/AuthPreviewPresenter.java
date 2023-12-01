package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.base.http.PublishProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthPreviewView;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/presenter/AuthPreviewPresenter.class */
public class AuthPreviewPresenter extends ShortVideoBasePresent<IAuthPreviewView> {
    private static final String a = AuthPreviewPresenter.class.getSimpleName();
    private GestureDetector b;
    private File c;
    private String d;
    private int e;
    private Bundle i;
    private boolean f = false;
    private GestureDetector.OnGestureListener j = new GestureDetector.OnGestureListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.3
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (AuthPreviewPresenter.this.f) {
                AuthPreviewPresenter.this.m();
                return true;
            }
            AuthPreviewPresenter.this.l();
            AuthPreviewPresenter.this.k();
            return true;
        }
    };

    public AuthPreviewPresenter(Bundle bundle) {
        this.i = bundle;
    }

    private void b(int i) {
        StvLogUtils.a(i);
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a() {
        Bundle bundle = this.i;
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = D().getArguments();
        }
        if (bundle2 == null) {
            StvLogUtils.a(a + "EditPresenter bundle == null!!!", new Object[0]);
            b(R.string.common_net_error);
            D().b();
            return;
        }
        String string = bundle2.getString("video_path");
        this.e = bundle2.getInt("from", 0);
        if (TextUtils.isEmpty(string)) {
            b(R.string.common_net_error);
            D().b();
            return;
        }
        File file = new File(string);
        this.c = file;
        if (!file.exists()) {
            StvLogUtils.a(a + "EditPresenter commonModel 视频文件不存在！！！", new Object[0]);
            b(R.string.common_net_error);
            D().b();
            return;
        }
        this.d = string;
        PLMediaFile pLMediaFile = new PLMediaFile(string);
        int videoWidth = pLMediaFile.getVideoWidth();
        int videoHeight = pLMediaFile.getVideoHeight();
        int i = D().getContext().getResources().getDisplayMetrics().widthPixels;
        int i2 = (int) (((i * 1.0f) / videoWidth) * videoHeight);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) D().a().getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 17;
        D().a().setLayoutParams(layoutParams);
        D().a().setVideoPath(this.d);
        D().a().setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                mediaPlayer.setLooping(true);
                if (AuthPreviewPresenter.this.f || AuthPreviewPresenter.this.D() == null || AuthPreviewPresenter.this.D().getActivity() == null || AuthPreviewPresenter.this.D().getActivity().isFinishing()) {
                    return;
                }
                AuthPreviewPresenter.this.D().a(new Runnable() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AuthPreviewPresenter.this.a(0);
                        AuthPreviewPresenter.this.m();
                    }
                }, 300L);
            }
        });
        this.b = new GestureDetector(D().getContext(), this.j);
        D().a().setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AuthPreviewPresenter.this.b.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public void a(int i) {
        if (D() != null) {
            D().a().seekTo(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void a(Bundle bundle) {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void b() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void c() {
        l();
        if (D() != null) {
            D().a().start();
        }
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void d() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void e() {
        m();
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public void f() {
    }

    @Override // com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent
    public boolean g() {
        n();
        return false;
    }

    public void h() {
        File file = this.c;
        if (file != null) {
            file.delete();
        }
    }

    public void i() {
        PublishProxy.a().a(D().getContext(), this.d, this.e, new PublishProxy.IUploadAuthVideoListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.4
            @Override // com.blued.android.module.base.http.PublishProxy.IUploadAuthVideoListener
            public void a(int i, String str) {
                if (a()) {
                    return;
                }
                AuthPreviewPresenter.this.D().a(str);
            }

            @Override // com.blued.android.module.base.http.PublishProxy.IUploadAuthVideoListener
            public void a(String str, double d) {
                if (!a() && d <= 1.0d) {
                    StvLogUtils.a(AuthPreviewPresenter.a + "percent = " + d, new Object[0]);
                    int i = (int) (100.0d * d);
                    if (i == 100 || i > 99) {
                        AuthPreviewPresenter.this.D().a(99.0f);
                    } else if (d > 30.0d) {
                        AuthPreviewPresenter.this.D().a(i);
                    }
                }
            }

            @Override // com.blued.android.module.base.http.PublishProxy.IUploadAuthVideoListener
            public boolean a() {
                if (AuthPreviewPresenter.this.D() == null || AuthPreviewPresenter.this.D().getActivity() == null || AuthPreviewPresenter.this.D().getActivity().isFinishing()) {
                    StvLogUtils.a(AuthPreviewPresenter.a + " getView() == null!!!", new Object[0]);
                    return true;
                }
                return false;
            }

            @Override // com.blued.android.module.base.http.PublishProxy.IUploadAuthVideoListener
            public void b() {
                if (a()) {
                    return;
                }
                if (AuthPreviewPresenter.this.e == 1 || AuthPreviewPresenter.this.e == 2) {
                    AuthPreviewPresenter.this.j();
                } else {
                    AuthPreviewPresenter.this.D().T_();
                }
            }
        });
    }

    public void j() {
        PublishProxy.a().a(D().getContext(), this.e, new PublishProxy.ILiveApplyListener() { // from class: com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter.5
            @Override // com.blued.android.module.base.http.PublishProxy.ILiveApplyListener
            public void a() {
                AuthPreviewPresenter.this.D().T_();
            }

            @Override // com.blued.android.module.base.http.PublishProxy.ILiveApplyListener
            public void a(int i, String str) {
                AuthPreviewPresenter.this.D().f();
            }
        });
    }

    public void k() {
        if (D() != null) {
            D().a().start();
            D().d();
            this.f = true;
        }
    }

    public void l() {
        D().a().resume();
    }

    public void m() {
        if (D() != null) {
            D().a().pause();
            D().c();
            this.f = false;
        }
    }

    public void n() {
        if (D() != null) {
            D().a().stopPlayback();
            this.f = false;
        }
    }
}
