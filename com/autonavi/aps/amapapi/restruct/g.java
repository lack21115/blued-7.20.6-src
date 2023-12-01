package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ht;
import com.amap.api.col.p0003sl.mq;
import com.amap.api.col.p0003sl.mt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/g.class */
public final class g {
    private File b;
    private Handler d;
    private String e;
    private boolean f;

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<f> f9254a = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f9255c = false;
    private Runnable g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.f9255c) {
                return;
            }
            if (g.this.f) {
                g.this.b();
                g.d(g.this);
            }
            if (g.this.d != null) {
                g.this.d.postDelayed(g.this.g, 60000L);
            }
        }
    };

    public g(Context context, Handler handler) {
        this.e = null;
        this.d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = com.autonavi.aps.amapapi.utils.i.l(context);
        }
        try {
            this.b = new File(path, "hisloc");
        } catch (Throwable th) {
            mt.a(th);
        }
        a();
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 60000L);
        }
    }

    private void a() {
        LinkedList<f> linkedList = this.f9254a;
        if (linkedList == null || linkedList.size() <= 0) {
            for (String str : com.autonavi.aps.amapapi.utils.i.a(this.b)) {
                try {
                    String str2 = new String(com.autonavi.aps.amapapi.security.a.b(ht.b(str), this.e), "UTF-8");
                    f fVar = new f();
                    fVar.a(new JSONObject(str2));
                    this.f9254a.add(fVar);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f9254a.iterator();
        while (it.hasNext()) {
            try {
                String a2 = it.next().a();
                sb.append(ht.b(com.autonavi.aps.amapapi.security.a.a(a2.getBytes("UTF-8"), this.e)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.i.a(this.b, sb2);
    }

    private static boolean b(ArrayList<d> arrayList, ArrayList<mq> arrayList2) {
        if (arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0) {
            return true;
        }
        return ((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20;
    }

    static /* synthetic */ boolean d(g gVar) {
        gVar.f = false;
        return false;
    }

    public final List<f> a(ArrayList<d> arrayList, ArrayList<mq> arrayList2) {
        if (b(arrayList, arrayList2)) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            Iterator<f> it = this.f9254a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                int i2 = i;
                if (currentTimeMillis - next.d < 21600000000L) {
                    arrayList3.add(next);
                    i2 = i + 1;
                }
                i = i2;
                if (i2 == 10) {
                    break;
                }
            }
            return arrayList3;
        }
        return null;
    }

    public final void a(f fVar) {
        Iterator<f> it = this.f9254a.iterator();
        f fVar2 = null;
        f fVar3 = null;
        int i = 0;
        while (it.hasNext()) {
            f next = it.next();
            if (next.f9252a == 1) {
                f fVar4 = fVar3;
                if (fVar3 == null) {
                    fVar4 = next;
                }
                i++;
                fVar2 = next;
                fVar3 = fVar4;
            }
        }
        if (fVar2 != null) {
            new Location("gps");
            if (fVar.d - fVar2.d < 20000 && com.autonavi.aps.amapapi.utils.i.a(new double[]{fVar.b, fVar.f9253c, fVar2.b, fVar2.f9253c}) < 20.0f) {
                return;
            }
        }
        if (i >= 5) {
            this.f9254a.remove(fVar3);
        }
        if (this.f9254a.size() >= 10) {
            this.f9254a.removeFirst();
        }
        this.f9254a.add(fVar);
        this.f = true;
    }

    public final void a(boolean z) {
        if (!z) {
            this.g.run();
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.f9255c = true;
    }

    public final void b(f fVar) {
        if (this.f9254a.size() > 0) {
            if (fVar.f9252a != 6 && fVar.f9252a != 5) {
                if (this.f9254a.contains(fVar)) {
                    return;
                }
                if (this.f9254a.size() >= 10) {
                    this.f9254a.removeFirst();
                }
                this.f9254a.add(fVar);
                this.f = true;
                return;
            }
            f last = this.f9254a.getLast();
            if (last.f9253c == fVar.f9253c && last.b == fVar.b && last.e == fVar.e) {
                return;
            }
            if (this.f9254a.size() >= 10) {
                this.f9254a.removeFirst();
            }
            this.f9254a.add(fVar);
            this.f = true;
        }
    }
}
