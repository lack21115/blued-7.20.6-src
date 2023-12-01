package com.soft.blued.ui.find.fragment;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.utils.ay;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.ui.find.model.ShadowModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.setting.fragment.MapFinderSettingFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapActivity.class */
public class FindSearchMapActivity extends BaseFragment implements View.OnClickListener, AMapLocationListener, AMap.OnCameraChangeListener, LocationSource, GeocodeSearch.OnGeocodeSearchListener {
    private GeocodeSearch A;
    private String C;
    private LatLng D;
    private LatLng E;
    private double H;
    private LocationSource.OnLocationChangedListener I;
    private AMapLocationClient J;
    private AMapLocationClientOption K;
    private String L;
    private PoiItem M;
    private LatLng N;
    private PeopleGridQuickAdapter O;
    private PeopleListQuickAdapter P;
    private int Q;
    private View R;
    private TextView S;
    private FrameLayout T;
    private MapSearchPositionFragment U;
    private ImageView V;
    private int W;
    private int X;
    private View Y;
    private TextView Z;
    private TextView aa;
    private TextView ab;
    private Context ac;
    private CardView ad;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f16555c;
    private SearchView d;
    private SearchEditText e;
    private ImageView f;
    private TextView g;
    private PullToRefreshRecyclerView h;
    private RecyclerView i;
    private boolean j;
    private String o;
    private String p;
    private LinearLayout r;
    private View s;
    private int t;
    private Dialog u;
    private NoDataAndLoadFailView v;
    private LinearLayout w;
    private TextView x;
    private TextView y;
    private AMap z;
    private String b = FindSearchMapActivity.class.getSimpleName();
    private boolean k = false;
    private int l = 1;
    private int m = 0;
    private int n = 36;
    private MapView q = null;
    private PoiSearch B = null;
    private String F = "";
    private String G = "";

    /* renamed from: a  reason: collision with root package name */
    BluedUIHttpResponse f16554a = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.19

        /* renamed from: a  reason: collision with root package name */
        boolean f16568a = false;
        boolean b = false;

