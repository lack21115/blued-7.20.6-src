package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendSettingView.class */
public class LiveMakeFriendSettingView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f14527a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f14528c;
    public Context d;
    public LayoutInflater e;
    private MyPopupWindow f;
    private LinearLayout g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private int k;
    private BaseFragment l;
    private long m;
    private boolean n = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendSettingView$MyPopupWindow.class */
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
                LiveMakeFriendSettingView.this.f();
            } catch (Exception e) {
                a();
            }
        }
    }

    public LiveMakeFriendSettingView(BaseFragment baseFragment, long j) {
        this.d = baseFragment.getContext();
        this.l = baseFragment;
        this.m = j;
        h();
    }

    private void h() {
        this.e = LayoutInflater.from(this.d);
        d();
        this.b = this.f14527a.findViewById(R.id.live_make_friend_setting_layer);
        this.f14528c = (FrameLayout) this.f14527a.findViewById(R.id.content_layout);
        this.g = (LinearLayout) this.f14527a.findViewById(R.id.ll_loading);
        this.h = (ImageView) this.f14527a.findViewById(R.id.live_make_friend_setting_header);
        this.i = (TextView) this.f14527a.findViewById(R.id.live_make_friend_setting_btn);
        TextView textView = (TextView) this.f14527a.findViewById(R.id.live_make_friend_camera_btn);
        this.j = textView;
        if (this.n) {
            textView.setText(R.string.live_make_friend_close_camera);
        } else {
            textView.setText(R.string.live_make_friend_open_camera);
        }
        ImageLoader.a((IRequestHost) null, LiveRoomInfo.a().d()).b(R.drawable.user_bg_round).c().a(this.h);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMakeFriendSettingView.this.f();
            }
        });
        this.f14528c.setVisibility(8);
        this.f14528c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f14527a, -1, -1, true);
        this.f = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setFocusable(true);
        this.f.update();
    }

    private void i() {
        this.f14528c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.3
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

    private void j() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f14528c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.l.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendSettingView.this.g.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendSettingView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendSettingView.this.f();
                if (LiveMakeFriendSettingView.this.l instanceof PlayingOnliveFragment) {
                    ((PlayingOnliveFragment) LiveMakeFriendSettingView.this.l).k.a(1);
                    ((PlayingOnliveFragment) LiveMakeFriendSettingView.this.l).cb.setState(0);
                }
                AppMethods.d(R.string.live_make_friend_successful_cancellation);
            }
        };
        LiveRoomHttpUtils.i(bluedUIHttpResponse, this.m + "");
    }

    public void a(int i) {
        this.k = i;
        if (i == 0) {
            this.i.setText(R.string.live_make_friend_cancel_apply);
        } else if (i == 1) {
            this.i.setText(R.string.live_make_friend_out);
        } else if (i != 2) {
        } else {
            this.i.setVisibility(8);
        }
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.f14528c.getVisibility() == 8) {
            return;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.4
            @Override // java.lang.Runnable
            public void run() {
                LiveMakeFriendSettingView.this.f.a();
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }
        }, 320L);
        j();
        this.f14528c.setVisibility(8);
    }

    public boolean a() {
        Logger.a("pk", "isCameraOpen = " + this.n);
        return this.n;
    }

    public void b() {
        this.n = true;
        this.j.setText(R.string.live_make_friend_close_camera);
        Logger.a("pk", "openCamera当前为开启摄像头");
    }

    public void c() {
        this.n = false;
        this.j.setText(R.string.live_make_friend_open_camera);
        Logger.a("pk", "closeCamera当前为关闭摄像头");
    }

    public void d() {
        this.f14527a = this.e.inflate(R.layout.live_make_friend_setting, (ViewGroup) null);
    }

    public void e() {
        this.b.clearAnimation();
        this.f14528c.clearAnimation();
        if (this.f.isShowing()) {
            this.f.a();
        }
        this.f.showAtLocation(this.f14528c, 81, 0, 0);
        this.f14528c.setVisibility(0);
        i();
    }

    public void f() {
        a((ILiveConnectionAnimListener) null);
    }

    public void g() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.l.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendSettingView.this.g.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendSettingView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendSettingView.this.f();
                if (LiveMakeFriendSettingView.this.l instanceof PlayingOnliveFragment) {
                    ((PlayingOnliveFragment) LiveMakeFriendSettingView.this.l).X();
                }
                AppMethods.d(R.string.live_make_friend_exit_successfully);
            }
        };
        LiveRoomHttpUtils.b(bluedUIHttpResponse, this.m + "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_friend_setting_btn) {
            if (this.k == 0) {
                Context context = this.d;
                CommonAlertDialog.a(context, "", context.getString(R.string.live_make_friend_cancellation_application), this.d.getResources().getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        LiveMakeFriendSettingView.this.k();
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            }
            Context context2 = this.d;
            CommonAlertDialog.a(context2, "", context2.getString(R.string.live_make_friend_out_tips), this.d.getResources().getString(R.string.filter_off), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendSettingView.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LiveMakeFriendSettingView.this.g();
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (view.getId() == R.id.live_make_friend_camera_btn) {
            f();
            BaseFragment baseFragment = this.l;
            if (baseFragment instanceof PlayingOnliveFragment) {
                if (this.n) {
                    if (((PlayingOnliveFragment) baseFragment).aB()) {
                        ((PlayingOnliveFragment) this.l).aX();
                    } else {
                        c();
                    }
                } else if (((PlayingOnliveFragment) baseFragment).aB()) {
                    ((PlayingOnliveFragment) this.l).aY();
                } else {
                    b();
                }
            }
            BaseFragment baseFragment2 = this.l;
            if (baseFragment2 instanceof RecordingOnliveFragment) {
                if (this.n) {
                    ((RecordingOnliveFragment) baseFragment2).az();
                } else {
                    ((RecordingOnliveFragment) baseFragment2).aA();
                }
            }
        }
    }
}
