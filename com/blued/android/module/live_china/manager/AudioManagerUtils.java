package com.blued.android.module.live_china.manager;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/AudioManagerUtils.class */
public class AudioManagerUtils {
    private static final String c = AudioManagerUtils.class.getSimpleName();
    private static AudioManagerUtils h;
    AudioFocusCallback b;
    private AudioManager d;
    private AudioFocusRequest e;
    private boolean f = false;
    private Handler g = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.blued.android.module.live_china.manager.AudioManagerUtils.1
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
    AudioManager.OnAudioFocusChangeListener a = new AudioManager.OnAudioFocusChangeListener() { // from class: com.blued.android.module.live_china.manager.AudioManagerUtils.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Log.c("==xpm", "audioFocusChangeListener:" + i);
            if (AudioManagerUtils.this.b != null) {
                AudioManagerUtils.this.b.a(i);
            }
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/AudioManagerUtils$AudioFocusCallback.class */
    public interface AudioFocusCallback {
        void a(int i);
    }

    private AudioManagerUtils() {
    }

    public static AudioManagerUtils a() {
        if (h == null) {
            synchronized (AudioManagerUtils.class) {
                try {
                    if (h == null) {
                        h = new AudioManagerUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int requestAudioFocus;
        String str;
        Log.c("==xpm", "executeRequestAudio");
        if (this.d == null) {
            this.d = (AudioManager) AppInfo.d().getSystemService("audio");
        }
        if (this.d != null) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    requestAudioFocus = this.d.requestAudioFocus(this.a, 3, 1);
                    str = " requestAudioFocus: SDK_INT < 26,";
                } else {
                    if (this.e == null) {
                        this.e = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.a).build();
                    }
                    Log.c("==xpm", "executeRequestAudio 1");
                    requestAudioFocus = this.d.requestAudioFocus(this.e);
                    str = " requestAudioFocus: SDK_INT >= 26,";
                }
                if (requestAudioFocus == 1) {
                    this.f = true;
                }
                if (AppInfo.m()) {
                    String str2 = c;
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
        Log.c("==xpm", "executeAbandonAudio");
        if (this.f) {
            if (this.d == null) {
                this.d = (AudioManager) AppInfo.d().getSystemService("audio");
            }
            if (this.d != null) {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        abandonAudioFocusRequest = this.d.abandonAudioFocus(this.a);
                        str = " abandonAudioFocus: SDK_INT < 26,";
                    } else {
                        if (this.e == null) {
                            this.e = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setOnAudioFocusChangeListener(this.a).setAcceptsDelayedFocusGain(true).build();
                        }
                        Log.c("==xpm", "executeAbandonAudio 1");
                        abandonAudioFocusRequest = this.d.abandonAudioFocusRequest(this.e);
                        str = " abandonAudioFocus: SDK_INT >= 26,";
                    }
                    if (abandonAudioFocusRequest == 1) {
                        this.f = false;
                    }
                    if (AppInfo.m()) {
                        String str2 = c;
                        Log.b(str2, str + " SDK_INT = " + Build.VERSION.SDK_INT + " , abandonFocusResult = " + abandonAudioFocusRequest);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(AudioFocusCallback audioFocusCallback) {
        this.b = audioFocusCallback;
    }

    public void a(boolean z) {
        if (z) {
            Handler handler = this.g;
            if (handler != null) {
                handler.removeMessages(1);
                this.g.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            return;
        }
        Handler handler2 = this.g;
        if (handler2 != null) {
            handler2.removeMessages(1);
            this.g.sendEmptyMessage(1);
        }
    }

    public void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1);
            this.g.sendEmptyMessage(2);
        }
    }
}
