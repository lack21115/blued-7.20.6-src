package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.p;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoRecorder.class */
public final class PLShortVideoRecorder {
    private p mShortVideoCore = new p();

    public boolean beginSection() {
        return beginSection(null);
    }

    public boolean beginSection(String str) {
        QosManager.a().a(QosManager.KeyPoint.record_section);
        return this.mShortVideoCore.a(str);
    }

    public void cancelConcat() {
        this.mShortVideoCore.o();
    }

    public void captureFrame(PLCaptureFrameListener pLCaptureFrameListener) {
        captureFrame(pLCaptureFrameListener, true);
    }

    public void captureFrame(PLCaptureFrameListener pLCaptureFrameListener, boolean z) {
        this.mShortVideoCore.a(pLCaptureFrameListener, z);
        QosManager.a().a(QosManager.KeyPoint.record_capture_frame);
    }

    public void concatSections(PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoCore.a(pLVideoSaveListener);
    }

    public boolean deleteAllSections() {
        return this.mShortVideoCore.n();
    }

    public boolean deleteLastSection() {
        return this.mShortVideoCore.m();
    }

    public void destroy() {
        destroy(true);
    }

    public void destroy(boolean z) {
        this.mShortVideoCore.b(z);
    }

    public boolean endSection() {
        QosManager.a().a(this.mShortVideoCore.h());
        return this.mShortVideoCore.c();
    }

    public PLBuiltinFilter[] getBuiltinFilterList() {
        return this.mShortVideoCore.u();
    }

    public int getMaxExposureCompensation() {
        return this.mShortVideoCore.y();
    }

    public int getMinExposureCompensation() {
        return this.mShortVideoCore.z();
    }

    public int getMusicPosition() {
        return this.mShortVideoCore.p();
    }

    public List<Float> getZooms() {
        return this.mShortVideoCore.A();
    }

    public boolean isFlashSupport() {
        return this.mShortVideoCore.x();
    }

    public void manualFocus(int i, int i2, int i3, int i4) {
        this.mShortVideoCore.b(i, i2, i3, i4);
        QosManager.a().a(QosManager.KeyPoint.record_focus);
    }

    public void mute(boolean z) {
        this.mShortVideoCore.a(z);
        QosManager.a().a(QosManager.KeyPoint.record_mute);
    }

    public void pause() {
        this.mShortVideoCore.k();
    }

    public void prepare(GLSurfaceView gLSurfaceView, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLFaceBeautySetting pLFaceBeautySetting, PLRecordSetting pLRecordSetting) {
        if (pLRecordSetting.IsRecordSpeedVariable()) {
            pLVideoEncodeSetting.setHWCodecEnabled(true);
        }
        this.mShortVideoCore.a(gLSurfaceView, pLCameraSetting, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, pLFaceBeautySetting, pLRecordSetting);
        QosManager.a().a(QosManager.KeyPoint.record_init);
    }

    public void prepare(GLSurfaceView gLSurfaceView, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        if (pLRecordSetting.IsRecordSpeedVariable()) {
            pLVideoEncodeSetting.setHWCodecEnabled(true);
        }
        this.mShortVideoCore.a(gLSurfaceView, pLCameraSetting, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, null, pLRecordSetting);
        QosManager.a().a(QosManager.KeyPoint.record_init);
        QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
        QosManager.a().a(QosManager.KeyPoint.record_camera_capture);
    }

    public boolean recoverFromDraft(GLSurfaceView gLSurfaceView, PLDraft pLDraft) {
        QosManager.a().a(QosManager.KeyPoint.draftbox);
        return this.mShortVideoCore.a(gLSurfaceView, pLDraft.getDraft());
    }

    public void resume() {
        this.mShortVideoCore.j();
    }

    public boolean saveToDraftBox(String str) {
        QosManager.a().a(QosManager.KeyPoint.draftbox);
        return this.mShortVideoCore.c(str);
    }

    public final void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mShortVideoCore.a(pLAudioFrameListener);
    }

    public void setBuiltinFilter(String str) {
        this.mShortVideoCore.b(str, true);
        QosManager.a().a(QosManager.KeyPoint.record_filter);
    }

    public final void setCameraParamSelectListener(PLCameraParamSelectListener pLCameraParamSelectListener) {
        this.mShortVideoCore.a(pLCameraParamSelectListener);
    }

    public final void setCameraPreviewListener(PLCameraPreviewListener pLCameraPreviewListener) {
        this.mShortVideoCore.a(pLCameraPreviewListener);
        QosManager.a().a(QosManager.KeyPoint.record_preview);
    }

    public void setEffectPlugin(PLEffectPlugin pLEffectPlugin) {
        this.mShortVideoCore.a(pLEffectPlugin);
    }

    public void setExposureCompensation(int i) {
        this.mShortVideoCore.c(i);
        QosManager.a().a(QosManager.KeyPoint.record_exposure);
    }

    public void setExternalFilter(String str) {
        this.mShortVideoCore.b(str, false);
        QosManager.a().a(QosManager.KeyPoint.record_filter);
    }

    public boolean setFlashEnabled(boolean z) {
        QosManager.a().a(QosManager.KeyPoint.record_flash);
        return z ? this.mShortVideoCore.v() : this.mShortVideoCore.w();
    }

    public void setFocusListener(PLFocusListener pLFocusListener) {
        this.mShortVideoCore.a(pLFocusListener);
    }

    public void setMirrorForEncode(boolean z) {
        this.mShortVideoCore.f(z);
        QosManager.a().a(QosManager.KeyPoint.record_mirror);
    }

    public void setMirrorForPreview(boolean z) {
        this.mShortVideoCore.e(z);
        QosManager.a().a(QosManager.KeyPoint.record_mirror);
    }

    public void setMusicAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mShortVideoCore.a(assetFileDescriptor);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicFile(String str) {
        this.mShortVideoCore.b(str);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicPosition(int i) {
        this.mShortVideoCore.a(i);
    }

    public void setRecordSpeed(double d) {
        this.mShortVideoCore.a(d);
        QosManager.a().a(QosManager.KeyPoint.record_speed);
    }

    public final void setRecordStateListener(PLRecordStateListener pLRecordStateListener) {
        this.mShortVideoCore.a(pLRecordStateListener);
    }

    public void setTextureRotation(int i) {
        this.mShortVideoCore.b(i);
    }

    public void setTextureScale(float f, float f2) {
        this.mShortVideoCore.b(f, f2);
    }

    public final void setVideoFilterListener(PLVideoFilterListener pLVideoFilterListener) {
        setVideoFilterListener(pLVideoFilterListener, false);
    }

    public final void setVideoFilterListener(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        this.mShortVideoCore.a(pLVideoFilterListener, z);
        QosManager.a().a(QosManager.KeyPoint.record_custom_effect);
    }

    public void setWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoCore.a(pLWatermarkSetting);
        QosManager.a().a(QosManager.KeyPoint.record_watermark);
    }

    public void setZoom(float f) {
        this.mShortVideoCore.a(f);
        QosManager.a().a(QosManager.KeyPoint.record_zoom);
    }

    public void switchCamera() {
        this.mShortVideoCore.B();
        QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
    }

    public void switchCamera(PLCameraSetting.CAMERA_FACING_ID camera_facing_id) {
        this.mShortVideoCore.a(camera_facing_id);
        QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
    }

    public void updateFaceBeautySetting(PLFaceBeautySetting pLFaceBeautySetting) {
        this.mShortVideoCore.a(pLFaceBeautySetting);
        QosManager.a().a(QosManager.KeyPoint.record_beauty);
    }
}
