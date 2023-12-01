package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private com.qiniu.pili.droid.shortvideo.process.a.c f27588a;
    private PLVideoEncodeSetting b;

    /* renamed from: c  reason: collision with root package name */
    private String f27589c;
    private long d;

    public o(Context context, String str, long j) {
        l.a(context.getApplicationContext());
        this.f27589c = str;
        this.d = j;
    }

    public JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_mix_video", i);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public void a() {
        this.f27588a.a();
    }

    public void a(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.b = pLVideoEncodeSetting;
    }

    public void a(List<PLVideoMixItem> list, PLVideoSaveListener pLVideoSaveListener) {
        if (u.a().a(b.a.mix_video)) {
            if (this.f27588a == null) {
                this.f27588a = new com.qiniu.pili.droid.shortvideo.process.a.c();
            }
            this.f27588a.a(list, this.f27589c, this.d, this.b, pLVideoSaveListener);
        } else if (pLVideoSaveListener != null) {
            pLVideoSaveListener.onSaveVideoFailed(8);
        }
    }
}
