package com.tencent.beacon.a.c;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/a.class */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.a.d.a f34935a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f34936c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tencent.beacon.a.d.a aVar, String str, long j) {
        this.f34935a = aVar;
        this.b = str;
        this.f34936c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.SharedPreferences$EditorC0895a edit = this.f34935a.edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putLong(this.b, this.f34936c);
        }
    }
}
