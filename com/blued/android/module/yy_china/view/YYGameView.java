package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.IPunishClickListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGamePrizeModel;
import com.blued.android.module.yy_china.model.YYGameTimerEvent;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRewardModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYCaptainGiftView;
import com.blued.android.module.yy_china.view.YYWishListView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGameView.class */
public class YYGameView extends RelativeLayout implements View.OnClickListener {
    private ImageView A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private ImageView H;
    private TextView I;
    private LinearLayout J;
    private RelativeLayout K;
    private RelativeLayout L;
    private ShapeTextView M;
    private ShapeFrameLayout N;
    private CardView O;
    private TextView P;
    private ShapeFrameLayout Q;
    private CardView R;
    private TextView S;
    private YYRoomModel T;
    private String U;

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18172a;
    private PopupWindow b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeTextView f18173c;
    private TextView d;
    private ShapeTextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ShapeFrameLayout i;
    private RelativeLayout j;
    private RelativeLayout k;
    private RelativeLayout l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RelativeLayout o;
    private RelativeLayout p;
    private LinearLayout q;
    private ShapeTextView r;
    private LinearLayout s;
    private ImageView t;
    private TextView u;
    private LinearLayout v;
    private ImageView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public YYGameView(Context context) {
        super(context);
        d();
    }

    public YYGameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public YYGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        this.F.setText(str);
        YYRoomModel yYRoomModel = this.T;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.m(yYRoomModel.room_id, str2, getCommonResponse(), this.f18172a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        this.s.setVisibility(0);
        this.s.setBackgroundResource(z ? R.drawable.icon_yy_left_increase_bg : R.drawable.icon_yy_left_decrease_bg);
        this.t.setImageResource(z ? R.drawable.icon_yy_active_increase : R.drawable.icon_yy_active_decrease);
        TextView textView = this.u;
        String string = getResources().getString(R.string.yy_game_active);
        textView.setText(String.format(string, str + "%"));
    }

    private void b(boolean z) {
        this.P.setVisibility(z ? 0 : 8);
        this.O.setVisibility(z ? 8 : 0);
        ShapeHelper.b(this.N, z ? R.color.transparent : R.color.syc_dark_b);
        this.S.setVisibility(z ? 0 : 8);
        CardView cardView = this.R;
        int i = 0;
        if (z) {
            i = 8;
        }
        cardView.setVisibility(i);
        ShapeHelper.b(this.Q, z ? R.color.transparent : R.color.syc_dark_b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, String str) {
        this.v.setVisibility(0);
        this.v.setBackgroundResource(z ? R.drawable.icon_yy_right_increase_bg : R.drawable.icon_yy_right_decrease_bg);
        this.w.setImageResource(z ? R.drawable.icon_yy_active_increase : R.drawable.icon_yy_active_decrease);
        TextView textView = this.x;
        String string = getResources().getString(R.string.yy_game_active);
        textView.setText(String.format(string, str + "%"));
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_game_layout, (ViewGroup) this, true);
        this.f18173c = (ShapeTextView) findViewById(R.id.tv_start);
        this.i = (ShapeFrameLayout) findViewById(R.id.set_game_view);
        this.d = (TextView) findViewById(R.id.tv_game_nostart);
        this.f = (TextView) findViewById(R.id.tv_game_gift);
        this.e = (ShapeTextView) findViewById(R.id.tv_set);
        this.g = (TextView) findViewById(R.id.tv_game_step);
        this.h = (TextView) findViewById(R.id.tv_game_time);
        this.G = (TextView) findViewById(R.id.tv_winner);
        this.H = (ImageView) findViewById(R.id.iv_win_team);
        this.I = (TextView) findViewById(R.id.tv_win_score);
        this.J = (LinearLayout) findViewById(R.id.ll_win_background);
        this.p = (RelativeLayout) findViewById(R.id.rl_campigning_captain);
        this.q = (LinearLayout) findViewById(R.id.ll_uncampign_captain);
        this.r = (ShapeTextView) findViewById(R.id.tv_campign_captain);
        this.y = (TextView) findViewById(R.id.tv_team_one_value);
        this.z = (TextView) findViewById(R.id.tv_team_two_value);
        this.A = (ImageView) findViewById(R.id.iv_left_captain);
        this.B = (ImageView) findViewById(R.id.iv_right_captain);
        this.C = (TextView) findViewById(R.id.tv_left_captain_name);
        this.D = (TextView) findViewById(R.id.tv_right_captain_name);
        this.s = (LinearLayout) findViewById(R.id.ll_left_active);
        this.t = (ImageView) findViewById(R.id.iv_left_active);
        this.u = (TextView) findViewById(R.id.tv_left_active);
        this.v = (LinearLayout) findViewById(R.id.ll_right_active);
        this.w = (ImageView) findViewById(R.id.iv_right_active);
        this.x = (TextView) findViewById(R.id.tv_right_active);
        this.j = (RelativeLayout) findViewById(R.id.fl_set_layout);
        this.k = (RelativeLayout) findViewById(R.id.rl_playing_layout);
        this.l = (RelativeLayout) findViewById(R.id.rl_game_over);
        this.m = (RelativeLayout) findViewById(R.id.rl_start_game);
        this.n = (RelativeLayout) findViewById(R.id.rl_game_waitting);
        this.o = (RelativeLayout) findViewById(R.id.rl_victory_team);
        this.F = (TextView) findViewById(R.id.tv_game_name);
        this.E = (ImageView) findViewById(R.id.iv_victory_img);
        this.K = (RelativeLayout) findViewById(R.id.fl_right_team);
        this.L = (RelativeLayout) findViewById(R.id.fl_left_team);
        this.M = (ShapeTextView) findViewById(R.id.reset_game);
        this.N = (ShapeFrameLayout) findViewById(R.id.fl_left_user);
        this.O = (CardView) findViewById(R.id.cv_left_captain);
        this.P = (TextView) findViewById(R.id.tv_left_seat_empty);
        this.Q = (ShapeFrameLayout) findViewById(R.id.fl_right_user);
        this.R = (CardView) findViewById(R.id.cv_right_captain);
        this.S = (TextView) findViewById(R.id.tv_right_seat_empty);
        this.e.setOnClickListener(this);
        this.f18173c.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.M.setOnClickListener(this);
    }

