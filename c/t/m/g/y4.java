package c.t.m.g;

import android.net.wifi.ScanResult;
import com.igexin.assist.util.AssistUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y4.class */
public class y4 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f4065a;

    static {
        ArrayList arrayList = new ArrayList();
        f4065a = arrayList;
        arrayList.add("mobile");
        f4065a.add("16wifi");
        f4065a.add("cmcc");
        f4065a.add("360wifi");
        f4065a.add("androidap");
        f4065a.add("htcphone");
        f4065a.add(AssistUtils.BRAND_XIAOMI);
        f4065a.add("lenovo");
        f4065a.add("macbook");
    }

    public static void a(List<ScanResult> list) {
        HashSet hashSet = new HashSet();
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().BSSID;
            if (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00") || str.equals("02:00:00:00:00:00")) {
                it.remove();
            } else if (hashSet.contains(str)) {
                it.remove();
            } else {
                hashSet.add(str);
            }
        }
    }
}
