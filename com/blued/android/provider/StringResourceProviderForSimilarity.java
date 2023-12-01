package com.blued.android.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.provider.IStringResourceProvider;
import java.net.HttpURLConnection;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/provider/StringResourceProviderForSimilarity.class */
public class StringResourceProviderForSimilarity implements IStringResourceProvider {
    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a() {
        return AppInfo.d().getString(2131892792);
    }

    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a(int i) {
        String string;
        if (i == 0) {
            string = AppInfo.d().getResources().getString(2131891037);
        } else if (i == 410) {
            string = AppInfo.d().getResources().getString(2131887668);
        } else if (i == 415) {
            string = AppInfo.d().getResources().getString(2131887669);
        } else if (i == 422) {
            string = AppInfo.d().getResources().getString(2131887670);
        } else if (i == 429) {
            string = AppInfo.d().getResources().getString(2131887671);
        } else if (i != 500) {
            switch (i) {
                case HttpURLConnection.HTTP_BAD_REQUEST /* 400 */:
                    string = AppInfo.d().getResources().getString(2131887564);
                    break;
                case 401:
                    string = AppInfo.d().getResources().getString(2131886266);
                    break;
                case 402:
                    string = AppInfo.d().getResources().getString(2131887571);
                    break;
                case 403:
                    string = AppInfo.d().getResources().getString(2131887572);
                    break;
                case 404:
                    string = AppInfo.d().getResources().getString(2131887663);
                    break;
                case HttpURLConnection.HTTP_BAD_METHOD /* 405 */:
                    string = AppInfo.d().getResources().getString(2131887667);
                    break;
                default:
                    string = AppInfo.d().getResources().getString(2131887272);
                    break;
            }
        } else {
            string = AppInfo.d().getResources().getString(2131887272);
        }
        return string + ":(" + i + ")";
    }

    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String b() {
        return AppInfo.d().getResources().getString(2131891037);
    }
}
