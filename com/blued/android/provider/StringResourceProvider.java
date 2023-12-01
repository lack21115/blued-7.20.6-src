package com.blued.android.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.provider.IStringResourceProvider;
import com.soft.blued.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/provider/StringResourceProvider.class */
public class StringResourceProvider implements IStringResourceProvider {
    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a() {
        return AppInfo.d().getString(R.string.web_select_file_upload);
    }

    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String a(int i) {
        String string = AppInfo.d().getResources().getString(2131887272);
        return string + " (" + i + ")";
    }

    @Override // com.blued.android.framework.provider.IStringResourceProvider
    public String b() {
        return AppInfo.d().getResources().getString(2131891037);
    }
}
