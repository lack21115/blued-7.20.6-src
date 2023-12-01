package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax.class */
public final class ax {
    private static Context aAp;
    private static Map<String, j> aAq = new HashMap();
    private static b aAr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax$a.class */
    public static final class a extends j<com.kwad.sdk.h.kwai.b> {
        private static com.kwad.sdk.h.kwai.b aAs;

        public a(boolean z) {
            super(z);
        }

        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.a((Object) cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable th) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* renamed from: cG */
        public com.kwad.sdk.h.kwai.b bG(Context context) {
            int i;
            int i2;
            CellInfo cellInfo;
            if (at.DU() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
                return aAs;
            }
            com.kwad.sdk.h.kwai.b bVar = aAs;
            if (bVar != null) {
                return bVar;
            }
            if (context == null || at.DU()) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
                if (bd.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getBaseStationId();
                        i = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i2 = gsmCellLocation.getCid();
                        i = gsmCellLocation.getLac();
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    int i3 = -1;
                    if (Build.VERSION.SDK_INT >= 17) {
                        Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                        while (true) {
                            cellInfo = null;
                            if (!it.hasNext()) {
                                break;
                            }
                            cellInfo = it.next();
                            if (cellInfo != null && cellInfo.isRegistered()) {
                                break;
                            }
                        }
                        i3 = -1;
                        if (cellInfo != null) {
                            i3 = a(cellInfo);
                        }
                    }
                    aAs = new com.kwad.sdk.h.kwai.b(i2, i, i3);
                }
                return aAs;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax$b.class */
    public static final class b implements SensorEventListener {
        private d aAt;
        private d aAu;
        private d aAv;
        protected boolean azm = false;
        private boolean aAw = false;

        public b(Context context) {
            if (0 == 0) {
                try {
                    cH(context);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
            }
        }

        private List<com.kwad.sdk.h.kwai.e> Eq() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.aAt;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar.Er(), this.aAt.getTimestamp()));
            }
            d dVar2 = this.aAu;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar2.Er(), this.aAu.getTimestamp()));
            }
            d dVar3 = this.aAv;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.h.kwai.e.a(dVar3.Er(), this.aAv.getTimestamp()));
            }
            return arrayList;
        }

        private static boolean a(SensorManager sensorManager, int i, SensorEventListener sensorEventListener) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i);
            if (defaultSensor == null) {
                return false;
            }
            return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
        }

        private void cH(Context context) {
            SensorManager sensorManager;
            try {
                sensorManager = (SensorManager) context.getSystemService("sensor");
            } catch (Exception e) {
                sensorManager = null;
            }
            if (sensorManager == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a(sensorManager, 1, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a(sensorManager, 4, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gravitySensorAvailable : " + a(sensorManager, 9, this));
        }

        private List<com.kwad.sdk.h.kwai.e> cI(Context context) {
            final ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList();
                final SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                final CountDownLatch countDownLatch = new CountDownLatch(3);
                if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.utils.ax.b.1
                    @Override // android.hardware.SensorEventListener
                    public final void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                        arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                })) {
                    countDownLatch.countDown();
                }
                if (!a(sensorManager, 4, new c() { // from class: com.kwad.sdk.utils.ax.b.2
                    @Override // android.hardware.SensorEventListener
                    public final void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                        arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                })) {
                    countDownLatch.countDown();
                }
                if (!a(sensorManager, 9, new c() { // from class: com.kwad.sdk.utils.ax.b.3
                    @Override // android.hardware.SensorEventListener
                    public final void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                        arrayList.add(com.kwad.sdk.h.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                })) {
                    countDownLatch.countDown();
                }
                try {
                    countDownLatch.await(2L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                }
            }
            return arrayList;
        }

        private List<com.kwad.sdk.h.kwai.e> cK(Context context) {
            if (context == null) {
                return null;
            }
            return this.aAw ? cI(context) : Eq();
        }

        public final List<com.kwad.sdk.h.kwai.e> cJ(Context context) {
            if (this.azm) {
                return null;
            }
            try {
                return cK(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return null;
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.aAt = new d(sensorEvent);
            } else if (type == 4) {
                this.aAu = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.aAv = new d(sensorEvent);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax$c.class */
    static abstract class c implements SensorEventListener {
        c() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax$d.class */
    public static final class d {
        private SensorEvent aAA;
        private long timestamp = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.aAA = sensorEvent;
        }

        public final SensorEvent Er() {
            return this.aAA;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ax$e.class */
    public static final class e extends j<com.kwad.sdk.h.kwai.f> {
        public e(boolean z) {
            super(z);
        }

        private static com.kwad.sdk.h.kwai.f cL(Context context) {
            com.kwad.sdk.h.kwai.f fVar = new com.kwad.sdk.h.kwai.f();
            fVar.axK = au.cu(context);
            fVar.axJ = au.cs(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        protected final /* synthetic */ com.kwad.sdk.h.kwai.f bG(Context context) {
            return cL(context);
        }
    }

    public static com.kwad.sdk.h.kwai.b Ci() {
        if (Ep()) {
            return (com.kwad.sdk.h.kwai.b) eM("baseStationEnable");
        }
        return null;
    }

    public static com.kwad.sdk.h.kwai.f Cj() {
        if (Ep()) {
            return (com.kwad.sdk.h.kwai.f) eM("simCardInfoEnable");
        }
        return null;
    }

    public static List<com.kwad.sdk.h.kwai.e> Ek() {
        if (o.CW()) {
            Context applicationContext = ServiceProvider.getContext().getApplicationContext();
            if (aAr == null) {
                aAr = new b(applicationContext);
            }
            return aAr.cJ(applicationContext);
        }
        return null;
    }

    private static boolean Ep() {
        return aAp != null;
    }

    private static <T> j<T> eL(String str) {
        try {
            return aAq.get(str);
        } catch (Exception e2) {
            return null;
        }
    }

    private static <T> T eM(String str) {
        j eL = eL(str);
        if (eL != null) {
            return (T) eL.bF(aAp);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
        } else if (!Ep()) {
            aAp = context.getApplicationContext();
            aAq.put("baseStationEnable", new a(fVar.sz()));
            aAq.put("simCardInfoEnable", new e(fVar.sx()));
        } else {
            if (aAq.containsKey("baseStationEnable")) {
                boolean sz = fVar.sz();
                j eL = eL("baseStationEnable");
                if (eL != null) {
                    eL.aP(sz);
                }
            }
            if (aAq.containsKey("simCardInfoEnable")) {
                boolean sx = fVar.sx();
                j eL2 = eL("simCardInfoEnable");
                if (eL2 != null) {
                    eL2.aP(sx);
                }
            }
        }
    }
}
