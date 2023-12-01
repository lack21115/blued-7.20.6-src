package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amap.api.maps.AMapUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.adapter.MapChanceEncounterAdapter;
import com.soft.blued.ui.find.fragment.MapSearchPositionFragment;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.manager.MapSearchHistoryManager;
import com.soft.blued.ui.find.model.MapAvatarUserModel;
import com.soft.blued.ui.find.model.MapChanceEncounterModel;
import com.soft.blued.ui.find.model.MapChanceEncounterStatusModel;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.ui.find.model.ShadowModel;
import com.soft.blued.ui.find.model.UserHeaderLocationModel;
import com.soft.blued.ui.find.view.CustomCircleView;
import com.soft.blued.ui.find.view.FindSearchMapBottomDialog;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.ScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapFragment.class */
public class FindSearchMapFragment extends BaseSearchMapFragment implements View.OnClickListener, GeocodeSearch.OnGeocodeSearchListener, TencentMap.OnCameraChangeListener {
    private UserHeaderLocationModel D;
    private Marker E;
    private Marker F;
    private LatLng G;
    private int H;
    private View K;
    private ImageView L;
    private ImageView M;
    private View N;
    private View O;
    private ImageView P;
    private ImageView Q;
    private MapChanceEncounterAdapter S;
    @BindView
    ShapeConstraintLayout btnChanceEncounter;
    @BindView
    FrameLayout chanceEncounterGuide;
    @BindView
    RecyclerView chanceEncounterRecyclerView;
    @BindView
    ShapeLinearLayout chanceEncounterView;
    @BindView
    CustomCircleView circleGuideView;
    @BindView
    ConstraintLayout clGuide1;
    @BindView
    ConstraintLayout clGuide2;
    @BindView
    ConstraintLayout clGuide3;
    @BindView
    ConstraintLayout clMapSearch;
    @BindView
    ConstraintLayout clShadowSetting;
    @BindView
    FrameLayout flChanceEncounterBg;
    private TencentMap g;
    @BindView
    ImageView ivChanceEncounter;
    @BindView
    ImageView ivChanceEncounterViewClose;
    @BindView
    ImageView ivLeftClose;
    @BindView
    ImageView ivLocation;
    @BindView
    ImageView ivMapSearch;
    @BindView
    ImageView ivRefreshPosition;
    @BindView
    ImageView ivReturnMyPosition;
    @BindView
    ImageView ivSearchShadowGuide;
    @BindView
    ImageView ivSetShadowGuide;
    @BindView
    ImageView ivShadowPosition;
    @BindView
    ImageView ivStartHeaderLocation;
    private Context k;
    private PoiItem l;
    @BindView
    LinearLayout llGuide4;
    @BindView
    LinearLayout llMapAnimator;
    @BindView
    LinearLayout llRefreshReturn;
    @BindView
    LinearLayout llSearchShadow;
    private LatLng m;
    @BindView
    TextureMapView mapView;
    private LatLng n;
    private String o;
    private double r;
    private String s;
    @BindView
    FrameLayout searchContent;
    @BindView
    ShapeTextView searchView;
    private MapSearchPositionFragment t;
    @BindView
    ToggleButton toggleButtonChanceEncounter;
    @BindView
    TextView tvCancel;
    @BindView
    TextView tvChanceEncounter;
    @BindView
    ShapeTextView tvChanceEncounterRemind;
    @BindView
    TextView tvChanceEncounterStatus;
    @BindView
    ShapeTextView tvCurrentLocation;
    @BindView
    TextView tvFirstFree;
    @BindView
    ShapeTextView tvHeaderOption;
    @BindView
    TextView tvNoData;
    @BindView
    TextView tvSearchMapSubtitle;
    @BindView
    TextView tvShadowContent;
    @BindView
    ShapeTextView tvTryMoveMap;
    private GeocodeSearch u;
    private Marker v;
    private ShadowModel w;
    private LatLng x;
    private int z;
    private String p = "";
    private String q = "";
    private boolean y = false;
    private boolean A = false;
    private boolean B = true;
    private boolean C = true;
    private boolean I = false;
    private boolean J = false;
    private boolean R = false;
    private boolean T = true;
    ArrayList<Marker> f = new ArrayList<>();
    private boolean U = false;
    private final double V = 6378137.0d;

    /* renamed from: com.soft.blued.ui.find.fragment.FindSearchMapFragment$16  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapFragment$16.class */
    class AnonymousClass16 extends BluedUIHttpResponse {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f30278a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(IRequestHost iRequestHost, boolean z) {
            super(iRequestHost);
            this.f30278a = z;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.FindSearchMapFragment$24  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapFragment$24.class */
    class AnonymousClass24 extends BluedUIHttpResponse<BluedEntityA<MapChanceEncounterModel>> {
        AnonymousClass24(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<MapChanceEncounterModel> bluedEntityA) {
            if (bluedEntityA != null) {
                FindSearchMapFragment.this.a(bluedEntityA.data);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            FindSearchMapFragment.this.a((List<MapChanceEncounterModel>) null);
            return true;
        }
    }

