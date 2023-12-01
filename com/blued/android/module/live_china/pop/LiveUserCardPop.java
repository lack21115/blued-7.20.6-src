package com.blued.android.module.live_china.pop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.UserMedalsAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.live_china.view.PopAnchorBadge;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveUserCardPop.class */
public class LiveUserCardPop extends BottomPopupView implements View.OnClickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone {
    public LinearLayout A;
    public TextView B;
    public TextView C;
    public TextView D;
    public ImageView E;
    public ImageView F;
    public ImageView G;
    public View H;
    public LinearLayout I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public LinearLayout N;
    public ImageView O;
    public View P;
    public ImageView Q;
    public View R;
    public ImageView S;
    public ImageView T;
    public TextView U;
    public boolean V;
    public boolean W;
    public BluedUIHttpResponse aa;
    private List<String> ab;
    private int ac;
    private LoadOptions ad;
    private String ae;
    private IRequestHost af;
    private UserCardOnclickListner ag;
    private Long ah;
    private Short ai;
    private ImageView aj;
    private RecyclerView ak;
    private List<AnchorMedal> al;
    private UserMedalAdapterForCard am;
    private int an;
    private ImageView ao;
    private TextView ap;
    private int aq;
    private LiveMsgReportModel ar;
    public View b;
    public View c;
    public Context d;
    public LayoutInflater e;
    public LiveRoomUserModel f;
    public View g;
    public View h;
    public View i;
    public View j;
    public TextView k;
    public LinearLayout t;
    public LinearLayout u;
    public LinearLayout v;
    public LinearLayout w;
    public TextView x;
    public LinearLayout y;
    public LinearLayout z;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveUserCardPop$FROM_SOURCE.class */
    public interface FROM_SOURCE {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveUserCardPop$USER_PRIVILLAGE.class */
    public interface USER_PRIVILLAGE {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveUserCardPop$UserCardOnclickListner.class */
    public interface UserCardOnclickListner {
        void a();

        void a(LiveRoomUserModel liveRoomUserModel);

        void a(String str);

        void a(String str, LiveMsgReportModel liveMsgReportModel);

        void a(String str, String str2);

        void b();

        void b(String str, String str2);

        void c();

        void c(String str, String str2);

        void d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveUserCardPop$UserMedalAdapterForCard.class */
    public class UserMedalAdapterForCard extends UserMedalsAdapter {
        public UserMedalAdapterForCard(Context context, List<AnchorMedal> list) {
            super(context, list);
        }

        @Override // com.blued.android.module.live_china.adapter.UserMedalsAdapter
        public View a() {
            return LiveUserCardPop.this.e.inflate(R.layout.item_user_anchor_medal4card, (ViewGroup) null);
        }
    }

    public LiveUserCardPop(Context context, IRequestHost iRequestHost, String str, Long l, Short sh, UserCardOnclickListner userCardOnclickListner) {
        super(context);
        this.f = new LiveRoomUserModel();
        this.ac = 0;
        this.ae = " | ";
        this.al = new ArrayList();
        this.an = 0;
        this.V = false;
        this.aq = 0;
        this.W = false;
        this.aa = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this.af) { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                LiveUserCardPop.this.W = true;
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveUserCardPop.this.f = bluedEntityA.data.get(0);
                if (LiveUserCardPop.this.f != null) {
                    LiveUserCardPop.this.C();
                    LiveUserCardPop.this.al.clear();
                    if (LiveUserCardPop.this.f.badge == null || LiveUserCardPop.this.f.badge.size() <= 0) {
                        LiveUserCardPop.this.ak.setVisibility(8);
                        return;
                    }
                    LiveUserCardPop.this.ak.setVisibility(0);
                    LiveUserCardPop.this.al.addAll(LiveUserCardPop.this.f.badge);
                    LiveUserCardPop liveUserCardPop = LiveUserCardPop.this;
                    liveUserCardPop.am = new UserMedalAdapterForCard(liveUserCardPop.d, LiveUserCardPop.this.al);
                    LiveUserCardPop.this.am.a(new UserMedalsAdapter.RecyclerViewItemClickListener() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.9.1
                        @Override // com.blued.android.module.live_china.adapter.UserMedalsAdapter.RecyclerViewItemClickListener
                        public void a(View view, int i) {
                            if (LiveUserCardPop.this.an == 0) {
                                LiveUserCardPop.this.E();
                                LiveUserCardPop.this.a(((AnchorMedal) LiveUserCardPop.this.al.get(i)).bid, LiveUserCardPop.this.f.uid);
                            }
                        }
                    });
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LiveUserCardPop.this.d);
                    linearLayoutManager.setOrientation(0);
                    LiveUserCardPop.this.ak.setLayoutManager(linearLayoutManager);
                    LiveUserCardPop.this.ak.setHasFixedSize(true);
                    LiveUserCardPop.this.ak.setAdapter(LiveUserCardPop.this.am);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveUserCardPop.this.W = false;
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveUserCardPop.this.y.setVisibility(8);
                LiveUserCardPop.this.z.setVisibility(0);
                if (LiveUserCardPop.this.W) {
                    return;
                }
                LiveUserCardPop.this.E();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveUserCardPop.this.y.setVisibility(0);
            }
        };
        this.d = context;
        setUserCardHostId(str);
        this.af = iRequestHost;
        this.ah = l;
        this.ai = sh;
        this.ag = userCardOnclickListner;
    }

