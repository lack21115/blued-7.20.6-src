package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.Chain;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/hj.class */
public class hj extends LruCache<Long, Bitmap> {
    private final Map<Long, SoftReference<mb>> mb;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/hj$mb.class */
    public interface mb {
        void mb(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/hj$ox.class */
    public static class ox {
        private static hj mb = new hj();
    }

    private hj() {
        super(8, 8);
        this.mb = new HashMap();
    }

    public static hj mb() {
        return ox.mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ox(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public void mb(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) == null) {
            if (TextUtils.isEmpty(str)) {
                h.mb(12, j2);
                return;
            } else {
                Chain.mb((Chain.mb<Object, R>) new Chain.mb<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hj.2
                    @Override // com.ss.android.downloadlib.utils.Chain.mb
                    public Object mb(Object obj) {
                        BufferedInputStream bufferedInputStream;
                        BufferedInputStream bufferedInputStream2;
                        try {
                            IDownloadHttpConnection downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                            if (downloadWithConnection == null) {
                                DownloadUtils.safeClose(null);
                                return null;
                            }
                            bufferedInputStream2 = new BufferedInputStream(downloadWithConnection.getInputStream());
                            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
                            try {
                                try {
                                    bufferedInputStream2.mark(bufferedInputStream2.available());
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                                    int i = options.outWidth;
                                    int i2 = options.outHeight;
                                    int mb2 = jb.mb(x.getContext(), 60.0f);
                                    options.inSampleSize = hj.ox(mb2, mb2, options);
                                    options.inJustDecodeBounds = false;
                                    bufferedInputStream2.reset();
                                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.putOpt(EventConstants.ExtraJson.KEY_TYPE, "load_bitmap");
                                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    AdEventHandler.mb().mb(EventConstants.UnityLabel.TTD_PREF_MONITOR, jSONObject, j2);
                                    hj.this.put(Long.valueOf(j), decodeStream);
                                    DownloadUtils.safeClose(bufferedInputStream2);
                                    return null;
                                } catch (Throwable th) {
                                    bufferedInputStream = bufferedInputStream3;
                                    th = th;
                                    DownloadUtils.safeClose(bufferedInputStream);
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream3 = bufferedInputStream2;
                                com.ss.android.downloadlib.exception.b.mb().mb(e, "BitmapCache loadBitmap");
                                DownloadUtils.safeClose(bufferedInputStream2);
                                return null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedInputStream2 = null;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = null;
                            DownloadUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                    }
                }, (Object) null).mb(new Chain.mb<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hj.1
                    @Override // com.ss.android.downloadlib.utils.Chain.mb
                    public Object mb(Object obj) {
                        SoftReference softReference = (SoftReference) hj.this.mb.remove(Long.valueOf(j));
                        if (softReference == null || softReference.get() == 0) {
                            return null;
                        }
                        ((mb) softReference.get()).mb(hj.this.get(Long.valueOf(j)));
                        return null;
                    }
                }).mb();
                return;
            }
        }
        SoftReference<mb> remove = this.mb.remove(Long.valueOf(j));
        if (remove == null || remove.get() == null) {
            return;
        }
        remove.get().mb(get(Long.valueOf(j)));
    }

    public void mb(long j, mb mbVar) {
        if (get(Long.valueOf(j)) != null) {
            mbVar.mb(get(Long.valueOf(j)));
        } else {
            this.mb.put(Long.valueOf(j), new SoftReference<>(mbVar));
        }
    }
}
