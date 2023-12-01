package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f23031a;
    private final String b;

    private q(j jVar, String str) {
        this.f23031a = jVar;
        this.b = str;
    }

    public static Runnable a(j jVar, String str) {
        return new q(jVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f23031a;
        String str = this.b;
        try {
            LiteavLog.i(jVar.f23014a, "setHWDecoderDeviceRelatedParams: ".concat(String.valueOf(str)));
            final JSONArray jSONArray = new JSONArray(str);
            if (jVar.f != null) {
                final VideoDecodeController videoDecodeController = jVar.f;
                videoDecodeController.a(new Runnable(videoDecodeController, jSONArray) { // from class: com.tencent.liteav.videoconsumer.decoder.ae

                    /* renamed from: a  reason: collision with root package name */
                    private final VideoDecodeController f23058a;
                    private final JSONArray b;

                    {
                        this.f23058a = videoDecodeController;
                        this.b = jSONArray;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoDecodeController videoDecodeController2 = this.f23058a;
                        JSONArray jSONArray2 = this.b;
                        videoDecodeController2.l = jSONArray2;
                        LiteavLog.i(videoDecodeController2.f23043a, "set MediaCodec device related params to %s", jSONArray2);
                    }
                });
            }
        } catch (JSONException e) {
            LiteavLog.e(jVar.f23014a, "setHWDecoderDeviceRelatedParams error ".concat(String.valueOf(e)));
        }
    }
}
