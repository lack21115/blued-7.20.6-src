package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView.class */
public class LiveMakeLoverStartView implements View.OnClickListener {
    public View a;
    public View b;
    public Context c;
    private MyPopupWindow d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private CountDownTimer h;
    private PlayingOnliveFragment i;

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverStartView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverStartView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverStartView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$3.class */
    class AnonymousClass3 extends CountDownTimer {
        final /* synthetic */ LiveMakeLoverStartView a;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.a.e();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            TextView textView = this.a.f;
            textView.setText(((j / 1000) + 1) + "S");
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverStartView$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$4.class */
    class AnonymousClass4 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverStartView$7  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$7.class */
    public class AnonymousClass7 implements PermissionCallbacks {
        AnonymousClass7() {
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void U_() {
            LiveMsgSendManager.a().d("开启权限");
            LiveMakeLoverStartView.this.a();
            BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(LiveMakeLoverStartView.this.i.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverStartView.7.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i, String str) {
                    super.onFailure(th, i, str);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverStartView.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveMakeLoverStartView.this.g.setEnabled(true);
                            LiveMakeLoverStartView.this.i.cb.setState(0);
                            LiveMakeLoverStartView.this.i.k.a(1);
                        }
                    });
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    LiveMakeLoverStartView.this.e.setVisibility(8);
                    LiveMakeLoverStartView.this.b();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    LiveMakeLoverStartView.this.e.setVisibility(0);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> bluedEntity) {
                }
            };
            LiveRoomHttpUtils.l(bluedUIHttpResponse, LiveMakeLoverStartView.this.i.t + "");
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void a(String[] strArr) {
            LiveMsgSendManager.a().d("关闭权限");
            LiveMakeLoverStartView.this.b();
            LiveMakeLoverStartView.this.d();
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverStartView$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        final /* synthetic */ LiveMakeLoverStartView a;

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                this.a.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    private void c() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_bottom_out));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.i.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverStartView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeLoverStartView.this.e.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverStartView.this.e.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverStartView.this.b();
                LiveMakeLoverStartView.this.a();
                LiveMakeLoverStartView.this.i.k.a(1);
                LiveMakeLoverStartView.this.i.cb.setState(0);
            }
        };
        LiveRoomHttpUtils.m(bluedUIHttpResponse, this.i.t + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        LiveRoomInfo.a().a(new AnonymousClass7());
    }

    public void a() {
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverStartView.5
            @Override // java.lang.Runnable
            public void run() {
                LiveMakeLoverStartView.this.d.a();
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }
        }, 320L);
        c();
        this.b.setVisibility(8);
    }

    public void b() {
        a((ILiveConnectionAnimListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_lover_start_cancel) {
            d();
        } else if (view.getId() == R.id.live_make_lover_start_now) {
            this.g.setEnabled(false);
            e();
        }
    }
}
