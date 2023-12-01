package com.blued.android.module.player.audio;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/audio/IAudioPlayer.class */
public interface IAudioPlayer {

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/audio/IAudioPlayer$OnCompletionListener.class */
    public interface OnCompletionListener {
        void a(IAudioPlayer iAudioPlayer);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/audio/IAudioPlayer$OnErrorListener.class */
    public interface OnErrorListener {
        boolean a(IAudioPlayer iAudioPlayer, int i, int i2);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/audio/IAudioPlayer$OnPreparedListener.class */
    public interface OnPreparedListener {
        void a(IAudioPlayer iAudioPlayer);
    }

    IAudioPlayer a();

    IAudioPlayer a(String str);

    IAudioPlayer a(boolean z);

    void b();
}
