package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/c.class */
public final class c {
    public static String sb() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.wm().C("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String sc() {
        return sb() + "/rest/e/v3/open/univ";
    }

    public static String sd() {
        return sb() + "/rest/e/v4/open/univ";
    }

    public static String se() {
        return sb() + "/rest/e/v4/open/univ/bidding";
    }

    public static String sf() {
        return sb() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String sg() {
        return sb() + "/rest/e/v3/open/logBatch";
    }

    public static String sh() {
        return sb() + "/rest/e/v3/open/config";
    }

    public static String si() {
        return sb() + "/rest/e/v3/open/callback";
    }

    public static String sj() {
        return sb() + "/rest/e/v3/open/crashLog";
    }

    public static String sk() {
        return sb() + "/rest/e/v3/open/appCheck";
    }

    public static String sl() {
        return sb() + "/rest/e/v3/open/collect";
    }

    public static String sm() {
        return sb() + "/rest/e/v3/open/checkReward";
    }
}
