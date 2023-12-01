package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.core.LatLonPoint;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.gaode.GaoDeUtils;
import com.blued.android.module.common.utils.gaode.OnPOIListener;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.statistics.BluedStatistics;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.SendPositionActivity;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionActivity.class */
public class SendPositionActivity extends BaseFragmentActivity implements View.OnClickListener, TencentLocationListener, LocationSource {

    /* renamed from: c  reason: collision with root package name */
    List<PositionPOIModel> f31893c;
    private RenrenPullToRefreshListView d;
    private ListView e;
    private SendPositionPOIAdapter f;
    private Context g;
    private View h;
    private TencentLocationManager i;
    private LocationSource.OnLocationChangedListener j;
    private TencentLocationRequest k;
    private TextureMapView l;
    private TencentMap m;
    private double n;
    private double o;
    private String p;
    private CommonTopTitleNoTrans q;
    private int r;
    private boolean s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.SendPositionActivity$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionActivity$4.class */
    public class AnonymousClass4 implements TencentMap.OnCameraChangeListener {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            SendPositionActivity sendPositionActivity = SendPositionActivity.this;
            sendPositionActivity.a(sendPositionActivity.n, SendPositionActivity.this.o);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            SendPositionActivity.this.n = cameraPosition.target.latitude;
            SendPositionActivity.this.o = cameraPosition.target.longitude;
            DelayRepeatTaskUtils.a("msg_send_postion_get_poi", new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionActivity$4$LuzaLNxKeGmEF9S5R_VM5d6R5XM
                @Override // java.lang.Runnable
                public final void run() {
                    SendPositionActivity.AnonymousClass4.this.a();
                }
            });
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionActivity$SendPositionPOIAdapter.class */
    public class SendPositionPOIAdapter extends BaseAdapter {
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f31899c;
        private List<PositionPOIModel> d = new ArrayList();
        private int e;

        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SendPositionActivity$SendPositionPOIAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f31900a;
            public TextView b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f31901c;
            public ImageView d;

            private ViewHolder() {
            }
        }

