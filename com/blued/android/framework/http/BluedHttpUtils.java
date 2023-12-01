package com.blued.android.framework.http;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.provider.ProviderHolder;
import com.google.gson.reflect.TypeToken;
import javax.net.ssl.SSLException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/BluedHttpUtils.class */
public class BluedHttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9797a = false;
    public static IErrorHandler b = new IErrorHandler() { // from class: com.blued.android.framework.http.BluedHttpUtils.1
        @Override // com.blued.android.framework.http.BluedHttpUtils.IErrorHandler
        public boolean a(int i, String str) {
            if (i == 401) {
                ProviderHolder.a().b().a(str);
            } else if (i == 4010001) {
                ProviderHolder.a().b().c();
            } else if (i == 4031101 || i == 4031102 || i == 4031201 || i == 403009032) {
                ProviderHolder.a().b().d();
            }
            if ((BluedHttpUtils.f9797a || i >= 0) && !TextUtils.isEmpty(str)) {
                AppMethods.a((CharSequence) str);
                return true;
            }
            return true;
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/BluedHttpUtils$IErrorHandler.class */
    public interface IErrorHandler {
        boolean a(int i, String str);
    }

    public static Pair<Integer, String> a(Throwable th, int i, String str) {
        int i2 = 0;
        if (th == null || !(th instanceof SSLException)) {
            int i3 = 0;
            String str2 = "";
            try {
                if (!TextUtils.isEmpty(str)) {
                    BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<Object>>() { // from class: com.blued.android.framework.http.BluedHttpUtils.2
                    }.getType());
                    i2 = bluedEntityA.code;
                    i3 = i2;
                    str2 = bluedEntityA.message;
                }
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "";
                i2 = i3;
            }
            if (i2 != 0) {
                i = i2;
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                str3 = ProviderHolder.a().c().a(i);
            }
            return new Pair<>(Integer.valueOf(i), str3);
        }
        return new Pair<>(0, ProviderHolder.a().c().b());
    }

    public static void a(boolean z) {
        f9797a = AppInfo.m() || z;
    }

    @Deprecated
    public static boolean a(int i, String str) {
        return b(null, i, str);
    }

    @Deprecated
    public static boolean a(Throwable th, int i, String str, IErrorHandler iErrorHandler) {
        if (i == 200 && th == null) {
            return true;
        }
        Pair<Integer, String> a2 = a(th, i, str);
        int intValue = a2.first.intValue();
        String str2 = a2.second;
        if (iErrorHandler != null ? iErrorHandler.a(intValue, str2) : false) {
            return false;
        }
        b.a(intValue, str2);
        return false;
    }

    @Deprecated
    public static boolean b(Throwable th, int i, String str) {
        return a(th, i, str, null);
    }
}
