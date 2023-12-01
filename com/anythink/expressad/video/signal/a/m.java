package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.video.module.AnythinkContainerView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/m.class */
public final class m extends f {
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private AnythinkContainerView f5679c;

    public m(Activity activity, AnythinkContainerView anythinkContainerView) {
        this.b = activity;
        this.f5679c = anythinkContainerView;
    }

    private static String a(List<com.anythink.expressad.foundation.d.c> list, String str, String str2, JSONObject jSONObject) {
        try {
            if (list.size() > 0) {
                com.anythink.expressad.foundation.h.b bVar = new com.anythink.expressad.foundation.h.b(com.anythink.expressad.foundation.b.a.b().d());
                Object b = com.anythink.expressad.foundation.d.c.b(list);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("campaignList", b);
                jSONObject2.put("device", bVar.a());
                jSONObject2.put("unit_id", str);
                jSONObject2.put("sdk_info", str2);
                jSONObject2.put("unitSetting", jSONObject);
                if (com.anythink.expressad.d.b.a() != null) {
                    com.anythink.expressad.d.b.a();
                    String a2 = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
                    if (!TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject3 = new JSONObject(a2);
                        try {
                            Context d = com.anythink.expressad.foundation.b.a.b().d();
                            String obj = v.b(d, "Anythink_ConfirmTitle".concat(String.valueOf(str)), "").toString();
                            String obj2 = v.b(d, "Anythink_ConfirmContent".concat(String.valueOf(str)), "").toString();
                            String obj3 = v.b(d, "Anythink_CancelText".concat(String.valueOf(str)), "").toString();
                            String obj4 = v.b(d, "Anythink_ConfirmText".concat(String.valueOf(str)), "").toString();
                            if (!TextUtils.isEmpty(obj)) {
                                jSONObject3.put(com.anythink.expressad.d.a.b.ct, obj);
                            }
                            if (!TextUtils.isEmpty(obj2)) {
                                jSONObject3.put(com.anythink.expressad.d.a.b.cu, obj2);
                            }
                            if (!TextUtils.isEmpty(obj3)) {
                                jSONObject3.put(com.anythink.expressad.d.a.b.cv, obj3);
                            }
                            if (!TextUtils.isEmpty(obj4)) {
                                jSONObject3.put(com.anythink.expressad.d.a.b.cx, obj4);
                            }
                            if (!TextUtils.isEmpty(obj4)) {
                                jSONObject3.put(com.anythink.expressad.d.a.b.cw, obj4);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.anythink.expressad.d.b.a();
                        String b2 = com.anythink.expressad.d.b.b(str);
                        if (!TextUtils.isEmpty(b2)) {
                            jSONObject3.put("ivreward", new JSONObject(b2));
                        }
                        jSONObject2.put("appSetting", jSONObject3);
                    }
                }
                return jSONObject2.toString();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            String obj = v.b(d, "Anythink_ConfirmTitle".concat(String.valueOf(str)), "").toString();
            String obj2 = v.b(d, "Anythink_ConfirmContent".concat(String.valueOf(str)), "").toString();
            String obj3 = v.b(d, "Anythink_CancelText".concat(String.valueOf(str)), "").toString();
            String obj4 = v.b(d, "Anythink_ConfirmText".concat(String.valueOf(str)), "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put(com.anythink.expressad.d.a.b.ct, obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cu, obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cv, obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cx, obj4);
            }
            if (TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put(com.anythink.expressad.d.a.b.cw, obj4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static com.anythink.expressad.videocommon.e.d c(String str) {
        if (com.anythink.expressad.videocommon.e.c.a() == null) {
            return null;
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str);
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final String a() {
        if (this.f5679c == null) {
            super.a();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f5679c.getCampaign());
                String unitID = this.f5679c.getUnitID();
                String str = com.anythink.expressad.out.b.f5227a + ",3.0.1";
                com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a() == null ? null : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), unitID);
                JSONObject jSONObject = new JSONObject();
                if (a2 != null) {
                    jSONObject = a2.R();
                }
                com.anythink.expressad.foundation.h.o.a("JSRewardVideoV1", "getEndScreenInfo success campaign = " + this.f5679c.getCampaign());
                return a(arrayList, unitID, str, jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.a();
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final void a(String str) {
        super.a(str);
        try {
            if (this.b == null || TextUtils.isEmpty(str) || !str.equals("click") || this.f5679c == null) {
                return;
            }
            this.f5679c.triggerCloseBtn(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final void b(String str) {
        super.b(str);
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(Camera.Parameters.SCENE_MODE_LANDSCAPE)) {
                this.b.setRequestedOrientation(0);
            } else if (str.equals(Camera.Parameters.SCENE_MODE_PORTRAIT)) {
                this.b.setRequestedOrientation(1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i, com.anythink.expressad.video.signal.h
    public final void handlerPlayableException(String str) {
        super.handlerPlayableException(str);
        try {
            if (this.b == null || TextUtils.isEmpty(str) || this.f5679c == null) {
                return;
            }
            this.f5679c.handlerPlayableException(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void install(com.anythink.expressad.foundation.d.c cVar) {
        super.install(cVar);
        AnythinkContainerView anythinkContainerView = this.f5679c;
        if (anythinkContainerView != null) {
            anythinkContainerView.install(cVar);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void notifyCloseBtn(int i) {
        super.notifyCloseBtn(i);
        AnythinkContainerView anythinkContainerView = this.f5679c;
        if (anythinkContainerView != null) {
            anythinkContainerView.notifyCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void orientation(Configuration configuration) {
        super.orientation(configuration);
        try {
            if (this.f5679c != null) {
                this.f5679c.orientation(configuration);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        AnythinkContainerView anythinkContainerView = this.f5679c;
        if (anythinkContainerView != null) {
            anythinkContainerView.toggleCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void webviewshow() {
        super.webviewshow();
        try {
            if (this.f5679c != null) {
                this.f5679c.webviewshow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
