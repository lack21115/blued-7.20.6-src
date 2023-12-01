package com.soft.blued.version.update;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.manager.CommunityManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.StringUtils;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/version/update/UpdateVersionFragment.class */
public class UpdateVersionFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f21155a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f21156c;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;
    private View i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;

    public static void a(Context context, DownloadBaseInfo downloadBaseInfo, String str) {
        Bundle bundle = new Bundle();
        if (downloadBaseInfo != null) {
            if (TextUtils.isEmpty(downloadBaseInfo.download_url) || !a(downloadBaseInfo.download_url)) {
                return;
            }
            bundle.putString("i_s_update_url", downloadBaseInfo.download_url);
            bundle.putString("i_s_update_desc", downloadBaseInfo.description);
            bundle.putString("i_s_update_version", downloadBaseInfo.version);
            bundle.putString("i_s_update_title", downloadBaseInfo.title);
        }
        bundle.putString("i_s_update_tag", str);
        TerminalActivity.a(bundle);
        TransparentActivity.b(context, UpdateVersionFragment.class, bundle);
    }

    public static void a(Context context, String str) {
        a(context, null, str);
    }

    private static boolean a(String str) {
        return Patterns.WEB_URL.matcher(str).matches();
    }

    private void d() {
        this.i.setVisibility(8);
        this.j = (TextView) this.i.findViewById(R.id.tv_notice);
        this.k = (TextView) this.i.findViewById(R.id.tv_code);
        this.l = (TextView) this.i.findViewById(2131371186);
        this.m = (TextView) this.i.findViewById(R.id.tv_update);
        this.n = (TextView) this.i.findViewById(2131371051);
    }

    private void e() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            getActivity().finish();
            return;
        }
        this.f21156c = arguments.getString("i_s_update_tag");
        this.d = arguments.getString("i_s_update_title");
        this.e = arguments.getString("i_s_update_desc");
        this.f = arguments.getString("i_s_update_url");
        this.g = arguments.getString("i_s_update_version");
        this.h = BluedPreferences.bq();
        if (!StringUtils.d(this.g)) {
            this.k.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + this.g);
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.j.setText(this.d);
        }
        this.l.setText(this.e);
    }

    private boolean f() {
        Context context = this.b;
        if (context == null) {
            return false;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            DownloadManager.Query query = new DownloadManager.Query();
            if (this.h != -1) {
                query.setFilterById(this.h);
                Cursor query2 = downloadManager.query(query);
                if (query2 != null && query2.moveToFirst()) {
                    int i = query2.getInt(query2.getColumnIndex("status"));
                    if (i == 2) {
                        AppMethods.d((int) R.string.tips_downloading);
                        query2.close();
                        return false;
                    } else if (i == 8) {
                        String br = BluedPreferences.br();
                        if (br.equals("" + DeviceUtils.b())) {
                            BluedPreferences.d(-1L);
                            query2.close();
                            return false;
                        }
                        try {
                            if (Long.valueOf(DeviceUtils.b()).longValue() >= Long.valueOf(BluedPreferences.br()).longValue()) {
                                BluedPreferences.d(-1L);
                                query2.close();
                                return false;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        g();
                        query2.close();
                        return true;
                    } else {
                        query2.close();
                    }
                }
            }
            if ("i_s_weak_update".equals(this.f21156c)) {
                h();
                return true;
            } else if ("i_s_strong_update".equals(this.f21156c)) {
                i();
                return true;
            } else {
                return false;
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void g() {
        CommonAlertDialog.a(this.b, (View) null, getResources().getString(R.string.install_title), getResources().getString(R.string.install_content), getResources().getString(2131886885), getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                String e = BluedPreferences.e(UpdateVersionFragment.this.h);
                if (!TextUtils.isEmpty(e)) {
                    FileUtils.b(new File(e));
                }
                BluedPreferences.d(-1L);
                UpdateVersionFragment.this.j();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                UpdateVersionFragment.this.j();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateVersionFragment.this.j();
            }
        }, true);
    }

    private void h() {
        this.i.setVisibility(0);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UpdateVersionFragment.this.update(false);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UpdateVersionFragment.this.j();
            }
        });
        this.i.setOnClickListener(null);
    }

    private void i() {
        this.i.setVisibility(0);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UpdateVersionFragment.this.update(true);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.version.update.UpdateVersionFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AppUtils.a(AppInfo.d());
            }
        });
        this.i.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(boolean z) {
        if (TextUtils.isEmpty(this.f) || !a(this.f)) {
            getActivity().finish();
            return;
        }
        if (DeviceUtils.f()) {
            UpdateVersionHelper.c(this.b);
        } else {
            String d = AppMethods.d();
            if (TextUtils.isEmpty(d)) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f)));
            } else {
                File file = new File(d, "Blued_" + this.g + ".apk");
                UpdateVersionHelper.a(file);
                DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService("download");
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f));
                    request.setDestinationUri(Uri.fromFile(file));
                    request.setTitle(getResources().getString(R.string.downloading_file));
                    request.setNotificationVisibility(1);
                    long enqueue = downloadManager.enqueue(request);
                    BluedPreferences.d(enqueue);
                    BluedPreferences.a(enqueue, file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f)));
                }
            }
        }
        if (z) {
            AppUtils.a(AppInfo.d());
        } else {
            getActivity().finish();
        }
    }

    public boolean onBackPressed() {
        if ("i_s_strong_update".equals(this.f21156c)) {
            AppUtils.a(AppInfo.d());
            return true;
        }
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.b = activity;
        this.f21155a = LayoutInflater.from(activity);
        if (this.i == null) {
            this.i = layoutInflater.inflate(R.layout.dialog_update_version, viewGroup, false);
            d();
        }
        e();
        if (!f()) {
            j();
        }
        CommunityManager.a.a().g(true);
        return this.i;
    }

    public void onDestroy() {
        super.onDestroy();
        CommunityManager.a.a().g(false);
    }
}