    private void e() {
        YYCaptainGiftView yYCaptainGiftView = new YYCaptainGiftView(getContext());
        yYCaptainGiftView.a(this.f18172a, new YYCaptainGiftView.OnJoinListener() { // from class: com.blued.android.module.yy_china.view.YYGameView.3
            @Override // com.blued.android.module.yy_china.view.YYCaptainGiftView.OnJoinListener
            public void a() {
                YYGameView.this.a(true);
            }
        });
        this.f18172a.a(yYCaptainGiftView, -2);
    }

    private void f() {
        YYWishListView yYWishListView = new YYWishListView(getContext());
        yYWishListView.a(this.f18172a, (Set<String>) null);
        yYWishListView.setOkListener(new YYWishListView.OnConfirmListener() { // from class: com.blued.android.module.yy_china.view.YYGameView.4
            @Override // com.blued.android.module.yy_china.view.YYWishListView.OnConfirmListener
            public void a(YYGiftModel yYGiftModel, int i) {
                if (yYGiftModel == null) {
                    return;
                }
                YYGameView.this.U = yYGiftModel.goods_id;
                YYGameView.this.e.setVisibility(8);
                YYGameView.this.f18173c.setVisibility(0);
                YYGameView.this.f.setVisibility(0);
                TextView textView = YYGameView.this.f;
                textView.setText("游戏礼物：" + yYGiftModel.name + " " + yYGiftModel.beans + YYGameView.this.getContext().getString(R.string.yy_gift_beans));
                YYGameView.this.b.dismiss();
            }
        });
        this.b = new PopupwindowFactory.Builder(getContext()).a(yYWishListView).a(80).c(-2).b(-1).d(R.color.transparent).h();
    }

