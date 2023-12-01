package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/DateUtils.class */
public class DateUtils {
    private static final String GMT_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";

    public static String getFormatTime(String str, long j) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(j));
    }

    public static Date toDate(String str) throws CosXmlClientException {
        try {
            return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).parse(str);
        } catch (ParseException e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        }
    }

    public static String toString(long j) {
        return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).format(new Date(j));
    }

    public static String toString(Date date) {
        return new SimpleDateFormat(GMT_TIME_FORMAT, Locale.ENGLISH).format(date);
    }
}
