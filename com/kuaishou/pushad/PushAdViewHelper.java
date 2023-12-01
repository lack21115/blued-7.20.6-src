package com.kuaishou.pushad;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.b.b;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/pushad/PushAdViewHelper.class */
public class PushAdViewHelper {
    private static final String TAG = "PushAdViewHelper";

    public static void appendPushAd(Activity activity, View view) {
        ViewGroup obtainDecorView;
        if (view == null || (obtainDecorView = obtainDecorView(activity)) == null) {
            return;
        }
        removePushAd(obtainDecorView);
        obtainDecorView.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    private static ViewGroup obtainDecorView(Activity activity) {
        Activity activity2 = activity;
        if (activity == null) {
            b.vS();
            activity2 = b.getCurrentActivity();
        }
        if (activity2 == null) {
            return null;
        }
        View findViewById = activity2.getWindow().getDecorView().findViewById(R.id.content);
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    public static void removePushAd(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup == null) {
            viewGroup2 = obtainDecorView(null);
        }
        if (viewGroup2 != null) {
            ArrayList<View> arrayList = new ArrayList();
            int childCount = viewGroup2.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = viewGroup2.getChildAt(i2);
                if (PushAdView.PUSH_VIEW_TAG.equals(childAt.getTag())) {
                    arrayList.add(childAt);
                }
                i = i2 + 1;
            }
            for (View view : arrayList) {
                viewGroup2.removeView(view);
            }
        }
    }
}
