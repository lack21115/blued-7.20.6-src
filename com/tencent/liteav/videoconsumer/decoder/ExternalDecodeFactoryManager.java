package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/ExternalDecodeFactoryManager.class */
public class ExternalDecodeFactoryManager {

    /* renamed from: a  reason: collision with root package name */
    private static o f23042a;

    public static void a(o oVar) {
        synchronized (ExternalDecodeFactoryManager.class) {
            try {
                f23042a = oVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a() {
        synchronized (ExternalDecodeFactoryManager.class) {
            try {
                if (f23042a == null) {
                    return false;
                }
                long a2 = f23042a.a();
                if (a2 != 0) {
                    f23042a.a(a2);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long createH265Decoder() {
        synchronized (ExternalDecodeFactoryManager.class) {
            try {
                if (f23042a == null) {
                    return 0L;
                }
                return f23042a.a();
            } finally {
            }
        }
    }

    public static void destroyH265Decoder(long j) {
        synchronized (ExternalDecodeFactoryManager.class) {
            try {
                if (f23042a == null) {
                    LiteavLog.w("ExternalDecodeFactoryManager", "DestroyHevcDecoder sDecoderFactory is null: ".concat(String.valueOf(j)));
                } else {
                    f23042a.a(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
