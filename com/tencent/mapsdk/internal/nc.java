package com.tencent.mapsdk.internal;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nc.class */
public class nc extends Paint {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<TencentMapContext> f37664a;

    public nc(TencentMapContext tencentMapContext) {
        this.f37664a = new WeakReference<>(tencentMapContext);
    }

    @Override // android.graphics.Paint
    public Typeface setTypeface(Typeface typeface) {
        TencentMapContext tencentMapContext;
        WeakReference<TencentMapContext> weakReference = this.f37664a;
        if (weakReference == null || (tencentMapContext = weakReference.get()) == null) {
            return super.setTypeface(typeface);
        }
        Typeface typeface2 = tencentMapContext.getTypeface();
        return (typeface2 == null || !(Typeface.DEFAULT == typeface || Typeface.DEFAULT_BOLD == typeface)) ? super.setTypeface(typeface) : super.setTypeface(typeface2);
    }
}
