package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.txcopyrightedmedia.ITXSongScore;
import com.tencent.txcopyrightedmedia.ITXSongScoreCallback;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.TXSongScoreConfig;
import com.tencent.txcopyrightedmedia.TXSongScoreNoteItem;
import com.tencent.txcopyrightedmedia.impl.songscore.KGKTVScore;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import com.tencent.txcopyrightedmedia.impl.utils.w;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/y.class */
public final class y implements ITXSongScore {

    /* renamed from: a  reason: collision with root package name */
    private TXSongScoreConfig f26497a;
    private KGKTVScore b;

    /* renamed from: c  reason: collision with root package name */
    private ITXSongScoreCallback f26498c;
    private boolean d;
    private int e;
    private TXSongScoreNoteItem[] h;
    private int f = -1;
    private final ArrayList<Integer> g = new ArrayList<>();
    private int i = 0;
    private final Object j = new Object();

    public y(TXSongScoreConfig tXSongScoreConfig) {
        if (tXSongScoreConfig == null) {
            return;
        }
        this.f26497a = tXSongScoreConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i a() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("AppId", ap.a().b);
            jSONObject2.put("LicenseExtAppName", ap.a().d.f26372c);
            jSONObject2.put("ExpireTime", (System.currentTimeMillis() / 1000) + 300);
            byte[] bytes = jSONObject2.toString().getBytes("UTF-8");
            byte[] bytes2 = ap.a().d.b.getBytes("UTF-8");
            String replace = new String(Base64.encode(ac.a(bytes, bytes2, Arrays.copyOf(bytes2, 16)), 0), "UTF-8").replace("\n", "");
            String a2 = this.b.a(ap.a().d.f26371a);
            jSONObject.put("Sign", replace);
            jSONObject.put("Action", "DescribeSDKScoreConfig");
            jSONObject.put("PlayToken", aj.d());
            jSONObject.put("LicenseExtAppName", ap.a().d.f26372c);
            jSONObject.put("AppId", ap.a().b);
            jSONObject.put("VerifyData", a2);
            String jSONObject3 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject3)) {
                return new i(-5, "Build active code request error.");
            }
            w wVar = w.c.f26493a;
            w.d a3 = w.a("https://play.yinsuda.qcloud.com/v1/playapi", jSONObject3.getBytes(), "application/json");
            if (a3 == null || a3.b == null) {
                return new i(-5, "Request KtvScore active code fail.");
            }
            if (a3.f26494a >= 200 && a3.f26494a < 300) {
                try {
                    str = new JSONObject(new String(a3.b, "UTF-8")).optJSONObject("Response").optString("ConfigData");
                } catch (Exception e) {
                    e.printStackTrace();
                    str = null;
                }
                return TextUtils.isEmpty(str) ? new i(-5, "ActivationCode is null.") : !this.b.b(str) ? new i(-8, "SongScore license fail.") : new i(0, null);
            }
            i iVar = new i(-4, "Request KtvScore active code fail. Status: " + a3.f26494a);
            i.a aVar = iVar.f26410a;
            aVar.b = String.valueOf(a3.f26494a);
            aVar.a(a3.e);
            return iVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new i(-5, "Build active code request error. detail: " + e2.getMessage());
        }
    }

    private boolean b() {
        if (this.b == null) {
            ITXSongScoreCallback iTXSongScoreCallback = this.f26498c;
            if (iTXSongScoreCallback != null) {
                iTXSongScoreCallback.onMIDIScoreError(-1, "SongScore init fail.");
                return false;
            }
            return false;
        } else if (this.d) {
            return true;
        } else {
            ITXSongScoreCallback iTXSongScoreCallback2 = this.f26498c;
            if (iTXSongScoreCallback2 != null) {
                iTXSongScoreCallback2.onMIDIScoreError(-9, "SongScore not prepared.");
                return false;
            }
            return false;
        }
    }

    static /* synthetic */ boolean f(y yVar) {
        yVar.d = true;
        return true;
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final int calculateTotalScore() {
        synchronized (this.j) {
            if (b()) {
                return this.b.c();
            }
            return -1;
        }
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void destroy() {
        synchronized (this.j) {
            if (this.b != null) {
                this.b.e();
            }
            this.f26498c = null;
            this.d = false;
        }
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void finish() {
        synchronized (this.j) {
            if (b()) {
                int c2 = this.b.c(this.e);
                this.b.d();
                if (this.f26498c != null) {
                    int size = this.g.size();
                    int[] iArr = new int[size];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        iArr[i2] = this.g.get(i2).intValue();
                        i = i2 + 1;
                    }
                    this.f26498c.onMIDIScoreFinish(iArr, c2);
                }
            }
        }
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final TXSongScoreNoteItem[] getAllGrove() {
        synchronized (this.j) {
            if (!b()) {
                return null;
            }
            if (this.h != null && this.h.length > 0) {
                return this.h;
            }
            ArrayList<TXSongScoreNoteItem> a2 = this.b.a();
            if (a2 == null) {
                return null;
            }
            this.h = new TXSongScoreNoteItem[a2.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a2.size()) {
                    return this.h;
                }
                this.h[i2] = a2.get(i2);
                i = i2 + 1;
            }
        }
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void prepare() {
        o oVar = (o) m.a().b(m.b);
        if (oVar == null) {
            return;
        }
        oVar.a(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.y.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (y.this.j) {
                    Context applicationContext = TXCopyrightedMedia.instance().getApplicationContext();
                    int i = 0;
                    if (applicationContext != null) {
                        i = ap.a().a(applicationContext);
                        if (i == 0) {
                            if (y.this.b != null) {
                                y.this.b.e();
                            }
                            y.this.b = new KGKTVScore();
                            i a2 = y.this.a();
                            if (a2.code != 0) {
                                if (y.this.f26498c != null) {
                                    y.this.f26498c.onMIDIScoreError(a2.code, a2.msg);
                                }
                                return;
                            }
                            i a3 = y.this.b.a(y.this.f26497a.sampleRate, y.this.f26497a.channel, y.this.f26497a.noteFilePath, y.this.f26497a.lyricFilePath);
                            if (a3.code == 0) {
                                y.f(y.this);
                                if (y.this.f26498c != null) {
                                    y.this.f26498c.onMIDIScorePrepared();
                                }
                            } else if (y.this.f26498c != null) {
                                y.this.f26498c.onMIDIScoreError(a3.code, a3.msg);
                            }
                            return;
                        }
                    }
                    if (y.this.f26498c != null) {
                        y.this.f26498c.onMIDIScoreError(-8, "License fail. ".concat(String.valueOf(i)));
                    }
                }
            }
        }, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0147 A[Catch: all -> 0x015b, TryCatch #0 {, blocks: (B:5:0x000d, B:8:0x001c, B:10:0x001e, B:12:0x0047, B:14:0x0052, B:16:0x0070, B:18:0x0083, B:21:0x00a1, B:23:0x00a7, B:25:0x00b4, B:27:0x00b9, B:29:0x00c2, B:31:0x00d2, B:32:0x00da, B:34:0x00e0, B:36:0x00eb, B:38:0x0100, B:46:0x0140, B:48:0x0147, B:50:0x0159, B:45:0x0133, B:41:0x010e, B:43:0x0119, B:44:0x0126), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0172  */
    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void process(byte[] r7, int r8, float r9) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.y.process(byte[], int, float):void");
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void seek(float f) {
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void setKeyShift(int i) {
        synchronized (this.j) {
            if (b()) {
                this.b.a(i);
            }
        }
    }

    @Override // com.tencent.txcopyrightedmedia.ITXSongScore
    public final void setSongScoreCallback(ITXSongScoreCallback iTXSongScoreCallback) {
        this.f26498c = new s(iTXSongScoreCallback);
    }
}
