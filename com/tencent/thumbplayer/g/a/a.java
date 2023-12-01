package com.tencent.thumbplayer.g.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/a/a.class */
public interface a {
    void onCreate(Boolean bool);

    void onRealRelease();

    void onReuseCodecAPIException(String str, Throwable th);

    void onStarted(Boolean bool, String str);

    void onTransToKeepPool();

    void onTransToRunningPool();
}
