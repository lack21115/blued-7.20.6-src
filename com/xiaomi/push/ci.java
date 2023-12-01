package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.ch;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ci.class */
public class ci extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f41309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f41309a = chVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<ch.a> arrayList6;
        arrayList = this.f41309a.f242a;
        synchronized (arrayList) {
            arrayList2 = this.f41309a.f242a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.f41309a.f242a;
                if (arrayList3.size() > 1) {
                    ch chVar = this.f41309a;
                    arrayList6 = this.f41309a.f242a;
                    chVar.a(arrayList6);
                } else {
                    ch chVar2 = this.f41309a;
                    arrayList4 = this.f41309a.f242a;
                    chVar2.b((ch.a) arrayList4.get(0));
                }
                arrayList5 = this.f41309a.f242a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
