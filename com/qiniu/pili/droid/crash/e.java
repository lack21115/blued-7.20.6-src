package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.DropBoxManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f27476a = {"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};
    private static String b = "N/A";

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f27477c = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Context context) {
        try {
            DropBoxManager dropBoxManager = (DropBoxManager) context.getSystemService(Context.DROPBOX_SERVICE);
            Calendar calendar = Calendar.getInstance();
            calendar.roll(12, -1);
            long timeInMillis = calendar.getTimeInMillis();
            this.f27477c.format(calendar.getTime());
            ArrayList<String> arrayList = new ArrayList(Arrays.asList(f27476a));
            if (arrayList.isEmpty()) {
                return "No tag configured for collection.";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append("Tag: ");
                sb.append(str);
                sb.append('\n');
                DropBoxManager.Entry nextEntry = dropBoxManager.getNextEntry(str, timeInMillis);
                DropBoxManager.Entry entry = nextEntry;
                if (nextEntry == null) {
                    sb.append("Nothing.");
                    sb.append('\n');
                } else {
                    while (entry != null) {
                        long timeMillis = entry.getTimeMillis();
                        calendar.setTimeInMillis(timeMillis);
                        sb.append('@');
                        sb.append(this.f27477c.format(calendar.getTime()));
                        sb.append('\n');
                        String text = entry.getText(500);
                        if (text != null) {
                            sb.append("Text: ");
                            sb.append(text);
                            sb.append('\n');
                        } else {
                            sb.append("Not Text!");
                            sb.append('\n');
                        }
                        entry.close();
                        entry = dropBoxManager.getNextEntry(str, timeMillis);
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            return b;
        }
    }
}
