package com.opos.mobad.model.e;

import android.os.SystemClock;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/a.class */
public class a {

    /* renamed from: com.opos.mobad.model.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/a$a.class */
    public static class C0537a {

        /* renamed from: a  reason: collision with root package name */
        public final AdData f12794a;
        public final AdItemData b;

        /* renamed from: c  reason: collision with root package name */
        public final MaterialData f12795c;
        public final MaterialFileData d;
        public final long e;

        private C0537a(AdData adData, AdItemData adItemData, MaterialData materialData) {
            this(adData, adItemData, materialData, (MaterialFileData) null);
        }

        private C0537a(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData) {
            this.f12794a = adData;
            this.b = adItemData;
            this.f12795c = materialData;
            this.d = materialFileData;
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public static final C0537a a(AdData adData) {
        List<AdItemData> f;
        MaterialData materialData;
        MaterialFileData materialFileData;
        if (adData == null || (f = adData.f()) == null || f.size() <= 0) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= f.size()) {
                return null;
            }
            AdItemData adItemData = f.get(i2);
            if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0 && (materialData = adItemData.i().get(0)) != null) {
                int d = materialData.d();
                if ((d == 4 || d == 9 || d == 10 || d == 11 || d == 12 || d == 13) ? false : true) {
                    return new C0537a(adData, adItemData, materialData);
                }
                if (materialData.F() != null && materialData.F().size() > 0 && (materialFileData = materialData.F().get(0)) != null) {
                    return new C0537a(adData, adItemData, materialData, materialFileData);
                }
            }
            i = i2 + 1;
        }
    }
}
