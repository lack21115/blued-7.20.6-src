package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.turingface.sdk.mfa.s5pTT;
import com.tencent.ugc.common.UGCConstants;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/kWj12.class */
public final class kWj12 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39964a = kC0XR.a(kC0XR.H0);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/kWj12$ShGzN.class */
    public static final class ShGzN {

        /* renamed from: a  reason: collision with root package name */
        public int f39965a;
        public F2BEC b;

        public ShGzN(int i, F2BEC f2bec) {
            this.f39965a = i;
            this.b = f2bec;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/kWj12$spXPg.class */
    public final class spXPg implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f39966a;
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f39967c;
        public final /* synthetic */ Context d;

        /* renamed from: com.tencent.turingface.sdk.mfa.kWj12$spXPg$spXPg  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/kWj12$spXPg$spXPg.class */
        public final class C1062spXPg extends Thread {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ IBinder f39968a;

            public C1062spXPg(IBinder iBinder) {
                this.f39968a = iBinder;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.tencent.turingface.sdk.mfa.s5pTT] */
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                s5pTT.spXPg.C1063spXPg c1063spXPg;
                int i;
                IBinder iBinder = this.f39968a;
                String str = s5pTT.spXPg.f39988a;
                if (iBinder == null) {
                    c1063spXPg = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    c1063spXPg = (queryLocalInterface == null || !(queryLocalInterface instanceof s5pTT)) ? new s5pTT.spXPg.C1063spXPg(iBinder) : (s5pTT) queryLocalInterface;
                }
                try {
                    if (c1063spXPg.a()) {
                        i = 0;
                    } else {
                        c1063spXPg.e();
                        i = 1;
                    }
                    ShGzN a2 = kWj12.a(c1063spXPg.d().b);
                    int i2 = i;
                    int i3 = a2.f39965a;
                    if (i3 != 0) {
                        spXPg.this.f39966a.set(Bi3eT.a(i3, i));
                    } else {
                        F2BEC f2bec = a2.b;
                        int i4 = i;
                        int i5 = i;
                        spXPg.this.f39966a.set(new Bi3eT(0, 200, System.currentTimeMillis() - spXPg.this.b, f2bec.h, c1063spXPg.b(), i));
                    }
                } catch (Throwable th) {
                    spXPg.this.f39966a.set(Bi3eT.a(UGCConstants.ERR_BGM_UNSUPPORT_AUDIO_CHANNEL, -1));
                }
                synchronized (spXPg.this.f39967c) {
                    spXPg.this.f39967c.notify();
                }
                if (G1g37.b.a(spXPg.this.d, "s_t_d_ask", false)) {
                    try {
                        c1063spXPg.c();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public spXPg(AtomicReference atomicReference, long j, Object obj, Context context) {
            this.f39966a = atomicReference;
            this.b = j;
            this.f39967c = obj;
            this.d = context;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new C1062spXPg(iBinder).start();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.f39966a.set(Bi3eT.a(-2004, -3));
            synchronized (this.f39967c) {
                this.f39967c.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
        if (r0.getCertificate("dddd" + r0) != null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:147:0x0311 -> B:78:0x024e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.Bi3eT a(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.kWj12.a(android.content.Context):com.tencent.turingface.sdk.mfa.Bi3eT");
    }

    public static ShGzN a(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            byte[] bArr2 = new byte[4];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 4);
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                i += (bArr2[i2] & 255) << (i2 * 8);
            }
            if (i > 1048576) {
                return new ShGzN(-3003, null);
            }
            byte[] bArr3 = new byte[i];
            int i3 = i + 4;
            if (bArr.length < i3) {
                return new ShGzN(-3004, null);
            }
            System.arraycopy((Object) bArr, 4, (Object) bArr3, 0, i);
            F2BEC f2bec = new F2BEC(new String(bArr3));
            int length = bArr.length - i3;
            if (length != 0) {
                byte[] bArr4 = new byte[length];
                System.arraycopy((Object) bArr, i3, (Object) bArr4, 0, length);
                Base64.encodeToString(bArr4, 2);
                return new ShGzN(0, f2bec);
            }
            return new ShGzN(-3005, null);
        }
        return new ShGzN(-3001, null);
    }

    public static Bi3eT b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(kC0XR.a(kC0XR.M0));
        intent.setPackage(kC0XR.a(kC0XR.N0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Bi3eT.a(UGCConstants.ERR_BGM_UNSUPPORT_SYSTEM, -1));
        if (context.getApplicationContext().bindService(intent, new spXPg(atomicReference, currentTimeMillis, obj, context), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException e) {
                }
            }
        } else {
            atomicReference.set(Bi3eT.a(UGCConstants.ERR_BGM_NO_AUDIO_TRACK, -1));
        }
        return (Bi3eT) atomicReference.get();
    }
}
