package android.hardware.camera2.legacy;

import android.hardware.Camera;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.utils.ParamsUtils;
import android.util.Log;
import com.android.internal.util.Preconditions;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyFocusStateMapper.class */
public class LegacyFocusStateMapper {
    private static String TAG = "LegacyFocusStateMapper";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private final Camera mCamera;
    private int mAfStatePrevious = 0;
    private String mAfModePrevious = null;
    private final Object mLock = new Object();
    private int mAfRun = 0;
    private int mAfState = 0;

    public LegacyFocusStateMapper(Camera camera) {
        this.mCamera = (Camera) Preconditions.checkNotNull(camera, "camera must not be null");
    }

    private static String afStateToString(int i) {
        switch (i) {
            case 0:
                return "INACTIVE";
            case 1:
                return "PASSIVE_SCAN";
            case 2:
                return "PASSIVE_FOCUSED";
            case 3:
                return "ACTIVE_SCAN";
            case 4:
                return "FOCUSED_LOCKED";
            case 5:
                return "NOT_FOCUSED_LOCKED";
            case 6:
                return "PASSIVE_UNFOCUSED";
            default:
                return "UNKNOWN(" + i + ")";
        }
    }

    public void mapResultTriggers(CameraMetadataNative cameraMetadataNative) {
        int i;
        Preconditions.checkNotNull(cameraMetadataNative, "result must not be null");
        synchronized (this.mLock) {
            i = this.mAfState;
        }
        if (VERBOSE && i != this.mAfStatePrevious) {
            Log.v(TAG, String.format("mapResultTriggers - afState changed from %s to %s", afStateToString(this.mAfStatePrevious), afStateToString(i)));
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AF_STATE, (CaptureResult.Key<Integer>) Integer.valueOf(i));
        this.mAfStatePrevious = i;
    }

