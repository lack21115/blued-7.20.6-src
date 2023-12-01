package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.opengl.GLSurfaceView;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.m;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoEditor.class */
public class PLShortVideoEditor {
    private PLVideoEditSetting mEditSetting;
    private m mShortVideoEditorCore;

    public PLShortVideoEditor(GLSurfaceView gLSurfaceView) {
        this.mShortVideoEditorCore = new m(gLSurfaceView);
        QosManager.a().a(QosManager.KeyPoint.editor_init);
    }

    public PLShortVideoEditor(GLSurfaceView gLSurfaceView, PLVideoEditSetting pLVideoEditSetting) {
        this.mEditSetting = pLVideoEditSetting;
        this.mShortVideoEditorCore = new m(gLSurfaceView, pLVideoEditSetting);
        QosManager.a().a(QosManager.KeyPoint.editor_init);
    }

    public void addGifWatermark(PLGifWatermarkSetting pLGifWatermarkSetting) {
        this.mShortVideoEditorCore.a(pLGifWatermarkSetting);
        QosManager.a().a(QosManager.KeyPoint.edit_image);
    }

    public void addImageView(PLImageView pLImageView) {
        this.mShortVideoEditorCore.a(pLImageView);
        QosManager.a().a(QosManager.KeyPoint.edit_image);
    }

    public void addMixAudioFile(PLMixAudioFile pLMixAudioFile) {
        this.mShortVideoEditorCore.b(pLMixAudioFile);
        QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
    }

    public void addPaintView(PLPaintView pLPaintView) {
        this.mShortVideoEditorCore.a(pLPaintView);
        QosManager.a().a(QosManager.KeyPoint.edit_paint);
    }

    public void addTextView(PLTextView pLTextView) {
        this.mShortVideoEditorCore.a(pLTextView);
        QosManager.a().a(QosManager.KeyPoint.edit_text);
    }

    public void cancelSave() {
        this.mShortVideoEditorCore.h();
    }

    public int getAudioMixFileDuration() {
        return this.mShortVideoEditorCore.f();
    }

    public PLBuiltinFilter[] getBuiltinFilterList() {
        return this.mShortVideoEditorCore.e();
    }

    public int getCurrentPosition() {
        return this.mShortVideoEditorCore.b();
    }

    public long getDurationMs() {
        PLVideoEditSetting pLVideoEditSetting = this.mEditSetting;
        if (pLVideoEditSetting != null) {
            return g.a((Object) pLVideoEditSetting.getSourceFilepath());
        }
        return -1L;
    }

    public void muteOriginAudio(boolean z) {
        this.mShortVideoEditorCore.c(z);
    }

    public void pausePlayback() {
        this.mShortVideoEditorCore.c();
    }

    public void removeGifWatermark(PLGifWatermarkSetting pLGifWatermarkSetting) {
        this.mShortVideoEditorCore.b(pLGifWatermarkSetting);
    }

    public void removeImageView(PLImageView pLImageView) {
        this.mShortVideoEditorCore.b(pLImageView);
    }

    public void removeMixAudioFile(PLMixAudioFile pLMixAudioFile) {
        this.mShortVideoEditorCore.a(pLMixAudioFile);
    }

    public void removePaintView(PLPaintView pLPaintView) {
        this.mShortVideoEditorCore.b(pLPaintView);
    }

    public void removeTextView(PLTextView pLTextView) {
        this.mShortVideoEditorCore.b(pLTextView);
    }

    public void resumePlayback() {
        this.mShortVideoEditorCore.a();
    }

    public void save() {
        save(null);
    }

    public void save(PLVideoFilterListener pLVideoFilterListener) {
        save(pLVideoFilterListener, false);
    }

    public void save(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        QosManager.a().a(this.mShortVideoEditorCore.i());
        this.mShortVideoEditorCore.b(pLVideoFilterListener, z);
    }

    public void seekTo(int i) {
        this.mShortVideoEditorCore.a(i);
    }

