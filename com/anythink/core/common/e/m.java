package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.c.k;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/m.class */
public final class m extends l implements Comparable<m> {
    private boolean A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    public int a;
    public String b;
    public String c;
    public int d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public double l;
    public String m;
    public int n;
    public double o;
    public String p;
    public double q;
    public com.anythink.core.b.c.a r;
    public boolean s;
    private final String t;
    private boolean u;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private final String z;

    public m(boolean z, double d, String str, String str2, String str3, String str4, String str5) {
        super(z, d, str, str2, str3, str4, str5, ATAdConst.CURRENCY.USD);
        this.t = getClass().getSimpleName() + ":";
        this.v = "${AUCTION_PRICE}";
        this.w = "${AUCTION_LOSS}";
        this.x = "${AUCTION_SEAT_ID}";
        this.y = "${AUCTION_BID_TO_WIN}";
        this.z = "${AUCTION_CURRENCY}";
    }

    private int a(m mVar) {
        if (mVar == null) {
            return -1;
        }
        double d = 0.0d;
        double a = this.sortPrice == 0.0d ? com.anythink.core.b.f.a().a(this.g, this.k) : this.sortPrice;
        if (mVar != null) {
            d = mVar.sortPrice == 0.0d ? com.anythink.core.b.f.a().a(mVar.g, mVar.k) : mVar.sortPrice;
        }
        return a > d ? -1 : 1;
    }

    private int a(boolean z, int i) {
        int i2 = this.d;
        return i == i2 ? !z ? 1 : 4 : (i == 67 || i2 == 35) ? 3 : 2;
    }

