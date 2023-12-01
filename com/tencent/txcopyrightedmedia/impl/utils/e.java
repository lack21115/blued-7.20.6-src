package com.tencent.txcopyrightedmedia.impl.utils;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final b f40097a;
    private final f b;

    public e(f fVar, b bVar) {
        this.b = fVar;
        this.f40097a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
        if (r0.length <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
        if (r8 != null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.txcopyrightedmedia.impl.utils.bc a(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.e.a(java.lang.String, java.lang.String):com.tencent.txcopyrightedmedia.impl.utils.bc");
    }

    public final void a() {
        this.b.getWritableDatabase().execSQL("DELETE FROM m4a_uri_cache");
    }

    public final boolean a(bb bbVar) {
        d.a(bbVar);
        if (bbVar.o().d > 0) {
            return true;
        }
        File c2 = d.c(bbVar);
        this.f40097a.a().a("REPLACE INTO m4a_uri_cache ( url, content,music_id,music_ext_id,content_file_path,content_length) VALUES (?,?,?,?,?,?);", new Object[]{bbVar.c(), null, bbVar.i(), bbVar.j(), c2.getAbsolutePath(), Long.valueOf(bbVar.o().b)});
        return true;
    }

    public final void b(bb bbVar) {
        aj.a(d.b(bbVar));
        this.b.getWritableDatabase().delete("m4a_uri_cache", "url=? AND music_ext_id=?", new String[]{bbVar.c(), bbVar.j()});
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        if (r11 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = r8
            com.tencent.txcopyrightedmedia.impl.utils.f r0 = r0.b
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()
            r14 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = r14
            java.lang.String r1 = "SELECT content_file_path FROM m4a_uri_cache WHERE music_id=? AND music_ext_id=?"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r3 = r2
            r4 = 0
            r5 = r9
            r3[r4] = r5     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r3 = r2
            r4 = 1
            r5 = r10
            r3[r4] = r5     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L6e
        L28:
            r0 = r13
            r12 = r0
            r0 = r13
            r11 = r0
            r0 = r13
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r0 == 0) goto L6e
            r0 = r13
            r12 = r0
            r0 = r13
            r11 = r0
            r0 = r13
            r1 = r13
            java.lang.String r2 = "content_file_path"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L28
            r0 = r13
            r12 = r0
            r0 = r13
            r11 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r1 = r0
            r2 = r15
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r0 = com.tencent.txcopyrightedmedia.impl.utils.aj.a(r0)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            goto L28
        L6e:
            r0 = r13
            if (r0 == 0) goto L91
            r0 = r13
            r11 = r0
            goto L8b
        L79:
            r9 = move-exception
            goto La8
        L7d:
            r13 = move-exception
            r0 = r11
            r12 = r0
            r0 = r13
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L79
            r0 = r11
            if (r0 == 0) goto L91
        L8b:
            r0 = r11
            r0.close()
        L91:
            r0 = r14
            java.lang.String r1 = "m4a_uri_cache"
            java.lang.String r2 = "music_id=? AND music_ext_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = r3
            r5 = 0
            r6 = r9
            r4[r5] = r6
            r4 = r3
            r5 = 1
            r6 = r10
            r4[r5] = r6
            int r0 = r0.delete(r1, r2, r3)
            return
        La8:
            r0 = r12
            if (r0 == 0) goto Lb4
            r0 = r12
            r0.close()
        Lb4:
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.e.b(java.lang.String, java.lang.String):void");
    }
}
