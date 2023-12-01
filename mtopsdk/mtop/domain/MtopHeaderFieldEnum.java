package mtopsdk.mtop.domain;

import com.alipay.sdk.cons.b;
import com.anythink.core.common.g.c;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/MtopHeaderFieldEnum.class */
public enum MtopHeaderFieldEnum {
    ACT("x-act", "accessToken"),
    WUAT("x-wuat", "wua"),
    SID("x-sid", "sid"),
    TIME("x-t", "t"),
    APPKEY("x-appkey", "appKey"),
    TTID("x-ttid", "ttid"),
    UTDID("x-utdid", b.g),
    SIGN("x-sign", c.Y),
    NQ("x-nq", "nq"),
    NETTYPE("x-nettype", "netType"),
    PV("x-pv", "pv"),
    UID("x-uid", "uid"),
    UMID("x-umt", "umt"),
    MTOP_FEATURE("x-features", "x-features"),
    X_APP_VER("x-app-ver", "x-app-ver"),
    USER_AGENT("user-agent", "user-agent");
    
    private String q;
    private String r;

    MtopHeaderFieldEnum(String str, String str2) {
        this.q = str;
        this.r = str2;
    }

    public final String a() {
        return this.q;
    }

    public final String b() {
        return this.r;
    }
}
