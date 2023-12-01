package com.xiaomi.push.service;

import com.xiaomi.push.ai;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/al.class */
final class al extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41605a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ax f972a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(String str, ax axVar, int i) {
        this.f973a = str;
        this.f972a = axVar;
        this.f41605a = i;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public final String mo11550a() {
        return this.f973a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f972a.a(this.f41605a);
    }
}
