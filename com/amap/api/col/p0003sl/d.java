package com.amap.api.col.p0003sl;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.android.internal.telephony.RILConstants;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.amap.api.col.3sl.d  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/d.class */
public final class d {
    private static boolean G = true;
    private static boolean I = false;
    private static AtomicBoolean J = new AtomicBoolean(false);
    public static volatile boolean g = false;
    private Context C;
    private g D;
    com.autonavi.aps.amapapi.model.a a;
    public c c;
    j j;
    Intent m;
    AMapLocationClientOption b = new AMapLocationClientOption();
    h d = null;
    private boolean E = false;
    private volatile boolean F = false;
    ArrayList<AMapLocationListener> e = new ArrayList<>();
    boolean f = false;
    public boolean h = true;
    public boolean i = true;
    Messenger k = null;
    Messenger l = null;
    int n = 0;
    private boolean H = true;
    b o = null;
    boolean p = false;
    AMapLocationClientOption.AMapLocationMode q = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object r = new Object();
    g s = null;
    boolean t = false;
    e u = null;
    private AMapLocationClientOption K = new AMapLocationClientOption();
    private i L = null;
    String v = null;
    private ServiceConnection M = new ServiceConnection() { // from class: com.amap.api.col.3sl.d.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.k = new Messenger(iBinder);
                d.this.E = true;
                d.this.t = true;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.k = null;
            d.this.E = false;
        }
    };
    AMapLocationQualityReport w = null;
    boolean x = false;
    boolean y = false;
    private volatile boolean N = false;
    a z = null;
    String A = null;
    boolean B = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.d$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/d$3.class */
    public static final /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.d$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/d$a.class */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Message message2 = null;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    d.this.a(message.getData());
                } else if (i == 12) {
                    d.this.b(message);
                } else if (i == 1011) {
                    d.this.a(14, (Bundle) null);
                    d.this.g();
                } else {
                    try {
                        switch (i) {
                            case 1002:
                                d.this.c((AMapLocationListener) message.obj);
                                return;
                            case 1003:
                                d.this.j();
                                d.this.a(13, (Bundle) null);
                                return;
                            case 1004:
                                d.this.l();
                                d.this.a(14, (Bundle) null);
                                return;
                            case 1005:
                                d.this.d((AMapLocationListener) message.obj);
                                return;
                            default:
                                switch (i) {
                                    case 1014:
                                        d.this.a(message);
                                        return;
                                    case RILConstants.RIL_UNSOL_STK_CALL_SETUP /* 1015 */:
                                        d.this.d.a(d.this.b);
                                        d.this.a((int) RILConstants.RIL_UNSOL_CDMA_CALL_WAITING, (Object) null, 300000L);
                                        return;
                                    case RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL /* 1016 */:
                                        if (i.m(d.this.C)) {
                                            d.this.r();
                                            return;
                                        } else if (d.this.d.b()) {
                                            d.this.a((int) RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL, (Object) null, 1000L);
                                            return;
                                        } else {
                                            d.this.n();
                                            return;
                                        }
                                    case RILConstants.RIL_UNSOL_SIM_REFRESH /* 1017 */:
                                        d.this.d.a();
                                        d.this.a(RILConstants.RIL_UNSOL_CDMA_CALL_WAITING);
                                        return;
                                    case RILConstants.RIL_UNSOL_CALL_RING /* 1018 */:
                                        d.this.b = (AMapLocationClientOption) message.obj;
                                        if (d.this.b != null) {
                                            d.this.s();
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i) {
                                            case 1023:
                                                d.this.c(message);
                                                return;
                                            case 1024:
                                                d.this.d(message);
                                                return;
                                            case RILConstants.RIL_UNSOL_CDMA_CALL_WAITING /* 1025 */:
                                                if (d.this.d.f()) {
                                                    d.this.d.a();
                                                    d.this.d.a(d.this.b);
                                                }
                                                d.this.a((int) RILConstants.RIL_UNSOL_CDMA_CALL_WAITING, (Object) null, 300000L);
                                                return;
                                            case RILConstants.RIL_UNSOL_CDMA_OTA_PROVISION_STATUS /* 1026 */:
                                                d.this.D.a(d.this.b);
                                                return;
                                            case RILConstants.RIL_UNSOL_CDMA_INFO_REC /* 1027 */:
                                                d.this.D.a();
                                                return;
                                            case 1028:
                                                d.this.f((AMapLocation) message.obj);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                    } catch (Throwable th) {
                        message2 = message;
                        th = th;
                        Message message3 = message2;
                        if (message2 == null) {
                            message3 = "handleMessage";
                        }
                        com.autonavi.aps.amapapi.utils.b.a(th, "AMapLocationManage$MHandlerr", message3);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.d$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/d$b.class */
    public static final class b extends HandlerThread {
        d a;

        public b(String str, d dVar) {
            super(str);
            this.a = null;
            this.a = dVar;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                this.a.j.a();
                f.a(this.a.C);
                this.a.p();
                if (this.a != null && this.a.C != null) {
                    com.autonavi.aps.amapapi.utils.a.b(this.a.C);
                    com.autonavi.aps.amapapi.utils.a.a(this.a.C);
                }
                super.onLooperPrepared();
            } catch (Throwable th) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.d$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/d$c.class */
    public final class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (d.this.p) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Message obtainMessage = d.this.z.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    d.this.z.sendMessage(obtainMessage);
                    return;
                }
                if (i != 2) {
                    if (i == 13) {
                        if (d.this.a != null) {
                            d.this.a((AMapLocation) d.this.a);
                            return;
                        }
                        AMapLocation aMapLocation = new AMapLocation("LBS");
                        aMapLocation.setErrorCode(33);
                        d.this.a(aMapLocation);
                        return;
                    }
                    switch (i) {
                        case 5:
                            Bundle data = message.getData();
                            data.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d.this.b));
                            d.this.a(10, data);
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            if (d.this.d != null) {
                                d.this.d.a(data2);
                                return;
                            }
                            return;
                        case 7:
                            d.this.H = message.getData().getBoolean("ngpsAble");
                            return;
                        case 8:
                            g.a((String) null, 2141);
                            break;
                        case 9:
                            boolean unused = d.I = message.getData().getBoolean("installMockApp");
                            return;
                        case 10:
                            d.this.a((AMapLocation) message.obj);
                            return;
                        default:
                            switch (i) {
                                case 100:
                                    g.a((String) null, 2155);
                                    break;
                                case 101:
                                    break;
                                case 102:
                                    Bundle data3 = message.getData();
                                    data3.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d.this.b));
                                    d.this.a(15, data3);
                                    return;
                                case 103:
                                    Bundle data4 = message.getData();
                                    if (d.this.D != null) {
                                        d.this.D.a(data4);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1028;
                            obtain.obj = message.obj;
                            d.this.z.sendMessage(obtain);
                            if (d.this.K == null || !d.this.K.getCacheCallBack() || d.this.c == null) {
                                return;
                            }
                            d.this.c.removeMessages(13);
                            return;
                    }
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 12;
                obtain2.obj = message.obj;
                d.this.z.sendMessage(obtain2);
                if (d.this.K == null || !d.this.K.getCacheCallBack() || d.this.c == null) {
                    return;
                }
                d.this.c.removeMessages(13);
            } catch (Throwable th) {
                String str = null;
                if (0 == 0) {
                    str = "handleMessage";
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager$MainHandler", str);
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        this.m = null;
        this.C = context;
        this.m = intent;
        b(looper);
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.r) {
            aVar = new a(looper);
            this.z = aVar;
        }
        return aVar;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.b bVar, boolean z) {
        if (this.b.isLocationCacheEnable()) {
            try {
                return bVar.a(z);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doFirstCacheLoc");
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.r) {
            if (this.z != null) {
                this.z.removeMessages(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            try {
                bundle2 = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.k = null;
                    this.E = false;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = com.autonavi.aps.amapapi.utils.b.b(this.C);
        }
        bundle2.putString("c", this.v);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle2);
        obtain.replyTo = this.l;
        if (this.k != null) {
            this.k.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object obj, long j) {
        synchronized (this.r) {
            if (this.z != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.z.sendMessageDelayed(obtain, j);
            }
        }
    }

    private static void a(final Context context) {
        if (J.compareAndSet(false, true)) {
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.d.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    hs.e();
                    hs.a(context);
                    hs.h(context);
                }
            });
        }
    }

    private void a(Intent intent) {
        try {
            this.C.bindService(intent, this.M, 1);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl");
        }
    }

    private void a(Intent intent, boolean z) {
        if (this.C != null) {
            if (Build.VERSION.SDK_INT < 26 || !z) {
                this.C.startService(intent);
            } else if (!t()) {
                Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                return;
            } else {
                try {
                    this.C.getClass().getMethod("startForegroundService", Intent.class).invoke(this.C, intent);
                } catch (Throwable th) {
                    this.C.startService(intent);
                }
            }
            this.B = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.autonavi.aps.amapapi.a aVar;
        AMapLocation aMapLocation;
        com.autonavi.aps.amapapi.a aVar2;
        AMapLocation aMapLocation2;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                AMapLocation aMapLocation3 = (AMapLocation) bundle.getParcelable("loc");
                this.A = bundle.getString("nb");
                com.autonavi.aps.amapapi.a aVar3 = (com.autonavi.aps.amapapi.a) bundle.getParcelable("statics");
                aMapLocation = aMapLocation3;
                aVar2 = aVar3;
                if (aMapLocation3 != null) {
                    aMapLocation = aMapLocation3;
                    aVar2 = aVar3;
                    aVar = aVar3;
                    try {
                        if (aMapLocation3.getErrorCode() == 0) {
                            aMapLocation = aMapLocation3;
                            aVar2 = aVar3;
                            if (this.d != null) {
                                this.d.c();
                                aMapLocation = aMapLocation3;
                                aVar2 = aVar3;
                                if (!TextUtils.isEmpty(aMapLocation3.getAdCode())) {
                                    h.y = aMapLocation3;
                                    aMapLocation = aMapLocation3;
                                    aVar2 = aVar3;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        aVar2 = aVar;
                        aMapLocation2 = null;
                        a(aMapLocation2, aVar2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                aVar2 = aVar;
                aMapLocation2 = null;
                a(aMapLocation2, aVar2);
            }
        } else {
            aVar2 = null;
            aMapLocation = null;
        }
        if (this.d != null) {
            aVar = aVar2;
            aMapLocation2 = this.d.a(aMapLocation, this.A);
        } else {
            aMapLocation2 = aMapLocation;
        }
        a(aMapLocation2, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            e(aMapLocation);
            if (this.j.a(aMapLocation, string)) {
                this.j.d();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    g.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.d.b()) {
                aMapLocation.setAltitude(i.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(i.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(i.a(aMapLocation.getSpeed()));
                b(aMapLocation);
                Iterator<AMapLocationListener> it = this.e.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void a(AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        synchronized (this) {
            AMapLocation aMapLocation2 = aMapLocation;
            if (aMapLocation == null) {
                try {
                    aMapLocation2 = new AMapLocation("");
                    aMapLocation2.setErrorCode(8);
                    aMapLocation2.setLocationDetail("amapLocation is null#0801");
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerLocation part3");
                    return;
                }
            }
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation2.getProvider())) {
                aMapLocation2.setProvider("lbs");
            }
            if (this.w == null) {
                this.w = new AMapLocationQualityReport();
            }
            this.w.setLocationMode(this.b.getLocationMode());
            if (this.d != null) {
                this.w.setGPSSatellites(this.d.e());
                this.w.setGpsStatus(this.d.d());
            }
            this.w.setWifiAble(i.g(this.C));
            this.w.setNetworkType(i.h(this.C));
            if (aMapLocation2.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation2.getProvider())) {
                this.w.setNetUseTime(0L);
            }
            if (aVar != null) {
                this.w.setNetUseTime(aVar.a());
            }
            this.w.setInstallHighDangerMockApp(I);
            aMapLocation2.setLocationQualityReport(this.w);
            if (this.F) {
                a(aMapLocation2, this.A);
                if (aVar != null) {
                    aVar.d(i.b());
                }
                g.a(this.C, aMapLocation2, aVar);
                g.a(this.C, aMapLocation2);
                c(aMapLocation2.m8814clone());
                f.a(this.C).a(aMapLocation2);
                f.a(this.C).b();
            }
            if (this.p) {
                return;
            }
            if (this.b.isOnceLocation()) {
                l();
                a(14, (Bundle) null);
            }
        }
    }

    private void a(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        a(1014, bundle, 0L);
    }

    private static void a(com.autonavi.aps.amapapi.b bVar) {
        try {
            bVar.d();
            bVar.a(new AMapLocationClientOption().setNeedAddress(false));
            bVar.a(true, new com.autonavi.aps.amapapi.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    private void a(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.a aVar) {
        try {
            bVar.a(this.C);
            bVar.a(this.b);
            bVar.b(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "initApsBase");
        }
    }

    private static void a(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getErrorCode() == 0) {
                    bVar.b(aVar);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|(14:2|3|4|5|(1:7)|8|9|(1:11)|12|13|14|15|(4:17|(2:19|(2:107|(3:109|110|(1:114)))(1:21))|115|116)(1:117)|22)|(4:(27:24|(1:26)(1:105)|27|28|29|(4:31|32|33|(1:35))|37|38|(3:96|97|98)(1:40)|41|42|(4:44|45|46|(1:48))|49|50|(1:54)|55|56|(1:58)|59|60|(1:62)|63|64|(2:66|(3:68|69|(2:71|72)))|87|88|89)|87|88|89)|106|38|(0)(0)|41|42|(0)|49|50|(2:52|54)|55|56|(0)|59|60|(0)|63|64|(0)|(1:(0))) */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01df A[Catch: all -> 0x0214, TRY_ENTER, TryCatch #10 {all -> 0x016b, blocks: (B:62:0x0156, B:99:0x0235, B:101:0x023b, B:68:0x017b, B:72:0x0189, B:74:0x0190, B:83:0x01d1, B:84:0x01d4, B:86:0x01df, B:88:0x0201, B:90:0x020b), top: B:131:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020b A[Catch: all -> 0x0214, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x016b, blocks: (B:62:0x0156, B:99:0x0235, B:101:0x023b, B:68:0x017b, B:72:0x0189, B:74:0x0190, B:83:0x01d1, B:84:0x01d4, B:86:0x01df, B:88:0x0201, B:90:0x020b), top: B:131:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0228  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x026d -> B:83:0x01d1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.b r7) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.d.b(com.autonavi.aps.amapapi.b):com.autonavi.aps.amapapi.model.a");
    }

    private void b(Looper looper) {
        try {
            if (looper != null) {
                this.c = new c(looper);
            } else if (Looper.myLooper() == null) {
                this.c = new c(this.C.getMainLooper());
            } else {
                this.c = new c();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "init 1");
        }
        try {
            this.j = new j(this.C);
            b bVar = new b("amapLocManagerThread", this);
            this.o = bVar;
            bVar.setPriority(5);
            this.o.start();
            this.z = a(this.o.getLooper());
            try {
                this.d = new h(this.C, this.c);
                this.D = new g(this.C, this.c);
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "init 3");
            }
            if (this.s == null) {
                this.s = new g();
            }
            a(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.h && this.k != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.b));
                a(0, bundle);
                if (this.F) {
                    a(13, (Bundle) null);
                }
                this.h = false;
            }
            a(aMapLocation, (com.autonavi.aps.amapapi.a) null);
            a(RILConstants.RIL_UNSOL_CDMA_CALL_WAITING);
            a(RILConstants.RIL_UNSOL_CDMA_CALL_WAITING, (Object) null, 300000L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void b(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                StringBuilder sb = TextUtils.isEmpty(locationDetail) ? new StringBuilder() : new StringBuilder(locationDetail);
                boolean c2 = i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean c3 = i.c(this.C, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean c4 = i.c(this.C, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean c5 = i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean c6 = i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean c7 = i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(c2 ? "#pm1" : "#pm0");
                sb.append(c3 ? "1" : "0");
                sb.append(c4 ? "1" : "0");
                sb.append(c5 ? "1" : "0");
                sb.append(c6 ? "1" : "0");
                sb.append(c7 ? "1" : "0");
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            Notification notification = (Notification) data.getParcelable(iu.g);
            Intent q = q();
            q.putExtra("i", i);
            q.putExtra(iu.g, notification);
            q.putExtra(iu.f, 1);
            a(q, true);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    private void c(AMapLocation aMapLocation) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.c.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        if (this.e.contains(aMapLocationListener)) {
            return;
        }
        this.e.add(aMapLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean(iu.j, true);
            Intent q = q();
            q.putExtra(iu.j, z);
            q.putExtra(iu.f, 2);
            a(q, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private void d(AMapLocation aMapLocation) {
        synchronized (this) {
            AMapLocation aMapLocation2 = aMapLocation;
            if (aMapLocation == null) {
                try {
                    aMapLocation2 = new AMapLocation("");
                    aMapLocation2.setErrorCode(8);
                    aMapLocation2.setLocationDetail("coarse amapLocation is null#2005");
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerCoarseLocation part2");
                    return;
                }
            }
            if (this.w == null) {
                this.w = new AMapLocationQualityReport();
            }
            this.w.setLocationMode(this.b.getLocationMode());
            if (this.D != null) {
                this.w.setGPSSatellites(aMapLocation2.getSatellites());
                this.w.setGpsStatus(this.D.b());
            }
            this.w.setWifiAble(i.g(this.C));
            this.w.setNetworkType(i.h(this.C));
            this.w.setNetUseTime(0L);
            this.w.setInstallHighDangerMockApp(I);
            aMapLocation2.setLocationQualityReport(this.w);
            if (this.F) {
                g.a(this.C, aMapLocation2);
                c(aMapLocation2.m8814clone());
                f.a(this.C).a(aMapLocation2);
                f.a(this.C).b();
            }
            if (this.p) {
                return;
            }
            if (this.D != null) {
                l();
            }
            a(14, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AMapLocationListener aMapLocationListener) {
        if (!this.e.isEmpty() && this.e.contains(aMapLocationListener)) {
            this.e.remove(aMapLocationListener);
        }
        if (this.e.isEmpty()) {
            l();
        }
    }

    private void e(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        AMapLocation aMapLocation2 = null;
        try {
            if (j.b != null) {
                aMapLocation2 = j.b.a();
            } else if (this.j != null) {
                aMapLocation2 = this.j.b();
            }
            g.a(aMapLocation2, aMapLocation);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AMapLocation aMapLocation) {
        try {
            if (this.i && this.k != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.b));
                a(0, bundle);
                if (this.F) {
                    a(13, (Bundle) null);
                }
                this.i = false;
            }
            d(aMapLocation);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void h() {
        synchronized (this.r) {
            if (this.z != null) {
                this.z.removeCallbacksAndMessages(null);
            }
            this.z = null;
        }
    }

    private boolean i() {
        int i;
        boolean z = false;
        int i2 = 0;
        do {
            try {
                if (this.k != null) {
                    break;
                }
                Thread.sleep(100L);
                i = i2 + 1;
                i2 = i;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.k == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (i.k(this.C.getApplicationContext())) {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            } else {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.c.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            if (!i.k(this.C.getApplicationContext())) {
                g.a((String) null, 2103);
                return z;
            }
            g.a((String) null, (int) AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            if ((Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 23 && !i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((Build.VERSION.SDK_INT < 31 && Build.VERSION.SDK_INT >= 29 && !i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (Build.VERSION.SDK_INT >= 31 && !i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !i.c(this.C, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")))) {
                k();
                return;
            }
            if (this.b == null) {
                this.b = new AMapLocationClientOption();
            }
            if (this.F) {
                return;
            }
            this.F = true;
            int i = AnonymousClass3.a[this.b.getLocationMode().ordinal()];
            if (i == 1) {
                a(RILConstants.RIL_UNSOL_CDMA_INFO_REC, (Object) null, 0L);
                a(RILConstants.RIL_UNSOL_SIM_REFRESH, (Object) null, 0L);
                a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL, (Object) null, 0L);
            } else if (i == 2) {
                if (i.m(this.C)) {
                    a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL);
                    a(RILConstants.RIL_UNSOL_SIM_REFRESH, (Object) null, 0L);
                    a(RILConstants.RIL_UNSOL_CDMA_OTA_PROVISION_STATUS, (Object) null, 0L);
                    return;
                }
                a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL);
                a(RILConstants.RIL_UNSOL_CDMA_INFO_REC, (Object) null, 0L);
                a(RILConstants.RIL_UNSOL_STK_CALL_SETUP, (Object) null, 0L);
            } else {
                if (i == 3) {
                    if (i.m(this.C)) {
                        a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL);
                        a(RILConstants.RIL_UNSOL_SIM_REFRESH, (Object) null, 0L);
                        a(RILConstants.RIL_UNSOL_CDMA_OTA_PROVISION_STATUS, (Object) null, 0L);
                        return;
                    }
                    a(RILConstants.RIL_UNSOL_CDMA_INFO_REC, (Object) null, 0L);
                    a(RILConstants.RIL_UNSOL_STK_CALL_SETUP, (Object) null, 0L);
                    long j = 0;
                    if (this.b.isGpsFirst()) {
                        j = 0;
                        if (this.b.isOnceLocation()) {
                            j = this.b.getGpsFirstTimeout();
                        }
                    }
                    a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL, (Object) null, j);
                }
            }
        }
    }

    private void k() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.w == null) {
            this.w = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.w = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.w.setGPSSatellites(0);
        this.w.setLocationMode(this.b.getLocationMode());
        this.w.setWifiAble(i.g(this.C));
        this.w.setNetworkType(i.h(this.C));
        this.w.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.w);
        g.a((String) null, 2121);
        c(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            a(RILConstants.RIL_UNSOL_CDMA_CALL_WAITING);
            if (this.d != null) {
                this.d.a();
            }
            if (this.D != null) {
                this.D.a();
            }
            a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL);
            this.F = false;
            this.n = 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    private void m() {
        com.autonavi.aps.amapapi.model.a b2 = b(new com.autonavi.aps.amapapi.b(true));
        if (i()) {
            Bundle bundle = new Bundle();
            String str = (b2 == null || !(b2.getLocationType() == 2 || b2.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.b));
            bundle.putString("isCacheLoc", str);
            a(0, bundle);
            if (this.F) {
                a(13, (Bundle) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (G || !(this.t || this.N)) {
                G = false;
                this.N = true;
                m();
            } else {
                if (this.t && !a() && !this.y) {
                    this.y = true;
                    p();
                }
                if (i()) {
                    this.y = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.b));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.d.b()) {
                        a(1, bundle);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doLBSLocation");
                try {
                    if (this.b.isOnceLocation()) {
                        return;
                    }
                    o();
                } catch (Throwable th2) {
                }
            } finally {
                try {
                    if (!this.b.isOnceLocation()) {
                        o();
                    }
                } catch (Throwable th3) {
                }
            }
        }
    }

    private void o() {
        if (this.b.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j = 1000;
            if (this.b.getInterval() >= 1000) {
                j = this.b.getInterval();
            }
            a(RILConstants.RIL_UNSOL_SIM_SMS_STORAGE_FULL, (Object) null, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.l == null) {
                this.l = new Messenger(this.c);
            }
            a(q());
        } catch (Throwable th) {
        }
    }

    private Intent q() {
        String str;
        if (this.m == null) {
            this.m = new Intent(this.C, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : ho.f(this.C);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.m.putExtra("a", str);
        this.m.putExtra("b", ho.c(this.C));
        this.m.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            StringBuilder sb = new StringBuilder();
            new com.autonavi.aps.amapapi.a().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            g.a((String) null, 2153);
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(20);
            aVar.setLocationDetail(sb.toString());
            f((AMapLocation) aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.d.b(this.b);
        this.D.b(this.b);
        if (this.F && !this.b.getLocationMode().equals(this.q)) {
            l();
            j();
        }
        this.q = this.b.getLocationMode();
        if (this.s != null) {
            if (this.b.isOnceLocation()) {
                this.s.a(this.C, 0);
            } else {
                this.s.a(this.C, 1);
            }
            this.s.a(this.C, this.b);
        }
    }

    private boolean t() {
        if (i.j(this.C)) {
            int i = -1;
            try {
                i = e.b(((Application) this.C.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[]{"android.permission.FOREGROUND_SERVICE"});
            } catch (Throwable th) {
            }
            return i == 0;
        }
        return true;
    }

    public final void a(int i, Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("i", i);
            bundle.putParcelable(iu.g, notification);
            a(1023, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void a(WebView webView) {
        if (this.L == null) {
            this.L = new i(this.C, webView);
        }
        this.L.a();
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.K = aMapLocationClientOption.m8816clone();
            a(RILConstants.RIL_UNSOL_CALL_RING, aMapLocationClientOption.m8816clone(), 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void a(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationListener");
        }
    }

    public final void a(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(iu.j, z);
            a(1024, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean a() {
        return this.E;
    }

    public final void b() {
        try {
            if (this.K.getCacheCallBack() && this.c != null) {
                this.c.sendEmptyMessageDelayed(13, this.K.getCacheCallBackTime());
            }
        } catch (Throwable th) {
        }
        try {
            a(1003, (Object) null, 0L);
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "startLocation");
        }
    }

    public final void b(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void c() {
        try {
            a(1004, (Object) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final void d() {
        try {
            if (this.L != null) {
                this.L.b();
                this.L = null;
            }
            a(1011, (Object) null, 0L);
            this.p = true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onDestroy");
        }
    }

    public final AMapLocation e() {
        AMapLocation aMapLocation = null;
        AMapLocation aMapLocation2 = null;
        try {
            if (this.j != null) {
                AMapLocation b2 = this.j.b();
                aMapLocation = b2;
                if (b2 != null) {
                    aMapLocation2 = b2;
                    b2.setTrustedLevel(3);
                    return b2;
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "getLastKnownLocation");
            aMapLocation = aMapLocation2;
        }
        return aMapLocation;
    }

    public final void f() {
        try {
            if (this.L != null) {
                this.L.b();
                this.L = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    final void g() {
        a(12, (Bundle) null);
        this.h = true;
        this.i = true;
        this.E = false;
        this.t = false;
        l();
        g gVar = this.s;
        if (gVar != null) {
            gVar.b(this.C);
        }
        f.a(this.C).a();
        g.a(this.C);
        e eVar = this.u;
        if (eVar != null) {
            eVar.b().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.M;
            if (serviceConnection != null) {
                this.C.unbindService(serviceConnection);
            }
        }
        try {
            if (this.B) {
                this.C.stopService(q());
            }
        } catch (Throwable th) {
        }
        this.B = false;
        ArrayList<AMapLocationListener> arrayList = this.e;
        if (arrayList != null) {
            arrayList.clear();
            this.e = null;
        }
        this.M = null;
        h();
        if (this.o != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    e.a(this.o, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable th2) {
                    this.o.quit();
                }
            } else {
                this.o.quit();
            }
        }
        this.o = null;
        c cVar = this.c;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        j jVar = this.j;
        if (jVar != null) {
            jVar.c();
            this.j = null;
        }
    }
}
