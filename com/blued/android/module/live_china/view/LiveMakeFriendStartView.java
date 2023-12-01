package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendStartView.class */
public class LiveMakeFriendStartView implements View.OnClickListener {
    public View a;
    public View b;
    public View c;
    public Context d;
    public LayoutInflater e;
    private MyPopupWindow f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private CountDownTimer k;
    private PlayingOnliveFragment l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveMakeFriendStartView$7  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendStartView$7.class */
    public class AnonymousClass7 implements PermissionCallbacks {
        AnonymousClass7() {
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void U_() {
            LiveMsgSendManager.a().d("开启权限");
            LiveMakeFriendStartView.this.b();
            BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(LiveMakeFriendStartView.this.l.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.7.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i, String str) {
                    super.onFailure(th, i, str);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveMakeFriendStartView.this.j.setEnabled(true);
                            LiveMakeFriendStartView.this.l.cb.setState(0);
                            LiveMakeFriendStartView.this.l.k.a(1);
                        }
                    });
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    LiveMakeFriendStartView.this.g.setVisibility(8);
                    LiveMakeFriendStartView.this.e();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    LiveMakeFriendStartView.this.g.setVisibility(0);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> bluedEntity) {
                }
            };
            LiveRoomHttpUtils.l(bluedUIHttpResponse, LiveMakeFriendStartView.this.l.t + "");
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void a(String[] strArr) {
            LiveMsgSendManager.a().d("关闭权限");
            LiveMakeFriendStartView.this.e();
            LiveMakeFriendStartView.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendStartView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(LiveMakeFriendStartView liveMakeFriendStartView, View view, int i, int i2) {
            this(view, i, i2, false);
        }

        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                LiveMakeFriendStartView.this.e();
            } catch (Exception e) {
                a();
            }
        }
    }

    public LiveMakeFriendStartView(PlayingOnliveFragment playingOnliveFragment) {
        this.d = playingOnliveFragment.getContext();
        this.l = playingOnliveFragment;
        f();
    }

    private void f() {
        this.e = LayoutInflater.from(this.d);
        a();
        this.b = this.a.findViewById(R.id.live_make_friend_start_layer);
        this.c = (FrameLayout) this.a.findViewById(R.id.content_layout);
        this.g = (LinearLayout) this.a.findViewById(R.id.ll_loading);
        this.h = (TextView) this.a.findViewById(R.id.live_make_friend_start_text);
        this.i = (TextView) this.a.findViewById(R.id.live_make_friend_start_cancel);
        this.j = (TextView) this.a.findViewById(R.id.live_make_friend_start_now);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.c.setVisibility(8);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this, this.a, -1, -1);
        this.f = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setFocusable(true);
        this.f.update();
    }

    private void g() {
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.4
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
        this.b.startAnimation(alphaAnimation);
    }

    private void h() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.l.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendStartView.this.g.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendStartView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendStartView.this.e();
                LiveMakeFriendStartView.this.b();
                LiveMakeFriendStartView.this.l.k.a(1);
                LiveMakeFriendStartView.this.l.cb.setState(0);
            }
        };
        LiveRoomHttpUtils.m(bluedUIHttpResponse, this.l.t + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        LiveRoomInfo.a().a(new AnonymousClass7());
    }

    public void a() {
        this.a = this.e.inflate(R.layout.live_make_friend_start, (ViewGroup) null);
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.5
            @Override // java.lang.Runnable
            public void run() {
                LiveMakeFriendStartView.this.f.a();
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }
        }, 320L);
        h();
        this.c.setVisibility(8);
    }

    public void b() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.LiveMakeFriendStartView$3] */
    public void c() {
        b();
        this.k = new CountDownTimer(6000L, 500L) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendStartView.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveMakeFriendStartView.this.j();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView = LiveMakeFriendStartView.this.h;
                textView.setText(((j / 1000) + 1) + "S");
            }
        }.start();
    }

    public void d() {
        c();
        this.b.clearAnimation();
        this.c.clearAnimation();
        if (this.f.isShowing()) {
            this.f.a();
        }
        this.f.showAtLocation(this.c, 81, 0, 0);
        this.c.setVisibility(0);
        g();
    }

    public void e() {
        a((ILiveConnectionAnimListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_friend_start_cancel) {
            i();
        } else if (view.getId() == R.id.live_make_friend_start_now) {
            this.j.setEnabled(false);
            j();
        }
    }
}
