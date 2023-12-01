package android.view;

import android.content.Context;
import android.hardware.SensorListener;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/view/OrientationListener.class */
public abstract class OrientationListener implements SensorListener {
    public static final int ORIENTATION_UNKNOWN = -1;
    private OrientationEventListener mOrientationEventLis;

    /* loaded from: source-9557208-dex2jar.jar:android/view/OrientationListener$OrientationEventListenerInternal.class */
    class OrientationEventListenerInternal extends OrientationEventListener {
        OrientationEventListenerInternal(Context context) {
            super(context);
        }

        OrientationEventListenerInternal(Context context, int i) {
            super(context, i);
            registerListener(OrientationListener.this);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            OrientationListener.this.onOrientationChanged(i);
        }
    }

    public OrientationListener(Context context) {
        this.mOrientationEventLis = new OrientationEventListenerInternal(context);
    }

    public OrientationListener(Context context, int i) {
        this.mOrientationEventLis = new OrientationEventListenerInternal(context, i);
    }

    public void disable() {
        this.mOrientationEventLis.disable();
    }

    public void enable() {
        this.mOrientationEventLis.enable();
    }

    @Override // android.hardware.SensorListener
    public void onAccuracyChanged(int i, int i2) {
    }

    public abstract void onOrientationChanged(int i);

    @Override // android.hardware.SensorListener
    public void onSensorChanged(int i, float[] fArr) {
    }
}
