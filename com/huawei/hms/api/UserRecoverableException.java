package com.huawei.hms.api;

import android.content.Intent;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/UserRecoverableException.class */
public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
