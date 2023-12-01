package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.3sl.mq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/f.class */
public final class f {
    protected static String I;
    protected static String K;

    /* renamed from: a  reason: collision with root package name */
    public String f6433a = "1";
    protected short b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected String f6434c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;
    protected String l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> A = new ArrayList<>();
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<mq> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected String J = null;
    protected String L = null;
    protected String M = null;
    protected String N = null;
    protected int O = 0;
    private List<com.autonavi.aps.amapapi.restruct.f> S = null;
    private List<com.autonavi.aps.amapapi.restruct.d> T = Collections.synchronizedList(new ArrayList());
    final int P = 3;

    private static int a(String str, byte[] bArr, int i) {
        int i2 = i;
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "copyContentWithByteLen");
            bArr[i2] = 0;
            i = i2;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i] = 0;
            return i + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        int i3 = length;
        if (length > 127) {
            i3 = 127;
        }
        bArr[i] = (byte) i3;
        int i4 = i + 1;
        i2 = i4;
        System.arraycopy(bytes, 0, bArr, i4, i3);
        return i4 + i3;
    }

    private static void a(com.autonavi.aps.amapapi.restruct.d dVar, List<com.autonavi.aps.amapapi.restruct.d> list) {
        int i;
        if (dVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(dVar);
            return;
        }
        long j = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            com.autonavi.aps.amapapi.restruct.d dVar2 = list.get(i2);
            if (dVar.c() == null || !dVar.c().equals(dVar2.c())) {
                j = Math.min(j, dVar2.t);
                if (j == dVar2.t) {
                    i3 = i2;
                }
                i2++;
            } else {
                i = -1;
                if (dVar.s != dVar2.s) {
                    dVar2.t = dVar.t;
                    dVar2.s = dVar.s;
                    i = -1;
                }
            }
        }
        if (i >= 0) {
            if (size < 3) {
                list.add(dVar);
            } else if (dVar.t <= j || i >= size) {
            } else {
                list.remove(i);
                list.add(dVar);
            }
        }
    }

    private void a(ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList, ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.autonavi.aps.amapapi.restruct.d> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.autonavi.aps.amapapi.restruct.d next = it.next();
                if (next.r && next.n) {
                    a(next, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r0.length != 6) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            r10 = r0
            r0 = 6
            byte[] r0 = new byte[r0]
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L1f
            r0 = r10
            r9 = r0
            r0 = r10
            int r0 = r0.length     // Catch: java.lang.Throwable -> L5e
            r1 = 6
            if (r0 == r1) goto L92
        L1f:
            r0 = 6
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L5e
            r10 = r0
            r0 = 0
            r8 = r0
            goto L7b
        L2b:
            r0 = r11
            r10 = r0
            r0 = r8
            r1 = r9
            int r1 = r1.length     // Catch: java.lang.Throwable -> L5e
            if (r0 >= r1) goto L78
            r0 = r9
            r1 = r8
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L5e
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L5e
            r1 = 2
            if (r0 <= r1) goto L4a
            r0 = r9
            r1 = r8
            r2 = r9
            r3 = r8
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L5e
            r3 = 0
            r4 = 2
            java.lang.String r2 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L5e
            r0[r1] = r2     // Catch: java.lang.Throwable -> L5e
        L4a:
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r8
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L5e
            r3 = 16
            int r2 = java.lang.Integer.parseInt(r2, r3)     // Catch: java.lang.Throwable -> L5e
            byte r2 = (byte) r2     // Catch: java.lang.Throwable -> L5e
            r0[r1] = r2     // Catch: java.lang.Throwable -> L5e
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L2b
        L5e:
            r9 = move-exception
            r0 = r9
            java.lang.String r1 = "Req"
            java.lang.String r2 = "getMacBa "
            r3 = r7
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r2 = r2.concat(r3)
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r2)
            r0 = r6
            java.lang.String r1 = "00:00:00:00:00:00"
            byte[] r0 = r0.a(r1)
            r10 = r0
        L78:
            r0 = r10
            return r0
        L7b:
            r0 = r10
            r9 = r0
            r0 = r8
            r1 = 6
            if (r0 >= r1) goto L92
            r0 = r10
            r1 = r8
            java.lang.String r2 = "0"
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L7b
        L92:
            r0 = 0
            r8 = r0
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a(java.lang.String):byte[]");
    }

    private void b() {
        String[] strArr = new String[27];
        strArr[0] = this.f6433a;
        strArr[1] = this.f6434c;
        strArr[2] = this.d;
        strArr[3] = this.e;
        strArr[4] = this.f;
        strArr[5] = this.g;
        strArr[6] = this.h;
        strArr[7] = this.i;
        strArr[8] = this.l;
        strArr[9] = this.m;
        strArr[10] = this.n;
        strArr[11] = this.o;
        strArr[12] = this.p;
        strArr[13] = this.q;
        strArr[14] = this.r;
        strArr[15] = this.s;
        strArr[16] = this.t;
        strArr[17] = this.u;
        strArr[18] = this.v;
        strArr[19] = this.w;
        strArr[20] = this.x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 27) {
                break;
            }
            if (TextUtils.isEmpty(strArr[i2])) {
                strArr[i2] = "";
            }
            i = i2 + 1;
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = "0";
        } else if (!"0".equals(this.j) && !"2".equals(this.j)) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "0";
        } else if (!"0".equals(this.k) && !"1".equals(this.k)) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y)) {
            this.y = "0";
        } else if (!"1".equals(this.y) && !"2".equals(this.y)) {
            this.y = "0";
        }
        if (!com.autonavi.aps.amapapi.restruct.e.a(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01d1, code lost:
        if (r0 > 127) goto L54;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x03cc -> B:112:0x0350). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r7, boolean r8, boolean r9, com.autonavi.aps.amapapi.restruct.e r10, com.autonavi.aps.amapapi.restruct.i r11, android.net.ConnectivityManager r12, java.lang.String r13, com.autonavi.aps.amapapi.restruct.g r14) {
        /*
            Method dump skipped, instructions count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a(android.content.Context, boolean, boolean, com.autonavi.aps.amapapi.restruct.e, com.autonavi.aps.amapapi.restruct.i, android.net.ConnectivityManager, java.lang.String, com.autonavi.aps.amapapi.restruct.g):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:12|13|14|15|(18:342|(1:344)(1:449)|345|(7:347|(1:349)(1:425)|350|(1:352)(1:424)|353|(1:355)(1:423)|356)(15:426|(11:428|(1:430)(1:448)|431|(1:433)(1:447)|434|(1:436)(1:446)|437|(1:439)(1:445)|440|(1:442)(1:444)|443)|358|(1:360)(1:422)|361|(1:420)|363|364|(1:366)(1:419)|367|(1:369)|370|(1:372)|373|(2:375|(2:377|378)(2:379|(2:380|(12:382|(1:384)(1:414)|385|(1:387)(1:413)|388|(1:390)(1:412)|391|(1:410)|393|394|(1:409)(8:396|(1:398)(1:408)|399|(1:401)|402|(1:404)|405|406)|407)(1:415))))(2:416|(2:418|378)(0)))|357|358|(0)(0)|361|(0)|363|364|(0)(0)|367|(0)|370|(0)|373|(0)(0))(1:19)|20|(2:22|(22:24|25|26|27|28|29|30|31|32|(1:338)(2:36|(2:37|(7:39|(3:98|(1:100)|101)(3:45|(3:47|(1:49)|50)(2:92|(3:94|(1:96)|97))|51)|52|(1:90)|54|55|(3:77|(6:79|(1:81)|82|(1:84)|85|(3:87|72|73)(1:88))(1:89)|74)(3:61|(2:63|(7:65|(1:67)|68|(1:70)|71|72|73)(1:75))(1:76)|74))(1:102)))|103|(1:337)(28:107|108|109|110|111|112|113|114|115|116|117|118|119|120|(1:122)|123|124|125|126|127|128|(1:130)|334|132|133|134|135|(8:137|138|139|140|141|142|143|144))|146|(1:148)(7:292|(1:294)(1:333)|295|(1:297)|298|(2:299|(18:301|302|303|304|305|306|307|308|309|310|311|(1:313)(2:325|(1:327))|314|(1:316)|324|318|(2:320|321)(1:323)|322)(1:331))|332)|149|150|151|152|153|(2:155|156)|157|(29:288|289|166|167|168|(1:170)|171|172|173|(3:278|279|280)|175|176|177|178|179|180|181|182|(1:184)(1:273)|185|(1:187)|188|(5:190|(1:192)(1:245)|193|(4:196|197|(2:198|(11:200|(5:207|(6:209|210|211|(2:213|214)|215|216)(3:220|221|(7:223|224|225|(2:227|228)|229|230|231))|217|218|219)|232|233|234|(2:236|237)|238|239|217|218|219)(1:240))|241)|195)|246|(4:248|(1:250)(1:266)|251|(2:253|(2:254|(5:256|(1:258)|259|(2:261|262)(1:264)|263)(1:265)))(0))(0)|267|(1:269)|270|271)(34:159|160|161|162|163|164|165|166|167|168|(0)|171|172|173|(0)|175|176|177|178|179|180|181|182|(0)(0)|185|(0)|188|(0)|246|(0)(0)|267|(0)|270|271)))|341|32|(1:34)|338|103|(1:105)|337|146|(0)(0)|149|150|151|152|153|(0)|157|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x05ed, code lost:
        if (r12 < (-128)) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x09e4, code lost:
        if (r0 < (-128)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0e84, code lost:
        if (r12 < 0) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0f74, code lost:
        r26[r12] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x14d2, code lost:
        if (r0 < (-128)) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0484, code lost:
        if (r12 < (-128)) goto L363;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0bc4  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0d6d  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0d7c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0f37  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0f3d  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0fa2 A[Catch: all -> 0x14a7, TRY_ENTER, TryCatch #4 {all -> 0x14a7, blocks: (B:329:0x0f94, B:331:0x0fa2, B:333:0x0fb2), top: B:459:0x0f94 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x1035  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x103d  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x1066  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x1097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x12f1  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x143d  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x14dd  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0fca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0503  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a() {
        /*
            Method dump skipped, instructions count: 5354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a():byte[]");
    }
}
