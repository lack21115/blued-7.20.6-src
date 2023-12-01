package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.widget.ImageView;
import com.huawei.hms.ads.lc;
import com.huawei.openalliance.ad.inter.data.b;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jx.class */
public interface jx<V extends lc> {
    boolean B();

    void Code(Context context, ImageView imageView, Drawable drawable);

    void Code(Location location);

    void Code(RequestOptions requestOptions);

    void Code(com.huawei.openalliance.ad.inter.data.n nVar);

    void Code(com.huawei.openalliance.ad.inter.data.t tVar);

    void Code(Integer num);

    void Code(String str, int i, List<String> list, int i2);

    void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j);

    boolean Code(b bVar, float f);

    void I(Integer num);

    void V(Integer num);

    void V(String str);
}
