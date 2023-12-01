package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkVideoView;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/o.class */
public class o extends k {
    private boolean ag;
    protected int ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private Map<Integer, String> am;
    private int an;

    public o(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i, z);
        this.al = false;
        this.ah = 0;
        this.an = -1;
        if (this.W) {
            this.am = cVar.R();
        }
        this.ah = cVar.i();
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i, Object obj) {
        int i2;
        int i3;
        try {
            if (i != 2 && i != 6) {
                if (i != 7) {
                    int i4 = 0;
                    if (i == 11) {
                        com.anythink.expressad.videocommon.b.e.a().a(false);
                        b();
                        i2 = i;
                    } else if (i == 12) {
                        b();
                        com.anythink.expressad.videocommon.b.e.a().a(false);
                        i2 = i;
                    } else if (i == 15) {
                        e();
                        d();
                        c();
                        if (obj == null || !(obj instanceof AnythinkVideoView.a)) {
                            i3 = 0;
                        } else {
                            i3 = ((AnythinkVideoView.a) obj).f8500a;
                            i4 = ((AnythinkVideoView.a) obj).b;
                        }
                        int i5 = i4;
                        if (i4 == 0) {
                            i5 = i4;
                            if (this.X != null) {
                                i5 = this.X.bi();
                            }
                        }
                        com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.n.a().g(), this.X, i3, i5, this.af);
                        com.anythink.expressad.video.module.b.a.a(this.X, this.am, this.ac, i3);
                        if (!this.ak) {
                            this.ak = true;
                            com.anythink.expressad.video.module.b.a.a(this.X, this.ac);
                        }
                        i2 = i;
                        if (!this.al) {
                            if (this.ah != 0) {
                                i5 = this.ah;
                            }
                            i2 = i;
                            if (i3 >= i5) {
                                this.al = true;
                                i2 = 17;
                            }
                        }
                        this.an = i3;
                    } else if (i != 16) {
                        i2 = i;
                    }
                } else {
                    i2 = i;
                    if (this.W) {
                        i2 = i;
                        if (obj != null) {
                            i2 = i;
                            if (obj instanceof Integer) {
                                int intValue = ((Integer) obj).intValue();
                                if (intValue == 2) {
                                    i2 = i;
                                    if (!this.ai) {
                                        this.ai = true;
                                        com.anythink.expressad.video.module.b.a.b(com.anythink.core.common.b.n.a().g(), this.X);
                                        i2 = i;
                                    }
                                } else {
                                    i2 = i;
                                    if (intValue == 1) {
                                        i2 = i;
                                        if (!this.ag) {
                                            this.ag = true;
                                            com.anythink.expressad.video.module.b.a.c(com.anythink.core.common.b.n.a().g(), this.X);
                                            i2 = i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.ae.a(i2, obj);
            }
            i2 = i;
            if (this.W) {
                i2 = i;
                if (!this.aj) {
                    this.aj = true;
                    b();
                    com.anythink.expressad.video.module.b.a.d(com.anythink.core.common.b.n.a().g(), this.X);
                    i2 = i;
                }
            }
            this.ae.a(i2, obj);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b("NotifyListener", th.getMessage(), th);
        }
    }
}
