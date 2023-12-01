package com.tencent.qimei.l;

import android.text.TextUtils;
import com.tencent.qimei.i.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/l/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.c.d f24657a;
    public final /* synthetic */ d b;

    public a(d dVar, com.tencent.qimei.c.d dVar2) {
        this.b = dVar;
        this.f24657a = dVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        str = this.b.b;
        String c2 = f.a(str).c("is_first");
        str2 = this.b.b;
        if (!com.tencent.qimei.v.d.a(str2).h() || TextUtils.isEmpty(c2)) {
            this.f24657a.a(2);
        } else {
            d.a(this.b, this.f24657a);
        }
    }
}
