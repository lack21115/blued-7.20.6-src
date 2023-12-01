package android.hardware;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/hardware/SensorListener.class */
public interface SensorListener {
    void onAccuracyChanged(int i, int i2);

    void onSensorChanged(int i, float[] fArr);
}
