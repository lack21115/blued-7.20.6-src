package com.tencent.connect.dataprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.connect.dataprovider.DataType;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/dataprovider/CallbackManager.class */
public final class CallbackManager {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f22498a;
    private Uri b;

    /* renamed from: c  reason: collision with root package name */
    private String f22499c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private int h;

    public CallbackManager(Activity activity) {
        this.g = false;
        this.f22498a = new WeakReference<>(activity.getApplicationContext());
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.b = intent.getData();
            this.f22499c = intent.getStringExtra(Constants.SRC_PACKAGE_NAME);
            this.d = intent.getStringExtra(Constants.SRC_ACTIVITY_CLASS_NAME);
            this.e = intent.getStringExtra(Constants.SRC_ACTIVITY_ACTION);
            this.h = intent.getIntExtra(Constants.REQUEST_TYPE, 0);
            this.f = intent.getStringExtra(Constants.APPID);
            if (this.b == null || this.d == null) {
                return;
            }
            this.g = true;
        }
    }

    private int a(Bundle bundle) {
        if (this.g) {
            if (this.f22498a == null) {
                return -3;
            }
            Intent intent = new Intent();
            intent.setClassName(this.f22499c, this.d);
            intent.setAction(this.e);
            bundle.putString(Constants.APPID, this.f);
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            this.f22498a.get().startActivity(intent);
            return 0;
        }
        return -2;
    }

    private int a(String str) {
        if (str == null) {
            return -7;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://")) {
            return 0;
        }
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (lowerCase.startsWith(Environment.getExternalStorageDirectory().toString().toLowerCase())) {
                File file = new File(str);
                if (!file.exists() || file.isDirectory()) {
                    return -8;
                }
                long length = file.length();
                if (length == 0) {
                    return -9;
                }
                return length > 1073741824 ? -6 : 0;
            }
            return -5;
        }
        return -10;
    }

    public int getRequestDateTypeFlag() {
        return this.h;
    }

    public boolean isCallFromTencentApp() {
        return this.g;
    }

    public boolean isSupportType(int i) {
        return (i & getRequestDateTypeFlag()) != 0;
    }

    public int sendTextAndImagePath(String str, String str2) {
        if (isSupportType(1)) {
            int a2 = a(str2);
            if (a2 != 0) {
                return a2;
            }
            DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(str, str2);
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.DATA_TYPE, 1);
            bundle.putParcelable(Constants.CONTENT_DATA, textAndMediaPath);
            return a(bundle);
        }
        return -1;
    }

    public int sendTextAndVideoPath(String str, String str2) {
        if (isSupportType(2)) {
            int a2 = a(str2);
            if (a2 != 0) {
                return a2;
            }
            DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(str, str2);
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.DATA_TYPE, 2);
            bundle.putParcelable(Constants.CONTENT_DATA, textAndMediaPath);
            return a(bundle);
        }
        return -1;
    }

    public int sendTextOnly(String str) {
        if (isSupportType(4)) {
            DataType.TextOnly textOnly = new DataType.TextOnly(str);
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.DATA_TYPE, 4);
            bundle.putParcelable(Constants.CONTENT_DATA, textOnly);
            return a(bundle);
        }
        return -1;
    }
}
