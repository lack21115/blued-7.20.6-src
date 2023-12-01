package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/network/NetworkFetcher.class */
public class NetworkFetcher {
    private final Context a;
    private final String b;
    private final NetworkCache c;

    private NetworkFetcher(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.c = new NetworkCache(applicationContext, str);
    }

    public static LottieResult<LottieComposition> a(Context context, String str) {
        return new NetworkFetcher(context, str).a();
    }

    private LottieComposition b() {
        Pair<FileExtension, InputStream> a = this.c.a();
        if (a == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a.first;
        InputStream inputStream = (InputStream) a.second;
        LottieResult<LottieComposition> a2 = fileExtension == FileExtension.ZIP ? LottieCompositionFactory.a(new ZipInputStream(inputStream), this.b) : LottieCompositionFactory.a(inputStream, this.b);
        if (a2.a() != null) {
            return a2.a();
        }
        return null;
    }

    private LottieResult<LottieComposition> c() {
        try {
            return d();
        } catch (IOException e) {
            return new LottieResult<>(e);
        }
    }

    /* JADX WARN: Finally extract failed */
    private LottieResult d() throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> a;
        Logger.a("Fetching " + this.b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                httpURLConnection.disconnect();
                String contentType = httpURLConnection.getContentType();
                boolean z = true;
                int hashCode = contentType.hashCode();
                boolean z2 = true;
                if (hashCode != -1248325150) {
                    if (hashCode == -43840953 && contentType.equals(FastJsonJsonView.DEFAULT_CONTENT_TYPE)) {
                        z = true;
                    }
                } else if (contentType.equals("application/zip")) {
                    z = false;
                }
                if (z) {
                    Logger.a("Received json response.");
                    fileExtension = FileExtension.JSON;
                    a = LottieCompositionFactory.a(new FileInputStream(new File(this.c.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.b);
                } else {
                    Logger.a("Handling zip response.");
                    fileExtension = FileExtension.ZIP;
                    a = LottieCompositionFactory.a(new ZipInputStream(new FileInputStream(this.c.a(httpURLConnection.getInputStream(), fileExtension))), this.b);
                }
                if (a.a() != null) {
                    this.c.a(fileExtension);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                if (a.a() == null) {
                    z2 = false;
                }
                sb.append(z2);
                Logger.a(sb.toString());
                return a;
            }
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.b + ". Failed with " + responseCode + "\n" + ((Object) sb2)));
                        }
                        sb2.append(readLine);
                        sb2.append('\n');
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
            }
        } catch (Exception e2) {
            return new LottieResult((Throwable) e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public LottieResult<LottieComposition> a() {
        LottieComposition b = b();
        if (b != null) {
            return new LottieResult<>(b);
        }
        Logger.a("Animation for " + this.b + " not found in cache. Fetching from network.");
        return c();
    }
}
