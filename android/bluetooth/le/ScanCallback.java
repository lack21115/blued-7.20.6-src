package android.bluetooth.le;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/le/ScanCallback.class */
public abstract class ScanCallback {
    public static final int SCAN_FAILED_ALREADY_STARTED = 1;
    public static final int SCAN_FAILED_APPLICATION_REGISTRATION_FAILED = 2;
    public static final int SCAN_FAILED_FEATURE_UNSUPPORTED = 4;
    public static final int SCAN_FAILED_INTERNAL_ERROR = 3;

    public void onBatchScanResults(List<ScanResult> list) {
    }

    public void onScanFailed(int i) {
    }

    public void onScanResult(int i, ScanResult scanResult) {
    }
}
