package com.danlan.android.cognition.sensor;

import android.content.Context;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/SensorCoreManager.class */
public class SensorCoreManager extends DataGroupManager {
    public static final int ACCELEROMETER_LIMIT_NUM = 2;
    private boolean isInitialized = false;
    private SensorCoreListener listener = null;

    private <T extends SensorCoreModel> JSONArray convertSensorDataToJSON(DataGroupArrayList<T> dataGroupArrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = dataGroupArrayList.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next != null) {
                try {
                    SafeJSONObject generateBaseSensorJSON = generateBaseSensorJSON(next);
                    generateBaseSensorJSON.put(StringFog.decrypt("WQ=="), next.getX());
                    generateBaseSensorJSON.put(StringFog.decrypt("WA=="), next.getY());
                    generateBaseSensorJSON.put(StringFog.decrypt("Ww=="), next.getZ());
                    jSONArray.put(generateBaseSensorJSON);
                } catch (Exception e) {
                }
            }
        }
        return jSONArray;
    }

    private <T extends SensorCoreModel> SafeJSONObject generateBaseSensorJSON(T t) {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("VUpJRlJXRUxR"), DateTime.buildISODate(t.getTimestamp()));
        safeJSONObject.put(StringFog.decrypt("QEBHVlNCR1g="), t.getAccuracy());
        return safeJSONObject;
    }

    public int getAccelerometerDataSize() {
        return this.listener.getAccelerometerData().size();
    }

    public void initialize(Context context) {
        this.listener = new SensorCoreListener(context);
        this.isInitialized = true;
    }

    public void registerListeners() {
        if (this.isInitialized) {
            this.listener.registerListeners();
        }
    }

    public void reset() {
        this.listener.reset();
    }

    public void setSensorDelay(int i) {
        if (this.isInitialized) {
            this.listener.setSensorDelay(i);
        }
    }

    @Override // com.danlan.android.cognition.sensor.DataGroupManager
    public SafeJSONObject toJSON() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        safeJSONObject.put(StringFog.decrypt("QEBHRk1GVk5MRlBGUw=="), convertSensorDataToJSON(this.listener.getAccelerometerData()));
        return safeJSONObject;
    }

    public void unregisterListeners() {
        if (this.isInitialized) {
            this.listener.unregisterListeners();
        }
    }
}
