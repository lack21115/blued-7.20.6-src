package android.hardware.camera2.impl;

import android.hardware.camera2.impl.CameraMetadataNative;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/GetCommand.class */
public interface GetCommand {
    <T> T getValue(CameraMetadataNative cameraMetadataNative, CameraMetadataNative.Key<T> key);
}
