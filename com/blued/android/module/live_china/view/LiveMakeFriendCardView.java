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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendCardView.class */
public class LiveMakeFriendCardView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f14502a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f14503c;
    public Context d;
    public LayoutInflater e;
    private MyPopupWindow f;
    private BaseFragment g;
    private RecordingOnliveFragment h;
    private PlayingOnliveFragment i;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private TextView p;
    private LiveFriendModel q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendCardView$MyPopupWindow.class */
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
                LiveMakeFriendCardView.this.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    public LiveMakeFriendCardView(BaseFragment baseFragment) {
        this.g = baseFragment;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h = (RecordingOnliveFragment) baseFragment;
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i = (PlayingOnliveFragment) baseFragment;
        }
        this.d = baseFragment.getContext();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveFriendModel liveFriendModel) {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendCardView.this.j.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendCardView.this.j.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendCardView.this.b();
            }
        }, "", liveFriendModel.uid);
    }

    private void b(LiveFriendModel liveFriendModel, int i) {
        ImageLoader.a((IRequestHost) null, liveFriendModel.avatar).b(R.drawable.user_bg_round).c().a(this.k);
        this.l.setText(liveFriendModel.name);
        if (liveFriendModel.voice == 1) {
            this.m.setText(R.string.live_make_friend_close_mic);
        } else {
            this.m.setText(R.string.live_make_friend_open_mic);
        }
        if (i == 0) {
            this.o.setImageResource(R.drawable.live_make_friend_no1);
        } else if (i == 1) {
            this.o.setImageResource(R.drawable.live_make_friend_no2);
        } else if (i != 2) {
        } else {
            this.o.setImageResource(R.drawable.live_make_friend_no3);
        }
    }

    private void c() {
        this.e = LayoutInflater.from(this.d);
        a();
        this.b = this.f14502a.findViewById(R.id.live_make_friend_card_layer);
        this.f14503c = (FrameLayout) this.f14502a.findViewById(R.id.content_layout);
        this.k = (ImageView) this.f14502a.findViewById(R.id.live_make_friend_card_header);
        this.l = (TextView) this.f14502a.findViewById(R.id.live_make_friend_card_name);
        this.m = (TextView) this.f14502a.findViewById(R.id.live_make_friend_card_mic);
        this.n = (TextView) this.f14502a.findViewById(R.id.live_make_friend_card_out);
        this.o = (ImageView) this.f14502a.findViewById(R.id.live_make_friend_card_num);
        this.p = (TextView) this.f14502a.findViewById(R.id.live_make_friend_card_btn);
        this.j = (LinearLayout) this.f14502a.findViewById(R.id.ll_loading);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMakeFriendCardView.this.b();
            }
        });
        this.f14503c.setVisibility(8);
        this.f14503c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f14502a, -1, -1, true);
        this.f = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
        this.f.setTouchable(true);
        this.f.setOutsideTouchable(true);
        this.f.setFocusable(true);
        this.f.update();
    }

    private void c(final LiveFriendModel liveFriendModel, final int i) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendCardView.this.j.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendCardView.this.j.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                int i2 = i;
                if (i2 == 0) {
                    LiveMakeFriendCardView.this.m.setText(R.string.live_make_friend_open_mic);
                } else if (i2 == 1) {
                    LiveMakeFriendCardView.this.m.setText(R.string.live_make_friend_close_mic);
                }
                liveFriendModel.voice = i;
            }
        }, liveFriendModel.uid, i);
    }

    private void d() {
        this.f14503c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.3
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

    private void e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f14503c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }

    public void a() {
        this.f14502a = this.e.inflate(R.layout.live_make_friend_card, (ViewGroup) null);
    }

    public void a(LiveFriendModel liveFriendModel, int i) {
        this.q = liveFriendModel;
        this.r = i;
        b(liveFriendModel, i);
        BaseFragment baseFragment = this.g;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h.O();
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i.g(4);
            LiveSetDataObserver.a().e(4);
        }
        this.b.clearAnimation();
        this.f14503c.clearAnimation();
        if (this.f.isShowing()) {
            this.f.a();
        }
        this.f.showAtLocation(this.f14503c, 81, 0, 0);
        this.f14503c.setVisibility(0);
        d();
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        BaseFragment baseFragment = this.g;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.h.P();
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.i.g(0);
            LiveSetDataObserver.a().e(0);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.4
            @Override // java.lang.Runnable
            public void run() {
                LiveMakeFriendCardView.this.f.a();
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }
        }, 320L);
        e();
        this.f14503c.setVisibility(8);
    }

    public void b() {
        a((ILiveConnectionAnimListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_friend_card_mic) {
            if (this.q.voice == 1) {
                c(this.q, 0);
            } else {
                c(this.q, 1);
            }
        } else if (view.getId() == R.id.live_make_friend_card_out) {
            Context context = this.d;
            CommonAlertDialog.a(context, null, "", context.getString(R.string.live_make_friend_offline_audience), null, null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendCardView.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LiveMakeFriendCardView liveMakeFriendCardView = LiveMakeFriendCardView.this;
                    liveMakeFriendCardView.a(liveMakeFriendCardView.q);
                }
            }, null, null, false, false);
        } else if (view.getId() == R.id.live_make_friend_card_btn) {
            b();
            if (this.g instanceof RecordingOnliveFragment) {
                this.h.dd.a(this.q.uid);
            }
        }
    }
}
