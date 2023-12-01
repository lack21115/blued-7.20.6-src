package com.danlan.android.cognition.collector;

import android.content.Context;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.sensor.SensorCoreManager;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/SensorCollector.class */
public class SensorCollector extends SubCollector {
    private long endTime;
    private Context mcontext;
    public SensorCoreManager sensorManager;
    private int waitTime;

    public SensorCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.waitTime = 80;
        this.endTime = 0L;
        this.mcontext = context;
        SensorCoreManager sensorCoreManager = new SensorCoreManager();
        this.sensorManager = sensorCoreManager;
        sensorCoreManager.initialize(context);
        this.sensorManager.setSensorDelay(1);
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        try {
            this.sensorManager.registerListeners();
            this.endTime = System.currentTimeMillis() + this.waitTime;
            do {
                if (this.sensorManager.getAccelerometerDataSize() == 2) {
                    break;
                }
            } while (System.currentTimeMillis() < this.endTime);
            this.sensorManager.unregisterListeners();
        } catch (Exception e) {
        }
        put(StringFog.decrypt("UkZKUE5R"), this.sensorManager.toJSON());
        collectDone();
    }
}
