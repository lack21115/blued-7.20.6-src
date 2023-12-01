package com.anythink.core.common.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.c.d;
import com.anythink.core.common.c.e;
import com.anythink.core.common.c.f;
import com.anythink.core.common.c.g;
import com.anythink.core.common.c.h;
import com.anythink.core.common.c.i;
import com.anythink.core.common.c.j;
import com.anythink.core.common.c.k;
import com.anythink.core.common.c.l;
import com.anythink.core.common.c.m;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/c.class */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private static c f6571a;

    private c(Context context) {
        super(context);
    }

    public static c a(Context context) {
        if (f6571a == null) {
            synchronized (c.class) {
                try {
                    if (f6571a == null) {
                        f6571a = new c(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6571a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d.a.f);
            sQLiteDatabase.execSQL(g.a.i);
            a(sQLiteDatabase, 3, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'sdkconfig'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'placement_ad_impression'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_action_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_show_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_install_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'inspect_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'video_res_cache_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'notice_url_fail_info'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                case 2:
                    d(sQLiteDatabase);
                    c(sQLiteDatabase);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(l.a.j);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(j.a.h);
                    sQLiteDatabase.execSQL(k.a.f);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(f.a.h);
                    sQLiteDatabase.execSQL(e.a.f);
                    break;
                case 6:
                    sQLiteDatabase.execSQL(h.a.d);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(m.a.h);
                    break;
                case 8:
                    sQLiteDatabase.execSQL(i.b.i);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
                    sQLiteDatabase.execSQL(g.a.i);
                    break;
            }
            i++;
        }
    }

    @Override // com.anythink.core.common.c.b
    protected final void b(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final String c() {
        return "anythink.db";
    }

    @Override // com.anythink.core.common.c.b
    protected final int d() {
        return 9;
    }
}
