package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/a/b.class */
public final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(com.kwad.sdk.core.diskcache.kwai.a aVar, String str) {
        try {
            a.c bF = aVar.bF(str);
            if (bF != null) {
                return bF.aZ(0);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final com.kwad.sdk.core.diskcache.kwai.a aVar, final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStream = null;
                OutputStream outputStream2 = null;
                OutputStream outputStream3 = null;
                try {
                    a.C0557a bG = com.kwad.sdk.core.diskcache.kwai.a.this.bG(str2);
                    if (bG != null) {
                        outputStream = bG.aW(0);
                        if (b.a(str, outputStream, new a.C0564a())) {
                            bG.commit();
                        } else {
                            bG.abort();
                        }
                        outputStream2 = outputStream;
                        outputStream3 = outputStream;
                        com.kwad.sdk.core.diskcache.kwai.a.this.flush();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (IOException e) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream3);
                } catch (Throwable th) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(com.kwad.sdk.core.diskcache.kwai.a aVar, String str, String str2, a.C0564a c0564a) {
        OutputStream outputStream;
        boolean z = false;
        OutputStream outputStream2 = null;
        boolean z2 = false;
        OutputStream outputStream3 = null;
        try {
            try {
                a.C0557a bG = aVar.bG(str2);
                outputStream = null;
                if (bG != null) {
                    outputStream = bG.aW(0);
                    if (a(str, outputStream, c0564a)) {
                        bG.commit();
                        z = true;
                    } else {
                        bG.abort();
                        z = false;
                    }
                    outputStream2 = outputStream;
                    z2 = z;
                    outputStream3 = outputStream;
                    aVar.flush();
                }
            } catch (IOException e) {
                c0564a.msg = e.getMessage();
                z = z2;
                outputStream = outputStream3;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            return z;
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
            throw th;
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0564a c0564a) {
        return com.kwad.sdk.core.network.kwai.a.a(str, outputStream, c0564a, -1);
    }
}