    public static m a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            m mVar = new m(jSONObject.optInt("is_success") == 1, jSONObject.has("price") ? jSONObject.optDouble("price") : 0.0d, jSONObject.optString(k.a.b), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            mVar.b = jSONObject.optString("cur");
            mVar.c = jSONObject.optString("unit_id");
            mVar.d = jSONObject.optInt("nw_firm_id");
            mVar.a = jSONObject.optInt("err_code");
            mVar.e = jSONObject.optLong("expire");
            mVar.f = jSONObject.optLong("out_data_time");
            mVar.u = jSONObject.optBoolean("is_send_winurl");
            mVar.i = jSONObject.optString(k.a.e);
            mVar.g = jSONObject.optString("tp_bid_id");
            mVar.j = jSONObject.optString("burl_win");
            mVar.k = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_SOURCE_ID);
            mVar.l = jSONObject.optDouble("cur_rate");
            if (jSONObject.has("bid_response")) {
                mVar.m = jSONObject.optString("bid_response");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("ctrl");
            if (optJSONObject != null) {
                mVar.n = optJSONObject.optInt(com.anythink.core.common.l.ae);
            }
            if (jSONObject.has("ecpm_api")) {
                mVar.o = jSONObject.optDouble("ecpm_api", 0.0d);
            }
            mVar.p = jSONObject.optString(com.anythink.core.common.l.P);
            if (jSONObject.has("second_price")) {
                mVar.q = jSONObject.optDouble("second_price", 0.0d);
            }
            mVar.h = jSONObject.optString("req_url", "");
            mVar.useType = jSONObject.optInt("bd_type", 1);
            if (jSONObject.has(com.anythink.core.common.l.am)) {
                mVar.sortPrice = jSONObject.optDouble(com.anythink.core.common.l.am, 0.0d);
            } else {
                mVar.sortPrice = mVar.price;
            }
            if (jSONObject.has("origin_price")) {
                mVar.originPrice = jSONObject.optDouble("origin_price");
                return mVar;
            }
            mVar.originPrice = mVar.sortPrice;
            return mVar;
        } catch (Throwable th) {
            return null;
        }
    }

    private String a(double d) {
        int i = this.d;
        return (i == 8 || i == 28) ? String.valueOf((int) d) : String.valueOf(d);
    }

    private static String a(int i) {
        return i == 2 ? ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : ErrorCode.networkError;
    }

    private static String a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        if (i == 34) {
            str2 = str.replace("${AUCTION_CURRENCY}", ATAdConst.CURRENCY.USD.toString());
        }
        return str2;
    }

    private static String a(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        return (!(obj instanceof String) && obj == null) ? "" : obj.toString();
    }

    private void a(ai aiVar, double d) {
        synchronized (this) {
            if (this.u) {
                return;
            }
            this.u = true;
            double d2 = d;
            if (this.l > 0.0d) {
                d2 = d * this.l;
            }
            double sortPrice = this.l > 0.0d ? getSortPrice() * this.l : getSortPrice();
            if (!TextUtils.isEmpty(this.winNoticeUrl)) {
                String replace = this.winNoticeUrl.replace("${AUCTION_BID_TO_WIN}", a(d2));
                if (this.d == 28) {
                    replace = this.winNoticeUrl.replace("${AUCTION_PRICE}", a(sortPrice));
                }
                if (aiVar != null) {
                    com.anythink.core.common.g.f a = com.anythink.core.common.g.f.a(replace, aiVar.c(), aiVar.t());
                    a.a(c(aiVar));
                    a.a(0, (com.anythink.core.common.g.i) null);
                }
            }
            if (this.biddingNotice != null) {
                if (this.d == 28) {
                    this.biddingNotice.notifyBidWin(sortPrice);
                } else {
                    this.biddingNotice.notifyBidWin(d2);
                }
                com.anythink.core.common.j.c.a(c(aiVar));
            }
            if ((aiVar.l() == 3 || aiVar.l() == 7) && !this.A) {
                com.anythink.core.b.f.a();
                com.anythink.core.b.f.a(this.k, this);
            }
        }
    }

    private void a(String str, ai aiVar) {
        if (aiVar == null) {
            return;
        }
        com.anythink.core.common.g.f a = com.anythink.core.common.g.f.a(str, aiVar.c(), aiVar.t());
        a.a(c(aiVar));
        a.a(0, (com.anythink.core.common.g.i) null);
    }

    private String b(boolean z, int i) {
        if (i == 3) {
            return YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
        }
        int i2 = this.d;
        return i2 == 8 ? i == 1 ? "5" : "1" : i2 == 29 ? i == 1 ? "2002" : "2" : i2 == 34 ? a(i) : (i2 == 59 || z) ? ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL;
    }

    private void b(double d) {
        this.q = d;
    }

    private void b(ai aiVar) {
        com.anythink.core.common.j.c.a(c(aiVar));
    }

    private an c(ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        an anVar = new an(aiVar.c(), aiVar.t());
        anVar.c(this.B);
        anVar.a(d(aiVar));
        anVar.f(this.g);
        anVar.d(this.D);
        anVar.e(this.C);
        anVar.g(this.E);
        anVar.h(this.F);
        anVar.i(this.G);
        return anVar;
    }

    private static void c(String str) {
        com.anythink.core.common.g.f.b(str).a(0, (com.anythink.core.common.g.i) null);
    }

    private static int d(ai aiVar) {
        if (aiVar == null) {
            return 0;
        }
        int l = aiVar.l();
        int i = 2;
        if (l != 2) {
            if (l != 5 && l != 6) {
                return 1;
            }
            i = 3;
        }
        return i;
    }

    public final void a(ai aiVar) {
        synchronized (this) {
            a(aiVar, this.q);
        }
    }

    public final void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.F = String.valueOf(eVar.U());
        this.E = String.valueOf(eVar.I());
        this.G = eVar.W();
    }

    public final void a(r rVar, boolean z) {
        String replace;
        synchronized (this) {
            int i = rVar.a;
            ai aiVar = rVar.d;
            ai aiVar2 = rVar.c;
            double d = rVar.b;
            e eVar = rVar.e;
            if (aiVar2 == null || aiVar == null) {
                return;
            }
            boolean j = aiVar2.j();
            int c = aiVar2.c();
            m a = com.anythink.core.b.f.a().a(aiVar);
            if (z) {
                if (a != null && TextUtils.equals(a.token, this.token)) {
                    com.anythink.core.b.f.a().a(this.k);
                    com.anythink.core.b.f.a();
                    com.anythink.core.b.f.b(this.k);
                }
                if (aiVar.l() == 3 || aiVar.l() == 7) {
                    com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.n.a().g(), this.token);
                }
            }
            if (this.u) {
                return;
            }
            this.u = true;
            double d2 = d;
            if (d <= getSortPrice()) {
                d2 = getSortPrice() + 0.01d;
            }
            String str = this.loseNoticeUrl;
            String b = b(j, i);
            com.anythink.core.common.j.c.a(eVar, aiVar, d2, b);
            double d3 = d2;
            if (this.l > 0.0d) {
                d3 = d2 * this.l;
            }
            if (!b.equals(YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID)) {
                if (this.biddingNotice != null) {
                    HashMap hashMap = new HashMap(3);
                    if (this.d == 8) {
                        hashMap.put(ATBiddingNotice.ADN_ID, Integer.valueOf(a(j, c)));
                    }
                    this.biddingNotice.notifyBidLoss(b, d3, hashMap);
                    this.biddingNotice = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    String replace2 = str.replace("${AUCTION_PRICE}", a(d3)).replace("${AUCTION_LOSS}", b);
                    if (this.d == 8) {
                        replace = replace2.replace("${AUCTION_SEAT_ID}", String.valueOf(a(j, c)));
                    } else if (this.d == 29) {
                        replace = replace2.replace("${AUCTION_SEAT_ID}", this.d == c ? "1" : "10001");
                    } else {
                        replace = replace2.replace("${AUCTION_SEAT_ID}", "");
                    }
                    String str2 = replace;
                    if (this.d == 6) {
                        str2 = replace.replace("${AUCTION_CURRENCY}", ATAdConst.CURRENCY.USD.toString());
                    }
                    c(str2);
                }
            }
        }
    }

    public final void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.C = a(map, "offer_id");
        this.D = a(map, "dsp_id");
    }

    public final void a(boolean z, double d, boolean z2) {
        synchronized (this) {
            double d2 = d;
            if (this.l > 0.0d) {
                d2 = d * this.l;
            }
            if (z) {
                String str = this.j;
                String str2 = str;
                if (TextUtils.isEmpty(str)) {
                    str2 = this.displayNoticeUrl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    c(str2.replace("${AUCTION_PRICE}", a(d2)));
                }
            } else {
                String str3 = this.displayNoticeUrl;
                if (!TextUtils.isEmpty(str3)) {
                    c(str3.replace("${AUCTION_PRICE}", a(d2)).replace("${AUCTION_LOSS}", b(z2, 2)));
                }
            }
            if (this.biddingNotice != null) {
                this.biddingNotice.notifyBidDisplay(z, d2);
                if (z) {
                    this.biddingNotice = null;
                }
            }
        }
    }

    public final boolean a() {
        return this.f < System.currentTimeMillis();
    }

    public final void b() {
        synchronized (this) {
            this.A = true;
        }
    }

    public final void b(String str) {
        this.B = str;
    }

    public final String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(k.a.b, this.token);
            jSONObject.put("cur", this.b);
            jSONObject.put("origin_price", this.originPrice);
            jSONObject.put("price", this.price);
            jSONObject.put("nurl", this.winNoticeUrl);
            jSONObject.put("lurl", this.loseNoticeUrl);
            jSONObject.put("unit_id", this.c);
            jSONObject.put("nw_firm_id", this.d);
            jSONObject.put("is_success", this.isSuccess ? 1 : 0);
            jSONObject.put("err_code", this.a);
            jSONObject.put("err_msg", this.errorMsg);
            jSONObject.put("expire", this.e);
            jSONObject.put("out_data_time", this.f);
            jSONObject.put("is_send_winurl", this.u);
            jSONObject.put(k.a.e, this.i);
            jSONObject.put("tp_bid_id", this.g);
            jSONObject.put("burl", this.displayNoticeUrl);
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_SOURCE_ID, this.k);
            jSONObject.put("cur_rate", this.l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.core.common.l.ae, this.n);
            jSONObject.put("ctrl", jSONObject2);
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("bid_response", this.m);
            }
            jSONObject.put("ecpm_api", this.o);
            jSONObject.put(com.anythink.core.common.l.P, this.p);
            jSONObject.put("second_price", this.q);
            jSONObject.put("req_url", this.h);
            jSONObject.put("bd_type", this.useType);
            jSONObject.put(com.anythink.core.common.l.am, this.sortPrice);
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(m mVar) {
        m mVar2 = mVar;
        if (mVar2 == null) {
            return -1;
        }
        double d = 0.0d;
        double a = this.sortPrice == 0.0d ? com.anythink.core.b.f.a().a(this.g, this.k) : this.sortPrice;
        if (mVar2 != null) {
            d = mVar2.sortPrice == 0.0d ? com.anythink.core.b.f.a().a(mVar2.g, mVar2.k) : mVar2.sortPrice;
        }
        return a > d ? -1 : 1;
    }

    public final boolean d() {
        return this.price == 0.0d;
    }
}
