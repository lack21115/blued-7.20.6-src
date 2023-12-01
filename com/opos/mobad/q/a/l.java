package com.opos.mobad.q.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public com.opos.mobad.ad.h f13538a;
    private Context b;
    private AdItemData g;
    private MaterialData h;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13539c = false;
    private volatile boolean d = false;
    private long e = -1;
    private boolean f = false;
    private boolean i = false;

    public l(Context context, com.opos.mobad.ad.h hVar) {
        this.b = context;
        this.f13538a = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        r6.append("打开");
        r7 = "就可以领取奖励!确定要离开吗?";
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004e, code lost:
        r6.append("安装完成");
        r7 = "就可以领取奖励!确定要离开吗?";
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (r5.i != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003e, code lost:
        if (r5.i != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.CharSequence a(android.text.SpannableStringBuilder r6, android.text.SpannableString r7, long r8) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.l.a(android.text.SpannableStringBuilder, android.text.SpannableString, long):java.lang.CharSequence");
    }

    private String a(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "s";
        }
        return this.b.getString(R.string.opos_mob_reward_count, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r5.i != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        if (r5.i != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r5.i != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r6, long r7) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.l.a(java.lang.String, long):java.lang.String");
    }

    private void a(final Object... objArr) {
        this.d = true;
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f13539c || !l.this.d || l.this.f13538a == null) {
                    return;
                }
                l.this.f13538a.a(objArr);
            }
        });
    }

    private String b(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "s";
        }
        return this.b.getString(R.string.opos_mob_reward_count_install, str2);
    }

    private String c(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "s";
        }
        return this.i ? this.b.getString(R.string.opos_mob_reward_count_open, str2) : this.b.getString(R.string.opos_mob_reward_count_open_without_install, str2);
    }

    private long f(long j) {
        long j2;
        long K = this.g.K();
        long j3 = j;
        if (j <= 0) {
            j3 = this.h.u();
        }
        if (K > 0) {
            j2 = K;
            if (j3 > 0) {
                j2 = Math.min(K, j3);
            }
        } else {
            j2 = j3;
        }
        long max = Math.max(0L, j2);
        long j4 = this.e;
        if (j4 >= max) {
            return 0L;
        }
        return Math.max(0L, max - j4);
    }

    public void a() {
        if (this.d || this.f13539c || !this.g.z()) {
            return;
        }
        a(new Object[0]);
    }

    public void a(long j) {
        this.e = j;
        if (this.d || this.f13539c) {
            return;
        }
        if (this.g.v() && this.g.K() > 0 && j >= this.g.K()) {
            a(new Object[0]);
        }
        if (this.g.y() && this.f && this.e >= this.g.K()) {
            a(new Object[0]);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData) {
        this.g = adItemData;
        this.h = materialData;
        this.d = false;
        this.f = false;
        this.e = -1L;
        this.i = com.opos.cmn.an.h.d.a.d(this.b, this.h.k());
    }

    public void a(AdItemData adItemData, String str) {
        if (this.d || this.f13539c || !this.g.x() || adItemData.C()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.g;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.g.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.g.c()) && !TextUtils.isEmpty(adItemData.c()) && this.g.c().equals(adItemData.c())))) {
            this.g.d(true);
        }
        a(new Object[0]);
    }

    public void b(long j) {
        this.e = j;
        if (this.d || this.f13539c || !this.g.v()) {
            return;
        }
        a(new Object[0]);
    }

    public void b(AdItemData adItemData, String str) {
        if (this.d || this.f13539c) {
            return;
        }
        this.i = true;
        if (!this.g.w() || adItemData.C()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.g;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.g.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.g.c()) && !TextUtils.isEmpty(adItemData.c()) && this.g.c().equals(adItemData.c())))) {
            this.g.d(true);
        }
        a(new Object[0]);
    }

    public boolean b() {
        return this.d;
    }

    public CharSequence c(long j) {
        CharSequence charSequence = "";
        com.opos.cmn.an.f.a.b("", "getRewardLastTips = " + this.d);
        if (!this.d) {
            if (this.g.A()) {
                return "";
            }
            if (this.g.v() && this.g.K() <= 0 && this.h.u() <= 0) {
                return "";
            }
            long f = f(j);
            String valueOf = String.valueOf(Math.round(f / 1000.0d));
            SpannableString spannableString = new SpannableString(valueOf);
            spannableString.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(android.R.color.holo_red_dark)), 0, valueOf.length(), 33);
            charSequence = a(new SpannableStringBuilder(), spannableString, f);
        }
        return charSequence;
    }

    public void c() {
        if (this.d || this.f13539c) {
            return;
        }
        this.f = true;
        if (this.g.y()) {
            if (this.g.K() <= 0 || this.e >= this.g.K()) {
                a(new Object[0]);
            }
        }
    }

    public String d(long j) {
        return (this.g.v() || this.g.x() || this.g.w()) ? e(j) : "";
    }

    public boolean d() {
        if (this.d || this.f13539c) {
            return false;
        }
        this.d = true;
        com.opos.mobad.service.a.a().a(this.g.g(), 5, this.g.f(), this.g.b(), (this.g.i().size() <= 0 || this.g.i().get(0) == null) ? "" : this.g.i().get(0).aa(), this.g.a(), this.g.J());
        a(new Object[0]);
        return true;
    }

    public String e(long j) {
        long j2 = j;
        if (j <= 0) {
            j2 = this.h.u();
        }
        long j3 = j2;
        if (this.g.K() > 0) {
            j3 = j2 > 0 ? Math.min(this.g.K(), j2) : this.g.K();
        }
        long max = Math.max(j3, 0L);
        long j4 = this.e;
        if (j4 > 0) {
            max = Math.max(0L, max - j4);
        }
        String valueOf = max > 0 ? String.valueOf(Math.round(max / 1000.0d)) : "";
        if (this.d) {
            String str = valueOf;
            if (!TextUtils.isEmpty(valueOf)) {
                str = valueOf + "s";
            }
            return this.b.getString(R.string.opos_mob_reward_tips, str);
        }
        return a(valueOf, max);
    }

    public void e() {
        this.d = false;
        this.f13539c = true;
    }
}
