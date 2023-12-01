package android.hardware.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.dispatch.Dispatchable;
import android.hardware.camera2.dispatch.MethodNameInvoker;
import android.hardware.camera2.impl.CameraDeviceImpl;
import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CallbackProxies.class */
public class CallbackProxies {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CallbackProxies$DeviceCaptureCallbackProxy.class */
    public static class DeviceCaptureCallbackProxy extends CameraDeviceImpl.CaptureCallback {
        private final MethodNameInvoker<CameraDeviceImpl.CaptureCallback> mProxy;

        public DeviceCaptureCallbackProxy(Dispatchable<CameraDeviceImpl.CaptureCallback> dispatchable) {
            this.mProxy = new MethodNameInvoker<>((Dispatchable) Preconditions.checkNotNull(dispatchable, "dispatchTarget must not be null"), CameraDeviceImpl.CaptureCallback.class);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureCompleted(CameraDevice cameraDevice, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.mProxy.invoke("onCaptureCompleted", cameraDevice, captureRequest, totalCaptureResult);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureFailed(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.mProxy.invoke("onCaptureFailed", cameraDevice, captureRequest, captureFailure);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCapturePartial(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.mProxy.invoke("onCapturePartial", cameraDevice, captureRequest, captureResult);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureProgressed(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.mProxy.invoke("onCaptureProgressed", cameraDevice, captureRequest, captureResult);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureSequenceAborted(CameraDevice cameraDevice, int i) {
            this.mProxy.invoke("onCaptureSequenceAborted", cameraDevice, Integer.valueOf(i));
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureSequenceCompleted(CameraDevice cameraDevice, int i, long j) {
            this.mProxy.invoke("onCaptureSequenceCompleted", cameraDevice, Integer.valueOf(i), Long.valueOf(j));
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
        public void onCaptureStarted(CameraDevice cameraDevice, CaptureRequest captureRequest, long j, long j2) {
            this.mProxy.invoke("onCaptureStarted", cameraDevice, captureRequest, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CallbackProxies$DeviceStateCallbackProxy.class */
    public static class DeviceStateCallbackProxy extends CameraDeviceImpl.StateCallbackKK {
        private final MethodNameInvoker<CameraDeviceImpl.StateCallbackKK> mProxy;

        public DeviceStateCallbackProxy(Dispatchable<CameraDeviceImpl.StateCallbackKK> dispatchable) {
            this.mProxy = new MethodNameInvoker<>((Dispatchable) Preconditions.checkNotNull(dispatchable, "dispatchTarget must not be null"), CameraDeviceImpl.StateCallbackKK.class);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
        public void onActive(CameraDevice cameraDevice) {
            this.mProxy.invoke("onActive", cameraDevice);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
        public void onBusy(CameraDevice cameraDevice) {
            this.mProxy.invoke("onBusy", cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            this.mProxy.invoke("onClosed", cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            this.mProxy.invoke("onDisconnected", cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            this.mProxy.invoke("onError", cameraDevice, Integer.valueOf(i));
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
        public void onIdle(CameraDevice cameraDevice) {
            this.mProxy.invoke("onIdle", cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            this.mProxy.invoke("onOpened", cameraDevice);
        }

        @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
        public void onUnconfigured(CameraDevice cameraDevice) {
            this.mProxy.invoke("onUnconfigured", cameraDevice);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CallbackProxies$SessionStateCallbackProxy.class */
    public static class SessionStateCallbackProxy extends CameraCaptureSession.StateCallback {
        private final MethodNameInvoker<CameraCaptureSession.StateCallback> mProxy;

        public SessionStateCallbackProxy(Dispatchable<CameraCaptureSession.StateCallback> dispatchable) {
            this.mProxy = new MethodNameInvoker<>((Dispatchable) Preconditions.checkNotNull(dispatchable, "dispatchTarget must not be null"), CameraCaptureSession.StateCallback.class);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession cameraCaptureSession) {
            this.mProxy.invoke("onActive", cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            this.mProxy.invoke("onClosed", cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            this.mProxy.invoke("onConfigureFailed", cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            this.mProxy.invoke("onConfigured", cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession cameraCaptureSession) {
            this.mProxy.invoke("onReady", cameraCaptureSession);
        }
    }

    private CallbackProxies() {
        throw new AssertionError();
    }
}
