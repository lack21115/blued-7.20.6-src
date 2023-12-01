package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGroupPkUserModel;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectInviteMoreView.class */
public class LiveConnectInviteMoreView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14394a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14395c;
    private View d;
    private LinearLayout e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private View k;
    private View l;
    private LiveConnectionView m;
    private ILiveConnectionStateListener n;
    private ProgressBar o;
    private List<LiveInviteUserModel> p;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectInviteMoreView$ExitDialog.class */
    public class ExitDialog extends LiveBottomDialog {
        public ExitDialog(Context context) {
            super(context);
        }

        @Override // com.blued.android.module.live_china.view.LiveBottomDialog
        public void b() {
            setContentView(R.layout.live_multi_exit_confirm_layout);
            findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.ExitDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ExitDialog.this.dismiss();
                }
            });
            TextView textView = (TextView) findViewById(R.id.tv_exit);
            TextView textView2 = (TextView) findViewById(R.id.tv_cancel);
            boolean z = LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13;
            if (z) {
                textView.setText(AppInfo.d().getString(R.string.live_multi_pk_exit_tip));
                textView2.setText(AppInfo.d().getString(R.string.live_multi_pk_exit_cancel));
            } else {
                textView2.setText(AppInfo.d().getString(R.string.cancel));
                textView.setText(AppInfo.d().getString(R.string.live_invite_connect_exit_tip));
            }
            final boolean z2 = z;
            findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.ExitDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (z2) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXIT_POP_YES_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                    }
                    ExitDialog.this.dismiss();
                    LiveConnectInviteMoreView.this.o.setVisibility(0);
                    if (LiveRoomManager.a().m() != 12 && LiveRoomManager.a().m() != 13) {
                        LiveConnectInviteMoreView.this.e();
                        return;
                    }
                    LiveConnectInviteMoreView.this.f();
                    LiveConnectInviteMoreView.this.m.k();
                }
            });
            final boolean z3 = z;
            findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.ExitDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (z3) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXIT_POP_NO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                    }
                    ExitDialog.this.dismiss();
                }
            });
        }
    }

    public LiveConnectInviteMoreView(Context context) {
        this(context, null);
    }

    public LiveConnectInviteMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveConnectInviteMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14394a = context;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        this.l.setVisibility(8);
    }

    private void b(List<LiveInviteUserModel> list) {
        int size;
        if (list == null) {
            return;
        }
        this.e.removeAllViews();
        boolean z = LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13;
        int a2 = ((AppInfo.l - (DensityUtils.a(AppInfo.d(), 82.0f) * 4)) - (DensityUtils.a(AppInfo.d(), 15.0f) * 2)) / 3;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                LiveInviteUserModel liveInviteUserModel = list.get(i2);
                if (liveInviteUserModel == null) {
                    return;
                }
                View inflate = LayoutInflater.from(this.f14394a).inflate(R.layout.live_multi_invite_item, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_invite);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_invite);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtils.a(this.f14394a, 82.0f), -2);
                if (i2 == 3 || z) {
                    layoutParams.rightMargin = 0;
                } else {
                    layoutParams.rightMargin = a2;
                }
                this.e.addView(inflate, layoutParams);
                ImageLoader.a((IRequestHost) null, liveInviteUserModel.avatar).b(R.drawable.user_bg_round).c().a(imageView);
                textView.setText(liveInviteUserModel.name);
                i = i2 + 1;
            } else if (z || (size = 4 - list.size()) <= 0) {
                return;
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        return;
                    }
                    View inflate2 = LayoutInflater.from(this.f14394a).inflate(R.layout.live_multi_invite_item, (ViewGroup) null);
                    ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.iv_invite);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.tv_invite);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(DensityUtils.a(this.f14394a, 82.0f), -2);
                    if (i4 == 3) {
                        layoutParams2.rightMargin = 0;
                    } else {
                        layoutParams2.rightMargin = a2;
                    }
                    this.e.addView(inflate2, layoutParams2);
                    imageView2.setImageResource(R.drawable.live_multi_invite_more);
                    textView2.setText(AppInfo.d().getString(R.string.live_invite_connecting_more));
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            LiveConnectInviteMoreView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.7.1
                                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                                public void onAnimationEnd() {
                                    EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECTING_PAGE_INVITE_CLICK, LiveRoomManager.a().e());
                                    LiveConnectInviteMoreView.this.m.a(true, 1);
                                }
                            });
                        }
                    });
                    i3 = i4 + 1;
                }
            }
        }
    }

    private String getUserListString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (LiveInviteUserModel liveInviteUserModel : this.p) {
            if (liveInviteUserModel.uid != LiveRoomManager.a().g()) {
                stringBuffer.append(liveInviteUserModel.uid + ",");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    private void h() {
        LayoutInflater from = LayoutInflater.from(this.f14394a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_pk_invite_more, this);
        this.f14395c = inflate.findViewById(R.id.content_layout);
        this.d = inflate.findViewById(R.id.live_pk_invite_layer);
        this.e = (LinearLayout) inflate.findViewById(R.id.ll_invite);
        this.g = (TextView) inflate.findViewById(R.id.tv_title);
        this.h = (TextView) inflate.findViewById(R.id.live_invite_cancel);
        this.f = (LinearLayout) inflate.findViewById(R.id.ll_btn_root);
        this.i = (TextView) inflate.findViewById(R.id.live_btm_tip);
        this.o = (ProgressBar) findViewById(R.id.ll_loading);
        this.j = inflate.findViewById(R.id.fl_invite_pk_root);
        this.k = inflate.findViewById(R.id.live_invite_pk);
        this.l = inflate.findViewById(R.id.view_dot);
        findViewById(R.id.fl_main).setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void i() {
        List<LiveInviteUserModel> list = this.p;
        if (list != null) {
            b(list);
        }
    }

    public void a() {
        a((ILiveConnectionAnimListener) null);
    }

    public void a(ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.f14395c.getVisibility() != 0) {
            setVisibility(8);
        } else {
            this.f14395c.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f14394a, R.anim.push_bottom_out);
            this.f14395c.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LiveConnectInviteMoreView.this.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
        if (iLiveConnectionAnimListener != null) {
            iLiveConnectionAnimListener.onAnimationEnd();
        }
        ILiveConnectionStateListener iLiveConnectionStateListener = this.n;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    public void a(LiveConnectionView liveConnectionView) {
        this.m = liveConnectionView;
        this.n = liveConnectionView;
        if (!LiveRoomPreferences.Q() || this.m == null) {
            return;
        }
        this.l.setVisibility(0);
        LiveEventBus.get(LiveEventBusUtil.D, Integer.class).observe(this.m.f14428a, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectInviteMoreView$IBNj-3pGjN6_zYUfhqrgUqKns58
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveConnectInviteMoreView.this.a((Integer) obj);
            }
        });
    }

    public void a(List<LiveInviteUserModel> list) {
        EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECTING_PAGE_SHOW, LiveRoomManager.a().e());
        this.p = list;
        setVisibility(0);
        this.f14395c.setVisibility(0);
        this.f14395c.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f14394a, R.anim.push_bottom_in);
        this.f14395c.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.1
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
        ILiveConnectionStateListener iLiveConnectionStateListener = this.n;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.a();
        }
        i();
        this.d.setVisibility(0);
        int i = (list == null || list.size() <= 0 || list.get(0) == null) ? 0 : list.get(0).status;
        if (LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXIT_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            this.g.setText(AppInfo.d().getString(R.string.live_multi_pking));
            this.h.setText(AppInfo.d().getString(i == 2 ? R.string.live_multi_pk_end_exit : R.string.live_multi_pk_exit));
            this.i.setText(AppInfo.d().getString(i == 2 ? R.string.live_invite_pk_end_tip : R.string.live_invite_pking_tip));
            this.i.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.bottomMargin = DisplayUtil.a(this.f14394a, 6.5f);
            this.f.setLayoutParams(layoutParams);
            this.h.setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_START_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        EventTrackLive.v(LiveProtos.Event.LIVE_PK_MORE_START_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), getUserListString());
        this.g.setText(AppInfo.d().getString(R.string.live_invite_connecting));
        this.h.setText(AppInfo.d().getString(R.string.live_invite_connect_exit));
        this.i.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.bottomMargin = DisplayUtil.a(this.f14394a, 14.0f);
        this.f.setLayoutParams(layoutParams2);
        this.h.setVisibility(0);
        this.j.setVisibility(0);
    }

    public boolean b() {
        return this.f14395c.getVisibility() == 0;
    }

    public void c() {
        LiveRoomHttpUtils.r(new BluedUIHttpResponse(this.m.f14428a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectInviteMoreView.this.o.setVisibility(8);
                LiveConnectInviteMoreView.this.a((ILiveConnectionAnimListener) null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        });
    }

    public void d() {
        LiveRoomHttpUtils.a(1, (List<LiveGroupPkUserModel>) null, new BluedUIHttpResponse(this.m.f14428a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectInviteMoreView.this.o.setVisibility(8);
                LiveConnectInviteMoreView.this.a((ILiveConnectionAnimListener) null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, this.m.f14428a.getFragmentActive());
    }

    public void e() {
        LiveRoomHttpUtils.q(new BluedUIHttpResponse(this.m.f14428a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectInviteMoreView.this.o.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveConnectInviteMoreView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.5.1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        if (LiveConnectInviteMoreView.this.m != null) {
                            LiveConnectInviteMoreView.this.m.t();
                        }
                    }
                });
            }
        });
    }

    public void f() {
        LiveRoomHttpUtils.a("1", new BluedUIHttpResponse(this.m.f14428a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectInviteMoreView.this.o.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveConnectInviteMoreView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LiveConnectInviteMoreView.6.1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        if (LiveConnectInviteMoreView.this.m != null) {
                            LiveConnectInviteMoreView.this.m.t();
                        }
                    }
                });
            }
        });
    }

    public void g() {
        new ExitDialog(this.f14394a).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_invite_layer) {
            a((ILiveConnectionAnimListener) null);
        } else if (view.getId() == R.id.live_invite_cancel) {
            if (LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXIT_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            } else {
                EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECTING_PAGE_EXIT_CLICK, LiveRoomManager.a().e());
            }
            g();
        } else if (view.getId() == R.id.live_invite_pk) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_START_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            EventTrackLive.v(LiveProtos.Event.LIVE_PK_MORE_START_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), getUserListString());
            this.o.setVisibility(0);
            if (this.p.size() == 2) {
                c();
            } else if (this.p.size() > 2) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
