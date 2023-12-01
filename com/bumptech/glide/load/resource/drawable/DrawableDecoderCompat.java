package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/DrawableDecoderCompat.class */
public final class DrawableDecoderCompat {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f20985a = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    public static Drawable a(Context context, Context context2, int i) {
        return a(context, context2, i, null);
    }

    private static Drawable a(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (f20985a) {
                return b(context2, i, theme);
            }
        } catch (Resources.NotFoundException e) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError e3) {
            f20985a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return c(context2, i, theme);
    }

    private static Drawable b(Context context, int i, Resources.Theme theme) {
        ContextThemeWrapper contextThemeWrapper = context;
        if (theme != null) {
            contextThemeWrapper = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(contextThemeWrapper, i);
    }

    private static Drawable c(Context context, int i, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
