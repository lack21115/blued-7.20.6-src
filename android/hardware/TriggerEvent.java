package android.hardware;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/TriggerEvent.class */
public final class TriggerEvent {
    public Sensor sensor;
    public long timestamp;
    public final float[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TriggerEvent(int i) {
        this.values = new float[i];
    }
}
