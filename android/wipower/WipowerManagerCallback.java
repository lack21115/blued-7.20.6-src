package android.wipower;

import android.wipower.WipowerManager;

/* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerManagerCallback.class */
public interface WipowerManagerCallback {
    void onPowerApply(WipowerManager.PowerApplyEvent powerApplyEvent);

    void onWipowerAlert(byte b);

    void onWipowerData(WipowerDynamicParam wipowerDynamicParam);

    void onWipowerReady();

    void onWipowerStateChange(WipowerManager.WipowerState wipowerState);
}
