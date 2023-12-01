package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.amap.api.col.3sl.mq;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/h.class */
public final class h extends a<mq> {
    public h(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String a(mq mqVar) {
        return mqVar == null ? "" : mqVar.a();
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(mq mqVar, long j) {
        if (mqVar != null) {
            mqVar.f = j;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static int b2(mq mqVar) {
        return mqVar == null ? PackageManager.INSTALL_FAILED_NO_MATCHING_ABIS : mqVar.c;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    private static long c2(mq mqVar) {
        if (mqVar == null) {
            return 0L;
        }
        return mqVar.f;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(mq mqVar, long j) {
        a2(mqVar, j);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(mq mqVar) {
        return a(mqVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(mq mqVar) {
        return b2(mqVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(mq mqVar) {
        return c2(mqVar);
    }
}
