package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/a/b.class */
public class b implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6453a = "ViewPager2";
    public static final String b = "RVAdapter";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6454c = "RVViewHolder";
    public static final String d = "ViewCompat";
    public static final String e = "p_e";
    private static final String f = "p_init";
    private static final String g = "p_set_class";
    private static final String h = "e_t";
    private static final String i = "e_n";
    private static final String j = "e_a";
    private static final String k = "e_r";
    private static final String l = "e_d";
    private final IAdInterListener m;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/a/b$a.class */
    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, IAdInterListener iAdInterListener, Object[] objArr) {
            if (b.f6453a.equals(str) && b.a(objArr, Context.class)) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (b.b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (b.f6454c.equals(str) && b.a(objArr, View.class)) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (b.d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a2;
            if (iOAdEvent != null) {
                try {
                    if (!b.e.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
                        return;
                    }
                    Object obj = data.get(b.h);
                    Object obj2 = data.get(b.i);
                    Object obj3 = data.get(b.j);
                    Object[] objArr = null;
                    if (obj3 instanceof Object[]) {
                        objArr = (Object[]) obj3;
                    }
                    if ((obj2 instanceof String) && (obj instanceof String)) {
                        if (b.f.equals((String) obj2)) {
                            Object obj4 = data.get(b.l);
                            if (!(obj4 instanceof IAdInterListener) || (a2 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                return;
                            }
                            data.put(b.k, a2);
                        } else if (b.g.equals((String) obj2) && (obj3 instanceof Map)) {
                            Map map = (Map) obj3;
                            map.put(b.f6453a, ViewPager2.class);
                            map.put(b.b, RecyclerView.Adapter.class);
                            map.put(b.f6454c, RecyclerView.ViewHolder.class);
                        }
                    }
                } catch (Throwable th) {
                    bq.a().b(th.getMessage());
                }
            }
        }
    }

    private b(IAdInterListener iAdInterListener, com.baidu.mobads.sdk.internal.a.a aVar) {
        this.m = iAdInterListener;
        iAdInterListener.addEventListener(e, new c(this, aVar));
    }

    public static b a(IAdInterListener iAdInterListener, com.baidu.mobads.sdk.internal.a.a aVar) {
        return new b(iAdInterListener, aVar);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= clsArr.length) {
                return true;
            }
            if (!clsArr[i3].isInstance(objArr[i3])) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(j, objArr);
        this.m.onAdTaskProcess(str, hashMap);
        return hashMap.get(k);
    }

    public final void a(String str) {
        this.m.onAdTaskProcess(str);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.m;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }
}
