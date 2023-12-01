package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.amap.api.services.core.AMapException;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.same.Logger;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveUtils.class */
public class LiveUtils {
    public static final int[] a = {1, 5, 15, 30, 50, 100, 200, HttpURLConnection.HTTP_BAD_REQUEST, 650, 1000, 1500, AMapException.CODE_AMAP_NEARBY_INVALID_USERID, 2800, 3800, 5000, 8000, 12000, 17000, 23000, 30000, 38000, 47000, 57000, 70000, 88000, 114000, 150000, 198000, 261000, 342000, 453000, 606000, 783000, 1013000, 1413000};
    public static Pattern b = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");

    public static int a(double d, float f, float f2, float f3) {
        float f4 = f3 - f2;
        float f5 = ((float) d) / f4;
        float f6 = ((f - f2) * 100.0f) / f4;
        int i = (int) (f5 + f6 + 0.5f);
        int i2 = i;
        if (i < ((int) f6) + 1) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (i2 > 100) {
            i3 = 100;
        }
        return i3;
    }

    public static int a(float f, float f2, float f3) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCurrentProgress currentLevelEx:");
        sb.append(f2);
        sb.append(" -- nextLevelEx:");
        sb.append(f3);
        sb.append(" -- return ");
        int i = (int) (((f - f2) / (f3 - f2)) * 100.0f);
        sb.append(i);
        Log.v("pk", sb.toString());
        return i;
    }

    public static int a(Context context, ImageView imageView, int i, boolean z) {
        String str;
        if (i < 0) {
            if (imageView != null) {
                imageView.setVisibility(8);
                return -1;
            }
            return -1;
        }
        int i2 = i;
        if (i >= 99) {
            i2 = 99;
        }
        if (i2 < 10) {
            str = "00" + i2;
        } else if (i2 < 100) {
            str = "0" + i2;
        } else {
            str = i2 + "";
        }
        int identifier = context.getResources().getIdentifier("anchor_rich" + str, "drawable", context.getPackageName());
        if (imageView != null) {
            imageView.setImageResource(identifier);
            if (i2 == 0 && z) {
                imageView.setVisibility(8);
                return identifier;
            }
            imageView.setVisibility(0);
        }
        return identifier;
    }

    public static long a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static LiveGiftModel a(LiveChattingModel liveChattingModel) {
        if (liveChattingModel.msgType != 33) {
            return null;
        }
        if (liveChattingModel.msgMapExtra != null) {
            return (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
        }
        if (TextUtils.isEmpty(liveChattingModel.getMsgExtra())) {
            return null;
        }
        try {
            return (LiveGiftModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), LiveGiftModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static CharSequence a(CharSequence charSequence, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static String a(int i) {
        return c(i);
    }

    public static String a(LiveAnnounceInfoModel liveAnnounceInfoModel) {
        if (liveAnnounceInfoModel == null) {
            return "";
        }
        if (liveAnnounceInfoModel.live_time > 86400) {
            String str = a(System.currentTimeMillis()) == a(liveAnnounceInfoModel.live_time * 1000) ? "今天 HH:mm" : "M月d日 HH:mm";
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            calendar.setTimeInMillis(liveAnnounceInfoModel.live_time * 1000);
            return BlueAppLocal.d() ? new SimpleDateFormat(str, BlueAppLocal.c()).format(calendar.getTime()) : new SimpleDateFormat(str, Locale.ENGLISH).format(calendar.getTime());
        } else if (TextUtils.isEmpty(liveAnnounceInfoModel.live_week_time) || liveAnnounceInfoModel.live_week_time.equals("0000000") || liveAnnounceInfoModel.live_week_time.length() < 7) {
            return "";
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (liveAnnounceInfoModel.live_week_time.equals("1111111")) {
                stringBuffer.append("每天");
            } else {
                stringBuffer.append("每周");
                if (liveAnnounceInfoModel.live_week_time.charAt(6) == '1') {
                    stringBuffer.append("一、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(5) == '1') {
                    stringBuffer.append("二、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(4) == '1') {
                    stringBuffer.append("三、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(3) == '1') {
                    stringBuffer.append("四、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(2) == '1') {
                    stringBuffer.append("五、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(1) == '1') {
                    stringBuffer.append("六、");
                }
                if (liveAnnounceInfoModel.live_week_time.charAt(0) == '1') {
                    stringBuffer.append("日、");
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
            calendar2.setTimeInMillis(a(System.currentTimeMillis()) + (liveAnnounceInfoModel.live_time * 1000));
            if (BlueAppLocal.d()) {
                stringBuffer.append(new SimpleDateFormat(" HH:mm", BlueAppLocal.c()).format(calendar2.getTime()));
            } else {
                stringBuffer.append(new SimpleDateFormat(" HH:mm", Locale.ENGLISH).format(calendar2.getTime()));
            }
            return stringBuffer.toString();
        }
    }

    public static String a(List<LiveChattingModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                Logger.b("TAG", "举报传给服务器的拼接字符串：", stringBuffer.toString());
                return stringBuffer.toString();
            }
            LiveChattingModel liveChattingModel = list.get(i2);
            if (i2 == list.size() - 1) {
                stringBuffer.append("[" + liveChattingModel.fromId + "][" + liveChattingModel.msgContent + "][" + liveChattingModel.msgTimestamp + "]");
            } else {
                stringBuffer.append("[" + liveChattingModel.fromId + "][" + liveChattingModel.msgContent + "][" + liveChattingModel.msgTimestamp + "]§§§§");
            }
            i = i2 + 1;
        }
    }

    public static LiveLiangModel b(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return null;
        }
        if (liveChattingModel.fromId == LiveRoomInfo.a().g()) {
            return LiveRoomManager.a().r();
        }
        LiveGiftModel a2 = a(liveChattingModel);
        if (a2 != null) {
            LiveLiangModel liveLiangModel = new LiveLiangModel();
            liveLiangModel.liang_type = a2.liang_type;
            liveLiangModel.liang_id = a2.liang_id;
            return liveLiangModel;
        } else if (liveChattingModel.msgMapExtra == null) {
            Gson f = AppInfo.f();
            try {
                if (TextUtils.isEmpty(liveChattingModel.getMsgExtra())) {
                    return null;
                }
                return (LiveLiangModel) f.fromJson(liveChattingModel.getMsgExtra(), LiveLiangModel.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            LiveLiangModel liveLiangModel2 = new LiveLiangModel();
            liveLiangModel2.liang_type = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "liang_type");
            liveLiangModel2.liang_id = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "liang_id");
            Log.i("xpp", "from map liang_info:" + liveLiangModel2.liang_type + "  : " + liveLiangModel2.liang_id);
            return liveLiangModel2;
        }
    }

    public static String b(int i) {
        return c(i);
    }

    public static LiveChatBadgeModel c(LiveChattingModel liveChattingModel) {
        if (liveChattingModel.fromId == LiveRoomInfo.a().g()) {
            if (liveChattingModel.msgType == 51 || liveChattingModel.msgType == 27) {
                return null;
            }
            return LiveRoomInfo.a().s();
        } else if (liveChattingModel == null || liveChattingModel.msgMapExtra == null) {
            return null;
        } else {
            String stringValue = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "chat_badge_url");
            if (TextUtils.isEmpty(stringValue)) {
                return null;
            }
            LiveChatBadgeModel liveChatBadgeModel = new LiveChatBadgeModel();
            liveChatBadgeModel.setChat_badge_url(stringValue);
            liveChatBadgeModel.setChat_badge_height(Integer.valueOf(MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "chat_badge_height")));
            liveChatBadgeModel.setChat_badge_length(Integer.valueOf(MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "chat_badge_length")));
            if (TextUtils.isEmpty(liveChatBadgeModel.getChat_badge_url()) || liveChatBadgeModel.getChat_badge_height().intValue() == 0 || liveChatBadgeModel.getChat_badge_length().intValue() == 0) {
                return null;
            }
            return liveChatBadgeModel;
        }
    }

    private static String c(int i) {
        Log.v("pk", "getLevelName richLevel=" + i);
        if (i == 30) {
            return "神壕1级";
        }
        if (i == 31) {
            return "神壕2级";
        }
        if (i == 32) {
            return "神壕3级";
        }
        if (i == 33) {
            return "神壕4级";
        }
        if (i == 34) {
            return "神壕5级";
        }
        if (i == 35) {
            return "神壕6级";
        }
        return i + "";
    }
}
