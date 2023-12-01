package com.kwad.sdk.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/h.class */
public final class h {
    private AudioManager ani;
    private AudioManager.OnAudioFocusChangeListener azi = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (h.this.gV == null) {
                return;
            }
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        h.this.gV.onAudioBeOccupied();
                    } else {
                        h.this.gV.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a gV;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/h$a.class */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.ani = (AudioManager) context.getSystemService("audio");
    }

    private AudioFocusRequest CR() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.azi).build();
    }

    public final boolean CQ() {
        if (this.azi == null || this.ani == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == this.ani.requestAudioFocus(CR()) : 1 == this.ani.requestAudioFocus(this.azi, 3, 2);
    }

    public final void c(a aVar) {
        this.gV = aVar;
    }
}
