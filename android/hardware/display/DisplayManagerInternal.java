package android.hardware.display;

import android.hardware.SensorManager;
import android.os.Handler;
import android.view.Display;
import android.view.DisplayInfo;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerInternal.class */
public abstract class DisplayManagerInternal {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerInternal$DisplayPowerCallbacks.class */
    public interface DisplayPowerCallbacks {
        void acquireSuspendBlocker();

        void onDisplayStateChange(int i);

        void onProximityNegative();

        void onProximityPositive();

        void onStateChanged();

        void releaseSuspendBlocker();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerInternal$DisplayPowerRequest.class */
    public static final class DisplayPowerRequest {
        public static final int POLICY_BRIGHT = 3;
        public static final int POLICY_DIM = 2;
        public static final int POLICY_DOZE = 1;
        public static final int POLICY_OFF = 0;
        public boolean blockScreenOn;
        public boolean boostScreenBrightness;
        public int dozeScreenBrightness;
        public int dozeScreenState;
        public boolean lowPowerMode;
        public int policy;
        public float screenAutoBrightnessAdjustment;
        public int screenBrightness;
        public boolean useAutoBrightness;
        public boolean useProximitySensor;

        public DisplayPowerRequest() {
            this.policy = 3;
            this.useProximitySensor = false;
            this.screenBrightness = 255;
            this.screenAutoBrightnessAdjustment = 0.0f;
            this.useAutoBrightness = false;
            this.blockScreenOn = false;
            this.dozeScreenBrightness = -1;
            this.dozeScreenState = 0;
        }

        public DisplayPowerRequest(DisplayPowerRequest displayPowerRequest) {
            copyFrom(displayPowerRequest);
        }

        public static String policyToString(int i) {
            switch (i) {
                case 0:
                    return "OFF";
                case 1:
                    return "DOZE";
                case 2:
                    return "DIM";
                case 3:
                    return "BRIGHT";
                default:
                    return Integer.toString(i);
            }
        }

        public void copyFrom(DisplayPowerRequest displayPowerRequest) {
            this.policy = displayPowerRequest.policy;
            this.useProximitySensor = displayPowerRequest.useProximitySensor;
            this.screenBrightness = displayPowerRequest.screenBrightness;
            this.screenAutoBrightnessAdjustment = displayPowerRequest.screenAutoBrightnessAdjustment;
            this.useAutoBrightness = displayPowerRequest.useAutoBrightness;
            this.blockScreenOn = displayPowerRequest.blockScreenOn;
            this.lowPowerMode = displayPowerRequest.lowPowerMode;
            this.boostScreenBrightness = displayPowerRequest.boostScreenBrightness;
            this.dozeScreenBrightness = displayPowerRequest.dozeScreenBrightness;
            this.dozeScreenState = displayPowerRequest.dozeScreenState;
        }

        public boolean equals(DisplayPowerRequest displayPowerRequest) {
            return displayPowerRequest != null && this.policy == displayPowerRequest.policy && this.useProximitySensor == displayPowerRequest.useProximitySensor && this.screenBrightness == displayPowerRequest.screenBrightness && this.screenAutoBrightnessAdjustment == displayPowerRequest.screenAutoBrightnessAdjustment && this.useAutoBrightness == displayPowerRequest.useAutoBrightness && this.blockScreenOn == displayPowerRequest.blockScreenOn && this.lowPowerMode == displayPowerRequest.lowPowerMode && this.boostScreenBrightness == displayPowerRequest.boostScreenBrightness && this.dozeScreenBrightness == displayPowerRequest.dozeScreenBrightness && this.dozeScreenState == displayPowerRequest.dozeScreenState;
        }

        public boolean equals(Object obj) {
            return (obj instanceof DisplayPowerRequest) && equals((DisplayPowerRequest) obj);
        }

        public int hashCode() {
            return 0;
        }

        public boolean isBrightOrDim() {
            return this.policy == 3 || this.policy == 2;
        }

        public String toString() {
            return "policy=" + policyToString(this.policy) + ", useProximitySensor=" + this.useProximitySensor + ", screenBrightness=" + this.screenBrightness + ", screenAutoBrightnessAdjustment=" + this.screenAutoBrightnessAdjustment + ", useAutoBrightness=" + this.useAutoBrightness + ", blockScreenOn=" + this.blockScreenOn + ", lowPowerMode=" + this.lowPowerMode + ", boostScreenBrightness=" + this.boostScreenBrightness + ", dozeScreenBrightness=" + this.dozeScreenBrightness + ", dozeScreenState=" + Display.stateToString(this.dozeScreenState);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManagerInternal$DisplayTransactionListener.class */
    public interface DisplayTransactionListener {
        void onDisplayTransaction();
    }

    public abstract DisplayInfo getDisplayInfo(int i);

    public abstract void initPowerManagement(DisplayPowerCallbacks displayPowerCallbacks, Handler handler, SensorManager sensorManager);

    public abstract boolean isProximitySensorAvailable();

    public abstract void performTraversalInTransactionFromWindowManager();

    public abstract void registerDisplayTransactionListener(DisplayTransactionListener displayTransactionListener);

    public abstract boolean requestPowerState(DisplayPowerRequest displayPowerRequest, boolean z);

    public abstract void setDisplayInfoOverrideFromWindowManager(int i, DisplayInfo displayInfo);

    public abstract void setDisplayProperties(int i, boolean z, float f, boolean z2);

    public abstract void unregisterDisplayTransactionListener(DisplayTransactionListener displayTransactionListener);
}
