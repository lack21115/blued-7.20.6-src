package com.soft.blued.ui.web;

import android.app.Activity;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ListIterator;
import java.util.Stack;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/ActivityStackManager.class */
public class ActivityStackManager {
    private static ActivityStackManager b = new ActivityStackManager();

    /* renamed from: a  reason: collision with root package name */
    private Stack<WeakReference<Activity>> f20782a;

    private ActivityStackManager() {
    }

    public static ActivityStackManager a() {
        if (b == null) {
            b = new ActivityStackManager();
        }
        return b;
    }

    public void a(WeakReference<Activity> weakReference) {
        if (this.f20782a == null) {
            this.f20782a = new Stack<>();
        }
        this.f20782a.add(weakReference);
    }

    public void b() {
        try {
            ListIterator<WeakReference<Activity>> listIterator = this.f20782a.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next().get();
                if (activity != null) {
                    activity.finish();
                }
                listIterator.remove();
            }
        } catch (Exception e) {
            Log.e("ActivityStackManager", e.getMessage());
        }
    }
}
