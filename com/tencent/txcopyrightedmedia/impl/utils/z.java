package com.tencent.txcopyrightedmedia.impl.utils;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/z.class */
public class z {
    public final Handler b;

    /* renamed from: c  reason: collision with root package name */
    private final f f40192c;
    private final HashMap<String, ArrayList<Object>> d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f40191a = new HandlerThread("db-accelerator");
    private final HashMap<String, Object> e = new HashMap<>();
    private final af f = new af();

    public z(f fVar) {
        this.f40192c = fVar;
        this.f40191a.start();
        this.b = new Handler(this.f40191a.getLooper()) { // from class: com.tencent.txcopyrightedmedia.impl.utils.z.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 100:
                        z.a(z.this);
                        if (message.obj instanceof CountDownLatch) {
                            ((CountDownLatch) message.obj).countDown();
                            return;
                        }
                        return;
                    case 101:
                        z.a(z.this);
                        z.this.f.a();
                        z.this.e.clear();
                        z.this.f.b();
                        z.this.f40191a.quit();
                        return;
                    case 102:
                        if (message.obj instanceof String) {
                            z.this.f.a();
                            Object remove = z.this.e.remove(message.obj);
                            StringBuilder sb = new StringBuilder("remove cache for id: ");
                            sb.append(message.obj);
                            sb.append(", success? ");
                            sb.append(remove != null);
                            z.this.f.b();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    static /* synthetic */ void a(z zVar) {
        synchronized (z.class) {
            try {
                SQLiteDatabase writableDatabase = zVar.f40192c.getWritableDatabase();
                for (String str : zVar.d.keySet()) {
                    ArrayList<Object> arrayList = zVar.d.get(str);
                    if (arrayList != null && arrayList.size() != 0) {
                        SQLiteStatement compileStatement = writableDatabase.compileStatement(str);
                        writableDatabase.beginTransaction();
                        Iterator<Object> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Object[] objArr = (Object[]) it.next();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < objArr.length) {
                                    Object obj = objArr[i2];
                                    if (obj instanceof String) {
                                        compileStatement.bindString(i2 + 1, (String) obj);
                                    } else if (obj instanceof byte[]) {
                                        compileStatement.bindBlob(i2 + 1, (byte[]) obj);
                                    } else {
                                        if (!(obj instanceof Double) && !(obj instanceof Float)) {
                                            if (!(obj instanceof Long) && !(obj instanceof Integer)) {
                                                if (obj == null) {
                                                    compileStatement.bindNull(i2 + 1);
                                                }
                                            }
                                            compileStatement.bindLong(i2 + 1, ((Long) obj).longValue());
                                        }
                                        compileStatement.bindDouble(i2 + 1, ((Double) obj).doubleValue());
                                    }
                                    i = i2 + 1;
                                }
                            }
                            long executeInsert = compileStatement.executeInsert();
                            StringBuilder sb = new StringBuilder("result: ");
                            sb.append(executeInsert);
                            sb.append(", sql: ");
                            sb.append(str);
                        }
                        arrayList.clear();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    }
                }
                zVar.d.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(String str, Object[] objArr) {
        if (this.f40191a.isAlive()) {
            synchronized (z.class) {
                try {
                    ArrayList<Object> arrayList = this.d.get(str);
                    ArrayList<Object> arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList<>();
                        this.d.put(str, arrayList2);
                    }
                    arrayList2.add(objArr);
                    if (!this.b.hasMessages(100)) {
                        this.b.sendEmptyMessageDelayed(100, 5000L);
                    }
                } finally {
                }
            }
        }
    }
}
