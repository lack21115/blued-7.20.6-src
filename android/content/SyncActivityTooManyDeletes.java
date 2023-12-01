package android.content;

import android.R;
import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.umeng.analytics.pro.d;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncActivityTooManyDeletes.class */
public class SyncActivityTooManyDeletes extends Activity implements AdapterView.OnItemClickListener {
    private Account mAccount;
    private String mAuthority;
    private long mNumDeletes;
    private String mProvider;

    private void startSyncReallyDelete() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS, true);
        bundle.putBoolean("force", true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(this.mAccount, this.mAuthority, bundle);
    }

    private void startSyncUndoDeletes() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS, true);
        bundle.putBoolean("force", true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(this.mAccount, this.mAuthority, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.mNumDeletes = extras.getLong("numDeletes");
        this.mAccount = (Account) extras.getParcelable("account");
        this.mAuthority = extras.getString(ContactsContract.Directory.DIRECTORY_AUTHORITY);
        this.mProvider = extras.getString(d.M);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, (int) R.layout.simple_list_item_1, (int) R.id.text1, new CharSequence[]{getResources().getText(17040976), getResources().getText(17040977), getResources().getText(17040978)});
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setItemsCanFocus(true);
        listView.setOnItemClickListener(this);
        TextView textView = new TextView(this);
        textView.setText(String.format(getResources().getText(17040975).toString(), Long.valueOf(this.mNumDeletes), this.mProvider, this.mAccount.name));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 0.0f);
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(listView, layoutParams);
        setContentView(linearLayout);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            startSyncReallyDelete();
        } else if (i == 1) {
            startSyncUndoDeletes();
        }
        finish();
    }
}
