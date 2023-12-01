package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kl.class */
public class kl {
    private static final int C = 0;
    private static final String Code = "ClctCtxProcessor";
    private static kl Z;
    private Context d;
    private Class<?> e;
    private static final byte[] V = new byte[0];
    private static final byte[] I = new byte[0];
    private static Map<String, String[]> B = new ConcurrentHashMap();
    private int S = 0;
    private int F = 0;
    private int D = 0;
    private int L = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f22513a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f22514c = 100;

    private kl(Context context) {
        this.d = context.getApplicationContext();
        try {
            this.e = Class.forName("com.huawei.openalliance.ad.views.PPSNativeView");
        } catch (Throwable th) {
            ge.I(Code, "init unClctViewClass error");
        }
    }

    public static kl Code(Context context) {
        return I(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if (android.text.TextUtils.isEmpty(r8) == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> Code(android.view.View r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.kl.Code(android.view.View, int, int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, String> Code(Context context, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!com.huawei.openalliance.ad.utils.af.Code(map)) {
            Code(context, "title", map, hashMap);
            Code(context, "content", map, hashMap);
            Code(context, "category", map, hashMap);
            Code(context, com.huawei.openalliance.ad.constant.t.ck, map, hashMap);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Activity activity, Map<Integer, String> map, int i) {
        HashMap hashMap = new HashMap();
        this.F = 0;
        this.L = 0;
        this.f22513a = 0;
        this.D = 0;
        Code(activity.getWindow().getDecorView(), map, hashMap, i, this.b);
        if (com.huawei.openalliance.ad.utils.af.Code(hashMap)) {
            ge.Code(Code, "no get cfg, getAutoContent");
            String[] Code2 = Code(activity, i);
            if (Code2 == null || Code2.length <= 0) {
                return;
            }
            B.put(com.huawei.openalliance.ad.constant.t.cf, Code2);
            return;
        }
        Code(hashMap, "title", B);
        if (!Code(hashMap, "content", B)) {
            ge.Code(Code, "no get cfg content, getAutoContent");
            String[] Code3 = Code(activity, i);
            if (Code3 != null && Code3.length > 0) {
                B.put(com.huawei.openalliance.ad.constant.t.cf, Code3);
            }
        }
        Code(hashMap, "category", B);
        Code(hashMap, com.huawei.openalliance.ad.constant.t.ck, B);
    }

    private void Code(Context context, String str, Map<String, String> map, Map<Integer, String> map2) {
        List<String> list = (List) com.huawei.openalliance.ad.utils.z.V(map.get(str), List.class, new Class[0]);
        if (aa.Code(list)) {
            return;
        }
        for (String str2 : list) {
            int identifier = context.getResources().getIdentifier(str2, "id", context.getPackageName());
            if (identifier != 0) {
                map2.put(Integer.valueOf(identifier), str);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void Code(View view, Map<Integer, String> map, Map<String, List<String>> map2, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i5 = i2 + 1;
        if (i5 >= this.f22514c) {
            ge.Code(Code, "clctCfgContentDepth outer round " + this.f22514c);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= viewGroup.getChildCount()) {
                return;
            }
            View childAt = viewGroup.getChildAt(i7);
            if (childAt instanceof TextView) {
                int id = childAt.getId();
                if (map.containsKey(Integer.valueOf(id))) {
                    String charSequence = ((TextView) childAt).getText().toString();
                    int length = charSequence.length();
                    String str = map.get(Integer.valueOf(id));
                    ArrayList arrayList = map2.containsKey(str) ? map2.get(str) : new ArrayList();
                    switch (str.hashCode()) {
                        case 50511102:
                            if (str.equals("category")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 110371416:
                            if (str.equals("title")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 951530617:
                            if (str.equals("content")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 1300380478:
                            if (str.equals(com.huawei.openalliance.ad.constant.t.ck)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (!z) {
                        i3 = this.F;
                        i4 = length + i3;
                        this.F = i4;
                    } else if (z) {
                        i3 = this.D;
                        i4 = length + i3;
                        this.D = i4;
                    } else if (z) {
                        i3 = this.L;
                        i4 = length + i3;
                        this.L = i4;
                    } else if (!z) {
                        i4 = 0;
                        i3 = 0;
                    } else {
                        i3 = this.f22513a;
                        i4 = length + i3;
                        this.f22513a = i4;
                    }
                    if (i3 >= i || i4 >= i) {
                        if (i3 < i && i4 >= i) {
                            int length2 = (charSequence.length() + i) - i4;
                            if (!TextUtils.isEmpty(charSequence.substring(0, length2))) {
                                arrayList.add(charSequence.substring(0, length2));
                            }
                        }
                    } else if (!TextUtils.isEmpty(charSequence)) {
                        arrayList.add(charSequence);
                    }
                    map2.put(str, arrayList);
                }
            }
            Code(childAt, map, map2, i, i5);
            i6 = i7 + 1;
        }
    }

    private boolean Code(View view) {
        Class<?> cls = this.e;
        return cls != null && cls.isInstance(view);
    }

    private boolean Code(Map<String, List<String>> map, String str, Map<String, String[]> map2) {
        if (map.containsKey(str)) {
            List<String> list = map.get(str);
            if (!aa.Code(list)) {
                map2.put(str, (String[]) list.toArray(new String[list.size()]));
                return true;
            }
            ge.Code(Code, "get %s is null " + str);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] Code(Activity activity, int i) {
        this.S = 0;
        List<String> Code2 = Code(activity.getWindow().getDecorView(), i, this.b);
        if (aa.Code(Code2)) {
            ge.Code(Code, "get contentAuto is null");
            return new String[0];
        }
        return (String[]) Code2.toArray(new String[Code2.size()]);
    }

    private static kl I(Context context) {
        kl klVar;
        synchronized (V) {
            if (Z == null) {
                Z = new kl(context);
            }
            klVar = Z;
        }
        return klVar;
    }

    public String Code() {
        if (fk.Code(this.d).ae()) {
            ge.Code(Code, "get AutoContentBundle");
            return com.huawei.openalliance.ad.utils.z.V(B);
        }
        ge.Code(Code, "get AutoContentBundle off");
        B.clear();
        return null;
    }

    public void V(final Context context) {
        com.huawei.openalliance.ad.utils.f.B(new Runnable() { // from class: com.huawei.hms.ads.kl.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    fk Code2 = fk.Code(context);
                    if (Code2.ae()) {
                        int N = Code2.N() * 1000;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - Code2.af() <= N && N != 0) {
                            ge.Code(kl.Code, "collect AutoContentBundle is limited in %s ", Integer.valueOf(N));
                            return;
                        }
                        ge.Code(kl.Code, "collectAutoContentBundle");
                        Code2.I(currentTimeMillis);
                        if (context instanceof Activity) {
                            Activity activity = (Activity) context;
                            String simpleName = activity.getClass().getSimpleName();
                            ge.Code(kl.Code, "getActivityInfo-name: %s", activity.getClass().getSimpleName());
                            if (!com.huawei.openalliance.ad.utils.au.Code(simpleName)) {
                                kl.B.clear();
                                kl.B.put("activityName", new String[]{simpleName});
                            }
                            Map Code3 = kl.this.Code(activity, Code2.P());
                            int O = Code2.O();
                            if (!com.huawei.openalliance.ad.utils.af.Code(Code3)) {
                                kl.this.Code(activity, Code3, O);
                                return;
                            }
                            ge.Code(kl.Code, "no id list, getAutoContent");
                            String[] Code4 = kl.this.Code(activity, O);
                            if (Code4 == null || Code4.length <= 0) {
                                return;
                            }
                            kl.B.put(com.huawei.openalliance.ad.constant.t.cf, Code4);
                            return;
                        }
                        str = "getActivityInfo-name: not Activity";
                    } else {
                        kl.B.clear();
                        str = "collectAutoContentBundle off";
                    }
                    ge.Code(kl.Code, str);
                } catch (Throwable th) {
                    ge.Code(kl.Code, "collect AutoContentBundle error: %s", th.getClass().getSimpleName());
                }
            }
        });
    }
}
