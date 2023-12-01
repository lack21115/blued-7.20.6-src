package com.xiaomi.push.service;

import com.xiaomi.push.ai;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/al.class */
final class al extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27914a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ax f925a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(String str, ax axVar, int i) {
        this.f926a = str;
        this.f925a = axVar;
        this.f27914a = i;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public final String mo8500a() {
        return this.f926a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f925a.a(this.f27914a);
    }
}
