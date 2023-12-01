package com.getui.gtc.dim;

import android.text.TextUtils;
import com.getui.gtc.dim.b.b;
import com.getui.gtc.dim.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final com.getui.gtc.dim.b.a f8323a;
    final b b;

    /* renamed from: c  reason: collision with root package name */
    final e f8324c;
    final Map<String, Boolean> d;
    private final Map<String, Object> e;
    private final Map<String, List<String>> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.dim.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/a$a.class */
    public static final class C0173a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f8325a = new a((byte) 0);
    }

    private a() {
        this.e = new ConcurrentHashMap();
        this.f = new HashMap();
        this.d = new HashMap();
        this.f8323a = com.getui.gtc.dim.b.a.a();
        this.b = b.a.a();
        this.f8324c = e.a();
        Map<String, List<String>> map = this.f;
        ArrayList arrayList = new ArrayList();
        arrayList.add("dim-2-1-21-5");
        arrayList.add("dim-2-1-21-3");
        arrayList.add("dim-2-1-21-1");
        arrayList.add("dim-2-1-21-2");
        map.put("dim-2-1-21-4", arrayList);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06b2 A[Catch: all -> 0x09e1, TRY_LEAVE, TryCatch #0 {, blocks: (B:37:0x00f9, B:39:0x0103, B:42:0x0110, B:46:0x0130, B:48:0x013b, B:50:0x014f, B:52:0x0162, B:52:0x0162, B:53:0x0165, B:51:0x0157, B:56:0x017a, B:59:0x01aa, B:62:0x01c0, B:63:0x01ca, B:69:0x022e, B:72:0x024f, B:73:0x027e, B:78:0x0289, B:82:0x029a, B:85:0x02b2, B:86:0x02c8, B:88:0x03be, B:204:0x0599, B:207:0x05b5, B:210:0x05cc, B:211:0x05d6, B:217:0x063b, B:220:0x065d, B:221:0x069a, B:92:0x03cc, B:96:0x03dc, B:100:0x03ec, B:104:0x03fc, B:108:0x040c, B:112:0x041c, B:116:0x042d, B:120:0x043e, B:124:0x044f, B:128:0x045f, B:132:0x046f, B:136:0x047f, B:140:0x048f, B:144:0x049f, B:148:0x04af, B:152:0x04bf, B:156:0x04cf, B:160:0x04df, B:164:0x04ef, B:168:0x0500, B:172:0x0511, B:176:0x0522, B:180:0x0533, B:184:0x0544, B:188:0x0555, B:192:0x0566, B:196:0x0577, B:200:0x0588, B:224:0x069d, B:226:0x06b2, B:229:0x06ca, B:231:0x06dc, B:232:0x06df, B:234:0x0762, B:296:0x0857, B:297:0x0860, B:301:0x08b4, B:303:0x08bf, B:304:0x090b, B:309:0x0913, B:311:0x091e, B:312:0x096a, B:238:0x0770, B:242:0x0780, B:246:0x0790, B:250:0x07a0, B:254:0x07b0, B:258:0x07c0, B:262:0x07d1, B:266:0x07e2, B:270:0x07f3, B:274:0x0803, B:278:0x0813, B:282:0x0823, B:286:0x0833, B:290:0x0843, B:315:0x096d, B:317:0x097d, B:319:0x09d8, B:320:0x09de), top: B:353:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x097d A[Catch: all -> 0x09e1, TryCatch #0 {, blocks: (B:37:0x00f9, B:39:0x0103, B:42:0x0110, B:46:0x0130, B:48:0x013b, B:50:0x014f, B:52:0x0162, B:52:0x0162, B:53:0x0165, B:51:0x0157, B:56:0x017a, B:59:0x01aa, B:62:0x01c0, B:63:0x01ca, B:69:0x022e, B:72:0x024f, B:73:0x027e, B:78:0x0289, B:82:0x029a, B:85:0x02b2, B:86:0x02c8, B:88:0x03be, B:204:0x0599, B:207:0x05b5, B:210:0x05cc, B:211:0x05d6, B:217:0x063b, B:220:0x065d, B:221:0x069a, B:92:0x03cc, B:96:0x03dc, B:100:0x03ec, B:104:0x03fc, B:108:0x040c, B:112:0x041c, B:116:0x042d, B:120:0x043e, B:124:0x044f, B:128:0x045f, B:132:0x046f, B:136:0x047f, B:140:0x048f, B:144:0x049f, B:148:0x04af, B:152:0x04bf, B:156:0x04cf, B:160:0x04df, B:164:0x04ef, B:168:0x0500, B:172:0x0511, B:176:0x0522, B:180:0x0533, B:184:0x0544, B:188:0x0555, B:192:0x0566, B:196:0x0577, B:200:0x0588, B:224:0x069d, B:226:0x06b2, B:229:0x06ca, B:231:0x06dc, B:232:0x06df, B:234:0x0762, B:296:0x0857, B:297:0x0860, B:301:0x08b4, B:303:0x08bf, B:304:0x090b, B:309:0x0913, B:311:0x091e, B:312:0x096a, B:238:0x0770, B:242:0x0780, B:246:0x0790, B:250:0x07a0, B:254:0x07b0, B:258:0x07c0, B:262:0x07d1, B:266:0x07e2, B:270:0x07f3, B:274:0x0803, B:278:0x0813, B:282:0x0823, B:286:0x0833, B:290:0x0843, B:315:0x096d, B:317:0x097d, B:319:0x09d8, B:320:0x09de), top: B:353:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a A[Catch: all -> 0x09e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:37:0x00f9, B:39:0x0103, B:42:0x0110, B:46:0x0130, B:48:0x013b, B:50:0x014f, B:52:0x0162, B:52:0x0162, B:53:0x0165, B:51:0x0157, B:56:0x017a, B:59:0x01aa, B:62:0x01c0, B:63:0x01ca, B:69:0x022e, B:72:0x024f, B:73:0x027e, B:78:0x0289, B:82:0x029a, B:85:0x02b2, B:86:0x02c8, B:88:0x03be, B:204:0x0599, B:207:0x05b5, B:210:0x05cc, B:211:0x05d6, B:217:0x063b, B:220:0x065d, B:221:0x069a, B:92:0x03cc, B:96:0x03dc, B:100:0x03ec, B:104:0x03fc, B:108:0x040c, B:112:0x041c, B:116:0x042d, B:120:0x043e, B:124:0x044f, B:128:0x045f, B:132:0x046f, B:136:0x047f, B:140:0x048f, B:144:0x049f, B:148:0x04af, B:152:0x04bf, B:156:0x04cf, B:160:0x04df, B:164:0x04ef, B:168:0x0500, B:172:0x0511, B:176:0x0522, B:180:0x0533, B:184:0x0544, B:188:0x0555, B:192:0x0566, B:196:0x0577, B:200:0x0588, B:224:0x069d, B:226:0x06b2, B:229:0x06ca, B:231:0x06dc, B:232:0x06df, B:234:0x0762, B:296:0x0857, B:297:0x0860, B:301:0x08b4, B:303:0x08bf, B:304:0x090b, B:309:0x0913, B:311:0x091e, B:312:0x096a, B:238:0x0770, B:242:0x0780, B:246:0x0790, B:250:0x07a0, B:254:0x07b0, B:258:0x07c0, B:262:0x07d1, B:266:0x07e2, B:270:0x07f3, B:274:0x0803, B:278:0x0813, B:282:0x0823, B:286:0x0833, B:290:0x0843, B:315:0x096d, B:317:0x097d, B:319:0x09d8, B:320:0x09de), top: B:353:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0289 A[Catch: all -> 0x09e1, TRY_ENTER, TryCatch #0 {, blocks: (B:37:0x00f9, B:39:0x0103, B:42:0x0110, B:46:0x0130, B:48:0x013b, B:50:0x014f, B:52:0x0162, B:52:0x0162, B:53:0x0165, B:51:0x0157, B:56:0x017a, B:59:0x01aa, B:62:0x01c0, B:63:0x01ca, B:69:0x022e, B:72:0x024f, B:73:0x027e, B:78:0x0289, B:82:0x029a, B:85:0x02b2, B:86:0x02c8, B:88:0x03be, B:204:0x0599, B:207:0x05b5, B:210:0x05cc, B:211:0x05d6, B:217:0x063b, B:220:0x065d, B:221:0x069a, B:92:0x03cc, B:96:0x03dc, B:100:0x03ec, B:104:0x03fc, B:108:0x040c, B:112:0x041c, B:116:0x042d, B:120:0x043e, B:124:0x044f, B:128:0x045f, B:132:0x046f, B:136:0x047f, B:140:0x048f, B:144:0x049f, B:148:0x04af, B:152:0x04bf, B:156:0x04cf, B:160:0x04df, B:164:0x04ef, B:168:0x0500, B:172:0x0511, B:176:0x0522, B:180:0x0533, B:184:0x0544, B:188:0x0555, B:192:0x0566, B:196:0x0577, B:200:0x0588, B:224:0x069d, B:226:0x06b2, B:229:0x06ca, B:231:0x06dc, B:232:0x06df, B:234:0x0762, B:296:0x0857, B:297:0x0860, B:301:0x08b4, B:303:0x08bf, B:304:0x090b, B:309:0x0913, B:311:0x091e, B:312:0x096a, B:238:0x0770, B:242:0x0780, B:246:0x0790, B:250:0x07a0, B:254:0x07b0, B:258:0x07c0, B:262:0x07d1, B:266:0x07e2, B:270:0x07f3, B:274:0x0803, B:278:0x0813, B:282:0x0823, B:286:0x0833, B:290:0x0843, B:315:0x096d, B:317:0x097d, B:319:0x09d8, B:320:0x09de), top: B:353:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b2 A[Catch: all -> 0x09e1, TRY_ENTER, TryCatch #0 {, blocks: (B:37:0x00f9, B:39:0x0103, B:42:0x0110, B:46:0x0130, B:48:0x013b, B:50:0x014f, B:52:0x0162, B:52:0x0162, B:53:0x0165, B:51:0x0157, B:56:0x017a, B:59:0x01aa, B:62:0x01c0, B:63:0x01ca, B:69:0x022e, B:72:0x024f, B:73:0x027e, B:78:0x0289, B:82:0x029a, B:85:0x02b2, B:86:0x02c8, B:88:0x03be, B:204:0x0599, B:207:0x05b5, B:210:0x05cc, B:211:0x05d6, B:217:0x063b, B:220:0x065d, B:221:0x069a, B:92:0x03cc, B:96:0x03dc, B:100:0x03ec, B:104:0x03fc, B:108:0x040c, B:112:0x041c, B:116:0x042d, B:120:0x043e, B:124:0x044f, B:128:0x045f, B:132:0x046f, B:136:0x047f, B:140:0x048f, B:144:0x049f, B:148:0x04af, B:152:0x04bf, B:156:0x04cf, B:160:0x04df, B:164:0x04ef, B:168:0x0500, B:172:0x0511, B:176:0x0522, B:180:0x0533, B:184:0x0544, B:188:0x0555, B:192:0x0566, B:196:0x0577, B:200:0x0588, B:224:0x069d, B:226:0x06b2, B:229:0x06ca, B:231:0x06dc, B:232:0x06df, B:234:0x0762, B:296:0x0857, B:297:0x0860, B:301:0x08b4, B:303:0x08bf, B:304:0x090b, B:309:0x0913, B:311:0x091e, B:312:0x096a, B:238:0x0770, B:242:0x0780, B:246:0x0790, B:250:0x07a0, B:254:0x07b0, B:258:0x07c0, B:262:0x07d1, B:266:0x07e2, B:270:0x07f3, B:274:0x0803, B:278:0x0813, B:282:0x0823, B:286:0x0833, B:290:0x0843, B:315:0x096d, B:317:0x097d, B:319:0x09d8, B:320:0x09de), top: B:353:0x00f9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.getui.gtc.dim.DimRequest r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 2832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.a.a(com.getui.gtc.dim.DimRequest, boolean):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f.put(str, arrayList);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                com.getui.gtc.dim.e.b.a("dim complex policy set: " + str + " : " + str2);
                return;
            }
            arrayList.add(split[i2].trim().toLowerCase());
            i = i2 + 1;
        }
    }
}
