package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.config.TPPlayerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/e.class */
public class e {
    public static a a(com.tencent.thumbplayer.e.b bVar, com.tencent.thumbplayer.tplayer.a aVar) {
        return TPPlayerConfig.getNewReportEnable() ? (a) new f(new d(aVar.a(), bVar), aVar).a() : new d(aVar.a(), bVar);
    }
}
