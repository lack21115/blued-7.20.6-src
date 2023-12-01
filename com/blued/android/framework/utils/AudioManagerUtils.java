package com.blued.android.framework.utils;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/AudioManagerUtils.class */
public class AudioManagerUtils {
    private static final String b = AudioManagerUtils.class.getSimpleName();
    private static AudioManagerUtils g;

    /* renamed from: c  reason: collision with root package name */
    private AudioManager f10071c;
    private AudioFocusRequest d;
    private boolean e = false;
    private Handler f = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.blued.android.framework.utils.AudioManagerUtils.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    AudioManagerUtils.this.d();
                    return false;
                } else if (i != 2) {
                    return false;
                } else {
                    AudioManagerUtils.this.c();
                    return false;
                }
            }
            return false;
        }
    });

    /* renamed from: a  reason: collision with root package name */
    AudioManager.OnAudioFocusChangeListener f10070a = new AudioManager.OnAudioFocusChangeListener() { // from class: com.blued.android.framework.utils.AudioManagerUtils.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    };

    private AudioManagerUtils() {
    }

    public static AudioManagerUtils a() {
        if (g == null) {
            synchronized (AudioManagerUtils.class) {
                try {
                    if (g == null) {
                        g = new AudioManagerUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int requestAudioFocus;
        String str;
        if (this.e) {
            return;
        }
        if (this.f10071c == null) {
            this.f10071c = (AudioManager) AppInfo.d().getSystemService("audio");
        }
        if (this.f10071c != null) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    requestAudioFocus = this.f10071c.requestAudioFocus(this.f10070a, 3, 2);
                    str = " requestAudioFocus: SDK_INT < 26,";
                } else {
                    if (this.d == null) {
                        this.d = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.f10070a).build();
                    }
                    requestAudioFocus = this.f10071c.requestAudioFocus(this.d);
                    str = " requestAudioFocus: SDK_INT >= 26,";
                }
                if (requestAudioFocus == 1) {
                    this.e = true;
                }
                if (AppInfo.m()) {
                    String str2 = b;
                    Log.b(str2, str + " SDK_INT = " + Build.VERSION.SDK_INT + " , requestFocusResult = " + requestAudioFocus);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int abandonAudioFocusRequest;
        String str;
        if (this.e) {
            if (this.f10071c == null) {
                this.f10071c = (AudioManager) AppInfo.d().getSystemService("audio");
            }
            if (this.f10071c != null) {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        abandonAudioFocusRequest = this.f10071c.abandonAudioFocus(this.f10070a);
                        str = " abandonAudioFocus: SDK_INT < 26,";
                    } else {
                        if (this.d == null) {
                            this.d = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setOnAudioFocusChangeListener(this.f10070a).setAcceptsDelayedFocusGain(true).build();
                        }
                        abandonAudioFocusRequest = this.f10071c.abandonAudioFocusRequest(this.d);
                        str = " abandonAudioFocus: SDK_INT >= 26,";
                    }
                    if (abandonAudioFocusRequest == 1) {
                        this.e = false;
                    }
                    if (AppInfo.m()) {
                        String str2 = b;
                        Log.b(str2, str + " SDK_INT = " + Build.VERSION.SDK_INT + " , abandonFocusResult = " + abandonAudioFocusRequest);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(1);
                this.f.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            return;
        }
        Handler handler2 = this.f;
        if (handler2 != null) {
            handler2.removeMessages(1);
            this.f.sendEmptyMessage(1);
        }
    }

    public void b() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(1);
            this.f.sendEmptyMessage(2);
        }
    }
}
