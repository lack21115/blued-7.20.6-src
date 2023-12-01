package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bn;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ba;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/av.class */
public class av {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a2 = ba.a(context).a(hl.SyncInfoFrequency.a(), 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a2) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(Context context, Cif cif) {
        com.xiaomi.channel.commonutils.logger.b.m8344a("need to update local info with: " + cif.m8914a());
        String str = cif.m8914a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    b.m8407a(context).a(true);
                } else {
                    b.m8407a(context).a(false);
                }
            }
        }
        String str2 = cif.m8914a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                String[] split2 = str2.split(",");
                int length = split2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    MiPushClient.addAlias(context, split2[i2]);
                    i = i2 + 1;
                }
            }
        }
        String str3 = cif.m8914a().get(Constants.EXTRA_KEY_TOPICS);
        if (str3 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str3)) {
                String[] split3 = str3.split(",");
                int length2 = split3.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    MiPushClient.addTopic(context, split3[i4]);
                    i3 = i4 + 1;
                }
            }
        }
        String str4 = cif.m8914a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str4 == null) {
            return;
        }
        MiPushClient.removeAllAccounts(context);
        if ("".equals(str4)) {
            return;
        }
        String[] split4 = str4.split(",");
        int length3 = split4.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return;
            }
            MiPushClient.addAccount(context, split4[i6]);
            i5 = i6 + 1;
        }
    }

    public static void a(Context context, boolean z) {
        com.xiaomi.push.ai.a(context).a(new aw(context, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(List<String> list) {
        String a2 = bn.a(d(list));
        return (TextUtils.isEmpty(a2) || a2.length() <= 4) ? "" : a2.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(List<String> list) {
        if (com.xiaomi.push.ac.a(list)) {
            return "";
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        Iterator it = arrayList.iterator();
        String str = "";
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = (String) it.next();
            String str4 = str2;
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2 + ",";
            }
            str = str4 + str3;
        }
    }
}
