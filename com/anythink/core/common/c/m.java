package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/m.class */
public class m extends com.anythink.core.common.c.a<com.anythink.core.common.a.i> {
    private static volatile m c;
    private final String b;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/m$a.class */
    public static final class a {
        public static final String a = "video_res_cache_info";
        public static final String b = "video_url";
        public static final String c = "file_path";
        public static final String d = "ready_rate";
        public static final String e = "download_size";
        public static final String f = "total_size";
        public static final String g = "update_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS video_res_cache_info(video_url TEXT, file_path TEXT, ready_rate INTEGER, download_size INTEGER, total_size INTEGER, update_time INTEGER )";
    }

    private m(b bVar) {
        super(bVar);
        this.b = m.class.getSimpleName();
    }

    public static m a(b bVar) {
        if (c == null) {
            synchronized (k.class) {
                try {
                    if (c == null) {
                        c = new m(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    private void d(String str) {
        try {
            Cursor query = a().query(a.a, null, null, null, null, null, null);
            StringBuilder sb = new StringBuilder("logDBCurItemNumber ");
            sb.append(str);
            sb.append(":");
            sb.append(query.getCount());
        } catch (Throwable th) {
            new StringBuilder("logDBCurItemNumber fail:").append(th.getMessage());
        }
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor query = a().query(a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        } else if (query != null) {
            query.close();
            return false;
        } else {
            return false;
        }
    }

    public final com.anythink.core.common.a.i a(String str) {
        try {
            Cursor query = a().query(a.a, null, "video_url=?", new String[]{str}, null, null, null);
            if (query.moveToNext()) {
                com.anythink.core.common.a.i iVar = new com.anythink.core.common.a.i();
                iVar.a(str);
                iVar.b(query.getString(query.getColumnIndex(a.c)));
                iVar.a(query.getInt(query.getColumnIndex(a.d)));
                iVar.b(query.getLong(query.getColumnIndex(a.e)));
                iVar.a(query.getLong(query.getColumnIndex(a.f)));
                iVar.c(query.getLong(query.getColumnIndex("update_time")));
                return iVar;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2 A[Catch: all -> 0x00e6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00e6, blocks: (B:9:0x0017, B:11:0x0067, B:13:0x008b, B:15:0x0094, B:22:0x00b2, B:25:0x00cb, B:19:0x00a4), top: B:44:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[Catch: all -> 0x00e6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00e6, blocks: (B:9:0x0017, B:11:0x0067, B:13:0x008b, B:15:0x0094, B:22:0x00b2, B:25:0x00cb, B:19:0x00a4), top: B:44:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r10, java.lang.String r11, long r12, long r14, int r16) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.m.a(java.lang.String, java.lang.String, long, long, int):void");
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            b().update(a.a, contentValues, "video_url = ? ", new String[]{str});
        } catch (Throwable th) {
        }
    }

    public final long c() {
        try {
            Cursor rawQuery = a().rawQuery("SELECT sum(download_size) FROM video_res_cache_info", null);
            if (rawQuery.moveToNext()) {
                return rawQuery.getLong(0);
            }
            return 0L;
        } catch (Throwable th) {
            new StringBuilder("getDownloadedVideoSize fail:").append(th.getMessage());
            return 0L;
        }
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b().delete(a.a, "video_url=?", new String[]{str});
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("removeVideoResCacheInfo fail:");
            sb.append(th.getMessage());
            sb.append(",videoUrl:");
            sb.append(str);
        }
    }

    public final List<com.anythink.core.common.a.i> d() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = a().query(a.a, null, null, null, null, null, "update_time DESC");
            if (query.getCount() > 0 && query.moveToPosition(((int) Math.round(((query.getCount() * 1.0d) + 1.0d) / 2.0d)) - 1)) {
                long j = query.getLong(query.getColumnIndex("update_time"));
                do {
                    com.anythink.core.common.a.i iVar = new com.anythink.core.common.a.i();
                    iVar.a(query.getString(query.getColumnIndex("video_url")));
                    iVar.b(query.getString(query.getColumnIndex(a.c)));
                    iVar.a(query.getInt(query.getColumnIndex(a.d)));
                    iVar.b(query.getLong(query.getColumnIndex(a.e)));
                    iVar.a(query.getLong(query.getColumnIndex(a.f)));
                    iVar.c(query.getLong(query.getColumnIndex("update_time")));
                    arrayList.add(iVar);
                } while (query.moveToNext());
                b().delete(a.a, "update_time<=?", new String[]{String.valueOf(j)});
                return arrayList;
            }
        } catch (Throwable th) {
            new StringBuilder("removeHalfVideoResCacheInfoByUpdateTime fail:").append(th.getMessage());
        }
        return arrayList;
    }
}