    public void setAudioMixAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mShortVideoEditorCore.a(assetFileDescriptor);
        QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
    }

    public void setAudioMixFile(String str) {
        this.mShortVideoEditorCore.a(str);
        QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
    }

    public void setAudioMixFileRange(long j, long j2) {
        this.mShortVideoEditorCore.b(j, j2);
    }

    public void setAudioMixLooping(boolean z) {
        this.mShortVideoEditorCore.b(z);
    }

    public void setAudioMixVolume(float f, float f2) {
        this.mShortVideoEditorCore.a(f, f2);
    }

    public void setBuiltinFilter(String str) {
        this.mShortVideoEditorCore.a(str, true);
        QosManager.a().a(QosManager.KeyPoint.edit_filter);
    }

    public void setDisplayMode(PLDisplayMode pLDisplayMode) {
        this.mShortVideoEditorCore.a(pLDisplayMode);
    }

    public void setEffectPlugin(PLEffectPlugin pLEffectPlugin) {
        this.mShortVideoEditorCore.a(pLEffectPlugin);
    }

    public void setExternalFilter(String str) {
        this.mShortVideoEditorCore.a(str, false);
        QosManager.a().a(QosManager.KeyPoint.edit_filter);
    }

    public void setMVEffect(String str, String str2) {
        this.mShortVideoEditorCore.a(str, str2);
        QosManager.a().a(QosManager.KeyPoint.edit_mv);
    }

    public void setPlaybackLoop(boolean z) {
        this.mShortVideoEditorCore.a(z);
    }

    public void setRotation(int i) {
        this.mShortVideoEditorCore.b(i);
        QosManager.a().a(QosManager.KeyPoint.edit_rotate);
    }

    public void setSpeed(double d) {
        this.mShortVideoEditorCore.a(d);
        QosManager.a().a(QosManager.KeyPoint.edit_speed);
    }

    public void setSpeed(double d, boolean z) {
        this.mShortVideoEditorCore.a(d, z);
        QosManager.a().a(QosManager.KeyPoint.edit_speed);
    }

    public void setSpeedTimeRanges(List<PLSpeedTimeRange> list) {
        this.mShortVideoEditorCore.a(list);
        QosManager.a().a(QosManager.KeyPoint.edit_speed);
    }

    public void setVideoEditSetting(PLVideoEditSetting pLVideoEditSetting) {
        this.mEditSetting = pLVideoEditSetting;
        this.mShortVideoEditorCore.a(pLVideoEditSetting);
    }

    public void setVideoEncodeSetting(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.mShortVideoEditorCore.a(pLVideoEncodeSetting);
    }

    public void setVideoPlayerListener(PLVideoPlayerListener pLVideoPlayerListener) {
        this.mShortVideoEditorCore.a(pLVideoPlayerListener);
    }

    public void setVideoRange(long j, long j2) {
        this.mShortVideoEditorCore.a(j, j2);
    }

    public void setVideoSaveListener(PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoEditorCore.a(pLVideoSaveListener);
    }

    public void setViewTimeline(View view, long j, long j2) {
        this.mShortVideoEditorCore.a(view, j, j2);
    }

    public void setWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoEditorCore.a(pLWatermarkSetting);
        QosManager.a().a(QosManager.KeyPoint.edit_watermark);
    }

    public void startPlayback() {
        startPlayback(null);
    }

    public void startPlayback(PLVideoFilterListener pLVideoFilterListener) {
        startPlayback(pLVideoFilterListener, false);
    }

    public void startPlayback(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        this.mShortVideoEditorCore.a(pLVideoFilterListener, z);
        QosManager.a().a(QosManager.KeyPoint.edit_preview);
    }

    public void stopPlayback() {
        this.mShortVideoEditorCore.d();
    }

    public void updateGifWatermark(PLGifWatermarkSetting pLGifWatermarkSetting) {
        this.mShortVideoEditorCore.c(pLGifWatermarkSetting);
    }

    public void updatePreviewWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoEditorCore.c(pLWatermarkSetting);
    }

    public void updateSaveWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoEditorCore.b(pLWatermarkSetting);
    }
}
