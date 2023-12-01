package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.turingface.sdk.mfa.vneRm;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/fenkF.class */
public final class fenkF {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39952a;
    public final Handler b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/fenkF$spXPg.class */
    public final class spXPg implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f39953a;
        public final /* synthetic */ Map b;

        public spXPg(Context context, Map map) {
            this.f39953a = context;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            fenkF.a(this.f39953a, this.b);
        }
    }

    static {
        StringBuilder b = com.tencent.turingcam.oqKCa.b("turingfd_conf_");
        b.append(com.tencent.turingcam.oqKCa.f39831a);
        b.append(BridgeUtil.UNDERLINE_STR);
        b.append("mfa");
        f39952a = b.toString();
    }

    public fenkF(Handler handler) {
        this.b = handler;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f39952a, 0);
        } catch (Throwable th) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, com.tencent.turingcam.oqKCa.a(com.tencent.turingcam.oqKCa.b(map.get(str).getBytes(), com.tencent.turingcam.oqKCa.b())));
            } catch (Throwable th2) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable th3) {
        }
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f39952a, 0);
        } catch (Throwable th) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
            }
            return new String(com.tencent.turingcam.oqKCa.a(bArr, com.tencent.turingcam.oqKCa.b()), "UTF-8");
        } catch (Throwable th2) {
            return "";
        }
    }

    public final long a(Context context, String str) {
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public final vneRm a(Context context) {
        try {
            String b = b(context, "101");
            if (TextUtils.isEmpty(b)) {
                return vneRm.a(1);
            }
            long j = 0;
            try {
                j = Long.valueOf(b(context, ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)).longValue();
            } catch (Throwable th) {
            }
            String b2 = b(context, "104");
            String b3 = b(context, "105");
            String b4 = b(context, "106");
            String b5 = b(context, "110");
            vneRm.spXPg spxpg = new vneRm.spXPg();
            spxpg.b = j;
            spxpg.f40004a = b;
            spxpg.f40005c = b2;
            spxpg.d = b3;
            spxpg.e = b4;
            spxpg.f = b5;
            return new vneRm(spxpg);
        } catch (Throwable th2) {
            return vneRm.a(1);
        }
    }

    public final void a(Context context, long j) {
        long j2 = j;
        if (j >= Long.MAX_VALUE) {
            j2 = Long.MAX_VALUE;
        }
        a(context, "401", "" + j2, true);
    }

    public final void a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, (Map<String, String>) hashMap, false);
    }

    public final void a(Context context, String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, hashMap, z);
    }

    public final void a(Context context, Map<String, String> map, boolean z) {
        if (z) {
            a(context, map);
        } else {
            this.b.post(new spXPg(context, map));
        }
    }

    public final WOMZP b(Context context) {
        System.currentTimeMillis();
        WOMZP womzp = new WOMZP(30);
        String[] split = b(context, "402").split(BridgeUtil.UNDERLINE_STR);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return womzp;
            }
            try {
                womzp.a(Long.valueOf(Long.valueOf(split[i2]).longValue()));
            } catch (NumberFormatException e) {
            }
            i = i2 + 1;
        }
    }

    public final void b(Context context, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("902", "" + j);
        a(context, hashMap);
    }

    public final void c(Context context, long j) {
        a(context, "503", "" + j, true);
    }
}
