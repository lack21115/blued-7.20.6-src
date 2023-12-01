package com.kwad.components.core.webview.a.c;

import com.kwad.components.core.webview.a.d.e;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/c/a.class */
public final class a {
    private final Set<e> VG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/c/a$a.class */
    public static final class C0535a {
        private static final a VI = new a((byte) 0);
    }

    private a() {
        this.VG = new CopyOnWriteArraySet();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str) {
        if (this.VG.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.VG)) {
            eVar.u(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(String str) {
        if (this.VG.size() == 0) {
            return;
        }
        for (e eVar : new HashSet(this.VG)) {
            eVar.ad(str);
        }
    }

    public static a rn() {
        return C0535a.VI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.VG.add(eVar);
        }
    }

    public final void aS(final String str) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aQ(str);
            }
        });
    }

    public final void aT(final String str) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aR(str);
            }
        });
    }

    public final void b(e eVar) {
        this.VG.remove(eVar);
    }

    public final void ro() {
        this.VG.clear();
    }
}
