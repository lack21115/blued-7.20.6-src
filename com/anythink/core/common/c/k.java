package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.b.n;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/k.class */
public class k extends com.anythink.core.common.c.a<com.anythink.core.common.a.h> {
    private static volatile k c;
    private final String b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/k$a.class */
    public static final class a {
        public static final String a = "offer_data_cache";
        public static final String b = "bid_id";
        public static final String c = "adsource_id";
        public static final String d = "network_firm_id";
        public static final String e = "offer_data";
        public static final String f = "CREATE TABLE IF NOT EXISTS offer_data_cache(bid_id TEXT ,adsource_id TEXT ,network_firm_id INTEGER ,offer_data TEXT)";
    }

    private k(b bVar) {
        super(bVar);
        this.b = k.class.getName();
    }

    public static k a(b bVar) {
        if (c == null) {
            synchronized (k.class) {
                try {
                    if (c == null) {
                        c = new k(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private boolean b(com.anythink.core.common.a.h hVar) {
        Cursor query;
        synchronized (this) {
            if (hVar == null) {
                return false;
            }
            if (hVar.c() == 67) {
                query = a().query(a.a, new String[]{a.e}, "adsource_id=?", new String[]{hVar.b()}, null, null, null);
            } else {
                query = a().query(a.a, new String[]{a.e}, "bid_id=?", new String[]{hVar.a()}, null, null, null);
            }
            if (query != null && query.getCount() > 0) {
                query.close();
                return true;
            }
            if (query != null) {
                query.close();
            }
            return false;
        }
    }

    public final long a(com.anythink.core.common.a.h hVar) {
        synchronized (this) {
            if (b() == null) {
                return -1L;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.b, hVar.a());
                contentValues.put("adsource_id", hVar.b());
                contentValues.put(a.d, hVar.a());
                contentValues.put(a.e, hVar.d());
                if (!b(hVar)) {
                    StringBuilder sb = new StringBuilder("OfferDataCache insert BidId:");
                    sb.append(hVar.a());
                    sb.append(",adSourceId:");
                    sb.append(hVar.b());
                    return b().insert(a.a, null, contentValues);
                } else if (hVar.c() != 67) {
                    new StringBuilder("OfferDataCache update(Adx) BidId:").append(hVar.a());
                    return b().update(a.a, contentValues, "bid_id = ? ", new String[]{hVar.a()});
                } else {
                    StringBuilder sb2 = new StringBuilder("OfferDataCache update(Directly) new BidId:");
                    sb2.append(hVar.a());
                    sb2.append(",old adSourceId:");
                    sb2.append(hVar.b());
                    return b().update(a.a, contentValues, "adsource_id = ? ", new String[]{hVar.b()});
                }
            } catch (Exception e) {
                return -1L;
            }
        }
    }

    public final void a(String str) {
        synchronized (this) {
            try {
                b().delete(a.a, "bid_id = ? ", new String[]{str});
            } catch (Throwable th) {
                com.anythink.core.common.j.c.a("Error_SQL_DELETE", th.getMessage(), n.a().r());
            }
        }
    }

    public final String b(String str) {
        synchronized (this) {
            Cursor query = a().query(a.a, new String[]{a.e}, "bid_id=?", new String[]{str}, null, null, null);
            if (query == null || query.getCount() <= 0) {
                return "";
            }
            query.moveToNext();
            String string = query.getString(0);
            query.close();
            return string;
        }
    }
}
