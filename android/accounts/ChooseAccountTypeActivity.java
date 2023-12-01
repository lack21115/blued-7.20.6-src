package android.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.android.internal.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountTypeActivity.class */
public class ChooseAccountTypeActivity extends Activity {
    private static final String TAG = "AccountChooser";
    private ArrayList<AuthInfo> mAuthenticatorInfosToDisplay;
    private HashMap<String, AuthInfo> mTypeToAuthenticatorInfo = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountTypeActivity$AccountArrayAdapter.class */
    private static class AccountArrayAdapter extends ArrayAdapter<AuthInfo> {
        private ArrayList<AuthInfo> mInfos;
        private LayoutInflater mLayoutInflater;

        public AccountArrayAdapter(Context context, int i, ArrayList<AuthInfo> arrayList) {
            super(context, i, arrayList);
            this.mInfos = arrayList;
            this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mLayoutInflater.inflate(R.layout.choose_account_row, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) view.findViewById(R.id.account_row_text);
                viewHolder.icon = (ImageView) view.findViewById(R.id.account_row_icon);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.text.setText(this.mInfos.get(i).name);
            viewHolder.icon.setImageDrawable(this.mInfos.get(i).drawable);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountTypeActivity$AuthInfo.class */
    public static class AuthInfo {
        final AuthenticatorDescription desc;
        final Drawable drawable;
        final String name;

        AuthInfo(AuthenticatorDescription authenticatorDescription, String str, Drawable drawable) {
            this.desc = authenticatorDescription;
            this.name = str;
            this.drawable = drawable;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/accounts/ChooseAccountTypeActivity$ViewHolder.class */
    private static class ViewHolder {
        ImageView icon;
        TextView text;

        private ViewHolder() {
        }
    }

    private void buildTypeToAuthDescriptionMap() {
        Drawable drawable;
        String str;
        AuthenticatorDescription[] authenticatorTypes = AccountManager.get(this).getAuthenticatorTypes();
        int length = authenticatorTypes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            AuthenticatorDescription authenticatorDescription = authenticatorTypes[i2];
            try {
                Context createPackageContext = createPackageContext(authenticatorDescription.packageName, 0);
                drawable = createPackageContext.getDrawable(authenticatorDescription.iconId);
                CharSequence text = createPackageContext.getResources().getText(authenticatorDescription.labelId);
                String str2 = null;
                if (text != null) {
                    str2 = text.toString();
                }
                str = text.toString();
            } catch (PackageManager.NameNotFoundException e) {
                drawable = null;
                str = null;
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "No icon name for account type " + authenticatorDescription.type);
                    drawable = null;
                    str = null;
                }
            } catch (Resources.NotFoundException e2) {
                drawable = null;
                str = null;
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "No icon resource for account type " + authenticatorDescription.type);
                    drawable = null;
                    str = null;
                }
            }
            this.mTypeToAuthenticatorInfo.put(authenticatorDescription.type, new AuthInfo(authenticatorDescription, str, drawable));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResultAndFinish(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("accountType", str);
        setResult(-1, new Intent().putExtras(bundle));
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "ChooseAccountTypeActivity.setResultAndFinish: selected account type " + str);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "ChooseAccountTypeActivity.onCreate(savedInstanceState=" + bundle + ")");
        }
        HashSet hashSet = null;
        String[] stringArrayExtra = getIntent().getStringArrayExtra("allowableAccountTypes");
        if (stringArrayExtra != null) {
            HashSet hashSet2 = new HashSet(stringArrayExtra.length);
            int length = stringArrayExtra.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                if (i2 >= length) {
                    break;
                }
                hashSet2.add(stringArrayExtra[i2]);
                i = i2 + 1;
            }
        }
        buildTypeToAuthDescriptionMap();
        this.mAuthenticatorInfosToDisplay = new ArrayList<>(this.mTypeToAuthenticatorInfo.size());
        for (Map.Entry<String, AuthInfo> entry : this.mTypeToAuthenticatorInfo.entrySet()) {
            String key = entry.getKey();
            AuthInfo value = entry.getValue();
            if (hashSet == null || hashSet.contains(key)) {
                this.mAuthenticatorInfosToDisplay.add(value);
            }
        }
        if (this.mAuthenticatorInfosToDisplay.isEmpty()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(AccountManager.KEY_ERROR_MESSAGE, "no allowable account types");
            setResult(-1, new Intent().putExtras(bundle2));
            finish();
        } else if (this.mAuthenticatorInfosToDisplay.size() == 1) {
            setResultAndFinish(this.mAuthenticatorInfosToDisplay.get(0).desc.type);
        } else {
            setContentView(R.layout.choose_account_type);
            ListView listView = (ListView) findViewById(16908298);
            listView.setAdapter((ListAdapter) new AccountArrayAdapter(this, 17367043, this.mAuthenticatorInfosToDisplay));
            listView.setChoiceMode(0);
            listView.setTextFilterEnabled(false);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.accounts.ChooseAccountTypeActivity.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                    ChooseAccountTypeActivity.this.setResultAndFinish(((AuthInfo) ChooseAccountTypeActivity.this.mAuthenticatorInfosToDisplay.get(i3)).desc.type);
                }
            });
        }
    }
}
