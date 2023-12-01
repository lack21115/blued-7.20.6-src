package com.zego.zegoavkit2.audioplayer;

import android.net.Uri;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioplayer/ZegoAudioPlayer.class */
public class ZegoAudioPlayer {
    public ZegoAudioPlayer() {
        ZegoAudioPlayerJNI.createAudioPlayer();
    }

    public void destroyAudioPlayer() {
        ZegoAudioPlayerJNI.destroyAudioPlayer();
    }

    public long getCurrentDuration(int i) {
        return ZegoAudioPlayerJNI.getCurrentDuration(i);
    }

    public long getDuration(int i) {
        return ZegoAudioPlayerJNI.getDuration(i);
    }

    public void pauseAll() {
        ZegoAudioPlayerJNI.pauseAll();
    }

    public void pauseEffect(int i) {
        ZegoAudioPlayerJNI.pauseEffect(i);
    }

    public void playEffect(Uri uri, int i, int i2, boolean z) {
        ZegoAudioPlayerJNI.playEffect(uri != null ? uri.toString() : "", i, i2, z);
    }

    public void playEffect(String str, int i, int i2, boolean z) {
        ZegoAudioPlayerJNI.playEffect(str, i, i2, z);
    }

    public void preloadEffect(Uri uri, int i) {
        ZegoAudioPlayerJNI.preloadEffect(uri != null ? uri.toString() : "", i);
    }

    public void preloadEffect(String str, int i) {
        ZegoAudioPlayerJNI.preloadEffect(str, i);
    }

    public void resumeAll() {
        ZegoAudioPlayerJNI.resumeAll();
    }

    public void resumeEffect(int i) {
        ZegoAudioPlayerJNI.resumeEffect(i);
    }

    public int seekTo(int i, long j) {
        return ZegoAudioPlayerJNI.seekTo(i, j);
    }

    public void setCallback(IZegoAudioPlayerCallback iZegoAudioPlayerCallback) {
        ZegoAudioPlayerJNI.setCallback(iZegoAudioPlayerCallback);
    }

    public void setPlaySpeed(int i, float f) {
        ZegoAudioPlayerJNI.setPlaySpeed(i, f);
    }

    public void setVolume(int i, int i2) {
        ZegoAudioPlayerJNI.setVolume(i, i2);
    }

    public void setVolumeAll(int i) {
        ZegoAudioPlayerJNI.setVolumeAll(i);
    }

    public void stopAll() {
        ZegoAudioPlayerJNI.stopAll();
    }

    public void stopEffect(int i) {
        ZegoAudioPlayerJNI.stopEffect(i);
    }

    public void unloadEffect(int i) {
        ZegoAudioPlayerJNI.unloadEffect(i);
    }
}
