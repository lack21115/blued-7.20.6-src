package com.soft.blued.ui.web.modelloader.fetcher;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.jsbridge.CallJsModel;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/fetcher/ShakeFetcher.class */
public class ShakeFetcher implements SensorEventListener, DataFetcher {
    Sensor accelerometerSensor;
    FragmentActivity activity;
    BridgeManager bridgeManager;
    private long lastTime;
    long mLastTimePositionA;
    long mLastTimePositionB;
    long mLastTimePositionC;
    long mLastUpdateTime;
    float mLastX;
    float mLastY;
    float mLastZ;
    Sensor magneticSensor;
    SensorManager sensorManager;
    public final int SHAKE_LOW = 400;
    public final int SHAKE_MEDIUM = 1000;
    public final int SHAKE_HIGH = 3000;
    boolean isFirst = true;
    float[] geomagnetic = new float[3];
    float[] gravity = new float[3];
    float[] lastResult = new float[3];
    boolean fitSpeed = false;
    boolean fitAngle = false;

    public ShakeFetcher(BridgeManager bridgeManager, FragmentActivity fragmentActivity) {
        this.bridgeManager = bridgeManager;
        this.activity = fragmentActivity;
    }

    private String double3toStr(double d, double d2, double d3) {
        return ((int) d) + "," + ((int) d2) + "," + ((int) d3);
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void cancel() {
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void loadData(String str, CallBackFunction callBackFunction, DataFetcher.DataFetcherCallback dataFetcherCallback) {
        SensorManager sensorManager = (SensorManager) this.activity.getSystemService("sensor");
        this.sensorManager = sensorManager;
        this.accelerometerSensor = sensorManager.getDefaultSensor(1);
        this.magneticSensor = this.sensorManager.getDefaultSensor(2);
        this.activity.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.web.modelloader.fetcher.ShakeFetcher.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                ShakeFetcher.this.activity.getLifecycle().removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void onPause() {
                SensorManager sensorManager2 = ShakeFetcher.this.sensorManager;
                ShakeFetcher shakeFetcher = ShakeFetcher.this;
                sensorManager2.unregisterListener(shakeFetcher, shakeFetcher.accelerometerSensor);
                SensorManager sensorManager3 = ShakeFetcher.this.sensorManager;
                ShakeFetcher shakeFetcher2 = ShakeFetcher.this;
                sensorManager3.unregisterListener(shakeFetcher2, shakeFetcher2.magneticSensor);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResume() {
                SensorManager sensorManager2 = ShakeFetcher.this.sensorManager;
                ShakeFetcher shakeFetcher = ShakeFetcher.this;
                sensorManager2.registerListener(shakeFetcher, shakeFetcher.accelerometerSensor, 3);
                SensorManager sensorManager3 = ShakeFetcher.this.sensorManager;
                ShakeFetcher shakeFetcher2 = ShakeFetcher.this;
                sensorManager3.registerListener(shakeFetcher2, shakeFetcher2.magneticSensor, 3);
            }
        });
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = new float[9];
        float[] fArr2 = new float[3];
        if (type == 2) {
            this.geomagnetic = sensorEvent.values;
        }
        if (type == 1) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = f - this.mLastX;
            float f5 = f2 - this.mLastY;
            float f6 = f3 - this.mLastZ;
            this.mLastX = f;
            this.mLastY = f2;
            this.mLastZ = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
            if (this.isFirst) {
                this.isFirst = false;
            } else if (Double.isInfinite(sqrt)) {
            } else {
                float[] fArr3 = sensorEvent.values;
                this.gravity = fArr3;
                SensorManager.getRotationMatrix(fArr, null, fArr3, this.geomagnetic);
                SensorManager.getOrientation(fArr, fArr2);
                double degrees = Math.toDegrees(fArr2[0]);
                double degrees2 = Math.toDegrees(fArr2[1]);
                double degrees3 = Math.toDegrees(fArr2[2]);
                float[] fArr4 = this.lastResult;
                if (fArr4[0] == 0.0f && fArr4[1] == 0.0f && fArr4[2] == 0.0f) {
                    this.lastResult = fArr2;
                }
                double degrees4 = Math.toDegrees(this.lastResult[0]);
                double degrees5 = Math.toDegrees(this.lastResult[1]);
                double degrees6 = Math.toDegrees(this.lastResult[2]);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastUpdateTime >= 500) {
                    this.mLastUpdateTime = currentTimeMillis;
                    double abs = Math.abs(Math.abs(degrees2) - Math.abs(degrees5));
                    double abs2 = Math.abs(Math.abs(degrees3) - Math.abs(degrees6));
                    double abs3 = Math.abs(Math.abs(degrees) - Math.abs(degrees4));
                    Logger.c("ljx_shake", "角度详细数据：" + degrees5 + "->" + abs + "," + degrees6 + "->" + abs2 + "," + degrees4 + "->" + abs3);
                }
            }
        }
    }

    public void sendToJs() {
        Log.v("drb", "NATIVE_TO_JS sendJs");
        this.bridgeManager.callHandler(LoaderConstants.NATIVE_TO_JS, AppInfo.f().toJson(new CallJsModel(LoaderConstants.SHAKE)), new CallBackFunction() { // from class: com.soft.blued.ui.web.modelloader.fetcher.ShakeFetcher.2
            @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
            public void onCallBack(String str) {
                Log.v("drb", "NATIVE_TO_JS SHAKE onCallBack：" + str);
            }
        });
    }
}
