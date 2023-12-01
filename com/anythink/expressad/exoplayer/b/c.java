package com.anythink.expressad.exoplayer.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7176a = new c(new int[]{2}, 2);
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7177c;

    private c(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.b = new int[0];
        }
        this.f7177c = i;
    }

    private int a() {
        return this.f7177c;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter(AudioManager.ACTION_HDMI_AUDIO_PLUG)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Intent intent) {
        return (intent == null || intent.getIntExtra(AudioManager.EXTRA_AUDIO_PLUG_STATE, 0) == 0) ? f7176a : new c(intent.getIntArrayExtra(AudioManager.EXTRA_ENCODINGS), intent.getIntExtra(AudioManager.EXTRA_MAX_CHANNEL_COUNT, 0));
    }

    public final boolean a(int i) {
        return Arrays.binarySearch(this.b, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.b, cVar.b) && this.f7177c == cVar.f7177c;
        }
        return false;
    }

    public final int hashCode() {
        return this.f7177c + (Arrays.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f7177c + ", supportedEncodings=" + Arrays.toString(this.b) + "]";
    }
}
