package com.soft.blued.ui.msg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.share.Util;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.core.b;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.umeng.analytics.MobclickAgent;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShowPositionActivity.class */
public class ShowPositionActivity extends BaseFragmentActivity implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public int f31938c;
    PopActionSheet d;
    private String e;
    private String f;
    private String g;
    private TextureMapView h;
    private TencentMap i;
    private LatLng j;
    private SparseArray k = new SparseArray();
    private SparseArray l = new SparseArray();
    private CustomDialog m;
    private String n;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 1) {
            try {
                startActivity(Intent.getIntent("intent://map/direction?destination=latlng:" + this.f + "," + this.e + "|name:" + this.g + "&mode=driving&&coord_type=gcj02&&src=Blued#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"));
            } catch (Exception e) {
                Logger.e("xpf", e.getMessage());
            }
        } else if (i == 2) {
            WebViewShowInfoFragment.show(this, "http://apis.map.qq.com/uri/v1/routeplan?type=drive&fromcoord=" + CommonPreferences.v() + "," + CommonPreferences.u() + "&to=" + this.g + "&tocoord=" + this.f + "," + this.e + "&policy=1&referer=Blued", 9);
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + this.f + "," + this.e));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            } catch (Exception e2) {
                Logger.e("xpf", e2.getMessage());
            }
        } else {
            try {
                startActivity(Intent.getIntent("androidamap://navi?sourceApplication=Blued&poiname=" + this.g + "&lat=" + this.f + "&lon=" + this.e + "&dev=0"));
                LiveFloatManager.a().l();
            } catch (Exception e3) {
                Logger.e("xpf", e3.getMessage());
            }
        }
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final int i) {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ShowPositionActivity.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Intent intent = new Intent(Context.this, ShowPositionActivity.class);
                intent.putExtra("lot", str);
                intent.putExtra("lat", str2);
                intent.putExtra("address", str3);
                intent.putExtra("from", i);
                Context.this.startActivity(intent);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final int i, final String str4) {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ShowPositionActivity.2
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Intent intent = new Intent(Context.this, ShowPositionActivity.class);
                intent.putExtra("lot", str);
                intent.putExtra("lat", str2);
                intent.putExtra("address", str3);
                intent.putExtra("uid", str4);
                intent.putExtra("from", i);
                Context.this.startActivity(intent);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    private void g() {
        ((ImageView) findViewById(2131363120)).setOnClickListener(this);
        ((TextView) findViewById(2131363108)).setText(R.string.position);
        TextView textView = (TextView) findViewById(2131363126);
        textView.setOnClickListener(this);
        Intent intent = getIntent();
        this.e = intent.getStringExtra("lot");
        this.f = intent.getStringExtra("lat");
        this.g = intent.getStringExtra("address");
        this.f31938c = intent.getIntExtra("from", 0);
        this.n = intent.getStringExtra("uid");
        if (!StringUtils.d(this.e) && !StringUtils.d(this.f)) {
            try {
                this.j = new LatLng(Double.valueOf(this.f).doubleValue(), Double.valueOf(this.e).doubleValue());
            } catch (Exception e) {
            }
        }
        if (this.f31938c == 1) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
        }
    }

    private void h() {
        PopActionSheet.MyPopupWindow e;
        synchronized (this) {
            InstantLog.a("navigation_btn");
            EventTrackMessage.e(MessageProtos.Event.NAVIGATION_BTN, this.n);
            if (this.d == null || (e = this.d.e()) == null || !e.isShowing()) {
                this.k.clear();
                this.l.clear();
                int i = 1;
                if (Util.isClientAvailable(this, "com.baidu.BaiduMap")) {
                    this.k.put(0, 1);
                    this.l.put(0, getResources().getString(R.string.map_baidu));
                } else {
                    i = 0;
                }
                int i2 = i;
                if (Util.isClientAvailable(this, "com.tencent.map")) {
                    this.k.put(i, 2);
                    this.l.put(i, getResources().getString(R.string.map_tengxun));
                    i2 = i + 1;
                }
                int i3 = i2;
                if (Util.isClientAvailable(this, "com.autonavi.minimap")) {
                    this.k.put(i2, 3);
                    this.l.put(i2, getResources().getString(R.string.map_gaode));
                    i3 = i2 + 1;
                }
                if (Util.isClientAvailable(this, "com.google.android.apps.maps")) {
                    this.k.put(i3, 4);
                    this.l.put(i3, getResources().getString(R.string.map_guge));
                }
                String[] strArr = new String[this.l.size()];
                int[] iArr = new int[this.l.size()];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.l.size()) {
                        break;
                    }
                    strArr[i5] = (String) this.l.valueAt(i5);
                    iArr[i5] = 2131101285;
                    i4 = i5 + 1;
                }
                if (this.l.size() > 0) {
                    PopActionSheet popActionSheet = new PopActionSheet(this, strArr, iArr, true, new PopActionSheet.PopSheetClickListner() { // from class: com.soft.blued.ui.msg.ShowPositionActivity.3
                        @Override // com.blued.android.module.live_china.view.PopActionSheet.PopSheetClickListner
                        public void onClick(int i6, String str) {
                            ShowPositionActivity showPositionActivity = ShowPositionActivity.this;
                            showPositionActivity.a(((Integer) showPositionActivity.k.get(i6)).intValue());
                        }
                    });
                    this.d = popActionSheet;
                    popActionSheet.a(DensityUtils.a(this, 300.0f));
                    this.d.a();
                } else {
                    a(getResources().getString(R.string.map_navigation_no_data));
                }
            }
        }
    }

    public Bitmap a(View view) {
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        return view.getDrawingCache(true);
    }

    public void a(String str) {
        CustomDialog customDialog = this.m;
        if (customDialog == null || !customDialog.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(2131560351, (ViewGroup) null);
            inflate.findViewById(2131372754).setVisibility(8);
            inflate.findViewById(2131371051).setVisibility(8);
            inflate.findViewById(2131371289).setVisibility(8);
            ((TextView) inflate.findViewById(2131371259)).setText(str);
            TextView textView = (TextView) inflate.findViewById(2131372161);
            textView.setText(getString(2131890371));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ShowPositionActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ShowPositionActivity.this.m.dismiss();
                }
            });
            CustomDialog customDialog2 = new CustomDialog(this, 2131952378);
            this.m = customDialog2;
            customDialog2.a(inflate, null);
        }
    }

    public void f() {
        if (this.j != null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.item_position_overlay, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_position_desc);
            if (TextUtils.isEmpty(this.g) || this.g.equals(b.l)) {
                textView.setVisibility(4);
            } else {
                textView.setVisibility(0);
            }
            textView.setText(this.g);
            this.i.addMarker(new MarkerOptions().position(new LatLng(this.j.latitude, this.j.longitude)).icon(BitmapDescriptorFactory.fromBitmap(a(inflate))));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            finish();
        } else if (id != 2131363126) {
        } else {
            h();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TencentMapInitializer.setAgreePrivacy(true);
        TencentLocationManager.setUserAgreePrivacy(true);
        setContentView(R.layout.activity_show_msg_position);
        g();
        TextureMapView textureMapView = (TextureMapView) findViewById(R.id.map);
        this.h = textureMapView;
        TencentMap map = textureMapView.getMap();
        this.i = map;
        LatLng latLng = this.j;
        if (latLng != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
        }
        f();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.h.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(ShowPositionActivity.class.getSimpleName());
        MobclickAgent.onPause(this);
        this.h.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(ShowPositionActivity.class.getSimpleName());
        MobclickAgent.onResume(this);
        this.h.onResume();
        LiveFloatManager.a().k();
    }
}