        public SendPositionPOIAdapter(Context context) {
            this.b = context;
            this.f31899c = LayoutInflater.from(context);
            this.e = context.getResources().getDisplayMetrics().widthPixels;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(PositionPOIModel positionPOIModel, int i, View view) {
            Tracker.onClick(view);
            positionPOIModel.mark_visible = true;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.d.size()) {
                    break;
                }
                if (i3 != i) {
                    this.d.get(i3).mark_visible = false;
                }
                i2 = i3 + 1;
            }
            SendPositionActivity.this.o = positionPOIModel.getLongitude();
            SendPositionActivity.this.n = positionPOIModel.getLatitude();
            if (StringUtils.d(positionPOIModel.address)) {
                SendPositionActivity.this.p = positionPOIModel.name;
            } else {
                SendPositionActivity.this.p = positionPOIModel.address;
            }
            SendPositionActivity.this.m.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(SendPositionActivity.this.n, SendPositionActivity.this.o), 15.0f));
            notifyDataSetChanged();
        }

        public void a(List<PositionPOIModel> list) {
            this.d.clear();
            if (list != null && list.size() > 0) {
                this.d.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.f31899c.inflate(R.layout.item_send_postion_poi, viewGroup, false);
                viewHolder.f31900a = (LinearLayout) view2.findViewById(R.id.ll_item);
                viewHolder.b = (TextView) view2.findViewById(R.id.tv_poi_shortname);
                viewHolder.f31901c = (TextView) view2.findViewById(R.id.tv_poi_address);
                viewHolder.d = (ImageView) view2.findViewById(R.id.img_choosen_mark);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            final PositionPOIModel positionPOIModel = this.d.get(i);
            viewHolder.b.setText(positionPOIModel.name);
            viewHolder.f31901c.setText(positionPOIModel.address);
            if (positionPOIModel.mark_visible) {
                viewHolder.d.setVisibility(0);
            } else {
                viewHolder.d.setVisibility(4);
            }
            viewHolder.f31900a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$SendPositionActivity$SendPositionPOIAdapter$1fYdJgp1CEEzCd0VdawXOfeKNx8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SendPositionActivity.SendPositionPOIAdapter.this.a(positionPOIModel, i, view3);
                }
            });
            return view2;
        }
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        this.f31893c = arrayList;
        arrayList.clear();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) findViewById(2131370749);
        this.q = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(this);
        this.q.setCenterText(this.g.getResources().getString(R.string.position));
        this.q.setRightText(this.g.getResources().getString(R.string.send));
        this.q.setRightTextColor(2131102254);
        this.q.setRightClickListener(this);
        View findViewById = findViewById(R.id.tv_search);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) findViewById(2131366898);
        this.d = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        this.d.p();
        ListView listView = (ListView) this.d.getRefreshableView();
        this.e = listView;
        listView.setClipToPadding(false);
        this.e.setScrollBarStyle(33554432);
        this.e.setHeaderDividersEnabled(false);
        this.e.setDividerHeight(1);
        this.e.setDivider(getResources().getDrawable(2131234662));
        SendPositionPOIAdapter sendPositionPOIAdapter = new SendPositionPOIAdapter(this);
        this.f = sendPositionPOIAdapter;
        this.e.setAdapter((ListAdapter) sendPositionPOIAdapter);
    }

    public void a(double d, double d2) {
        GaoDeUtils.a(this, 0, new LatLonPoint(d, d2), new OnPOIListener() { // from class: com.soft.blued.ui.msg.SendPositionActivity.2
            @Override // com.blued.android.module.common.utils.gaode.OnPOIListener
            public void onComplete(int i, List<? extends PositionPOIModel> list, boolean z) {
                if (i == 0) {
                    SendPositionActivity.this.a((List<PositionPOIModel>) list);
                    return;
                }
                SendPositionActivity.this.r = i;
                AppMethods.a((CharSequence) (SendPositionActivity.this.g.getResources().getString(R.string.location_fail_try_again) + "(" + i + ")"));
                BluedStatistics.c().a("MSG_POI", 0L, i, null);
            }
        });
    }

    public void a(List<PositionPOIModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                PositionPOIModel positionPOIModel = list.get(i2);
                if (i2 == 0) {
                    positionPOIModel.mark_visible = true;
                    if (StringUtils.d(positionPOIModel.address)) {
                        positionPOIModel.address = positionPOIModel.name;
                    }
                    positionPOIModel.name = getResources().getString(R.string.position_now);
                    this.p = positionPOIModel.address;
                }
                arrayList.add(positionPOIModel);
                i = i2 + 1;
            }
        }
        this.f.a(arrayList);
        this.e.setSelection(0);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        Logger.a(BrowserContract.Bookmarks.POSITION, "地图activate");
        this.j = onLocationChangedListener;
        int requestLocationUpdates = this.i.requestLocationUpdates(this.k, this, Looper.getMainLooper());
        if (requestLocationUpdates < 1 || requestLocationUpdates > 3) {
            return;
        }
        AppMethods.a((CharSequence) (this.g.getResources().getString(R.string.location_fail_try_again) + "(" + requestLocationUpdates + ")"));
    }

    public void b(double d, double d2) {
        if (this.m != null) {
            try {
                this.m.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), 15.0f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
    public void deactivate() {
        Logger.a(BrowserContract.Bookmarks.POSITION, "地图deactivate");
        this.i.removeUpdates(this);
        this.i = null;
        this.k = null;
        this.j = null;
        this.m = null;
    }

    public void f() {
        TextureMapView textureMapView = (TextureMapView) findViewById(R.id.map);
        this.l = textureMapView;
        this.m = textureMapView.getMap();
        this.i = TencentLocationManager.getInstance(this);
        TencentLocationRequest create = TencentLocationRequest.create();
        this.k = create;
        create.setInterval(m.ag);
        this.k.setIndoorLocationMode(true);
        this.m.setLocationSource(this);
        this.m.setMyLocationEnabled(true);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_position));
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.fillColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.strokeWidth(0);
        this.m.setMyLocationStyle(myLocationStyle.myLocationType(2));
        this.m.getUiSettings().setMyLocationButtonEnabled(false);
        this.m.getUiSettings().setZoomControlsEnabled(false);
        this.m.setOnCameraChangeListener(new AnonymousClass4());
        this.m.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
        if (BlueAppLocal.d()) {
            this.m.setForeignLanguage(Language.zh);
        } else {
            this.m.setForeignLanguage(Language.en);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i2 == -1) {
            Double valueOf = Double.valueOf(intent.getDoubleExtra("lot", this.o));
            Double valueOf2 = Double.valueOf(intent.getDoubleExtra("lat", this.n));
            b(valueOf2.doubleValue(), valueOf.doubleValue());
            this.m.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(valueOf2.doubleValue(), valueOf.doubleValue()), 15.0f));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            finish();
        } else if (id != 2131363126) {
            if (id != 2131372511) {
                return;
            }
            PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.SendPositionActivity.3
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    TerminalActivity.a(SendPositionActivity.this, SendPositionSearchFragment.class, (Bundle) null, 0);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        } else {
            Intent intent = new Intent();
            double d = this.o;
            if (d == Double.MIN_VALUE || this.n == Double.MIN_VALUE || d == 0.0d) {
                intent.putExtra("lot", "");
                intent.putExtra("lat", "");
            } else {
                intent.putExtra("lot", this.o + "");
                intent.putExtra("lat", this.n + "");
            }
            if (TextUtils.isEmpty(this.p)) {
                intent.putExtra("address", this.g.getResources().getString(R.string.biao_v4_msg_location));
            } else {
                intent.putExtra("address", this.p.replace(",", "."));
            }
            if (CommonTools.a((Activity) this)) {
                setResult(-1, intent);
                finish();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TencentMapInitializer.setAgreePrivacy(true);
        TencentLocationManager.setUserAgreePrivacy(true);
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.SendPositionActivity.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
        setContentView(R.layout.activity_send_position);
        this.g = this;
        g();
        f();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TextureMapView textureMapView = this.l;
        if (textureMapView != null) {
            textureMapView.onDestroy();
        }
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        Logger.a(BrowserContract.Bookmarks.POSITION, "定位完成：" + i + "," + str);
        if (i != 0 || this.j == null) {
            return;
        }
        Location location = new Location(tencentLocation.getProvider());
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        this.j.onLocationChanged(location);
        CommonPreferences.a(tencentLocation.getLongitude(), tencentLocation.getLatitude());
        if (this.s) {
            return;
        }
        this.s = true;
        b(location.getLatitude(), location.getLongitude());
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(SendPositionActivity.class.getSimpleName());
        MobclickAgent.onPause(this);
        TextureMapView textureMapView = this.l;
        if (textureMapView != null) {
            textureMapView.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.l.onRestart();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(SendPositionActivity.class.getSimpleName());
        MobclickAgent.onResume(this);
        TextureMapView textureMapView = this.l;
        if (textureMapView != null) {
            textureMapView.onResume();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.l.onStart();
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onStatusUpdate(String str, int i, String str2) {
        Logger.c("ljx", "腾讯地图状态改变日志：" + str + "===" + str2);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.l.onStop();
    }
}
