package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverListView.class */
public class LiveMakeLoverListView extends FrameLayout implements View.OnClickListener {
    public RenrenPullToRefreshListView a;
    public LiveMakeFriendAdapter b;
    public boolean c;
    public View d;
    public View e;
    public View f;
    private Context g;
    private LayoutInflater h;
    private View i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private long p;
    private LiveSettingClickListener q;
    private BaseFragment r;
    private RecordingOnliveFragment s;
    private PlayingOnliveFragment t;
    private BluedUIHttpResponse u;

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverListView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverListView$2.class */
    class AnonymousClass2 implements RenrenPullToRefreshListView.OnPullDownListener {
        final /* synthetic */ LiveMakeLoverListView a;

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            this.a.a(true);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            this.a.a(false);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverListView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverListView$3.class */
    class AnonymousClass3 implements LiveMakeFriendAdapter.LiveJoinListener {
        final /* synthetic */ LiveMakeLoverListView a;

        @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
        public void a(LiveFriendModel liveFriendModel, int i) {
            if (this.a.r instanceof RecordingOnliveFragment) {
                this.a.s.dd.a(liveFriendModel.uid);
            } else if (this.a.r instanceof PlayingOnliveFragment) {
                LiveSetDataObserver.a().e(liveFriendModel.uid);
            }
        }

        @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
        public void a(LiveFriendModel liveFriendModel, int i, TextView textView) {
            this.a.a(liveFriendModel, textView);
        }

        @Override // com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter.LiveJoinListener
        public void b(LiveFriendModel liveFriendModel, int i, TextView textView) {
            this.a.b(liveFriendModel, textView);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverListView$5  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverListView$5.class */
    class AnonymousClass5 implements Animation.AnimationListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ LiveMakeLoverListView b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.a) {
                this.b.a.k();
            } else if (this.b.e.getVisibility() == 0 || this.b.d.getVisibility() == 0 || this.b.b.getCount() != 0) {
            } else {
                this.b.a.k();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverListView$LiveSettingClickListener.class */
    public interface LiveSettingClickListener {
        void a();
    }

    public LiveMakeLoverListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeLoverListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        this.o = 0;
        this.u = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverListView.4
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
                    LiveMakeLoverListView.this.d();
                } else if (LiveMakeLoverListView.this.b.getCount() == 0) {
                    LiveMakeLoverListView.this.b();
                } else {
                    LiveMakeLoverListView.this.e();
                }
                LiveMakeLoverListView.this.a.q();
                LiveMakeLoverListView.this.a.j();
                this.a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverListView.this.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    LiveMakeLoverListView.this.b.a(new ArrayList());
                } else {
                    LiveMakeLoverListView.this.b.a(bluedEntity.data);
                }
            }
        };
        this.g = context;
        h();
    }

    private void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.j.getVisibility() == 8) {
            return;
        }
        this.j.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.g, R.anim.push_bottom_out);
        this.j.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverListView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveMakeLoverListView.this.setVisibility(8);
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

    private void h() {
        LayoutInflater from = LayoutInflater.from(this.g);
        this.h = from;
        View inflate = from.inflate(R.layout.live_make_lover_list, this);
        this.i = inflate;
        this.j = inflate.findViewById(R.id.content_layout);
        this.k = this.i.findViewById(R.id.live_make_lover_list_layer);
        this.l = (TextView) this.i.findViewById(R.id.live_make_lover_list_title);
        this.m = (TextView) this.i.findViewById(R.id.live_make_lover_setting_btn);
        this.k.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    public void a() {
        if (this.n == 0) {
            this.l.setText(R.string.live_make_friend_manage);
            return;
        }
        if (this.o == 0) {
            this.l.setText(R.string.live_make_friend_apply);
            this.m.setText(R.string.live_make_friend_apply);
        } else {
            this.l.setText(R.string.live_make_friend_waiting_for);
            this.m.setText(R.string.live_make_friend_setting);
        }
        this.m.setVisibility(0);
    }

    public void a(final LiveFriendModel liveFriendModel, final TextView textView) {
        LiveRoomHttpUtils.k(new BluedUIHttpResponse(this.r.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverListView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeLoverListView.this.f.setVisibility(8);
                textView.setEnabled(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverListView.this.f.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverListView.this.b.a(liveFriendModel);
            }
        }, liveFriendModel.uid);
    }

    public void a(boolean z) {
        BaseFragment baseFragment = this.r;
        if (baseFragment instanceof RecordingOnliveFragment) {
            LiveRoomHttpUtils.a(this.u, this.s.t);
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            LiveRoomHttpUtils.a(this.u, this.t.t);
        }
    }

    public void b() {
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.a.setVisibility(8);
        this.f.setVisibility(8);
    }

    public void b(final LiveFriendModel liveFriendModel, final TextView textView) {
        LiveRoomHttpUtils.j(new BluedUIHttpResponse(this.r.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverListView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeLoverListView.this.f.setVisibility(8);
                textView.setEnabled(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverListView.this.f.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverListView.this.b.a(liveFriendModel);
            }
        }, liveFriendModel.uid);
    }

    public void c() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.a.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void d() {
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void e() {
        this.a.setVisibility(0);
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void f() {
        a((ILiveConnectionAnimListener) null);
    }

    public void g() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.r.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverListView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveMakeLoverListView.this.f.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveMakeLoverListView.this.f.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverListView.this.setState(1);
                LiveMakeLoverListView.this.a(true);
                if (LiveMakeLoverListView.this.r instanceof PlayingOnliveFragment) {
                    LiveMakeLoverListView.this.t.k.a(2);
                }
                AppMethods.d(R.string.live_make_friend_application_successful);
            }
        };
        LiveRoomHttpUtils.h(bluedUIHttpResponse, this.p + "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_lover_list_layer) {
            f();
        } else if (view.getId() == R.id.tv_live_reload) {
            a(true);
        } else if (view.getId() == R.id.live_make_lover_setting_btn) {
            if (this.o == 0) {
                g();
            } else if (this.q != null) {
                f();
                this.q.a();
            }
        }
    }

    public void setState(int i) {
        this.o = i;
        a();
    }
}
