package com.sobot.chat.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.sobot.chat.camera.CameraInterface;
import com.sobot.chat.camera.util.StCmeraLog;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/state/BorrowPictureState.class */
public class BorrowPictureState implements State {
    private final String TAG = "BorrowPictureState";
    private CameraMachine machine;

    public BorrowPictureState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.sobot.chat.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
        this.machine.getView().resetState(1);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.sobot.chat.camera.state.State
    public void capture() {
    }

    @Override // com.sobot.chat.camera.state.State
    public void confirm() {
        this.machine.getView().confirmState(1);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.sobot.chat.camera.state.State
    public void flash(String str) {
    }

    @Override // com.sobot.chat.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
    }

    @Override // com.sobot.chat.camera.state.State
    public void record(Surface surface, float f) {
    }

    @Override // com.sobot.chat.camera.state.State
    public void restart() {
    }

    @Override // com.sobot.chat.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.sobot.chat.camera.state.State
    public void stop() {
    }

    @Override // com.sobot.chat.camera.state.State
    public void stopRecord(boolean z, long j) {
    }

    @Override // com.sobot.chat.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
    }

    @Override // com.sobot.chat.camera.state.State
    public void zoom(float f, int i) {
        StCmeraLog.i("BorrowPictureState", "zoom");
    }
}
