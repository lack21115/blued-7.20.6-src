package com.kwad.components.core.r;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/l.class */
public class l {
    private static volatile l Qb;
    private SensorManager Qc;
    private final Map<String, a> Qd = new HashMap();
    private final Map<String, Set<SensorEventListener>> Qe = new ConcurrentHashMap();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/l$a.class */
    public static final class a implements SensorEventListener {
        private final WeakReference<l> Qf;
        private final String key;

        public a(String str, l lVar) {
            this.key = str;
            this.Qf = new WeakReference<>(lVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            l lVar = this.Qf.get();
            if (lVar != null) {
                lVar.a(this.key, sensorEvent);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/l$b.class */
    public interface b {
        void onFailed();
    }

    private l() {
    }

    private void a(String str, int i, Sensor sensor) {
        getSensorManager().registerListener(aF(str), sensor, aK(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        Set<SensorEventListener> set = this.Qe.get(str);
        if (set != null) {
            for (SensorEventListener sensorEventListener : set) {
                sensorEventListener.onSensorChanged(sensorEvent);
            }
        }
    }

    private void aE(String str) {
        a aVar = this.Qd.get(str);
        if (aVar != null) {
            this.Qd.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a aF(String str) {
        a aVar = this.Qd.get(str);
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new a(str, this);
            this.Qd.put(str, aVar2);
        }
        return aVar2;
    }

    private Sensor aJ(int i) {
        SensorManager sensorManager;
        int i2;
        if (getSensorManager() == null) {
            return null;
        }
        if (i == 1) {
            sensorManager = getSensorManager();
            i2 = 10;
        } else if (i != 2) {
            return null;
        } else {
            sensorManager = getSensorManager();
            i2 = 4;
        }
        return sensorManager.getDefaultSensor(i2);
    }

    private static int aK(int i) {
        if (i != -3) {
            if (i != -2) {
                return i != -1 ? 3 : 0;
            }
            return 1;
        }
        return 2;
    }

    private SensorManager getSensorManager() {
        if (this.Qc == null) {
            this.Qc = (SensorManager) ServiceProvider.getContext().getSystemService("sensor");
        }
        return this.Qc;
    }

    private static String l(int i, int i2) {
        return i + "_" + i2;
    }

    public static l pS() {
        if (Qb == null) {
            synchronized (l.class) {
                try {
                    if (Qb == null) {
                        Qb = new l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Qb;
    }

    public final void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor aJ = aJ(i);
        if (aJ == null) {
            bVar.onFailed();
            return;
        }
        String l = l(i, i2);
        Set<SensorEventListener> set = this.Qe.get(l);
        if (set != null) {
            set.add(sensorEventListener);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(sensorEventListener);
        this.Qe.put(l, hashSet);
        a(l, i2, aJ);
    }

    public final void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, Set<SensorEventListener>> entry : this.Qe.entrySet()) {
            Iterator<SensorEventListener> it = entry.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(sensorEventListener)) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (entry.getValue().size() == 0) {
                aE(entry.getKey());
            }
        }
    }
}
