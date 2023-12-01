package com.bytedance.applog.picker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.bdtracker.c;
import com.bytedance.bdtracker.i1;
import com.bytedance.bdtracker.k1;
import com.bytedance.bdtracker.t;
import com.bytedance.bdtracker.v;
import java.util.Objects;
import org.json.JSONArray;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/picker/DomSender.class */
public class DomSender extends t implements Handler.Callback, i1.b {
    public final Handler g;
    public int h;
    public int i;
    public final Context j;
    public final String k;
    public final k1 l;
    public final String m;
    public final String n;
    public final i1 o;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/picker/DomSender$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7572a;
        public JSONArray b = new JSONArray();

        /* renamed from: c  reason: collision with root package name */
        public int f7573c;
        public int d;
    }

    public DomSender(v vVar, String str) {
        super(vVar);
        this.g = new Handler(Looper.getMainLooper(), this);
        this.l = new k1(this.f);
        this.o = new i1(this.f, this, Looper.myLooper());
        this.j = vVar.a();
        this.k = vVar.h.a();
        this.m = vVar.h.m();
        c cVar = this.f;
        String str2 = (String) (cVar.o != null ? cVar.o.a("resolution", (String) null, String.class) : null);
        if (!TextUtils.isEmpty(str2)) {
            String[] split = ((String) Objects.requireNonNull(str2)).split("x");
            this.i = Integer.parseInt(split[0]);
            this.h = Integer.parseInt(split[1]);
        }
        this.n = str;
    }

    @Override // com.bytedance.bdtracker.t
    public boolean c() {
        this.o.a();
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public String d() {
        return "d";
    }

    @Override // com.bytedance.bdtracker.t
    public long[] e() {
        return new long[]{1000};
    }

    @Override // com.bytedance.bdtracker.t
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.t
    public long h() {
        return 1000L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Toast.makeText(this.j, (String) message.obj, 0).show();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x03f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0394 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03e7 A[Catch: all -> 0x0418, IOException -> 0x041f, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x041f, all -> 0x0418, blocks: (B:85:0x0394, B:99:0x03e7), top: B:176:0x0394 }] */
    @Override // com.bytedance.bdtracker.i1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onGetCircleInfoFinish(java.util.Map<java.lang.Integer, com.bytedance.bdtracker.i1.a> r7) {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.picker.DomSender.onGetCircleInfoFinish(java.util.Map):void");
    }
}
