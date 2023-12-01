package com.soft.blued.tinker.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.tinker.util.Utils;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/app/TinkerTestActivity.class */
public class TinkerTestActivity extends Activity {
    public boolean a(Context context) {
        StringBuilder sb = new StringBuilder();
        Tinker with = Tinker.with(getApplicationContext());
        if (with.isTinkerLoaded()) {
            sb.append(String.format("[patch is loaded] \n", new Object[0]));
            sb.append(String.format("[buildConfig TINKER_ID] %s \n", BuildInfo.e));
            sb.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", BaseBuildInfo.b));
            sb.append(String.format("[buildConfig MESSSAGE] %s \n", BuildInfo.d));
            sb.append(String.format("[TINKER_ID] %s \n", with.getTinkerLoadResultIfPresent().getPackageConfigByName(ShareConstants.TINKER_ID)));
            sb.append(String.format("[packageConfig patchMessage] %s \n", with.getTinkerLoadResultIfPresent().getPackageConfigByName("patchMessage")));
            sb.append(String.format("[packageConfig patchCode] %s \n", with.getTinkerLoadResultIfPresent().getPackageConfigByName("patchCode")));
            sb.append(String.format("[TINKER_ID Rom Space] %d k \n", Long.valueOf(with.getTinkerRomSpace())));
        } else {
            sb.append(String.format("[patch is not loaded] \n", new Object[0]));
            sb.append(String.format("[buildConfig TINKER_ID] %s \n", BuildInfo.e));
            sb.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", BaseBuildInfo.b));
            sb.append(String.format("[buildConfig MESSSAGE] %s \n", BuildInfo.d));
            sb.append(String.format("[TINKER_ID] %s \n", ShareTinkerInternals.getManifestTinkerID(getApplicationContext())));
        }
        sb.append(String.format("[BaseBuildInfo Message] %s \n", BaseBuildInfo.f29769a));
        TextView textView = new TextView(context);
        textView.setText(sb.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setPadding(16, 16, 16, 16);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setView(textView);
        builder.create().show();
        Logger.b("xpf", sb.toString());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tinker_test);
        TinkerLog.e("Tinker.TinkerTestActivity", "i am on onCreate classloader:" + TinkerTestActivity.class.getClassLoader().toString(), new Object[0]);
        TinkerLog.e("Tinker.TinkerTestActivity", "i am on patch onCreate", new Object[0]);
        ((Button) findViewById(R.id.loadPatch)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.tinker.app.TinkerTestActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Context applicationContext = TinkerTestActivity.this.getApplicationContext();
                TinkerInstaller.onReceiveUpgradePatch(applicationContext, Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
            }
        });
        ((Button) findViewById(R.id.loadLibrary)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.tinker.app.TinkerTestActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TinkerLoadLibrary.installNavitveLibraryABI(TinkerTestActivity.this.getApplicationContext(), "armeabi");
                System.loadLibrary("stlport_shared");
            }
        });
        ((Button) findViewById(R.id.cleanPatch)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.tinker.app.TinkerTestActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Tinker.with(TinkerTestActivity.this.getApplicationContext()).cleanPatch();
            }
        });
        ((Button) findViewById(R.id.killSelf)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.tinker.app.TinkerTestActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShareTinkerInternals.killAllOtherProcess(TinkerTestActivity.this.getApplicationContext());
                Process.killProcess(Process.myPid());
            }
        });
        ((Button) findViewById(R.id.showInfo)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.tinker.app.TinkerTestActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TinkerTestActivity tinkerTestActivity = TinkerTestActivity.this;
                tinkerTestActivity.a(tinkerTestActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        Utils.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        TinkerLog.e("Tinker.TinkerTestActivity", "i am on onResume", new Object[0]);
        super.onResume();
        Utils.a(false);
    }
}
