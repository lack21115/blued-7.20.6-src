package com.oplus.log.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/CLoganProtocol.class */
class CLoganProtocol implements g {
    private static final String LIBRARY_NAME = "opluslog";
    private static boolean sIsCloganOk;
    private boolean mIsLoganInit;
    private boolean mIsLoganOpen;
    private i mLoganProtocolStatus;
    private Set<Integer> mArraySet = Collections.synchronizedSet(new HashSet());
    private long nativeConfigPointer = 0;

    static {
        try {
            if (!l.a(LIBRARY_NAME, CLoganProtocol.class)) {
                System.loadLibrary(LIBRARY_NAME);
            }
            sIsCloganOk = true;
        } catch (Throwable th) {
            if (com.oplus.log.b.a()) {
                th.printStackTrace();
            }
            sIsCloganOk = false;
        }
    }

    private static native void clogan_debug(boolean z);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i, String str3, String str4);

    private native int clogan_open(String str);

    private native int clogan_write(int i, String str, long j, String str2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCloganSuccess() {
        return sIsCloganOk;
    }

    private void loganStatusCode(String str, int i) {
        if (i < 0) {
            if ("clogan_write".endsWith(str) && i != -4060) {
                if (this.mArraySet.contains(Integer.valueOf(i))) {
                    return;
                }
                this.mArraySet.add(Integer.valueOf(i));
            }
            i iVar = this.mLoganProtocolStatus;
            if (iVar != null) {
                iVar.a(str, i);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_debug(boolean z) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                clogan_debug(z);
            } catch (UnsatisfiedLinkError e) {
                if (com.oplus.log.b.a()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_flush() {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e) {
                if (com.oplus.log.b.a()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_init(String str, String str2, int i, String str3, String str4) {
        if (this.mIsLoganInit) {
            return;
        }
        if (!sIsCloganOk) {
            loganStatusCode("logan_loadso", -5020);
            return;
        }
        try {
            int clogan_init = clogan_init(str, str2, i, str3, str4);
            this.mIsLoganInit = true;
            loganStatusCode("clogan_init", clogan_init);
        } catch (UnsatisfiedLinkError e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
            }
            loganStatusCode("clogan_init", -1060);
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_open(String str) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                int clogan_open = clogan_open(str);
                this.mIsLoganOpen = true;
                loganStatusCode("clogan_open", clogan_open);
            } catch (UnsatisfiedLinkError e) {
                if (com.oplus.log.b.a()) {
                    e.printStackTrace();
                }
                loganStatusCode("clogan_open", -2070);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_write(int i, String str, long j, String str2, long j2) {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                int clogan_write = clogan_write(i, str, j, str2, j2);
                if (clogan_write != -4010 || b.f10642a) {
                    loganStatusCode("clogan_write", clogan_write);
                }
            } catch (UnsatisfiedLinkError e) {
                if (com.oplus.log.b.a()) {
                    e.printStackTrace();
                }
                loganStatusCode("clogan_write", -4060);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void setOnLoganProtocolStatus(i iVar) {
        this.mLoganProtocolStatus = iVar;
    }
}