    /* renamed from: com.soft.blued.ui.find.fragment.FindSearchMapFragment$26  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapFragment$26.class */
    class AnonymousClass26 extends BluedUIHttpResponse<BluedEntityA<MapChanceEncounterModel>> {
        AnonymousClass26(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<MapChanceEncounterModel> bluedEntityA) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        new FindSearchMapBottomDialog.Builder(this.k).a(2).a(this.k.getResources().getDrawable(R.drawable.icon_vip_bottom_dialog)).a(a(R.string.pay_vip_for_location)).b(a(R.string.unlimited_use)).a(a(R.string.map_buy_now), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.11
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
            public void a(Dialog dialog, boolean z) {
                InstantLog.a("map_vip_dialog_buy_click");
                PayUtils.a(FindSearchMapFragment.this.k, 21, "nearby_friend_avatar_loc", VipProtos.FromType.NEARBY_FRIEND_AVATAR_LOC);
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_CLICK);
            }
        }).b(a(R.string.in_scope_btn_str), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                FindSearchMapFragment.this.c(true);
                FindSearchMapFragment.this.A = true;
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_AVATAR_LOC_CLICK);
            }
        }).a().show();
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_SHOW);
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_AVATAR_LOC_SHOW);
    }

    private void B() {
        if (this.D == null) {
            return;
        }
        Drawable drawable = this.k.getResources().getDrawable(R.drawable.icon_header_location_dialog);
        if (this.z == 1) {
            drawable = this.k.getResources().getDrawable(R.drawable.icon_header_shadow_location_dialog);
        }
        new FindSearchMapBottomDialog.Builder(this.k).a(1).a(drawable).g(a(R.string.show_your_header_location)).h(a(R.string.others_can_see_where_are_you)).c(Boolean.valueOf(this.A)).a(a(2131887320), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.15
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
            public void a(Dialog dialog, boolean z) {
                if (z) {
                    FindSearchMapFragment.this.b(true);
                } else {
                    FindSearchMapFragment.this.c(false);
                }
                FindSearchMapFragment.this.A = z;
            }
        }).a().show();
    }

    private void C() {
        boolean z = true;
        if (this.w.is_open_shadow != 1) {
            z = false;
        }
        FindSearchMapBottomDialog.Builder builder = new FindSearchMapBottomDialog.Builder(this.k);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double b = b(this.x, this.f30189c);
        if (z) {
            final boolean z2 = z;
            builder.a(4).b(Boolean.valueOf(z)).c(a(R.string.shadow_mine)).d(a(R.string.shadow_is_open)).e(decimalFormat.format(b / 1000.0d) + "km").f(this.q).a(a(R.string.delete_shadow), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.18
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    MineHttpUtils.b(new BluedUIHttpResponse(FindSearchMapFragment.this.getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.18.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            FindSearchMapFragment.this.clShadowSetting.setVisibility(0);
                            FindSearchMapFragment.this.ivMapSearch.setImageDrawable(FindSearchMapFragment.this.k.getDrawable(R.drawable.icon_bg_map_find_people));
                            FindSearchMapFragment.this.ivShadowPosition.setVisibility(8);
                            FindSearchMapFragment.this.x = null;
                            FindSearchMapFragment.this.tvShadowContent.setText(FindSearchMapFragment.this.a(R.string.set_up_shadow));
                            if (FindSearchMapFragment.this.A) {
                                if (FindSearchMapFragment.this.F != null) {
                                    FindSearchMapFragment.this.F.remove();
                                }
                            } else if (FindSearchMapFragment.this.v != null) {
                                FindSearchMapFragment.this.v.remove();
                            }
                        }
                    });
                }
            }).a(a(2131887320), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.17
                /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
                @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
                public void a(Dialog dialog, boolean z3) {
                    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                }
            }).a().show();
            return;
        }
        final boolean z3 = z;
        builder.a(4).b(Boolean.valueOf(z)).c(a(R.string.shadow_mine)).d(a(R.string.shadow_is_close)).e(decimalFormat.format(b / 1000.0d) + "km").f(this.q).a(a(2131887320), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.19
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
            public void a(Dialog dialog, boolean z4) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        }).a().show();
    }

    private void D() {
        NearbyHttpUtils.b(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.20
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 4031219) {
                    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CONFIRM_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0, false, FindSearchMapFragment.this.y);
                    EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_POP_SHOW);
                    InstantLog.a("map_vip_dialog_show");
                    CommonAlertDialog.a(FindSearchMapFragment.this.k, (int) R.drawable.map_buy_vip_tip, AppUtils.a((int) R.string.map_free_over), (String) null, AppUtils.a((int) R.string.map_buy_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.20.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_BTN_CLICK);
                            InstantLog.a("map_vip_dialog_buy_click");
                            PayUtils.a(FindSearchMapFragment.this.k, 21, "nearby_friend_non_trial_find", VipProtos.FromType.NEARBY_FRIEND_MAP_FIND_NONE_TRIAL);
                        }
                    }, (DialogInterface.OnDismissListener) null);
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    CommonAlertDialog.a(FindSearchMapFragment.this.k, 0, AppUtils.a((int) R.string.map_tips), AppUtils.a((int) R.string.map_is_vip_user), AppUtils.a((int) R.string.map_buy_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.20.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            InstantLog.a("map_vip_dialog_buy_click");
                            PayUtils.a(FindSearchMapFragment.this.k, 21, "nearby_friend_trial_find", VipProtos.FromType.NEARBY_FRIEND_MAP_FIND_TRIAL);
                            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_POP_UP_BUY_CLICK);
                        }
                    }, FindSearchMapFragment.this.a(R.string.use_the_free), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.20.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            FindSearchMapFragment.this.E();
                            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_POP_UP_TRIAL_CLICK);
                            NearbyHttpUtils.a();
                        }
                    }, (DialogInterface.OnDismissListener) null, 0);
                } else {
                    FindSearchMapFragment.this.E();
                }
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CONFIRM_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0, true, FindSearchMapFragment.this.y);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        MapFindManager.MapFindBean mapFindBean = new MapFindManager.MapFindBean();
        if (this.l != null) {
            mapFindBean.d = this.l.getCityName() + this.l.getAdName() + this.l.getDirection();
            StringBuilder sb = new StringBuilder();
            sb.append(this.l.getLatLonPoint().getLatitude());
            sb.append("");
            mapFindBean.b = sb.toString();
            mapFindBean.f30599a = this.l.getLatLonPoint().getLongitude() + "";
            mapFindBean.f30600c = this.r;
        } else if (this.n == null) {
            return;
        } else {
            mapFindBean.d = this.p;
            mapFindBean.b = this.n.latitude + "";
            mapFindBean.f30599a = this.n.longitude + "";
            mapFindBean.f30600c = this.r;
        }
        mapFindBean.f30600c = this.r;
        mapFindBean.e = this.searchView.getText().toString();
        MapFindManager.a().a(mapFindBean);
        P();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_MAP_FIND_CLICK).post(true);
        if (this.H == 1) {
            HomeArgumentHelper.a(this.k, "find", (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ShadowModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.21
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ShadowModel> bluedEntityA) {
                FindSearchMapFragment.this.w = bluedEntityA.data.get(0);
                if (FindSearchMapFragment.this.w != null) {
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    findSearchMapFragment.y = findSearchMapFragment.w.has_right == 1;
                    FindSearchMapFragment.this.ivShadowPosition.setVisibility(FindSearchMapFragment.this.w.is_open_shadow == 1 ? 0 : 8);
                    FindSearchMapFragment.this.t.b(FindSearchMapFragment.this.w.has_right);
                    FindSearchMapFragment findSearchMapFragment2 = FindSearchMapFragment.this;
                    findSearchMapFragment2.z = findSearchMapFragment2.w.is_open_shadow;
                    if (FindSearchMapFragment.this.T) {
                        FindSearchMapFragment.this.L();
                        FindSearchMapFragment.this.T = false;
                    }
                    if (!FindSearchMapFragment.this.w.latitude.isEmpty() && !FindSearchMapFragment.this.w.longitude.isEmpty()) {
                        FindSearchMapFragment findSearchMapFragment3 = FindSearchMapFragment.this;
                        findSearchMapFragment3.x = new LatLng(Double.parseDouble(findSearchMapFragment3.w.latitude), Double.parseDouble(FindSearchMapFragment.this.w.longitude));
                        if (FindSearchMapFragment.this.w.is_open_shadow == 1) {
                            FindSearchMapFragment.this.tvShadowContent.setText(FindSearchMapFragment.this.a(R.string.move_shadow_here));
                            FindSearchMapFragment findSearchMapFragment4 = FindSearchMapFragment.this;
                            findSearchMapFragment4.a(findSearchMapFragment4.x, FindSearchMapFragment.this.A);
                            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_SHADOW_MANAGEMENT_SHOW);
                        } else {
                            FindSearchMapFragment.this.tvShadowContent.setText(FindSearchMapFragment.this.a(R.string.set_up_shadow));
                        }
                    }
                    if (FindSearchMapFragment.this.H != 1 || FindSearchMapFragment.this.x == null) {
                        return;
                    }
                    FindSearchMapFragment.this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(FindSearchMapFragment.this.x, 16.0f));
                }
            }
        });
        EventTrackGuy.c(GuyProtos.Event.NEARBY_FRIEND_SHOW, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (BluedPreferences.ah(UserInfo.getInstance().getLoginUserInfo().uid)) {
            return;
        }
        if (this.B) {
            this.ivChanceEncounter.setImageDrawable(this.k.getResources().getDrawable(R.drawable.icon_map_chance_encounter_opened));
            this.tvChanceEncounter.setTextColor(this.k.getResources().getColor(2131102163));
            return;
        }
        this.ivChanceEncounter.setImageDrawable(this.k.getResources().getDrawable(R.drawable.icon_map_chance_encounter_colsed));
        this.tvChanceEncounter.setTextColor(this.k.getResources().getColor(2131102206));
    }

    private void H() {
        FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MapChanceEncounterStatusModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.23
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MapChanceEncounterStatusModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                MapChanceEncounterStatusModel singleData = bluedEntityA.getSingleData();
                if (FindSearchMapFragment.this.B && singleData.is_update && FindSearchMapFragment.this.tvChanceEncounterRemind.getVisibility() == 8) {
                    FindSearchMapFragment.this.tvChanceEncounterRemind.setVisibility(0);
                    EventTrackVIP.b(VipProtos.Event.MAP_FIND_PASSBY_POP_RED_DOT_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade);
                }
            }
        }, getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().uid, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void I() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.R = true;
        this.flChanceEncounterBg.setVisibility(0);
        this.chanceEncounterView.setVisibility(0);
        this.toggleButtonChanceEncounter.setChecked(this.B);
        if (this.B) {
            this.tvChanceEncounterStatus.setText(R.string.chance_encounter_opened);
        } else {
            this.tvChanceEncounterStatus.setText(R.string.chance_encounter_closed);
        }
        this.toggleButtonChanceEncounter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.25
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                EventTrackVIP.a(VipProtos.Event.MAP_FIND_PASSBY_POP_SWITCH_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, z);
                FindSearchMapFragment.this.B = z;
                if (z) {
                    FindSearchMapFragment.this.tvChanceEncounterStatus.setText(R.string.chance_encounter_opened);
                    FindSearchMapFragment.this.I();
                } else {
                    FindSearchMapFragment.this.tvChanceEncounterStatus.setText(R.string.chance_encounter_closed);
                }
                FindSearchMapFragment.this.K();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void K() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.D == null || !BluedPreferences.aj(UserInfo.getInstance().getLoginUserInfo().uid)) {
            return;
        }
        long j = this.D.dayTime * 60 * 60 * 1000;
        long time = new Date().getTime();
        long ek = BluedPreferences.ek();
        Log.e("lyl", "intervalTime: " + j);
        Log.e("lyl", "nowTime: " + time);
        Log.e("lyl", "lastTime: " + ek);
        if (time - ek <= j || this.D.avatar_location_status == 1) {
            return;
        }
        M();
        BluedPreferences.r(time);
    }

    private void M() {
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_INIT_AVATAR_LOC_POP_SHOW);
        Drawable drawable = this.k.getResources().getDrawable(R.drawable.icon_header_location_dialog);
        if (this.z == 1) {
            drawable = this.k.getResources().getDrawable(R.drawable.icon_header_shadow_location_dialog);
        }
        new FindSearchMapBottomDialog.Builder(this.k).a(0).a(drawable).a((Boolean) true).a(a(R.string.show_your_header_location)).b(a(R.string.others_can_see_where_are_you)).i(a(R.string.dont_remind_next_time)).a(a(R.string.confirm_open), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.28
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
            public void a(Dialog dialog, boolean z) {
                if (z) {
                    BluedPreferences.ak(UserInfo.getInstance().getLoginUserInfo().uid);
                }
                FindSearchMapFragment.this.b(true);
                FindSearchMapFragment.this.A = true;
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_INIT_AVATAR_LOC_OPEN_CLICK);
            }
        }).a(new FindSearchMapBottomDialog.DismissListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.27
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.DismissListener
            public void a(Dialog dialog, boolean z) {
                if (z) {
                    BluedPreferences.ak(UserInfo.getInstance().getLoginUserInfo().uid);
                }
            }
        }).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        LatLng latLng;
        LatLng latLng2;
        if (this.g == null) {
            return;
        }
        if (this.A) {
            latLng = this.f30189c;
            latLng2 = this.x;
        } else {
            latLng = null;
            latLng2 = null;
        }
        if (this.f.size() > 0) {
            Iterator<Marker> it = this.f.iterator();
            while (it.hasNext()) {
                Marker next = it.next();
                if (next != null) {
                    next.remove();
                }
            }
        }
        VisibleRegion visibleRegion = this.g.getProjection().getVisibleRegion();
        float a2 = a(visibleRegion.nearLeft, visibleRegion.nearRight);
        float a3 = DensityUtil.a(AppInfo.l);
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MapAvatarUserModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.29
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MapAvatarUserModel> bluedEntityA) {
                List<MapAvatarUserModel> list = bluedEntityA.data;
                ArrayList arrayList = new ArrayList();
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (MapAvatarUserModel mapAvatarUserModel : list) {
                    arrayList.add(mapAvatarUserModel.uid + "");
                    if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || FindSearchMapFragment.this.y) {
                        FindSearchMapFragment.this.c(mapAvatarUserModel);
                    } else {
                        LatLng latLng3 = new LatLng(Double.parseDouble(mapAvatarUserModel.location.latitude), Double.parseDouble(mapAvatarUserModel.location.longitude));
                        FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                        float a4 = findSearchMapFragment.a(latLng3, findSearchMapFragment.f30189c);
                        if (mapAvatarUserModel.chat_room_id > 0) {
                            FindSearchMapFragment.this.b(mapAvatarUserModel);
                        } else if (!FindSearchMapFragment.this.A) {
                            FindSearchMapFragment.this.a(mapAvatarUserModel);
                        } else if (a4 > 1000.0f) {
                            FindSearchMapFragment.this.a(mapAvatarUserModel);
                        } else {
                            FindSearchMapFragment.this.c(mapAvatarUserModel);
                        }
                    }
                }
            }
        }, e(), v(), (a2 / a3) + "", "57", latLng, latLng2);
    }

    private void O() {
        if (!this.y) {
            WebViewShowInfoFragment.show(this.k, H5Url.a(46, UserInfo.getInstance().getLoginUserInfo().uid, "nearby_friend_set_shadow"), 0);
        } else if (this.r < 1.0d) {
            CommonAlertDialog.a(this.k, "", a(R.string.shadow_so_near), AppUtils.a((int) R.string.submit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.33
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    FindSearchMapFragment.this.b(1);
                }
            }, AppUtils.a((int) R.string.change_the_position), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (!this.R) {
            if (getActivity() != null) {
                getActivity().finish();
                ActivityChangeAnimationUtils.c(getActivity());
                return;
            }
            return;
        }
        this.B = this.toggleButtonChanceEncounter.isChecked();
        K();
        this.chanceEncounterView.setVisibility(8);
        this.flChanceEncounterBg.setVisibility(8);
        this.R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(LatLng latLng, LatLng latLng2) {
        return AMapUtils.calculateLineDistance(a(latLng), a(latLng2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private com.amap.api.maps.model.LatLng a(LatLng latLng) {
        return new com.amap.api.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    public static void a(BaseFragmentActivity baseFragmentActivity, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("from_page", i);
        TerminalActivity.a(bundle);
        TerminalActivity.e(baseFragmentActivity, FindSearchMapFragment.class, bundle);
        if (baseFragmentActivity instanceof Activity) {
            ActivityChangeAnimationUtils.a(baseFragmentActivity);
        }
    }

    public static void a(BaseFragmentActivity baseFragmentActivity, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("from_page", i);
        bundle.putBoolean("is_open_map_chance_encounter_dialog", z);
        TerminalActivity.a(bundle);
        TerminalActivity.e(baseFragmentActivity, FindSearchMapFragment.class, bundle);
        if (baseFragmentActivity instanceof Activity) {
            ActivityChangeAnimationUtils.a(baseFragmentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MapAvatarUserModel mapAvatarUserModel) {
        ImageLoader.a(getFragmentActive(), mapAvatarUserModel.avatar).b(2131237310).c().d().a(new CustomTarget<Drawable>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.30
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                FindSearchMapFragment.this.P.setImageDrawable(drawable);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.zIndex(-1.0f);
                markerOptions.position(new LatLng(Double.parseDouble(mapAvatarUserModel.location.latitude), Double.parseDouble(mapAvatarUserModel.location.longitude)));
                FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                Bitmap a2 = findSearchMapFragment.a(findSearchMapFragment.N);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(a2));
                Marker addMarker = FindSearchMapFragment.this.g.addMarker(markerOptions);
                addMarker.setTitle(mapAvatarUserModel.uid + "");
                addMarker.setSnippet(mapAvatarUserModel.is_shadow + "");
                FindSearchMapFragment.this.a(addMarker);
                FindSearchMapFragment.this.f.add(addMarker);
                a2.recycle();
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LatLng latLng, boolean z) {
        if (this.g == null) {
            return;
        }
        Marker marker = this.v;
        if (marker != null) {
            marker.remove();
            this.v = null;
        }
        Marker marker2 = this.F;
        if (marker2 != null) {
            marker2.remove();
            this.F = null;
        }
        if (z) {
            ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().avatar).b(2131237310).c().a(new CustomTarget<Drawable>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.36
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    FindSearchMapFragment.this.M.setImageDrawable(drawable);
                    FindSearchMapFragment.this.L.setImageDrawable(FindSearchMapFragment.this.k.getResources().getDrawable(R.drawable.icon_avatar_user_shadow));
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    Bitmap a2 = findSearchMapFragment.a(findSearchMapFragment.K);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(a2));
                    FindSearchMapFragment findSearchMapFragment2 = FindSearchMapFragment.this;
                    findSearchMapFragment2.F = findSearchMapFragment2.g.addMarker(markerOptions);
                    FindSearchMapFragment.this.F.setTitle(UserInfo.getInstance().getLoginUserInfo().uid);
                    FindSearchMapFragment.this.F.setSnippet("0");
                    FindSearchMapFragment findSearchMapFragment3 = FindSearchMapFragment.this;
                    findSearchMapFragment3.a(findSearchMapFragment3.F);
                    a2.recycle();
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable) {
                }
            });
            return;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_shadow_location);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(decodeResource));
        this.v = this.g.addMarker(markerOptions);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(2000L);
        this.v.setAnimation(scaleAnimation);
        this.v.startAnimation();
        decodeResource.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = str;
        userBasicModel.is_shadow = i;
        UserInfoFragmentNew.a(this.k, userBasicModel, "map_avatart_location", false, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MapChanceEncounterModel> list) {
        if (list == null || list.size() <= 0) {
            this.tvNoData.setVisibility(0);
            this.tvFirstFree.setVisibility(8);
            return;
        }
        this.S.setNewData(list);
        this.tvFirstFree.setVisibility(0);
        this.tvNoData.setVisibility(8);
        this.tvFirstFree.setVisibility(0);
    }

    private double b(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        double d = (latLng.latitude * 3.141592653589793d) / 180.0d;
        double d2 = (latLng2.latitude * 3.141592653589793d) / 180.0d;
        return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((d - d2) / 2.0d), 2.0d) + ((Math.cos(d) * Math.cos(d2)) * Math.pow(Math.sin((((latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d) / 2.0d), 2.0d)))) * 2.0d) * 6378137.0d) * 10000.0d) / 10000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        String str;
        String str2;
        if (this.l != null) {
            str = this.l.getLatLonPoint().getLatitude() + "";
            str2 = this.l.getLatLonPoint().getLongitude() + "";
        } else if (this.n != null) {
            str = this.n.latitude + "";
            str2 = this.n.longitude + "";
        } else {
            str = "";
            str2 = str;
        }
        String str3 = !TextUtils.isEmpty(this.q) ? this.q : this.p;
        if (!TextUtils.isEmpty(str3)) {
            MapSearchHistoryManager.a().a(new SearchPositionModel(str3, Double.valueOf(str).doubleValue(), Double.valueOf(str2).doubleValue()));
        }
        EventTrackVIP.a(VipProtos.Event.MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK, str, str2);
        MineHttpUtils.a(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.34
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str4) {
                AppMethods.d((int) R.string.shadow_set_success);
                return super.onUIFailure(i2, str4);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (i == 1) {
                    AppMethods.d((int) R.string.shadow_set_success);
                } else {
                    AppMethods.d((int) R.string.shadow_set_closed);
                }
                if (FindSearchMapFragment.this.v != null) {
                    FindSearchMapFragment.this.v.remove();
                    FindSearchMapFragment.this.v = null;
                }
                if (FindSearchMapFragment.this.F != null) {
                    FindSearchMapFragment.this.F.remove();
                    FindSearchMapFragment.this.F = null;
                }
                if (i == 1) {
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    findSearchMapFragment.x = findSearchMapFragment.n;
                    FindSearchMapFragment findSearchMapFragment2 = FindSearchMapFragment.this;
                    findSearchMapFragment2.a(findSearchMapFragment2.x, FindSearchMapFragment.this.A);
                    FindSearchMapFragment.this.ivShadowPosition.setVisibility(0);
                    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_SHADOW_MANAGEMENT_SHOW);
                    FindSearchMapFragment.this.clShadowSetting.setVisibility(8);
                    FindSearchMapFragment.this.ivMapSearch.setImageDrawable(FindSearchMapFragment.this.k.getDrawable(R.drawable.icon_bg_map_find_people_long));
                }
                FindSearchMapFragment.this.z = i;
                FindSearchMapFragment.this.w.is_open_shadow = i;
            }
        }, str3, str2, str, i + "");
    }

    public static void b(BaseFragmentActivity baseFragmentActivity, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("from_page", i);
        bundle.putBoolean("is_map_find", true);
        TerminalActivity.a(bundle);
        TerminalActivity.e(baseFragmentActivity, FindSearchMapFragment.class, bundle);
        if (baseFragmentActivity instanceof Activity) {
            ActivityChangeAnimationUtils.a(baseFragmentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MapAvatarUserModel mapAvatarUserModel) {
        StringBuilder sb;
        VipProtos.Event event = VipProtos.Event.MAP_FIND_USER_SHOW;
        if (mapAvatarUserModel.chat_room_id > 0) {
            sb = new StringBuilder();
            sb.append(mapAvatarUserModel.chat_room_id);
        } else {
            sb = new StringBuilder();
            sb.append(mapAvatarUserModel.uid);
        }
        sb.append("");
        EventTrackVIP.a(event, sb.toString(), mapAvatarUserModel.chat_room_id > 0 ? "yy" : "user", false);
        ImageLoader.a(getFragmentActive(), mapAvatarUserModel.avatar).b(2131237310).c().a(new CustomTarget<Drawable>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.31
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                FindSearchMapFragment.this.Q.setImageDrawable(drawable);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.zIndex(-1.0f);
                markerOptions.position(new LatLng(Double.parseDouble(mapAvatarUserModel.location.latitude), Double.parseDouble(mapAvatarUserModel.location.longitude)));
                FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                Bitmap a2 = findSearchMapFragment.a(findSearchMapFragment.O);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(a2));
                Marker addMarker = FindSearchMapFragment.this.g.addMarker(markerOptions);
                addMarker.setTitle(mapAvatarUserModel.uid + "-" + mapAvatarUserModel.chat_room_id);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(mapAvatarUserModel.is_shadow);
                addMarker.setSnippet(sb2.toString());
                FindSearchMapFragment.this.a(addMarker);
                FindSearchMapFragment.this.f.add(addMarker);
                a2.recycle();
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    private void b(String str, boolean z) {
        if (getFragmentActive().isActive()) {
            Log.e("lyl", "address:" + str);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (StringUtils.d(str)) {
                str = "";
            } else if (str.length() > 8) {
                try {
                    if (Double.parseDouble(decimalFormat.format(this.r)) > 999.0d) {
                        str = str.substring(0, 7) + "... ";
                    } else {
                        str = str.substring(0, 8) + "... ";
                    }
                } catch (Exception e) {
                    str = str + " ";
                }
            } else {
                str = str + " ";
            }
            LatLng latLng = this.x;
            if (latLng != null) {
                if (b(latLng, this.n) >= 0.05d) {
                    this.clShadowSetting.setVisibility(0);
                    this.ivMapSearch.setImageDrawable(this.k.getDrawable(R.drawable.icon_bg_map_find_people));
                } else if (this.z == 1) {
                    this.clShadowSetting.setVisibility(8);
                    this.ivMapSearch.setImageDrawable(this.k.getDrawable(R.drawable.icon_bg_map_find_people_long));
                }
            }
            if (this.r < 0.05d) {
                this.clMapSearch.setVisibility(8);
                this.tvTryMoveMap.setVisibility(0);
                this.clShadowSetting.setVisibility(8);
                this.ivReturnMyPosition.setVisibility(8);
            } else {
                this.tvTryMoveMap.setVisibility(8);
                this.clMapSearch.setVisibility(0);
                this.clShadowSetting.setVisibility(0);
                this.ivMapSearch.setImageDrawable(this.k.getDrawable(R.drawable.icon_bg_map_find_people));
                this.ivReturnMyPosition.setVisibility(0);
                LatLng latLng2 = this.x;
                if (latLng2 != null && b(latLng2, this.n) < 0.05d && this.z == 1) {
                    this.clShadowSetting.setVisibility(8);
                    this.ivMapSearch.setImageDrawable(this.k.getDrawable(R.drawable.icon_bg_map_find_people_long));
                }
            }
            if (this.z == 1) {
                this.tvShadowContent.setText(a(R.string.move_shadow_here));
            } else {
                this.tvShadowContent.setText(a(R.string.set_up_shadow));
            }
            String str2 = AppUtils.a((int) R.string.distance_to_me) + " " + decimalFormat.format(this.r) + " km";
            String str3 = str + str2;
            this.tvCurrentLocation.setText(str2 + " " + str);
            if (StringUtils.d(str3)) {
                this.tvCurrentLocation.setVisibility(8);
            } else {
                this.tvCurrentLocation.setVisibility(0);
            }
            this.tvCurrentLocation.requestLayout();
            Point screenLocation = this.g.getProjection().toScreenLocation(this.G);
            int abs = Math.abs(screenLocation.x);
            int abs2 = Math.abs(screenLocation.y);
            if ((abs > AppInfo.l / 6 || abs2 > AppInfo.m / 6) && z) {
                N();
                Log.e("lyl", "移动地图刷新数据");
            }
            Log.e("lyl", "mapLeftTopPoint: " + screenLocation);
            Log.e("lyl", "pointX: " + abs);
            Log.e("lyl", "pointY: " + abs2);
            this.G = e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z) {
        if (this.D.is_age_stealth == 1 || this.D.is_role_stealth == 1 || this.D.is_stealth_distance == 1) {
            this.D.is_invisible_half = 1;
        }
        if (this.D.is_invisible_all != 1 && this.D.is_invisible_half != 1 && this.D.is_hide_distance != 1) {
            c(z);
        } else if (this.D.is_invisible_all == 1) {
            CommonAlertDialog.a(this.k, a(R.string.invisible_to_vip), a(R.string.close_the_invisible), a(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (FindSearchMapFragment.this.D.is_hide_distance == 1) {
                        CommonAlertDialog.a(FindSearchMapFragment.this.k, FindSearchMapFragment.this.a(R.string.hide_distance_is_open), FindSearchMapFragment.this.a(R.string.close_the_hide_distance), FindSearchMapFragment.this.a(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.12.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i2) {
                                Tracker.onClick(dialogInterface2, i2);
                                FindSearchMapFragment.this.c(z);
                                FindSearchMapFragment.this.D.is_invisible_all = 0;
                                FindSearchMapFragment.this.D.is_hide_distance = 0;
                            }
                        }, FindSearchMapFragment.this.a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                    FindSearchMapFragment.this.D.is_invisible_all = 0;
                    FindSearchMapFragment.this.c(z);
                }
            }, a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (this.D.is_hide_distance == 1) {
            CommonAlertDialog.a(this.k, a(R.string.hide_distance_is_open), a(R.string.close_the_hide_distance), a(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.13
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (FindSearchMapFragment.this.D.is_invisible_half == 1 && FindSearchMapFragment.this.C) {
                        CommonAlertDialog.a(FindSearchMapFragment.this.k, FindSearchMapFragment.this.a(R.string.invisible_to_vip), FindSearchMapFragment.this.a(R.string.some_users_can_not_see_you), FindSearchMapFragment.this.a(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.13.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i2) {
                                Tracker.onClick(dialogInterface2, i2);
                                FindSearchMapFragment.this.c(z);
                                FindSearchMapFragment.this.C = false;
                            }
                        }, FindSearchMapFragment.this.a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                    FindSearchMapFragment.this.c(z);
                    FindSearchMapFragment.this.D.is_hide_distance = 0;
                }
            }, a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (this.D.is_invisible_half == 1 && this.C) {
            CommonAlertDialog.a(this.k, a(R.string.invisible_to_vip), a(R.string.some_users_can_not_see_you), a(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    FindSearchMapFragment.this.c(z);
                    FindSearchMapFragment.this.C = false;
                }
            }, a(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final MapAvatarUserModel mapAvatarUserModel) {
        StringBuilder sb;
        VipProtos.Event event = VipProtos.Event.MAP_FIND_USER_SHOW;
        if (mapAvatarUserModel.chat_room_id > 0) {
            sb = new StringBuilder();
            sb.append(mapAvatarUserModel.chat_room_id);
        } else {
            sb = new StringBuilder();
            sb.append(mapAvatarUserModel.uid);
        }
        sb.append("");
        EventTrackVIP.a(event, sb.toString(), mapAvatarUserModel.chat_room_id > 0 ? "yy" : "user", false);
        ImageLoader.a(getFragmentActive(), mapAvatarUserModel.avatar).b(2131237310).c().a(new CustomTarget<Drawable>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.32
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                FindSearchMapFragment.this.P.setImageDrawable(drawable);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.zIndex(-1.0f);
                markerOptions.position(new LatLng(Double.parseDouble(mapAvatarUserModel.location.latitude), Double.parseDouble(mapAvatarUserModel.location.longitude)));
                FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                Bitmap a2 = findSearchMapFragment.a(findSearchMapFragment.N);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(a2));
                Marker addMarker = FindSearchMapFragment.this.g.addMarker(markerOptions);
                addMarker.setTitle(mapAvatarUserModel.uid + "-" + mapAvatarUserModel.chat_room_id);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(mapAvatarUserModel.is_shadow);
                addMarker.setSnippet(sb2.toString());
                FindSearchMapFragment.this.a(addMarker);
                FindSearchMapFragment.this.f.add(addMarker);
                a2.recycle();
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void c(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void d(final boolean z) {
        MineHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<UserHeaderLocationModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserHeaderLocationModel> bluedEntityA) {
                UserHeaderLocationModel userHeaderLocationModel = bluedEntityA.data.get(0);
                if (userHeaderLocationModel != null) {
                    FindSearchMapFragment.this.D = userHeaderLocationModel;
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    findSearchMapFragment.A = findSearchMapFragment.D.avatar_location_status == 1;
                    FindSearchMapFragment findSearchMapFragment2 = FindSearchMapFragment.this;
                    boolean z2 = false;
                    if (findSearchMapFragment2.D.passby_status == 1) {
                        z2 = true;
                    }
                    findSearchMapFragment2.B = z2;
                } else {
                    FindSearchMapFragment.this.A = false;
                }
                if (z) {
                    FindSearchMapFragment findSearchMapFragment3 = FindSearchMapFragment.this;
                    findSearchMapFragment3.f(findSearchMapFragment3.A);
                    FindSearchMapFragment.this.F();
                }
                FindSearchMapFragment findSearchMapFragment4 = FindSearchMapFragment.this;
                findSearchMapFragment4.e(findSearchMapFragment4.A);
                FindSearchMapFragment.this.G();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        if (z) {
            Drawable drawable = this.k.getResources().getDrawable(R.drawable.icon_map_header_option);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.tvHeaderOption.setCompoundDrawables(drawable, null, null, null);
            this.tvHeaderOption.setTextColor(this.k.getResources().getColor(2131102163));
            return;
        }
        Drawable drawable2 = this.k.getResources().getDrawable(R.drawable.icon_map_header_option_closed);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.tvHeaderOption.setCompoundDrawables(drawable2, null, null, null);
        this.tvHeaderOption.setTextColor(this.k.getResources().getColor(2131101963));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z) {
        Marker marker = this.E;
        if (marker != null) {
            marker.remove();
            this.E = null;
        }
        if (this.g != null && z) {
            ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().avatar).b(2131237310).c().a(new CustomTarget<Drawable>() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.35
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    FindSearchMapFragment.this.M.setImageDrawable(drawable);
                    FindSearchMapFragment.this.L.setImageDrawable(FindSearchMapFragment.this.k.getResources().getDrawable(R.drawable.icon_avatar_user));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(FindSearchMapFragment.this.f30189c);
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    Bitmap a2 = findSearchMapFragment.a(findSearchMapFragment.K);
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(a2));
                    FindSearchMapFragment findSearchMapFragment2 = FindSearchMapFragment.this;
                    findSearchMapFragment2.E = findSearchMapFragment2.g.addMarker(markerOptions);
                    FindSearchMapFragment.this.E.setTitle(UserInfo.getInstance().getLoginUserInfo().uid);
                    FindSearchMapFragment.this.E.setSnippet("0");
                    FindSearchMapFragment findSearchMapFragment3 = FindSearchMapFragment.this;
                    findSearchMapFragment3.a(findSearchMapFragment3.E);
                    a2.recycle();
                    Log.e("lyl", "onResourceReady: selfAvatar" + z);
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable) {
                }
            });
        }
    }

    private void w() {
        try {
            this.u = new GeocodeSearch(this.k);
        } catch (AMapException e) {
            e.printStackTrace();
        }
        this.u.setOnGeocodeSearchListener(this);
    }

    private void x() {
        if (BluedPreferences.en()) {
            BluedPreferences.eo();
        }
        View inflate = getLayoutInflater().inflate(R.layout.map_avatar_self, (ViewGroup) null, false);
        this.K = inflate;
        this.L = (ImageView) inflate.findViewById(R.id.iv_avatar_bg);
        this.M = (ImageView) this.K.findViewById(R.id.iv_avatar_map);
        this.N = getLayoutInflater().inflate(R.layout.map_avatar_user, (ViewGroup) null, false);
        this.O = getLayoutInflater().inflate(R.layout.map_avatar_chatting_user, (ViewGroup) null, false);
        this.P = (ImageView) this.N.findViewById(R.id.iv_avatar_map);
        this.Q = (ImageView) this.O.findViewById(R.id.iv_avatar_map);
        this.ivReturnMyPosition.setOnClickListener(this);
        this.ivLeftClose.setOnClickListener(this);
        this.clMapSearch.setOnClickListener(this);
        this.clShadowSetting.setOnClickListener(this);
        this.ivRefreshPosition.setOnClickListener(this);
        this.ivShadowPosition.setOnClickListener(this);
        this.tvHeaderOption.setOnClickListener(this);
        this.btnChanceEncounter.setOnClickListener(this);
        this.flChanceEncounterBg.setOnClickListener(this);
        this.ivChanceEncounterViewClose.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                findSearchMapFragment.B = findSearchMapFragment.toggleButtonChanceEncounter.isChecked();
                FindSearchMapFragment.this.K();
                FindSearchMapFragment.this.chanceEncounterView.setVisibility(8);
                FindSearchMapFragment.this.flChanceEncounterBg.setVisibility(8);
                FindSearchMapFragment.this.R = false;
            }
        });
        this.chanceEncounterRecyclerView.setLayoutManager(new LinearLayoutManager(this.k));
        MapChanceEncounterAdapter mapChanceEncounterAdapter = new MapChanceEncounterAdapter(this.k, getFragmentActive(), this.I);
        this.S = mapChanceEncounterAdapter;
        this.chanceEncounterRecyclerView.setAdapter(mapChanceEncounterAdapter);
        this.searchView.setOnClickListener(this);
        MapSearchPositionFragment mapSearchPositionFragment = new MapSearchPositionFragment();
        this.t = mapSearchPositionFragment;
        mapSearchPositionFragment.a(new MapSearchPositionFragment.OnBackListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.6
            @Override // com.soft.blued.ui.find.fragment.MapSearchPositionFragment.OnBackListener
            public void a() {
                FindSearchMapFragment.this.P();
            }
        });
        this.t.f30347c = this;
        getChildFragmentManager().beginTransaction().replace(R.id.search_content, this.t).commitAllowingStateLoss();
    }

    private void y() {
        this.searchView.setElevation(10.0f);
        this.searchView.getBackground().setAlpha(240);
        if (this.g == null) {
            LatLng latLng = null;
            if (MapFindManager.a().b()) {
                latLng = new LatLng(Double.parseDouble(MapFindManager.a().c().b), Double.parseDouble(MapFindManager.a().c().f30599a));
            }
            TencentMap map = this.mapView.getMap();
            this.g = map;
            map.moveCamera(CameraUpdateFactory.zoomTo(16.0f));
            if (latLng != null) {
                this.searchView.setText(MapFindManager.a().c().e);
                final LatLng latLng2 = latLng;
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FindSearchMapFragment.this.H != 1) {
                            FindSearchMapFragment.this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 16.0f));
                        }
                    }
                }, 1000L);
            }
        }
        this.g.setLocationSource(this);
        this.g.setMyLocationEnabled(true);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_position));
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.strokeWidth(0);
        this.g.setMyLocationStyle(myLocationStyle);
        this.g.setMyLocationEnabled(true);
        this.g.getUiSettings().setZoomControlsEnabled(false);
        this.g.setOnCameraChangeListener(this);
        this.g.setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.8
            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                float f;
                String str;
                String str2;
                String[] split = marker.getTitle().split("-");
                int i = 0;
                String str3 = split[0];
                LatLng position = marker.getPosition();
                if (position == null || FindSearchMapFragment.this.f30189c == null) {
                    f = 0.0f;
                } else {
                    FindSearchMapFragment findSearchMapFragment = FindSearchMapFragment.this;
                    f = findSearchMapFragment.a(position, findSearchMapFragment.f30189c);
                }
                long parseInt = split.length > 1 ? Integer.parseInt(split[1]) : 0L;
                int i2 = (parseInt > 0L ? 1 : (parseInt == 0L ? 0 : -1));
                if (i2 > 0) {
                    str2 = parseInt + "";
                    str = "yy";
                } else {
                    str = "user";
                    str2 = str3;
                }
                EventTrackVIP.a(VipProtos.Event.MAP_FIND_USER_CLICK, str2, str, i2 == 0 && f > 1000.0f && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && !FindSearchMapFragment.this.y);
                if (i2 > 0) {
                    YYRoomInfoManager.e().a((BaseFragmentActivity) FindSearchMapFragment.this.k, parseInt + "", "map_find_yy");
                    return true;
                }
                try {
                    i = Integer.valueOf(marker.getSnippet()).intValue();
                } catch (Exception e) {
                }
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || FindSearchMapFragment.this.y) {
                    if (TextUtils.isEmpty(str3)) {
                        return true;
                    }
                    FindSearchMapFragment.this.a(str3, i);
                    return true;
                } else if (f > 1000.0f) {
                    FindSearchMapFragment.this.z();
                    return true;
                } else if (FindSearchMapFragment.this.A) {
                    FindSearchMapFragment.this.a(str3, i);
                    return true;
                } else {
                    FindSearchMapFragment.this.A();
                    return true;
                }
            }
        });
        this.G = e();
        d(true);
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        new FindSearchMapBottomDialog.Builder(this.k).a(3).a(this.k.getResources().getDrawable(R.drawable.icon_vip_bottom_dialog)).a(a(R.string.pay_vip_for_location)).b(a(R.string.unlimited_use)).a(a(R.string.map_buy_now), new FindSearchMapBottomDialog.ConfirmBtnListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.9
            @Override // com.soft.blued.ui.find.view.FindSearchMapBottomDialog.ConfirmBtnListener
            public void a(Dialog dialog, boolean z) {
                InstantLog.a("map_vip_dialog_buy_click");
                PayUtils.a(FindSearchMapFragment.this.k, 21, "nearby_friend_avatar_loc", VipProtos.FromType.NEARBY_FRIEND_AVATAR_LOC);
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_CLICK);
            }
        }).a().show();
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_TO_BUY_VIP_SHOW);
    }

    public String a(int i) {
        return this.k.getString(i);
    }

    @Override // com.soft.blued.ui.find.fragment.BaseSearchMapFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (getActivity() != null) {
            this.k = getActivity();
            Bundle arguments = getArguments();
            this.H = arguments.getInt("from_page");
            this.I = arguments.getBoolean("is_open_map_chance_encounter_dialog", false);
            this.J = arguments.getBoolean("is_map_find", false);
        }
        y();
        if (BluedPreferences.ah(UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.tvCurrentLocation.setVisibility(8);
            this.btnChanceEncounter.setVisibility(8);
            this.tvHeaderOption.setVisibility(8);
            this.llSearchShadow.setVisibility(8);
            this.llRefreshReturn.setVisibility(8);
            this.ivLocation.setVisibility(8);
            this.tvCancel.setVisibility(8);
            this.tvTryMoveMap.setVisibility(8);
            this.searchView.setElevation(0.0f);
            this.circleGuideView.setVisibility(0);
            this.clGuide1.setVisibility(0);
            this.ivStartHeaderLocation.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FindSearchMapFragment.this.clGuide1.setVisibility(8);
                    FindSearchMapFragment.this.clGuide2.setVisibility(0);
                }
            });
            this.ivSearchShadowGuide.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FindSearchMapFragment.this.clGuide2.setVisibility(8);
                    FindSearchMapFragment.this.clGuide3.setVisibility(0);
                }
            });
            this.ivSetShadowGuide.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FindSearchMapFragment.this.circleGuideView.setVisibility(8);
                    FindSearchMapFragment.this.clGuide3.setVisibility(8);
                    FindSearchMapFragment.this.chanceEncounterGuide.setVisibility(0);
                    FindSearchMapFragment.this.llGuide4.setVisibility(0);
                    FindSearchMapFragment.this.btnChanceEncounter.setVisibility(0);
                    FindSearchMapFragment.this.tvHeaderOption.setVisibility(0);
                    FindSearchMapFragment.this.tvHeaderOption.setElevation(0.0f);
                    FindSearchMapFragment.this.ivReturnMyPosition.setVisibility(8);
                    FindSearchMapFragment.this.ivShadowPosition.setVisibility(8);
                    FindSearchMapFragment.this.ivRefreshPosition.setVisibility(0);
                }
            });
            this.llGuide4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FindSearchMapFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FindSearchMapFragment.this.chanceEncounterGuide.setVisibility(8);
                    FindSearchMapFragment.this.llGuide4.setVisibility(8);
                    FindSearchMapFragment.this.tvHeaderOption.setElevation(10.0f);
                    BluedPreferences.ai(UserInfo.getInstance().getLoginUserInfo().uid);
                    FindSearchMapFragment.this.tvCurrentLocation.setVisibility(0);
                    FindSearchMapFragment.this.llSearchShadow.setVisibility(0);
                    FindSearchMapFragment.this.ivLocation.setVisibility(0);
                    FindSearchMapFragment.this.tvCancel.setVisibility(0);
                    FindSearchMapFragment.this.tvTryMoveMap.setVisibility(0);
                    FindSearchMapFragment.this.llRefreshReturn.setVisibility(0);
                    FindSearchMapFragment.this.G();
                    if (FindSearchMapFragment.this.I) {
                        FindSearchMapFragment.this.I();
                        FindSearchMapFragment.this.J();
                    }
                    FindSearchMapFragment.this.F();
                }
            });
        } else if (this.I) {
            I();
            J();
        }
        x();
        w();
    }

    public void a(LatLonPoint latLonPoint) {
        this.u.getFromLocationAsyn(new RegeocodeQuery(latLonPoint, 200.0f, GeocodeSearch.AMAP));
    }

    public void a(PoiItem poiItem, String str) {
        this.l = poiItem;
        this.searchContent.setVisibility(8);
        this.llSearchShadow.setVisibility(0);
        this.llRefreshReturn.setVisibility(0);
        this.tvHeaderOption.setVisibility(0);
        this.btnChanceEncounter.setVisibility(0);
        this.tvCurrentLocation.setVisibility(0);
        this.searchView.setVisibility(0);
        this.ivLeftClose.setVisibility(0);
        LatLng latLng = new LatLng(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
        this.m = latLng;
        TencentMap tencentMap = this.g;
        if (tencentMap != null) {
            tencentMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
        }
        if (StringUtils.d(str)) {
            return;
        }
        this.searchView.setText(str);
    }

    public void a(SearchPositionModel searchPositionModel) {
        PoiItem poiItem = new PoiItem("", new LatLonPoint(searchPositionModel.lat, searchPositionModel.lon), "", "");
        this.l = poiItem;
        this.searchContent.setVisibility(8);
        this.llSearchShadow.setVisibility(0);
        this.llRefreshReturn.setVisibility(0);
        this.tvCurrentLocation.setVisibility(0);
        this.searchView.setVisibility(0);
        this.tvHeaderOption.setVisibility(0);
        this.btnChanceEncounter.setVisibility(0);
        this.ivLeftClose.setVisibility(0);
        LatLng latLng = new LatLng(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
        this.m = latLng;
        TencentMap tencentMap = this.g;
        if (tencentMap != null) {
            tencentMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
        }
        if (StringUtils.d(searchPositionModel.name)) {
            return;
        }
        this.searchView.setText(searchPositionModel.name);
    }

    public void a(Marker marker) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(500L);
        marker.setAnimation(scaleAnimation);
        marker.startAnimation();
    }

    @Override // com.soft.blued.ui.find.fragment.BaseSearchMapFragment
    public int b() {
        return R.layout.fragment_find_search_map;
    }

    @Override // com.soft.blued.ui.find.fragment.BaseSearchMapFragment
    public void b(Bundle bundle) {
        super.b(bundle);
    }

    @Override // com.soft.blued.ui.find.fragment.BaseSearchMapFragment
    public TextureMapView c() {
        return this.mapView;
    }

    public void d() {
        this.searchContent.setVisibility(8);
        this.llSearchShadow.setVisibility(0);
        this.llRefreshReturn.setVisibility(0);
        this.tvCurrentLocation.setVisibility(0);
        this.searchView.setVisibility(0);
        this.tvHeaderOption.setVisibility(0);
        this.btnChanceEncounter.setVisibility(0);
        this.ivLeftClose.setVisibility(0);
    }

    public LatLng e() {
        return this.g.getProjection().fromScreenLocation(new Point(this.mapView.getLeft(), this.mapView.getTop()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            this.s = intent.getStringExtra("search_position");
            PoiItem poiItem = (PoiItem) intent.getParcelableExtra("lat_lon_point");
            this.l = poiItem;
            LatLng latLng = new LatLng(poiItem.getLatLonPoint().getLatitude(), this.l.getLatLonPoint().getLongitude());
            this.m = latLng;
            this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
            if (StringUtils.d(this.s)) {
                return;
            }
            this.searchView.setText(this.s);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        P();
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            LatLng latLng = cameraPosition.target;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            this.l = null;
            LatLng latLng = new LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude);
            this.n = latLng;
            if (this.f30189c == null) {
                this.f30189c = new LatLng(0.0d, 0.0d);
            }
            this.r = a(this.f30189c, latLng) / 1000.0d;
            a(new LatLonPoint(cameraPosition.target.latitude, cameraPosition.target.longitude));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.btn_chance_encounter /* 2131362550 */:
                EventTrackVIP.b(VipProtos.Event.MAP_FIND_PASSBY_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade);
                if (!BluedPreferences.ah(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    I();
                    J();
                }
                this.tvChanceEncounterRemind.setVisibility(8);
                return;
            case R.id.cl_map_search /* 2131362917 */:
                D();
                return;
            case R.id.cl_shadow_setting /* 2131362940 */:
                O();
                return;
            case R.id.iv_left_close /* 2131365546 */:
                P();
                return;
            case R.id.iv_refresh_position /* 2131365801 */:
                N();
                return;
            case R.id.iv_return_my_position /* 2131365817 */:
                if (this.f30189c != null) {
                    this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(this.f30189c, 16.0f));
                    return;
                }
                return;
            case R.id.iv_shadow_position /* 2131365871 */:
                LatLng latLng = this.x;
                if (latLng != null) {
                    this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
                    C();
                    EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_SHADOW_MANAGEMENT_CLICK);
                    return;
                }
                return;
            case R.id.tv_header_option /* 2131371655 */:
                B();
                EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_AVATAR_LOC_SET_CLICK);
                return;
            case R.id.tv_search_view /* 2131372521 */:
                EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_BAR_CLICK);
                this.t.a(this.s, this.o);
                this.searchContent.setVisibility(0);
                this.llSearchShadow.setVisibility(8);
                this.llRefreshReturn.setVisibility(8);
                this.tvCurrentLocation.setVisibility(8);
                this.btnChanceEncounter.setVisibility(8);
                this.searchView.setVisibility(8);
                this.tvHeaderOption.setVisibility(8);
                this.ivLeftClose.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        if (i != 1000 || geocodeResult == null || geocodeResult.getGeocodeAddressList() == null || geocodeResult.getGeocodeAddressList().size() <= 0) {
            return;
        }
        GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
        this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(geocodeAddress.getLatLonPoint().getLatitude(), geocodeAddress.getLatLonPoint().getLongitude()), 16.0f));
    }

    @Override // com.soft.blued.ui.find.fragment.BaseSearchMapFragment, com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        if (tencentLocation == null) {
            return;
        }
        if (i == 0) {
            this.f30189c = new LatLng(tencentLocation.getLatitude(), tencentLocation.getLongitude());
            CommonPreferences.a(tencentLocation.getLongitude(), tencentLocation.getLatitude());
            Event c2 = BluedStatistics.c();
            c2.a("LOCATION_POSITION", 0L, 0, "find map search longitude:" + tencentLocation.getLongitude() + " -- latitude:" + tencentLocation.getLatitude());
            this.n = this.f30189c;
            this.o = tencentLocation.getCity();
            Location location = new Location(tencentLocation.getProvider());
            location.setLatitude(tencentLocation.getLatitude());
            location.setLongitude(tencentLocation.getLongitude());
            location.setAccuracy(tencentLocation.getAccuracy());
            if (this.e != null) {
                this.e.onLocationChanged(location);
            }
            if (!this.J) {
                this.g.moveCamera(CameraUpdateFactory.newLatLngZoom(this.n, 16.0f));
            }
            this.p = tencentLocation.getProvince() + tencentLocation.getCity() + tencentLocation.getDistrict();
            this.q = tencentLocation.getAddress();
        } else {
            this.p = "";
            this.q = "";
            if (PermissionUtils.a()) {
                AppMethods.d((int) R.string.operate_fail);
            }
        }
        b(this.q, false);
        d(true);
        H();
        Log.e("lyl", "onLocationChanged: errorCode = " + i + ", errorInfo = " + str);
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i != 1000) {
            this.p = "";
        } else if (regeocodeResult == null || regeocodeResult.getRegeocodeAddress() == null || regeocodeResult.getRegeocodeAddress().getFormatAddress() == null) {
            this.p = "";
        } else {
            RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
            this.p = regeocodeAddress.getProvince() + regeocodeAddress.getCity() + regeocodeAddress.getDistrict();
            this.q = regeocodeAddress.getFormatAddress();
            Log.e("lyl", "街道:" + regeocodeAddress.getCrossroads() + " -- " + regeocodeAddress.getFormatAddress() + " -- " + regeocodeAddress.getStreetNumber() + " -- " + regeocodeAddress.getNeighborhood() + " -- " + regeocodeAddress.getBuilding());
        }
        b(this.q, true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_MAP_STATE).post(Boolean.valueOf(this.A));
    }

    public LatLng v() {
        return this.g.getProjection().fromScreenLocation(new Point(this.mapView.getRight(), this.mapView.getBottom()));
    }
}
