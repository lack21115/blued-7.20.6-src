package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.ap;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/g.class */
public interface g extends d, Serializable {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/g$a.class */
    public static class a {
        public static g Code(String str) {
            Serializable V = ap.V(str);
            if (V instanceof AdContentData) {
                return new n((AdContentData) V);
            }
            return null;
        }

        public static String Code(g gVar) {
            if (gVar instanceof n) {
                return ap.Code(((n) gVar).Code);
            }
            return null;
        }
    }

    v B();

    k I();

    List<k> Z();

    boolean d_();

    List<String> n();
}
