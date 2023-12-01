package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/d.class */
public class d {
    public static final d e = new d();

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f8676a;
    public volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8677c = false;
    public e d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(HonorPushCallback honorPushCallback, boolean z) {
        this.d.a(honorPushCallback, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f8676a = new WeakReference<>(fVar.f8682a);
        this.f8677c = fVar.b;
        this.d = new e(fVar.f8682a);
        if (this.f8677c) {
            a((HonorPushCallback<String>) null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable, HonorPushCallback honorPushCallback) {
        if (this.b) {
            runnable.run();
        } else if (honorPushCallback != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(HonorPushCallback honorPushCallback) {
        this.d.a(honorPushCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(HonorPushCallback honorPushCallback) {
        this.d.b(honorPushCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(HonorPushCallback honorPushCallback) {
        this.d.c(honorPushCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(HonorPushCallback honorPushCallback) {
        this.d.d(honorPushCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(HonorPushCallback honorPushCallback) {
        this.d.e(honorPushCallback);
    }

    public Context a() {
        return this.f8676a.get();
    }

    public void a(final HonorPushCallback<Void> honorPushCallback) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$EGMgL7Am84jByBw_4GmjKn54yhA
            @Override // java.lang.Runnable
            public final void run() {
                d.this.e(honorPushCallback);
            }
        }, honorPushCallback);
    }

    public void a(final HonorPushCallback<String> honorPushCallback, final boolean z) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$lBLsW6z9ZiSIaOovYHalAwiZ-8I
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(honorPushCallback, z);
            }
        }, honorPushCallback);
    }

    public void a(final f fVar) {
        k0.a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$pHi71rfctf4o362TLzTx1QckTmw
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(fVar);
            }
        });
    }

    public final void a(final Runnable runnable, final HonorPushCallback<?> honorPushCallback) {
        k0.a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$hpjfIeps1fSDiqbu8BorQkqsE_4
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(runnable, honorPushCallback);
            }
        });
    }

    public void b(final HonorPushCallback<Void> honorPushCallback) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$eJzre5EVwAZLBeM3ZN0OERDeHCw
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f(honorPushCallback);
            }
        }, honorPushCallback);
    }

    public void c(final HonorPushCallback<Void> honorPushCallback) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$-IE5zT0Wlg3EtNcs7D91hKN8rDY
            @Override // java.lang.Runnable
            public final void run() {
                d.this.g(honorPushCallback);
            }
        }, honorPushCallback);
    }

    public void d(final HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$DJhGx0iD48ikXW6KAe2sz8NB0yM
            @Override // java.lang.Runnable
            public final void run() {
                d.this.h(honorPushCallback);
            }
        }, honorPushCallback);
    }

    public void j(final HonorPushCallback<Boolean> honorPushCallback) {
        a(new Runnable() { // from class: com.hihonor.push.sdk.-$$Lambda$d$OUG3HEVt8xKwrmbb68nvPHCa8JU
            @Override // java.lang.Runnable
            public final void run() {
                d.this.i(honorPushCallback);
            }
        }, honorPushCallback);
    }
}
