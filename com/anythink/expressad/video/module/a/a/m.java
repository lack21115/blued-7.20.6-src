package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/m.class */
public final class m extends o {
    public static final long ag = 3000;
    private AnythinkVideoView ai;
    private AnythinkContainerView aj;
    private int ak;
    private final com.anythink.core.common.i.a al;
    private boolean am;
    private boolean an;
    private int ao;
    private int ap;
    private final com.anythink.core.common.i.b aq;

    public m(AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, int i, int i2, com.anythink.expressad.video.module.a.a aVar, int i3, boolean z, int i4) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i3, z);
        this.al = com.anythink.core.common.i.c.a();
        this.am = false;
        this.an = false;
        boolean z2 = true;
        this.ao = 1;
        this.aq = new com.anythink.core.common.i.b() { // from class: com.anythink.expressad.video.module.a.a.m.1
            @Override // java.lang.Runnable
            public final void run() {
                m.this.aj.showVideoClickView(-1);
                m.this.ai.soundOperate(0, 2);
            }
        };
        this.ai = anythinkVideoView;
        this.aj = anythinkContainerView;
        this.ap = i;
        this.ak = i2;
        this.ao = i4;
        if (anythinkVideoView != null) {
            this.am = anythinkVideoView.getVideoSkipTime() != 0 ? false : z2;
        }
        if (anythinkVideoView == null || anythinkContainerView == null) {
            this.W = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r4.ai.mCurrPlayNum > 1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r5 > r4.X.i()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.am
            if (r0 == 0) goto L8
            return
        L8:
            r0 = r4
            com.anythink.expressad.video.module.AnythinkVideoView r0 = r0.ai
            if (r0 == 0) goto L97
            r0 = r4
            com.anythink.expressad.foundation.d.c r0 = r0.X
            if (r0 != 0) goto L17
            return
        L17:
            r0 = r4
            int r0 = r0.ak
            r7 = r0
            r0 = r7
            if (r0 < 0) goto L2b
            r0 = r5
            r1 = r7
            if (r0 < r1) goto L2b
            r0 = 2
            r8 = r0
            goto L2e
        L2b:
            r0 = 1
            r8 = r0
        L2e:
            r0 = r8
            r7 = r0
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L62
            r0 = r4
            com.anythink.expressad.foundation.d.c r0 = r0.X
            int r0 = r0.i()
            if (r0 != 0) goto L52
            r0 = r8
            r7 = r0
            r0 = r4
            com.anythink.expressad.video.module.AnythinkVideoView r0 = r0.ai
            int r0 = r0.mCurrPlayNum
            r1 = 1
            if (r0 <= r1) goto L62
            goto L60
        L52:
            r0 = r8
            r7 = r0
            r0 = r5
            r1 = r4
            com.anythink.expressad.foundation.d.c r1 = r1.X
            int r1 = r1.i()
            if (r0 <= r1) goto L62
        L60:
            r0 = 2
            r7 = r0
        L62:
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L83
            r0 = r7
            r8 = r0
            r0 = r4
            com.anythink.expressad.video.module.AnythinkVideoView r0 = r0.ai
            int r0 = r0.mCurrPlayNum
            r1 = 1
            if (r0 <= r1) goto L83
            r0 = r7
            r8 = r0
            r0 = r5
            r1 = r6
            if (r0 != r1) goto L83
            r0 = 2
            r8 = r0
        L83:
            r0 = r8
            r1 = 2
            if (r0 != r1) goto L97
            r0 = r4
            com.anythink.expressad.video.module.AnythinkVideoView r0 = r0.ai
            r1 = 0
            r2 = 2
            r0.closeVideoOperate(r1, r2)
            r0 = r4
            r1 = 1
            r0.am = r1
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.a.a.m.a(int, int):void");
    }

    private void g() {
        this.al.a(this.aq);
    }

    private void h() {
        g();
        this.al.a(this.aq, ag);
    }

    private void i() {
        int i;
        if (this.X == null || this.X.k() != 5) {
            return;
        }
        AnythinkVideoView anythinkVideoView = this.ai;
        com.anythink.expressad.foundation.d.c cVar = null;
        if (anythinkVideoView != null) {
            cVar = null;
            if (anythinkVideoView.mCampOrderViewData != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = 0;
                    if (i3 < this.ai.mCampOrderViewData.size()) {
                        if (this.ai.mCampOrderViewData.get(i3) != null && this.ai.mCampOrderViewData.get(i3).aZ() == this.X.aZ()) {
                            i = i3 - 1;
                            break;
                        }
                        i2 = i3 + 1;
                    } else {
                        break;
                    }
                }
                cVar = null;
                if (i >= 0) {
                    cVar = null;
                    if (this.ai.mCampOrderViewData.get(i) != null) {
                        cVar = this.ai.mCampOrderViewData.get(i);
                    }
                }
            }
        }
        if (cVar != null) {
            AnythinkVideoView anythinkVideoView2 = this.ai;
            if (anythinkVideoView2 != null) {
                anythinkVideoView2.setCampaign(cVar);
            }
            AnythinkContainerView anythinkContainerView = this.aj;
            if (anythinkContainerView != null) {
                anythinkContainerView.setCampaign(cVar);
            }
            a(cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0118, code lost:
        if (r5.ai.mCurrPlayNum > 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012a, code lost:
        if (r0 > r5.X.i()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012d, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b4, code lost:
        if (r0.f8500a == r0.b) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0237, code lost:
        if (r5.ao != 0) goto L88;
     */
    @Override // com.anythink.expressad.video.module.a.a.o, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 1539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.a.a.m.a(int, java.lang.Object):void");
    }
}
