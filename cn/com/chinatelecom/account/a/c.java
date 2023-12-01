package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.e.g;
import com.baidu.mobads.sdk.internal.bw;
import java.net.URLEncoder;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.codec.language.bm.Rule;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/a/c.class */
public class c extends cn.com.chinatelecom.account.api.d.a {
    private static final String b = c.class.getSimpleName();

    private static void a(Context context, int i) {
        try {
            cn.com.chinatelecom.account.api.e.c.a(context, "key_c_l_l_v", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        boolean z;
        int hashCode = str.hashCode();
        int i = -1;
        if (hashCode == 64897) {
            if (str.equals(Rule.ALL)) {
                z = false;
            }
            z = true;
        } else if (hashCode != 78159) {
            if (hashCode == 66247144 && str.equals(bw.l)) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("OFF")) {
                z = true;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                if (z) {
                    i = -2;
                }
            }
            a(context, i);
        }
        i = 0;
        a(context, i);
    }

    public static void a(Context context, List<String> list) {
        int b2 = b(context);
        if (b2 == -2) {
            return;
        }
        b(context, list, b2);
    }

    private static int b(Context context) {
        try {
            return cn.com.chinatelecom.account.api.e.c.b(context, "key_c_l_l_v", 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static String b(Context context, String str) {
        return a.a(context, g.c(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, Queue<String> queue) {
        JSONArray jSONArray = new JSONArray();
        String jSONArray2 = jSONArray.toString();
        if (!queue.isEmpty()) {
            for (String str : queue) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONArray.length() <= 0) {
            return "";
        }
        String jSONArray3 = jSONArray.toString();
        String str2 = jSONArray2;
        if (!TextUtils.isEmpty(jSONArray3)) {
            try {
                str2 = URLEncoder.encode(Helper.guulam(context, jSONArray3), "UTF-8");
            } catch (Exception e2) {
                e2.printStackTrace();
                str2 = jSONArray2;
            }
        }
        return b(context, str2);
    }

    private static void b(final Context context, final List<String> list, final int i) {
        a(new Runnable() { // from class: cn.com.chinatelecom.account.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                Exception e;
                try {
                    Queue c2 = c.c(Context.this, list, i);
                    if (c2.isEmpty()) {
                        return;
                    }
                    String b2 = c.b(Context.this, c2);
                    JSONObject jSONObject = null;
                    int i2 = -1;
                    try {
                        if (!TextUtils.isEmpty(b2)) {
                            jSONObject = new JSONObject(b2);
                            try {
                                i2 = jSONObject.getInt("code");
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                i2 = -1;
                                if (jSONObject != null) {
                                }
                                c.b(Context.this, c2, i);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        jSONObject = null;
                        e = e3;
                    }
                    if (jSONObject != null || i2 != 0) {
                        c.b(Context.this, c2, i);
                        return;
                    }
                    c.c(Context.this);
                    c2.clear();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Queue<String> queue, int i) {
        String str;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (queue != null && !queue.isEmpty()) {
            int i2 = 0;
            for (String str2 : queue) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i != -1 || jSONObject.getInt("rt") != 0) {
                    jSONArray.put(jSONObject);
                    int i3 = i2 + 1;
                    i2 = i3;
                    if (i3 > 10) {
                        break;
                    }
                }
            }
        }
        if (jSONArray.length() > 0) {
            try {
                str = Helper.eneulret(jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Queue<String> c(Context context, List<String> list, int i) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (c.class) {
            try {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                String a2 = b.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(new String(Helper.dneulret(cn.com.chinatelecom.account.api.a.c.a(a2))));
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length && i2 <= 10; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject != null) {
                                concurrentLinkedQueue.add(jSONObject.toString());
                            }
                        }
                        b.a(context, "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i == -1) {
                    for (String str : list) {
                        try {
                            if (new JSONObject(str).getInt("rt") != 0) {
                                concurrentLinkedQueue.add(str);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (i == 0) {
                    concurrentLinkedQueue.addAll(list);
                }
                while (concurrentLinkedQueue.size() > 10) {
                    concurrentLinkedQueue.poll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentLinkedQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        b.a(context, "");
    }
}
