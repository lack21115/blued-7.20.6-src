package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private List<i> f35463a = new ArrayList();

    public void a(a aVar) {
        Camera a2 = aVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        Exception e = null;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f35463a.size()) {
                break;
            }
            Camera.Parameters parameters = a2.getParameters();
            try {
                this.f35463a.get(i3).a(parameters, aVar);
                a2.setParameters(parameters);
            } catch (Exception e2) {
                e = e2;
                i = i3;
            }
            i2 = i3 + 1;
        }
        if (e != null) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(new com.tencent.cloud.huiyansdkface.a.b.c(22, "set some parameter failed:" + i, e, "type_normal"));
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1ParasOperator", "set config success. use time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void a(i iVar) {
        if (iVar == null || this.f35463a.contains(iVar)) {
            return;
        }
        this.f35463a.add(iVar);
    }
}
