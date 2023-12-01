package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/TransactionIdCreater.class */
public class TransactionIdCreater {
    public static String getId(String str, String str2) {
        return StringUtil.addByteForNum(str, 9, '0') + StringUtil.addByteForNum(str2, 6, '0') + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new Random().nextInt(1000000)));
    }
}
