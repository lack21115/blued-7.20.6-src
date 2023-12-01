package com.zk_oaction.adengine.lk_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sensor/b.class */
public class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, d> f41974a = new HashMap<>();
    private com.zk_oaction.adengine.lk_sdk.b b;

    /* renamed from: c  reason: collision with root package name */
    private Context f41975c;
    private HashMap<String, Integer> d;
    private SensorManager e;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sensor/b$a.class */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41976a;
        final /* synthetic */ String[] b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f41977c;

        a(String str, String[] strArr, boolean z) {
            this.f41976a = str;
            this.b = strArr;
            this.f41977c = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                synchronized (b.this.f41974a) {
                    int a2 = b.this.a(this.f41976a);
                    Sensor defaultSensor = b.this.e.getDefaultSensor(a2);
                    c cVar = this.f41976a.equals("gyroscope") ? new c(b.this.b, this.f41976a, a2, defaultSensor, this.b, b.this.e) : this.f41976a.equals("accelerometer") ? new com.zk_oaction.adengine.lk_sensor.a(b.this.b, this.f41976a, a2, defaultSensor, this.b) : new d(b.this.b, this.f41976a, a2, defaultSensor, this.b);
                    if (b.this.e != null && cVar.f != null && !cVar.h) {
                        if (this.f41977c) {
                            cVar.h = true;
                            cVar.a();
                            b.this.e.registerListener(b.this, cVar.f, 2);
                        }
                        b.this.f41974a.put(this.f41976a, cVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public b(Context context, com.zk_oaction.adengine.lk_sdk.b bVar) {
        this.b = bVar;
        this.f41975c = context;
        this.e = (SensorManager) context.getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        Integer num = this.d.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private void d() {
        HashMap<String, Integer> hashMap = this.d;
        if (hashMap != null && hashMap.size() > 0) {
            return;
        }
        this.d = new HashMap<>();
        try {
            Field[] fields = Sensor.class.getFields();
            int length = fields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Field field = fields[i2];
                String name = field.getName();
                if (name.startsWith("TYPE_")) {
                    this.d.put(name.substring(5).toLowerCase(Locale.US), Integer.valueOf(field.getInt(null)));
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            HashMap<String, d> hashMap = this.f41974a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<String, d> entry : this.f41974a.entrySet()) {
                d value = entry.getValue();
                if (this.e != null && value != null && value.f != null && !value.h) {
                    value.h = true;
                    value.a();
                    this.e.registerListener(this, value.f, 2);
                }
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, String[] strArr, boolean z) {
        try {
            d();
            if (this.e == null) {
                this.e = (SensorManager) this.f41975c.getSystemService("sensor");
            }
            if (this.e == null) {
                return;
            }
            new a(str, strArr, z).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        Sensor sensor;
        try {
            HashMap<String, d> hashMap = this.f41974a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<String, d> entry : this.f41974a.entrySet()) {
                d value = entry.getValue();
                SensorManager sensorManager = this.e;
                if (sensorManager != null && value != null && (sensor = value.f) != null && value.h) {
                    value.h = false;
                    sensorManager.unregisterListener(this, sensor);
                }
            }
        } catch (Throwable th) {
        }
    }

    public void c() {
        try {
            HashMap<String, d> hashMap = this.f41974a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            this.f41974a.clear();
            this.f41974a = null;
        } catch (Throwable th) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.b == null) {
            return;
        }
        try {
            HashMap<String, d> hashMap = this.f41974a;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<String, d> entry : this.f41974a.entrySet()) {
                d value = entry.getValue();
                if (value != null && sensorEvent.sensor.getType() == value.e) {
                    value.a(sensorEvent);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
