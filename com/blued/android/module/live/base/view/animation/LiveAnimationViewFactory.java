package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppMethods;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LiveAnimationViewFactory.class */
public class LiveAnimationViewFactory {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, WeakReference<BaseLiveAnimationView>> f11504a = new ArrayMap();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LiveAnimationViewFactory$ScaleType.class */
    public enum ScaleType {
        CENTER_CROP,
        FIT_CENTER,
        FIT_BOTTOM
    }

    private BaseLiveAnimationView a(Context context, int i, String str, ScaleType scaleType) {
        WeakReference<BaseLiveAnimationView> weakReference = this.f11504a.get(Integer.valueOf(i));
        if (weakReference == null) {
            BaseLiveAnimationView b = b(context, i, str, scaleType);
            this.f11504a.put(Integer.valueOf(i), new WeakReference<>(b));
            return b;
        }
        BaseLiveAnimationView baseLiveAnimationView = weakReference.get();
        if (baseLiveAnimationView != null) {
            baseLiveAnimationView.a(str);
            return baseLiveAnimationView;
        }
        BaseLiveAnimationView b2 = b(context, i, str, scaleType);
        this.f11504a.put(Integer.valueOf(i), new WeakReference<>(b2));
        return b2;
    }

    private BaseLiveAnimationView a(Context context, String str, String str2, String str3, ScaleType scaleType) {
        return AppMethods.c(19) ? !TextUtils.isEmpty(str3) ? a(context, 7, str3, scaleType) : !TextUtils.isEmpty(str2) ? a(context, 1, str2, scaleType) : a(context, 0, str, scaleType) : !TextUtils.isEmpty(str3) ? a(context, 7, str3, scaleType) : a(context, 0, str, scaleType);
    }

    private BaseLiveAnimationView b(Context context, int i, String str, ScaleType scaleType) {
        boolean z = true;
        switch (i) {
            case 0:
                return new GifLiveAnimationView(context, str, scaleType == ScaleType.CENTER_CROP);
            case 1:
                if (scaleType != ScaleType.CENTER_CROP) {
                    z = false;
                }
                return new ApngLiveAnimationView(context, str, z);
            case 2:
                return new SuperCarView(context);
            case 3:
                return new SuperPlaneView(context);
            case 4:
                return new SuperShipView(context);
            case 5:
                return new SuperCastleView(context);
            case 6:
                return new MoneyRainView(context);
            case 7:
                return new LiveMp4AnimationView(context, str, scaleType);
            case 8:
                return new LuckyBagView(context);
            default:
                return new GifLiveAnimationView(context, "", scaleType == ScaleType.CENTER_CROP);
        }
    }

    public BaseLiveAnimationView a(Context context, String str, String str2, String str3, String str4, ScaleType scaleType) {
        return !TextUtils.isEmpty(str4) ? "car".equals(str4) ? a(context, 2, "", scaleType) : "plane".equals(str4) ? a(context, 3, "", scaleType) : "ship".equals(str4) ? a(context, 4, "", scaleType) : "tower".equals(str4) ? a(context, 5, "", scaleType) : "hongbao".equals(str4) ? a(context, 6, "", scaleType) : "luckybag".equals(str4) ? a(context, 8, str, scaleType) : a(context, str, str2, str3, scaleType) : a(context, str, str2, str3, scaleType);
    }

    public void a(int i) {
        Map<Integer, WeakReference<BaseLiveAnimationView>> map = this.f11504a;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }
}
