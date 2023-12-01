package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.widget.LockPatternUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveInteractionModel;
import com.blued.android.module.live_china.same.loadingIndicator.AVLoadingIndicatorView;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKWholeView.class */
public class LivePKWholeView extends FrameLayout implements View.OnClickListener {
    public int a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private LiveConnectionView e;
    private ILiveConnectionStateListener f;
    private View g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private LinearLayout l;
    private ImageView m;
    private AVLoadingIndicatorView n;
    private ImageView o;
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private WholeCountDownTimer u;
    private InviteCountDownTimer v;
    private CountDownTimer w;
    private LiveInteractionModel x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LivePKWholeView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKWholeView$1.class */
    public class AnonymousClass1 extends BluedUIHttpResponse<BluedEntity<GrabBoxDetailModel, LiveInteractionModel>> {
        AnonymousClass1(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LivePKWholeView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.1.1.1
                        @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                        public void onAnimationEnd() {
                            LivePKWholeView.this.e.a(true);
                        }
                    });
                }
            });
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<GrabBoxDetailModel, LiveInteractionModel> bluedEntity) {
            if (bluedEntity != null && bluedEntity.extra != null) {
                LivePKWholeView.this.x = bluedEntity.extra;
            }
            LivePKWholeView.this.i();
            AppInfo.n().postDelayed(LivePKWholeView.this.u, LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LivePKWholeView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKWholeView$3.class */
    class AnonymousClass3 extends CountDownTimer {
        final /* synthetic */ LiveFriendModel a;
        final /* synthetic */ LivePKWholeView b;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.b.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.3.1
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    AnonymousClass3.this.b.e.a.a(AnonymousClass3.this.a, "friend");
                }
            });
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.b.t.setText(((j / 1000) + 1) + "");
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKWholeView$InviteCountDownTimer.class */
    public class InviteCountDownTimer implements Runnable {
        public InviteCountDownTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LivePKWholeView.this.g();
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKWholeView$WholeCountDownTimer.class */
    public class WholeCountDownTimer implements Runnable {
        public WholeCountDownTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InstantLog.a("live_pk_match_overtime");
            LivePKWholeView.this.c();
        }
    }

    public LivePKWholeView(Context context) {
        this(context, null);
    }

    public LivePKWholeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKWholeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = new WholeCountDownTimer();
        this.v = new InviteCountDownTimer();
        this.b = context;
        k();
    }

    private void k() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        this.d = from.inflate(R.layout.live_pk_whole_loading, this).findViewById(R.id.content_layout);
        this.g = findViewById(R.id.live_pk_whole_layer);
        this.h = (TextView) findViewById(R.id.live_pk_whole_title);
        this.i = (LinearLayout) findViewById(R.id.live_pk_whole_text_layout);
        this.j = (TextView) findViewById(R.id.live_pk_whole_text_top);
        this.k = (TextView) findViewById(R.id.live_pk_whole_text_bottom);
        this.l = (LinearLayout) findViewById(R.id.live_pk_whole_header_layout);
        this.m = (ImageView) findViewById(R.id.live_pk_whole_my_header);
        this.n = (AVLoadingIndicatorView) findViewById(R.id.remote_loading_view);
        this.o = (ImageView) findViewById(R.id.live_pk_whole_your_header);
        this.p = (LinearLayout) findViewById(R.id.live_pk_whole_bottom_double_btn_layout);
        this.q = (TextView) findViewById(R.id.live_pk_whole_bottom_double_cancel_btn);
        this.r = (TextView) findViewById(R.id.live_pk_whole_bottom_double_again_btn);
        this.s = (TextView) findViewById(R.id.live_pk_whole_bottom_single_cancel_btn);
        this.t = (TextView) findViewById(R.id.live_pk_whole_bottom_count_down);
        this.d.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.r.setOnClickListener(this);
    }

    private void l() {
        LiveRoomHttpUtils.m(new AnonymousClass1(this.e.a.getFragmentActive()));
    }

    private void m() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        this.d.setVisibility(0);
        this.d.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.a();
        }
    }

    public void a() {
        this.h.setText(this.b.getString(R.string.live_pk_whole_matching));
        this.l.setVisibility(0);
        this.i.setVisibility(8);
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        this.t.setVisibility(8);
        ImageLoader.a((IRequestHost) null, LiveRoomInfo.a().d()).b(R.drawable.user_bg_round).c().a(this.m);
        this.o.setImageResource(R.drawable.user_bg_round);
        m();
        this.g.setVisibility(4);
        l();
        setCurrentModel(1);
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.d.getVisibility() == 8) {
            return;
        }
        this.d.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivePKWholeView.this.setVisibility(8);
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        setCurrentModel(0);
        ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    public void a(LiveConnectionView liveConnectionView) {
        this.e = liveConnectionView;
        this.f = liveConnectionView;
    }

    public void b() {
        Log.v("pk", "取消全民pk接口");
        LiveRoomHttpUtils.n(new BluedUIHttpResponse() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    public void c() {
        this.h.setText(this.b.getString(R.string.live_pk_whole));
        this.l.setVisibility(8);
        this.i.setVisibility(0);
        this.n.setVisibility(8);
        this.p.setVisibility(0);
        this.s.setVisibility(8);
        m();
        this.g.setVisibility(4);
        setCurrentModel(3);
    }

    public void d() {
        h();
        int i = this.a;
        if (i == 4 || i == 1) {
            g();
        }
    }

    public void e() {
        if (this.p.getVisibility() == 0 || this.s.getVisibility() == 0) {
            this.s.performClick();
        }
    }

    public boolean f() {
        return getVisibility() == 0;
    }

    public void g() {
        setCurrentModel(0);
        a((ILiveConnectionAnimListener) null);
    }

    public void h() {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void i() {
        AppInfo.n().removeCallbacks(this.u);
    }

    public void j() {
        AppInfo.n().removeCallbacks(this.v);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_whole_bottom_single_cancel_btn || view.getId() == R.id.live_pk_whole_bottom_double_cancel_btn) {
            a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKWholeView.6
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    LivePKWholeView.this.b();
                    LivePKWholeView.this.e.a(false);
                }
            });
            i();
        } else if (view.getId() == R.id.live_pk_whole_bottom_double_again_btn) {
            a();
        }
    }

    public void setCurrentModel(int i) {
        Log.v("pk", "setCurrentModel:" + i);
        this.a = i;
    }
}
