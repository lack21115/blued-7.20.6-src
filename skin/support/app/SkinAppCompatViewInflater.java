package skin.support.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.view.ViewCompat;
import skin.support.content.res.SkinCompatVectorResources;
import skin.support.widget.SkinCompatAutoCompleteTextView;
import skin.support.widget.SkinCompatButton;
import skin.support.widget.SkinCompatCheckBox;
import skin.support.widget.SkinCompatCheckedTextView;
import skin.support.widget.SkinCompatContentFrameLayout;
import skin.support.widget.SkinCompatEditText;
import skin.support.widget.SkinCompatFrameLayout;
import skin.support.widget.SkinCompatImageButton;
import skin.support.widget.SkinCompatImageView;
import skin.support.widget.SkinCompatLinearLayout;
import skin.support.widget.SkinCompatMultiAutoCompleteTextView;
import skin.support.widget.SkinCompatProgressBar;
import skin.support.widget.SkinCompatRadioButton;
import skin.support.widget.SkinCompatRadioGroup;
import skin.support.widget.SkinCompatRatingBar;
import skin.support.widget.SkinCompatRelativeLayout;
import skin.support.widget.SkinCompatScrollView;
import skin.support.widget.SkinCompatSeekBar;
import skin.support.widget.SkinCompatSpinner;
import skin.support.widget.SkinCompatTextView;
import skin.support.widget.SkinCompatToolbar;
import skin.support.widget.SkinCompatView;

