package com.soft.blued.ui.find.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.view.PhotoGridView;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.video.uitls.ViewUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterFragment.class */
public class FilterFragment extends BaseFragment implements View.OnClickListener {
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private LinearLayout I;
    private LinearLayout J;
    private LinearLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public FilterDialogFragment f16503a;
    private String[] aA;
    private String[] aB;
    private boolean aC;
    private boolean aD;
    private TextView aF;
    private ImageView aa;
    private ImageView ab;
    private PhotoGridView aj;
    private PhotoGridView ak;
    private PhotoGridView al;
    private PhotoGridView am;
    private PhotoGridView an;
    private PhotoGridView ao;
    private PhotoGridView ap;
    private UserTagAdapter aq;

    /* renamed from: ar  reason: collision with root package name */
    private UserTagAdapter f16504ar;
    private UserTagAdapter as;
    private UserTagAdapter at;
    private UserTagAdapter au;
    private UserTagAdapter av;
    private UserTagAdapter aw;
    private View ax;
    private String[] ay;
    private String[] az;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public CommonTopTitleNoTrans f16505c;
    public NestedScrollView d;
    public TextView e;
    public TextView f;
    public TwoWaysBar g;
    public TwoWaysBar h;
    public TwoWaysBar i;
    public TwoWaysBar j;
    public TwoWaysBar k;
    public LinearLayout l;
    private Dialog m;
    private Context n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private boolean s = false;
    private String y = "";
    private String z = "";
    private String A = "";
    private String B = "";
    private String C = "";
    private List<UserTag> ac = new ArrayList();
    private List<UserTag> ad = new ArrayList();
    private List<UserTag> ae = new ArrayList();
    private List<UserTag> af = new ArrayList();
    private List<UserTag> ag = new ArrayList();
    private List<UserTag> ah = new ArrayList();
    private List<UserTag> ai = new ArrayList();
    private HashSet<String> aE = new HashSet<>();

    private void A() {
        String d = d();
        Logger.e("rolses==" + d, new Object[0]);
        BluedPreferences.k(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (BluedPreferences.bN()) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(BluedPreferences.T())) {
            i = 1;
        }
        String[] c2 = c();
        int i2 = i;
        if (!TextUtils.isEmpty(c2[1])) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (!TextUtils.isEmpty(c2[2])) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (FilterHelper.d().m()) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (FilterHelper.d().l()) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (FilterHelper.d().k()) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (!TextUtils.isEmpty(d())) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (BluedPreferences.R()) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (BluedPreferences.P()) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (FilterHelper.d().i()) {
            i10 = i9 + 1;
        }
        int i11 = i10;
        if (FilterHelper.d().j()) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (FilterHelper.d().g()) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (FilterHelper.d().g()) {
            i13 = i12 + 1;
        }
        if (i13 >= 6) {
            BluedPreferences.bM();
            ToastUtils.a(getResources().getString(R.string.filter_condition_more));
        }
    }

    private boolean c(String str) {
        if (StringUtils.d(str) && StringUtils.d(BluedPreferences.M())) {
            return false;
        }
        return !str.equals(BluedPreferences.W());
    }

    private boolean d(String str) {
        if (StringUtils.d(str) && StringUtils.d(BluedPreferences.X())) {
            return false;
        }
        return !str.equals(BluedPreferences.X());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (StringUtils.d(str)) {
            BluedPreferences.q("");
        } else {
            this.aC = true;
            if (str.equals("-1")) {
                BluedPreferences.q(str);
            } else {
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                String str2 = "";
                for (int i = 0; i < split.length; i++) {
                    str2 = (Integer.parseInt(split[i]) + 1) + "," + str2;
                    strArr[i] = (Integer.parseInt(split[i]) + 1) + "";
                }
                BluedPreferences.q(str2);
            }
        }
        B();
    }

