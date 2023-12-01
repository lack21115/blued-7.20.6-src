package com.weimob.library.groups.imageloader.executor;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/executor/ImageLoaderHttpUrlConnectionNetworkFetcher.class */
public class ImageLoaderHttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private final ExecutorService mExecutorService;

    public ImageLoaderHttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
    }

    public ImageLoaderHttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        HttpURLConnection openConnectionTo = openConnectionTo(uri);
        int responseCode = openConnectionTo.getResponseCode();
        if (isHttpSuccess(responseCode)) {
            return openConnectionTo;
        }
        if (!isHttpRedirect(responseCode)) {
            openConnectionTo.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        String headerField = openConnectionTo.getHeaderField(HttpHeaders.LOCATION);
        openConnectionTo.disconnect();
        Uri parse = headerField == null ? null : Uri.parse(headerField);
        String scheme = uri.getScheme();
        if (i <= 0 || parse == null || parse.getScheme().equals(scheme)) {
            throw new IOException(i == 0 ? error("URL %s follows too many redirects", uri.toString()) : error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        return downloadFrom(parse, i - 1);
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    private static boolean isHttpRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    public void fetch(final FetchState fetchState, final NetworkFetcher.Callback callback) {
        final Future<?> submit = this.mExecutorService.submit(new Runnable() { // from class: com.weimob.library.groups.imageloader.executor.ImageLoaderHttpUrlConnectionNetworkFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                ImageLoaderHttpUrlConnectionNetworkFetcher.this.fetchSync(fetchState, callback);
            }
        });
        fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.weimob.library.groups.imageloader.executor.ImageLoaderHttpUrlConnectionNetworkFetcher.2
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void fetchSync(com.facebook.imagepipeline.producers.FetchState r5, com.facebook.imagepipeline.producers.NetworkFetcher.Callback r6) {
        /*
            r4 = this;
            r0 = 0
            r12 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r4
            r1 = r5
            android.net.Uri r1 = r1.getUri()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L6a
            r2 = 5
            java.net.HttpURLConnection r0 = r0.downloadFrom(r1, r2)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L6a
            r7 = r0
            r0 = r12
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L4c
            r0 = r11
            r9 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r8 = r0
            r0 = r7
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L92
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            r5 = r0
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = r10
            r2 = -1
            r0.onResponse(r1, r2)     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L92
            goto L4c
        L47:
            r10 = move-exception
            goto L6e
        L4c:
            r0 = r10
            if (r0 == 0) goto L59
            r0 = r10
            r0.close()     // Catch: java.io.IOException -> Laa
            goto L59
        L59:
            r0 = r7
            if (r0 == 0) goto L91
            goto L8d
        L60:
            r6 = move-exception
            r0 = 0
            r8 = r0
            r0 = r10
            r5 = r0
            goto L93
        L6a:
            r10 = move-exception
            r0 = 0
            r7 = r0
        L6e:
            r0 = r9
            r5 = r0
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = r10
            r0.onFailure(r1)     // Catch: java.lang.Throwable -> L92
            r0 = r9
            if (r0 == 0) goto L89
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> Lae
            goto L89
        L89:
            r0 = r7
            if (r0 == 0) goto L91
        L8d:
            r0 = r7
            r0.disconnect()
        L91:
            return
        L92:
            r6 = move-exception
        L93:
            r0 = r5
            if (r0 == 0) goto L9e
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> Lb2
            goto L9e
        L9e:
            r0 = r8
            if (r0 == 0) goto La8
            r0 = r8
            r0.disconnect()
        La8:
            r0 = r6
            throw r0
        Laa:
            r5 = move-exception
            goto L59
        Lae:
            r5 = move-exception
            goto L89
        Lb2:
            r5 = move-exception
            goto L9e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.weimob.library.groups.imageloader.executor.ImageLoaderHttpUrlConnectionNetworkFetcher.fetchSync(com.facebook.imagepipeline.producers.FetchState, com.facebook.imagepipeline.producers.NetworkFetcher$Callback):void");
    }
}
