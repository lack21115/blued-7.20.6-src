package com.tencent.cloud.huiyansdkface.record;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/WeMediaManager.class */
public class WeMediaManager {

    /* renamed from: a  reason: collision with root package name */
    private static String f36056a = "WeMediaManager";
    private static WeMediaManager i = new WeMediaManager();
    private WeWrapMp4Jni b = new WeWrapMp4Jni();

    /* renamed from: c  reason: collision with root package name */
    private boolean f36057c = false;
    private WeMediaCodec d = null;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private int h = 50;

    private WeMediaManager() {
    }

    public static WeMediaManager getInstance() {
        return i;
    }

    public boolean createMediaCodec(Context context, int i2, int i3, int i4) {
        WeMediaCodec weMediaCodec = new WeMediaCodec(context, this.b, i2, i3, i4, this.h);
        this.d = weMediaCodec;
        boolean z = weMediaCodec.initMediaCodec(context);
        this.f = z;
        return z;
    }

    public void destroy() {
        WeMediaCodec weMediaCodec;
        stop(false);
        if (!this.f || (weMediaCodec = this.d) == null) {
            return;
        }
        try {
            weMediaCodec.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = null;
    }

    public void enableDebug() {
        this.g = true;
    }

    public byte[] getVideoByte() {
        WeMediaCodec weMediaCodec = this.d;
        return (weMediaCodec == null || weMediaCodec.getVideoByte() == null) ? new byte[0] : this.d.getVideoByte().toByteArray();
    }

    public void init(int i2) {
        WLogger.i(f36056a, "init");
        this.h = i2 + 1;
        String str = f36056a;
        WLogger.i(str, "init maxFrameNum=" + this.h);
    }

    public void onPreviewFrame(byte[] bArr) {
        if (this.f36057c) {
            this.d.onPreviewFrame(bArr);
        }
    }

    public void resetVideoByte() {
        WeMediaCodec weMediaCodec = this.d;
        if (weMediaCodec == null || weMediaCodec.getVideoByte() == null) {
            return;
        }
        this.d.getVideoByte().reset();
    }

    public void start(WbRecordFinishListener wbRecordFinishListener) {
        String str = f36056a;
        WLogger.i(str, "WeMediaManager start " + System.currentTimeMillis());
        if (this.f36057c) {
            return;
        }
        this.f36057c = true;
        this.d.start(wbRecordFinishListener);
    }

    public void stop(boolean z) {
        String str = f36056a;
        WLogger.i(str, "WeMediaManager stop " + System.currentTimeMillis());
        if (this.f36057c) {
            this.f36057c = false;
            this.d.stop();
        }
    }
}