    private void g() {
        if (this.T == null || TextUtils.isEmpty(this.U)) {
            return;
        }
        EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_GAME_START_CLICK, this.T.room_id);
        YYRoomHttpUtils.k(this.T.room_id, this.U, (BluedUIHttpResponse) getCommonResponse(), (IRequestHost) this.f18172a.getFragmentActive());
    }

    private BluedUIHttpResponse<BluedEntityA<Object>> getCommonResponse() {
        return new BluedUIHttpResponse<BluedEntityA<Object>>(this.f18172a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGameView.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        };
    }

    private void getGamePrize() {
        YYRoomModel yYRoomModel = this.T;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.L(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYGamePrizeModel>>(this.f18172a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGameView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGamePrizeModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                LogUtils.d("prize", "1");
                YYGamePrizeModel singleData = bluedEntityA.getSingleData();
                if (singleData == null) {
                    return;
                }
                LogUtils.d("prize", "2");
                if (singleData.display == 0) {
                    return;
                }
                LogUtils.d("prize", "3");
                YYGiftModel yYGiftModel = singleData.goods;
                if (yYGiftModel == null) {
                    return;
                }
                LogUtils.d("prize", "4");
                YYGameRewardView yYGameRewardView = new YYGameRewardView(YYGameView.this.getContext());
                yYGameRewardView.a(YYGameView.this.f18172a, singleData.victory, yYGiftModel.images_static, yYGiftModel.name);
                YYGameView.this.f18172a.a((View) yYGameRewardView, DensityUtils.a(YYGameView.this.getContext(), 300.0f), -2, 17, false);
            }
        }, this.f18172a.getFragmentActive());
    }

    private void h() {
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    private void i() {
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        this.l.setVisibility(8);
    }

    private void j() {
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void a() {
        this.U = "";
        b(true);
        ImageLoader.a(this.f18172a.getFragmentActive(), "").b(R.drawable.user_bg_round).a(this.A);
        this.C.setText(getResources().getString(R.string.yy_game_electioning));
        ImageLoader.a(this.f18172a.getFragmentActive(), "").b(R.drawable.user_bg_round).a(this.B);
        this.D.setText(getResources().getString(R.string.yy_game_electioning));
        h();
        this.p.setVisibility(0);
        this.m.setVisibility(8);
        this.f.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.o.setVisibility(8);
        if (!YYRoomInfoManager.e().y()) {
            this.d.setVisibility(0);
            this.i.setVisibility(8);
            return;
        }
        this.d.setVisibility(8);
        this.i.setVisibility(0);
        this.e.setVisibility(0);
        this.f18173c.setVisibility(8);
    }

    public void a(final int i, final int i2) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYGameView.5
            @Override // java.lang.Runnable
            public void run() {
                YYGameView.this.L.setAlpha(1.0f);
                YYGameView.this.K.setAlpha(1.0f);
                YYGameView yYGameView = YYGameView.this;
                boolean z = i > 0;
                yYGameView.a(z, Math.abs(i) + "");
                YYGameView yYGameView2 = YYGameView.this;
                boolean z2 = i2 > 0;
                yYGameView2.b(z2, Math.abs(i2) + "");
            }
        }, 6000L);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18172a = baseYYStudioFragment;
        this.T = YYRoomInfoManager.e().b();
        LiveEventBus.get("show_game_time", YYGameTimerEvent.class).observe(baseYYStudioFragment, new Observer<YYGameTimerEvent>() { // from class: com.blued.android.module.yy_china.view.YYGameView.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYGameTimerEvent yYGameTimerEvent) {
                if (yYGameTimerEvent == null) {
                    YYGameView.this.h.setVisibility(8);
                    return;
                }
                YYGameView.this.h.setVisibility(0);
                YYGameView.this.h.setText(yYGameTimerEvent.content);
            }
        });
        a();
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, int i, int i2) {
        i();
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(0);
        this.L.setAlpha(i > 0 ? 1.0f : 0.4f);
        this.K.setAlpha(i2 > 0 ? 1.0f : 0.4f);
        if (yYSeatMemberModel != null) {
            ImageLoader.a(this.f18172a.getFragmentActive(), yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(this.E);
        }
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, int i, String str) {
        j();
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        if (yYSeatMemberModel == null) {
            return;
        }
        TextView textView = this.G;
        textView.setText("恭喜第" + yYSeatMemberModel.team_num + "队获得本次游戏胜利");
        this.I.setText(String.format(getResources().getString(R.string.yy_game_total_active), str));
        if (i == 1) {
            this.H.setImageResource(R.drawable.icon_yy_team_one);
            this.J.setBackgroundResource(R.drawable.icon_yy_victory_bg_one);
            this.I.setTextColor(getResources().getColor(R.color.syc_00E0AB));
        } else if (i == 2) {
            this.H.setImageResource(R.drawable.icon_yy_team_two);
            this.J.setBackgroundResource(R.drawable.icon_yy_victory_bg_two);
            this.I.setTextColor(getResources().getColor(R.color.syc_3883FD));
        }
        if (yYSeatMemberModel != null) {
            getGamePrize();
        }
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, YYSeatMemberModel yYSeatMemberModel2) {
        String str;
        String str2;
        i();
        this.q.setVisibility(8);
        this.p.setVisibility(0);
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.N.setVisibility(0);
        this.Q.setVisibility(0);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        b(false);
        if (yYSeatMemberModel != null) {
            String avatar = yYSeatMemberModel.getAvatar();
            String name = yYSeatMemberModel.getName();
            str2 = avatar;
            str = name;
        } else {
            str = "等待上位";
            str2 = "";
        }
        ImageLoader.a(this.f18172a.getFragmentActive(), str2).b(R.drawable.user_bg_round).a(this.A);
        this.C.setText(str);
        String str3 = "等待上位";
        String str4 = "";
        if (yYSeatMemberModel2 != null) {
            str4 = yYSeatMemberModel2.getAvatar();
            str3 = yYSeatMemberModel2.getName();
        }
        ImageLoader.a(this.f18172a.getFragmentActive(), str4).b(R.drawable.user_bg_round).a(this.B);
        this.D.setText(str3);
    }

    public void a(String str) {
        i();
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.F.setText(str);
    }

    public void a(boolean z) {
        i();
        this.n.setVisibility(0);
        this.z.setVisibility(8);
        this.y.setVisibility(8);
        this.m.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.o.setVisibility(8);
        this.N.setVisibility(0);
        this.Q.setVisibility(0);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        b(true);
        ImageLoader.a(this.f18172a.getFragmentActive(), "").b(R.drawable.user_bg_round).a(this.A);
        ImageLoader.a(this.f18172a.getFragmentActive(), "").b(R.drawable.user_bg_round).a(this.B);
        if (!YYRoomInfoManager.e().y() && !z && YYRoomInfoManager.e().i()) {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.h.setVisibility(8);
            return;
        }
        this.C.setText(getResources().getString(R.string.yy_game_electioning));
        this.D.setText(getResources().getString(R.string.yy_game_electioning));
        this.p.setVisibility(0);
        this.q.setVisibility(8);
    }

    public void b() {
        i();
        this.q.setVisibility(8);
        this.p.setVisibility(0);
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.N.setVisibility(4);
        this.Q.setVisibility(4);
        this.C.setVisibility(4);
        this.D.setVisibility(4);
    }

    public void b(String str) {
        i();
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.F.setText(str);
        if (YYRoomInfoManager.e().y()) {
            return;
        }
        YYGameBonusView yYGameBonusView = new YYGameBonusView(getContext());
        yYGameBonusView.a(this.f18172a);
        this.f18172a.a((View) yYGameBonusView, -2, false);
    }

    public void c() {
        YYPunishListView yYPunishListView = new YYPunishListView(getContext());
        yYPunishListView.setTitleText("");
        yYPunishListView.setConfirmListener(new IPunishClickListener() { // from class: com.blued.android.module.yy_china.view.YYGameView.6
            @Override // com.blued.android.module.yy_china.listener.IPunishClickListener
            public void a(YYRewardModel yYRewardModel) {
                if (YYGameView.this.f18172a != null) {
                    YYGameView.this.f18172a.y();
                }
                YYGameView yYGameView = YYGameView.this;
                yYGameView.a("获胜方选择惩罚\n" + yYRewardModel.event_name, yYRewardModel.event_id);
            }
        });
        yYPunishListView.a(this.f18172a, 1);
        this.f18172a.a(yYPunishListView, -2);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        this.g.setText(str);
    }

    public void d(String str) {
        this.y.setVisibility(StringUtils.a(str, 0) > 0 ? 0 : 8);
        this.y.setText(String.format(getResources().getString(R.string.yy_game_total_active), CommonStringUtils.b(StringUtils.a(str, 0.0d))));
    }

    public void e(String str) {
        this.z.setVisibility(StringUtils.a(str, 0) > 0 ? 0 : 8);
        this.z.setText(String.format(getResources().getString(R.string.yy_game_total_active), CommonStringUtils.b(StringUtils.a(str, 0.0d))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_start) {
            if (ClickUtils.a(R.id.tv_start)) {
                return;
            }
            g();
        } else if (view.getId() == R.id.tv_set) {
            if (ClickUtils.a(R.id.tv_set)) {
                return;
            }
            f();
        } else if (view.getId() != R.id.tv_campign_captain) {
            if (view.getId() == R.id.reset_game) {
                YYRoomHttpUtils.M(this.T.room_id, new BluedUIHttpResponse<BluedEntityA<Object>>(this.f18172a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGameView.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                        YYImModel yYImModel = new YYImModel();
                        yYImModel.msgMapExtra = new HashMap<>();
                        MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "step", 0L);
                        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "step_title", "");
                        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "step_content", "");
                        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_left_value", "");
                        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_right_value", "");
                        LiveEventBus.get("show_game_step").post(yYImModel);
                    }
                }, this.f18172a.getFragmentActive());
            }
        } else if (ClickUtils.a(R.id.tv_campign_captain)) {
        } else {
            if (this.T != null) {
                EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_GAME_ROB_CLICK, this.T.room_id);
            }
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PopupWindow popupWindow = this.b;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.b = null;
        }
    }
}
