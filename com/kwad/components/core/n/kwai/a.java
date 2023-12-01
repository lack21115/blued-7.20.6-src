package com.kwad.components.core.n.kwai;

import android.text.TextUtils;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.f;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/kwai/a.class */
public final class a {
    public final b JW;
    public final com.kwad.components.core.n.b Or;
    public List<String> Os;
    public boolean Ot;
    public boolean Ou;
    public d Ov;

    /* renamed from: com.kwad.components.core.n.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/kwai/a$a.class */
    public static final class C0527a {
        public b JW;
        public com.kwad.components.core.n.b Or;
        public boolean Ot;
        public boolean Ou;

        public final C0527a a(com.kwad.components.core.n.b bVar) {
            this.Or = bVar;
            return this;
        }

        public final C0527a aG(boolean z) {
            this.Ot = true;
            return this;
        }

        public final C0527a aH(boolean z) {
            this.Ou = z;
            return this;
        }

        public final C0527a e(b bVar) {
            this.JW = bVar;
            return this;
        }

        public final a pj() {
            if (com.kwad.components.ad.d.a.bI.booleanValue() && (this.JW == null || this.Or == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }

    private a(C0527a c0527a) {
        this.JW = c0527a.JW;
        this.Or = c0527a.Or;
        this.Ot = c0527a.Ot;
        this.Ou = c0527a.Ou;
    }

    /* synthetic */ a(C0527a c0527a, byte b) {
        this(c0527a);
    }

    public static void a(a aVar, int i, String str, boolean z) {
        aVar.Or.a(i, str, z);
    }

    public static void a(a aVar, AdResultData adResultData, boolean z) {
        boolean isAdResultDataEmpty = adResultData.isAdResultDataEmpty();
        com.kwad.components.core.n.b bVar = aVar.Or;
        if (isAdResultDataEmpty) {
            bVar.a(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg, z);
        } else {
            bVar.a(adResultData, z);
        }
    }

    public final int getAdNum() {
        if (this.JW.Ow != null) {
            return this.JW.Ow.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        if (this.JW.Ow != null) {
            return this.JW.Ow.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        if (this.JW.Ow != null) {
            return this.JW.Ow.getPosId();
        }
        return -1L;
    }
}
