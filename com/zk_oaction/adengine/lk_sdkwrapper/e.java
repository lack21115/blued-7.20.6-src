package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> f41969a = new HashMap<>();
    private Context b;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/e$a.class */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.zk_oaction.adengine.lk_sdkwrapper.a f41970a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f41971c;
        final /* synthetic */ boolean d;

        a(com.zk_oaction.adengine.lk_sdkwrapper.a aVar, int i, int i2, boolean z) {
            this.f41970a = aVar;
            this.b = i;
            this.f41971c = i2;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f41970a == null || e.this.b == null) {
                    return;
                }
                this.f41970a.a(this.b, this.f41971c);
                HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap = e.this.f41969a;
                if (hashMap != null) {
                    hashMap.put(this.f41970a.e(), this.f41970a);
                }
                if (this.d) {
                    this.f41970a.c();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public View a(String str, int i, int i2, boolean z, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i3, Map map, int i4) {
        if (this.b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/native_match_w");
        com.zk_oaction.adengine.lk_sdkwrapper.a a2 = new File(sb.toString()).exists() ? a(str, hashMap, aVar, i3, map, i4) : new com.zk_oaction.adengine.lk_sdkwrapper.a(this.b, i4, str, hashMap, i3, map, aVar);
        a2.a(i, i2);
        HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap2 = this.f41969a;
        if (hashMap2 != null) {
            hashMap2.put(a2.e(), a2);
        }
        if (z) {
            a2.c();
        }
        return a2;
    }

    public com.zk_oaction.adengine.lk_sdkwrapper.a a(String str, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i, Map map, int i2) {
        return new b(this.b, i2, str, hashMap, i, map, aVar);
    }

    public void a(Context context) {
        synchronized (this) {
            this.b = context;
        }
    }

    public void a(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).c();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void a(View view, HashMap<ZkViewSDK.KEY, Object> hashMap) {
        if (view != null) {
            try {
                if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                    ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).a(hashMap);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(View view, boolean z) {
        if (view != null) {
            try {
                if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                    ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).a(z);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public View b(String str, int i, int i2, boolean z, HashMap<ZkViewSDK.KEY, Object> hashMap, ZkViewSDK.a aVar, int i3, Map map, int i4) {
        if (this.b == null) {
            return null;
        }
        c cVar = new c(this.b, i4, str, hashMap, i3, map, aVar);
        new Handler(Looper.getMainLooper()).post(new a(cVar, i, i2, z));
        return cVar;
    }

    public void b(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).d();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void c(View view) {
        synchronized (this) {
            if (view != null) {
                try {
                    if (view instanceof com.zk_oaction.adengine.lk_sdkwrapper.a) {
                        ((com.zk_oaction.adengine.lk_sdkwrapper.a) view).b();
                        HashMap<String, com.zk_oaction.adengine.lk_sdkwrapper.a> hashMap = this.f41969a;
                        if (hashMap != null && hashMap.containsKey(((com.zk_oaction.adengine.lk_sdkwrapper.a) view).e())) {
                            this.f41969a.remove(((com.zk_oaction.adengine.lk_sdkwrapper.a) view).e());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
