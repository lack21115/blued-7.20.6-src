package com.opos.exoplayer.core.f.d;

import android.text.TextUtils;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.i.h;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/d/a.class */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f25370a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f25371c;
    private int d;
    private int e;
    private int f;

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.b = false;
            return;
        }
        this.b = true;
        String str = new String(list.get(0));
        com.opos.exoplayer.core.i.a.a(str.startsWith("Format: "));
        b(str);
        a(new m(list.get(1)));
    }

    public static long a(String str) {
        Matcher matcher = f25370a.matcher(str);
        return !matcher.matches() ? com.anythink.expressad.exoplayer.b.b : (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    private void a(m mVar) {
        String z;
        do {
            z = mVar.z();
            if (z == null) {
                return;
            }
        } while (!z.startsWith("[Events]"));
    }

    private void a(m mVar, List<com.opos.exoplayer.core.f.b> list, h hVar) {
        while (true) {
            String z = mVar.z();
            if (z == null) {
                return;
            }
            if (!this.b && z.startsWith("Format: ")) {
                b(z);
            } else if (z.startsWith("Dialogue: ")) {
                a(z, list, hVar);
            }
        }
    }

    private void a(String str, List<com.opos.exoplayer.core.f.b> list, h hVar) {
        long j;
        StringBuilder sb;
        String str2;
        if (this.f25371c == 0) {
            sb = new StringBuilder();
            str2 = "Skipping dialogue line before complete format: ";
        } else {
            String[] split = str.substring(10).split(",", this.f25371c);
            if (split.length == this.f25371c) {
                long a2 = a(split[this.d]);
                if (a2 != com.anythink.expressad.exoplayer.b.b) {
                    String str3 = split[this.e];
                    if (str3.trim().isEmpty()) {
                        j = -9223372036854775807L;
                    } else {
                        long a3 = a(str3);
                        j = a3;
                        if (a3 == com.anythink.expressad.exoplayer.b.b) {
                            sb = new StringBuilder();
                        }
                    }
                    list.add(new com.opos.exoplayer.core.f.b(split[this.f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    hVar.a(a2);
                    if (j != com.anythink.expressad.exoplayer.b.b) {
                        list.add(null);
                        hVar.a(j);
                        return;
                    }
                    return;
                }
                sb = new StringBuilder();
                sb.append("Skipping invalid timing: ");
                sb.append(str);
                com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
            }
            sb = new StringBuilder();
            str2 = "Skipping dialogue line with fewer columns than format: ";
        }
        sb.append(str2);
        sb.append(str);
        com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
    }

    private void b(String str) {
        boolean z;
        String[] split = TextUtils.split(str.substring(8), ",");
        this.f25371c = split.length;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f25371c) {
                break;
            }
            String d = u.d(split[i2].trim());
            int hashCode = d.hashCode();
            if (hashCode == 100571) {
                if (d.equals("end")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 3556653) {
                if (hashCode == 109757538 && d.equals("start")) {
                    z = false;
                }
                z = true;
            } else {
                if (d.equals("text")) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                this.d = i2;
            } else if (z) {
                this.e = i2;
            } else if (z) {
                this.f = i2;
            }
            i = i2 + 1;
        }
        if (this.d == -1 || this.e == -1 || this.f == -1) {
            this.f25371c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        m mVar = new m(bArr, i);
        if (!this.b) {
            a(mVar);
        }
        a(mVar, arrayList, hVar);
        com.opos.exoplayer.core.f.b[] bVarArr = new com.opos.exoplayer.core.f.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, hVar.b());
    }
}
