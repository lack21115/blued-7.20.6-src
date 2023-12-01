package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.same.loadingIndicator.AVLoadingIndicatorView;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKInviteView.class */
public class LivePKInviteView extends FrameLayout implements View.OnClickListener {
    public int a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private View e;
    private LinearLayout f;
    private View g;
    private LiveConnectionView h;
    private ILiveConnectionStateListener i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private AVLoadingIndicatorView q;
    private ProgressBar r;
    private LiveFriendModel s;
    private CountDownTimer t;

    public LivePKInviteView(Context context) {
        this(context, null);
    }

    public LivePKInviteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKInviteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        g();
    }

    private void b(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.d.getVisibility() == 8) {
            return;
        }
        this.d.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
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
        ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    private void c(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.f.getVisibility() == 8) {
            return;
        }
        this.f.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_center_out);
        this.f.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
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
    }

    private void g() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        View inflate = from.inflate(R.layout.live_pk_invite_loading, this);
        this.d = inflate.findViewById(R.id.content_layout);
        this.e = inflate.findViewById(R.id.live_pk_invite_layer);
        this.j = (TextView) inflate.findViewById(R.id.tv_title);
        this.k = (TextView) inflate.findViewById(R.id.tv_tip);
        this.l = (TextView) inflate.findViewById(R.id.tv_left);
        this.m = (TextView) inflate.findViewById(R.id.tv_right);
        this.n = (ImageView) inflate.findViewById(R.id.iv_left);
        this.o = (ImageView) inflate.findViewById(R.id.iv_right);
        this.p = (ImageView) inflate.findViewById(R.id.iv_anim);
        this.q = (AVLoadingIndicatorView) inflate.findViewById(R.id.iv_circling);
        this.g = inflate.findViewById(R.id.live_invite_cancel);
        this.r = (ProgressBar) findViewById(R.id.ll_loading);
        this.f = (LinearLayout) inflate.findViewById(R.id.live_pk_simple_loading_layout);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    private void h() {
        LiveFriendModel liveFriendModel = this.s;
        if (liveFriendModel != null) {
            if (TextUtils.isEmpty(liveFriendModel.name)) {
                this.m.setText("");
            } else {
                this.m.setText(this.s.name);
            }
            ImageLoader.a((IRequestHost) null, this.s.avatar).b(R.drawable.user_bg_round).c().a(this.o);
        }
        this.l.setText(LiveRoomManager.a().h());
        ImageLoader.a((IRequestHost) null, LiveRoomManager.a().i()).b(R.drawable.user_bg_round).c().a(this.n);
        if (this.a == 0) {
            this.q.setVisibility(0);
            this.p.setVisibility(8);
            this.j.setText(this.b.getString(R.string.live_invite_pking_tile));
        } else {
            this.q.setVisibility(8);
            this.p.setVisibility(0);
            ImageLoader.c(null, "live_multi_connection_anim.png").e((int) (System.currentTimeMillis() / 1000)).g(-1).a(this.p);
            this.j.setText(this.b.getString(R.string.live_invite_connecting_title));
        }
        if (this.s.timeout == 0) {
            this.s.timeout = 20;
        }
        this.k.setText(String.format(AppInfo.d().getString(R.string.live_pk_invitation_cancelled), String.valueOf(this.s.timeout)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f.clearAnimation();
        this.f.setVisibility(0);
        this.f.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_center_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    private void j() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a() {
        c();
    }

    public void a(LiveFriendModel liveFriendModel, final boolean z, int i) {
        this.a = i;
        this.s = liveFriendModel;
        setVisibility(0);
        this.d.setVisibility(0);
        this.d.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    LivePKInviteView.this.e();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.a();
        }
        h();
        this.e.setVisibility(0);
    }

    public void a(ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (b()) {
            if (this.f.getVisibility() == 0) {
                c(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.2
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LivePKInviteView.this.setVisibility(8);
                    }
                });
            }
            if (this.d.getVisibility() == 0) {
                b(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.3
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LivePKInviteView.this.setVisibility(8);
                    }
                });
            }
            j();
        } else {
            setVisibility(8);
        }
        if (iLiveConnectionAnimListener != null) {
            iLiveConnectionAnimListener.onAnimationEnd();
        }
        ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    public void a(LiveConnectionView liveConnectionView) {
        this.h = liveConnectionView;
        this.i = liveConnectionView;
    }

    public void a(final boolean z) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse(this.h.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKInviteView.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePKInviteView.this.r.setVisibility(8);
                LivePKInviteView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.9.1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        if (z) {
                            LivePKInviteView.this.h.a(false, LivePKInviteView.this.a);
                        }
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    public void b(final boolean z) {
        if (this.s == null) {
            a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.10
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    if (z) {
                        LivePKInviteView.this.h.a(false, LivePKInviteView.this.a);
                    }
                }
            });
        } else {
            LiveRoomHttpUtils.d(new BluedUIHttpResponse(this.h.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKInviteView.11
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    LivePKInviteView.this.r.setVisibility(8);
                    LivePKInviteView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.11.1
                        @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                        public void onAnimationEnd() {
                            if (z) {
                                LivePKInviteView.this.h.a(false, LivePKInviteView.this.a);
                            }
                        }
                    });
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                }
            }, this.s.uid, 1);
        }
    }

    public boolean b() {
        return this.f.getVisibility() == 0 || this.d.getVisibility() == 0;
    }

    public void c() {
        if (this.f.getVisibility() == 8) {
            b(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.6
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    LivePKInviteView.this.e.setVisibility(4);
                    LivePKInviteView.this.i();
                }
            });
        } else {
            c(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.7
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    LivePKInviteView.this.e.setVisibility(0);
                    LivePKInviteView livePKInviteView = LivePKInviteView.this;
                    livePKInviteView.a(livePKInviteView.s, false, LivePKInviteView.this.a);
                }
            });
        }
    }

    public void d() {
        if (this.a == 0) {
            a(false);
        } else {
            b(false);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.LivePKInviteView$12] */
    public void e() {
        j();
        this.t = new CountDownTimer(20000L, 1000L) { // from class: com.blued.android.module.live_china.view.LivePKInviteView.12
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LivePKInviteView.this.f.getVisibility() == 0) {
                    if (LivePKInviteView.this.a == 0) {
                        LivePKInviteView.this.a(false);
                    } else {
                        LivePKInviteView.this.b(false);
                    }
                } else if (LivePKInviteView.this.a == 0) {
                    LivePKInviteView.this.a(true);
                } else {
                    LivePKInviteView.this.b(true);
                }
                AppMethods.d(R.string.live_pk_invite_him_next_time);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void f() {
        j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_invite_layer) {
            c();
        } else if (view.getId() == R.id.live_invite_cancel) {
            String string = this.a == 0 ? this.b.getString(R.string.live_pk_cancel_this_invitation) : this.b.getString(R.string.live_connection_cancel_this_invitation);
            Context context = this.b;
            CommonAlertDialog.a(context, "", string, context.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKInviteView.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LivePKInviteView.this.r.setVisibility(0);
                    if (LivePKInviteView.this.a == 0) {
                        LivePKInviteView.this.a(true);
                    } else {
                        LivePKInviteView.this.b(true);
                    }
                }
            }, this.b.getString(R.string.live_window_permisson_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (view.getId() == R.id.live_pk_simple_loading_layout) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