    private void F() {
        if (TextUtils.equals(LiveRoomInfo.a().f(), getCurrentAnchor())) {
            this.ac = 1;
            return;
        }
        Logger.a("rrb", "isCurrentUserAManager = ", Integer.valueOf(this.ac));
        if (LiveFloatManager.a().w()) {
            this.ac = 2;
        } else {
            this.ac = 0;
        }
    }

    private boolean G() {
        boolean z;
        String str = this.f.relationship;
        int hashCode = str.hashCode();
        if (hashCode == 52) {
            if (str.equals("4")) {
                z = false;
            }
            z = true;
        } else if (hashCode != 56) {
            if (hashCode == 1569 && str.equals("12")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("8")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            this.D.setText(this.d.getString(R.string.liveVideo_livingView_label_inBlackList));
            this.D.setVisibility(0);
            this.w.setVisibility(8);
            return false;
        } else if (z) {
            H();
            return false;
        } else if (z) {
            H();
            return false;
        } else {
            this.D.setVisibility(8);
            this.w.setVisibility(0);
            return true;
        }
    }

    private void H() {
        this.g.setVisibility(0);
        this.w.setVisibility(8);
        this.D.setVisibility(0);
        this.D.setText(this.d.getString(R.string.liveVideo_livingView_label_userBlockYou));
        this.A.setVisibility(8);
    }

    private void I() {
        F();
        this.g.setVisibility(0);
        int i = this.ac;
        if (i == 0) {
            List<String> list = this.ab;
            if (list == null || !list.contains(this.f.uid)) {
                this.j.setVisibility(0);
                this.t.setVisibility(0);
                this.h.setVisibility(0);
                this.u.setVisibility(0);
                this.i.setVisibility(8);
                this.v.setVisibility(8);
                this.I.setVisibility(0);
                this.J.setVisibility(0);
                this.M.setVisibility(8);
                this.N.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.j.setVisibility(8);
                this.t.setVisibility(8);
                this.h.setVisibility(8);
                this.u.setVisibility(0);
                this.i.setVisibility(8);
                this.v.setVisibility(8);
                this.I.setVisibility(0);
                this.J.setVisibility(0);
                this.M.setVisibility(8);
                this.N.setVisibility(8);
                this.k.setVisibility(8);
            }
        } else if (i == 1) {
            this.j.setVisibility(0);
            this.t.setVisibility(8);
            this.h.setVisibility(8);
            this.u.setVisibility(0);
            this.i.setVisibility(0);
            this.v.setVisibility(0);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.M.setVisibility(0);
            this.N.setVisibility(0);
            this.k.setVisibility(8);
        } else if (i == 2) {
            if (this.f.is_manager == 1 || this.f.uid.equalsIgnoreCase(getCurrentAnchor())) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
            this.j.setVisibility(0);
            this.t.setVisibility(0);
            this.h.setVisibility(0);
            this.u.setVisibility(0);
            this.i.setVisibility(8);
            this.v.setVisibility(8);
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
        }
        int i2 = this.aq;
        if (i2 != 1) {
            if (i2 == 2) {
                J();
                return;
            } else if (i2 != 3) {
                return;
            } else {
                if (this.W) {
                    EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_SHOW, LiveRoomManager.a().d(), this.f.uid, EventTrackLive.b(this.f.relationship));
                }
                J();
                return;
            }
        }
        K();
        this.w.setVisibility(0);
        if (this.ac != 1) {
            this.t.setVisibility(8);
            this.J.setVisibility(8);
            return;
        }
        this.i.setVisibility(8);
        this.v.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void J() {
        this.j.setVisibility(4);
        this.D.setVisibility(8);
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.v.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
    }

    private void K() {
        this.g.setVisibility(8);
        this.j.setVisibility(4);
        this.w.setVisibility(8);
        this.D.setVisibility(8);
        this.k.setVisibility(8);
    }

    public static void a(Context context, IRequestHost iRequestHost, String str) {
        LiveUserCardPop liveUserCardPop = new LiveUserCardPop(context, iRequestHost, "", 0L, (short) 0, new UserCardOnclickListner() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.1
            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void a() {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void a(LiveRoomUserModel liveRoomUserModel) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void a(String str2) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void a(String str2, LiveMsgReportModel liveMsgReportModel) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void a(String str2, String str3) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void b() {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void b(String str2, String str3) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void c() {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void c(String str2, String str3) {
            }

            @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
            public void d() {
            }
        });
        liveUserCardPop.f.uid = str;
        new XPopup.Builder(context).a((BasePopupView) liveUserCardPop).h();
    }

    public void A() {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this.af) { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.5
            boolean a = false;
            String b;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                AppMethods.a((CharSequence) LiveUserCardPop.this.d.getResources().getString(R.string.live_manager_settled));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 403903) {
                    this.b = str;
                    this.a = true;
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.a) {
                    CommonAlertDialog.a(LiveUserCardPop.this.d, (View) null, "", this.b, LiveUserCardPop.this.d.getString(R.string.live_manager_manage), LiveUserCardPop.this.d.getString(R.string.live_ok), (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            LiveUserCardPop.this.ag.d();
                        }
                    }, (DialogInterface.OnCancelListener) null, true);
                    this.a = false;
                }
            }
        }, this.af, String.valueOf(this.ah), this.f.uid);
    }

    public void B() {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this.af) { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                AppMethods.a((CharSequence) LiveUserCardPop.this.d.getResources().getString(R.string.live_manager_removed));
            }
        }, this.af, String.valueOf(this.ah), this.f.uid);
    }

    public void C() {
        int color;
        LiveRoomUserModel liveRoomUserModel = this.f;
        if (liveRoomUserModel != null) {
            if (!TextUtils.isEmpty(liveRoomUserModel.name)) {
                if (TextUtils.isEmpty(this.f.note)) {
                    this.B.setText(this.f.name);
                } else {
                    TextView textView = this.B;
                    textView.setText(this.f.note + "(" + this.f.name + ")");
                }
            }
            LiveRoomInfo.a().a(this.d, this.B, this.f, R.color.syc_dark_h);
            if (this.f.is_manager == 1) {
                this.ao.setVisibility(0);
            } else {
                this.ao.setVisibility(8);
            }
            LiveUtils.a(this.d, this.aj, this.f.anchor_level, true);
            BitmapUtils.a(this.d, this.O, this.f.rich_level);
            if (this.f.rich_level >= 1) {
                this.ap.setVisibility(0);
                color = this.d.getResources().getColor(R.color.syc_r);
                this.P.setVisibility(0);
                if (this.f.rich_level >= 30) {
                    switch (this.f.rich_level) {
                        case 30:
                            this.Q.setImageResource(R.drawable.bg_lv30_usercard);
                            break;
                        case 31:
                            this.Q.setImageResource(R.drawable.bg_lv31_usercard);
                            break;
                        case 32:
                            this.Q.setImageResource(R.drawable.bg_lv32_usercard);
                            break;
                        case 33:
                            this.Q.setImageResource(R.drawable.bg_lv33_usercard);
                            break;
                        case 34:
                            this.Q.setImageResource(R.drawable.bg_lv34_usercard);
                            break;
                        case 35:
                            this.Q.setImageResource(R.drawable.bg_lv35_usercard);
                            break;
                    }
                } else if (this.f.rich_level >= 26) {
                    this.Q.setImageResource(R.drawable.bg_lv26_usercard);
                } else if (this.f.rich_level >= 21) {
                    this.Q.setImageResource(R.drawable.bg_lv21_usercard);
                } else if (this.f.rich_level >= 11) {
                    this.Q.setImageResource(R.drawable.bg_lv11_usercard);
                } else {
                    this.P.setVisibility(4);
                }
            } else {
                this.ap.setVisibility(8);
                color = this.d.getResources().getColor(R.color.nafio_b);
                this.P.setVisibility(4);
            }
            if (this.f.liang_type == 1) {
                if (TextUtils.equals(this.f.uid, LiveRoomInfo.a().f())) {
                    this.S.setVisibility(0);
                    this.S.setImageResource(R.drawable.live_liang_gray);
                } else {
                    this.S.setVisibility(8);
                }
                this.U.setTextColor(this.d.getResources().getColor(R.color.syc_dark_79818D));
                this.U.setVisibility(0);
                TextView textView2 = this.U;
                textView2.setText("ID: " + this.f.liang_id);
                this.R.setVisibility(0);
                this.T.setVisibility(8);
            } else if (this.f.liang_type >= 2) {
                this.S.setVisibility(0);
                this.S.setImageResource(R.drawable.live_liang);
                this.U.setTextColor(this.d.getResources().getColor(R.color.syc_w_465CF2));
                this.U.setVisibility(0);
                TextView textView3 = this.U;
                textView3.setText(" : " + this.f.liang_id);
                this.R.setVisibility(0);
                this.T.setVisibility(0);
            } else {
                this.S.setVisibility(8);
                this.R.setVisibility(8);
            }
            if (TextUtils.equals(this.f.uid, LiveRoomInfo.a().f())) {
                this.S.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackLive.a(LiveProtos.Event.BETTER_ID_MY_PROFILE_BATTER_CLICK);
                        LiveRoomInfo.a().a(LiveUserCardPop.this.d, LiveRoomInfo.a().E());
                    }
                });
            }
            ImageLoader.a(this.af, this.f.avatar).b(R.drawable.user_bg_round).a(2.0f, color).a(this.E);
            if (!TextUtils.isEmpty(this.f.location)) {
                this.L.setText(this.f.location);
            }
            if (UserInfoHelper.b(this.f.vbadge)) {
                this.C.setVisibility(8);
            } else {
                this.C.setText(this.f.age + this.d.getResources().getString(R.string.age_unit) + this.ae + LiveRoomInfo.a().a(this.f.height, true) + this.ae + LiveRoomInfo.a().b(this.f.weight, true) + this.ae + LiveRoomInfo.a().a(this.d, (TextView) null, this.f.role));
                this.C.setVisibility(0);
            }
            if (this.ab == null || getCurrentAnchor() == null || !getCurrentAnchor().equals(this.f.uid) || TextUtils.isEmpty(this.f.description)) {
                this.A.setVisibility(8);
            } else {
                this.K.setText(this.f.description);
                this.A.setVisibility(0);
            }
            LiveRoomInfo.a().a(this.F, this.f.vbadge);
            LiveRoomInfo.a().a(this.G, this.f);
        }
        if (TextUtils.equals(LiveRoomInfo.a().f(), this.f.uid)) {
            K();
        } else {
            D();
            if (G()) {
                if (this.an != 1) {
                    I();
                } else {
                    this.j.setVisibility(4);
                    this.t.setVisibility(8);
                    this.h.setVisibility(8);
                    this.u.setVisibility(0);
                    this.i.setVisibility(8);
                    this.v.setVisibility(8);
                    this.k.setVisibility(8);
                    this.I.setVisibility(0);
                    this.J.setVisibility(0);
                    this.M.setVisibility(8);
                    this.N.setVisibility(8);
                    this.g.setVisibility(0);
                }
            }
        }
        LiveUserRelationshipUtils.a(this.d, this.f.relationship, this.x, null);
    }

    public void D() {
        if (this.f.allow_active == 0) {
            this.k.setText(this.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
        } else {
            this.k.setText(this.d.getString(R.string.liveVideo_livingView_label_forbidToSpeakButton));
        }
    }

    public void E() {
        p();
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void Q_() {
    }

    public void a(final LiveRoomUserModel liveRoomUserModel, final int i) {
        if (!PlayingOnliveFragment.aa) {
            a(liveRoomUserModel, i, (LiveMsgReportModel) null);
            return;
        }
        KeyboardUtils.a((Activity) this.d);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.10
            @Override // java.lang.Runnable
            public void run() {
                LiveUserCardPop.this.a(liveRoomUserModel, i, (LiveMsgReportModel) null);
            }
        }, 500L);
    }

    public void a(LiveRoomUserModel liveRoomUserModel, int i, LiveMsgReportModel liveMsgReportModel) {
        if (liveRoomUserModel != null) {
            this.ar = liveMsgReportModel;
            this.aq = i;
            if (this.ag == null) {
                this.ag = new UserCardOnclickListner() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.11
                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void a() {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void a(LiveRoomUserModel liveRoomUserModel2) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void a(String str) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void a(String str, LiveMsgReportModel liveMsgReportModel2) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void a(String str, String str2) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void b() {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void b(String str, String str2) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void c() {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void c(String str, String str2) {
                    }

                    @Override // com.blued.android.module.live_china.pop.LiveUserCardPop.UserCardOnclickListner
                    public void d() {
                    }
                };
            }
            this.ag.b();
            this.z.setVisibility(4);
            this.y.setVisibility(0);
            this.P.setVisibility(4);
            this.f = liveRoomUserModel;
            C();
            getUserinfo();
        }
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a(String str) {
        this.f.relationship = str;
        if (this.f.uid.equals(getCurrentAnchor())) {
            LiveMsgSendManager.a().k();
        }
        LiveUserRelationshipUtils.a(this.d, str, this.x, null);
        LiveRelationshipObserver.a().a(str, this.f.uid);
    }

    public void a(String str, int i) {
        this.f.uid = str;
        this.f.name = "";
        this.f.avatar = "";
        a(this.f, i);
    }

    public void a(String str, String str2) {
        PopAnchorBadge.a(this.d, str2, getCurrentAnchor(), str, new PopAnchorBadge.DismissLisnter() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.8
            @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
            public void a() {
                LiveUserCardPop.this.ag.a();
            }

            @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
            public void b() {
                LiveUserCardPop.this.ag.c();
            }
        }, this.af);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        e();
        c(this.f.uid);
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b(String str) {
        this.f.relationship = str;
        LiveUserRelationshipUtils.a(this.d, str, this.x, null);
        LiveRelationshipObserver.a().a(str, this.f.uid);
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void c() {
    }

    public void c(String str) {
        a(str, 0);
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void d() {
    }

    public void e() {
        int i = this.d.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.ad = loadOptions;
        loadOptions.l = false;
        this.ad.b = R.drawable.user_bg_round;
        this.ad.d = R.drawable.user_bg_round;
        int i2 = i >> 1;
        this.ad.a(i2, i2);
        this.e = LayoutInflater.from(this.d);
        this.H = this;
        this.ap = (TextView) findViewById(R.id.tv_avatar_gold_border);
        this.ao = (ImageView) this.H.findViewById(R.id.img_manager_icon);
        this.P = this.H.findViewById(R.id.view_over30_ribbon);
        this.Q = (ImageView) this.H.findViewById(R.id.img_ribbon);
        this.R = this.H.findViewById(R.id.ll_liang);
        this.S = (ImageView) this.H.findViewById(R.id.img_liang);
        this.T = (ImageView) this.H.findViewById(R.id.iv_liang_icon);
        this.U = (TextView) this.H.findViewById(R.id.tv_liang_id);
        View findViewById = this.H.findViewById(R.id.tv_report);
        this.j = findViewById;
        findViewById.setOnClickListener(this);
        TextView textView = (TextView) this.H.findViewById(R.id.tv_silence);
        this.k = textView;
        textView.setOnClickListener(this);
        this.y = (LinearLayout) this.H.findViewById(R.id.ll_loading);
        LinearLayout linearLayout = (LinearLayout) this.H.findViewById(R.id.ll_reply);
        this.t = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.H.findViewById(R.id.ll_attention);
        this.u = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.H.findViewById(R.id.ll_manage);
        this.v = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.w = (LinearLayout) this.H.findViewById(R.id.ll_bottom_button);
        this.z = (LinearLayout) this.H.findViewById(R.id.ll_userinfo);
        LinearLayout linearLayout4 = (LinearLayout) this.H.findViewById(R.id.ll_view_profile);
        this.I = linearLayout4;
        linearLayout4.setOnClickListener(this);
        this.A = (LinearLayout) this.H.findViewById(R.id.ll_description);
        this.g = this.H.findViewById(R.id.tv_cut_bottom);
        this.h = this.H.findViewById(R.id.tv_cut_attention);
        this.i = this.H.findViewById(R.id.tv_cut_silence);
        this.x = (TextView) this.H.findViewById(R.id.tv_attention);
        this.k = (TextView) this.H.findViewById(R.id.tv_silence);
        this.K = (TextView) this.H.findViewById(R.id.tv_description);
        this.J = (TextView) this.H.findViewById(R.id.tv_cut_chat);
        this.M = (TextView) this.H.findViewById(R.id.tv_cut_connect);
        LinearLayout linearLayout5 = (LinearLayout) this.H.findViewById(R.id.ll_connect);
        this.N = linearLayout5;
        linearLayout5.setOnClickListener(this);
        this.B = (TextView) this.H.findViewById(R.id.tv_name);
        this.E = (ImageView) this.H.findViewById(R.id.header_view);
        this.O = (ImageView) this.H.findViewById(R.id.img_rich_rank);
        this.aj = (ImageView) this.H.findViewById(R.id.img_anchor_lvl);
        this.F = (ImageView) this.H.findViewById(R.id.img_verify);
        this.G = (ImageView) this.H.findViewById(R.id.img_vip_icon);
        this.C = (TextView) this.H.findViewById(R.id.tv_userinfo_line1);
        this.D = (TextView) this.H.findViewById(R.id.tv_block);
        this.b = this.H.findViewById(R.id.tv_bg);
        this.L = (TextView) this.H.findViewById(R.id.tv_distance);
        this.ak = this.H.findViewById(R.id.lv_medals);
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveUserCardPop.this.E();
            }
        });
        View findViewById2 = this.H.findViewById(R.id.ll_content);
        this.c = findViewById2;
        findViewById2.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    public String getCurrentAnchor() {
        List<String> list = this.ab;
        return (list == null || list.size() <= 0) ? "" : this.ab.get(0);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.item_pop_usercard;
    }

    public String getUid() {
        return this.f.uid;
    }

    public String getUserName() {
        return this.f.name;
    }

    public void getUserinfo() {
        if ("fromname".equals(this.f.uid)) {
            LiveRoomHttpUtils.b(this.aa, this.f.uid, this.f.name, this.af);
        } else {
            LiveRoomHttpUtils.b(this.aa, this.f.uid, this.f.name, this.af);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ll_view_profile) {
            if (LiveRoomManager.a().p() != null && LiveRoomManager.a().p().link_type == 4) {
                EventTrackLive.d(LiveProtos.Event.USER_MIKE_USER_PHOTO_CARD_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.f.uid);
            }
            if (LiveRefreshUIObserver.a().f()) {
                E();
                this.ag.c();
                if (this.ab.contains(this.f.uid)) {
                    LiveRoomInfo.a().a(this.d, this.f.uid, this.f.name, this.f.avatar, this.f.is_show_vip_page, 1);
                } else {
                    LiveRoomInfo.a().a(this.d, this.f.uid, this.f.name, this.f.avatar, this.f.is_show_vip_page, 2);
                }
            }
        } else if (view.getId() == R.id.tv_report) {
            E();
            this.ag.a(this.f.uid, this.ar);
        } else if (view.getId() == R.id.ll_reply) {
            if (LiveRoomInfo.a().a(this.d, (View.OnClickListener) null)) {
                return;
            }
            E();
            this.ag.b(this.f.uid, this.f.name);
        } else if (view.getId() == R.id.ll_attention) {
            if (this.aq == 3) {
                EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_CLICK, LiveRoomManager.a().d(), this.f.uid, EventTrackLive.b(this.f.relationship));
            }
            String str = (getCurrentAnchor() == null || !getCurrentAnchor().equalsIgnoreCase(this.f.uid)) ? "live_" : "liveanchor_";
            LiveRoomInfo.a().a(this.d, (LiveUserRelationshipUtils.IAddOrRemoveAttentionDone) this, this.f.uid, this.f.relationship, str + this.ah, this.af, false);
        } else if (view.getId() == R.id.ll_connect) {
            E();
            this.ag.a(this.f);
        } else if (view.getId() == R.id.ll_manage) {
            EventTrackLive.a(LiveProtos.Event.LIVE_MANAGE_BTN_CLICK, LiveRoomManager.a().e(), this.f.uid);
            z();
            InstantLog.a("live_manage_btn_click");
        } else if (view.getId() == R.id.tv_silence) {
            if (this.f.allow_active != 1) {
                this.f.allow_active = 1;
                D();
                this.ag.c(this.f.uid, this.f.name);
                InstantLog.b("live_banned_option_click", 2);
                AppMethods.d(R.string.live_released_to_speak_tip);
                return;
            }
            InstantLog.b("live_banned_option_click", 0);
            this.f.allow_active = 0;
            D();
            this.ag.a(getUid(), getUserName());
            AppMethods.d(R.string.live_forbid_to_speak_tip);
        }
    }

    public void setFromSource(int i) {
        this.an = i;
    }

    public void setUserCardHostId(String str) {
        List<String> list = this.ab;
        if (list == null) {
            this.ab = new ArrayList();
        } else {
            list.clear();
        }
        this.ab.add(str);
    }

    public void setUserCardHostId(List<String> list) {
        List<String> list2 = this.ab;
        if (list2 == null) {
            this.ab = new ArrayList();
        } else {
            list2.clear();
        }
        if (list != null) {
            this.ab.addAll(list);
        }
    }

    public void z() {
        ArrayList arrayList = new ArrayList();
        if (this.f.allow_active == 1) {
            if (this.f.is_manager == 1) {
                arrayList.add(this.d.getString(R.string.live_cancel_manage));
            } else {
                arrayList.add(this.d.getString(R.string.live_set_manager));
            }
            arrayList.add(this.d.getString(R.string.live_manager_list));
            arrayList.add(this.d.getString(R.string.live_temp_banned));
            arrayList.add(this.d.getString(R.string.live_perm_banned));
        } else {
            if (this.f.is_manager == 1) {
                arrayList.add(this.d.getString(R.string.live_cancel_manage));
            } else {
                arrayList.add(this.d.getString(R.string.live_set_manager));
            }
            arrayList.add(this.d.getString(R.string.live_manager_list));
            arrayList.add(this.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                Context context = this.d;
                PopActionSheet.a(context, null, strArr, iArr, DensityUtils.a(context, 200.0f), true, new PopActionSheet.PopSheetClickListner() { // from class: com.blued.android.module.live_china.pop.LiveUserCardPop.4
                    @Override // com.blued.android.module.live_china.view.PopActionSheet.PopSheetClickListner
                    public void onClick(int i3, String str) {
                        if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.live_set_manager))) {
                            LiveUserCardPop.this.A();
                        } else if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.live_cancel_manage))) {
                            LiveUserCardPop.this.B();
                        } else if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.live_manager_list))) {
                            LiveUserCardPop.this.ag.d();
                        } else if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.live_temp_banned))) {
                            LiveUserCardPop.this.f.allow_active = 0;
                            LiveUserCardPop.this.D();
                            LiveUserCardPop.this.ag.a(LiveUserCardPop.this.getUid(), LiveUserCardPop.this.getUserName());
                            InstantLog.b("live_banned_option_click", 0);
                            AppMethods.d(R.string.live_forbid_to_speak_tip);
                        } else if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.live_perm_banned))) {
                            LiveUserCardPop.this.f.allow_active = 0;
                            LiveUserCardPop.this.D();
                            LiveUserCardPop.this.ag.a(LiveUserCardPop.this.getUid());
                            InstantLog.b("live_banned_option_click", 1);
                            AppMethods.d(R.string.live_forbid_to_speak_tip);
                        } else if (str.equalsIgnoreCase(LiveUserCardPop.this.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak))) {
                            LiveUserCardPop.this.f.allow_active = 1;
                            LiveUserCardPop.this.D();
                            LiveUserCardPop.this.ag.c(LiveUserCardPop.this.getUid(), LiveUserCardPop.this.getUserName());
                            InstantLog.b("live_banned_option_click", 2);
                            AppMethods.d(R.string.live_released_to_speak_tip);
                        }
                        LiveUserCardPop.this.E();
                    }
                });
                return;
            }
            iArr[i2] = R.color.syc_a;
            i = i2 + 1;
        }
    }
}
