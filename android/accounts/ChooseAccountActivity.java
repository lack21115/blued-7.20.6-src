package android.accounts;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountActivity.class */
public class ChooseAccountActivity extends Activity {
    private static final String TAG = "AccountManager";
    private Bundle mResult;
    private Parcelable[] mAccounts = null;
    private AccountManagerResponse mAccountManagerResponse = null;
    private HashMap<String, AuthenticatorDescription> mTypeToAuthDescription = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountActivity$AccountArrayAdapter.class */
    private static class AccountArrayAdapter extends ArrayAdapter<AccountInfo> {
        private AccountInfo[] mInfos;
        private LayoutInflater mLayoutInflater;

        public AccountArrayAdapter(Context context, int i, AccountInfo[] accountInfoArr) {
            super(context, i, accountInfoArr);
            this.mInfos = accountInfoArr;
            this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mLayoutInflater.inflate(17367101, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) view.findViewById(16909029);
                viewHolder.icon = (ImageView) view.findViewById(16909028);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.text.setText(this.mInfos[i].name);
            viewHolder.icon.setImageDrawable(this.mInfos[i].drawable);
            return view;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountActivity$AccountInfo.class */
    private static class AccountInfo {
        final Drawable drawable;
        final String name;

        AccountInfo(String str, Drawable drawable) {
            this.name = str;
            this.drawable = drawable;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountActivity$ViewHolder.class */
    private static class ViewHolder {
        ImageView icon;
        TextView text;

        private ViewHolder() {
        }
    }

    private void getAuthDescriptions() {
        AuthenticatorDescription[] authenticatorTypes = AccountManager.get(this).getAuthenticatorTypes();
        int length = authenticatorTypes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            AuthenticatorDescription authenticatorDescription = authenticatorTypes[i2];
            this.mTypeToAuthDescription.put(authenticatorDescription.type, authenticatorDescription);
            i = i2 + 1;
        }
    }

    private Drawable getDrawableForType(String str) {
        Drawable drawable = null;
        if (this.mTypeToAuthDescription.containsKey(str)) {
            try {
                AuthenticatorDescription authenticatorDescription = this.mTypeToAuthDescription.get(str);
                drawable = createPackageContext(authenticatorDescription.packageName, 0).getDrawable(authenticatorDescription.iconId);
            } catch (PackageManager.NameNotFoundException e) {
                drawable = null;
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "No icon name for account type " + str);
                    return null;
                }
            } catch (Resources.NotFoundException e2) {
                drawable = null;
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "No icon resource for account type " + str);
                    return null;
                }
            }
        }
        return drawable;
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mAccountManagerResponse != null) {
            if (this.mResult != null) {
                this.mAccountManagerResponse.onResult(this.mResult);
            } else {
                this.mAccountManagerResponse.onError(4, "canceled");
            }
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAccounts = getIntent().getParcelableArrayExtra(AccountManager.KEY_ACCOUNTS);
        this.mAccountManagerResponse = (AccountManagerResponse) getIntent().getParcelableExtra(AccountManager.KEY_ACCOUNT_MANAGER_RESPONSE);
        if (this.mAccounts == null) {
            setResult(0);
            finish();
            return;
        }
        getAuthDescriptions();
        AccountInfo[] accountInfoArr = new AccountInfo[this.mAccounts.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mAccounts.length) {
                setContentView(17367100);
                ListView listView = (ListView) findViewById(R.id.list);
                listView.setAdapter((ListAdapter) new AccountArrayAdapter(this, R.layout.simple_list_item_1, accountInfoArr));
                listView.setChoiceMode(1);
                listView.setTextFilterEnabled(true);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.accounts.ChooseAccountActivity.1
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        ChooseAccountActivity.this.onListItemClick((ListView) adapterView, view, i3, j);
                    }
                });
                return;
            }
            accountInfoArr[i2] = new AccountInfo(((Account) this.mAccounts[i2]).name, getDrawableForType(((Account) this.mAccounts[i2]).type));
            i = i2 + 1;
        }
    }

    protected void onListItemClick(ListView listView, View view, int i, long j) {
        Account account = (Account) this.mAccounts[i];
        Log.d(TAG, "selected account " + account);
        Bundle bundle = new Bundle();
        bundle.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
        bundle.putString("accountType", account.type);
        this.mResult = bundle;
        finish();
    }
}
