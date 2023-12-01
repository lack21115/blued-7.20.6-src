package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f25151a = "SDKEcService";
    private static e b;
    private int e = -1;

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, a> f25152c = new LinkedHashMap();
    private Map<Integer, String> d = new LinkedHashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/e$a.class */
    public interface a {
        void a(String str);
    }

    public static e a() {
        if (b == null) {
            b = new e();
        }
        return b;
    }

    public void a(int i, a aVar) {
        String str;
        StringBuilder sb;
        String str2;
        String sb2;
        if (this.d.containsKey(Integer.valueOf(i))) {
            String str3 = this.d.get(Integer.valueOf(i));
            this.d.remove(Integer.valueOf(i));
            aVar.a(str3);
            str = f25151a;
            sb2 = "Executed command: " + i + ", extra: " + str3 + ", emergency configuration has requested";
        } else {
            if (this.e == -1) {
                this.f25152c.put(Integer.valueOf(i), aVar);
                str = f25151a;
                sb = new StringBuilder();
                sb.append("Emergency configuration has not yet dispatched. Command query: ");
                sb.append(i);
                str2 = " has been suspended";
            } else {
                str = f25151a;
                sb = new StringBuilder();
                sb.append("Emergency configuration has been dispatched, status: ");
                sb.append(this.e);
                sb.append(". Command query: ");
                sb.append(i);
                str2 = " ignored";
            }
            sb.append(str2);
            sb2 = sb.toString();
        }
        TbsLog.i(str, sb2);
    }

    public void a(int i, Map<Integer, String> map) {
        String str = f25151a;
        TbsLog.i(str, "Handle emergency commands in sdk, status: " + i);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i == 0) {
            for (Integer num : map.keySet()) {
                if (this.f25152c.containsKey(num)) {
                    a aVar = this.f25152c.get(num);
                    if (aVar != null) {
                        aVar.a(map.get(num));
                    }
                } else {
                    String str2 = map.get(num);
                    if (str2 == null) {
                        str2 = "";
                    }
                    linkedHashMap.put(num, str2);
                }
            }
        } else {
            this.f25152c.clear();
            String str3 = f25151a;
            TbsLog.i(str3, "Handle emergency commands failed, ignore all unhandled emergencies, status: " + i);
        }
        this.d = linkedHashMap;
        this.e = i;
    }
}
