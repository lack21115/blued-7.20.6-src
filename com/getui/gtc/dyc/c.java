package com.getui.gtc.dyc;

import android.content.ContentValues;
import android.database.Cursor;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.AbstractDb;
import com.getui.gtc.base.db.AbstractTable;
import com.getui.gtc.base.db.DbManager;
import java.util.HashMap;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/c.class */
class c {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/c$a.class */
    public static class a extends AbstractDb {
        @Override // com.getui.gtc.base.db.AbstractDb
        public String getDbName() {
            return "cg.db";
        }

        @Override // com.getui.gtc.base.db.AbstractDb
        public int getVersion() {
            return 1;
        }
    }

    /* renamed from: com.getui.gtc.dyc.c$c  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/c$c.class */
    static class C0350c {

        /* renamed from: a  reason: collision with root package name */
        private static c f21978a = new c();
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/c$d.class */
    public static class d extends AbstractTable {
        @Override // com.getui.gtc.base.db.AbstractTable
        public String createSql() {
            return "CREATE TABLE IF NOT EXISTS sct (v TEXT PRIMARY KEY, c TEXT)";
        }

        @Override // com.getui.gtc.base.db.AbstractTable
        public String getTableName() {
            return "sct";
        }
    }

    private c() {
        try {
            DbManager.init(GtcProvider.context(), a.class, d.class);
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a() {
        return C0350c.f21978a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(String str) {
        Cursor query = ((d) DbManager.getTable(a.class, d.class)).query(new String[]{"c"}, "v=?", new String[]{str});
        if (query == null) {
            return null;
        }
        h hVar = null;
        if (query.moveToNext()) {
            try {
                hVar = h.e(query.getString(query.getColumnIndex("c")));
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
                hVar = null;
            }
        }
        query.close();
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, h hVar) {
        try {
            String g = hVar.g();
            ContentValues contentValues = new ContentValues();
            contentValues.put("v", str);
            contentValues.put("c", g);
            return ((d) DbManager.getTable(a.class, d.class)).replace(null, contentValues) != -1;
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, h> c() {
        Cursor query = ((d) DbManager.getTable(a.class, d.class)).query(new String[]{"v", "c"}, null, null);
        if (query == null) {
            return null;
        }
        HashMap<String, h> hashMap = new HashMap<>();
        while (query.moveToNext()) {
            try {
                hashMap.put(query.getString(query.getColumnIndex("v")), h.e(query.getString(query.getColumnIndex("c"))));
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
            }
        }
        query.close();
        return hashMap;
    }
}
