package com.soft.blued.ui.msg.controller.tools;

import android.text.TextUtils;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.blued.android.module.common.user.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/IMV4Method.class */
public class IMV4Method {
    public static int a(long j) {
        return String.valueOf(j).equals(UserInfo.getInstance().getLoginUserInfo().getUid()) ? 0 : 1;
    }

    public static int a(ArrayList<String> arrayList, String str) {
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next) && next.equals(str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static String a(int i, long j) {
        return "" + i + "_" + j;
    }

    public static String a(ChattingModel chattingModel) {
        String str = "";
        if (!TextUtils.isEmpty(chattingModel.msgContent)) {
            String[] split = chattingModel.msgContent.split(",,");
            if (split.length < 2) {
                return "";
            }
            str = split[0];
        }
        return str;
    }

    public static String a(short s, long j, String str) {
        long j2 = j;
        if (s == 2) {
            j2 = j;
            if (j < 0) {
                j2 = -j;
            }
        }
        return AppMethods.b(a(s, j2)) + "/" + Md5.a(str.toLowerCase().trim());
    }

    public static ArrayList<String> a(List<ChattingModel> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (ChattingModel chattingModel : list) {
            if (chattingModel.msgType == 2 || chattingModel.msgType == 251) {
                arrayList.add(chattingModel.msgContent);
            }
        }
        return arrayList;
    }

    public static boolean b(long j) {
        return String.valueOf(j).equals(UserInfo.getInstance().getLoginUserInfo().getUid());
    }
}
