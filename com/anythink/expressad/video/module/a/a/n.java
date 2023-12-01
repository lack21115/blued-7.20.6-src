package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkVideoView;
import com.anythink.expressad.video.signal.factory.IJSFactory;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/n.class */
public final class n extends o {
    private IJSFactory ag;
    private int ai;
    private boolean aj;
    private int ak;
    private boolean al;

    public n(IJSFactory iJSFactory, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, String str, String str2, int i, int i2, com.anythink.expressad.video.module.a.a aVar, int i3, boolean z, int i4) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i3, z);
        this.aj = false;
        this.al = false;
        this.ag = iJSFactory;
        this.ai = i;
        this.aj = i2 == 0;
        this.ak = i4;
        if (iJSFactory == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.o, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, Object obj) {
        int i2;
        int i3 = i;
        if (this.W) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        int i4 = 6;
                        if (i != 6) {
                            if (i != 8) {
                                if (i == 114) {
                                    i3 = i;
                                    if (this.ag.getJSCommon().m() == 2) {
                                        com.anythink.expressad.video.signal.j jSVideoModule = this.ag.getJSVideoModule();
                                        this.ag.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                        i3 = i;
                                    }
                                } else if (i != 116) {
                                    switch (i) {
                                        case 10:
                                            this.al = true;
                                            this.ag.getJSNotifyProxy().a(0);
                                            i3 = i;
                                            break;
                                        case 11:
                                        case 12:
                                            this.ag.getJSVideoModule().videoOperate(3);
                                            if (this.X.F() == 3) {
                                                this.ag.getJSVideoModule().setVisible(0);
                                            } else if (this.X.f() != 2) {
                                                this.ag.getJSVideoModule().setVisible(8);
                                            }
                                            if (i == 12) {
                                                f();
                                                i2 = 2;
                                            } else {
                                                i2 = 1;
                                            }
                                            this.ag.getJSNotifyProxy().a(i2);
                                            if (this.ag.getJSCommon().m() == 2) {
                                                this.ag.getJSVideoModule().setVisible(0);
                                                com.anythink.expressad.video.signal.j jSVideoModule2 = this.ag.getJSVideoModule();
                                                this.ag.getJSContainerModule().showMiniCard(jSVideoModule2.getBorderViewTop(), jSVideoModule2.getBorderViewLeft(), jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                            } else if (i == 12) {
                                                if (this.ak == 1) {
                                                    if (this.X.f() != 2) {
                                                        this.ag.getJSContainerModule().showEndcard(this.X.F());
                                                    } else {
                                                        this.ag.getJSContainerModule().showVideoEndCover();
                                                    }
                                                }
                                            } else if (this.X.f() != 2) {
                                                this.ag.getJSContainerModule().showEndcard(this.X.F());
                                            } else {
                                                this.ag.getJSContainerModule().showVideoEndCover();
                                            }
                                            this.ag.getJSVideoModule().dismissAllAlert();
                                            i3 = i;
                                            if (i == 12) {
                                                i3 = i;
                                                if (!this.al) {
                                                    i3 = i;
                                                    if (this.ak == 1) {
                                                        f();
                                                        e();
                                                        d();
                                                        c();
                                                        i3 = i;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 13:
                                            if (!this.ag.getJSVideoModule().isH5Canvas()) {
                                                this.ag.getJSVideoModule().closeVideoOperate(0, 2);
                                            }
                                            this.ag.getJSNotifyProxy().a(-1);
                                            i3 = i;
                                            break;
                                        case 14:
                                            i3 = i;
                                            if (!this.aj) {
                                                this.ag.getJSVideoModule().closeVideoOperate(0, 1);
                                                i3 = i;
                                                break;
                                            }
                                            break;
                                        case 15:
                                            i3 = i;
                                            if (obj != null) {
                                                i3 = i;
                                                if (obj instanceof AnythinkVideoView.a) {
                                                    this.aj = true;
                                                    this.ag.getJSNotifyProxy().a((AnythinkVideoView.a) obj);
                                                    i3 = i;
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            switch (i) {
                                                case 123:
                                                case 124:
                                                    com.anythink.expressad.video.signal.g jSNotifyProxy = this.ag.getJSNotifyProxy();
                                                    if (i == 123) {
                                                        i4 = 7;
                                                    }
                                                    jSNotifyProxy.a(i4, "");
                                                    i3 = i;
                                                    break;
                                                case 125:
                                                    this.ag.getJSContainerModule().hideAlertWebview();
                                                    i3 = i;
                                                    break;
                                                default:
                                                    i3 = i;
                                                    break;
                                            }
                                    }
                                } else {
                                    com.anythink.expressad.video.signal.j jSVideoModule3 = this.ag.getJSVideoModule();
                                    this.ag.getJSContainerModule().configurationChanged(jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                    i3 = i;
                                }
                            } else if (this.ag.getJSContainerModule().showAlertWebView()) {
                                this.ag.getJSVideoModule().alertWebViewShowed();
                                i3 = i;
                            } else {
                                this.ag.getJSVideoModule().showAlertView();
                                i3 = i;
                            }
                        }
                    } else {
                        i3 = i;
                        if (obj != null) {
                            i3 = i;
                            if (obj instanceof Integer) {
                                Integer num = ((Integer) obj).intValue() == 1 ? 2 : 1;
                                this.ag.getJSVideoModule().soundOperate(num.intValue(), -1);
                                this.ag.getJSNotifyProxy().a(5, String.valueOf(num));
                                i3 = i;
                            }
                        }
                    }
                }
                this.ag.getJSVideoModule().dismissAllAlert();
                if (i == 2) {
                    this.ag.getJSNotifyProxy().a(2, "");
                }
                this.ag.getJSVideoModule().videoOperate(3);
                if (this.ag.getJSCommon().m() != 2) {
                    if (this.X.F() != 3) {
                        this.ag.getJSVideoModule().setVisible(8);
                    } else {
                        this.ag.getJSVideoModule().setVisible(0);
                    }
                    if (this.ai == 2 && !this.ag.getJSContainerModule().endCardShowing() && this.X.f() != 2) {
                        this.ag.getJSContainerModule().showEndcard(this.X.F());
                        this.ag.getJSNotifyProxy().a(1);
                        i3 = i;
                    }
                }
                i = 16;
                this.ag.getJSNotifyProxy().a(1);
                i3 = i;
            } else {
                i3 = i;
                if (!this.ag.getJSContainerModule().endCardShowing()) {
                    this.ag.getJSNotifyProxy().a(1, "");
                    i3 = i;
                }
            }
        }
        super.a(i3, obj);
    }
}
