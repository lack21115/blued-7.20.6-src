package android.hardware;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/SensorEvent.class */
public class SensorEvent {
    public int accuracy;
    public Sensor sensor;
    public long timestamp;
    public final float[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SensorEvent(int i) {
        this.values = new float[i];
    }
}
