package skin.support.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import com.android.internal.R;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import skin.support.SkinCompatManager;
import skin.support.collection.ArrayMap;
import skin.support.view.ViewCompat;

/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinCompatViewInflater.class */
public class SkinCompatViewInflater {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};
    private static final int[] b = {R.attr.onClick};
    private static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> d = new ArrayMap();
    private final Object[] e = new Object[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinCompatViewInflater$DeclaredOnClickListener.class */
    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public DeclaredOnClickListener(View view, String str) {
            this.a = view;
            this.b = str;
        }

        private void a(Context context, String str) {
            int id;
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = context;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.a.getId() == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (this.c == null) {
                a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private View a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends View> constructor = d.get(str);
        Constructor<? extends View> constructor2 = constructor;
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor2 = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(a);
                d.put(str, constructor2);
            } catch (Exception e) {
                return null;
            }
        }
        constructor2.setAccessible(true);
        return constructor2.newInstance(this.e);
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ViewCompat.a(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new DeclaredOnClickListener(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        View view;
        Iterator<SkinLayoutInflater> it = SkinCompatManager.a().e().iterator();
        View view2 = null;
        do {
            view = view2;
            if (!it.hasNext()) {
                break;
            }
            view2 = it.next().a(context, str, attributeSet);
            view = view2;
        } while (view2 == null);
        return view;
    }

    private View c(Context context, String str, AttributeSet attributeSet) {
        View view;
        Iterator<SkinLayoutInflater> it = SkinCompatManager.a().d().iterator();
        View view2 = null;
        do {
            view = view2;
            if (!it.hasNext()) {
                break;
            }
            view2 = it.next().a(context, str, attributeSet);
            view = view2;
        } while (view2 == null);
        return view;
    }

    public View a(Context context, String str, AttributeSet attributeSet) {
        String str2 = str;
        if ("view".equals(str)) {
            str2 = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 != str2.indexOf(46)) {
                View a2 = a(context, str2, (String) null);
                Object[] objArr = this.e;
                objArr[0] = null;
                objArr[1] = null;
                return a2;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= c.length) {
                    Object[] objArr2 = this.e;
                    objArr2[0] = null;
                    objArr2[1] = null;
                    return null;
                }
                View a3 = a(context, str2, c[i2]);
                if (a3 != null) {
                    Object[] objArr3 = this.e;
                    objArr3[0] = null;
                    objArr3[1] = null;
                    return a3;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            Object[] objArr4 = this.e;
            objArr4[0] = null;
            objArr4[1] = null;
            return null;
        } catch (Throwable th) {
            Object[] objArr5 = this.e;
            objArr5[0] = null;
            objArr5[1] = null;
            throw th;
        }
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        View b2 = b(context, str, attributeSet);
        View view2 = b2;
        if (b2 == null) {
            view2 = c(context, str, attributeSet);
        }
        View view3 = view2;
        if (view2 == null) {
            view3 = a(context, str, attributeSet);
        }
        if (view3 != null) {
            a(view3, attributeSet);
        }
        return view3;
    }
}
