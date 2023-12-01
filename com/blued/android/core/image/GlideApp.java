package com.blued.android.core.image;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/GlideApp.class */
public final class GlideApp {
    private GlideApp() {
    }

    public static GlideRequests a(Activity activity) {
        return (GlideRequests) Glide.a(activity);
    }

    public static GlideRequests a(Fragment fragment) {
        return (GlideRequests) Glide.a(fragment);
    }

    public static GlideRequests a(FragmentActivity fragmentActivity) {
        return (GlideRequests) Glide.a(fragmentActivity);
    }

    public static Glide a(Context context) {
        return Glide.a(context);
    }

    public static GlideRequests b(Context context) {
        return (GlideRequests) Glide.b(context);
    }
}
