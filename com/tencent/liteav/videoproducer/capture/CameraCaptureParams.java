package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;
import java.util.Objects;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CameraCaptureParams.class */
public class CameraCaptureParams extends CaptureSourceInterface.CaptureParams {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f36842a;

    public CameraCaptureParams() {
        this.f36842a = null;
    }

    public CameraCaptureParams(CameraCaptureParams cameraCaptureParams) {
        super(cameraCaptureParams);
        this.f36842a = null;
        this.f36842a = cameraCaptureParams.f36842a;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    public boolean equals(Object obj) {
        if (obj instanceof CameraCaptureParams) {
            CameraCaptureParams cameraCaptureParams = (CameraCaptureParams) obj;
            return super.equals(cameraCaptureParams) && Objects.equals(this.f36842a, cameraCaptureParams.f36842a);
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    public String toString() {
        return String.format(Locale.ENGLISH, "%s, frontCamera: %b", super.toString(), this.f36842a);
    }
}
