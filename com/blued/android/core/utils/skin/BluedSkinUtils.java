package com.blued.android.core.utils.skin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import skin.support.SkinCompatManager;
import skin.support.app.SkinAppCompatViewInflater;
import skin.support.app.SkinCardViewInflater;
import skin.support.app.SkinLayoutInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatUserThemeManager;
import skin.support.design.app.SkinMaterialViewInflater;
import skin.support.observe.SkinObserver;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/skin/BluedSkinUtils.class */
public class BluedSkinUtils {
    private BluedSkinUtils() {
    }

    public static int a(Context context, int i) {
        try {
            return a() ? SkinCompatResources.c(context, i) : context.getResources().getColor(i);
        } catch (Exception e) {
            return AppInfo.d().getResources().getColor(i);
        }
    }

    public static void a(Application application) {
        SkinCompatManager.a(application).a((SkinLayoutInflater) new SkinAppCompatViewInflater()).a((SkinLayoutInflater) new SkinMaterialViewInflater()).a((SkinLayoutInflater) new SkinConstraintViewInflater()).a((SkinLayoutInflater) new SkinCardViewInflater()).b(true).c(true).a(false).i();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static void a(BluedSkinObserver bluedSkinObserver) {
        SkinCompatManager.a().a((SkinObserver) bluedSkinObserver);
    }

    public static void a(String str, final BluedSkinLoaderListener bluedSkinLoaderListener) {
        SkinCompatManager.a().a(str, new SkinCompatManager.SkinLoaderListener() { // from class: com.blued.android.core.utils.skin.BluedSkinUtils.1
            @Override // skin.support.SkinCompatManager.SkinLoaderListener
            public void a() {
                BluedSkinLoaderListener bluedSkinLoaderListener2 = BluedSkinLoaderListener.this;
                if (bluedSkinLoaderListener2 != null) {
                    bluedSkinLoaderListener2.a();
                }
            }

            @Override // skin.support.SkinCompatManager.SkinLoaderListener
            public void a(String str2) {
                BluedSkinLoaderListener bluedSkinLoaderListener2 = BluedSkinLoaderListener.this;
                if (bluedSkinLoaderListener2 != null) {
                    bluedSkinLoaderListener2.a(str2);
                }
            }

            @Override // skin.support.SkinCompatManager.SkinLoaderListener
            public void b() {
                BluedSkinLoaderListener bluedSkinLoaderListener2 = BluedSkinLoaderListener.this;
                if (bluedSkinLoaderListener2 != null) {
                    bluedSkinLoaderListener2.b();
                }
            }
        }, 0);
    }

    public static boolean a() {
        return SkinCompatManager.a() != null;
    }

    public static boolean a(Activity activity) {
        return (activity.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Drawable b(Context context, int i) {
        try {
            return a() ? SkinCompatResources.e(context, i) : context.getResources().getDrawable(i);
        } catch (Exception e) {
            return AppInfo.d().getResources().getDrawable(i);
        }
    }

    public static void b() {
        SkinCompatResources.a().b();
        SkinCompatManager.a().f();
        SkinCompatUserThemeManager.b().c();
        SkinCompatUserThemeManager.b().d();
    }

    public static void b(BluedSkinObserver bluedSkinObserver) {
        SkinCompatManager.a().b(bluedSkinObserver);
    }

    public static boolean c() {
        return SkinCompatResources.a().d();
    }
}
