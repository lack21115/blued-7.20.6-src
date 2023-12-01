package com.huawei.hms.ads;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.android.internal.telephony.PhoneConstants;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ky.class */
public class ky {
    public static int Code(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static com.huawei.openalliance.ad.inter.data.m Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = width;
        int i2 = height;
        float f = x;
        float f2 = y;
        if (view instanceof ImageView) {
            int[] Code = Code(view);
            if (Code == null) {
                return null;
            }
            i = Code[0];
            i2 = Code[1];
            f = x - ((width - i) / 2);
            f2 = y - ((height - i2) / 2);
        }
        sb.append(i);
        sb.append(PhoneConstants.APN_TYPE_ALL);
        sb.append(i2);
        return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) f), Integer.valueOf((int) f2), sb.toString());
    }

    private static int[] Code(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                int width = imageView.getDrawable().getBounds().width();
                int height = imageView.getDrawable().getBounds().height();
                Matrix imageMatrix = imageView.getImageMatrix();
                float[] fArr = new float[10];
                imageMatrix.getValues(fArr);
                return new int[]{(int) (width * fArr[0]), (int) (height * fArr[4])};
            }
            return null;
        }
        return null;
    }

    public static boolean V(View view, MotionEvent motionEvent) {
        int[] Code;
        if (view == null || motionEvent == null) {
            return true;
        }
        if (!(view instanceof ImageView) || (Code = Code(view)) == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int width = view.getWidth();
        int height = view.getHeight();
        return Math.abs(((float) (width / 2)) - x) - ((float) (Code[0] / 2)) > 0.0f || Math.abs(((float) (height / 2)) - y) - ((float) (Code[1] / 2)) > 0.0f;
    }
}
