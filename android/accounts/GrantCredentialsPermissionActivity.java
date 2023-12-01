package android.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/GrantCredentialsPermissionActivity.class */
public class GrantCredentialsPermissionActivity extends Activity implements View.OnClickListener {
    public static final String EXTRAS_ACCOUNT = "account";
    public static final String EXTRAS_ACCOUNT_TYPE_LABEL = "accountTypeLabel";
    public static final String EXTRAS_AUTH_TOKEN_LABEL = "authTokenLabel";
    public static final String EXTRAS_AUTH_TOKEN_TYPE = "authTokenType";
    public static final String EXTRAS_PACKAGES = "application";
    public static final String EXTRAS_REQUESTING_UID = "uid";
    public static final String EXTRAS_RESPONSE = "response";
    private Account mAccount;
    private String mAuthTokenType;
    protected LayoutInflater mInflater;
    private Bundle mResultBundle = null;
    private int mUid;

    private String getAccountLabel(Account account) {
        AuthenticatorDescription[] authenticatorTypes;
        for (AuthenticatorDescription authenticatorDescription : AccountManager.get(this).getAuthenticatorTypes()) {
            if (authenticatorDescription.type.equals(account.type)) {
                try {
                    return createPackageContext(authenticatorDescription.packageName, 0).getString(authenticatorDescription.labelId);
                } catch (PackageManager.NameNotFoundException e) {
                    return account.type;
                } catch (Resources.NotFoundException e2) {
                    return account.type;
                }
            }
        }
        return account.type;
    }

    private View newPackageView(String str) {
        View inflate = this.mInflater.inflate(17367179, (ViewGroup) null);
        ((TextView) inflate.findViewById(16909142)).setText(str);
        return inflate;
    }

    @Override // android.app.Activity
    public void finish() {
        AccountAuthenticatorResponse accountAuthenticatorResponse = (AccountAuthenticatorResponse) getIntent().getParcelableExtra("response");
        if (accountAuthenticatorResponse != null) {
            if (this.mResultBundle != null) {
                accountAuthenticatorResponse.onResult(this.mResultBundle);
            } else {
                accountAuthenticatorResponse.onError(4, "canceled");
            }
        }
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 16909060:
                AccountManager.get(this).updateAppPermission(this.mAccount, this.mAuthTokenType, this.mUid, false);
                setResult(0);
                break;
            case 16909061:
                AccountManager.get(this).updateAppPermission(this.mAccount, this.mAuthTokenType, this.mUid, true);
                Intent intent = new Intent();
                intent.putExtra("retry", true);
                setResult(-1, intent);
                setAccountAuthenticatorResult(intent.getExtras());
                break;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(17367126);
        setTitle(17040919);
        this.mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            setResult(0);
            finish();
            return;
        }
        this.mAccount = (Account) extras.getParcelable("account");
        this.mAuthTokenType = extras.getString("authTokenType");
        this.mUid = extras.getInt("uid");
        PackageManager packageManager = getPackageManager();
        String[] packagesForUid = packageManager.getPackagesForUid(this.mUid);
        if (this.mAccount == null || this.mAuthTokenType == null || packagesForUid == null) {
            setResult(0);
            finish();
            return;
        }
        try {
            String accountLabel = getAccountLabel(this.mAccount);
            final TextView textView = (TextView) findViewById(16909057);
            textView.setVisibility(8);
            AccountManager.get(this).getAuthTokenLabel(this.mAccount.type, this.mAuthTokenType, new AccountManagerCallback<String>() { // from class: android.accounts.GrantCredentialsPermissionActivity.1
                @Override // android.accounts.AccountManagerCallback
                public void run(AccountManagerFuture<String> accountManagerFuture) {
                    try {
                        final String result = accountManagerFuture.getResult();
                        if (TextUtils.isEmpty(result)) {
                            return;
                        }
                        GrantCredentialsPermissionActivity.this.runOnUiThread(new Runnable() { // from class: android.accounts.GrantCredentialsPermissionActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GrantCredentialsPermissionActivity.this.isFinishing()) {
                                    return;
                                }
                                textView.setText(result);
                                textView.setVisibility(0);
                            }
                        });
                    } catch (AuthenticatorException e) {
                    } catch (OperationCanceledException e2) {
                    } catch (IOException e3) {
                    }
                }
            }, null);
            findViewById(16909061).setOnClickListener(this);
            findViewById(16909060).setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(16909053);
            int length = packagesForUid.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    ((TextView) findViewById(16909056)).setText(this.mAccount.name);
                    ((TextView) findViewById(16909055)).setText(accountLabel);
                    return;
                }
                String str = packagesForUid[i2];
                try {
                    str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
                } catch (PackageManager.NameNotFoundException e) {
                }
                linearLayout.addView(newPackageView(str));
                i = i2 + 1;
            }
        } catch (IllegalArgumentException e2) {
            setResult(0);
            finish();
        }
    }

    public final void setAccountAuthenticatorResult(Bundle bundle) {
        this.mResultBundle = bundle;
    }
}
