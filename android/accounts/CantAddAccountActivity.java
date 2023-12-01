package android.accounts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/CantAddAccountActivity.class */
public class CantAddAccountActivity extends Activity {
    public static final String EXTRA_ERROR_CODE = "android.accounts.extra.ERROR_CODE";

    public void onCancelButtonClicked(View view) {
        onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_not_authorized);
    }
}
