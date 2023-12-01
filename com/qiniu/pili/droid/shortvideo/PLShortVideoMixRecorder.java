package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.n;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoMixRecorder.class */
public final class PLShortVideoMixRecorder {
    private n mShortVideoMixRecorderCore;

    public PLShortVideoMixRecorder(Context context) {
        this.mShortVideoMixRecorderCore = new n(context);
    }

    public boolean beginSection() {
        return beginSection(null);
    }

    public boolean beginSection(String str) {
        QosManager.a().a(QosManager.KeyPoint.record_video_mix);
        QosManager.a().a(QosManager.KeyPoint.record_section);
        return this.mShortVideoMixRecorderCore.a(str);
    }

    public void cancel() {
        this.mShortVideoMixRecorderCore.b();
    }

    public boolean deleteAllSections() {
        return this.mShortVideoMixRecorderCore.n();
    }

    public boolean deleteLastSection() {
        return this.mShortVideoMixRecorderCore.m();
    }

    public void destroy() {
        destroy(true);
    }

    public void destroy(boolean z) {
        this.mShortVideoMixRecorderCore.b(z);
    }

    public boolean endSection() {
        QosManager.a().a(this.mShortVideoMixRecorderCore.h());
        return this.mShortVideoMixRecorderCore.c();
    }

    public PLAudioMixMode getAudioMixMode() {
        return this.mShortVideoMixRecorderCore.a();
    }

    public PLBuiltinFilter[] getBuiltinFilterList() {
        return this.mShortVideoMixRecorderCore.u();
    }

    public int getMaxExposureCompensation() {
        return this.mShortVideoMixRecorderCore.y();
    }

    public int getMinExposureCompensation() {
        return this.mShortVideoMixRecorderCore.z();
    }

    public List<Float> getZooms() {
        return this.mShortVideoMixRecorderCore.A();
    }

    public boolean isFlashSupport() {
        return this.mShortVideoMixRecorderCore.x();
    }

    public void manualFocus(int i, int i2, int i3, int i4) {
        this.mShortVideoMixRecorderCore.b(i, i2, i3, i4);
        QosManager.a().a(QosManager.KeyPoint.record_focus);
    }

    public void muteMicrophone(boolean z) {
        this.mShortVideoMixRecorderCore.c(z);
    }

    public void muteSampleVideo(boolean z) {
        this.mShortVideoMixRecorderCore.d(z);
    }

    public void pause() {
        this.mShortVideoMixRecorderCore.k();
    }

    public void prepare(GLSurfaceView gLSurfaceView, GLSurfaceView gLSurfaceView2, PLVideoMixSetting pLVideoMixSetting, PLCameraSetting pLCameraSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLFaceBeautySetting pLFaceBeautySetting, PLRecordSetting pLRecordSetting) {
        if (pLRecordSetting.IsRecordSpeedVariable()) {
            pLVideoEncodeSetting.setHWCodecEnabled(true);
        }
        this.mShortVideoMixRecorderCore.a(gLSurfaceView, gLSurfaceView2, pLVideoMixSetting, pLCameraSetting, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, pLFaceBeautySetting, pLRecordSetting);
        QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
        QosManager.a().a(QosManager.KeyPoint.record_camera_capture);
    }

    public void resume() {
        this.mShortVideoMixRecorderCore.j();
    }

    public void save(PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoMixRecorderCore.b(pLVideoSaveListener);
    }

    public final void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mShortVideoMixRecorderCore.a(pLAudioFrameListener);
    }

    public void setAudioMixMode(PLAudioMixMode pLAudioMixMode) {
        this.mShortVideoMixRecorderCore.a(pLAudioMixMode);
    }

    public void setAudioMixVolume(float f, float f2) {
        this.mShortVideoMixRecorderCore.a(f, f2);
    }

    public void setBuiltinFilter(String str) {
        this.mShortVideoMixRecorderCore.b(str, true);
        QosManager.a().a(QosManager.KeyPoint.record_filter);
    }

    public final void setCameraParamSelectListener(PLCameraParamSelectListener pLCameraParamSelectListener) {
        this.mShortVideoMixRecorderCore.a(pLCameraParamSelectListener);
    }

    public final void setCameraPreviewListener(PLCameraPreviewListener pLCameraPreviewListener) {
        this.mShortVideoMixRecorderCore.a(pLCameraPreviewListener);
        QosManager.a().a(QosManager.KeyPoint.record_preview);
    }

    public void setExposureCompensation(int i) {
        this.mShortVideoMixRecorderCore.c(i);
        QosManager.a().a(QosManager.KeyPoint.record_exposure);
    }

    public void setExternalFilter(String str) {
        this.mShortVideoMixRecorderCore.b(str, false);
        QosManager.a().a(QosManager.KeyPoint.record_filter);
    }

    public boolean setFlashEnabled(boolean z) {
        QosManager.a().a(QosManager.KeyPoint.record_flash);
        return z ? this.mShortVideoMixRecorderCore.v() : this.mShortVideoMixRecorderCore.w();
    }

    public void setFocusListener(PLFocusListener pLFocusListener) {
        this.mShortVideoMixRecorderCore.a(pLFocusListener);
    }

    public final void setRecordStateListener(PLRecordStateListener pLRecordStateListener) {
        this.mShortVideoMixRecorderCore.a(pLRecordStateListener);
    }

    public void setTextureRotation(int i) {
        this.mShortVideoMixRecorderCore.b(i);
    }

    public final void setVideoFilterListener(PLVideoFilterListener pLVideoFilterListener) {
        setVideoFilterListener(pLVideoFilterListener, false);
    }

    public final void setVideoFilterListener(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        this.mShortVideoMixRecorderCore.a(pLVideoFilterListener, z);
        QosManager.a().a(QosManager.KeyPoint.record_custom_effect);
    }

    public void setWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoMixRecorderCore.a(pLWatermarkSetting);
        QosManager.a().a(QosManager.KeyPoint.record_watermark);
    }

    public void setZoom(float f) {
        this.mShortVideoMixRecorderCore.a(f);
        QosManager.a().a(QosManager.KeyPoint.record_zoom);
    }

    public void switchCamera() {
        this.mShortVideoMixRecorderCore.B();
        QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
    }

    public void switchCamera(PLCameraSetting.CAMERA_FACING_ID camera_facing_id) {
        this.mShortVideoMixRecorderCore.a(camera_facing_id);
    }

    public void updateFaceBeautySetting(PLFaceBeautySetting pLFaceBeautySetting) {
        this.mShortVideoMixRecorderCore.a(pLFaceBeautySetting);
        QosManager.a().a(QosManager.KeyPoint.record_beauty);
    }
}