    private void f() {
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            this.aD = false;
        } else if (aF == 2) {
            this.aD = true;
        }
        this.az = FilterHelper.d().a();
        this.aA = FilterHelper.d().b();
        this.aB = FilterHelper.d().c();
        this.ay = this.n.getResources().getStringArray(R.array.race_array_key);
    }

    private void g() {
        TwoWaysBar twoWaysBar = this.g;
        if (twoWaysBar == null || this.h == null || this.f == null || this.e == null) {
            return;
        }
        twoWaysBar.d = 1;
        if (BluedConfig.a().g().is_filter_vip == 1) {
            this.g.setEnabled(true);
            this.g.a(this.B, 100);
            this.e.setText(TwoWaysBar.a(this.n, this.B, 1));
            this.h.setEnabled(true);
            Logger.e("FilterFragment", "barTimeRange===" + this.C);
            this.h.a(this.C, 30);
            this.f.setText(TwoWaysBar.a(this.n, this.C, 2));
        } else {
            this.e.setText(TwoWaysBar.a(this.n, "", 1));
            this.f.setText(TwoWaysBar.a(this.n, "", 2));
            this.g.setEnabled(false);
            this.h.setEnabled(false);
        }
        this.g.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.5
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                FilterFragment.this.aC = true;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(i2 >= 100 ? "max" : Integer.valueOf(i2));
                BluedPreferences.v(sb.toString());
                FilterFragment.this.e.setText(TwoWaysBar.a(FilterFragment.this.n, i, i2, 1));
                FilterFragment.this.B();
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void b(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void c(boolean z) {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_DISTANCE_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                if (z) {
                    return;
                }
                PayUtils.a(FilterFragment.this.getActivity(), 24, "nearby_filter_distance");
            }
        });
        this.h.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.6
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                FilterFragment.this.aC = true;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(i2 >= 30 ? "max" : Integer.valueOf(i2));
                BluedPreferences.w(sb.toString());
                FilterFragment.this.f.setText(TwoWaysBar.a(FilterFragment.this.n, i, i2, 2));
                FilterFragment.this.B();
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void b(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void c(boolean z) {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_ONLINE_TIME_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                if (z) {
                    return;
                }
                PayUtils.a(FilterFragment.this.getActivity(), 24, "nearby_filter_time");
            }
        });
    }

    private void h() {
        this.l = (LinearLayout) this.b.findViewById(R.id.ll_filter_root);
        this.e = (TextView) this.b.findViewById(R.id.tv_distance_range);
        this.f = (TextView) this.b.findViewById(R.id.tv_time_range);
        this.g = (TwoWaysBar) this.b.findViewById(R.id.bar_distance);
        TwoWaysBar twoWaysBar = (TwoWaysBar) this.b.findViewById(R.id.bar_time);
        this.h = twoWaysBar;
        twoWaysBar.d = 2;
        String Z = BluedPreferences.Z();
        this.B = Z;
        if (TextUtils.isEmpty(Z)) {
            this.B = "0-max";
        }
        String aa = BluedPreferences.aa();
        this.C = aa;
        if (TextUtils.isEmpty(aa)) {
            this.C = "0-max";
        }
        g();
        this.ab = (ImageView) this.b.findViewById(R.id.img_filter_dot);
        if (BluedPreferences.aI()) {
            this.ab.setVisibility(8);
        } else {
            this.ab.setVisibility(0);
        }
        this.m = DialogUtils.a(getActivity());
        this.D = (ImageView) this.b.findViewById(R.id.sbt_fiter_onoff);
        this.E = (ImageView) this.b.findViewById(R.id.sbt_photo_onoff);
        this.F = (ImageView) this.b.findViewById(R.id.sbt_ai_photo_onoff);
        this.G = (ImageView) this.b.findViewById(R.id.sbt_verify_onoff);
        this.H = (ImageView) this.b.findViewById(R.id.sbt_vip_only_onoff);
        this.R = (LinearLayout) this.b.findViewById(R.id.ll_vip_only_onoff);
        this.I = (LinearLayout) this.b.findViewById(R.id.ll_fiter_race);
        this.J = (LinearLayout) this.b.findViewById(R.id.ll_fiter_onoff);
        this.K = (LinearLayout) this.b.findViewById(R.id.ll_photo_onoff);
        this.Q = (LinearLayout) this.b.findViewById(R.id.ll_AI_photo_onoff);
        this.Y = (TextView) this.b.findViewById(R.id.tv_ai_photo_desc);
        this.Q.setVisibility(0);
        this.Y.setVisibility(0);
        this.L = (LinearLayout) this.b.findViewById(R.id.ll_verify_onoff);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_filter_heis);
        this.M = linearLayout;
        linearLayout.setOnClickListener(this);
        this.O = (LinearLayout) this.b.findViewById(R.id.ll_heis);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.ll_filter_lookfor);
        this.N = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.P = (LinearLayout) this.b.findViewById(R.id.ll_lookforis);
        this.S = (TextView) this.b.findViewById(R.id.tv_fiter_race);
        this.T = (TextView) this.b.findViewById(R.id.tv_age_range);
        this.U = (TextView) this.b.findViewById(R.id.tv_height_range);
        this.V = (TextView) this.b.findViewById(R.id.tv_weight_range);
        this.W = (TextView) this.b.findViewById(R.id.tv_filter_heis);
        this.X = (TextView) this.b.findViewById(R.id.tv_filter_lookfor);
        this.Z = (ImageView) this.b.findViewById(R.id.tv_heis_arrow);
        this.aa = (ImageView) this.b.findViewById(R.id.tv_lookforis_arrow);
        this.i = (TwoWaysBar) this.b.findViewById(R.id.bar_age);
        this.j = (TwoWaysBar) this.b.findViewById(R.id.bar_height);
        this.k = (TwoWaysBar) this.b.findViewById(R.id.bar_weight);
        PhotoGridView photoGridView = (PhotoGridView) this.b.findViewById(R.id.gv_heis_bodytype);
        this.aj = photoGridView;
        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.aj, FilterFragment.this.ac, FilterFragment.this.aq, i);
            }
        });
        PhotoGridView photoGridView2 = (PhotoGridView) this.b.findViewById(R.id.gv_heis_chara);
        this.ak = photoGridView2;
        photoGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.ak, FilterFragment.this.ad, FilterFragment.this.f16504ar, i);
            }
        });
        PhotoGridView photoGridView3 = (PhotoGridView) this.b.findViewById(R.id.gv_lookfor_bodytype);
        this.al = photoGridView3;
        photoGridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.al, FilterFragment.this.af, FilterFragment.this.as, i);
            }
        });
        PhotoGridView photoGridView4 = (PhotoGridView) this.b.findViewById(R.id.gv_lookfor_want);
        this.am = photoGridView4;
        photoGridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.am, FilterFragment.this.ae, FilterFragment.this.au, i);
            }
        });
        PhotoGridView photoGridView5 = (PhotoGridView) this.b.findViewById(R.id.gv_lookfor_chara);
        this.an = photoGridView5;
        photoGridView5.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.an, FilterFragment.this.ag, FilterFragment.this.at, i);
            }
        });
        PhotoGridView photoGridView6 = (PhotoGridView) this.b.findViewById(R.id.gv_role);
        this.ao = photoGridView6;
        photoGridView6.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                FilterFragment filterFragment = FilterFragment.this;
                filterFragment.a(filterFragment.ao, FilterFragment.this.ah, FilterFragment.this.av, i);
            }
        });
        String I = BluedPreferences.I();
        this.t = I;
        b(I);
        UserTagAdapter userTagAdapter = new UserTagAdapter(this.n, this.ah);
        this.av = userTagAdapter;
        this.ao.setAdapter((ListAdapter) userTagAdapter);
        NestedScrollView nestedScrollView = (NestedScrollView) this.b.findViewById(2131369639);
        this.d = nestedScrollView;
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.13
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
            }
        });
        View findViewById = this.b.findViewById(R.id.filter_lay);
        this.ax = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        if (BluedPreferences.H()) {
            this.o = true;
            this.D.setImageResource(2131237259);
            this.ax.setVisibility(8);
        } else {
            this.o = false;
            this.D.setImageResource(2131237258);
            this.ax.setVisibility(0);
        }
        final String string = this.n.getResources().getString(R.string.unlimited);
        String K = BluedPreferences.K();
        this.u = K;
        if (TextUtils.isEmpty(K)) {
            String str = "0-" + (this.az.length - 1);
            this.u = str;
            BluedPreferences.l(str);
        }
        this.i.d = 3;
        this.T.setText(FilterHelper.d().a(this.u));
        this.i.a(this.u, this.az.length);
        this.i.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.15
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                String str2 = i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                BluedPreferences.l(str2);
                FilterFragment.this.aC = true;
                FilterFragment.this.T.setText(FilterHelper.d().a(str2));
                FilterFragment.this.B();
            }
        });
        this.w = this.aD ? BluedPreferences.M() : BluedPreferences.L();
        Logger.e("fiter_height===" + this.w, new Object[0]);
        if (TextUtils.isEmpty(this.w)) {
            String str2 = "0-" + (this.aA.length - 1);
            this.w = str2;
            if (this.aD) {
                BluedPreferences.n(str2);
            } else {
                BluedPreferences.m(str2);
            }
        }
        this.U.setText(FilterHelper.d().b(this.w));
        this.j.d = 3;
        this.j.a(this.w, this.aA.length);
        this.j.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.16
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                String str3 = i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                if (FilterFragment.this.aD) {
                    BluedPreferences.n(str3);
                } else {
                    BluedPreferences.m(str3);
                }
                FilterFragment.this.U.setText(FilterHelper.d().b(str3));
                FilterFragment.this.aC = true;
                FilterFragment.this.B();
            }
        });
        this.x = this.aD ? BluedPreferences.O() : BluedPreferences.N();
        Logger.e("fiter_height===" + this.x, new Object[0]);
        if (TextUtils.isEmpty(this.x)) {
            String str3 = "0-" + (this.aB.length - 1);
            this.x = str3;
            if (this.aD) {
                BluedPreferences.p(str3);
            } else {
                BluedPreferences.o(str3);
            }
        }
        this.V.setText(FilterHelper.d().c(this.x));
        this.k.d = 3;
        this.k.a(this.x, this.aB.length);
        this.k.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.17
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                String str4 = i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                if (FilterFragment.this.aD) {
                    BluedPreferences.p(str4);
                } else {
                    BluedPreferences.o(str4);
                }
                FilterFragment.this.V.setText(FilterHelper.d().c(str4));
                FilterFragment.this.aC = true;
                FilterFragment.this.B();
            }
        });
        this.v = BluedPreferences.T();
        i();
        PhotoGridView photoGridView7 = (PhotoGridView) this.b.findViewById(R.id.gv_relation);
        this.ap = photoGridView7;
        photoGridView7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.18
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (((UserTag) FilterFragment.this.ai.get(i)).checked == 1) {
                    ((UserTag) FilterFragment.this.ai.get(i)).checked = 0;
                } else {
                    ((UserTag) FilterFragment.this.ai.get(i)).checked = 1;
                }
                for (UserTag userTag : FilterFragment.this.ai) {
                    if (!userTag.id.equals(((UserTag) FilterFragment.this.ai.get(i)).id)) {
                        userTag.checked = 0;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                Iterator it = FilterFragment.this.ai.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UserTag userTag2 = (UserTag) it.next();
                    if (userTag2.checked == 1) {
                        if (userTag2.name.equals(string)) {
                            stringBuffer.append("-1");
                            break;
                        }
                        stringBuffer.append(userTag2.id + ",");
                    }
                }
                FilterFragment.this.e(stringBuffer.toString());
                FilterFragment.this.aw.notifyDataSetChanged();
            }
        });
        UserTagAdapter userTagAdapter2 = new UserTagAdapter(this.n, this.ai);
        this.aw = userTagAdapter2;
        this.ap.setAdapter((ListAdapter) userTagAdapter2);
        this.y = BluedPreferences.V();
        Logger.c("fiter_choosedTagId====" + this.y, new Object[0]);
        String W = BluedPreferences.W();
        this.z = W;
        this.W.setText(W);
        String X = BluedPreferences.X();
        this.A = X;
        this.X.setText(X);
        this.p = BluedPreferences.P();
        this.q = BluedPreferences.R();
        this.r = BluedPreferences.S();
        this.s = BluedPreferences.Y();
        if (BluedPreferences.P()) {
            this.E.setImageResource(2131237259);
        } else {
            this.E.setImageResource(2131237258);
        }
        if (BluedPreferences.R()) {
            this.F.setImageResource(2131237259);
        } else {
            this.F.setImageResource(2131237258);
        }
        if (BluedPreferences.S()) {
            this.G.setImageResource(2131237259);
        } else {
            this.G.setImageResource(2131237258);
        }
        if (BluedPreferences.Y()) {
            this.H.setImageResource(2131237259);
        } else {
            this.H.setImageResource(2131237258);
        }
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedPreferences.P()) {
                    FilterFragment.this.E.setImageResource(2131237258);
                } else {
                    FilterFragment.this.E.setImageResource(2131237259);
                }
                BluedPreferences.e(!BluedPreferences.P());
                FilterFragment.this.aC = true;
                FilterFragment.this.B();
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedPreferences.R()) {
                    FilterFragment.this.F.setImageResource(2131237258);
                } else {
                    FilterFragment.this.F.setImageResource(2131237259);
                }
                BluedPreferences.g(!BluedPreferences.R());
                FilterFragment.this.aC = true;
                FilterFragment.this.B();
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FilterFragment.this.ab.setVisibility(8);
                BluedPreferences.aJ();
                BluedPreferences.d(!BluedPreferences.H());
                if (BluedPreferences.H()) {
                    FilterFragment.this.D.setImageResource(2131237259);
                    FilterFragment.this.ax.setVisibility(8);
                } else {
                    FilterFragment.this.D.setImageResource(2131237258);
                    FilterFragment.this.ax.setVisibility(0);
                }
                FilterFragment.this.aC = true;
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MultiSelectFragment.a(FilterFragment.this, 0, FilterFragment.this.getString(R.string.filter_race), FilterFragment.this.getResources().getStringArray(R.array.race_array_key), BluedPreferences.U(), null);
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FilterFragment.this.ab.setVisibility(8);
                BluedPreferences.aJ();
            }
        });
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        TextView textView = (TextView) this.b.findViewById(R.id.tv_complete);
        this.aF = textView;
        textView.setOnClickListener(this);
    }

    private void i() {
        String[] stringArray = getResources().getStringArray(R.array.relation_status_array);
        stringArray[0] = getResources().getString(R.string.unlimited);
        String T = BluedPreferences.T();
        String[] split = !TextUtils.isEmpty(T) ? T.split(",") : null;
        int[] iArr = BlueAppLocal.d() ? UserRelationshipUtils.l : null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                break;
            }
            this.ai.add(new UserTag(i2 + "", stringArray[i2], 0));
            i = i2 + 1;
        }
        if (iArr != null && iArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                arrayList.add(Integer.valueOf(iArr[i4]));
                i3 = i4 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.ai.size()) {
                    break;
                }
                int i7 = i6;
                if (arrayList.contains(Integer.valueOf(i6))) {
                    this.ai.remove(i6);
                    i7 = i6 - 1;
                }
                i5 = i7 + 1;
            }
        }
        if (T.equals("-1") && this.ai.size() > 0) {
            this.ai.get(0).checked = 1;
        } else if (split != null && split.length > 0) {
            ArrayList arrayList2 = new ArrayList();
            int length2 = split.length;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= length2) {
                    break;
                }
                String str = split[i9];
                arrayList2.add((Integer.valueOf(str).intValue() - 1) + "");
                i8 = i9 + 1;
            }
            for (UserTag userTag : this.ai) {
                if (arrayList2.contains(userTag.id)) {
                    userTag.checked = 1;
                }
            }
        }
    }

    private boolean j() {
        return this.o != BluedPreferences.H();
    }

    private boolean k() {
        boolean z = true;
        String[] a2 = a(true);
        if (a2.length > 2) {
            Logger.e("isModified", "lookModify===:" + a2[2] + "===本地:" + BluedPreferences.X());
            if (!c(a2[1])) {
                if (d(a2[2])) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        return false;
    }

    private boolean l() {
        return m() || j() || u() || t() || s() || r() || x() || w() || v() || q() || p() || o() || k() || n();
    }

    private boolean m() {
        HashSet hashSet = new HashSet();
        for (UserTag userTag : this.ae) {
            if (userTag.checked == 1) {
                hashSet.add(userTag.id);
                Logger.e("isModified", "isMakeFriendModify=id==" + userTag.id.hashCode());
            }
        }
        if (this.aE.size() != hashSet.size()) {
            return true;
        }
        Logger.e("isModified", "isMakeFriendModify=default==" + this.aE + "===curret=:" + hashSet);
        Iterator<String> it = this.aE.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!hashSet.contains(next)) {
                Logger.e("isModified", "isMakeFriendModify=tag==" + next.hashCode());
                return true;
            }
        }
        Logger.e("isModified", "isMakeFriendModify=tag=fffff=false");
        return false;
    }

    private boolean n() {
        return (TextUtils.isEmpty(this.v) && !TextUtils.isEmpty(BluedPreferences.T())) || !this.v.equals(BluedPreferences.T());
    }

    private boolean o() {
        String O = this.aD ? BluedPreferences.O() : BluedPreferences.N();
        return (TextUtils.isEmpty(this.x) && !TextUtils.isEmpty(O)) || !this.x.equals(O);
    }

    private boolean p() {
        String M = this.aD ? BluedPreferences.M() : BluedPreferences.L();
        return (TextUtils.isEmpty(this.w) && !TextUtils.isEmpty(M)) || !this.w.equals(M);
    }

    private boolean q() {
        return (TextUtils.isEmpty(this.u) && !TextUtils.isEmpty(BluedPreferences.K())) || !this.u.equals(BluedPreferences.K());
    }

    private boolean r() {
        return (TextUtils.isEmpty(this.C) && !TextUtils.isEmpty(BluedPreferences.aa())) || !this.C.equals(BluedPreferences.aa());
    }

    private boolean s() {
        return (TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(BluedPreferences.Z())) || !this.B.equals(BluedPreferences.Z());
    }

    private boolean t() {
        return this.s != BluedPreferences.Y();
    }

    private boolean u() {
        return this.r != BluedPreferences.S();
    }

    private boolean v() {
        return this.q != BluedPreferences.R();
    }

    private boolean w() {
        return this.p != BluedPreferences.P();
    }

    private boolean x() {
        String d = d();
        if (TextUtils.isEmpty(d) || !TextUtils.isEmpty(BluedPreferences.I())) {
            return (TextUtils.isEmpty(d) && !TextUtils.isEmpty(BluedPreferences.I())) || !d.equals(BluedPreferences.I());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Logger.e("Filter", "setInitialData===============" + this.o);
        BluedPreferences.k(this.t);
        BluedPreferences.d(this.o);
        BluedPreferences.e(this.p);
        BluedPreferences.g(this.q);
        BluedPreferences.h(this.r);
        BluedPreferences.l(this.u);
        BluedPreferences.o(this.x);
        BluedPreferences.m(this.w);
        BluedPreferences.q(this.v);
        BluedPreferences.s(this.y);
        BluedPreferences.t(this.z);
        BluedPreferences.u(this.A);
        BluedPreferences.i(this.s);
        BluedPreferences.v(this.B);
        BluedPreferences.w(this.C);
    }

    private void z() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        this.f16505c = findViewById;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(2131369264);
        if (relativeLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16505c.findViewById(2131369264).getLayoutParams();
            layoutParams.height = DensityUtils.a(getContext(), 54.0f);
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.f16505c.setCenterText(getString(R.string.filter));
        this.f16505c.setRightText(2131887320);
        this.f16505c.setLeftClickListener(this);
        this.f16505c.setRightClickListener(this);
        this.f16505c.setCenterTextColor(2131102254);
        this.f16505c.getTitleBackground().setBackground(new ColorDrawable(0));
        this.f16505c.getRightTextView().setVisibility(8);
        ShapeTextView rightTextView = this.f16505c.getRightTextView();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) rightTextView.getLayoutParams();
        layoutParams2.rightMargin = DensityUtils.a(getContext(), 10.0f);
        rightTextView.setLayoutParams(layoutParams2);
        rightTextView.setTextColor(BluedSkinUtils.a(this.n, 2131101766));
        ImageView leftImg = this.f16505c.getLeftImg();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) leftImg.getLayoutParams();
        layoutParams3.leftMargin = DensityUtils.a(getContext(), 10.0f);
        leftImg.setLayoutParams(layoutParams3);
        leftImg.setImageDrawable(BluedSkinUtils.b(this.n, 2131233904));
    }

    public void a() {
        if (this.O.getVisibility() == 0) {
            this.Z.setImageDrawable(BluedSkinUtils.b(this.n, 2131233039));
        } else {
            this.Z.setImageDrawable(BluedSkinUtils.b(this.n, 2131233039));
        }
        if (this.P.getVisibility() == 0) {
            this.aa.setImageDrawable(BluedSkinUtils.b(this.n, 2131233039));
        } else {
            this.aa.setImageDrawable(BluedSkinUtils.b(this.n, 2131233039));
        }
    }

    public void a(final View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ViewUtils.a(view));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(300L);
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.28
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(0);
                FilterFragment.this.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.29
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = intValue;
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    public void a(View view, List<UserTag> list, UserTagAdapter userTagAdapter, int i) {
        if (list.get(i).checked == 1) {
            list.get(i).checked = 0;
        } else {
            list.get(i).checked = 1;
        }
        userTagAdapter.notifyDataSetChanged();
        if (view.getId() != 2131364210 || view.getId() != 2131364209) {
            String[] a2 = a(true);
            String str = a2[1];
            String str2 = a2[2];
            this.W.setText(str);
            this.X.setText(str2);
        }
        this.aC = true;
    }

    public void a(LinearLayout linearLayout) {
        a((View) linearLayout);
    }

    public void a(String str) {
        if (!StringUtils.d(str)) {
            String[] split = str.split(",");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return;
                }
                if (this.ac != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= this.ac.size()) {
                            break;
                        } else if (split[i2].equals(this.ac.get(i4).id)) {
                            this.ac.get(i4).checked = 1;
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
                if (this.ad != null) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= this.ad.size()) {
                            break;
                        } else if (split[i2].equals(this.ad.get(i6).id)) {
                            this.ad.get(i6).checked = 1;
                            break;
                        } else {
                            i5 = i6 + 1;
                        }
                    }
                }
                if (this.af != null) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= this.af.size()) {
                            break;
                        } else if (split[i2].equals(this.af.get(i8).id)) {
                            this.af.get(i8).checked = 1;
                            break;
                        } else {
                            i7 = i8 + 1;
                        }
                    }
                }
                if (this.ag != null) {
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= this.ag.size()) {
                            break;
                        } else if (split[i2].equals(this.ag.get(i10).id)) {
                            this.ag.get(i10).checked = 1;
                            break;
                        } else {
                            i9 = i10 + 1;
                        }
                    }
                }
                if (this.ae != null) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11;
                        if (i12 >= this.ae.size()) {
                            break;
                        } else if (split[i2].equals(this.ae.get(i12).id)) {
                            this.ae.get(i12).checked = 1;
                            this.aE.add(this.ae.get(i12).id);
                            break;
                        } else {
                            i11 = i12 + 1;
                        }
                    }
                }
                i = i2 + 1;
            }
        } else if (this.ac == null) {
        } else {
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= this.ac.size()) {
                    return;
                }
                this.ac.get(i14).checked = 0;
                i13 = i14 + 1;
            }
        }
    }

    public String[] a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        if (this.ac != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ac.size()) {
                    break;
                }
                if (this.ac.get(i2).checked == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb.append(this.ac.get(i2).id);
                    stringBuffer.append(sb.toString());
                }
                i = i2 + 1;
            }
        }
        if (this.ad != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.ad.size()) {
                    break;
                }
                if (this.ad.get(i4).checked == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb2.append(this.ad.get(i4).id);
                    stringBuffer.append(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(StringUtils.d(stringBuffer2.toString()) ? "" : ",");
                    sb3.append(this.ad.get(i4).name);
                    stringBuffer2.append(sb3.toString());
                }
                i3 = i4 + 1;
            }
        }
        if (this.af != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.af.size()) {
                    break;
                }
                if (this.af.get(i6).checked == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb4.append(this.af.get(i6).id);
                    stringBuffer.append(sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(StringUtils.d(stringBuffer3.toString()) ? "" : ",");
                    sb5.append(this.af.get(i6).name);
                    stringBuffer3.append(sb5.toString());
                }
                i5 = i6 + 1;
            }
        }
        if (this.ag != null) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= this.ag.size()) {
                    break;
                }
                if (this.ag.get(i8).checked == 1) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb6.append(this.ag.get(i8).id);
                    stringBuffer.append(sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(StringUtils.d(stringBuffer3.toString()) ? "" : ",");
                    sb7.append(this.ag.get(i8).name);
                    stringBuffer3.append(sb7.toString());
                }
                i7 = i8 + 1;
            }
        }
        if (!z && this.ae != null) {
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.ae.size()) {
                    break;
                }
                if (this.ae.get(i10).checked == 1) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb8.append(this.ae.get(i10).id);
                    stringBuffer.append(sb8.toString());
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(StringUtils.d(stringBuffer3.toString()) ? "" : ",");
                    sb9.append(this.ae.get(i10).name);
                    stringBuffer3.append(sb9.toString());
                }
                i9 = i10 + 1;
            }
        }
        return new String[]{stringBuffer.toString(), stringBuffer2.toString(), stringBuffer3.toString()};
    }

    public void b() {
        FindHttpUtils.a(this.n, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserTagAll>>() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.33
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            return;
                        }
                        FilterFragment.this.ac = ((UserTagAll) bluedEntityA.data.get(0)).type;
                        if (FilterFragment.this.ac != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= FilterFragment.this.ac.size()) {
                                    break;
                                }
                                ((UserTag) FilterFragment.this.ac.get(i2)).checked = 0;
                                i = i2 + 1;
                            }
                        }
                        FilterFragment.this.ad = ((UserTagAll) bluedEntityA.data.get(0)).character;
                        if (FilterFragment.this.ad != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= FilterFragment.this.ad.size()) {
                                    break;
                                }
                                ((UserTag) FilterFragment.this.ad.get(i4)).checked = 0;
                                i3 = i4 + 1;
                            }
                        }
                        FilterFragment.this.af = ((UserTagAll) bluedEntityA.data.get(0)).love_type;
                        if (FilterFragment.this.af != null) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= FilterFragment.this.af.size()) {
                                    break;
                                }
                                ((UserTag) FilterFragment.this.af.get(i6)).checked = 0;
                                i5 = i6 + 1;
                            }
                        }
                        FilterFragment.this.ag = ((UserTagAll) bluedEntityA.data.get(0)).love_character;
                        if (FilterFragment.this.ag != null) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= FilterFragment.this.ag.size()) {
                                    break;
                                }
                                ((UserTag) FilterFragment.this.ag.get(i8)).checked = 0;
                                i7 = i8 + 1;
                            }
                        }
                        FilterFragment.this.ae = ((UserTagAll) bluedEntityA.data.get(0)).i_want;
                        if (FilterFragment.this.ae != null) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 >= FilterFragment.this.ae.size()) {
                                    break;
                                }
                                ((UserTag) FilterFragment.this.ae.get(i10)).checked = 0;
                                i9 = i10 + 1;
                            }
                        }
                        FilterFragment.this.a(FilterFragment.this.y);
                        BluedPreferences.t(FilterFragment.this.c()[1]);
                        BluedPreferences.u(FilterFragment.this.a(true)[2]);
                        FilterFragment.this.z = BluedPreferences.W();
                        FilterFragment.this.W.setText(FilterFragment.this.z);
                        FilterFragment.this.A = BluedPreferences.X();
                        FilterFragment.this.X.setText(FilterFragment.this.A);
                        FilterFragment.this.aq = new UserTagAdapter(FilterFragment.this.n, FilterFragment.this.ac);
                        FilterFragment.this.f16504ar = new UserTagAdapter(FilterFragment.this.n, FilterFragment.this.ad);
                        FilterFragment.this.as = new UserTagAdapter(FilterFragment.this.n, FilterFragment.this.af);
                        FilterFragment.this.at = new UserTagAdapter(FilterFragment.this.n, FilterFragment.this.ag);
                        FilterFragment.this.au = new UserTagAdapter(FilterFragment.this.n, FilterFragment.this.ae);
                        FilterFragment.this.aj.setAdapter((ListAdapter) FilterFragment.this.aq);
                        FilterFragment.this.ak.setAdapter((ListAdapter) FilterFragment.this.f16504ar);
                        FilterFragment.this.al.setAdapter((ListAdapter) FilterFragment.this.as);
                        FilterFragment.this.an.setAdapter((ListAdapter) FilterFragment.this.at);
                        FilterFragment.this.am.setAdapter((ListAdapter) FilterFragment.this.au);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a(FilterFragment.this.n.getResources().getString(2131887272));
                    }
                }
            }

            public void onUIFinish() {
                DialogUtils.b(FilterFragment.this.m);
            }

            public void onUIStart() {
                DialogUtils.a(FilterFragment.this.m);
            }
        }, (IRequestHost) getFragmentActive());
    }

    public void b(final View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(ViewUtils.a(view), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.30
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(300L);
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.31
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                FilterFragment.this.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.32
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = intValue;
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    public void b(LinearLayout linearLayout) {
        b((View) linearLayout);
    }

    public void b(String str) {
        UserTag userTag = new UserTag("1", this.n.getResources().getString(2131891552), 0);
        UserTag userTag2 = new UserTag("0.5", this.n.getResources().getString(2131891551), 0);
        UserTag userTag3 = new UserTag("0", this.n.getResources().getString(2131891550), 0);
        UserTag userTag4 = new UserTag("-1", this.n.getResources().getString(2131891554), 0);
        this.ah.add(userTag);
        this.ah.add(userTag2);
        this.ah.add(userTag3);
        this.ah.add(userTag4);
        if (StringUtils.d(str)) {
            return;
        }
        String[] split = str.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            String str2 = split[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.ah.size()) {
                    UserTag userTag5 = this.ah.get(i4);
                    if (userTag5.id.equalsIgnoreCase(str2)) {
                        userTag5.checked = 1;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public String[] c() {
        return a(false);
    }

    public String d() {
        String str = "";
        if (this.ah != null) {
            int i = 0;
            String str2 = "";
            while (true) {
                str = str2;
                if (i >= this.ah.size()) {
                    break;
                }
                String str3 = str;
                if (this.ah.get(i).checked == 1) {
                    if (TextUtils.equals(this.ah.get(i).id, "0.5")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(StringUtils.d(str) ? "" : ",");
                        sb.append(this.ah.get(i).id);
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append(StringUtils.d(sb2) ? "" : ",");
                        sb3.append("0.75");
                        String sb4 = sb3.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(sb4);
                        sb5.append(StringUtils.d(sb4) ? "" : ",");
                        sb5.append("0.25");
                        str3 = sb5.toString();
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str);
                        sb6.append(StringUtils.d(str) ? "" : ",");
                        sb6.append(this.ah.get(i).id);
                        str3 = sb6.toString();
                    }
                }
                i++;
                str2 = str3;
            }
        }
        Log.v("drb", "result:" + str);
        return str;
    }

    public void e() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.f16505c;
        if (commonTopTitleNoTrans == null || commonTopTitleNoTrans.getLeftImg() == null) {
            return;
        }
        this.f16505c.getLeftImg().performClick();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.J.setFocusable(true);
        this.J.setFocusableInTouchMode(true);
        this.J.requestFocus();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 0) {
            return;
        }
        String string = this.n.getResources().getString(R.string.unlimited);
        if (i == 0) {
            this.aC = true;
            BluedPreferences.r(intent.getStringExtra("SELETEDPOSITION"));
            String U = BluedPreferences.U();
            if (StringUtils.d(U)) {
                this.S.setText(string);
            } else if ("-1".equals(U)) {
                this.S.setText(string);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                String[] split = U.split(",");
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= split.length) {
                        break;
                    }
                    String str = split[i4];
                    stringBuffer.append(this.ay[Integer.parseInt(str)] + ",");
                    i3 = i4 + 1;
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                this.S.setText(stringBuffer.toString());
            }
        } else if (i == 7) {
            this.aC = true;
            e(intent.getStringExtra("SELECTEDID"));
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        y();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                if (l()) {
                    CommonAlertDialog.a(this.n, getString(R.string.common_string_notice), getResources().getString(R.string.filter_give_up), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.26
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            FilterFragment.this.y();
                            if (FilterFragment.this.f16503a != null) {
                                FilterFragment.this.f16503a.dismiss();
                            }
                        }
                    }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    return;
                }
                FilterDialogFragment filterDialogFragment = this.f16503a;
                if (filterDialogFragment != null) {
                    filterDialogFragment.dismiss();
                    return;
                }
                return;
            case 2131363126:
            case R.id.tv_complete /* 2131371154 */:
                A();
                String[] c2 = c();
                BluedPreferences.s(c2[0]);
                BluedPreferences.t(c2[1]);
                BluedPreferences.u(a(true)[2]);
                FilterDialogFragment filterDialogFragment2 = this.f16503a;
                if (filterDialogFragment2 != null) {
                    filterDialogFragment2.dismiss();
                }
                if (this.aC) {
                    PeopleDataObserver.a().b();
                }
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_COMPLETE_BTN_CLICK, NearbyHttpUtils.a(NearbyHttpUtils.a(this.n, new FilterEntity())), BluedPreferences.H());
                return;
            case R.id.ll_filter_heis /* 2131367800 */:
                if (this.O.getVisibility() != 8) {
                    b(this.O);
                    return;
                }
                a(this.O);
                if (this.P.getVisibility() == 0) {
                    b(this.P);
                    return;
                }
                return;
            case R.id.ll_filter_lookfor /* 2131367801 */:
                if (this.P.getVisibility() != 8) {
                    b(this.P);
                    return;
                }
                a(this.P);
                if (this.O.getVisibility() == 0) {
                    b(this.O);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.pop_window_filter, viewGroup, false);
            f();
            h();
            z();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        FilterHelper.d().f();
    }

    public void onResume() {
        super.onResume();
        if (this.H == null || this.G == null) {
            return;
        }
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_filter_vip == 0) {
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackGuy.a(GuyProtos.Event.SCREEN_VIP_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                    PayUtils.a(FilterFragment.this.getActivity(), 24, "nearby_filter_vip_user");
                }
            });
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackGuy.a(GuyProtos.Event.SCREEN_AUTH_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                    PayUtils.a(FilterFragment.this.getActivity(), 24, "nearby_filter_auth_user");
                }
            });
            return;
        }
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.a(GuyProtos.Event.SCREEN_VIP_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                FilterFragment.this.aC = true;
                if (BluedPreferences.Y()) {
                    FilterFragment.this.H.setImageResource(2131237258);
                } else {
                    FilterFragment.this.H.setImageResource(2131237259);
                }
                BluedPreferences.i(!BluedPreferences.Y());
                FilterFragment.this.B();
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.a(GuyProtos.Event.SCREEN_AUTH_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                FilterFragment.this.aC = true;
                if (BluedPreferences.S()) {
                    FilterFragment.this.G.setImageResource(2131237258);
                } else {
                    FilterFragment.this.G.setImageResource(2131237259);
                }
                BluedPreferences.h(!BluedPreferences.S());
                FilterFragment.this.B();
            }
        });
    }
}
