package com.tencent.map.geolocation;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import c.t.m.g.e4;
import c.t.m.g.h5;
import c.t.m.g.s3;
import c.t.m.g.s5;
import com.anythink.expressad.foundation.g.b.b;
import com.anythink.expressad.video.bt.a.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocationManager.class */
public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static int DR_TYPE_BIKE = 3;
    public static int DR_TYPE_WALK = 2;
    public static final int SIGN_IN_SCENE = 10;
    public static final int SPORT_SCENE = 11;
    public static final int TRANSPORT_SCENE = 12;
    public static boolean f = false;
    public static TencentLocationManager g;
    public Context d;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37252a = false;
    public final byte[] b = new byte[0];
    public ServiceConnection e = new ServiceConnection(this) { // from class: com.tencent.map.geolocation.TencentLocationManager.1
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            s3.a("LOC", "s onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            s3.a("LOC", "s onServiceDisconnected");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public TencentLocationBridge f37253c = a();

    public TencentLocationManager(Context context) {
        this.d = context;
    }

    public static TencentLocationManager getInstance(Context context) throws NullPointerException, IllegalArgumentException {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            try {
                if (g == null) {
                    if (context == null) {
                        throw new NullPointerException(b.f7836a);
                    }
                    if (context.getApplicationContext() == null) {
                        throw new NullPointerException("application context is null");
                    }
                    g = new TencentLocationManager(context.getApplicationContext());
                }
                tencentLocationManager = g;
            } finally {
            }
        }
        return tencentLocationManager;
    }

    public static boolean getUserAgreePrivacy() {
        return f;
    }

    public static void setUserAgreePrivacy(boolean z) {
        f = z;
    }

    public final TencentLocationBridge a() {
        if (f) {
            TencentLocationBridge tencentLocationBridge = this.f37253c;
            return tencentLocationBridge != null ? tencentLocationBridge : new s5(this.d);
        }
        return null;
    }

    public void disableForegroundLocation(boolean z) {
        if (f && this.f37252a) {
            s.removeNotification = z;
            this.d.unbindService(this.e);
            this.f37252a = false;
            s3.a("LOC", "disableForegroundLocation");
        }
    }

    public void enableForegroundLocation(int i, Notification notification) throws IllegalArgumentException {
        if (f) {
            if (i <= 0 || notification == null) {
                throw new IllegalArgumentException("enableForegroundLocation illegalArgument");
            }
            if (this.f37252a) {
                return;
            }
            Intent intent = new Intent(this.d, s.class);
            intent.putExtra("LocNotification", notification);
            intent.putExtra("LocNotificationId", i);
            this.d.bindService(intent, this.e, 1);
            this.f37252a = true;
            s3.a("LOC", "enableForegroundLocation");
        }
    }

    public String getBuild() {
        String build;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                build = a2.getBuild();
            }
            return build;
        }
        return "";
    }

    public int getCoordinateType() {
        synchronized (this.b) {
            if (f) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                return a2.getCoordinateType();
            }
            return -1;
        }
    }

    public TencentLocation getDrPosition() {
        TencentLocation position;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                position = a2.getPosition();
            }
            return position;
        }
        return null;
    }

    public TencentLocation getLastKnownLocation() {
        TencentLocation lastKnownLocation;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                lastKnownLocation = a2.getLastKnownLocation();
            }
            return lastKnownLocation;
        }
        return null;
    }

    public String getVersion() {
        String version;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                version = a2.getVersion();
            }
            return version;
        }
        return "";
    }

    public boolean isDrSupport() {
        boolean isSupport;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                isSupport = a2.isSupport();
            }
            return isSupport;
        }
        return false;
    }

    public void removeUpdates(TencentLocationListener tencentLocationListener) {
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                a2.removeUpdates(tencentLocationListener);
            }
        }
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        if (f) {
            return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
        }
        return 4;
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int requestLocationUpdates;
        if (f) {
            if (tencentLocationRequest != null) {
                if (tencentLocationListener != null) {
                    if (looper != null) {
                        synchronized (this.b) {
                            TencentLocationBridge a2 = a();
                            this.f37253c = a2;
                            requestLocationUpdates = a2.requestLocationUpdates(tencentLocationRequest, tencentLocationListener, looper);
                        }
                        return requestLocationUpdates;
                    }
                    throw new NullPointerException("looper is null");
                }
                throw new NullPointerException("listener is null");
            }
            throw new NullPointerException("request is null");
        }
        return 4;
    }

    public int requestLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        int requestLocationWithScene;
        if (f) {
            synchronized (this.b) {
                if (i != 10 && i != 11 && i != 12) {
                    throw new IllegalArgumentException("unknown scenario type: " + i);
                }
                synchronized (this.b) {
                    TencentLocationBridge a2 = a();
                    this.f37253c = a2;
                    requestLocationWithScene = a2.requestLocationWithScene(i, tencentLocationListener);
                }
            }
            return requestLocationWithScene;
        }
        return 4;
    }

    public int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int requestSingleFreshLocation;
        if (f) {
            if (tencentLocationListener != null) {
                if (looper != null) {
                    synchronized (this.b) {
                        TencentLocationBridge a2 = a();
                        this.f37253c = a2;
                        requestSingleFreshLocation = a2.requestSingleFreshLocation(tencentLocationRequest, tencentLocationListener, looper);
                    }
                    return requestSingleFreshLocation;
                }
                throw new NullPointerException("looper is null");
            }
            throw new NullPointerException("listener is null");
        }
        return 4;
    }

    public void setCoordinateType(int i) {
        if (f) {
            synchronized (this.b) {
                if (i != 1 && i != 0) {
                    throw new IllegalArgumentException("unknown coordinate type: " + i);
                }
                synchronized (this.b) {
                    TencentLocationBridge a2 = a();
                    this.f37253c = a2;
                    a2.setCoordinateType(i);
                }
            }
        }
    }

    public void setDebuggable(boolean z) {
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                a2.setDebuggable(z);
            }
        }
    }

    public void setDeviceID(Context context, String str) {
        if (f) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("setDeviceID, deviceID length must more than 0");
            }
            if (str.length() > 63) {
                str = str.substring(0, 63);
            }
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                a2.setDeviceID(context, str);
            }
        }
    }

    public void setMockEnable(boolean z) {
        if (f) {
            e4.a(z);
        }
    }

    public void setSystemCacheEnable(boolean z) {
        if (f) {
            h5.a(z);
        }
    }

    public int startDrEngine(int i) {
        int startDrEngine;
        if (f) {
            try {
                synchronized (this.b) {
                    TencentLocationBridge a2 = a();
                    this.f37253c = a2;
                    startDrEngine = a2.startDrEngine(i);
                }
                return startDrEngine;
            } catch (Exception e) {
                return c.f8290a;
            }
        }
        return -6;
    }

    @Deprecated
    public boolean startIndoorLocation() {
        boolean startIndoorLocation;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                startIndoorLocation = a2.startIndoorLocation();
            }
            return startIndoorLocation;
        }
        return false;
    }

    @Deprecated
    public boolean stopIndoorLocation() {
        boolean stopIndoorLocation;
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                stopIndoorLocation = a2.stopIndoorLocation();
            }
            return stopIndoorLocation;
        }
        return false;
    }

    public void stopLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        if (f) {
            synchronized (this.b) {
                if (i != 10 && i != 11 && i != 12) {
                    throw new IllegalArgumentException("unknown scenario type: " + i);
                }
                synchronized (this.b) {
                    TencentLocationBridge a2 = a();
                    this.f37253c = a2;
                    a2.stopLocationWithScene(i, tencentLocationListener);
                }
            }
        }
    }

    public void terminateDrEngine() {
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                a2.terminateDrEngine();
            }
        }
    }

    public void triggerCodeGuarder(boolean z) {
        if (f) {
            synchronized (this.b) {
                TencentLocationBridge a2 = a();
                this.f37253c = a2;
                a2.triggerCodeGuarder(z);
            }
        }
    }
}
