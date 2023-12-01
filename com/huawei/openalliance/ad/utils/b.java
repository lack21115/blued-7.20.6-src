package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/b.class */
public class b {
    private static final String Code = "ActivityUtils";
    private static final int V = 5;

    public static String Code(Context context) {
        Activity V2 = V(context);
        if (V2 != null) {
            ge.Code(Code, "ana_tag  getActivityLocalClassName LocalClassName = %s", V2.getLocalClassName());
            return V2.getLocalClassName();
        }
        ge.Z(Code, "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }

    public static String Code(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else if (obj instanceof View) {
            return Code(((View) obj).getContext());
        } else {
            str = "ana_tag  getActivityName activityname is not view";
        }
        ge.Z(Code, str);
        return null;
    }

    private static Activity V(Context context) {
        if (context == null) {
            ge.Z(Code, "ana_tag getActivity context is null, return");
            return null;
        }
        int i = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i++;
            if (i > 5) {
                ge.Z(Code, "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
