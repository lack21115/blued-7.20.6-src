package com.blued.android.core.ui;

import android.app.Activity;
import java.util.Stack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/ActivityStack.class */
public class ActivityStack {

    /* renamed from: a  reason: collision with root package name */
    private static ActivityStack f9714a;
    private final Stack<Activity> b = new Stack<>();

    ActivityStack() {
    }

    public static ActivityStack a() {
        ActivityStack activityStack;
        synchronized (ActivityStack.class) {
            try {
                if (f9714a == null) {
                    f9714a = new ActivityStack();
                }
                activityStack = f9714a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityStack;
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.b.add(activity);
        }
    }

    public void a(Class<? extends Activity> cls) {
        int size = this.b.size();
        Activity[] activityArr = new Activity[size];
        this.b.copyInto(activityArr);
        Activity activity = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Activity activity2 = activityArr[i2];
            if (activity2.getClass() != cls) {
                activity2.finish();
            } else {
                if (activity != null && activity != activity2) {
                    activity.finish();
                }
                activity = activity2;
            }
            i = i2 + 1;
        }
        this.b.clear();
        if (activity != null) {
            this.b.add(activity);
        }
    }

    public Stack<Activity> b() {
        Stack<Activity> stack = new Stack<>();
        Stack<Activity> stack2 = this.b;
        if (stack2 != null) {
            stack.addAll(stack2);
        }
        return stack;
    }

    public void b(Activity activity) {
        if (activity != null) {
            this.b.remove(activity);
        }
    }

    public void c() {
        int size = this.b.size();
        Activity[] activityArr = new Activity[size];
        this.b.copyInto(activityArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.b.clear();
                return;
            } else {
                activityArr[i2].finish();
                i = i2 + 1;
            }
        }
    }
}
