package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/AppDetailInfoActivity.class */
public class AppDetailInfoActivity extends Activity {
    private LinearLayout b;
    private long h;
    private RecyclerView hj;
    private List<Pair<String, String>> ko;
    private ImageView mb;
    private TextView ox;
    private long u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/AppDetailInfoActivity$mb.class */
    public class mb extends RecyclerView.Adapter<Object> {
        private mb() {
        }
    }

    public static void mb(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean mb() {
        this.h = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.model.ox mb2 = b.mb().mb(this.h);
        if (mb2 == null) {
            return false;
        }
        this.u = mb2.ox;
        this.ko = mb2.ww;
        return true;
    }

    private void ox() {
        this.mb = (ImageView) findViewById(R.id.iv_detail_back);
        this.ox = (TextView) findViewById(R.id.tv_empty);
        this.hj = (RecyclerView) findViewById(R.id.permission_list);
        this.b = (LinearLayout) findViewById(R.id.ll_download);
        if (this.ko.isEmpty()) {
            this.hj.setVisibility(8);
            this.ox.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.hj.setLayoutManager(linearLayoutManager);
            this.hj.setAdapter(new mb());
        }
        this.mb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_CLOSE, AppDetailInfoActivity.this.u);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_DOWNLOAD, AppDetailInfoActivity.this.u);
                ox.mb().ox(AppDetailInfoActivity.this.u);
                com.ss.android.socialbase.appdownloader.b.mb((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.b.mb(ox.mb().ox());
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.mb(EventConstants.Refer.LP_APP_DETAIL_CLICK_CLOSE, this.u);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (mb()) {
            ox();
        } else {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }
}
