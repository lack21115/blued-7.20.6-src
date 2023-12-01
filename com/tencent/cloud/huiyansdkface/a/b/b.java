package com.tencent.cloud.huiyansdkface.a.b;

import android.util.Log;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f21748a = new a() { // from class: com.tencent.cloud.huiyansdkface.a.b.b.1
        @Override // com.tencent.cloud.huiyansdkface.a.b.a
        public void a(c cVar) {
            Log.e("CameraErrorCallback", String.format("camera exception: type=%s,msg=%s", cVar.c(), cVar.getMessage()));
            if (cVar != null) {
                cVar.printStackTrace();
            }
        }
    };
    private static a b;

    public static void a(a aVar) {
        b = aVar;
    }

    public static void a(c cVar) {
        a aVar = b;
        if (aVar != null) {
            aVar.a(cVar);
        } else if (cVar != null) {
            cVar.printStackTrace();
        }
    }
}
