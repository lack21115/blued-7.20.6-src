package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendListView.class */
public class LiveMakeFriendListView extends FrameLayout implements View.OnClickListener {
    public RenrenPullToRefreshListView a;
    public ListView b;
    public LiveMakeFriendAdapter c;
    public boolean d;
    public View e;
    public View f;
    public View g;
    private Context h;
    private LayoutInflater i;
    private View j;
    private View k;
    private View l;
    private TextView m;
    private TextView n;
    private TextView o;
    private int p;
    private int q;
    private long r;
    private LiveSettingClickListener s;
    private BaseFragment t;
    private RecordingOnliveFragment u;
    private PlayingOnliveFragment v;
    private BluedUIHttpResponse w;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendListView$LiveSettingClickListener.class */
    public interface LiveSettingClickListener {
        void a();
    }

    public LiveMakeFriendListView(Context context) {
        this(context, null);
    }

    public LiveMakeFriendListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeFriendListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.q = 0;
        this.w = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.4
            boolean a = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                this.a = true;
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.a) {
                    LiveMakeFriendListView.this.f();
                } else if (LiveMakeFriendListView.this.c.getCount() == 0) {
                    LiveMakeFriendListView.this.d();
                } else {
                    LiveMakeFriendListView.this.g();
                }
                LiveMakeFriendListView.this.a.q();
                LiveMakeFriendListView.this.a.j();
                this.a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendListView.this.e();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    LiveMakeFriendListView.this.c.a(new ArrayList());
                } else {
                    LiveMakeFriendListView.this.c.a(bluedEntity.data);
                }
            }
        };
        this.h = context;
        j();
    }

    private void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.k.getVisibility() == 8) {
            return;
        }
        this.k.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_out);
        this.k.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveMakeFriendListView.this.setVisibility(8);
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

    private void j() {
        LayoutInflater from = LayoutInflater.from(this.h);
        this.i = from;
        View inflate = from.inflate(R.layout.live_make_friend_list, this);
        this.j = inflate;
        this.k = inflate.findViewById(R.id.content_layout);
        this.l = this.j.findViewById(R.id.live_make_friend_list_layer);
        this.m = (TextView) this.j.findViewById(R.id.live_make_friend_list_title);
        this.o = (TextView) this.j.findViewById(R.id.live_make_friend_setting_btn);
        this.l.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void k() {
        this.e = this.j.findViewById(R.id.ll_nodata);
        this.f = this.j.findViewById(R.id.ll_error);
        this.g = this.j.findViewById(R.id.live_make_friend_loading_view);
        this.n = (TextView) this.k.findViewById(R.id.tv_live_reload);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.j.findViewById(R.id.rptrlv_live_list);
        this.a = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        this.a.p();
        this.b = (ListView) this.a.getRefreshableView();
        this.a.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                LiveMakeFriendListView.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                LiveMakeFriendListView.this.a(false);
            }
        });
        this.b.setDivider(null);
        this.b.setSelector(new ColorDrawable(0));
        LiveMakeFriendAdapter liveMakeFriendAdapter = new LiveMakeFriendAdapter(this.h, new LiveMakeFriendAdapter.LiveJoinListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.3
            @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
            public void a(LiveFriendModel liveFriendModel, int i) {
                if (LiveMakeFriendListView.this.t instanceof RecordingOnliveFragment) {
                    LiveMakeFriendListView.this.u.dd.a(liveFriendModel.uid);
                } else if (LiveMakeFriendListView.this.t instanceof PlayingOnliveFragment) {
                    LiveSetDataObserver.a().e(liveFriendModel.uid);
                }
            }

            @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
            public void a(LiveFriendModel liveFriendModel, int i, TextView textView) {
                LiveMakeFriendListView.this.a(liveFriendModel, textView);
            }

            @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
            public void b(LiveFriendModel liveFriendModel, int i, TextView textView) {
                LiveMakeFriendListView.this.b(liveFriendModel, textView);
            }
        }, this.p, this.b);
        this.c = liveMakeFriendAdapter;
        this.b.setAdapter((ListAdapter) liveMakeFriendAdapter);
        this.n.setOnClickListener(this);
    }

    public void a() {
        if (this.p == 0) {
            this.m.setText(R.string.live_make_friend_manage);
            return;
        }
        if (this.q == 0) {
            this.m.setText(R.string.live_make_friend_apply);
            this.o.setText(R.string.live_make_friend_apply);
        } else {
            this.m.setText(R.string.live_make_friend_waiting_for);
            this.o.setText(R.string.live_make_friend_setting);
        }
        this.o.setVisibility(0);
    }

    public void a(int i, LiveSettingClickListener liveSettingClickListener, long j, BaseFragment baseFragment) {
        this.p = i;
        this.s = liveSettingClickListener;
        this.r = j;
        this.t = baseFragment;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.u = (RecordingOnliveFragment) baseFragment;
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            this.v = (PlayingOnliveFragment) baseFragment;
        }
        k();
        a();
    }

    public void a(final LiveFriendModel liveFriendModel, final TextView textView) {
        LiveRoomHttpUtils.k(new BluedUIHttpResponse(this.t.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendListView.this.g.setVisibility(8);
                textView.setEnabled(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendListView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendListView.this.c.a(liveFriendModel);
            }
        }, liveFriendModel.uid);
    }

    public void a(boolean z) {
        BaseFragment baseFragment = this.t;
        if (baseFragment instanceof RecordingOnliveFragment) {
            LiveRoomHttpUtils.a(this.w, this.u.t);
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            LiveRoomHttpUtils.a(this.w, this.v.t);
        }
    }

    public void b() {
        h();
    }

    public void b(final LiveFriendModel liveFriendModel, final TextView textView) {
        LiveRoomHttpUtils.j(new BluedUIHttpResponse(this.t.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendListView.this.g.setVisibility(8);
                textView.setEnabled(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendListView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendListView.this.c.a(liveFriendModel);
            }
        }, liveFriendModel.uid);
    }

    public void b(final boolean z) {
        setVisibility(0);
        this.k.setVisibility(0);
        this.k.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_in);
        this.k.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    LiveMakeFriendListView.this.a.k();
                } else if (LiveMakeFriendListView.this.f.getVisibility() == 0 || LiveMakeFriendListView.this.e.getVisibility() == 0 || LiveMakeFriendListView.this.c.getCount() != 0) {
                } else {
                    LiveMakeFriendListView.this.a.k();
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

    public boolean c() {
        return this.k.getVisibility() == 0;
    }

    public void d() {
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void e() {
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void f() {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void g() {
        this.a.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void h() {
        a((ILiveConnectionAnimListener) null);
    }

    public void i() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.t.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeFriendListView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeFriendListView.this.g.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeFriendListView.this.g.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeFriendListView.this.setState(1);
                LiveMakeFriendListView.this.a(true);
                if (LiveMakeFriendListView.this.t instanceof PlayingOnliveFragment) {
                    LiveMakeFriendListView.this.v.k.a(2);
                }
                AppMethods.d(R.string.live_make_friend_application_successful);
            }
        };
        LiveRoomHttpUtils.h(bluedUIHttpResponse, this.r + "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_friend_list_layer) {
            h();
        } else if (view.getId() == R.id.tv_live_reload) {
            a(true);
        } else if (view.getId() == R.id.live_make_friend_setting_btn) {
            if (this.q == 0) {
                i();
            } else if (this.s != null) {
                h();
                this.s.a();
            }
        }
    }

    public void setState(int i) {
        this.q = i;
        a();
    }
}
