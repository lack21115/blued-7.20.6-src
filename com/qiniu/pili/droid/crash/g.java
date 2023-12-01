package com.qiniu.pili.droid.crash;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/g.class */
public class g implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private File f13793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(File file) {
        this.f13793a = file;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Integer call() throws Exception {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://sdk-dau.cn-shanghai.log.aliyuncs.com/logstores/crash/track").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("x-log-apiversion", "0.6.0");
            httpURLConnection.setRequestProperty("x-log-bodyrawsize", "1234");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f13793a));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    String sb2 = sb.toString();
                    PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    printWriter.write(sb2);
                    printWriter.flush();
                    printWriter.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                    return Integer.valueOf(responseCode);
                }
                sb.append(readLine);
            }
        } catch (UnknownHostException e) {
            return 500;
        }
    }
}
