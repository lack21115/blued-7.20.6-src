package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.ui.BaseActivity;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/PushClickActivity.class */
public class PushClickActivity extends BaseActivity {
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                Intent intent2 = new Intent((Context) this, (Class<?>) FirstActivity.class);
                intent2.setAction(intent.getAction());
                intent2.putExtra("is_push_key", true);
                intent2.putExtra("extra_bool_open_welcome_page", intent.getBooleanExtra("extra_bool_open_welcome_page", false));
                intent2.setData(intent.getData());
                intent2.putExtras(intent);
                startActivity(intent2);
                overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        finish();
    }
}
