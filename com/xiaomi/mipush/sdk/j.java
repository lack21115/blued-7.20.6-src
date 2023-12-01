package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/j.class */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27535a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ e f112a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, Context context, e eVar) {
        this.f113a = str;
        this.f27535a = context;
        this.f112a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        if (TextUtils.isEmpty(this.f113a)) {
            return;
        }
        String[] split = this.f113a.split(Constants.WAVE_SEPARATOR);
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
            com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.f27535a, this.f112a, str);
        i.m8429a(this.f27535a);
    }
}
