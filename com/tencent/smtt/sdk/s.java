package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/s.class */
class s {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f25188a;

    public s(DexLoader dexLoader) {
        this.f25188a = null;
        this.f25188a = dexLoader;
    }

    public String a(Context context) {
        Object newInstance;
        Object invokeMethod;
        DexLoader dexLoader = this.f25188a;
        return (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (invokeMethod = this.f25188a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? "" : String.valueOf(invokeMethod);
    }

    public void a(Context context, String str) {
        Object newInstance;
        DexLoader dexLoader = this.f25188a;
        if (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.f25188a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }
}
