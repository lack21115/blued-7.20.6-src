package android.hardware;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/SensorEventListener.class */
public interface SensorEventListener {
    void onAccuracyChanged(Sensor sensor, int i);

    void onSensorChanged(SensorEvent sensorEvent);
}
