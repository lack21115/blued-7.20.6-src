package com.huawei.hms.ads.unity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.bs;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/unity/UnityImageUtil.class */
public class UnityImageUtil {
    private static UnityImageUtil I;
    private static final byte[] V = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.unity.UnityImageUtil$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/unity/UnityImageUtil$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[UnityImageType.values().length];
            Code = iArr;
            try {
                iArr[UnityImageType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[UnityImageType.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[UnityImageType.CHOICESINFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private UnityImageUtil() {
    }

    private k Code(g gVar, String str, UnityImageType unityImageType) {
        int i = AnonymousClass2.Code[unityImageType.ordinal()];
        if (i == 1) {
            k I2 = gVar.I();
            if (TextUtils.equals(str, I2.Z())) {
                return I2;
            }
            return null;
        } else if (i != 2) {
            return null;
        } else {
            for (k kVar : gVar.Z()) {
                if (TextUtils.equals(str, kVar.Z())) {
                    return kVar;
                }
            }
            return null;
        }
    }

    public static UnityImageUtil getInstance() {
        UnityImageUtil unityImageUtil;
        synchronized (V) {
            if (I == null) {
                I = new UnityImageUtil();
            }
            unityImageUtil = I;
        }
        return unityImageUtil;
    }

    public void unityLoadImage(final UnityImageDelegate unityImageDelegate, Context context, NativeAd nativeAd, UnityImageType unityImageType) {
        if (unityImageDelegate == null || unityImageDelegate.getUri() == null) {
            return;
        }
        Uri uri = unityImageDelegate.getUri();
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(uri.toString());
        sourceParam.Code(52428800L);
        sourceParam.I(true);
        if (nativeAd == null || !(nativeAd instanceof bs)) {
            return;
        }
        g Code = ((bs) nativeAd).Code();
        final k Code2 = Code(Code, uri.toString(), unityImageType);
        if (Code2 == null) {
            ge.Code("UnityImageUtil", "illegal image");
            return;
        }
        sourceParam.V(Code2.I());
        sourceParam.V(Code2.S());
        if (Code != null) {
            y.Code(context, sourceParam, Code.D(), new aj() { // from class: com.huawei.hms.ads.unity.UnityImageUtil.1
                @Override // com.huawei.openalliance.ad.utils.aj
                public void Code() {
                    ge.I("UnityImageUtil", "unity load image fail");
                }

                @Override // com.huawei.openalliance.ad.utils.aj
                public void Code(String str, Drawable drawable) {
                    k kVar = Code2;
                    if (kVar == null || !TextUtils.equals(str, kVar.Z())) {
                        return;
                    }
                    ge.Code("UnityImageUtil", "unity load image success");
                    unityImageDelegate.setDrawable(drawable);
                }
            });
        }
    }
}
