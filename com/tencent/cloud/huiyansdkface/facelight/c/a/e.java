package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.content.Context;
import android.view.View;
import com.tencent.cloud.huiyansdkface.a.g.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/a/e.class */
public class e implements com.tencent.cloud.huiyansdkface.a.g.a {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.d.c f35540a;

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public View a(Context context) {
        return this.f35540a.a(context);
    }

    public void a() {
        WLogger.d("TuringPreviewView", "destroy");
        this.f35540a.c();
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public void a(com.tencent.cloud.huiyansdkface.a.c.a.a aVar) {
        this.f35540a.a(aVar.a());
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public void a(a.InterfaceC0905a interfaceC0905a) {
        WLogger.i("TuringPreviewView", "set TuringCallback");
        this.f35540a.a(interfaceC0905a);
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.c.d.c cVar) {
        this.f35540a = cVar;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public boolean b() {
        return false;
    }
}
