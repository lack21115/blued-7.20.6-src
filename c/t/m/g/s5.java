package c.t.m.g;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationBridge;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.util.SoUtils;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s5.class */
public class s5 implements TencentLocationBridge {

    /* renamed from: a  reason: collision with root package name */
    public t3 f3936a;
    public p4 b;

    public s5(Context context) {
        init(context);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public String getBuild() {
        return "220803";
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public int getCoordinateType() {
        return this.b.i();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public TencentLocation getLastKnownLocation() {
        return this.b.k();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public TencentLocation getPosition() {
        return k6.a(this.f3936a).a();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public String getVersion() {
        return "7.4.9.official_1";
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void init(Context context) {
        q2.a(context);
        q2.a(true);
        this.f3936a = t3.a(context);
        this.b = new p4(this.f3936a);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public boolean isSupport() {
        return k6.a(this.f3936a).b();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void removeUpdates(TencentLocationListener tencentLocationListener) {
        this.b.a(tencentLocationListener);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        return this.b.a(tencentLocationRequest, tencentLocationListener, looper);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public int requestLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        return this.b.a(i, tencentLocationListener);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        return this.b.b(tencentLocationRequest, tencentLocationListener, looper);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void setCoordinateType(int i) {
        this.b.b(i);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void setDebuggable(boolean z) {
        s2.b("CONF_USER_DEBUGGABLE", Boolean.valueOf(z));
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void setDeviceID(Context context, String str) {
        d6.b("LocationSDK", "location_device_id", str);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public int startDrEngine(int i) {
        try {
            return k6.a(this.f3936a).a(i);
        } catch (Exception e) {
            return com.anythink.expressad.video.bt.a.c.f5450a;
        }
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public boolean startIndoorLocation() {
        return this.b.r();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public boolean stopIndoorLocation() {
        return this.b.u();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void stopLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        this.b.b(i, tencentLocationListener);
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void terminateDrEngine() {
        k6.a(this.f3936a).d();
    }

    @Override // com.tencent.map.geolocation.TencentLocationBridge
    public void triggerCodeGuarder(boolean z) {
        SoUtils.fun_x(z);
    }
}
