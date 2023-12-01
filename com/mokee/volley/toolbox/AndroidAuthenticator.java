package com.mokee.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mokee.volley.AuthFailureError;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/AndroidAuthenticator.class */
public class AndroidAuthenticator implements Authenticator {
    private static final String[] e = null;

    /* renamed from: a  reason: collision with root package name */
    private final Context f24246a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24247c;
    private final Account d;

    static {
        String[] strArr = new String[5];
        throw new VerifyError("bad dex opcode");
    }

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this.f24246a = context;
        this.d = account;
        this.f24247c = str;
        this.b = z;
    }

    public Account getAccount() {
        return this.d;
    }

    @Override // com.mokee.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> authToken = AccountManager.get(this.f24246a).getAuthToken(this.d, this.f24247c, this.b, null, null);
        try {
            Bundle result = authToken.getResult();
            String str = null;
            try {
                try {
                    if (authToken.isDone()) {
                        str = null;
                        if (!authToken.isCancelled()) {
                            if (result.containsKey(e[0])) {
                                throw new AuthFailureError((Intent) result.getParcelable(e[3]));
                            }
                            str = result.getString(e[2]);
                        }
                    }
                    if (str == null) {
                        try {
                            throw new AuthFailureError(e[1] + this.f24247c);
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    return str;
                } catch (Exception e3) {
                    throw e3;
                }
            } catch (Exception e4) {
                throw e4;
            }
        } catch (Exception e5) {
            throw new AuthFailureError(e[4], e5);
        }
    }

    @Override // com.mokee.volley.toolbox.Authenticator
    public void invalidateAuthToken(String str) {
        AccountManager.get(this.f24246a).invalidateAuthToken(this.d.type, str);
    }
}
