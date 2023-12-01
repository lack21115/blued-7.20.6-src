package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.br;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/processor/b.class */
public class b implements IPerfProcessor {

    /* renamed from: a  reason: collision with root package name */
    protected Context f41182a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f106a;

    public b(Context context) {
        this.f41182a = context;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.f41182a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String b = b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                return null;
            }
            String str = b + i2;
            if (br.m11552a(this.f41182a, str)) {
                return str;
            }
            i = i2 + 1;
        }
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        br.a(this.f41182a, "perf", "perfUploading");
        File[] m11553a = br.m11553a(this.f41182a, "perfUploading");
        if (m11553a == null || m11553a.length <= 0) {
            return;
        }
        int length = m11553a.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file = m11553a[i2];
            if (file != null) {
                List<String> a2 = e.a(this.f41182a, file.getAbsolutePath());
                file.delete();
                a(a2);
            }
            i = i2 + 1;
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo11403a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f106a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f106a.get(a2);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap2.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap2.put(a3, perfClientReport);
            this.f106a.put(a2, hashMap2);
        }
    }

    public void a(List<String> list) {
        br.a(this.f41182a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String c2 = c(aVarArr[0]);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        e.a(c2, aVarArr);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f106a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f106a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f106a.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f106a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f106a = hashMap;
    }
}
