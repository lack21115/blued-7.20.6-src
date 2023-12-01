package com.huawei.openalliance.ad.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.ad.views.PPSSplashView;
import com.huawei.openalliance.ad.views.SplashLinkedVideoView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/i.class */
public class i {
    public static com.huawei.openalliance.ad.inter.data.m Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        if (Code(view)) {
            return V(view, motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        sb.append(width);
        sb.append("*");
        sb.append(height);
        return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) x), Integer.valueOf((int) y), sb.toString());
    }

    private static boolean Code(View view) {
        ViewParent parent = view.getParent();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5 || parent == null) {
                return false;
            }
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                return true;
            }
            parent = parent.getParent();
            i = i2 + 1;
        }
    }

    private static com.huawei.openalliance.ad.inter.data.m V(View view, MotionEvent motionEvent) {
        float left = view.getLeft() + motionEvent.getX();
        float top = view.getTop() + motionEvent.getY();
        StringBuilder sb = new StringBuilder();
        ViewParent parent = view.getParent();
        int i = 0;
        while (i < 5 && parent != null) {
            float f = left;
            float f2 = top;
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                f = left + viewGroup.getLeft();
                f2 = top + viewGroup.getTop();
            }
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                int width = viewGroup2.getWidth();
                int height = viewGroup2.getHeight();
                sb.append(width);
                sb.append("*");
                sb.append(height);
                return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) f), Integer.valueOf((int) f2), sb.toString());
            }
            parent = parent.getParent();
            i++;
            left = f;
            top = f2;
        }
        return null;
    }
}
