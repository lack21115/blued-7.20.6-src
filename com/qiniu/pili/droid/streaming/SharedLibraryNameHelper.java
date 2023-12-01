package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import com.qiniu.pili.droid.streaming.microphone.AudioMixer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/SharedLibraryNameHelper.class */
public class SharedLibraryNameHelper {

    /* renamed from: a  reason: collision with root package name */
    public String f14137a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f14138c;
    public String d;
    public String e;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/SharedLibraryNameHelper$PLSharedLibraryType.class */
    public enum PLSharedLibraryType {
        PL_SO_TYPE_CORE,
        PL_SO_TYPE_H264,
        PL_SO_TYPE_AAC,
        PL_SO_TYPE_MM,
        PL_SO_TYPE_AUDIO_MIX
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/SharedLibraryNameHelper$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14139a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[PLSharedLibraryType.values().length];
            f14139a = iArr;
            try {
                iArr[PLSharedLibraryType.PL_SO_TYPE_CORE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14139a[PLSharedLibraryType.PL_SO_TYPE_H264.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14139a[PLSharedLibraryType.PL_SO_TYPE_AAC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14139a[PLSharedLibraryType.PL_SO_TYPE_MM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14139a[PLSharedLibraryType.PL_SO_TYPE_AUDIO_MIX.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/SharedLibraryNameHelper$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final SharedLibraryNameHelper f14140a = new SharedLibraryNameHelper(null);
    }

    public SharedLibraryNameHelper() {
        this.f14137a = "pldroid_streaming_h264_encoder";
        this.b = "pldroid_streaming_aac_encoder";
        this.f14138c = "pldroid_streaming_core";
        this.d = "pldroid_mmprocessing";
        this.e = "pldroid_streaming_amix";
    }

    public /* synthetic */ SharedLibraryNameHelper(a aVar) {
        this();
    }

    public static boolean a(boolean z) {
        if (z && !PLAACEncoder.f14149c) {
            e.f1313c.e("PLSONameHelper", "SW AAC Codec is not available");
        }
        return PLAACEncoder.f14149c;
    }

    public static boolean b(boolean z) {
        if (z && !AudioMixer.s) {
            e.f1313c.e("PLSONameHelper", "Audio mix is not available");
        }
        return AudioMixer.s;
    }

    public static boolean c(boolean z) {
        if (z && !PLH264Encoder.i) {
            e.f1313c.e("PLSONameHelper", "SW H264 Codec is not available");
        }
        return PLH264Encoder.i;
    }

    public static boolean d(boolean z) {
        if (z && !a.a.a.a.a.i.a.f1335a) {
            e.f1313c.e("PLSONameHelper", "MM Processing is not available");
        }
        return a.a.a.a.a.i.a.f1335a;
    }

    public static boolean e(boolean z) {
        if (z && !PLDroidStreamingCore.isLoadOk) {
            e.f1313c.e("PLSONameHelper", "Streaming Core is not available");
        }
        return PLDroidStreamingCore.isLoadOk;
    }

    public static SharedLibraryNameHelper getInstance() {
        return b.f14140a;
    }

    public boolean a() {
        return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_AAC));
    }

    public final boolean a(String str) {
        if (StreamingEnv.b()) {
            if (str != null) {
                try {
                    if (str.contains("/")) {
                        System.load(str);
                        return true;
                    }
                    System.loadLibrary(str);
                    return true;
                } catch (UnsatisfiedLinkError e) {
                    e eVar = e.f1313c;
                    eVar.e("PLSONameHelper", "Load error:" + e.getMessage());
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public boolean b() {
        return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_AUDIO_MIX));
    }

    public boolean c() {
        return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_H264));
    }

    public boolean d() {
        return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_MM));
    }

    public boolean e() {
        return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_CORE));
    }

    public String getSharedLibraryName(PLSharedLibraryType pLSharedLibraryType) {
        int i = a.f14139a[pLSharedLibraryType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return this.e;
                        }
                        throw new IllegalArgumentException("cannot support the so type:" + pLSharedLibraryType);
                    }
                    return this.d;
                }
                return this.b;
            }
            return this.f14137a;
        }
        return this.f14138c;
    }

    public void renameSharedLibrary(PLSharedLibraryType pLSharedLibraryType, String str) {
        e eVar = e.f1313c;
        eVar.c("PLSONameHelper", "renameSharedLibrary type:" + pLSharedLibraryType + ",newName:" + str);
        int i = a.f14139a[pLSharedLibraryType.ordinal()];
        if (i == 1) {
            this.f14138c = str;
        } else if (i == 2) {
            this.f14137a = str;
        } else if (i == 3) {
            this.b = str;
        } else if (i == 4) {
            this.d = str;
        } else if (i == 5) {
            this.e = str;
        } else {
            throw new IllegalArgumentException("cannot support the so type:" + pLSharedLibraryType);
        }
    }
}
