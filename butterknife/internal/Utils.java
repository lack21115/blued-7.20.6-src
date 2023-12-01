package butterknife.internal;

import android.util.TypedValue;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:butterknife/internal/Utils.class */
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final TypedValue f3731a = new TypedValue();

    private Utils() {
        throw new AssertionError("No instances.");
    }

    public static View a(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String a2 = a(view, i);
        throw new IllegalStateException("Required view '" + a2 + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T a(View view, int i, String str, Class<T> cls) {
        return (T) b(a(view, i, str), i, str, cls);
    }

    private static String a(View view, int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }

    public static <T> T b(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String a2 = a(view, i);
            throw new IllegalStateException("View '" + a2 + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }
}
