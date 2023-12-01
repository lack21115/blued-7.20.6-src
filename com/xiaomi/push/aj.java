package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/aj.class */
public class aj extends ai.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f41249a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f176a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f177a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, boolean z, String str) {
        super(aVar);
        this.f41249a = aiVar;
        this.f177a = z;
        this.f176a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ai.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        SharedPreferences sharedPreferences;
        if (this.f177a) {
            return;
        }
        sharedPreferences = this.f41249a.f172a;
        sharedPreferences.edit().putLong(this.f176a, System.currentTimeMillis()).commit();
    }
}
