package com.tencent.cloud.huiyansdkface.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/e.class */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f21785a = new ArrayList();

    public e a(b bVar) {
        if (bVar != null && !this.f21785a.contains(bVar)) {
            this.f21785a.add(bVar);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a() {
        int size = this.f21785a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.f21785a.get(i).a();
            size = i;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f21785a.size()) {
                return;
            }
            this.f21785a.get(i2).a(aVar);
            i = i2 + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar, com.tencent.cloud.huiyansdkface.a.c.d dVar, com.tencent.cloud.huiyansdkface.a.a.a aVar2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f21785a.size()) {
                return;
            }
            this.f21785a.get(i2).a(aVar, dVar, aVar2);
            i = i2 + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.g.b bVar, com.tencent.cloud.huiyansdkface.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.e.b bVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f21785a.size()) {
                return;
            }
            this.f21785a.get(i2).a(bVar, aVar, bVar2, dVar);
            i = i2 + 1;
        }
    }

    public e b(b bVar) {
        if (bVar != null && this.f21785a.contains(bVar)) {
            this.f21785a.remove(bVar);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void b(com.tencent.cloud.huiyansdkface.a.c.a aVar) {
        int size = this.f21785a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.f21785a.get(i).b(aVar);
            size = i;
        }
    }
}
