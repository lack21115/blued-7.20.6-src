package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cv.class */
class cv extends cp {

    /* renamed from: a  reason: collision with root package name */
    cp f27630a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ct f228a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv(ct ctVar, String str, cp cpVar) {
        super(str);
        this.f228a = ctVar;
        this.b = cpVar;
        this.f27630a = this.b;
        this.f214b = this.f214b;
        cp cpVar2 = this.b;
        if (cpVar2 != null) {
            this.f = cpVar2.f;
        }
    }

    @Override // com.xiaomi.push.cp
    public ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            if (this.f27630a != null) {
                arrayList.addAll(this.f27630a.a(true));
            }
            synchronized (ct.b) {
                cp cpVar = ct.b.get(this.f214b);
                if (cpVar != null) {
                    Iterator<String> it = cpVar.a(true).iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (arrayList.indexOf(next) == -1) {
                            arrayList.add(next);
                        }
                    }
                    arrayList.remove(this.f214b);
                    arrayList.add(this.f214b);
                }
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cp
    public void a(String str, co coVar) {
        synchronized (this) {
            if (this.f27630a != null) {
                this.f27630a.a(str, coVar);
            }
        }
    }

    @Override // com.xiaomi.push.cp
    public boolean b() {
        return false;
    }
}
