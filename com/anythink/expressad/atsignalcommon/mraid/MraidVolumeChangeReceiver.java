package com.anythink.expressad.atsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/MraidVolumeChangeReceiver.class */
public class MraidVolumeChangeReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static double f7090a = -1.0d;
    private static final String b = "android.media.VOLUME_CHANGED_ACTION";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7091c = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private Context d;
    private AudioManager e;
    private boolean f = false;
    private VolumeChangeListener g;
    private VolumeChangeBroadcastReceiver h;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/MraidVolumeChangeReceiver$VolumeChangeBroadcastReceiver.class */
    static class VolumeChangeBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<MraidVolumeChangeReceiver> f7092a;

        public VolumeChangeBroadcastReceiver(MraidVolumeChangeReceiver mraidVolumeChangeReceiver) {
            this.f7092a = new WeakReference<>(mraidVolumeChangeReceiver);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MraidVolumeChangeReceiver mraidVolumeChangeReceiver;
            VolumeChangeListener volumeChangeListener;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (mraidVolumeChangeReceiver = this.f7092a.get()) == null || (volumeChangeListener = mraidVolumeChangeReceiver.getVolumeChangeListener()) == null) {
                return;
            }
            double currentVolume = mraidVolumeChangeReceiver.getCurrentVolume();
            if (currentVolume >= 0.0d) {
                volumeChangeListener.onVolumeChanged(currentVolume);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/MraidVolumeChangeReceiver$VolumeChangeListener.class */
    public interface VolumeChangeListener {
        void onVolumeChanged(double d);
    }

    public MraidVolumeChangeReceiver(Context context) {
        this.d = context;
        this.e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public double getCurrentVolume() {
        AudioManager audioManager = this.e;
        int i = -1;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.e;
        if (audioManager2 != null) {
            i = audioManager2.getStreamVolume(3);
        }
        double d = (i * 100.0d) / streamMaxVolume;
        f7090a = d;
        return d;
    }

    public VolumeChangeListener getVolumeChangeListener() {
        return this.g;
    }

    public void registerReceiver() {
        if (this.d != null) {
            this.h = new VolumeChangeBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.d.registerReceiver(this.h, intentFilter);
            this.f = true;
        }
    }

    public void setVolumeChangeListener(VolumeChangeListener volumeChangeListener) {
        this.g = volumeChangeListener;
    }

    public void unregisterReceiver() {
        Context context;
        if (!this.f || (context = this.d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.h);
            this.g = null;
            this.f = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