    public void processRequestTriggers(CaptureRequest captureRequest, Camera.Parameters parameters) {
        final int i;
        int i2;
        int i3;
        final int i4;
        Preconditions.checkNotNull(captureRequest, "captureRequest must not be null");
        int intValue = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_AF_TRIGGER, 0)).intValue();
        final String focusMode = parameters.getFocusMode();
        if (!Objects.equals(this.mAfModePrevious, focusMode)) {
            if (VERBOSE) {
                Log.v(TAG, "processRequestTriggers - AF mode switched from " + this.mAfModePrevious + " to " + focusMode);
            }
            synchronized (this.mLock) {
                this.mAfRun++;
                this.mAfState = 0;
            }
            this.mCamera.cancelAutoFocus();
        }
        this.mAfModePrevious = focusMode;
        synchronized (this.mLock) {
            i = this.mAfRun;
        }
        Camera.AutoFocusMoveCallback autoFocusMoveCallback = new Camera.AutoFocusMoveCallback() { // from class: android.hardware.camera2.legacy.LegacyFocusStateMapper.1
            @Override // android.hardware.Camera.AutoFocusMoveCallback
            public void onAutoFocusMoving(boolean z, Camera camera) {
                synchronized (LegacyFocusStateMapper.this.mLock) {
                    int i5 = LegacyFocusStateMapper.this.mAfRun;
                    if (LegacyFocusStateMapper.VERBOSE) {
                        Log.v(LegacyFocusStateMapper.TAG, "onAutoFocusMoving - start " + z + " latest AF run " + i5 + ", last AF run " + i);
                    }
                    if (i != i5) {
                        Log.d(LegacyFocusStateMapper.TAG, "onAutoFocusMoving - ignoring move callbacks from old af run" + i);
                        return;
                    }
                    int i6 = z ? 1 : 2;
                    String str = focusMode;
                    boolean z2 = true;
                    switch (str.hashCode()) {
                        case -194628547:
                            if (str.equals("continuous-video")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 910005312:
                            if (str.equals("continuous-picture")) {
                                z2 = false;
                                break;
                            }
                            break;
                    }
                    switch (z2) {
                        case false:
                        case true:
                            break;
                        default:
                            Log.w(LegacyFocusStateMapper.TAG, "onAutoFocus - got unexpected onAutoFocus in mode " + focusMode);
                            break;
                    }
                    LegacyFocusStateMapper.this.mAfState = i6;
                }
            }
        };
        boolean z = true;
        switch (focusMode.hashCode()) {
            case -194628547:
                if (focusMode.equals("continuous-video")) {
                    z = true;
                    break;
                }
                break;
            case 3005871:
                if (focusMode.equals("auto")) {
                    z = false;
                    break;
                }
                break;
            case 103652300:
                if (focusMode.equals(Camera.Parameters.FOCUS_MODE_MACRO)) {
                    z = true;
                    break;
                }
                break;
            case 910005312:
                if (focusMode.equals("continuous-picture")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
                this.mCamera.setAutoFocusMoveCallback(autoFocusMoveCallback);
                break;
        }
        switch (intValue) {
            case 0:
                return;
            case 1:
                boolean z2 = true;
                switch (focusMode.hashCode()) {
                    case -194628547:
                        if (focusMode.equals("continuous-video")) {
                            z2 = true;
                            break;
                        }
                        break;
                    case 3005871:
                        if (focusMode.equals("auto")) {
                            z2 = false;
                            break;
                        }
                        break;
                    case 103652300:
                        if (focusMode.equals(Camera.Parameters.FOCUS_MODE_MACRO)) {
                            z2 = true;
                            break;
                        }
                        break;
                    case 910005312:
                        if (focusMode.equals("continuous-picture")) {
                            z2 = true;
                            break;
                        }
                        break;
                }
                switch (z2) {
                    case false:
                    case true:
                        i3 = 3;
                        break;
                    case true:
                    case true:
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                synchronized (this.mLock) {
                    i4 = this.mAfRun + 1;
                    this.mAfRun = i4;
                    this.mAfState = i3;
                }
                if (VERBOSE) {
                    Log.v(TAG, "processRequestTriggers - got AF_TRIGGER_START, new AF run is " + i4);
                }
                if (i3 != 0) {
                    this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: android.hardware.camera2.legacy.LegacyFocusStateMapper.2
                        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // android.hardware.Camera.AutoFocusCallback
                        public void onAutoFocus(boolean z3, Camera camera) {
                            boolean z4 = false;
                            synchronized (LegacyFocusStateMapper.this.mLock) {
                                int i5 = LegacyFocusStateMapper.this.mAfRun;
                                if (LegacyFocusStateMapper.VERBOSE) {
                                    Log.v(LegacyFocusStateMapper.TAG, "onAutoFocus - success " + z3 + " latest AF run " + i5 + ", last AF run " + i4);
                                }
                                if (i5 != i4) {
                                    Log.d(LegacyFocusStateMapper.TAG, String.format("onAutoFocus - ignoring AF callback (old run %d, new run %d)", Integer.valueOf(i4), Integer.valueOf(i5)));
                                    return;
                                }
                                int i6 = z3 ? 4 : 5;
                                String str = focusMode;
                                switch (str.hashCode()) {
                                    case -194628547:
                                        if (str.equals("continuous-video")) {
                                            z4 = true;
                                            break;
                                        }
                                        z4 = true;
                                        break;
                                    case 3005871:
                                        if (str.equals("auto")) {
                                            break;
                                        }
                                        z4 = true;
                                        break;
                                    case 103652300:
                                        if (str.equals(Camera.Parameters.FOCUS_MODE_MACRO)) {
                                            z4 = true;
                                            break;
                                        }
                                        z4 = true;
                                        break;
                                    case 910005312:
                                        if (str.equals("continuous-picture")) {
                                            z4 = true;
                                            break;
                                        }
                                        z4 = true;
                                        break;
                                    default:
                                        z4 = true;
                                        break;
                                }
                                switch (z4) {
                                    case false:
                                    case true:
                                    case true:
                                    case true:
                                        break;
                                    default:
                                        Log.w(LegacyFocusStateMapper.TAG, "onAutoFocus - got unexpected onAutoFocus in mode " + focusMode);
                                        break;
                                }
                                LegacyFocusStateMapper.this.mAfState = i6;
                            }
                        }
                    });
                    return;
                }
                return;
            case 2:
                synchronized (this.mLock) {
                    synchronized (this.mLock) {
                        i2 = this.mAfRun + 1;
                        this.mAfRun = i2;
                        this.mAfState = 0;
                    }
                    this.mCamera.cancelAutoFocus();
                    if (VERBOSE) {
                        Log.v(TAG, "processRequestTriggers - got AF_TRIGGER_CANCEL, new AF run is " + i2);
                    }
                }
                return;
            default:
                Log.w(TAG, "processRequestTriggers - ignoring unknown control.afTrigger = " + intValue);
                return;
        }
    }
}
