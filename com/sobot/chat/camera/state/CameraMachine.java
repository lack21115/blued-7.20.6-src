package com.sobot.chat.camera.state;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.sobot.chat.camera.CameraInterface;
import com.sobot.chat.camera.view.StICameraView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/state/CameraMachine.class */
public class CameraMachine implements State {
    private Context context;
    private StICameraView view;
    private State previewState = new PreviewState(this);
    private State borrowPictureState = new BorrowPictureState(this);
    private State borrowVideoState = new BorrowVideoState(this);
    private State state = this.previewState;

    public CameraMachine(Context context, StICameraView stICameraView, CameraInterface.CameraOpenOverCallback cameraOpenOverCallback) {
        this.context = context;
        this.view = stICameraView;
    }

    @Override // com.sobot.chat.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        this.state.cancle(surfaceHolder, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void capture() {
        this.state.capture();
    }

    @Override // com.sobot.chat.camera.state.State
    public void confirm() {
        this.state.confirm();
    }

    @Override // com.sobot.chat.camera.state.State
    public void flash(String str) {
        this.state.flash(str);
    }

    @Override // com.sobot.chat.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
        this.state.foucs(f, f2, focusCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State getBorrowPictureState() {
        return this.borrowPictureState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State getBorrowVideoState() {
        return this.borrowVideoState;
    }

    public Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State getPreviewState() {
        return this.previewState;
    }

    public State getState() {
        return this.state;
    }

    public StICameraView getView() {
        return this.view;
    }

    @Override // com.sobot.chat.camera.state.State
    public void record(Surface surface, float f) {
        this.state.record(surface, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void restart() {
        this.state.restart();
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override // com.sobot.chat.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        this.state.start(surfaceHolder, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void stop() {
        this.state.stop();
    }

    @Override // com.sobot.chat.camera.state.State
    public void stopRecord(boolean z, long j) {
        this.state.stopRecord(z, j);
    }

    @Override // com.sobot.chat.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
        this.state.swtich(surfaceHolder, f);
    }

    @Override // com.sobot.chat.camera.state.State
    public void zoom(float f, int i) {
        this.state.zoom(f, i);
    }
}
