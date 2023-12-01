package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a.class */
public interface a extends com.tencent.thumbplayer.adapter.a.b {
    int a();

    void a(c.k kVar);

    void a(com.tencent.thumbplayer.adapter.a.e eVar);

    void a(com.tencent.thumbplayer.adapter.a.e eVar, int i, long j);

    void a(com.tencent.thumbplayer.adapter.a.e eVar, Map<String, String> map);

    void a(com.tencent.thumbplayer.adapter.a.e eVar, Map<String, String> map, int i, long j);

    void a(TPVideoInfo tPVideoInfo);

    void a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    int b();

    void b(TPVideoInfo tPVideoInfo);

    boolean c();

    int d();

    b e();
}