        public boolean onUIFailure(int i, String str) {
            this.f16568a = true;
            if (i == 4031213) {
                InstantLog.a("map_vip_dialog_show");
                this.b = true;
                return true;
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            DialogUtils.b(FindSearchMapActivity.this.u);
            FindSearchMapActivity.this.h.j();
            if (FindSearchMapActivity.this.j) {
                FindSearchMapActivity.this.P.loadMoreComplete();
                if (this.f16568a) {
                    if (FindSearchMapActivity.this.P.getItemCount() == 0) {
                        FindSearchMapActivity.this.v.b();
                    }
                } else if (FindSearchMapActivity.this.P.getItemCount() == 0) {
                    FindSearchMapActivity.this.v.a();
                }
            } else {
                FindSearchMapActivity.this.O.loadMoreComplete();
                if (this.f16568a) {
                    if (FindSearchMapActivity.this.O.getItemCount() == 0) {
                        FindSearchMapActivity.this.v.b();
                    }
                } else if (FindSearchMapActivity.this.O.getItemCount() == 0) {
                    FindSearchMapActivity.this.v.a();
                }
            }
            this.f16568a = false;
            if (this.b) {
                CommonAlertDialog.a(FindSearchMapActivity.this.getActivity(), (int) R.drawable.map_buy_vip_tip, AppUtils.a((int) R.string.map_free_over), (String) null, AppUtils.a((int) R.string.map_buy_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.19.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        InstantLog.a("map_vip_dialog_buy_click");
                        PayUtils.a(FindSearchMapActivity.this.getActivity(), 21, "map_find");
                    }
                }, (DialogInterface.OnDismissListener) null);
            }
        }

        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(FindSearchMapActivity.this.u);
        }

        public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> bluedEntity) {
            try {
                if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    if (FindSearchMapActivity.this.j) {
                        FindSearchMapActivity.this.P.setEnableLoadMore(false);
                        FindSearchMapActivity.this.P.loadMoreEnd();
                    } else {
                        FindSearchMapActivity.this.O.setEnableLoadMore(false);
                        FindSearchMapActivity.this.O.loadMoreEnd();
                    }
                    if (FindSearchMapActivity.this.l != 1) {
                        FindSearchMapActivity.I(FindSearchMapActivity.this);
                    }
                    if (BluedPreferences.H()) {
                        AppMethods.d((int) R.string.biao_find_sift_nodata);
                        return;
                    } else {
                        AppMethods.d(2131887275);
                        return;
                    }
                }
                FindSearchMapActivity.this.v.d();
                if (!FindSearchMapActivity.this.k) {
                    FindSearchMapActivity.this.k();
                }
                if (bluedEntity.extra == null || !bluedEntity.hasMore()) {
                    if (FindSearchMapActivity.this.j) {
                        FindSearchMapActivity.this.P.setEnableLoadMore(false);
                        FindSearchMapActivity.this.P.loadMoreEnd();
                    } else {
                        FindSearchMapActivity.this.O.setEnableLoadMore(false);
                        FindSearchMapActivity.this.O.loadMoreEnd();
                    }
                } else if (FindSearchMapActivity.this.j) {
                    FindSearchMapActivity.this.P.setEnableLoadMore(true);
                } else {
                    FindSearchMapActivity.this.O.setEnableLoadMore(true);
                }
                if (FindSearchMapActivity.this.l == 1) {
                    if (FindSearchMapActivity.this.j) {
                        FindSearchMapActivity.this.P.setNewData(bluedEntity.data);
                    } else {
                        FindSearchMapActivity.this.O.setNewData(bluedEntity.data);
                    }
                } else if (FindSearchMapActivity.this.j) {
                    FindSearchMapActivity.this.P.addData((Collection<? extends UserFindResult>) bluedEntity.data);
                } else {
                    FindSearchMapActivity.this.O.addData((Collection<? extends UserFindResult>) bluedEntity.data);
                }
                if (bluedEntity.extra != null) {
                    FindSearchMapActivity.this.o = ((BluedMyExtra) bluedEntity.extra).getNext_min_dist();
                    FindSearchMapActivity.this.p = ((BluedMyExtra) bluedEntity.extra).getNext_skip_uid();
                }
            } catch (Exception e) {
                if (FindSearchMapActivity.this.l != 1) {
                    FindSearchMapActivity.I(FindSearchMapActivity.this);
                }
            }
        }

        public BluedEntity<UserFindResult, BluedMyExtra> parseData(String str) {
            BluedEntity<UserFindResult, BluedMyExtra> parseData = super.parseData(str);
            if (parseData != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parseData.data.size()) {
                        break;
                    }
                    ((UserFindResult) parseData.data.get(i2)).distance = DistanceUtils.a(((UserFindResult) parseData.data.get(i2)).distance, BlueAppLocal.c(), false);
                    ((UserFindResult) parseData.data.get(i2)).last_operate = TimeAndDateUtils.a(FindSearchMapActivity.this.getActivity(), TimeAndDateUtils.c(((UserFindResult) parseData.data.get(i2)).last_operate));
                    i = i2 + 1;
                }
            }
            return parseData;
        }
    };

    static /* synthetic */ int I(FindSearchMapActivity findSearchMapActivity) {
        int i = findSearchMapActivity.l;
        findSearchMapActivity.l = i - 1;
        return i;
    }

    private void a(Bundle bundle) {
        this.q = this.R.findViewById(R.id.smapsView);
        this.s = this.R.findViewById(R.id.map_click_view);
        MapView findViewById = this.R.findViewById(R.id.smapsView);
        this.q = findViewById;
        findViewById.onCreate(bundle);
        LinearLayout linearLayout = (LinearLayout) this.R.findViewById(R.id.ll_map_animator);
        this.r = linearLayout;
        linearLayout.post(new Runnable() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.8
            @Override // java.lang.Runnable
            public void run() {
                ConstraintLayout constraintLayout = (ConstraintLayout) FindSearchMapActivity.this.R.findViewById(R.id.constraintLayout);
                FindSearchMapActivity.this.t = (constraintLayout.getHeight() - FindSearchMapActivity.this.f16555c.getHeight()) - StatusBarHelper.a(FindSearchMapActivity.this.ac);
                FindSearchMapActivity.this.r.getLayoutParams().height = FindSearchMapActivity.this.t;
                FindSearchMapActivity.this.r.requestLayout();
            }
        });
        this.w = (LinearLayout) this.R.findViewById(R.id.ll_toast);
        this.x = (TextView) this.R.findViewById(R.id.tv_toast_address);
        this.y = (TextView) this.R.findViewById(R.id.tv_toast_distance);
        if (this.z == null) {
            LatLng latLng = null;
            if (MapFindManager.a().b()) {
                latLng = new LatLng(Double.parseDouble(MapFindManager.a().c().b), Double.parseDouble(MapFindManager.a().c().f16909a));
            }
            try {
                this.A = new GeocodeSearch(getActivity());
            } catch (AMapException e) {
                e.printStackTrace();
            }
            this.A.setOnGeocodeSearchListener(this);
            this.z = this.q.getMap();
            j();
            t();
            this.z.moveCamera(CameraUpdateFactory.zoomTo(16.0f));
            if (latLng != null) {
                this.e.setText(MapFindManager.a().c().e);
                final LatLng latLng2 = latLng;
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.9
                    @Override // java.lang.Runnable
                    public void run() {
                        FindSearchMapActivity.this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 16.0f));
                    }
                }, 1000L);
            }
        }
    }

    private void a(String str) {
        String str2;
        Log.v("drb", "address:" + str);
        if (StringUtils.d(str)) {
            str = "";
        } else if (str.length() <= 12) {
            str = str + " ";
        } else if (!q()) {
            str = str.substring(0, 12) + "... ";
        }
        if (this.H < 100.0d) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            str2 = AppUtils.a((int) R.string.distance_to_me) + " " + decimalFormat.format(this.H) + " km";
        } else {
            str2 = AppUtils.a((int) R.string.distance_to_me) + " " + ((int) this.H) + " km";
        }
        String str3 = str + str2;
        this.x.setText(str);
        this.y.setText(str2);
        if (StringUtils.d(str3)) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
        }
        this.x.requestLayout();
    }

    static /* synthetic */ int b(FindSearchMapActivity findSearchMapActivity) {
        int i = findSearchMapActivity.l;
        findSearchMapActivity.l = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z, final boolean z2) {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ShadowModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.16
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ShadowModel> bluedEntityA) {
                ShadowModel shadowModel = (ShadowModel) bluedEntityA.data.get(0);
                if (shadowModel != null) {
                    if (shadowModel.has_right == 0) {
                        if (z) {
                            WebViewShowInfoFragment.show(FindSearchMapActivity.this.getActivity(), H5Url.a(46, new Object[]{UserInfo.getInstance().getLoginUserInfo().uid, "map_shadow"}), 0);
                            return;
                        }
                        return;
                    }
                    if (!shadowModel.latitude.isEmpty() && !shadowModel.longitude.isEmpty()) {
                        FindSearchMapActivity.this.N = new LatLng(Double.parseDouble(shadowModel.latitude), Double.parseDouble(shadowModel.longitude));
                        if (z) {
                            FindSearchMapActivity.this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(FindSearchMapActivity.this.N, 16.0f));
                        }
                        FindSearchMapActivity.this.ab.setText(R.string.shadow_take_effect);
                    } else if (z2) {
                        FindSearchMapActivity.this.n();
                    }
                    if (z2) {
                        FindSearchMapActivity.this.e();
                    }
                }
            }
        });
    }

    private void d() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.W = arguments.getInt("from");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.X = 1;
        this.g.setVisibility(4);
        this.S.setVisibility(4);
        this.Y.setVisibility(8);
        this.Z.setVisibility(0);
        this.aa.setVisibility(0);
        this.V.setImageResource(R.drawable.shadow_mine_icon);
        a(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!BluedPreferences.bf() || getActivity() == null) {
            return;
        }
        BluedPreferences.bg();
        InstantLog.a("map_vip_dialog_show");
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
            CommonAlertDialog.a(getActivity(), AppUtils.a((int) R.string.map_tips), AppUtils.a((int) R.string.map_is_vip_user), AppUtils.a((int) R.string.map_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
        } else {
            CommonAlertDialog.a(getActivity(), 0, AppUtils.a((int) R.string.map_tips), AppUtils.a((int) R.string.map_is_vip_user), AppUtils.a((int) R.string.map_buy_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    InstantLog.a("map_vip_dialog_buy_click");
                    PayUtils.a(FindSearchMapActivity.this.getActivity(), 21, "map_find");
                }
            }, (DialogInterface.OnDismissListener) null);
        }
    }

    private void g() {
        this.Q = PeopleGridQuickAdapter.a(getActivity());
        PullToRefreshRecyclerView findViewById = this.R.findViewById(R.id.list_view);
        this.h = findViewById;
        boolean z = true;
        findViewById.setRefreshEnabled(true);
        RecyclerView recyclerView = (RecyclerView) this.h.getRefreshableView();
        this.i = recyclerView;
        recyclerView.setClipToPadding(false);
        this.i.setScrollBarStyle(33554432);
        if (BluedPreferences.J() != 1) {
            z = false;
        }
        this.j = z;
        this.h.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.4
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                FindSearchMapActivity.this.a(true, false);
            }
        });
        if (this.j) {
            a();
        } else {
            b();
        }
    }

    private void h() {
        CommonTopTitleNoTrans findViewById = this.R.findViewById(R.id.top_title);
        this.f16555c = findViewById;
        findViewById.setOnClickListener(this);
        this.f16555c.setRightClickListener(this);
        this.f16555c.setCenterText(AppUtils.a((int) R.string.map_finder));
        this.f16555c.setRightImg(2131233922);
        this.f16555c.f();
        this.f16555c.setRightClickListener(this);
        this.f16555c.setLeftClickListener(this);
        this.f16555c.setCenterTextColor(2131101780);
    }

    private void i() {
        if (HomeActivity.f17295c != null) {
            HomeActivity.f17295c.getWindow().setSoftInputMode(51);
        }
        this.u = DialogUtils.a(getActivity());
        this.T = (FrameLayout) this.R.findViewById(R.id.search_content);
        this.v = this.R.findViewById(R.id.no_data_view);
        SearchView findViewById = this.R.findViewById(R.id.search_view);
        this.d = findViewById;
        this.e = findViewById.getEditView();
        this.d.setRootBgColor((int) android.R.color.transparent);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.H = DensityUtils.a(getContext(), 14.0f);
        shapeModel.k = ContextCompat.getColor(getContext(), 2131101780);
        this.d.setShapeModel(shapeModel);
        this.e.setTextColor(ContextCompat.getColor(getContext(), 2131102203));
        this.e.setHintTextColor(ContextCompat.getColor(getContext(), 2131101133));
        this.f = (ImageView) this.R.findViewById(R.id.iv_return_my_position);
        this.V = (ImageView) this.R.findViewById(R.id.location);
        this.Y = this.R.findViewById(R.id.shadow_setting_layout);
        this.ab = (TextView) this.R.findViewById(R.id.shadow_setting_text);
        this.Z = (TextView) this.R.findViewById(R.id.tv_shadow_ok);
        this.aa = (TextView) this.R.findViewById(R.id.tv_shadow_cancel);
        this.g = (TextView) this.R.findViewById(2131372161);
        this.S = (TextView) this.R.findViewById(2131371051);
        this.ad = (CardView) this.R.findViewById(2131362749);
        this.d.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_BAR_CLICK);
                FindSearchMapActivity.this.U.a(FindSearchMapActivity.this.L, FindSearchMapActivity.this.C);
                FindSearchMapActivity.this.T.setVisibility(0);
            }
        });
        if (p()) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.ad.getLayoutParams();
            layoutParams.setMargins(DensityUtils.a(this.ac, 10.0f), DensityUtils.a(this.ac, 40.0f), DensityUtils.a(this.ac, 10.0f), DensityUtils.a(this.ac, 40.0f));
            this.ad.setLayoutParams(layoutParams);
        }
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.aa.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.S.setOnClickListener(this);
        MapSearchPositionFragment mapSearchPositionFragment = new MapSearchPositionFragment();
        this.U = mapSearchPositionFragment;
        mapSearchPositionFragment.b = this;
        getChildFragmentManager().beginTransaction().replace(R.id.search_content, this.U).commitAllowingStateLoss();
    }

    private void j() {
        Locale c2 = LocaleUtils.c();
        if (TextUtils.equals(c2 != null ? c2.getLanguage() : "", a.V)) {
            this.z.setMapLanguage(a.V);
            ServiceSettings.getInstance().setLanguage(ay.Code);
            return;
        }
        this.z.setMapLanguage("en");
        ServiceSettings.getInstance().setLanguage("en");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.k = true;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(600L);
        this.d.startAnimation(alphaAnimation);
        this.d.setEnabled(false);
        this.g.setEnabled(false);
        this.f.setEnabled(false);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.r.getHeight(), DensityUtils.a(getActivity(), 100.0f));
        ofInt.setTarget(this.r);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FindSearchMapActivity.this.r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FindSearchMapActivity.this.r.requestLayout();
            }
        });
        ofInt.setDuration(600L).start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.w.getPaddingBottom(), DensityUtils.a(getActivity(), 10.0f));
        ofInt2.setTarget(this.w);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FindSearchMapActivity.this.w.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                FindSearchMapActivity.this.w.requestLayout();
            }
        });
        ofInt2.setDuration(600L).start();
        this.s.setVisibility(0);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.k = false;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(600L);
        this.d.startAnimation(alphaAnimation);
        this.d.setEnabled(true);
        this.g.setEnabled(true);
        this.f.setEnabled(true);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.r.getHeight(), this.t);
        ofInt.setTarget(this.r);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FindSearchMapActivity.this.r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FindSearchMapActivity.this.r.requestLayout();
            }
        });
        ofInt.setDuration(600L).start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.w.getPaddingBottom(), DensityUtils.a(getActivity(), 90.0f));
        ofInt2.setTarget(this.w);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FindSearchMapActivity.this.w.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                FindSearchMapActivity.this.w.requestLayout();
            }
        });
        ofInt2.setDuration(600L).start();
        this.s.setVisibility(8);
    }

    private void m() {
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FindSearchMapActivity.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (BluedPreferences.cs()) {
            ((TextView) this.R.findViewById(R.id.shadow_tips)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ((TextView) this.R.findViewById(R.id.shadow_tips)).setVisibility(8);
        BluedPreferences.ct();
    }

    private boolean p() {
        return this.W == 1;
    }

    private boolean q() {
        return this.X == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r() {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.fragment.FindSearchMapActivity.r():void");
    }

    private void s() {
        NearbyHttpUtils.b(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.18
            public boolean onUIFailure(int i, String str) {
                if (i == 4031219) {
                    EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_POP_SHOW);
                    InstantLog.a("map_vip_dialog_show");
                    CommonAlertDialog.a(FindSearchMapActivity.this.getActivity(), (int) R.drawable.map_buy_vip_tip, AppUtils.a((int) R.string.map_free_over), (String) null, AppUtils.a((int) R.string.map_buy_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.18.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_BTN_CLICK);
                            InstantLog.a("map_vip_dialog_buy_click");
                            PayUtils.a(FindSearchMapActivity.this.getActivity(), 21, "map_find");
                        }
                    }, (DialogInterface.OnDismissListener) null);
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
                MapFindManager.MapFindBean mapFindBean = new MapFindManager.MapFindBean();
                if (FindSearchMapActivity.this.M != null) {
                    mapFindBean.d = FindSearchMapActivity.this.M.getCityName() + FindSearchMapActivity.this.M.getAdName() + FindSearchMapActivity.this.M.getDirection();
                    StringBuilder sb = new StringBuilder();
                    sb.append(FindSearchMapActivity.this.M.getLatLonPoint().getLatitude());
                    sb.append("");
                    mapFindBean.b = sb.toString();
                    mapFindBean.f16909a = FindSearchMapActivity.this.M.getLatLonPoint().getLongitude() + "";
                    mapFindBean.f16910c = FindSearchMapActivity.this.H;
                } else if (FindSearchMapActivity.this.E == null) {
                    return;
                } else {
                    mapFindBean.d = FindSearchMapActivity.this.F;
                    mapFindBean.b = FindSearchMapActivity.this.E.latitude + "";
                    mapFindBean.f16909a = FindSearchMapActivity.this.E.longitude + "";
                    mapFindBean.f16910c = FindSearchMapActivity.this.H;
                }
                mapFindBean.f16910c = FindSearchMapActivity.this.H;
                mapFindBean.e = FindSearchMapActivity.this.e.getText().toString();
                MapFindManager.a().a(mapFindBean);
                FindSearchMapActivity.this.u();
                LiveEventBus.get(EventBusConstant.KEY_EVENT_MAP_FIND_CLICK).post(true);
            }
        }, getFragmentActive());
    }

    private void t() {
        this.z.setLocationSource(this);
        this.z.setMyLocationEnabled(false);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource((int) R.drawable.my_position));
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.strokeWidth(0.0f);
        this.z.setMyLocationStyle(myLocationStyle);
        this.z.getUiSettings().setMyLocationButtonEnabled(false);
        this.z.getUiSettings().setZoomControlsEnabled(false);
        this.z.setOnCameraChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (getParentFragment() instanceof DialogFragment) {
            ((DialogFragment) getParentFragment()).dismissAllowingStateLoss();
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void a() {
        PeopleListQuickAdapter peopleListQuickAdapter = new PeopleListQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "map_find", this.i);
        this.P = peopleListQuickAdapter;
        peopleListQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                FindSearchMapActivity.b(FindSearchMapActivity.this);
                FindSearchMapActivity.this.a(false, false);
            }
        }, this.i);
        this.i.setAdapter(this.P);
        this.i.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }

    public void a(LatLonPoint latLonPoint) {
        this.A.getFromLocationAsyn(new RegeocodeQuery(latLonPoint, 200.0f, "autonavi"));
    }

    public void a(PoiItem poiItem, String str) {
        this.M = poiItem;
        this.T.setVisibility(8);
        LatLng latLng = new LatLng(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
        this.N = latLng;
        this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
        if (StringUtils.d(str)) {
            return;
        }
        this.e.setText(str);
    }

    public void a(SearchPositionModel searchPositionModel) {
        PoiItem poiItem = new PoiItem("", new LatLonPoint(searchPositionModel.lat, searchPositionModel.lon), "", "");
        this.M = poiItem;
        this.T.setVisibility(8);
        LatLng latLng = new LatLng(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
        this.N = latLng;
        this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
        if (StringUtils.d(searchPositionModel.name)) {
            return;
        }
        this.e.setText(searchPositionModel.name);
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            this.l = 1;
        }
        int i = this.n;
        int i2 = this.l;
        FilterEntity filterEntity = new FilterEntity();
        filterEntity.f = "map";
        filterEntity.sort_by = "index";
        filterEntity.source = "map";
        filterEntity.longitude = String.valueOf(this.E.longitude);
        filterEntity.latitude = String.valueOf(this.E.latitude);
        filterEntity.nickName = "";
        filterEntity.limit = this.n + "";
        filterEntity.start = (i * (i2 - 1)) + "";
        filterEntity.column = PeopleGridQuickAdapter.a(getActivity());
        if (z2) {
            filterEntity.is_map_ok_click = "click";
        }
        if (this.l == 1) {
            NearbyHttpUtils.a(getActivity(), this.f16554a, filterEntity, "", null);
            return;
        }
        filterEntity.next_min_dist = this.o;
        filterEntity.next_skip_uid = this.p;
        NearbyHttpUtils.a(getActivity(), this.f16554a, filterEntity, "", null);
    }

    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.I = onLocationChangedListener;
        try {
            if (this.J == null) {
                this.J = new AMapLocationClient(getActivity());
            }
            this.K = new AMapLocationClientOption();
            this.J.setLocationListener(this);
            this.K.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            this.K.setOnceLocation(true);
            this.J.setLocationOption(this.K);
            this.J.startLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        PeopleGridQuickAdapter peopleGridQuickAdapter = new PeopleGridQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "map_find", this.i);
        this.O = peopleGridQuickAdapter;
        peopleGridQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.6
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                FindSearchMapActivity.b(FindSearchMapActivity.this);
                FindSearchMapActivity.this.a(false, false);
            }
        }, this.i);
        this.i.setAdapter(this.O);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), this.Q);
        this.i.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.7
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int i2 = FindSearchMapActivity.this.Q;
                if (FindSearchMapActivity.this.O.getItem(i) != 0) {
                    int itemViewType = FindSearchMapActivity.this.O.getItemViewType(i);
                    if (itemViewType != 10) {
                        return itemViewType != 11 ? FindSearchMapActivity.this.Q : FindSearchMapActivity.this.Q;
                    }
                    i2 = 1;
                }
                return i2;
            }
        });
    }

    public void c() {
        this.T.setVisibility(8);
    }

    public void deactivate() {
        this.I = null;
        AMapLocationClient aMapLocationClient = this.J;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.J.onDestroy();
        }
        this.J = null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            this.L = intent.getStringExtra("search_position");
            PoiItem parcelableExtra = intent.getParcelableExtra("lat_lon_point");
            this.M = parcelableExtra;
            LatLng latLng = new LatLng(parcelableExtra.getLatLonPoint().getLatitude(), this.M.getLatLonPoint().getLongitude());
            this.N = latLng;
            this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
            if (StringUtils.d(this.L)) {
                return;
            }
            this.e.setText(this.L);
        }
    }

    public boolean onBackPressed() {
        if (this.k) {
            l();
            return false;
        }
        EventTrackVIP.a(VipProtos.Event.MAP_FIND_BACK_BTN_CLICK);
        u();
        return false;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            LatLng latLng = cameraPosition.target;
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            this.M = null;
            LatLng latLng = new LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude);
            this.E = latLng;
            this.H = AMapUtils.calculateLineDistance(this.D, latLng) / 1000.0d;
            a(new LatLonPoint(cameraPosition.target.latitude, cameraPosition.target.longitude));
            if (this.H > 0.05d) {
                this.f.setImageResource(R.drawable.icon_return_now_position_1);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        boolean z = false;
        switch (view.getId()) {
            case 2131363120:
                EventTrackVIP.a(VipProtos.Event.MAP_FIND_BACK_BTN_CLICK);
                u();
                return;
            case 2131363126:
                InstantLog.a("map_find_setting_click");
                MapFinderSettingFragment.a(getActivity());
                return;
            case R.id.iv_return_my_position /* 2131365817 */:
                LatLng latLng = this.D;
                if (latLng != null) {
                    this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
                    this.f.setImageResource(R.drawable.icon_return_now_position_2);
                    return;
                }
                return;
            case R.id.shadow_setting_layout /* 2131369763 */:
                VipProtos.Event event = VipProtos.Event.MAP_FIND_SETTINGS_BTN_CLICK;
                boolean z2 = false;
                if (BluedConfig.a().g().is_chat_shadow == 1) {
                    z2 = true;
                }
                EventTrackVIP.a(event, z2);
                b(true, true);
                return;
            case 2131371051:
                u();
                return;
            case 2131372161:
                InstantLog.a("map_find_do_search");
                GuyProtos.Event event2 = GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CONFIRM_CLICK;
                if (BluedConfig.a().g().is_chat_shadow == 1) {
                    z = true;
                }
                EventTrackGuy.c(event2, z);
                s();
                return;
            case R.id.tv_shadow_cancel /* 2131372574 */:
                u();
                return;
            case R.id.tv_shadow_ok /* 2131372576 */:
                r();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.R = layoutInflater.inflate(R.layout.activity_find_search_map, (ViewGroup) null);
        this.ac = getActivity();
        d();
        h();
        i();
        g();
        a(bundle);
        if (p()) {
            e();
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    FindSearchMapActivity.this.b(true, true);
                }
            }, 800L);
        } else {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    FindSearchMapActivity.this.f();
                }
            }, 800L);
            b(false, false);
        }
        return this.R;
    }

    public void onDestroy() {
        super.onDestroy();
        this.q.onDestroy();
        AMapLocationClient aMapLocationClient = this.J;
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
        }
        if (HomeActivity.f17295c != null) {
            HomeActivity.f17295c.getWindow().setSoftInputMode(35);
        }
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        if (i != 1000 || geocodeResult == null || geocodeResult.getGeocodeAddressList() == null || geocodeResult.getGeocodeAddressList().size() <= 0) {
            return;
        }
        GeocodeAddress geocodeAddress = (GeocodeAddress) geocodeResult.getGeocodeAddressList().get(0);
        this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(geocodeAddress.getLatLonPoint().getLatitude(), geocodeAddress.getLatLonPoint().getLongitude()), 16.0f));
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (this.I == null || aMapLocation == null) {
            Logger.a(BrowserContract.Bookmarks.POSITION, "定位完成：mListener为空或者amapLocation为空");
        } else {
            Logger.a(BrowserContract.Bookmarks.POSITION, "定位完成：" + aMapLocation.getErrorCode() + "," + aMapLocation.getLatitude() + t.aE + aMapLocation.getLongitude());
            if (aMapLocation.getErrorCode() == 0) {
                LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                this.D = latLng;
                this.E = latLng;
                this.C = aMapLocation.getCity();
                this.I.onLocationChanged(aMapLocation);
                this.z.moveCamera(CameraUpdateFactory.newLatLngZoom(this.E, 16.0f));
                this.F = aMapLocation.getProvince() + aMapLocation.getCity() + aMapLocation.getDistrict();
                this.G = aMapLocation.getAddress();
                CommonPreferences.a(aMapLocation.getLongitude(), aMapLocation.getLatitude());
            } else {
                this.F = "";
                this.G = "";
                AppMethods.a("2131891191(" + aMapLocation.getErrorCode() + ")");
                BluedStatistics.c().a("MAP_LOCATION", 0L, aMapLocation.getErrorCode(), aMapLocation.getLocationDetail());
            }
            this.F = "";
            this.G = "";
        }
        if (q()) {
            a(this.G);
        } else {
            a(this.F);
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(FindSearchMapActivity.class.getSimpleName());
        MobclickAgent.onPause(getActivity());
        this.q.onPause();
        deactivate();
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i != 1000) {
            this.F = "";
        } else if (regeocodeResult == null || regeocodeResult.getRegeocodeAddress() == null || regeocodeResult.getRegeocodeAddress().getFormatAddress() == null) {
            this.F = "";
        } else {
            RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
            this.F = regeocodeAddress.getProvince() + regeocodeAddress.getCity() + regeocodeAddress.getDistrict();
            this.G = regeocodeAddress.getFormatAddress();
            Log.v("drb", "街道:" + regeocodeAddress.getCrossroads() + " -- " + regeocodeAddress.getFormatAddress() + " -- " + regeocodeAddress.getStreetNumber() + " -- " + regeocodeAddress.getNeighborhood() + " -- " + regeocodeAddress.getBuilding());
        }
        if (q()) {
            a(this.G);
        } else {
            a(this.F);
        }
    }

    public void onResume() {
        this.q.onResume();
        super.onResume();
        MobclickAgent.onPageStart(FindSearchMapActivity.class.getSimpleName());
        MobclickAgent.onResume(getActivity());
        if (this.s.getVisibility() == 0) {
            m();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.q.onSaveInstanceState(bundle);
    }
}
