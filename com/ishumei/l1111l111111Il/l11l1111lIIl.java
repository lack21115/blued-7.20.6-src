package com.ishumei.l1111l111111Il;

import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.ishumei.dfp.SMSDK;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111lIIl.class */
public final class l11l1111lIIl {
    Runnable l1111l111111Il;
    private int l111l11111I1l;
    private int l111l11111Il;
    private ArrayList<l11l1111I11l> l111l11111lIl;
    private com.ishumei.l111l11111lIl.l111l11111lIl l111l1111l1Il;
    private Runnable l111l1111lI1l;
    private boolean l111l1111llIl;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111lIIl$l1111l111111Il.class */
    static final class l1111l111111Il {
        private static final l11l1111lIIl l1111l111111Il = new l11l1111lIIl((byte) 0);

        private l1111l111111Il() {
        }
    }

    private l11l1111lIIl() {
        this.l111l11111lIl = new ArrayList<>();
        this.l111l11111I1l = 0;
        this.l111l11111Il = 0;
        this.l111l1111llIl = false;
        this.l111l1111lI1l = new Runnable() { // from class: com.ishumei.l1111l111111Il.l11l1111lIIl.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l11l1111lIIl.l1111l111111Il(l11l1111lIIl.this);
                } catch (Exception e) {
                }
            }
        };
        this.l1111l111111Il = new Runnable() { // from class: com.ishumei.l1111l111111Il.l11l1111lIIl.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l11l1111lIIl.l1111l111111Il(l11l1111lIIl.this);
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this, 6, l11l1111lIIl.this.l111l1111l1Il.l111l11111I1l() * 1000, false);
                } catch (Exception e) {
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this, 6, l11l1111lIIl.this.l111l1111l1Il.l111l11111I1l() * 1000, false);
                } catch (Throwable th) {
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this, 6, l11l1111lIIl.this.l111l1111l1Il.l111l11111I1l() * 1000, false);
                    throw th;
                }
            }
        };
    }

    /* synthetic */ l11l1111lIIl(byte b) {
        this();
    }

    public static l11l1111lIIl l1111l111111Il() {
        return l1111l111111Il.l1111l111111Il;
    }

    static /* synthetic */ void l1111l111111Il(l11l1111lIIl l11l1111liil) {
        if (l11l1111liil.l111l11111lIl.size() > 0) {
            l11l1111liil.l111l11111Il++;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("smid", SmAntiFraud.getDeviceId());
            jSONObject.put("appId", SmAntiFraud.option.l11l11IlIIll());
            jSONObject.put("appname", com.ishumei.l111l11111Il.l111l11111lIl.l111l11111I1l());
            jSONObject.put(TextToSpeech.Engine.KEY_PARAM_SESSION_ID, l111l1111llIl.l1111l111111Il.l111l1111l1Il);
            ArrayList<l11l1111I11l> arrayList = l11l1111liil.l111l11111lIl;
            l11l1111liil.l111l11111lIl = new ArrayList<>();
            JSONArray jSONArray = new JSONArray();
            for (l11l1111I11l l11l1111i11l : arrayList) {
                jSONArray.put(com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(l11l1111i11l));
            }
            jSONObject.put("wevent", jSONArray);
            String v3 = SMSDK.v3(l111l1111llIl.l1111l111111Il.l111l11111Il, jSONObject.toString(), SmAntiFraud.option.l111l1111llIl(), SmAntiFraud.option.l11l1111I1ll(), SmAntiFraud.option.l11l11IlIIll());
            if (TextUtils.isEmpty(v3)) {
                return;
            }
            new com.ishumei.l111l1111l1Il.l111l11111I1l().l1111l111111Il(com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(SmAntiFraud.option.l11l1111Il1l(), SmAntiFraud.option.l111l1111l1Il(), SmAntiFraud.option.l111l11111Il())).l1111l111111Il(v3.getBytes(), null, SmAntiFraud.option.l11l1111Il1l());
        }
    }

    static /* synthetic */ boolean l1111l111111Il(l11l1111lIIl l11l1111liil, boolean z) {
        l11l1111liil.l111l1111llIl = true;
        return true;
    }

    private void l111l11111lIl() {
        if (this.l111l11111lIl.size() <= 0) {
            return;
        }
        this.l111l11111Il++;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("smid", SmAntiFraud.getDeviceId());
        jSONObject.put("appId", SmAntiFraud.option.l11l11IlIIll());
        jSONObject.put("appname", com.ishumei.l111l11111Il.l111l11111lIl.l111l11111I1l());
        jSONObject.put(TextToSpeech.Engine.KEY_PARAM_SESSION_ID, l111l1111llIl.l1111l111111Il.l111l1111l1Il);
        ArrayList<l11l1111I11l> arrayList = this.l111l11111lIl;
        this.l111l11111lIl = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        for (l11l1111I11l l11l1111i11l : arrayList) {
            jSONArray.put(com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(l11l1111i11l));
        }
        jSONObject.put("wevent", jSONArray);
        String v3 = SMSDK.v3(l111l1111llIl.l1111l111111Il.l111l11111Il, jSONObject.toString(), SmAntiFraud.option.l111l1111llIl(), SmAntiFraud.option.l11l1111I1ll(), SmAntiFraud.option.l11l11IlIIll());
        if (TextUtils.isEmpty(v3)) {
            return;
        }
        new com.ishumei.l111l1111l1Il.l111l11111I1l().l1111l111111Il(com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(SmAntiFraud.option.l11l1111Il1l(), SmAntiFraud.option.l111l1111l1Il(), SmAntiFraud.option.l111l11111Il())).l1111l111111Il(v3.getBytes(), null, SmAntiFraud.option.l11l1111Il1l());
    }

    static /* synthetic */ int l111l1111l1Il(l11l1111lIIl l11l1111liil) {
        int i = l11l1111liil.l111l11111I1l;
        l11l1111liil.l111l11111I1l = i + 1;
        return i;
    }

    public final void l1111l111111Il(final String str, final String str2, MotionEvent motionEvent) {
        int action = motionEvent == null ? -1 : motionEvent.getAction();
        float pressure = motionEvent == null ? -1.0f : motionEvent.getPressure();
        float size = motionEvent == null ? -1.0f : motionEvent.getSize();
        long j = -1;
        long downTime = motionEvent == null ? -1L : motionEvent.getDownTime();
        if (motionEvent != null) {
            j = motionEvent.getEventTime();
        }
        final int i = action;
        final float f = pressure;
        final float f2 = size;
        final long j2 = downTime;
        final long j3 = j;
        final float xPrecision = motionEvent == null ? -1.0f : motionEvent.getXPrecision();
        final float yPrecision = motionEvent == null ? -1.0f : motionEvent.getYPrecision();
        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new Runnable() { // from class: com.ishumei.l1111l111111Il.l11l1111lIIl.3
            @Override // java.lang.Runnable
            public final void run() {
                if (l11l1111lIIl.this.l111l1111l1Il == null) {
                    l11l1111lIIl.this.l111l1111l1Il = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
                }
                if (!l11l1111lIIl.this.l111l1111llIl) {
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(l11l1111lIIl.this.l1111l111111Il, 6, l11l1111lIIl.this.l111l1111l1Il.l111l11111I1l() * 1000, false);
                    l11l1111lIIl.l1111l111111Il(l11l1111lIIl.this, true);
                }
                if (l11l1111lIIl.this.l111l11111Il >= l11l1111lIIl.this.l111l1111l1Il.l111l11111lIl()) {
                    return;
                }
                int i2 = i;
                String str3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? "" : "Move" : "Up" : "Down";
                l11l1111I11l l11l1111i11l = new l11l1111I11l();
                l11l1111i11l.l1111l111111Il(l11l1111lIIl.l111l1111l1Il(l11l1111lIIl.this));
                l11l1111i11l.l1111l111111Il(str);
                l11l1111i11l.l111l11111lIl(str3);
                l11l1111i11l.l111l11111I1l(str2);
                l11l1111i11l.l111l11111Il(f);
                l11l1111i11l.l111l11111I1l(f2);
                l11l1111i11l.l111l11111I1l(System.currentTimeMillis());
                l11l1111i11l.l1111l111111Il(j2);
                l11l1111i11l.l111l11111lIl(j3);
                l11l1111i11l.l1111l111111Il(xPrecision);
                l11l1111i11l.l111l11111lIl(yPrecision);
                l11l1111lIIl.this.l111l11111lIl.add(l11l1111i11l);
                if (l11l1111lIIl.this.l111l11111lIl.size() >= l11l1111lIIl.this.l111l1111l1Il.l1111l111111Il()) {
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(l11l1111lIIl.this.l111l1111lI1l, 6);
                }
            }
        }, 6, 0L, false);
    }
}
