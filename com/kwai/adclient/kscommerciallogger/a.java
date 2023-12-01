package com.kwai.adclient.kscommerciallogger;

import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/a.class */
public final class a {
    private com.kwai.adclient.kscommerciallogger.kwai.a aDQ;
    private com.kwai.adclient.kscommerciallogger.kwai.b aDR;
    private JSONObject aDS;
    private boolean aDT;
    private boolean isDebug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/a$a.class */
    public static final class C0582a {
        private static a aDU;

        public static a FS() {
            if (aDU == null) {
                aDU = new a((byte) 0);
            }
            return aDU;
        }
    }

    private a() {
        this.isDebug = false;
        this.aDT = false;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a FS() {
        return C0582a.FS();
    }

    private void d(c cVar) {
        com.kwai.adclient.kscommerciallogger.kwai.a aVar = this.aDQ;
        if (aVar != null) {
            String tag = cVar.getTag();
            String str = cVar.FW() == null ? "" : cVar.FW().value;
            if (cVar.FX() != null) {
                String str2 = cVar.FX().value;
            }
            if (cVar.FY() != null) {
                cVar.FY().getValue();
            }
            cVar.Gb();
            b.O(cVar.FZ());
            b.O(cVar.Ga());
            aVar.F(tag, str);
        }
    }

    public final JSONObject FT() {
        return this.aDS;
    }

    public final boolean FU() {
        return this.aDT;
    }

    public final void a(com.kwai.adclient.kscommerciallogger.kwai.a aVar, com.kwai.adclient.kscommerciallogger.kwai.b bVar, JSONObject jSONObject, boolean z, boolean z2) {
        this.aDQ = aVar;
        this.aDR = bVar;
        this.aDS = null;
        this.isDebug = z;
        this.aDT = z2;
    }

    public final void c(c cVar) {
        if (cVar == null) {
            this.aDQ.G("KSCommercialLogger", "rl rtLog is null please check it");
            return;
        }
        d(cVar);
        com.kwai.adclient.kscommerciallogger.kwai.b bVar = this.aDR;
        if (bVar != null) {
            bVar.H(cVar.FV(), cVar.toString());
        }
    }

    public final boolean isDebug() {
        return this.isDebug;
    }
}
