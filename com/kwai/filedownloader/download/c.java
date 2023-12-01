package com.kwai.filedownloader.download;

import com.kwai.filedownloader.download.ConnectTask;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/c.class */
public final class c implements Runnable {
    private final String RZ;
    private final int aGL;
    private final ConnectTask aHH;
    private final f aHI;
    private e aHJ;
    final int aHK;
    private final boolean aHi;
    private volatile boolean lh;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/c$a.class */
    public static final class a {
        private String RZ;
        private Boolean aHF;
        private f aHI;
        private final ConnectTask.a aHL = new ConnectTask.a();
        private Integer aHM;

        public final c HV() {
            if (this.aHI == null || this.RZ == null || this.aHF == null || this.aHM == null) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("%s %s %B", this.aHI, this.RZ, this.aHF));
            }
            ConnectTask HE = this.aHL.HE();
            return new c(HE.aGL, this.aHM.intValue(), HE, this.aHI, this.aHF.booleanValue(), this.RZ, (byte) 0);
        }

        public final a a(f fVar) {
            this.aHI = fVar;
            return this;
        }

        public final a b(com.kwai.filedownloader.download.a aVar) {
            this.aHL.a(aVar);
            return this;
        }

        public final a bS(boolean z) {
            this.aHF = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwai.filedownloader.c.b bVar) {
            this.aHL.a(bVar);
            return this;
        }

        public final a cR(int i) {
            this.aHL.cQ(i);
            return this;
        }

        public final a d(Integer num) {
            this.aHM = num;
            return this;
        }

        public final a fq(String str) {
            this.aHL.fn(str);
            return this;
        }

        public final a fr(String str) {
            this.aHL.fo(str);
            return this;
        }

        public final a fs(String str) {
            this.RZ = str;
            return this;
        }
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.aGL = i;
        this.aHK = i2;
        this.lh = false;
        this.aHI = fVar;
        this.RZ = str;
        this.aHH = connectTask;
        this.aHi = z;
    }

    /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void Hf() {
        pause();
    }

    public final void pause() {
        this.lh = true;
        e eVar = this.aHJ;
        if (eVar != null) {
            eVar.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.c.run():void");
    }
}
