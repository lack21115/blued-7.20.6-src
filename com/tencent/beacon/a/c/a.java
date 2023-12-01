package com.tencent.beacon.a.c;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/a.class */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.a.d.a f21244a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f21245c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tencent.beacon.a.d.a aVar, String str, long j) {
        this.f21244a = aVar;
        this.b = str;
        this.f21245c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.SharedPreferences$EditorC0725a edit = this.f21244a.edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putLong(this.b, this.f21245c);
        }
    }
}
