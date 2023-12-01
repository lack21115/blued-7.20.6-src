package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ThemedSpinnerAdapter.class */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ThemedSpinnerAdapter$Helper.class */
    public static final class Helper {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1845a;
        private final LayoutInflater b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f1846c;

        public Helper(Context context) {
            this.f1845a = context;
            this.b = LayoutInflater.from(context);
        }

        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.f1846c;
            return layoutInflater != null ? layoutInflater : this.b;
        }

        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.f1846c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.f1846c = null;
            } else if (theme == this.f1845a.getTheme()) {
                this.f1846c = this.b;
            } else {
                this.f1846c = LayoutInflater.from(new ContextThemeWrapper(this.f1845a, theme));
            }
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
