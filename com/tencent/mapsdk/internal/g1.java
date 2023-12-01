package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LocationCompass;
import com.tencent.tencentmap.mapsdk.maps.model.LocationNavigationGravityline;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g1.class */
public class g1 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private a0 f37453a;
    private LocationSource.OnLocationChangedListener b;

    /* renamed from: c  reason: collision with root package name */
    private LocationSource f37454c = null;
    private boolean d = false;
    private Circle e = null;
    private TencentMap.OnMyLocationChangeListener f = null;
    private MyLocationStyle g = new MyLocationStyle();
    private int h = Color.argb(102, 0, 163, 255);
    private Location i = null;
    private BitmapDescriptor j;
    private BitmapDescriptor k;
    private rc l;
    private int m;
    private TencentMap.OnMyLocationClickListener n;
    private BitmapDescriptor o;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g1$a.class */
    public class a implements LocationSource.OnLocationChangedListener {
        public a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource.OnLocationChangedListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            if (g1.this.i == null) {
                g1.this.i = new Location(location);
            } else {
                g1.this.i.setLongitude(location.getLongitude());
                g1.this.i.setLatitude(location.getLatitude());
                g1.this.i.setAccuracy(location.getAccuracy());
                g1.this.i.setProvider(location.getProvider());
                g1.this.i.setTime(location.getTime());
                g1.this.i.setSpeed(location.getSpeed());
                g1.this.i.setAltitude(location.getAltitude());
            }
            g1.this.b(location);
            if (g1.this.f != null) {
                g1.this.f.onMyLocationChange(location);
            }
        }
    }

    public g1(rc rcVar, a0 a0Var) {
        this.f37453a = null;
        this.b = null;
        this.l = rcVar;
        this.f37453a = a0Var;
        this.b = h();
    }

    private void a(Location location) {
        BitmapDescriptor compassImage;
        Bitmap bitmap;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (this.e == null) {
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.radius(location.getAccuracy()).center(latLng).fillColor(this.g.getFillColor()).strokeColor(this.g.getStrokeColor()).strokeWidth(this.g.getStrokeWidth());
            this.e = this.l.a(circleOptions);
        }
        if (this.m == 0) {
            BitmapDescriptor myLocationIcon = this.g.getMyLocationIcon();
            BitmapDescriptor bitmapDescriptor = myLocationIcon;
            if (myLocationIcon == null) {
                bitmapDescriptor = f();
            }
            Bitmap bitmap2 = bitmapDescriptor.getBitmap(this.l.getContext());
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.j = bitmapDescriptor;
                this.m = this.l.a(bitmapDescriptor.getFormater().getBitmapId(), this.g.getAnchorU(), this.g.getAnchorV());
            }
            LocationCompass locationCompass = this.g.getLocationCompass();
            if (locationCompass != null && locationCompass.getCompassImage() != null && (bitmap = (compassImage = locationCompass.getCompassImage()).getBitmap(this.l.getContext())) != null && !bitmap.isRecycled()) {
                this.k = compassImage;
                this.l.e(compassImage.getFormater().getBitmapId());
                BitmapDescriptor[] compassGroupImages = locationCompass.getCompassGroupImages();
                if (compassGroupImages != null && compassGroupImages.length == 4) {
                    String[] strArr = new String[compassGroupImages.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= compassGroupImages.length) {
                            break;
                        }
                        if (compassGroupImages[i2] != null) {
                            compassGroupImages[i2].getBitmap(this.l.getContext());
                            strArr[i2] = compassGroupImages[i2].getFormater().getBitmapId();
                        } else {
                            strArr[i2] = "";
                        }
                        i = i2 + 1;
                    }
                    this.l.a(compassImage.getFormater().getBitmapId(), strArr[0], strArr[1], strArr[2], strArr[3]);
                }
            }
            LocationNavigationGravityline locationNavigationGravityline = this.g.getLocationNavigationGravityline();
            if (locationNavigationGravityline != null) {
                this.l.a(locationNavigationGravityline.getWidth(), locationNavigationGravityline.getColor(), locationNavigationGravityline.getDestination());
            }
        }
    }

    private void a(MyLocationStyle myLocationStyle, Location location) {
        if (location == null || myLocationStyle == null) {
            return;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        Circle circle = this.e;
        if (circle != null) {
            circle.setCenter(latLng);
            this.e.setRadius(location.getAccuracy());
        }
        this.l.a(GeoPoint.from(latLng), 0.0f, 0.0f, false);
        int myLocationType = myLocationStyle.getMyLocationType();
        if (myLocationType == 1) {
            this.l.a(location.getBearing());
        } else if (myLocationType != 2) {
            if (myLocationType != 3) {
                this.l.a(location.getBearing());
                a0 a0Var = this.f37453a;
                if (a0Var != null) {
                    a0Var.a(CameraUpdateFactory.newLatLng(latLng));
                    return;
                }
                return;
            }
            a0 a0Var2 = this.f37453a;
            if (a0Var2 != null) {
                this.f37453a.a(CameraUpdateFactory.rotateTo(location.getBearing(), a0Var2.b().tilt));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        if (location == null) {
            return;
        }
        a(location);
        a(this.g, location);
    }

    private BitmapDescriptor f() {
        if (this.o == null) {
            this.o = BitmapDescriptorFactory.fromAsset(this.l, "navi_marker_location.png");
        }
        return this.o;
    }

    private LocationSource.OnLocationChangedListener h() {
        return new a();
    }

    @Override // com.tencent.mapsdk.internal.i0
    public void a() {
        Circle circle = this.e;
        if (circle != null) {
            circle.setVisible(false);
            this.e.remove();
            this.e = null;
        }
    }

    public void a(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f = onMyLocationChangeListener;
    }

    public void a(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        this.n = onMyLocationClickListener;
    }

    public boolean a(float f, float f2) {
        boolean d = this.l.g().d(f, f2);
        boolean z = d;
        if (d) {
            z = d;
            if (this.n != null) {
                LatLng latLng = new LatLng();
                Location location = this.i;
                if (location != null) {
                    latLng.setAltitude(location.getAltitude());
                    latLng.setLongitude(this.i.getLongitude());
                    latLng.setLatitude(this.i.getLatitude());
                }
                z = this.n.onMyLocationClicked(latLng);
            }
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.i0
    public void b() {
        if (this.d) {
            return;
        }
        this.d = true;
        if (this.b == null) {
            this.b = h();
        }
        this.l.n(false);
        this.l.m(false);
        this.l.o(false);
        Circle circle = this.e;
        if (circle != null) {
            circle.setVisible(true);
        }
        LocationSource locationSource = this.f37454c;
        if (locationSource != null) {
            locationSource.activate(this.b);
        }
    }

    @Override // com.tencent.mapsdk.internal.i0
    public void c() {
        Circle circle = this.e;
        if (circle != null) {
            circle.setVisible(false);
            this.e.remove();
            this.e = null;
        }
        if (this.d) {
            this.d = false;
            this.l.n(true);
            this.l.m(true);
            this.l.o(true);
            this.m = 0;
            this.b = null;
            LocationSource locationSource = this.f37454c;
            if (locationSource != null) {
                locationSource.deactivate();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.i0
    public boolean d() {
        return this.d;
    }

    public void e() {
        c();
        this.f37453a = null;
    }

    public BitmapDescriptor g() {
        return this.j;
    }

    @Override // com.tencent.mapsdk.internal.i0
    public Location getMyLocation() {
        if (this.i == null) {
            return null;
        }
        return new Location(this.i);
    }

    @Override // com.tencent.mapsdk.internal.i0
    public void setLocationSource(LocationSource locationSource) {
        this.f37454c = locationSource;
        if (!this.d || locationSource == null) {
            return;
        }
        locationSource.activate(this.b);
    }

    @Override // com.tencent.mapsdk.internal.i0
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        BitmapDescriptor compassImage;
        Bitmap bitmap;
        if (myLocationStyle == null) {
            return;
        }
        this.g = myLocationStyle;
        Circle circle = this.e;
        if (circle != null) {
            circle.setFillColor(myLocationStyle.getFillColor());
            this.e.setStrokeColor(myLocationStyle.getStrokeColor());
            this.e.setStrokeWidth(myLocationStyle.getStrokeWidth());
        }
        if (this.m == 0 || this.j == null) {
            return;
        }
        BitmapDescriptor myLocationIcon = myLocationStyle.getMyLocationIcon();
        BitmapDescriptor bitmapDescriptor = myLocationIcon;
        if (myLocationIcon == null) {
            bitmapDescriptor = f();
        }
        Bitmap bitmap2 = bitmapDescriptor.getBitmap(this.l.getContext());
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            String bitmapId = bitmapDescriptor.getFormater().getBitmapId();
            if (!this.j.getFormater().getBitmapId().equals(bitmapId)) {
                this.j = myLocationStyle.getMyLocationIcon();
                this.m = this.l.a(bitmapId, myLocationStyle.getAnchorU(), myLocationStyle.getAnchorV());
            }
        }
        LocationCompass locationCompass = myLocationStyle.getLocationCompass();
        if (locationCompass != null && locationCompass.getCompassImage() != null && (bitmap = (compassImage = locationCompass.getCompassImage()).getBitmap(this.l.getContext())) != null && !bitmap.isRecycled()) {
            String bitmapId2 = compassImage.getFormater().getBitmapId();
            BitmapDescriptor bitmapDescriptor2 = this.k;
            if (!(bitmapDescriptor2 != null ? bitmapDescriptor2.getFormater().getBitmapId() : "").equals(bitmapId2)) {
                this.k = compassImage;
                this.l.e(bitmapId2);
            }
            BitmapDescriptor[] compassGroupImages = locationCompass.getCompassGroupImages();
            if (compassGroupImages != null && compassGroupImages.length == 4) {
                String[] strArr = new String[compassGroupImages.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= compassGroupImages.length) {
                        break;
                    }
                    if (compassGroupImages[i2] != null) {
                        compassGroupImages[i2].getBitmap(this.l.getContext());
                        strArr[i2] = compassGroupImages[i2].getFormater().getBitmapId();
                    } else {
                        strArr[i2] = "";
                    }
                    i = i2 + 1;
                }
                this.l.a(bitmapId2, strArr[0], strArr[1], strArr[2], strArr[3]);
            }
        }
        LocationNavigationGravityline locationNavigationGravityline = myLocationStyle.getLocationNavigationGravityline();
        if (locationNavigationGravityline != null) {
            this.l.a(locationNavigationGravityline.getWidth(), locationNavigationGravityline.getColor(), locationNavigationGravityline.getDestination());
        }
    }
}
