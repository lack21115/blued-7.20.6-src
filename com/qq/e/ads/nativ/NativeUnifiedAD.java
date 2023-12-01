package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/NativeUnifiedAD.class */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {
    private AdListenerAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private NativeADUnifiedListener f14195c;
    private List<Integer> d = new ArrayList();
    private List<String> e;
    private volatile int f;
    private volatile int g;
    private String h;
    private LoadAdParams i;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/NativeUnifiedAD$AdListenerAdapter.class */
    static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private NativeADUnifiedListener f14196a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f14196a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f14196a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f14196a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List<NativeUnifiedADData> list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                }
                this.f14196a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f14195c = nativeADUnifiedListener;
        this.b = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f14195c = nativeADUnifiedListener;
        this.b = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.d.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.f14163a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.i;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.f);
        nuadi.setMaxVideoDuration(this.g);
        nuadi.setVastClassName(this.h);
        List<String> list = this.e;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.d) {
            a(num.intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f14195c;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f14163a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        a(i, true);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.i = loadAdParams;
        loadData(i);
    }

    public void setCategories(List<String> list) {
        this.e = list;
        T t = this.f14163a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.g = i;
        if (this.g > 0 && this.f > this.g) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f14163a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.g);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f = i;
        if (this.g > 0 && this.f > this.g) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f14163a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.f);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.h = str;
        T t = this.f14163a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }
}
