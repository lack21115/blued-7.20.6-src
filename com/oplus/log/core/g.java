package com.oplus.log.core;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/g.class */
public interface g {
    void logan_debug(boolean z);

    void logan_flush();

    void logan_init(String str, String str2, int i, String str3, String str4);

    void logan_open(String str);

    void logan_write(int i, String str, long j, String str2, long j2);

    void setOnLoganProtocolStatus(i iVar);
}
