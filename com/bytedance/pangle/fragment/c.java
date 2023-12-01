package com.bytedance.pangle.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Array;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/fragment/c.class */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    Fragment f21405a;

    public c(Fragment fragment) {
        this.f21405a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        Object obj;
        if (this.f21405a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                obj = null;
                if (i2 >= length) {
                    break;
                }
                obj = objArr[i2];
                Object readField = FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) || ((readField instanceof String) && (((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                }
                i = i2 + 1;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i3 = 0;
                int i4 = 0;
                while (i4 < objArr.length) {
                    int i5 = i3;
                    if (objArr[i4] != obj) {
                        objArr2[i3] = objArr[i4];
                        iArr[i3] = i4;
                        i5 = i3 + 1;
                    }
                    i4++;
                    i3 = i5;
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        Object obj;
        if (this.f21405a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                obj = null;
                if (i2 >= length) {
                    break;
                }
                obj = objArr[i2];
                Object readField = FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) || ((readField instanceof String) && (((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                }
                i = i2 + 1;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i3 = 0;
                int i4 = 0;
                while (i4 < objArr.length) {
                    int i5 = i3;
                    if (objArr[i4] != obj) {
                        objArr2[i3] = objArr[i4];
                        iArr[i3] = i4;
                        i5 = i3 + 1;
                    }
                    i4++;
                    i3 = i5;
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
