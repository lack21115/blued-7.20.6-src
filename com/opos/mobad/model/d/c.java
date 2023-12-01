package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.provider.ad.AdEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f12721a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.provider.ad.a f12722c;

    private c(Context context) {
        this.b = context;
        this.f12722c = new com.opos.mobad.provider.ad.a(context);
    }

    public static final c a(Context context) {
        c cVar;
        c cVar2 = f12721a;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                c cVar3 = f12721a;
                cVar = cVar3;
                if (cVar3 == null) {
                    cVar = new c(context.getApplicationContext());
                    f12721a = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private List<com.opos.mobad.b.a.b> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream.available() > 0) {
            int readInt = dataInputStream.readInt();
            byte[] bArr2 = new byte[readInt];
            dataInputStream.read(bArr2, 0, readInt);
            arrayList.add(com.opos.mobad.b.a.b.f12020c.a(bArr2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.b.a.b bVar) {
        if (com.opos.cmn.an.h.c.a.e(this.b)) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            d.a(this.b, bVar, (Set<com.opos.mobad.model.b.e>) hashSet, false, (q) null);
            if (bVar.A != null && bVar.A.size() >= 0 && bVar.A.get(0) != null) {
                d.a(this.b, bVar.A.get(0), hashSet, hashSet2, false, null);
            }
            com.opos.cmn.an.f.a.b("acManager", "fm:" + hashSet.size() + ",om:" + hashSet2.size());
            if (hashSet.size() > 0) {
                boolean a2 = new j(this.b).a(hashSet, null);
                com.opos.cmn.an.f.a.b("acManager", "resource result:" + a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(List<com.opos.mobad.b.a.b> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (com.opos.mobad.b.a.b bVar : list) {
            byte[] b = com.opos.mobad.b.a.b.f12020c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.b>) bVar);
            dataOutputStream.writeInt(b.length);
            dataOutputStream.write(b);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public com.opos.mobad.model.b.d a(String str) throws Exception {
        AdEntity a2 = this.f12722c.a(str);
        if (a2 == null) {
            return null;
        }
        return new com.opos.mobad.model.b.d(com.opos.mobad.b.a.d.f12034c.a(a2.f13422a), a(a2.b), a2.f13423c);
    }

    public void a(final String str, final com.opos.mobad.model.b.d dVar, final List<com.opos.mobad.b.a.b> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("acManager", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    byte[] a2 = c.this.a(list);
                    c.this.f12722c.a(str, new AdEntity(com.opos.mobad.b.a.d.f12034c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), a2, dVar.i()));
                    c.this.a((com.opos.mobad.b.a.b) list.get(0));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("acManager", "cache fail", (Throwable) e);
                }
            }
        });
    }
}
