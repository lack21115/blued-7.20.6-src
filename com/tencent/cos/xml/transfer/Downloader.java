package com.tencent.cos.xml.transfer;

import android.content.Context;
import com.tencent.cos.xml.CosXml;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.utils.SharePreferenceUtils;
import java.io.File;
import java.util.List;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/Downloader.class */
public class Downloader {
    private String bucket;
    private String cosPath;
    private CosXml cosXmlServer;
    private GetObjectRequest getObjectRequest;
    private String localFileName;
    private String localPath;
    private SharePreferenceUtils sharePreferedUtils;
    private long rangeStart = 0;
    private ListenerHandler listenerHandler = new ListenerHandler();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/Downloader$ListenerHandler.class */
    class ListenerHandler implements CosXmlProgressListener, CosXmlResultListener {
        private CosXmlProgressListener cosXmlProgressListener;
        private CosXmlResultListener cosXmlResultListener;

        public ListenerHandler() {
        }

        @Override // com.tencent.cos.xml.listener.CosXmlResultListener
        public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
            CosXmlResultListener cosXmlResultListener = this.cosXmlResultListener;
            if (cosXmlResultListener != null) {
                cosXmlResultListener.onFail(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
            }
        }

        @Override // com.tencent.qcloud.core.common.QCloudProgressListener
        public void onProgress(long j, long j2) {
            CosXmlProgressListener cosXmlProgressListener = this.cosXmlProgressListener;
            if (cosXmlProgressListener != null) {
                cosXmlProgressListener.onProgress(Downloader.this.rangeStart + j, Downloader.this.rangeStart + j2);
            }
        }

        @Override // com.tencent.cos.xml.listener.CosXmlResultListener
        public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
            Downloader.this.sharePreferedUtils.clear(Downloader.this.getObjectRequest.getDownloadPath());
            CosXmlResultListener cosXmlResultListener = this.cosXmlResultListener;
            if (cosXmlResultListener != null) {
                cosXmlResultListener.onSuccess(cosXmlRequest, cosXmlResult);
            }
        }

        public void setCosXmlProgressListener(CosXmlProgressListener cosXmlProgressListener) {
            this.cosXmlProgressListener = cosXmlProgressListener;
        }

        public void setCosXmlResultListener(CosXmlResultListener cosXmlResultListener) {
            this.cosXmlResultListener = cosXmlResultListener;
        }
    }

    public Downloader(Context context, CosXml cosXml) {
        this.sharePreferedUtils = SharePreferenceUtils.instance(context);
        this.cosXmlServer = cosXml;
    }

    private void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "bucket must not be null ");
        }
        if (this.cosPath == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "cosPath must not be null ");
        }
        if (this.localPath == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "localPath must not be null ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getRange(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public void cancel() {
        CosXml cosXml;
        GetObjectRequest getObjectRequest = this.getObjectRequest;
        if (getObjectRequest == null || (cosXml = this.cosXmlServer) == null) {
            return;
        }
        cosXml.cancel(getObjectRequest);
    }

    public GetObjectResult download(String str, String str2, String str3, String str4) throws CosXmlClientException, CosXmlServiceException {
        this.bucket = str;
        this.cosPath = str2;
        this.localPath = str3;
        this.localFileName = str4;
        checkParameters();
        List<String> list = this.cosXmlServer.headObject(new HeadObjectRequest(str, str2)).headers.get("ETag");
        String str5 = (list == null || list.size() <= 0) ? null : list.get(0);
        GetObjectRequest getObjectRequest = new GetObjectRequest(str, str2, str3, str4);
        this.getObjectRequest = getObjectRequest;
        this.rangeStart = 0L;
        String downloadPath = getObjectRequest.getDownloadPath();
        if (str5 != null) {
            String value = this.sharePreferedUtils.getValue(downloadPath);
            if (value == null || !str5.equals(value)) {
                this.sharePreferedUtils.updateValue(downloadPath, str5);
            } else {
                this.rangeStart = getRange(downloadPath);
            }
        }
        this.getObjectRequest.setRange(this.rangeStart);
        this.getObjectRequest.setProgressListener(this.listenerHandler);
        GetObjectResult object = this.cosXmlServer.getObject(this.getObjectRequest);
        this.sharePreferedUtils.clear(downloadPath);
        return object;
    }

    public void download(String str, String str2, String str3, String str4, CosXmlResultListener cosXmlResultListener) {
        this.bucket = str;
        this.cosPath = str2;
        this.localPath = str3;
        this.localFileName = str4;
        this.listenerHandler.setCosXmlResultListener(cosXmlResultListener);
        try {
            checkParameters();
            this.getObjectRequest = new GetObjectRequest(str, str2, str3, str4);
            this.cosXmlServer.headObjectAsync(new HeadObjectRequest(str, str2), new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.Downloader.1
                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                    Downloader.this.listenerHandler.onFail(Downloader.this.getObjectRequest, cosXmlClientException, cosXmlServiceException);
                }

                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                    List<String> list = ((HeadObjectResult) cosXmlResult).headers.get("ETag");
                    String str5 = (list == null || list.size() <= 0) ? null : list.get(0);
                    Downloader.this.rangeStart = 0L;
                    String downloadPath = Downloader.this.getObjectRequest.getDownloadPath();
                    if (str5 != null) {
                        String value = Downloader.this.sharePreferedUtils.getValue(downloadPath);
                        if (value == null || !str5.equals(value)) {
                            Downloader.this.sharePreferedUtils.updateValue(downloadPath, str5);
                        } else {
                            Downloader downloader = Downloader.this;
                            downloader.rangeStart = downloader.getRange(downloadPath);
                        }
                    }
                    Downloader.this.getObjectRequest.setRange(Downloader.this.rangeStart);
                    Downloader.this.getObjectRequest.setProgressListener(Downloader.this.listenerHandler);
                    Downloader.this.cosXmlServer.getObjectAsync(Downloader.this.getObjectRequest, Downloader.this.listenerHandler);
                }
            });
        } catch (CosXmlClientException e) {
            this.listenerHandler.onFail(this.getObjectRequest, e, null);
        }
    }

    public void setProgress(CosXmlProgressListener cosXmlProgressListener) {
        this.listenerHandler.setCosXmlProgressListener(cosXmlProgressListener);
    }
}
