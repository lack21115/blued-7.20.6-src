package com.zego.zegoavkit2.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/utils/SysUtil.class */
public final class SysUtil {
    private static void closeReader(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getOsInfo() {
        return (Build.MANUFACTURER + ":" + Build.VERSION.RELEASE + ":" + Build.MODEL + ":" + Build.VERSION.SDK_INT + ":" + Build.BRAND).replaceAll(",", ".");
    }

    public static String getSoCModel() {
        String readProp;
        String soCModelFromCPUInfo = getSoCModelFromCPUInfo();
        if (isValidSoCModel(soCModelFromCPUInfo)) {
            readProp = soCModelFromCPUInfo.split(" ")[0];
        } else {
            readProp = readProp("ro.board.platform");
            if (!isValidSoCModel(readProp)) {
                readProp = Build.HARDWARE;
                if (!isValidSoCModel(readProp)) {
                    String str = Build.HARDWARE;
                    readProp = str;
                    if (str == null) {
                        readProp = "";
                    }
                }
            }
        }
        return readProp.toLowerCase();
    }

    static String getSoCModelFromCPUInfo() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        File file = new File("/proc/cpuinfo");
        String str = "";
        if (file.exists()) {
            if (!file.canRead()) {
                return "";
            }
            BufferedReader bufferedReader3 = null;
            try {
                bufferedReader2 = new BufferedReader(new FileReader(file), 8192);
            } catch (Exception e) {
                e = e;
            }
            try {
                String readLine = bufferedReader2.readLine();
                while (true) {
                    str = "";
                    bufferedReader = bufferedReader2;
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("Hardware")) {
                        Matcher matcher = Pattern.compile("sm\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher.find()) {
                            str = matcher.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher2 = Pattern.compile("sdm\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher2.find()) {
                            str = matcher2.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher3 = Pattern.compile("msm\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher3.find()) {
                            str = matcher3.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher4 = Pattern.compile("apq\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher4.find()) {
                            str = matcher4.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher5 = Pattern.compile("((waipio)|(lahaina)|(kona)|(huracan)|(hana)|(napali)|(nairo)|(lito)|(atoll)|(trinket)|(bengal))").matcher(readLine.toLowerCase());
                        if (matcher5.find()) {
                            str = matcher5.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher6 = Pattern.compile("kirin\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher6.find()) {
                            str = matcher6.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher7 = Pattern.compile("hi\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher7.find()) {
                            str = matcher7.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher8 = Pattern.compile("mt\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher8.find()) {
                            str = matcher8.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher9 = Pattern.compile("kompanio\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher9.find()) {
                            str = matcher9.toMatchResult().group(0);
                            break;
                        }
                        Matcher matcher10 = Pattern.compile("(samsung)?e(xynos)?\\d+.*").matcher(readLine.toLowerCase());
                        if (matcher10.find()) {
                            str = matcher10.toMatchResult().group(0);
                            break;
                        }
                    }
                    readLine = bufferedReader2.readLine();
                }
                bufferedReader = bufferedReader2;
            } catch (Exception e2) {
                bufferedReader3 = bufferedReader2;
                e = e2;
                e.printStackTrace();
                bufferedReader = bufferedReader3;
                str = "";
                closeReader(bufferedReader);
                return str;
            }
            closeReader(bufferedReader);
        }
        return str;
    }

    public static String getVersion() {
        return Build.VERSION.RELEASE.replaceAll(",", ".");
    }

    static boolean isValidSoCModel(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        return Pattern.matches("^sm\\d+.*", lowerCase) || Pattern.matches("^sdm\\d+.*", lowerCase) || Pattern.matches("^msm\\d+.*", lowerCase) || Pattern.matches("^apq\\d+.*", lowerCase) || Pattern.matches("^((waipio)|(lahaina)|(kona)|(huracan)|(hana)|(napali)|(nairo)|(lito)|(atoll)|(trinket)|(bengal))", lowerCase) || Pattern.matches("^kirin\\d+.*", lowerCase) || Pattern.matches("^hi\\d+.*", lowerCase) || Pattern.matches("^mt\\d+.*", lowerCase) || Pattern.matches("^kompanio\\d+.*", lowerCase) || Pattern.matches("^(samsung)?e(xynos)?\\d+.*", lowerCase);
    }

    static String readProp(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = new ProcessBuilder(new String[0]).command("getprop", str).redirectErrorStream(true).start();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (Exception e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    readLine = "";
                }
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                }
                if (process != null) {
                    process.destroy();
                }
                return readLine;
            } catch (Exception e3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                if (process != null) {
                    process.destroy();
                    return "";
                }
                return "";
            } catch (Throwable th2) {
                bufferedReader2 = bufferedReader;
                th = th2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (Exception e6) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
    }
}
