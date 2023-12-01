package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCallView.class */
public class PopLiveCallView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f15062a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f15063c;
    public Context d;
    public LayoutInflater e;
    private MyPopupWindow f;
    private BaseFragment g;
    private RecordingOnliveFragment h;
    private PlayingOnliveFragment i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private ImageView n;
    private View o;
    private View p;
    private View q;
    private LiveFriendModel r;
    private CountDownTimer s;
    private LinearLayout t;
    private List<LiveFriendModel> u = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCallView$AcceptResponse.class */
    class AcceptResponse extends BluedUIHttpResponse {
        public AcceptResponse(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            if (i == 403) {
                PopLiveCallView.this.u.clear();
                PopLiveCallView.this.i();
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.this.p.setVisibility(8);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.this.p.setVisibility(0);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            PopLiveCallView.this.u.clear();
            PopLiveCallView.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCallView$CancelResponse.class */
    public class CancelResponse extends BluedUIHttpResponse {

        /* renamed from: a  reason: collision with root package name */
        LiveFriendModel f15076a;

        public CancelResponse(LiveFriendModel liveFriendModel, IRequestHost iRequestHost) {
            super(iRequestHost);
            this.f15076a = liveFriendModel;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            if (i == 403) {
                PopLiveCallView.this.u.remove(this.f15076a);
                PopLiveCallView.this.i();
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.this.p.setVisibility(8);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.this.p.setVisibility(0);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            PopLiveCallView.this.u.remove(this.f15076a);
            PopLiveCallView.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveCallView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopLiveCallView.this.i();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopLiveCallView(BaseFragment baseFragment) {
        this.g = baseFragment;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h = (RecordingOnliveFragment) baseFragment;
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i = (PlayingOnliveFragment) baseFragment;
        }
        this.d = baseFragment.getContext();
        e();
    }

    private void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        BaseFragment baseFragment = this.g;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h.P();
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i.g(0);
            LiveSetDataObserver.a().e(0);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.5
            @Override // java.lang.Runnable
            public void run() {
                PopLiveCallView.this.f.a();
                PopLiveCallView.this.d();
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }
        }, 320L);
        j();
        k();
        this.f15063c.setVisibility(8);
    }

    private void a(List<LiveInviteUserModel> list) {
        LiveInviteUserModel next;
        if (list == null) {
            return;
        }
        this.t.removeAllViews();
        Iterator<LiveInviteUserModel> it = list.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext() || (next = it.next()) == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.live_pk_invite_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_invite);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_invite);
            this.t.addView(inflate, new LinearLayout.LayoutParams(DensityUtils.a(this.d, 90.0f), -2));
            ImageLoader.a((IRequestHost) null, next.avatar).b(R.drawable.user_bg_round).c().a(imageView);
            textView.setText(next.name);
            View findViewById = inflate.findViewById(R.id.view_anim);
            View findViewById2 = inflate.findViewById(R.id.view_bg);
            if (i2 == 0) {
                findViewById2.setVisibility(0);
                findViewById.setVisibility(0);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(600L);
                scaleAnimation.setFillAfter(false);
                scaleAnimation.setRepeatMode(2);
                scaleAnimation.setRepeatCount(-1);
                imageView.clearAnimation();
                imageView.startAnimation(scaleAnimation);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setRepeatCount(-1);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setRepeatCount(-1);
                final AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(1200L);
                animationSet.addAnimation(scaleAnimation2);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setFillAfter(true);
                findViewById.clearAnimation();
                findViewById.setAnimation(animationSet);
                findViewById.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        animationSet.start();
                    }
                }, 600L);
            }
            i = i2 + 1;
        }
    }

    private void b(final int i) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopLiveCallView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopLiveCallView.this.p.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopLiveCallView.this.p.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (i == 1) {
                    PopLiveCallView.this.a(0);
                }
            }
        }, i);
    }

    private void c(final int i) {
        LiveRoomHttpUtils.f(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopLiveCallView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopLiveCallView.this.p.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopLiveCallView.this.p.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (i == 1) {
                    PopLiveCallView.this.a(5);
                }
            }
        }, i);
    }

    private void c(final LiveFriendModel liveFriendModel) {
        if (liveFriendModel != null) {
            if (liveFriendModel.model != 5) {
                liveFriendModel.users = new ArrayList();
                LiveInviteUserModel liveInviteUserModel = new LiveInviteUserModel();
                liveInviteUserModel.name = liveFriendModel.name;
                liveInviteUserModel.avatar = liveFriendModel.avatar;
                liveFriendModel.users.add(liveInviteUserModel);
            }
            a(liveFriendModel.users);
            int i = liveFriendModel.model;
            if (i == 0) {
                this.q.setVisibility(8);
                this.j.setText(R.string.live_pk_sent_you_invitation);
                this.o.setVisibility(0);
            } else if (i == 2) {
                this.q.setVisibility(8);
                this.j.setText(R.string.live_connection_anchor_invitation);
                this.o.setVisibility(8);
            } else if (i == 5) {
                this.q.setVisibility(0);
                this.j.setText(R.string.live_connection_sent_you_invitation);
                this.o.setVisibility(0);
            }
            if (liveFriendModel.timeout == 0) {
                liveFriendModel.timeout = 20;
            }
            this.s = new CountDownTimer(liveFriendModel.timeout * 1000, 500L) { // from class: com.blued.android.module.live_china.view.PopLiveCallView.3
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    PopLiveCallView.this.u.remove(liveFriendModel);
                    PopLiveCallView.this.i();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    TextView textView = PopLiveCallView.this.l;
                    textView.setText(AppInfo.d().getString(R.string.live_invite_connect_reject) + "(" + (((j / 1000) + 1) + "") + "s)");
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (c() || this.u.size() <= 0) {
            return;
        }
        LiveFriendModel liveFriendModel = this.u.get(0);
        this.r = liveFriendModel;
        c(liveFriendModel);
        f();
    }

    private void d(final LiveFriendModel liveFriendModel) {
        LiveRoomHttpUtils.f(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopLiveCallView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 403) {
                    PopLiveCallView.this.u.remove(liveFriendModel);
                    PopLiveCallView.this.i();
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopLiveCallView.this.p.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopLiveCallView.this.p.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                PopLiveCallView.this.u.remove(liveFriendModel);
                PopLiveCallView.this.i();
            }
        }, liveFriendModel.uid);
    }

    private void e() {
        this.e = LayoutInflater.from(this.d);
        b();
        this.b = this.f15062a.findViewById(R.id.live_pk_call_layer);
        this.t = (LinearLayout) this.f15062a.findViewById(R.id.ll_invite);
        this.f15063c = this.f15062a.findViewById(R.id.content_layout);
        this.j = (TextView) this.f15062a.findViewById(R.id.live_pk_call_text);
        this.k = (TextView) this.f15062a.findViewById(R.id.live_pk_call_invite_text);
        this.o = this.f15062a.findViewById(R.id.live_pk_call_invite_layout);
        this.l = (TextView) this.f15062a.findViewById(R.id.live_pk_call_cancel);
        this.m = this.f15062a.findViewById(R.id.live_pk_call_answer);
        this.n = (ImageView) this.f15062a.findViewById(R.id.live_pk_call_invite);
        this.p = this.f15062a.findViewById(R.id.ll_loading);
        this.q = this.f15062a.findViewById(R.id.iv_connect);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.f15063c.setVisibility(8);
        this.f15063c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f15062a, -1, -1, true);
        this.f = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setFocusable(true);
        this.f.update();
    }

    private void e(LiveFriendModel liveFriendModel) {
        LiveRoomHttpUtils.g(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopLiveCallView.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 403) {
                    PopLiveCallView.this.u.clear();
                    PopLiveCallView.this.i();
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopLiveCallView.this.p.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopLiveCallView.this.p.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                PopLiveCallView.this.u.clear();
                PopLiveCallView.this.i();
            }
        }, liveFriendModel.uid);
    }

    private void f() {
        BaseFragment baseFragment = this.g;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h.O();
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i.g(4);
            LiveSetDataObserver.a().e(4);
        }
        this.b.clearAnimation();
        this.f15063c.clearAnimation();
        if (this.f.isShowing()) {
            this.f.a();
        }
        this.f.showAtLocation(this.f15063c, 81, 0, 0);
        this.f15063c.setVisibility(0);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(LiveFriendModel liveFriendModel) {
        if (liveFriendModel.model == 5) {
            LiveRoomHttpUtils.e(new CancelResponse(liveFriendModel, this.g.getFragmentActive()), liveFriendModel.uid, 1);
        } else if (liveFriendModel.model == 2) {
            LiveRoomHttpUtils.o(new CancelResponse(liveFriendModel, this.g.getFragmentActive()), liveFriendModel.uid);
        }
    }

    private void g() {
        this.f15063c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.4
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
        h();
    }

    private void g(final LiveFriendModel liveFriendModel) {
        LiveRoomInfo.a().a(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.view.PopLiveCallView.10
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                LiveMsgSendManager.a().d("开启权限");
                if (liveFriendModel.model == 5) {
                    PopLiveCallView popLiveCallView = PopLiveCallView.this;
                    LiveRoomHttpUtils.e(new CancelResponse(liveFriendModel, popLiveCallView.g.getFragmentActive()), liveFriendModel.uid, 0);
                } else if (liveFriendModel.model == 2) {
                    PopLiveCallView popLiveCallView2 = PopLiveCallView.this;
                    LiveRoomHttpUtils.p(new AcceptResponse(popLiveCallView2.g.getFragmentActive()), liveFriendModel.uid);
                }
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
                LiveMsgSendManager.a().d("关闭权限");
                PopLiveCallView popLiveCallView = PopLiveCallView.this;
                popLiveCallView.f(popLiveCallView.r);
                PopLiveCallView.this.i();
            }
        });
    }

    private void h() {
        LiveFriendModel liveFriendModel;
        if (!(this.g instanceof RecordingOnliveFragment) || (liveFriendModel = this.r) == null) {
            return;
        }
        if (liveFriendModel.model == 0) {
            if (this.h.cs) {
                this.n.setImageResource(R.drawable.live_invite_select);
            } else {
                this.n.setImageResource(R.drawable.live_invite_default);
            }
            this.k.setText(R.string.live_pk_no_invitation);
            return;
        }
        if (this.h.ct) {
            this.n.setImageResource(R.drawable.live_invite_select);
        } else {
            this.n.setImageResource(R.drawable.live_invite_default);
        }
        this.k.setText(R.string.live_connection_no_invitation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        a((ILiveConnectionAnimListener) null);
    }

    private void j() {
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void k() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f15063c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }

    private boolean l() {
        return this.p.getVisibility() == 0;
    }

    public void a() {
        this.l.performClick();
    }

    public void a(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.u.size()) {
                return;
            }
            LiveFriendModel liveFriendModel = this.u.get(i3);
            int i4 = i3;
            if (liveFriendModel.model == i) {
                this.u.remove(liveFriendModel);
                i4 = i3 - 1;
            }
            i2 = i4 + 1;
        }
    }

    public void a(LiveFriendModel liveFriendModel) {
        this.u.add(liveFriendModel);
        d();
    }

    public void b() {
        this.f15062a = this.e.inflate(R.layout.live_pk_call, (ViewGroup) null);
    }

    public void b(LiveFriendModel liveFriendModel) {
        LiveFriendModel liveFriendModel2;
        if (liveFriendModel == null || (liveFriendModel2 = this.r) == null || !TextUtils.equals(liveFriendModel2.uid, liveFriendModel.uid)) {
            return;
        }
        if (this.u.size() > 0) {
            this.u.remove(0);
        }
        this.r = null;
        i();
    }

    public boolean c() {
        return this.f15063c.getVisibility() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_call_cancel) {
            LiveFriendModel liveFriendModel = this.r;
            if (liveFriendModel != null) {
                if (liveFriendModel.model == 0) {
                    d(this.r);
                } else {
                    f(this.r);
                }
            }
        } else if (view.getId() == R.id.live_pk_call_answer) {
            LiveFriendModel liveFriendModel2 = this.r;
            if (liveFriendModel2 != null) {
                if (liveFriendModel2.model == 0) {
                    e(this.r);
                } else {
                    g(this.r);
                }
            }
        } else if (view.getId() == R.id.live_pk_call_invite && !l() && (this.g instanceof RecordingOnliveFragment)) {
            LiveFriendModel liveFriendModel3 = this.r;
            if (liveFriendModel3 != null) {
                if (liveFriendModel3.model == 0) {
                    if (this.h.cs) {
                        this.h.cs = false;
                        this.n.setImageResource(R.drawable.live_invite_default);
                        b(0);
                    } else {
                        this.h.cs = true;
                        this.n.setImageResource(R.drawable.live_invite_select);
                        b(1);
                    }
                } else if (this.h.ct) {
                    this.h.ct = false;
                    this.n.setImageResource(R.drawable.live_invite_default);
                    c(0);
                } else {
                    this.h.ct = true;
                    this.n.setImageResource(R.drawable.live_invite_select);
                    c(1);
                }
            }
            this.h.bB.v();
        }
    }
}
