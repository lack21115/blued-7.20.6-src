package com.sobot.chat.camera.state;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.sobot.chat.camera.CameraInterface;
import com.sobot.chat.camera.util.StCmeraLog;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/state/PreviewState.class */
class PreviewState implements State {
    public static final String TAG = "PreviewState";
    private CameraMachine machine;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.sobot.chat.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        StCmeraLog.i("浏览状态下,没有 cancle 事件");
    }

    @Override // com.sobot.chat.camera.state.State
    public void capture() {
        CameraInterface.getInstance().takePicture(new CameraInterface.TakePictureCallback() { // from class: com.sobot.chat.camera.state.PreviewState.1
            @Override // com.sobot.chat.camera.CameraInterface.TakePictureCallback
            public void captureResult(Bitmap bitmap, boolean z) {
                PreviewState.this.machine.getView().showPicture(bitmap, z);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowPictureState());
                StCmeraLog.i("capture");
            }
        });
    }

    @Override // com.sobot.chat.camera.state.State
    public void confirm() {
        StCmeraLog.i("浏览状态下,没有 confirm 事件");
    }

    @Override // com.sobot.chat.camera.state.State
    public void flash(String str) {
        CameraInterface.getInstance().setFlashMode(str);
    }

    @Override // com.sobot.chat.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
        StCmeraLog.i("preview state foucs");
        if (this.machine.getView().handlerFoucs(f, f2)) {
            CameraInterface.getInstance().handleFocus(this.machine.getContext(), f, f2, focusCallback);
        }
    }

    @Override // com.sobot.chat.camera.state.State
    public void record(Surface surface, float f) {
        CameraInterface.getInstance().startRecord(surface, f, null);
    }

    @Override // com.sobot.chat.camera.state.State
    public void restart() {
    }

    @Override // com.sobot.chat.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void stop() {
        CameraInterface.getInstance().doStopPreview();
    }

    @Override // com.sobot.chat.camera.state.State
    public void stopRecord(final boolean z, long j) {
        CameraInterface.getInstance().stopRecord(z, new CameraInterface.StopRecordCallback() { // from class: com.sobot.chat.camera.state.PreviewState.2
            @Override // com.sobot.chat.camera.CameraInterface.StopRecordCallback
            public void recordResult(String str, Bitmap bitmap) {
                if (z) {
                    PreviewState.this.machine.getView().resetState(3);
                    return;
                }
                PreviewState.this.machine.getView().playVideo(bitmap, str);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowVideoState());
            }
        });
    }

    @Override // com.sobot.chat.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().switchCamera(surfaceHolder, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void zoom(float f, int i) {
        StCmeraLog.i(TAG, "zoom");
        CameraInterface.getInstance().setZoom(f, i);
    }
}
