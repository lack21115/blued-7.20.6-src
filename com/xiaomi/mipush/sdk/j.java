package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/j.class */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41226a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ e f159a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, Context context, e eVar) {
        this.f160a = str;
        this.f41226a = context;
        this.f159a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        if (TextUtils.isEmpty(this.f160a)) {
            return;
        }
        String[] split = this.f160a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                str = "";
                break;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i = i2 + 1;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.f41226a, this.f159a, str);
        i.m11479a(this.f41226a);
    }
}
