package com.blued.android.module.shortvideo.manager;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/manager/StvFragmentManager.class */
public class StvFragmentManager {

    /* renamed from: a  reason: collision with root package name */
    private static StvFragmentManager f15748a;
    private List<String> b = new LinkedList();

    private StvFragmentManager() {
    }

    public static StvFragmentManager a() {
        if (f15748a == null) {
            synchronized (StvFragmentManager.class) {
                try {
                    if (f15748a == null) {
                        f15748a = new StvFragmentManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15748a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || this.b.contains(str)) {
            return;
        }
        this.b.add(str);
    }

    public void b() {
        Fragment findFragmentById;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Field declaredField2 = obj.getClass().getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity = (Activity) declaredField2.get(obj);
                if (activity != null && activity.getClass().getSimpleName().equals(TerminalActivity.class.getSimpleName()) && (findFragmentById = ((TerminalActivity) activity).getSupportFragmentManager().findFragmentById(R.id.root_view)) != null) {
                    String simpleName = findFragmentById.getClass().getSimpleName();
                    if (c(simpleName)) {
                        b(simpleName);
                        activity.finish();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || !this.b.contains(str)) {
            return;
        }
        this.b.remove(str);
    }

    public boolean c() {
        List<String> list = this.b;
        return list != null && list.size() > 0;
    }

    public boolean c(String str) {
        return !TextUtils.isEmpty(str) && this.b.contains(str);
    }

    public boolean d() {
        return c(EditFragment.class.getSimpleName());
    }
}
