package com.bytedance.bdtracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n1.class */
public class n1 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final v f7660a;
    public final Handler b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a> f7661c = new HashMap();
    public final Set<String> d = new HashSet();
    public String e = "";

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7662a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f7663c;

        public a(long j, String str, JSONObject jSONObject) {
            this.f7662a = j;
            this.b = str;
            this.f7663c = jSONObject;
        }

        public String toString() {
            StringBuilder a2 = com.bytedance.bdtracker.a.a("ProfileDataWrapper{timeStamp=");
            a2.append(this.f7662a);
            a2.append(", apiName='");
            a2.append(this.b);
            a2.append('\'');
            a2.append(", jsonObject=");
            a2.append(this.f7663c);
            a2.append('}');
            return a2.toString();
        }
    }

    public n1(v vVar) {
        this.f7660a = vVar;
        StringBuilder a2 = com.bytedance.bdtracker.a.a("bd_tracker_profile:");
        a2.append(vVar.f7719c.l);
        HandlerThread handlerThread = new HandlerThread(a2.toString());
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(int i, a aVar) {
        if (this.f7660a.f7719c.v) {
            return;
        }
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(i, aVar));
    }

    public final void a(a aVar) {
        if (this.f7660a == null) {
            return;
        }
        StringBuilder a2 = com.bytedance.bdtracker.a.a("__profile_");
        a2.append(aVar.b);
        d2 d2Var = new d2(a2.toString(), aVar.f7663c.toString());
        ArrayList<t1> arrayList = new ArrayList<>();
        v vVar = this.f7660a;
        vVar.m.a(vVar.f7719c, d2Var);
        this.f7660a.b(d2Var);
        arrayList.add(d2Var);
        this.f7660a.b().b(arrayList);
        this.b.sendMessageDelayed(this.b.obtainMessage(106), 500L);
    }

    public void a(JSONObject jSONObject) {
        a(105, new a(System.currentTimeMillis(), "append", jSONObject));
    }

    public void b(JSONObject jSONObject) {
        a(103, new a(System.currentTimeMillis(), "increment", jSONObject));
    }

    public void c(JSONObject jSONObject) {
        a(100, new a(System.currentTimeMillis(), "set", jSONObject));
    }

    public void d(JSONObject jSONObject) {
        a(102, new a(System.currentTimeMillis(), "set_once", jSONObject));
    }

    public void e(JSONObject jSONObject) {
        a(104, new a(System.currentTimeMillis(), "unset", jSONObject));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        boolean z2;
        switch (message.what) {
            case 100:
                a aVar = (a) message.obj;
                String str = this.e;
                boolean equals = str != null ? str.equals(this.f7660a.f7719c.getSsid()) : false;
                this.e = this.f7660a.f7719c.getSsid();
                Iterator<String> keys = aVar.f7663c.keys();
                boolean z3 = false;
                boolean z4 = true;
                while (true) {
                    boolean z5 = z4;
                    if (!keys.hasNext()) {
                        if (equals && !z3 && z5) {
                            return true;
                        }
                        z2.a("invoke profile set.");
                        a(aVar);
                        return true;
                    }
                    String next = keys.next();
                    if (!this.f7661c.containsKey(next) || this.f7661c.get(next) == null) {
                        z3 = true;
                    } else {
                        a aVar2 = this.f7661c.get(next);
                        z2 = z3;
                        z = z5;
                        if (aVar2 != null) {
                            if (System.currentTimeMillis() - aVar2.f7662a >= 60000) {
                                z3 = true;
                            }
                            try {
                                z2 = z3;
                                z = z5;
                                if (j1.a(aVar.f7663c, aVar2.f7663c, (String) null)) {
                                }
                            } catch (Exception e) {
                                z2.a(e);
                                z2 = z3;
                                z = z5;
                            }
                        }
                        this.f7661c.put(next, aVar);
                        z3 = z2;
                        z4 = z;
                    }
                    z = false;
                    z2 = z3;
                    this.f7661c.put(next, aVar);
                    z3 = z2;
                    z4 = z;
                }
                break;
            case 101:
            default:
                return true;
            case 102:
                a aVar3 = (a) message.obj;
                String str2 = this.e;
                boolean equals2 = str2 != null ? str2.equals(this.f7660a.f7719c.getSsid()) : false;
                this.e = this.f7660a.f7719c.getSsid();
                Iterator<String> keys2 = aVar3.f7663c.keys();
                boolean z6 = true;
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!this.d.contains(next2)) {
                        z6 = false;
                    }
                    this.d.add(next2);
                }
                if (equals2 && z6) {
                    return true;
                }
                z2.a("invoke profile set once.");
                a(aVar3);
                return true;
            case 103:
                z2.a("invoke profile increment.");
                a((a) message.obj);
                return true;
            case 104:
                z2.a("invoke profile unset.");
                a((a) message.obj);
                return true;
            case 105:
                z2.a("invoke profile append.");
                a((a) message.obj);
                return true;
            case 106:
                v vVar = this.f7660a;
                if (vVar == null || vVar.h.h() == 0) {
                    return true;
                }
                ArrayList<t1> b = this.f7660a.b().b(this.f7660a.f7719c.l);
                if (b.isEmpty()) {
                    return true;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("magic_tag", "ss_app_log");
                    jSONObject.put("header", this.f7660a.f7719c.getHeader());
                    jSONObject.put("time_sync", q1.e);
                    jSONObject.put("local_time", System.currentTimeMillis() / 1000);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<t1> it = b.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().h());
                    }
                    jSONObject.put("event_v3", jSONArray);
                    byte[] b2 = this.f7660a.f7719c.j.f7685c.b(jSONObject.toString());
                    this.f7660a.b().a(b);
                    if (this.f7660a.f7719c.j.a(new String[]{this.f7660a.c().getProfileUri()}, b2, this.f7660a.d) != 200) {
                        this.f7660a.b().b(b);
                        return true;
                    }
                    return true;
                } catch (JSONException e2) {
                    z2.a(e2);
                    return true;
                }
        }
    }
}
