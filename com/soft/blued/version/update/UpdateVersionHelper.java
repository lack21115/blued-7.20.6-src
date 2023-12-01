package com.soft.blued.version.update;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/version/update/UpdateVersionHelper.class */
public class UpdateVersionHelper {
    public static int a(Context context) {
        if (context != null) {
            try {
                DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                DownloadManager.Query query = new DownloadManager.Query();
                long bq = BluedPreferences.bq();
                if (bq != -1) {
                    query.setFilterById(bq);
                    Cursor query2 = downloadManager.query(query);
                    if (query2.moveToFirst()) {
                        int i = query2.getInt(query2.getColumnIndex("status"));
                        int i2 = 2;
                        if (i != 2) {
                            i2 = 8;
                            if (i != 8) {
                                return -1;
                            }
                        }
                        return i2;
                    }
                    return -1;
                }
                return -1;
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    public static void b(final Context context) {
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            MineHttpUtils.a(context, "0", new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>() { // from class: com.soft.blued.version.update.UpdateVersionHelper.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<DownloadBaseInfo> bluedEntityA) {
                    if (bluedEntityA != null) {
                        try {
                            if (bluedEntityA.hasData()) {
                                DownloadBaseInfo downloadBaseInfo = bluedEntityA.data.get(0);
                                String str = downloadBaseInfo.type;
                                if (!TextUtils.isEmpty(downloadBaseInfo.version_code)) {
                                    BluedPreferences.I(downloadBaseInfo.version_code);
                                }
                                if (!TextUtils.isEmpty(str) && str.equals("1") && (Context.this instanceof Activity)) {
                                    String format = new SimpleDateFormat(" yyyy-MM-dd").format(new Date());
                                    if (format.equals(BluedPreferences.by())) {
                                        int bz = BluedPreferences.bz();
                                        if (bz >= downloadBaseInfo.times) {
                                            return;
                                        }
                                        BluedPreferences.m(bz + 1);
                                    } else {
                                        BluedPreferences.N(format);
                                        if (downloadBaseInfo.times <= 0) {
                                            BluedPreferences.m(0);
                                            return;
                                        }
                                        BluedPreferences.m(1);
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putString("i_s_update_tag", "i_s_weak_update");
                                    bundle.putString("i_s_update_url", downloadBaseInfo.download_url);
                                    bundle.putString("i_s_update_desc", downloadBaseInfo.description);
                                    bundle.putString("i_s_update_version", downloadBaseInfo.version);
                                    bundle.putString("i_s_update_title", downloadBaseInfo.title);
                                    TerminalActivity.a(bundle);
                                    TransparentActivity.b(Context.this, UpdateVersionFragment.class, bundle);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void c(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + AppInfo.f9486a));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + AppInfo.f9486a));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
