package com.ishumei.l111l1111l1Il;

import com.ishumei.l111l11111lIl.l111l1111llIl;
import com.ishumei.smantifraud.SmAntiFraud;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111l1Il/l1111l111111Il.class */
public class l1111l111111Il {
    private int l1111l111111Il;
    private int l111l11111I1l;
    private int l111l11111Il;
    private int l111l11111lIl;
    private String l111l1111l1Il;
    private byte[] l111l1111lI1l;
    private boolean l111l1111lIl;
    private String[] l111l1111llIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ishumei.l111l1111l1Il.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111l1Il/l1111l111111Il$l1111l111111Il.class */
    public static final class C0460l1111l111111Il {
        private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte) 0);

        private C0460l1111l111111Il() {
        }
    }

    private l1111l111111Il() {
        this.l1111l111111Il = 1;
        this.l111l11111lIl = 60;
        this.l111l11111I1l = 60;
        this.l111l11111Il = 0;
        this.l111l1111l1Il = null;
        this.l111l1111llIl = null;
        this.l111l1111lI1l = null;
        this.l111l1111lIl = false;
        l11l1111I11l();
    }

    /* synthetic */ l1111l111111Il(byte b) {
        this();
    }

    public static l1111l111111Il l1111l111111Il(String str) {
        l1111l111111Il unused = C0460l1111l111111Il.l1111l111111Il;
        l1111l111111Il l1111l111111il = C0460l1111l111111Il.l1111l111111Il;
        l1111l111111Il l1111l111111il2 = new l1111l111111Il();
        l1111l111111il2.l111l1111lIl = l1111l111111il.l111l1111lIl;
        l1111l111111il2.l111l11111lIl = l1111l111111il.l111l11111lIl;
        l1111l111111il2.l111l11111I1l = l1111l111111il.l111l11111I1l;
        l1111l111111il2.l111l1111llIl = l1111l111111il.l111l1111llIl;
        l1111l111111il2.l111l1111lI1l = l1111l111111il.l111l1111lI1l;
        l1111l111111il2.l111l11111Il = l1111l111111il.l111l11111Il;
        l1111l111111il2.l1111l111111Il = str.startsWith("https://") ? 0 : 1;
        l1111l111111il2.l111l1111l1Il = str;
        return l1111l111111il2;
    }

    public static l1111l111111Il l1111l111111Il(String str, byte[] bArr, boolean z) {
        l1111l111111Il l1111l111111il = new l1111l111111Il();
        l1111l111111il.l11l1111I11l();
        if (str.startsWith("https://")) {
            l1111l111111il.l1111l111111Il = 0;
            if (bArr != null) {
                l1111l111111il.l111l1111lI1l = bArr;
            }
        } else {
            l1111l111111il.l1111l111111Il = 1;
        }
        l1111l111111il.l111l1111l1Il = str;
        l1111l111111il.l111l1111lIl = z;
        return l1111l111111il;
    }

    private void l1111l111111Il(int i) {
        this.l111l11111lIl = i;
    }

    public static void l1111l111111Il(SmAntiFraud.SmOption smOption) {
        l1111l111111Il l1111l111111il = C0460l1111l111111Il.l1111l111111Il;
        if (smOption.l111l1111l1Il() != null) {
            l1111l111111il.l111l1111lI1l = smOption.l111l1111l1Il();
        }
        l1111l111111il.l111l1111lIl = smOption.l111l11111Il();
    }

    private void l1111l111111Il(boolean z) {
        this.l111l1111lIl = z;
    }

    private void l1111l111111Il(byte[] bArr) {
        this.l111l1111lI1l = bArr;
    }

    private void l1111l111111Il(String[] strArr) {
        this.l111l1111llIl = strArr;
    }

    private void l111l11111I1l(int i) {
        this.l1111l111111Il = i;
    }

    private void l111l11111Il(int i) {
        this.l111l11111Il = i;
    }

    private void l111l11111lIl(int i) {
        this.l111l11111I1l = i;
    }

    private void l111l11111lIl(String str) {
        this.l111l1111l1Il = str;
    }

    private void l11l1111I11l() {
        this.l111l1111llIl = l111l1111llIl.l111l11111Il;
        this.l111l11111lIl = 4;
        this.l111l11111I1l = 30;
        this.l111l11111Il = 0;
        this.l111l1111lI1l = l111l1111llIl.l111l1111l1Il;
    }

    private static l1111l111111Il l11l1111I1l() {
        l1111l111111Il l1111l111111il = C0460l1111l111111Il.l1111l111111Il;
        l1111l111111Il l1111l111111il2 = new l1111l111111Il();
        l1111l111111il2.l111l1111lIl = l1111l111111il.l111l1111lIl;
        l1111l111111il2.l111l11111lIl = l1111l111111il.l111l11111lIl;
        l1111l111111il2.l111l11111I1l = l1111l111111il.l111l11111I1l;
        l1111l111111il2.l111l1111llIl = l1111l111111il.l111l1111llIl;
        l1111l111111il2.l111l1111lI1l = l1111l111111il.l111l1111lI1l;
        l1111l111111il2.l111l11111Il = l1111l111111il.l111l11111Il;
        return l1111l111111il2;
    }

    private static l1111l111111Il l11l1111lIIl() {
        return C0460l1111l111111Il.l1111l111111Il;
    }

    public final boolean l1111l111111Il() {
        return this.l111l1111lIl;
    }

    public final int l111l11111I1l() {
        return this.l111l11111I1l;
    }

    public final int l111l11111Il() {
        return this.l1111l111111Il;
    }

    public final int l111l11111lIl() {
        return this.l111l11111lIl;
    }

    public final String l111l1111l1Il() {
        return this.l111l1111l1Il;
    }

    public final byte[] l111l1111lI1l() {
        return this.l111l1111lI1l;
    }

    public final int l111l1111lIl() {
        return this.l111l11111Il;
    }

    public final String[] l111l1111llIl() {
        return this.l111l1111llIl;
    }
}
