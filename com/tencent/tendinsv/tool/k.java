package com.tencent.tendinsv.tool;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f25384a;
    private Context b;
    private Handler h;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f25385c = 0;
    private volatile String d = "";
    private String e = "0";
    private TelephonyManager f = null;
    private HandlerThread g = new HandlerThread("handlerThread");
    private AtomicInteger i = new AtomicInteger();
    private PhoneStateListener j = new PhoneStateListener() { // from class: com.tencent.tendinsv.tool.k.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (k.this.g == null || !k.this.g.isAlive() || k.this.h == null) {
                k.this.a(signalStrength);
                return;
            }
            if (k.this.i.get() > 2) {
                k.this.i.set(0);
                k.this.h.removeMessages(1);
            }
            k.this.i.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = signalStrength;
            k.this.h.sendMessage(obtain);
        }
    };

    private k() {
    }

    public static k a() {
        if (f25384a == null) {
            synchronized (k.class) {
                try {
                    if (f25384a == null) {
                        f25384a = new k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25384a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SignalStrength signalStrength) {
        String str;
        try {
            try {
                int networkType = this.f.getNetworkType();
                switch (networkType) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        try {
                            this.f25385c = ((Integer) signalStrength.getClass().getMethod("getGsmDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
                        } catch (Exception e) {
                            this.f25385c = -1000;
                        }
                        switch (networkType) {
                            case 3:
                                str = "UMTS";
                                this.d = str;
                                break;
                            case 5:
                                str = "EVDO0";
                                this.d = str;
                                break;
                            case 6:
                                str = "EVDOA";
                                this.d = str;
                                break;
                            case 8:
                                str = "HSDPA";
                                this.d = str;
                                break;
                            case 9:
                                str = "HSUPA";
                                this.d = str;
                                break;
                            case 10:
                                str = "HSPA";
                                this.d = str;
                                break;
                            case 12:
                                str = "EVDOB";
                                this.d = str;
                                break;
                            case 14:
                                str = "EHRPD";
                                this.d = str;
                                break;
                            case 15:
                                str = "HSPAP";
                                this.d = str;
                                break;
                        }
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                    default:
                        this.f25385c = signalStrength.getGsmSignalStrength();
                        if (networkType == 1) {
                            str = "GPRS";
                        } else if (networkType == 2) {
                            str = "EDGE";
                        } else if (networkType == 4) {
                            str = "CDMA";
                        } else if (networkType == 7) {
                            str = "1xRTT";
                        } else if (networkType == 11) {
                            str = "IDEN";
                        } else if (networkType != 16) {
                            if (networkType != 18) {
                                str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
                            }
                            this.d = "IWLAN";
                            break;
                        } else {
                            str = "GMS";
                        }
                        this.d = str;
                        break;
                    case 13:
                    case 18:
                    case 19:
                        try {
                            this.f25385c = ((Integer) signalStrength.getClass().getMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
                        } catch (Exception e2) {
                            this.f25385c = -1000;
                        }
                        if (networkType != 13) {
                            if (networkType != 18) {
                                if (networkType == 19) {
                                    str = "LTE_CA";
                                }
                            }
                            this.d = "IWLAN";
                            break;
                        } else {
                            str = "LTE";
                        }
                        this.d = str;
                        break;
                    case 17:
                        try {
                            this.f25385c = ((Integer) signalStrength.getClass().getMethod("getTdScdmaDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        str = "TD_SCDMA";
                        this.d = str;
                        break;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            this.i.getAndDecrement();
        }
    }

    private String f() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            if (this.b != null && (wifiManager = (WifiManager) this.b.getApplicationContext().getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && connectionInfo.getBSSID() != null) {
                this.e = String.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100));
            }
            return this.e;
        } catch (Exception e) {
            e.printStackTrace();
            this.e = "-1000";
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "obtainWifiInfo--Exception_e=", e);
            return this.e;
        }
    }

    public void a(Context context) {
        HandlerThread handlerThread;
        if (context != null) {
            try {
                this.b = context;
                if (this.f == null) {
                    this.f = (TelephonyManager) context.getSystemService("phone");
                }
                if (this.g != null) {
                    if (!this.g.isAlive()) {
                        handlerThread = this.g;
                    }
                    this.h = new Handler(this.g.getLooper()) { // from class: com.tencent.tendinsv.tool.k.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            k.this.a((SignalStrength) message.obj);
                        }
                    };
                    this.f.listen(this.j, 256);
                }
                handlerThread = new HandlerThread("handlerThread");
                this.g = handlerThread;
                handlerThread.start();
                this.h = new Handler(this.g.getLooper()) { // from class: com.tencent.tendinsv.tool.k.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        k.this.a((SignalStrength) message.obj);
                    }
                };
                this.f.listen(this.j, 256);
            } catch (Exception e) {
                com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "setSignalStrengthsChangeListener--Exception_e=", e);
            }
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        try {
            this.e = com.tencent.tendinsv.utils.c.a(this.b) ? f() : "-1";
            return this.e;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1000";
        }
    }

    public int d() {
        try {
            if (!com.tencent.tendinsv.utils.c.a(this.b, null)) {
                this.f25385c = -1;
            } else if (this.f25385c > 0) {
                this.f25385c = 0;
            }
            return this.f25385c;
        } catch (Exception e) {
            e.printStackTrace();
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "getItedbm--Exception_e=", e);
            return -1000;
        }
    }

    public void e() {
        this.g.getLooper().quit();
        this.g = null;
    }
}
