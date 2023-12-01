package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LivePKInviteAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveInviteModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKFriendListView.class */
public class LivePKFriendListView extends FrameLayout implements View.OnClickListener {
    public RenrenPullToRefreshListView a;
    public ListView b;
    public LivePKInviteAdapter c;
    public boolean d;
    public View e;
    public View f;
    public View g;
    private Context h;
    private LayoutInflater i;
    private View j;
    private View k;
    private View l;
    private ImageView m;
    private LiveConnectionView n;
    private ILiveConnectionStateListener o;
    private int p;
    private TextView q;
    private View r;
    private TextView s;
    private ImageView t;
    private TextView u;
    private View v;
    private View w;
    private BluedUIHttpResponse x;
    private int y;

    public LivePKFriendListView(Context context) {
        this(context, null);
    }

    public LivePKFriendListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKFriendListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.p = 0;
        this.x = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.3
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
                    LivePKFriendListView.this.c();
                } else if (LivePKFriendListView.this.c.getCount() == 0) {
                    LivePKFriendListView.this.a();
                } else {
                    LivePKFriendListView.this.d();
                }
                if (LivePKFriendListView.this.d) {
                    LivePKFriendListView.this.a.o();
                } else {
                    LivePKFriendListView.this.a.p();
                }
                LivePKFriendListView.this.a.q();
                LivePKFriendListView.this.a.j();
                this.a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (LivePKFriendListView.this.p == 0) {
                    LivePKFriendListView.this.b();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> bluedEntity) {
                if (bluedEntity != null && bluedEntity.data != null && bluedEntity.data.size() > 0) {
                    if (LivePKFriendListView.this.p == 0) {
                        LivePKFriendListView.this.c.a(bluedEntity.data);
                    } else {
                        LivePKFriendListView.this.c.b(bluedEntity.data);
                    }
                }
                LivePKFriendListView.this.d = bluedEntity.hasMore();
                if (bluedEntity.extra != null) {
                    LivePKFriendListView.this.p = bluedEntity.extra.cursor;
                }
            }
        };
        this.h = context;
        l();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LiveFriendModel liveFriendModel) {
        if (liveFriendModel == null) {
            return;
        }
        LiveRoomHttpUtils.e(new BluedUIHttpResponse(this.n.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePKFriendListView.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LivePKFriendListView.this.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LivePKFriendListView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.9.1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LivePKFriendListView.this.n.a(liveFriendModel, true, 0);
                    }
                });
            }
        }, liveFriendModel.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final LiveFriendModel liveFriendModel) {
        if (liveFriendModel == null) {
            return;
        }
        LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntity<LiveInviteModel, LiveInviteModel>>(this.n.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.10
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePKFriendListView.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LivePKFriendListView.this.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(final BluedEntity<LiveInviteModel, LiveInviteModel> bluedEntity) {
                LivePKFriendListView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.10.1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        BluedEntity bluedEntity2 = bluedEntity;
                        if (bluedEntity2 != null && bluedEntity2.extra != 0) {
                            liveFriendModel.timeout = ((LiveInviteModel) bluedEntity.extra).timeout;
                        }
                        LivePKFriendListView.this.n.a(liveFriendModel, true, 1);
                    }
                });
            }
        }, liveFriendModel.uid, 0);
    }

    private void l() {
        LayoutInflater from = LayoutInflater.from(this.h);
        this.i = from;
        View inflate = from.inflate(R.layout.live_pk_friend_list, this);
        this.j = inflate;
        this.k = inflate.findViewById(R.id.content_layout);
        this.l = this.j.findViewById(R.id.live_pk_friend_list_layer);
        this.m = (ImageView) this.j.findViewById(R.id.live_pk_friend_list_back);
        this.q = (TextView) this.j.findViewById(R.id.live_pk_friend_list_title);
        this.r = this.j.findViewById(R.id.live_title_tip);
        this.t = (ImageView) this.j.findViewById(R.id.live_pk_friend_list_invite);
        this.u = (TextView) this.j.findViewById(R.id.live_pk_friend_list_invite_text);
        this.v = this.j.findViewById(R.id.full_screen_loading_view);
        View findViewById = this.j.findViewById(R.id.live_help);
        this.w = findViewById;
        findViewById.setVisibility(8);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.w.setOnClickListener(this);
    }

    private void m() {
        this.e = this.j.findViewById(R.id.ll_nodata);
        this.f = this.j.findViewById(R.id.ll_error);
        this.g = this.j.findViewById(R.id.pk_loading_view);
        this.s = (TextView) this.k.findViewById(R.id.tv_live_reload);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.j.findViewById(R.id.rptrlv_live_list);
        this.a = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        this.b = (ListView) this.a.getRefreshableView();
        this.a.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                LivePKFriendListView.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                LivePKFriendListView.this.a(false);
            }
        });
        this.b.setDivider(null);
        this.b.setSelector(new ColorDrawable(0));
        LivePKInviteAdapter livePKInviteAdapter = new LivePKInviteAdapter(this.h, new LivePKInviteAdapter.LiveInviteListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.2
            @Override // com.blued.android.module.live_china.adapter.LivePKInviteAdapter.LiveInviteListener
            public void a(LiveFriendModel liveFriendModel, int i) {
                if (LivePKFriendListView.this.y == 0) {
                    LivePKFriendListView.this.a(liveFriendModel);
                    return;
                }
                EventTrackLive.a(LiveProtos.Event.LIVE_MANY_CONNECT_PAGE_INVITE_CLICK, LiveRoomManager.a().e(), liveFriendModel.uid);
                LivePKFriendListView.this.b(liveFriendModel);
            }
        });
        this.c = livePKInviteAdapter;
        this.b.setAdapter((ListAdapter) livePKInviteAdapter);
        this.s.setOnClickListener(this);
    }

    private void setLiveConnectionStatus(int i) {
        LiveRoomHttpUtils.f(new BluedUIHttpResponse(this.n.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePKFriendListView.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LivePKFriendListView.this.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, i);
    }

    private void setLivePkStatus(int i) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse(this.n.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePKFriendListView.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LivePKFriendListView.this.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, i);
    }

    public void a() {
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.k.getVisibility() != 0) {
            setVisibility(8);
            return;
        }
        this.k.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_out);
        this.k.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivePKFriendListView.this.setVisibility(8);
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
        ILiveConnectionStateListener iLiveConnectionStateListener = this.o;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.b();
        }
    }

    public void a(LiveConnectionView liveConnectionView) {
        this.n = liveConnectionView;
        this.o = liveConnectionView;
    }

    public void a(boolean z) {
        if (z) {
            this.p = 0;
        }
        if (this.y == 0) {
            LiveRoomHttpUtils.b(this.x, this.p);
        } else {
            LiveRoomHttpUtils.e(this.x, this.p);
        }
    }

    public void a(final boolean z, int i) {
        if (this.y != i) {
            this.p = 0;
        }
        this.y = i;
        if (i == 0) {
            this.q.setText(R.string.live_pk_friend);
            this.r.setVisibility(8);
        } else {
            this.q.setText(R.string.live_anchor_connection);
            this.r.setVisibility(0);
            EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECT_PAGE_SHOW, LiveRoomManager.a().e());
        }
        this.c.a(i);
        if (z) {
            b();
            LivePKInviteAdapter livePKInviteAdapter = this.c;
            if (livePKInviteAdapter != null) {
                livePKInviteAdapter.a(new ArrayList());
            }
        }
        setVisibility(0);
        this.k.setVisibility(0);
        this.k.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_in);
        this.k.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    LivePKFriendListView.this.a.k();
                } else if (LivePKFriendListView.this.f.getVisibility() == 0 || LivePKFriendListView.this.e.getVisibility() == 0 || LivePKFriendListView.this.c.getCount() != 0) {
                } else {
                    LivePKFriendListView.this.a.k();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ILiveConnectionStateListener iLiveConnectionStateListener = this.o;
        if (iLiveConnectionStateListener != null) {
            iLiveConnectionStateListener.a();
        }
        j();
    }

    public void b() {
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void c() {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void d() {
        this.a.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.e.setVisibility(8);
    }

    public boolean e() {
        return getVisibility() == 0;
    }

    public void f() {
        if (g()) {
            return;
        }
        k();
    }

    public boolean g() {
        return this.v.getVisibility() == 0;
    }

    public void h() {
        this.v.setVisibility(0);
    }

    public void i() {
        this.v.setVisibility(8);
    }

    public void j() {
        if (this.y == 0) {
            if (this.n.a.cs) {
                this.t.setImageResource(R.drawable.live_invite_select);
            } else {
                this.t.setImageResource(R.drawable.live_invite_default);
            }
            this.u.setText(R.string.live_pk_no_invitation);
            return;
        }
        if (this.n.a.ct) {
            this.t.setImageResource(R.drawable.live_invite_select);
        } else {
            this.t.setImageResource(R.drawable.live_invite_default);
        }
        this.u.setText(R.string.live_connection_no_invitation);
    }

    public void k() {
        a((ILiveConnectionAnimListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_friend_list_layer) {
            k();
        } else if (view.getId() == R.id.live_pk_friend_list_back) {
            a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKFriendListView.6
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    if (LivePKFriendListView.this.n == null || LivePKFriendListView.this.n.a == null || !LivePKFriendListView.this.n.a.aW()) {
                        LivePKFriendListView.this.n.a(false);
                    }
                }
            });
        } else if (view.getId() == R.id.tv_live_reload) {
            a(true);
        } else if (view.getId() != R.id.live_pk_friend_list_invite) {
            if (view.getId() == R.id.live_help) {
                LiveSetDataObserver.a().b(LiveRoomInfo.a().A(), DisplayUtil.a(AppInfo.d(), 13.0f));
            }
        } else if (this.y == 0) {
            if (this.n.a.cs) {
                this.n.a.cs = false;
                this.t.setImageResource(R.drawable.live_invite_default);
                setLivePkStatus(0);
                return;
            }
            this.n.a.cs = true;
            this.t.setImageResource(R.drawable.live_invite_select);
            setLivePkStatus(1);
        } else if (this.n.a.ct) {
            this.n.a.ct = false;
            this.t.setImageResource(R.drawable.live_invite_default);
            setLiveConnectionStatus(0);
        } else {
            this.n.a.ct = true;
            this.t.setImageResource(R.drawable.live_invite_select);
            setLiveConnectionStatus(1);
        }
    }
}
