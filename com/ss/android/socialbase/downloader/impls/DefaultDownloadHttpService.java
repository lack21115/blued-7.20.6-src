package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DefaultDownloadHttpService.class */
public class DefaultDownloadHttpService implements IDownloadHttpService {
    private final LruCache<String, OkHttpClient> hostIpClientCache = new LruCache<>(4, 8);

    private OkHttpClient createSpecialHostIpClient(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + BridgeUtil.UNDERLINE_STR + str2;
                synchronized (this.hostIpClientCache) {
                    OkHttpClient okHttpClient = this.hostIpClientCache.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder createDownloadClientBuilder = DownloadComponentManager.createDownloadClientBuilder();
                    createDownloadClientBuilder.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.2
                        @Override // okhttp3.Dns
                        public List<InetAddress> lookup(String str4) throws UnknownHostException {
                            return TextUtils.equals(host, str4) ? Collections.singletonList(InetAddress.getByName(str2)) : Dns.SYSTEM.lookup(str4);
                        }
                    });
                    OkHttpClient build = createDownloadClientBuilder.build();
                    synchronized (this.hostIpClientCache) {
                        this.hostIpClientCache.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return DownloadComponentManager.getDownloadClient();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public IDownloadHttpConnection downloadWithConnection(int i, String str, List<HttpHeader> list) throws IOException {
        String str2;
        Request.Builder url = new Request.Builder().url(str);
        if (list != null && list.size() > 0) {
            Iterator<HttpHeader> it = list.iterator();
            String str3 = null;
            while (true) {
                str2 = str3;
                if (!it.hasNext()) {
                    break;
                }
                HttpHeader next = it.next();
                String name = next.getName();
                if (str3 == null && DownloadConstants.EXTRA_REQUEST_HOST_IP.equals(name)) {
                    str3 = next.getValue();
                } else {
                    url.addHeader(name, DownloadUtils.getEncodedStr(next.getValue()));
                }
            }
        } else {
            str2 = null;
        }
        OkHttpClient createSpecialHostIpClient = !TextUtils.isEmpty(str2) ? createSpecialHostIpClient(str, str2) : DownloadComponentManager.getDownloadClient();
        if (createSpecialHostIpClient != null) {
            final Call newCall = createSpecialHostIpClient.newCall(url.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                final ResponseBody body = execute.body();
                if (body != null) {
                    GZIPInputStream byteStream = body.byteStream();
                    String header = execute.header("Content-Encoding");
                    if (header != null && "gzip".equalsIgnoreCase(header) && !(byteStream instanceof GZIPInputStream)) {
                        byteStream = new GZIPInputStream(byteStream);
                    }
                    final InputStream inputStream = byteStream;
                    return new IDefaultDownloadHttpConnection() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.1
                        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                        public void cancel() {
                            Call call = newCall;
                            if (call == null || call.isCanceled()) {
                                return;
                            }
                            newCall.cancel();
                        }

                        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                        public void end() {
                            try {
                                if (body != null) {
                                    body.close();
                                }
                                if (newCall == null || newCall.isCanceled()) {
                                    return;
                                }
                                newCall.cancel();
                            } catch (Throwable th) {
                            }
                        }

                        @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
                        public String getHostIp() {
                            return "";
                        }

                        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                        public InputStream getInputStream() throws IOException {
                            return inputStream;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                        public int getResponseCode() throws IOException {
                            return execute.code();
                        }

                        @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                        public String getResponseHeaderField(String str4) {
                            return execute.header(str4);
                        }
                    };
                }
                return null;
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
