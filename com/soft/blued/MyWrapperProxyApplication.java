package com.soft.blued;

import android.content.Context;
import android.os.Process;
import com.wrapper.proxyapplication.Util;
import com.wrapper.proxyapplication.WrapperProxyApplication;
import java.io.IOException;
import java.util.zip.ZipFile;

/* loaded from: source-63640-dex2jar.jar:com/soft/blued/MyWrapperProxyApplication.class */
public class MyWrapperProxyApplication extends WrapperProxyApplication {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:10:0x002d). Please submit an issue!!! */
    @Override // com.wrapper.proxyapplication.WrapperProxyApplication
    protected void initProxyApplication(Context context) {
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (zipFile == null) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
        Util.PrepareSecurefiles(context, zipFile);
        try {
            zipFile.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        System.loadLibrary(Util.libname);
    }

    @Override // com.wrapper.proxyapplication.WrapperProxyApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
    }
}
