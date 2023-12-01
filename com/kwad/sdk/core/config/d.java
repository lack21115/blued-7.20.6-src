package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/d.class */
public class d {
    private static final AtomicBoolean adR = new AtomicBoolean(false);
    private static volatile SdkConfigData adS;

    public static boolean E(long j) {
        return (j & c.abW.getValue().longValue()) != 0;
    }

    public static double a(f fVar) {
        Double d = (Double) b(fVar);
        return (d != null ? d : fVar.uX()).doubleValue();
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        return (num != null ? num : kVar.uX()).intValue();
    }

    public static long a(m mVar) {
        Long l = (Long) b(mVar);
        return (l != null ? l : mVar.uX()).longValue();
    }

    public static String a(p pVar) {
        String str = (String) b(pVar);
        return str != null ? str : pVar.uX();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.uX();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        return (bool != null ? bool : dVar.uX()).booleanValue();
    }

    public static void aH(Context context) {
        synchronized (d.class) {
            try {
                if (adR.get()) {
                    return;
                }
                com.kwad.sdk.core.d.b.d("SdkConfigManager", "loadCache");
                c.init();
                tX();
                b.aG(context);
                uu();
                adR.set(true);
            } finally {
            }
        }
    }

    public static <T> T b(com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context CA = ServiceProvider.CA();
            b.a(CA, bVar);
            g.execute(new aw() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    d.aH(Context.this);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.uX();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        return num != null ? num.intValue() > 0 : kVar.uX().intValue() > 0;
    }

    public static void c(SdkConfigData sdkConfigData) {
        synchronized (d.class) {
            try {
                adS = sdkConfigData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getLogObiwanData() {
        return c.ado.getValue();
    }

    public static String getUserAgent() {
        return c.acX.getValue();
    }

    public static boolean gz() {
        return c.adj.getValue().booleanValue();
    }

    public static boolean isCanUseTk() {
        return a(c.acL);
    }

    public static boolean isLoaded() {
        return adR.get();
    }

    public static boolean sA() {
        return c.acv.getValue().intValue() == 1;
    }

    public static String sB() {
        return c.acJ.getImei();
    }

    public static String sC() {
        return c.acJ.getOaid();
    }

    public static List<String> sD() {
        return c.ace.getValue();
    }

    public static boolean sE() {
        return c.acW.getValue().intValue() == 1;
    }

    public static boolean sF() {
        return c.acY.getValue().intValue() == 1;
    }

    public static boolean sH() {
        return c.ads.getValue().booleanValue();
    }

    public static boolean sI() {
        return c.adt.getValue().booleanValue();
    }

    public static int sJ() {
        if (adS != null) {
            return adS.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int sK() {
        return c.adv.getValue().intValue();
    }

    public static boolean sL() {
        return c.adG.getValue().booleanValue();
    }

    public static double sM() {
        return c.adf.getValue().floatValue();
    }

    public static boolean sN() {
        return c.adJ.getValue().booleanValue();
    }

    public static int su() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.abH.getValue().intValue();
    }

    public static boolean sv() {
        return false;
    }

    public static boolean sw() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.abL.getValue().intValue() == 1;
    }

    public static boolean sx() {
        return c.acw.getValue().intValue() == 1;
    }

    public static boolean sy() {
        return c.acy.getValue().intValue() == 1;
    }

    public static boolean sz() {
        return c.acx.getValue().intValue() == 1;
    }

    public static boolean tV() {
        return c.abP.getValue().intValue() == 1;
    }

    public static int tW() {
        return c.abQ.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void tX() {
        com.kwad.components.ad.c.a.init();
        com.kwad.components.ad.feed.kwai.a.init();
        com.kwad.components.ad.fullscreen.kwai.a.init();
        com.kwad.components.ad.interstitial.kwai.a.init();
        com.kwad.components.ad.reward.kwai.a.init();
        com.kwad.components.ad.splashscreen.a.a.init();
    }

    public static List<String> tY() {
        return c.acg.getValue();
    }

    public static String tZ() {
        return c.acd.getValue();
    }

    public static int uA() {
        return c.abT.getValue().intValue();
    }

    public static int uB() {
        return c.ada.getValue().intValue();
    }

    public static int uC() {
        return c.acZ.getValue().intValue();
    }

    public static boolean uD() {
        return c.adb.getValue().intValue() == 1;
    }

    public static boolean uE() {
        return c.adc.getValue().booleanValue();
    }

    public static float uF() {
        float floatValue = c.add.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float uG() {
        return c.ade.getValue().floatValue();
    }

    public static boolean uH() {
        return c.adg.getValue().booleanValue();
    }

    public static boolean uI() {
        return c.adk.getValue().intValue() > 0;
    }

    public static boolean uJ() {
        return c.adq.getValue().intValue() == 1;
    }

    public static long uK() {
        return c.adp.getValue().longValue();
    }

    public static boolean uL() {
        return c.adu.vc();
    }

    public static com.kwad.sdk.core.network.idc.kwai.a uM() {
        return c.adw.getValue();
    }

    public static long uN() {
        return c.adx.getValue().longValue();
    }

    public static int uO() {
        return c.ady.getValue().intValue();
    }

    public static boolean uP() {
        return c.adz.getValue().floatValue() == 1.0f;
    }

    public static boolean uQ() {
        return c.adA.vc();
    }

    public static boolean uR() {
        return c.adC.vc();
    }

    public static String uS() {
        return c.adD.getValue();
    }

    public static String uT() {
        return c.adE.getValue();
    }

    public static String uU() {
        return c.adF.getValue();
    }

    public static int uV() {
        return c.adI.getValue().intValue();
    }

    public static boolean uW() {
        return c.adK.getValue().booleanValue();
    }

    public static List<String> ua() {
        return c.acf.getValue();
    }

    public static int ub() {
        return c.adB.getValue().intValue();
    }

    public static boolean uc() {
        return c.abY.getValue().booleanValue();
    }

    public static String ud() {
        return c.aca.getValue();
    }

    public static String ue() {
        return c.acb.getValue();
    }

    public static boolean uf() {
        return c.abM.getValue().intValue() == 1;
    }

    public static int ug() {
        return c.abN.getValue().intValue();
    }

    public static boolean uh() {
        return c.abO.getValue().intValue() == 1;
    }

    public static int ui() {
        return c.acn.getValue().intValue();
    }

    public static int uj() {
        return c.aco.getValue().intValue();
    }

    public static int uk() {
        return c.acp.getValue().intValue();
    }

    public static long ul() {
        return c.acq.getValue().intValue() * 60000;
    }

    public static boolean um() {
        return c.acz.getValue().intValue() == 1;
    }

    public static boolean un() {
        return c.acA.getValue().intValue() == 1;
    }

    public static int uo() {
        return c.acH.getValue().intValue();
    }

    public static boolean up() {
        return c.acI.getValue().booleanValue();
    }

    public static boolean uq() {
        return !c.acN.getValue().booleanValue();
    }

    public static boolean ur() {
        return a(c.acM);
    }

    public static boolean us() {
        return c.acP.getValue().intValue() == 1;
    }

    public static int ut() {
        return c.acQ.getValue().intValue();
    }

    public static SdkConfigData uu() {
        if (adS == null) {
            synchronized (d.class) {
                try {
                    if (adS == null) {
                        adS = new SdkConfigData();
                        String bX = y.bX(ServiceProvider.CA());
                        if (TextUtils.isEmpty(bX)) {
                            com.kwad.sdk.core.d.b.d("SdkConfigManager", "configCache is empty");
                        } else {
                            try {
                                adS.parseJson(new JSONObject(bX));
                            } catch (JSONException e) {
                                com.kwad.sdk.core.d.b.printStackTrace(e);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return adS;
    }

    public static boolean uv() {
        return c.abR.getValue().intValue() == 1;
    }

    public static boolean uw() {
        return c.abS.getValue().intValue() == 1;
    }

    public static int ux() {
        return c.abU.getValue().intValue();
    }

    public static boolean uy() {
        return c.abV.getValue().booleanValue();
    }

    public static boolean uz() {
        return c.adr.getValue().intValue() == 1;
    }
}
