package com.anythink.expressad.exoplayer.d;

import android.media.MediaCrypto;
import android.media.MediaDrm;
import com.anythink.expressad.exoplayer.d.j;
import com.anythink.expressad.exoplayer.k.af;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/l.class */
public final class l implements j<k> {
    private static final String g = "cenc";
    private final UUID h;
    private final MediaDrm i;

    private l(UUID uuid) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        com.anythink.expressad.exoplayer.k.a.a(!com.anythink.expressad.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        UUID uuid2 = uuid;
        if (af.f7632a < 27) {
            uuid2 = uuid;
            if (com.anythink.expressad.exoplayer.b.bj.equals(uuid)) {
                uuid2 = com.anythink.expressad.exoplayer.b.bi;
            }
        }
        this.h = uuid2;
        this.i = new MediaDrm(uuid2);
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid2) && "ASUS_Z00AD".equals(af.d)) {
            this.i.setPropertyString("securityLevel", "L3");
        }
    }

    public static l a(UUID uuid) {
        try {
            return new l(uuid);
        } catch (Exception e) {
            throw new o(e);
        }
    }

    private static boolean d() {
        return "ASUS_Z00AD".equals(af.d);
    }

    private k e(byte[] bArr) {
        return new k(new MediaCrypto(this.h, bArr), af.f7632a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.h) && "L3".equals(a("securityLevel")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
        if (com.anythink.expressad.exoplayer.k.o.q.equals(r10) != false) goto L16;
     */
    @Override // com.anythink.expressad.exoplayer.d.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.d.j.d a(byte[] r8, byte[] r9, java.lang.String r10, int r11, java.util.HashMap<java.lang.String, java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.d.l.a(byte[], byte[], java.lang.String, int, java.util.HashMap):com.anythink.expressad.exoplayer.d.j$d");
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final String a(String str) {
        return this.i.getPropertyString(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(final j.f<? super k> fVar) {
        this.i.setOnEventListener(new MediaDrm.OnEventListener() { // from class: com.anythink.expressad.exoplayer.d.l.1
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                fVar.a(bArr, i);
            }
        });
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(final j.g<? super k> gVar) {
        if (af.f7632a < 23) {
            throw new UnsupportedOperationException();
        }
        this.i.setOnKeyStatusChangeListener(gVar == null ? null : new MediaDrm.OnKeyStatusChangeListener() { // from class: com.anythink.expressad.exoplayer.d.l.2
            @Override // android.media.MediaDrm.OnKeyStatusChangeListener
            public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List<MediaDrm.KeyStatus> list, boolean z) {
                ArrayList arrayList = new ArrayList();
                for (MediaDrm.KeyStatus keyStatus : list) {
                    arrayList.add(new j.b(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                }
            }
        }, null);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(String str, String str2) {
        this.i.setPropertyString(str, str2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(String str, byte[] bArr) {
        this.i.setPropertyByteArray(str, bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(byte[] bArr) {
        this.i.closeSession(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a() {
        return this.i.openSession();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr2;
        if (com.anythink.expressad.exoplayer.b.bj.equals(this.h)) {
            bArr3 = a.a(bArr2);
        }
        return this.i.provideKeyResponse(bArr, bArr3);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final j.h b() {
        MediaDrm.ProvisionRequest provisionRequest = this.i.getProvisionRequest();
        return new j.c(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr) {
        this.i.provideProvisionResponse(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr, byte[] bArr2) {
        this.i.restoreKeys(bArr, bArr2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] b(String str) {
        return this.i.getPropertyByteArray(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final Map<String, String> c(byte[] bArr) {
        return this.i.queryKeyStatus(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void c() {
        this.i.release();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final /* synthetic */ k d(byte[] bArr) {
        return new k(new MediaCrypto(this.h, bArr), af.f7632a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.h) && "L3".equals(a("securityLevel")));
    }
}
