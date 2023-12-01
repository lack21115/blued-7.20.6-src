package android.hardware.camera2;

import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.impl.CaptureResultExtras;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/TotalCaptureResult.class */
public final class TotalCaptureResult extends CaptureResult {
    private final List<CaptureResult> mPartialResults;

    public TotalCaptureResult(CameraMetadataNative cameraMetadataNative, int i) {
        super(cameraMetadataNative, i);
        this.mPartialResults = new ArrayList();
    }

    public TotalCaptureResult(CameraMetadataNative cameraMetadataNative, CaptureRequest captureRequest, CaptureResultExtras captureResultExtras, List<CaptureResult> list) {
        super(cameraMetadataNative, captureRequest, captureResultExtras);
        if (list == null) {
            this.mPartialResults = new ArrayList();
        } else {
            this.mPartialResults = list;
        }
    }

    public List<CaptureResult> getPartialResults() {
        return Collections.unmodifiableList(this.mPartialResults);
    }
}
