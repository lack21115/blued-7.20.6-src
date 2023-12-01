package com.sobot.chat.utils;

import com.alipay.sdk.util.i;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.umeng.analytics.pro.bh;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/WriteTxtToStringOrJson.class */
public class WriteTxtToStringOrJson {
    public static String version_path = "3_1_3";

    public static void main(String[] strArr) {
        List<String> arrayByFileReader = ReadFile.toArrayByFileReader("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/sobotlocalizable_key.txt");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "zh-Hans");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "zh-Hant");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.ab);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.Y);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.W);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.aa);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "en");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "th");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.X);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.Z);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "tr");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "it");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "id");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "in");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "pt");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "es");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "ms");
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, bh.aC);
        writeJsonString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "vi");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "zh-Hant", "zh-rtw");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.ab, "ru-rRU");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.Y, "ko-rKR");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.W, "ja-rJP");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.aa, a.aa);
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "en", "en");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "th", "th-rTH");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.X, a.X);
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, a.Z, a.Z);
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "tr", "tr");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "it", "it");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "id", "id");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "in", "in");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "pt", "pt");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "es", "es");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "ms", "ms");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, bh.aC, "pl-rPL");
        writeXmlString("/Users/edy/Documents/sobotpublish/yuyanbao/localizable3.1.3/", arrayByFileReader, "vi", "vi-rVN");
    }

    public static void writeJsonString(String str, List<String> list, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> arrayByFileReader = ReadFile.toArrayByFileReader(str + "sobotlocalizable_value_" + str2 + ".txt");
        stringBuffer.append("{");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                stringBuffer.append(i.d);
                System.out.println(stringBuffer.toString());
                WriteFile.writeStringToFile(str + BridgeUtil.SPLIT_MARK + version_path + "/sobot_android_strings_" + str2 + ".json", stringBuffer.toString(), true);
                return;
            }
            if (i2 == list.size() - 1) {
                stringBuffer.append("\"" + list.get(i2) + "\":\"" + arrayByFileReader.get(i2) + "\"");
            } else {
                stringBuffer.append("\"" + list.get(i2) + "\":\"" + arrayByFileReader.get(i2) + "\",");
            }
            i = i2 + 1;
        }
    }

    public static void writeXmlString(String str, List<String> list, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> arrayByFileReader = ReadFile.toArrayByFileReader(str + "sobotlocalizable_value_" + str2 + ".txt");
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                stringBuffer.append("</resources>");
                System.out.println(stringBuffer.toString());
                WriteFile.writeStringToFile(str + "values-" + str3 + "/strings.xml", stringBuffer.toString(), true);
                return;
            }
            stringBuffer.append("       <string name=\"" + list.get(i2) + "\">" + arrayByFileReader.get(i2) + "</string>\n");
            i = i2 + 1;
        }
    }
}
