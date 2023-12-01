package com.tencent.thumbplayer.c;

import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a.class */
public interface a extends ITPPlayerProxy {
    com.tencent.thumbplayer.adapter.a.e a(long j, String str, TPVideoInfo tPVideoInfo, Map<String, String> map);

    com.tencent.thumbplayer.adapter.a.e a(String str, Map<String, String> map);

    ITPMediaAsset a(ITPMediaAsset iTPMediaAsset);

    ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo);

    String a(int i, String str, TPDownloadParamData tPDownloadParamData);

    void a(float f);

    void a(int i);

    void a(long j);

    void a(TPOptionalParam tPOptionalParam);

    void a(TPVideoInfo tPVideoInfo);

    void a(ITPPlayListener iTPPlayListener);

    void a(String str, Object obj);

    void a(String str, String str2);

    void a(boolean z);

    boolean a();

    void b();

    boolean c();

    void d();

    void e();

    boolean f();

    String g();

    void h();

    void i();

    ITPPlayerProxyListener j();
}
