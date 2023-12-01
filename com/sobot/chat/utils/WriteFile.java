package com.sobot.chat.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/WriteFile.class */
public class WriteFile {
    public static void checkFilePath(String str) {
        File file = new File(str.substring(0, str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1));
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        File file2 = new File(str);
        if (file2.isFile()) {
            return;
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringToFile(String str, String str2, boolean z) {
        try {
            checkFilePath(str);
            FileWriter fileWriter = new FileWriter(str, z);
            fileWriter.write(str2);
            fileWriter.close();
            System.out.println("finish");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
