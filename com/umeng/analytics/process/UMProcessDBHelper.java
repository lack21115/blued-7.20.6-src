package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/UMProcessDBHelper.class */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/UMProcessDBHelper$InsertEventCallback.class */
    class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = str;
            if (str.startsWith(com.umeng.analytics.process.a.f27112c)) {
                str2 = str.replaceFirst(com.umeng.analytics.process.a.f27112c, "");
            }
            UMProcessDBHelper.this.insertEvents(str2.replace(com.umeng.analytics.process.a.d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/UMProcessDBHelper$ProcessToMainCallback.class */
    class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = str;
            if (str.startsWith(com.umeng.analytics.process.a.f27112c)) {
                str2 = str.replaceFirst(com.umeng.analytics.process.a.f27112c, "");
            }
            UMProcessDBHelper.this.processToMain(str2.replace(com.umeng.analytics.process.a.d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/UMProcessDBHelper$a.class */
    public class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        int f27109a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f27110c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.f27110c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable th) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new UMProcessDBHelper(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception e) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.b);
                        contentValues.put("__e", aVar.f27110c);
                        contentValues.put("__t", Integer.valueOf(aVar.e));
                        contentValues.put(a.InterfaceC0909a.f, aVar.f);
                        contentValues.put("__av", aVar.g);
                        contentValues.put("__vc", aVar.h);
                        contentValues.put("__s", aVar.d);
                        sQLiteDatabase.insert(a.InterfaceC0909a.f27113a, null, contentValues);
                    } catch (Exception e2) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th2) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th4) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception e3) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th5) {
                }
            }
            c.a(this.mContext).b(str);
            return false;
        }
    }

    private boolean processIsService(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0131, code lost:
        if (r11 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0166, code lost:
        r11.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01aa, code lost:
        if (r11 == null) goto L43;
     */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x017c: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:56:0x0179 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception e) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (list != null && size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i2).f27109a);
                    i = i2 + 1;
                }
            } else {
                sQLiteDatabase.delete(a.InterfaceC0909a.f27113a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception e2) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r10 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r9) {
        /*
            r8 = this;
            r0 = 0
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = r8
            android.content.Context r0 = r0.mContext     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            java.lang.String r1 = "_main_"
            android.database.sqlite.SQLiteDatabase r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r11 = r0
            r0 = r11
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r0 = r11
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r9
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r9 = r0
        L28:
            r0 = r11
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r9
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            if (r0 == 0) goto L5b
            r0 = r11
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            java.lang.String r1 = "__et_p"
            java.lang.String r2 = "id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r4 = r3
            r5 = 0
            r6 = r9
            java.lang.Object r6 = r6.next()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r4[r5] = r6     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            int r0 = r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            goto L28
        L5b:
            r0 = r11
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L9d
            r0 = r11
            if (r0 == 0) goto L8f
            r0 = r11
            r10 = r0
            goto L8b
        L6d:
            r9 = move-exception
            r0 = r12
            if (r0 == 0) goto L78
            r0 = r12
            r0.endTransaction()
        L78:
            r0 = r8
            android.content.Context r0 = r0.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)
            java.lang.String r1 = "_main_"
            r0.b(r1)
            r0 = r9
            throw r0
        L87:
            r0 = r10
            if (r0 == 0) goto L8f
        L8b:
            r0 = r10
            r0.endTransaction()
        L8f:
            r0 = r8
            android.content.Context r0 = r0.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)
            java.lang.String r1 = "_main_"
            r0.b(r1)
            return
        L9d:
            r9 = move-exception
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0416 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r10, java.util.List<java.lang.Integer> r12) {
        /*
            Method dump skipped, instructions count: 1090
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            cursor2 = null;
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = sQLiteDatabase.query(a.InterfaceC0909a.f27113a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    JSONObject jSONObject2 = null;
                    if (cursor != null) {
                        jSONObject2 = null;
                        try {
                            try {
                                if (cursor.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursor.getString(cursor.getColumnIndex("__av"));
                                        String string2 = cursor.getString(cursor.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e) {
                                        e = e;
                                        cursor2 = cursor;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception e2) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e3) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject = null;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = sQLiteDatabase2;
                }
            } catch (Exception e6) {
                e = e6;
                jSONObject = null;
                cursor = null;
            }
        } catch (Exception e7) {
            e = e7;
            sQLiteDatabase = null;
            jSONObject = null;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }
}
