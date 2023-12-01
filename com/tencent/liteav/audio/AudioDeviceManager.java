package com.tencent.liteav.audio;

import android.media.AudioManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/AudioDeviceManager.class */
public class AudioDeviceManager {
    private static final String TAG = "AudioDeviceManager";
    private AudioManager mAudioManager;

    private AudioManager getAudioManager() {
        AudioManager audioManager;
        synchronized (this) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
            }
            audioManager = this.mAudioManager;
        }
        return audioManager;
    }

    private int getAudioMode() {
        try {
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                return audioManager.getMode();
            }
            return -1;
        } catch (Exception e) {
            Log.i(TAG, "Exception occurs in getAudioMode " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    private int getSystemVolume() {
        try {
            int i = getAudioMode() == 0 ? 3 : 0;
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                return audioManager.getStreamVolume(i);
            }
            return -1;
        } catch (Exception e) {
            Log.i(TAG, "Exception occurs in getSystemVolume " + e.getMessage(), new Object[0]);
            return -1;
        }
    }
}
