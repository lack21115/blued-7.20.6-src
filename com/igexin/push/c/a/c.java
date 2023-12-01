package com.igexin.push.c.a;

import com.heytap.mcssdk.constant.IntentConstant;
import com.igexin.c.a.b.a.a.h;
import com.igexin.c.a.b.d;
import com.igexin.push.c.c.e;
import com.igexin.push.f.g;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/a/c.class */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23324a = c.class.getName();
    public static int b = -1;
    private byte[] g;

    private c(String str) {
        super(str, (byte) 0);
    }

    private static byte a(h hVar) throws IOException {
        return (byte) b(hVar, 1);
    }

    public static d a() {
        c cVar = new c("socketProtocol");
        new a(IntentConstant.COMMAND, cVar);
        return cVar;
    }

    private static e a(com.igexin.push.c.c.a aVar) {
        e eVar = new e();
        eVar.b = e.f23338a;
        eVar.a(aVar.f23330c);
        eVar.f = aVar.b > 0 ? 1 : 0;
        eVar.d = 7;
        eVar.f23339c = 11;
        eVar.g = aVar.d;
        eVar.f23339c += g.c().length;
        if (aVar.f23329a <= 0) {
            if (eVar.i == 0) {
                eVar.p = 0;
            }
            com.igexin.c.a.b.e.c();
            return eVar;
        }
        eVar.q = g.e();
        eVar.r = (int) (System.currentTimeMillis() / 1000);
        eVar.o = g.a(aVar, eVar.q, eVar.r);
        eVar.p = eVar.o.length;
        eVar.f23339c += eVar.p;
        com.igexin.c.a.b.e.c();
        return eVar;
    }

    private static Object a(h hVar, e eVar) throws Exception {
        if (eVar.i == 48) {
            com.igexin.c.a.c.a.a(f23324a, "decodeAes, encryptType = 0x30, return");
            return null;
        }
        byte b2 = (byte) b(hVar, 1);
        if (b2 > 0) {
            a(hVar, b2);
        }
        eVar.g = (byte) b(hVar, 1);
        eVar.p = (byte) b(hVar, 1);
        if (eVar.p > 0) {
            eVar.o = a(hVar, eVar.p);
        }
        if (eVar.f == 0) {
            com.igexin.push.c.c.a aVar = new com.igexin.push.c.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] a2 = a(hVar, 11);
        int c2 = com.igexin.c.a.b.g.c(a2, 0);
        if (c2 <= b) {
            b = -1;
            throw new Exception("server packetId can't be less than previous");
        }
        b = c2;
        int c3 = com.igexin.c.a.b.g.c(a2, 4);
        short a3 = com.igexin.c.a.b.g.a(a2, 8);
        int i = a2[10] & 255;
        com.igexin.push.c.c.a aVar2 = new com.igexin.push.c.c.a();
        aVar2.f23329a = a3;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        aVar2.g = eVar.i;
        if (a3 > 0) {
            byte[] a4 = a(hVar, a3);
            if (eVar.i == 16) {
                a4 = g.d(a4, g.b(com.igexin.c.a.b.g.b(c3)));
            } else if (eVar.i == 32) {
                if (i != 26) {
                    return null;
                }
                com.igexin.c.a.c.a.a(f23324a, "decodeAes, encryptType = 0x20, special");
                a4 = g.e(a4, com.igexin.c.a.b.g.b(c3));
            } else if (eVar.i != 0) {
                byte b3 = eVar.i;
                return null;
            }
            if (eVar.h == Byte.MIN_VALUE) {
                a4 = com.igexin.c.a.b.g.b(a4);
            } else if (eVar.h != 0) {
                return null;
            }
            aVar2.a(a4);
            if (!Arrays.equals(eVar.o, g.a(aVar2, c2, c3))) {
                com.igexin.c.a.c.a.a(f23324a, "decode signature error!!!!");
                com.igexin.c.a.c.a.a(f23324a + "|decode signature error!!!!", new Object[0]);
                return null;
            }
        } else if (aVar2.f23329a < 0) {
            com.igexin.c.a.c.a.a(f23324a, "data len < 0, error");
            com.igexin.c.a.c.a.a(f23324a + "|data len < 0, error", new Object[0]);
            return null;
        }
        return aVar2;
    }

    private static byte[] a(h hVar, int i) throws IOException {
        byte[] bArr = new byte[i];
        hVar.a(bArr);
        return bArr;
    }

    private static int b(h hVar, int i) throws IOException {
        byte[] a2 = a(hVar, i);
        if (i == 1) {
            return a2[0] & 255;
        }
        if (i == 2) {
            return com.igexin.c.a.b.g.a(a2, 0);
        }
        if (i == 4) {
            return com.igexin.c.a.b.g.c(a2, 0);
        }
        return 0;
    }

    private Object b(h hVar, e eVar) throws Exception {
        byte b2;
        if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
            this.g = a(hVar, b2);
        }
        if (eVar.f == 0) {
            com.igexin.push.c.c.a aVar = new com.igexin.push.c.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] a2 = a(hVar, 3);
        short a3 = com.igexin.c.a.b.g.a(a2, 0);
        int i = a2[2] & 255;
        com.igexin.push.c.c.a aVar2 = new com.igexin.push.c.c.a();
        aVar2.f23329a = a3;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        if (i != 26) {
            com.igexin.c.a.c.a.a(f23324a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
            return null;
        }
        if (aVar2.f23329a > 0) {
            byte[] a4 = a(hVar, a3);
            byte[] bArr = a4;
            if (eVar.i == 48) {
                byte[] bArr2 = this.g;
                bArr = com.igexin.c.a.a.a.a(a4, bArr2 == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr2));
            }
            if (eVar.h == Byte.MIN_VALUE) {
                bArr = com.igexin.c.a.b.g.b(bArr);
            } else if (eVar.h != 0) {
                return null;
            }
            aVar2.a(bArr);
        }
        return aVar2;
    }

    private static short b(h hVar) throws IOException {
        return (short) b(hVar, 2);
    }

    private static int c(h hVar) throws IOException {
        return b(hVar, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x033a  */
    @Override // com.igexin.c.a.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 909
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.a.c.a(java.lang.Object):java.lang.Object");
    }

    @Override // com.igexin.c.a.b.d
    public final Object b(Object obj) throws Exception {
        com.igexin.push.c.c.a aVar;
        byte b2;
        h hVar = obj instanceof h ? (h) obj : null;
        if (hVar == null) {
            com.igexin.c.a.c.a.a(f23324a, "syncIns is null");
            com.igexin.c.a.c.a.a(f23324a + "|syncIns is null", new Object[0]);
            return null;
        }
        byte[] a2 = a(hVar, 8);
        if (com.igexin.c.a.b.g.c(a2, 0) != 1944742139) {
            return null;
        }
        e eVar = new e();
        eVar.f23339c = a2[4] & 255;
        eVar.d = a2[5] & 255;
        eVar.a(a2[6]);
        eVar.f = a2[7] & 255;
        if (eVar.d == 7) {
            if (eVar.i == 48) {
                com.igexin.c.a.c.a.a(f23324a, "decodeAes, encryptType = 0x30, return");
                return null;
            }
            byte b3 = (byte) b(hVar, 1);
            if (b3 > 0) {
                a(hVar, b3);
            }
            eVar.g = (byte) b(hVar, 1);
            eVar.p = (byte) b(hVar, 1);
            if (eVar.p > 0) {
                eVar.o = a(hVar, eVar.p);
            }
            if (eVar.f != 0) {
                byte[] a3 = a(hVar, 11);
                int c2 = com.igexin.c.a.b.g.c(a3, 0);
                if (c2 <= b) {
                    b = -1;
                    throw new Exception("server packetId can't be less than previous");
                }
                b = c2;
                int c3 = com.igexin.c.a.b.g.c(a3, 4);
                short a4 = com.igexin.c.a.b.g.a(a3, 8);
                int i = a3[10] & 255;
                com.igexin.push.c.c.a aVar2 = new com.igexin.push.c.c.a();
                aVar2.f23329a = a4;
                aVar2.b = (byte) i;
                aVar2.f = eVar.d;
                aVar2.g = eVar.i;
                if (a4 > 0) {
                    byte[] a5 = a(hVar, a4);
                    if (eVar.i == 16) {
                        a5 = g.d(a5, g.b(com.igexin.c.a.b.g.b(c3)));
                    } else if (eVar.i == 32) {
                        if (i != 26) {
                            return null;
                        }
                        com.igexin.c.a.c.a.a(f23324a, "decodeAes, encryptType = 0x20, special");
                        a5 = g.e(a5, com.igexin.c.a.b.g.b(c3));
                    } else if (eVar.i != 0) {
                        byte b4 = eVar.i;
                        return null;
                    }
                    if (eVar.h == Byte.MIN_VALUE) {
                        a5 = com.igexin.c.a.b.g.b(a5);
                    } else if (eVar.h != 0) {
                        return null;
                    }
                    aVar2.a(a5);
                    if (!Arrays.equals(eVar.o, g.a(aVar2, c2, c3))) {
                        com.igexin.c.a.c.a.a(f23324a, "decode signature error!!!!");
                        com.igexin.c.a.c.a.a(f23324a + "|decode signature error!!!!", new Object[0]);
                        return null;
                    }
                } else if (aVar2.f23329a < 0) {
                    com.igexin.c.a.c.a.a(f23324a, "data len < 0, error");
                    com.igexin.c.a.c.a.a(f23324a + "|data len < 0, error", new Object[0]);
                    return null;
                }
                return aVar2;
            }
            aVar = new com.igexin.push.c.c.a();
        } else if (eVar.d != 1) {
            String str = f23324a;
            com.igexin.c.a.c.a.a(str, "server socket resp version = " + eVar.d + ", not support!!!");
            com.igexin.c.a.c.a.a(f23324a + "|server socket resp version = " + eVar.d + ", not support !!!", new Object[0]);
            return null;
        } else {
            if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
                this.g = a(hVar, b2);
            }
            if (eVar.f != 0) {
                byte[] a6 = a(hVar, 3);
                short a7 = com.igexin.c.a.b.g.a(a6, 0);
                int i2 = a6[2] & 255;
                com.igexin.push.c.c.a aVar3 = new com.igexin.push.c.c.a();
                aVar3.f23329a = a7;
                aVar3.b = (byte) i2;
                aVar3.f = eVar.d;
                if (i2 != 26) {
                    com.igexin.c.a.c.a.a(f23324a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
                    return null;
                }
                if (aVar3.f23329a > 0) {
                    byte[] a8 = a(hVar, a7);
                    byte[] bArr = a8;
                    if (eVar.i == 48) {
                        byte[] bArr2 = this.g;
                        bArr = com.igexin.c.a.a.a.a(a8, bArr2 == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr2));
                    }
                    if (eVar.h == Byte.MIN_VALUE) {
                        bArr = com.igexin.c.a.b.g.b(bArr);
                    } else if (eVar.h != 0) {
                        return null;
                    }
                    aVar3.a(bArr);
                }
                return aVar3;
            }
            aVar = new com.igexin.push.c.c.a();
        }
        aVar.f = eVar.d;
        aVar.b = (byte) 0;
        return aVar;
    }
}
