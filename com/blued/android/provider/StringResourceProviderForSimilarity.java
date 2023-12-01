package com.blued.android.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.provider.IStringResourceProvider;
import com.soft.blued.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/provider/StringResourceProviderForSimilarity.class */
public class StringResourceProviderForSimilarity implements IStringResourceProvider {
    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a() {
        return AppInfo.d().getString(R.string.web_select_file_upload);
    }

    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a(int i) {
        String string;
        if (i == 0) {
            string = AppInfo.d().getResources().getString(2131891037);
        } else if (i == 410) {
            string = AppInfo.d().getResources().getString(R.string.e410);
        } else if (i == 415) {
            string = AppInfo.d().getResources().getString(R.string.e415);
        } else if (i == 422) {
            string = AppInfo.d().getResources().getString(R.string.e422);
        } else if (i == 429) {
            string = AppInfo.d().getResources().getString(R.string.e429);
        } else if (i != 500) {
            switch (i) {
                case 400:
                    string = AppInfo.d().getResources().getString(R.string.e400);
                    break;
                case 401:
                    string = AppInfo.d().getResources().getString(R.string.account_abnormal);
                    break;
                case 402:
                    string = AppInfo.d().getResources().getString(R.string.e402);
                    break;
                case 403:
                    string = AppInfo.d().getResources().getString(R.string.e403);
                    break;
                case 404:
                    string = AppInfo.d().getResources().getString(R.string.e404);
                    break;
                case 405:
                    string = AppInfo.d().getResources().getString(R.string.e405);
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
