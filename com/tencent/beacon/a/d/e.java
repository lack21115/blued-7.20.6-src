package com.tencent.beacon.a.d;

import java.nio.MappedByteBuffer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/e.class */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f21264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar) {
        this.f21264a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        JSONObject jSONObject;
        long j;
        MappedByteBuffer mappedByteBuffer;
        MappedByteBuffer mappedByteBuffer2;
        MappedByteBuffer mappedByteBuffer3;
        MappedByteBuffer mappedByteBuffer4;
        long j2;
        try {
            obj = this.f21264a.f21266a;
            synchronized (obj) {
                jSONObject = this.f21264a.f21267c;
                byte[] a2 = g.a(jSONObject.toString().getBytes("ISO8859-1"));
                if (a2 == null) {
                    return;
                }
                j = this.f21264a.e;
                if (a2.length + 10 > j) {
                    this.f21264a.e = a2.length + 10;
                    g gVar = this.f21264a;
                    j2 = this.f21264a.e;
                    gVar.a(j2);
                }
                mappedByteBuffer = this.f21264a.d;
                mappedByteBuffer.putInt(0, a2.length);
                mappedByteBuffer2 = this.f21264a.d;
                mappedByteBuffer2.position(10);
                mappedByteBuffer3 = this.f21264a.d;
                mappedByteBuffer3.put(a2);
                mappedByteBuffer4 = this.f21264a.d;
                mappedByteBuffer4.force();
            }
        } catch (Exception e) {
            com.tencent.beacon.a.b.g.e().a("504", "[properties] write to file error!", e);
        }
    }
}
