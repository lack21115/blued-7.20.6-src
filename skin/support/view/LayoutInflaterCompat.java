package skin.support.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.alipay.sdk.util.i;
import java.lang.reflect.Field;
import skin.support.utils.Slog;

/* loaded from: source-3503164-dex2jar.jar:skin/support/view/LayoutInflaterCompat.class */
public final class LayoutInflaterCompat {
    private static boolean a;

    /* loaded from: source-3503164-dex2jar.jar:skin/support/view/LayoutInflaterCompat$Factory2Wrapper.class */
    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory a;

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.a(view, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.a.a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.a + i.d;
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        try {
            layoutInflater.setFactory2(factory2);
        } catch (Exception e) {
            Slog.a("setFactory2 failed. Try forceSetFactory2");
            b(layoutInflater, factory2);
        }
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Field field = null;
        if (!a) {
            field = null;
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                field = declaredField;
                declaredField.setAccessible(true);
                field = declaredField;
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            a = true;
        }
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
