package com.blued.android.module.yy_china.trtc_audio;

import com.blued.android.module.live.base.music.model.TrtcAudioFrameModel;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.yy_china.model.trtc.TRTCSEIMsg;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.tencent.trtc.TRTCCloudDef;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/IAudioContract.class */
public interface IAudioContract {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/IAudioContract$AppHandoverListener.class */
    public interface AppHandoverListener {
        void a();

        void b();
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/IAudioContract$IAudioCallback.class */
    public interface IAudioCallback {
        void a();

        void a(int i);

        void a(int i, String str);

        void a(long j);

        void a(TrtcAudioFrameModel trtcAudioFrameModel);

        void a(TRTCCloudDef.TRTCQuality tRTCQuality);

        void a(String str);

        void a(String str, int i, int i2, String str2);

        void a(String str, int i, String str2);

        void a(String str, boolean z);

        void a(Set<String> set, boolean z);

        void b();

        void b(int i);

        void b(int i, String str);

        void b(String str);

        void c();

        void c(String str);
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/IAudioContract$IAudioControl.class */
    public interface IAudioControl {
        void a();

        void a(int i);

        void a(int i, float f);

        void a(int i, int i2);

        void a(int i, int i2, boolean z);

        void a(int i, IMusicCallback iMusicCallback);

        void a(int i, String str);

        void a(int i, String str, int i2, String str2, long j);

        void a(int i, boolean z, String str, int i2, String str2, long j);

        void a(TRTCSEIMsg tRTCSEIMsg);

        void a(IAudioCallback iAudioCallback);

        void a(YYAudioConfig yYAudioConfig);

        void a(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam);

        void a(String str, int i);

        void a(boolean z);

        void a(boolean z, int i);

        void b();

        void b(int i);

        void b(int i, String str);

        void b(IAudioCallback iAudioCallback);

        void b(YYAudioConfig yYAudioConfig);

        void b(boolean z);

        void c();

        void c(int i);

        void d();

        void d(int i);

        void e();

        void e(int i);

        int f();

        void f(int i);

        int g();

        void g(int i);

        int h();

        void i();
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/IAudioContract$IMusicCallback.class */
    public interface IMusicCallback {
        void a(int i, int i2);

        void a(TrtcMusicModel trtcMusicModel);

        void b(int i, int i2);
    }
}
