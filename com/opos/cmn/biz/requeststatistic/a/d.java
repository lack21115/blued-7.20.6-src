package com.opos.cmn.biz.requeststatistic.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.a.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10991a = d.class.getSimpleName();
    private static d g;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public b f10992c;
    public a e;
    public a f;
    private ReadWriteLock h = new ReentrantReadWriteLock();
    public LinkedBlockingQueue<c> d = new LinkedBlockingQueue<>();

    private d() {
    }

    public static d a() {
        d dVar;
        d dVar2 = g;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                if (g == null) {
                    g = new d();
                }
                dVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    static /* synthetic */ void a(d dVar, final a.InterfaceC0461a interfaceC0461a) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.3
            @Override // java.lang.Runnable
            public final void run() {
                d.this.h.writeLock().lock();
                try {
                    try {
                        LinkedList linkedList = new LinkedList();
                        Object poll = d.this.d.poll();
                        while (true) {
                            c cVar = (c) poll;
                            if (cVar == null) {
                                break;
                            }
                            linkedList.add(cVar);
                            poll = d.this.d.poll();
                        }
                        d.this.f10992c.a(linkedList);
                        String str = d.f10991a;
                        com.opos.cmn.an.f.a.b(str, "write cache size:" + linkedList.size());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b(d.f10991a, "write fail", e);
                        if (interfaceC0461a != null) {
                            interfaceC0461a.b();
                            d.this.h.writeLock().unlock();
                            return;
                        }
                    }
                    d.this.h.writeLock().unlock();
                    a.InterfaceC0461a interfaceC0461a2 = interfaceC0461a;
                    if (interfaceC0461a2 != null) {
                        interfaceC0461a2.a();
                    }
                } catch (Throwable th) {
                    d.this.h.writeLock().unlock();
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<c> list) {
        this.h.writeLock().lock();
        try {
            try {
                b bVar = this.f10992c;
                if (list != null && list.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            break;
                        }
                        sb.append("'");
                        sb.append(list.get(i2).f10989a);
                        sb.append("'");
                        if (i2 < list.size() - 1) {
                            sb.append(",");
                        }
                        i = i2 + 1;
                    }
                    sb.append(")");
                    SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                    writableDatabase.execSQL("delete\tfrom\trequest_statistic\twhere\tid\tin\t" + sb.toString());
                }
                this.h.writeLock().unlock();
                return true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b(f10991a, "delete data", e);
                this.h.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            this.h.writeLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ void b(d dVar, final a.InterfaceC0461a interfaceC0461a) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.5
            @Override // java.lang.Runnable
            public final void run() {
                d.c(d.this, new a.InterfaceC0461a() { // from class: com.opos.cmn.biz.requeststatistic.a.d.5.1
                    @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0461a
                    public final void a() {
                        d.d(d.this);
                        if (interfaceC0461a != null) {
                            interfaceC0461a.a();
                        }
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0461a
                    public final void b() {
                        d.d(d.this);
                        if (interfaceC0461a != null) {
                            interfaceC0461a.b();
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void c(d dVar, final a.InterfaceC0461a interfaceC0461a) {
        dVar.h.readLock().lock();
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        long currentTimeMillis2 = System.currentTimeMillis() - 60000;
        String str = f10991a;
        com.opos.cmn.an.f.a.b(str, "do report cache with start Time:" + currentTimeMillis + ", endTime:" + currentTimeMillis2);
        try {
            try {
                final List<c> a2 = dVar.f10992c.a(currentTimeMillis, currentTimeMillis2);
                dVar.h.readLock().unlock();
                String str2 = f10991a;
                com.opos.cmn.an.f.a.b(str2, "report cache size:" + a2.size());
                if (a2.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (c cVar : a2) {
                        try {
                            jSONArray.put(new JSONObject(cVar.b));
                        } catch (JSONException e) {
                            com.opos.cmn.an.f.a.b(f10991a, "parse data fail", e);
                        }
                    }
                    if (jSONArray.length() > 0) {
                        final Context context = dVar.b;
                        final String jSONArray2 = jSONArray.toString();
                        final a.InterfaceC0460a interfaceC0460a = new a.InterfaceC0460a() { // from class: com.opos.cmn.biz.requeststatistic.a.d.6
                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0460a
                            public final void onFail() {
                                com.opos.cmn.an.f.a.b(d.f10991a, "report cache fail");
                                a.InterfaceC0461a interfaceC0461a2 = interfaceC0461a;
                                if (interfaceC0461a2 != null) {
                                    interfaceC0461a2.b();
                                }
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0460a
                            public final void onSuccess() {
                                a.InterfaceC0461a interfaceC0461a2;
                                com.opos.cmn.an.f.a.b(d.f10991a, "report cache success");
                                if (!d.this.a(a2) && (interfaceC0461a2 = interfaceC0461a) != null) {
                                    interfaceC0461a2.b();
                                } else if (d.e(d.this)) {
                                    d.c(d.this, interfaceC0461a);
                                } else {
                                    interfaceC0461a.a();
                                }
                            }
                        };
                        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.a(context, jSONArray2, interfaceC0460a);
                            }
                        });
                        return;
                    } else if (!dVar.a(a2)) {
                        if (interfaceC0461a != null) {
                            interfaceC0461a.b();
                            return;
                        }
                        return;
                    } else if (interfaceC0461a == null) {
                        return;
                    }
                } else if (interfaceC0461a == null) {
                    return;
                }
                interfaceC0461a.a();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b(f10991a, "get cache fail", e2);
                if (interfaceC0461a != null) {
                    interfaceC0461a.b();
                }
                dVar.h.readLock().unlock();
            }
        } catch (Throwable th) {
            dVar.h.readLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ void d(d dVar) {
        dVar.h.writeLock().lock();
        int i = 0;
        try {
            try {
                i = dVar.f10992c.getWritableDatabase().delete("request_statistic", "createTime<= ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000)});
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b(f10991a, "delete cache expired fail", e);
            }
            dVar.h.writeLock().unlock();
            com.opos.cmn.an.f.a.b(f10991a, "delete cache expired size:".concat(String.valueOf(i)));
        } catch (Throwable th) {
            dVar.h.writeLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ boolean e(d dVar) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) dVar.b.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public final void b() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }
}
