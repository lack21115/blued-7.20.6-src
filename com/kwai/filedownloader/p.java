package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/p.class */
final class p extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.b.b> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/p$a.class */
    public static final class a extends a.AbstractBinderC0416a {
        protected a() {
        }

        @Override // com.kwai.filedownloader.b.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwai.filedownloader.message.e.Iv().s(messageSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Class<?> cls) {
        super(cls);
    }

    private static a Hl() {
        return new a();
    }

    private static com.kwai.filedownloader.b.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwai.filedownloader.b.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ a Hm() {
        return Hl();
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwai.filedownloader.b.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        if (isConnected()) {
            try {
                IF().b(str, str2, z, i, i2, i3, z2, bVar, z3);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.e.a.l(str, str2, z);
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ com.kwai.filedownloader.b.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i) {
        if (isConnected()) {
            try {
                return IF().cB(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.e.a.cB(i);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i) {
        if (isConnected()) {
            try {
                return IF().cC(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return (byte) 0;
            }
        }
        return com.kwai.filedownloader.e.a.cC(i);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i) {
        if (isConnected()) {
            try {
                return IF().cD(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.e.a.cD(i);
    }
}
