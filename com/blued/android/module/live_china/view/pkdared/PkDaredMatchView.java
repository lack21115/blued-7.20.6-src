package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveDaredPKExtraModel;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.pkdared.PkDaredMatchView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredMatchView.class */
public class PkDaredMatchView extends FrameLayout {
    private IRequestHost a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private OvershootInterpolator f;
    private int g;
    private int h;
    private CountDownTimer i;
    private CountDownTimer j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.pkdared.PkDaredMatchView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredMatchView$3.class */
    public class AnonymousClass3 extends CountDownTimer {
        AnonymousClass3(long j, long j2) {
            super(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            PkDaredMatchView.this.b(30, false);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PkDaredMatchView.this.b();
            PkDaredMatchView.this.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$3$H6LtEjJcwgqakw29jCYUJ5Xep28
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredMatchView.AnonymousClass3.this.a();
                }
            });
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PkDaredMatchView.this.b.setText(String.format(PkDaredMatchView.this.getContext().getResources().getString(R.string.live_pk_dared_match_time), Long.valueOf(Math.round(j / 1000.0d))));
        }
    }

    public PkDaredMatchView(Context context) {
        super(context);
        this.f = new OvershootInterpolator(1.5f);
        this.k = 60;
        a(context);
    }

    public PkDaredMatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new OvershootInterpolator(1.5f);
        this.k = 60;
        a(context);
    }

    public PkDaredMatchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new OvershootInterpolator(1.5f);
        this.k = 60;
        a(context);
    }

    public PkDaredMatchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = new OvershootInterpolator(1.5f);
        this.k = 60;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (ClickUtils.a(R.id.btn_cancel)) {
            return;
        }
        b();
        IRequestHost iRequestHost = this.a;
        if (iRequestHost != null) {
            LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredMatchView.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    AppMethods.a((CharSequence) str);
                    return true;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel> bluedEntity) {
                    PkDaredObserver.a().b();
                }
            }, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            f();
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        IRequestHost iRequestHost;
        if (ClickUtils.a(R.id.btn_retry) || (iRequestHost = this.a) == null) {
            return;
        }
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredMatchView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel> bluedEntity) {
                if (bluedEntity.extra == null || bluedEntity.extra.countdown <= 0) {
                    return;
                }
                PkDaredMatchView pkDaredMatchView = PkDaredMatchView.this;
                pkDaredMatchView.a(pkDaredMatchView.k = bluedEntity.extra.countdown, true);
            }
        }, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        if (z) {
            d();
        } else {
            c();
        }
    }

    private void c() {
        this.e.setAlpha(0.0f);
        this.d.setAlpha(0.0f);
        this.c.setTranslationY(getHeight() / 2);
        this.b.setTranslationY(getHeight() / 2);
        this.c.setAlpha(0.0f);
        this.b.setAlpha(0.0f);
        this.c.setText(R.string.live_pk_dared_match_cancel);
        this.c.animate().alpha(1.0f).translationY(0.0f).setDuration(350L).setStartDelay(80L);
        this.b.animate().alpha(1.0f).translationY(0.0f).setDuration(320L).setStartDelay(20L);
        this.d.setTranslationZ(0.0f);
        this.c.setTranslationZ(1.0f);
    }

    private void d() {
        this.g = this.c.getTop();
        this.h = this.d.getTop();
        this.c.setText(R.string.live_pk_dared_match_cancel);
        this.e.animate().alpha(0.0f).setDuration(200L).setStartDelay(0L);
        this.d.animate().alpha(0.0f).translationY(this.g - this.h).setDuration(350L).setStartDelay(0L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredMatchView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkDaredMatchView.this.d.setTranslationY(0.0f);
            }
        });
        this.c.setTranslationY(this.h - this.g);
        this.c.animate().alpha(1.0f).translationY(0.0f).setDuration(350L).setStartDelay(0L);
        this.b.animate().alpha(1.0f).setDuration(200L).setStartDelay(100L);
        this.d.setTranslationZ(0.0f);
        this.c.setTranslationZ(1.0f);
    }

    private void e() {
        this.g = this.c.getTop();
        this.h = this.d.getTop();
        this.d.setText(R.string.live_pk_dared_retry);
        this.b.animate().alpha(0.0f).setDuration(200L).setStartDelay(0L);
        this.c.animate().alpha(0.0f).translationY(this.h - this.g).setDuration(350L).setStartDelay(0L);
        this.d.setTranslationY(this.g - this.h);
        this.d.animate().alpha(1.0f).translationY(0.0f).setDuration(350L).setStartDelay(0L).setListener(null);
        this.e.animate().alpha(1.0f).setDuration(200L).setStartDelay(100L);
        this.d.setTranslationZ(1.0f);
        this.c.setTranslationZ(0.0f);
    }

    private void f() {
        this.b.setAlpha(0.0f);
        this.c.setAlpha(0.0f);
        this.d.setText(R.string.live_pk_dared_match_retry);
        this.d.setTranslationY(getHeight() / 2);
        this.e.setTranslationY(getHeight() / 2);
        this.d.setAlpha(0.0f);
        this.e.setAlpha(0.0f);
        this.d.animate().alpha(1.0f).translationY(0.0f).setDuration(320L).setStartDelay(20L).setListener(null);
        this.e.animate().alpha(1.0f).translationY(0.0f).setDuration(350L).setStartDelay(80L);
        this.d.setTranslationZ(1.0f);
        this.c.setTranslationZ(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.g = this.c.getTop();
        this.h = this.d.getTop();
    }

    public void a() {
        b();
        this.b.setText("");
        this.c.setText("");
        this.d.setText("");
        this.e.setText("");
        setVisibility(8);
    }

    public void a(int i, final boolean z) {
        b();
        this.i = new AnonymousClass3(i * 1000, 1000L).start();
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$rUzn29XEUcFyy2eVPtk0hiBNxWk
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredMatchView.this.b(z);
            }
        });
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_match, this);
        this.b = (TextView) findViewById(R.id.tv_match_ing);
        this.c = (TextView) findViewById(R.id.btn_cancel);
        this.d = (TextView) findViewById(R.id.btn_retry);
        this.e = (TextView) findViewById(R.id.tv_auto_close);
        this.b.animate().setInterpolator(this.f);
        this.c.animate().setInterpolator(this.f);
        this.d.animate().setInterpolator(this.f).setListener(null);
        this.e.animate().setInterpolator(this.f);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$CG-WSLVnqbJkUmyOtr6N3Dp07jM
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredMatchView.this.g();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$8IsQt9IgtFfL8V-709zNauaYMaQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PkDaredMatchView.this.a(view);
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$ueMJgRcwDfTo31ENSymrd1EWRiw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PkDaredMatchView.this.b(view);
            }
        });
    }

    public void b() {
        CountDownTimer countDownTimer = this.i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.i = null;
        }
        CountDownTimer countDownTimer2 = this.j;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.j = null;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.pkdared.PkDaredMatchView$5] */
    public void b(int i, final boolean z) {
        b();
        this.j = new CountDownTimer(i * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredMatchView.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PkDaredMatchView.this.b();
                PkDaredObserver.a().b();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                PkDaredMatchView.this.e.setText(String.format(PkDaredMatchView.this.getContext().getResources().getString(R.string.live_pk_dared_match_auto_close_time), Long.valueOf(Math.round(j / 1000.0d))));
            }
        }.start();
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredMatchView$TIcyfmQ-5-gmWZPdoBWLZV6GRrI
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredMatchView.this.a(z);
            }
        });
    }

    public void setRequestHost(IRequestHost iRequestHost) {
        this.a = iRequestHost;
    }
}
