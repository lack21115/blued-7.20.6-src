package com.efs.sdk.base.core.config;

import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f21747a = new ConcurrentHashMap();

    public final List<AbsSection> a(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection put = kVSection.put("type", str).put("appid", this.f21747a.get("appid")).put("wid", this.f21747a.get("wid")).put("pid", this.f21747a.get("pid")).put("pkg", this.f21747a.get("pkg")).put("ver", this.f21747a.get("ver")).put(RedirectRespWrapper.KEY_VERCODE, this.f21747a.get(RedirectRespWrapper.KEY_VERCODE)).put("ps", this.f21747a.get("ps")).put("stime", this.f21747a.get("stime"));
        com.efs.sdk.base.core.a.a.a();
        KVSection put2 = put.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        put2.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000)).put("sdk_ver", this.f21747a.get("sdk_ver"));
        String valueOf = String.valueOf(b("uid", ""));
        if (!TextUtils.isEmpty(valueOf)) {
            kVSection.put("uid", valueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.f21747a.get("lang")).put("brand", this.f21747a.get("brand")).put("model", this.f21747a.get("model")).put("build_model", this.f21747a.get("build_model")).put("rom", this.f21747a.get("rom")).put("sdk", this.f21747a.get("sdk")).put("dsp_h", this.f21747a.get("dsp_h")).put("dsp_w", this.f21747a.get("dsp_w")).put("tzone", this.f21747a.get("tzone")).put("net", this.f21747a.get("net")).put(com.anythink.expressad.video.dynview.a.a.Z, this.f21747a.get(com.anythink.expressad.video.dynview.a.a.Z));
        try {
            if (this.f21747a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f21747a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f21747a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f21747a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f21747a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f21747a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public final Map<String, Object> a() {
        HashMap hashMap = new HashMap(this.f21747a);
        com.efs.sdk.base.core.a.a.a();
        hashMap.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        hashMap.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        return hashMap;
    }

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f21747a.put(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object b(String str, Object obj) {
        Object obj2 = this.f21747a.get(str);
        if (obj2 == null && !this.f21747a.containsKey(str)) {
            return obj;
        }
        return obj2;
    }
}
