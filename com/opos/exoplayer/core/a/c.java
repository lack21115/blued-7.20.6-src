package com.opos.exoplayer.core.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f11324a = new c(new int[]{2}, 2);
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11325c;

    c(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.b = new int[0];
        }
        this.f11325c = i;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter(AudioManager.ACTION_HDMI_AUDIO_PLUG)));
    }

    static c a(Intent intent) {
        return (intent == null || intent.getIntExtra(AudioManager.EXTRA_AUDIO_PLUG_STATE, 0) == 0) ? f11324a : new c(intent.getIntArrayExtra(AudioManager.EXTRA_ENCODINGS), intent.getIntExtra(AudioManager.EXTRA_MAX_CHANNEL_COUNT, 0));
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.b, i) >= 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (Arrays.equals(this.b, cVar.b)) {
                    if (this.f11325c != cVar.f11325c) {
                        return false;
                    }
                }
                return z;
            }
            return false;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return this.f11325c + (Arrays.hashCode(this.b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f11325c + ", supportedEncodings=" + Arrays.toString(this.b) + "]";
    }
}