/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinAppCompatViewInflater.class */
public class SkinAppCompatViewInflater implements SkinLayoutInflater, SkinWrapper {
    public SkinAppCompatViewInflater() {
        SkinCompatVectorResources.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        if (((androidx.appcompat.view.ContextThemeWrapper) r6).getThemeResId() != r11) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Context a(android.content.Context r6, android.util.AttributeSet r7, boolean r8, boolean r9) {
        /*
            r0 = r6
            r1 = r7
            int[] r2 = skin.support.appcompat.R.styleable.View
            r3 = 0
            r4 = 0
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r1, r2, r3, r4)
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L1c
            r0 = r7
            int r1 = skin.support.appcompat.R.styleable.View_android_theme
            r2 = 0
            int r0 = r0.getResourceId(r1, r2)
            r10 = r0
            goto L1f
        L1c:
            r0 = 0
            r10 = r0
        L1f:
            r0 = r10
            r11 = r0
            r0 = r9
            if (r0 == 0) goto L4e
            r0 = r10
            r11 = r0
            r0 = r10
            if (r0 != 0) goto L4e
            r0 = r7
            int r1 = skin.support.appcompat.R.styleable.View_theme
            r2 = 0
            int r0 = r0.getResourceId(r1, r2)
            r10 = r0
            r0 = r10
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L4e
            java.lang.String r0 = "SkinAppCompatViewInflater"
            java.lang.String r1 = "app:theme is now deprecated. Please move to using android:theme instead."
            skin.support.utils.Slog.a(r0, r1)
            r0 = r10
            r11 = r0
        L4e:
            r0 = r7
            r0.recycle()
            r0 = r6
            r7 = r0
            r0 = r11
            if (r0 == 0) goto L79
            r0 = r6
            boolean r0 = r0 instanceof androidx.appcompat.view.ContextThemeWrapper
            if (r0 == 0) goto L6e
            r0 = r6
            r7 = r0
            r0 = r6
            androidx.appcompat.view.ContextThemeWrapper r0 = (androidx.appcompat.view.ContextThemeWrapper) r0
            int r0 = r0.getThemeResId()
            r1 = r11
            if (r0 == r1) goto L79
        L6e:
            androidx.appcompat.view.ContextThemeWrapper r0 = new androidx.appcompat.view.ContextThemeWrapper
            r1 = r0
            r2 = r6
            r3 = r11
            r1.<init>(r2, r3)
            r7 = r0
        L79:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.app.SkinAppCompatViewInflater.a(android.content.Context, android.util.AttributeSet, boolean, boolean):android.content.Context");
    }

    private boolean a(Context context, ViewParent viewParent) {
        if (viewParent != null && (context instanceof Activity)) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            while (viewParent != null) {
                if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                    return false;
                }
                viewParent = viewParent.getParent();
            }
            return true;
        }
        return false;
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        if (str.contains(".")) {
            return null;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    z = true;
                    break;
                }
                break;
            case -1495589242:
                if (str.equals("ProgressBar")) {
                    z = true;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    z = true;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    z = true;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    z = true;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    z = true;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    z = true;
                    break;
                }
                break;
            case -443652810:
                if (str.equals("RelativeLayout")) {
                    z = true;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    z = true;
                    break;
                }
                break;
            case 2666181:
                if (str.equals("View")) {
                    z = false;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    z = true;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    z = true;
                    break;
                }
                break;
            case 1127291599:
                if (str.equals("LinearLayout")) {
                    z = true;
                    break;
                }
                break;
            case 1310765783:
                if (str.equals("FrameLayout")) {
                    z = true;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    z = true;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    z = true;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    z = true;
                    break;
                }
                break;
            case 1969230692:
                if (str.equals("RadioGroup")) {
                    z = true;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    z = true;
                    break;
                }
                break;
            case 2059813682:
                if (str.equals("ScrollView")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return new SkinCompatView(context, attributeSet);
            case true:
                return new SkinCompatLinearLayout(context, attributeSet);
            case true:
                return new SkinCompatRelativeLayout(context, attributeSet);
            case true:
                return new SkinCompatFrameLayout(context, attributeSet);
            case true:
                return new SkinCompatTextView(context, attributeSet);
            case true:
                return new SkinCompatImageView(context, attributeSet);
            case true:
                return new SkinCompatButton(context, attributeSet);
            case true:
                return new SkinCompatEditText(context, attributeSet);
            case true:
                return new SkinCompatSpinner(context, attributeSet);
            case true:
                return new SkinCompatImageButton(context, attributeSet);
            case true:
                return new SkinCompatCheckBox(context, attributeSet);
            case true:
                return new SkinCompatRadioButton(context, attributeSet);
            case true:
                return new SkinCompatRadioGroup(context, attributeSet);
            case true:
                return new SkinCompatCheckedTextView(context, attributeSet);
            case true:
                return new SkinCompatAutoCompleteTextView(context, attributeSet);
            case true:
                return new SkinCompatMultiAutoCompleteTextView(context, attributeSet);
            case true:
                return new SkinCompatRatingBar(context, attributeSet);
            case true:
                return new SkinCompatSeekBar(context, attributeSet);
            case true:
                return new SkinCompatProgressBar(context, attributeSet);
            case true:
                return new SkinCompatScrollView(context, attributeSet);
            default:
                return null;
        }
    }

    private View c(Context context, String str, AttributeSet attributeSet) {
        boolean z;
        ContentFrameLayout skinCompatToolbar;
        int hashCode = str.hashCode();
        if (hashCode != -543350792) {
            if (hashCode == 171496577 && str.equals("androidx.appcompat.widget.Toolbar")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("androidx.appcompat.widget.ContentFrameLayout")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            skinCompatToolbar = new SkinCompatToolbar(context, attributeSet);
        } else if (!z) {
            return null;
        } else {
            skinCompatToolbar = new SkinCompatContentFrameLayout(context, attributeSet);
        }
        return skinCompatToolbar;
    }

    @Override // skin.support.app.SkinWrapper
    public Context a(Context context, View view, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        boolean z2 = false;
        if (z) {
            z2 = false;
            if (a(context, (ViewParent) view)) {
                z2 = true;
            }
        }
        Context context2 = context;
        if (z2) {
            context2 = context;
            if (view != null) {
                context2 = view.getContext();
            }
        }
        boolean shouldBeUsed = VectorEnabledTintResources.shouldBeUsed();
        Context context3 = context2;
        if (z2) {
            context3 = context2;
            if (view != null) {
                context3 = view.getContext();
            }
        }
        Context a = a(context3, attributeSet, z, true);
        Context context4 = a;
        if (shouldBeUsed) {
            context4 = TintContextWrapper.wrap(a);
        }
        return context4;
    }

    @Override // skin.support.app.SkinLayoutInflater
    public View a(Context context, String str, AttributeSet attributeSet) {
        View b = b(context, str, attributeSet);
        View view = b;
        if (b == null) {
            view = c(context, str, attributeSet);
        }
        return view;
    }
}
