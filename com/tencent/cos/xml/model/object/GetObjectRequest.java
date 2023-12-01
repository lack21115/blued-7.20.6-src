package com.tencent.cos.xml.model.object;

import android.net.Uri;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/GetObjectRequest.class */
public class GetObjectRequest extends ObjectRequest implements TransferRequest {
    private Uri fileContentUri;
    private long fileOffset;
    private CosXmlProgressListener progressListener;
    private Range range;
    private String rspCacheControl;
    private String rspContentDisposition;
    private String rspContentEncoding;
    private String rspContentLanguage;
    private String rspContentType;
    private String rspExpires;
    private String saveFileName;
    private String savePath;
    private String versionId;

    public GetObjectRequest(String str, String str2, Uri uri) {
        super(str, str2);
        this.fileOffset = 0L;
        this.fileContentUri = uri;
    }

    public GetObjectRequest(String str, String str2, String str3) {
        super(str, str2);
        this.fileOffset = 0L;
        this.savePath = str3;
    }

    public GetObjectRequest(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.fileOffset = 0L;
        this.savePath = str3;
        this.saveFileName = str4;
    }

    public String getDownloadPath() {
        String str;
        String str2;
        int lastIndexOf;
        String str3 = this.savePath;
        if (str3 != null) {
            if (str3.endsWith(BridgeUtil.SPLIT_MARK)) {
                str2 = this.savePath;
            } else {
                str2 = this.savePath + BridgeUtil.SPLIT_MARK;
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.saveFileName != null) {
                return str2 + this.saveFileName;
            }
            str = str2;
            if (this.cosPath != null) {
                if (this.cosPath.lastIndexOf(BridgeUtil.SPLIT_MARK) >= 0) {
                    return str2 + this.cosPath.substring(lastIndexOf + 1);
                }
                return str2 + this.cosPath;
            }
        } else {
            str = null;
        }
        return str;
    }

    public Uri getFileContentUri() {
        return this.fileContentUri;
    }

    public long getFileOffset() {
        return this.fileOffset;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        if (this.versionId != null) {
            this.queryParameters.put("versionId", this.versionId);
        }
        if (this.rspContentType != null) {
            this.queryParameters.put("response-content-type", this.rspContentType);
        }
        if (this.rspContentLanguage != null) {
            this.queryParameters.put("response-content-language", this.rspContentLanguage);
        }
        if (this.rspExpires != null) {
            this.queryParameters.put("response-expires", this.rspExpires);
        }
        if (this.rspCacheControl != null) {
            this.queryParameters.put("response-cache-control", this.rspCacheControl);
        }
        if (this.rspContentDisposition != null) {
            this.queryParameters.put("response-content-disposition", this.rspContentDisposition);
        }
        if (this.rspContentEncoding != null) {
            this.queryParameters.put("response-content-encoding", this.rspContentEncoding);
        }
        return super.getQueryString();
    }

    public Range getRange() {
        return this.range;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public String getRspCacheControl() {
        return this.rspCacheControl;
    }

    public String getRspContentDispositon() {
        return this.rspContentDisposition;
    }

    public String getRspContentEncoding() {
        return this.rspContentEncoding;
    }

    public String getRspContentLanguage() {
        return this.rspContentLanguage;
    }

    public String getRspContentType() {
        return this.rspContentType;
    }

    public String getRspExpires() {
        return this.rspExpires;
    }

    public String getSaveFileName() {
        return this.saveFileName;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public void setFileOffset(long j) {
        if (j > 0) {
            this.fileOffset = j;
        }
    }

    public void setIfMatch(String str) {
        if (str != null) {
            addHeader("If-Match", str);
        }
    }

    public void setIfModifiedSince(String str) {
        if (str != null) {
            addHeader("If-Modified-Since", str);
        }
    }

    public void setIfNONEMatch(String str) {
        if (str != null) {
            addHeader("If-None-Match", str);
        }
    }

    public void setIfUnmodifiedSince(String str) {
        if (str != null) {
            addHeader("If-Unmodified-Since", str);
        }
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public void setRange(long j) {
        setRange(j, -1L);
    }

    public void setRange(long j, long j2) {
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        Range range = new Range(j3, j2);
        addHeader("Range", range.getRange());
        this.range = range;
    }

    public void setRspCacheControl(String str) {
        this.rspCacheControl = str;
    }

    public void setRspContentDispositon(String str) {
        this.rspContentDisposition = str;
    }

    public void setRspContentEncoding(String str) {
        this.rspContentEncoding = str;
    }

    public void setRspContentLanguage(String str) {
        this.rspContentLanguage = str;
    }

    public void setRspContentType(String str) {
        this.rspContentType = str;
    }

    public void setRspExpires(String str) {
        this.rspExpires = str;
    }

    public void setSaveFileName(String str) {
        this.saveFileName = str;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    @Override // com.tencent.cos.xml.model.object.TransferRequest
    public void setTrafficLimit(long j) {
        addHeader(Headers.COS_TRAFFIC_LIMIT, String.valueOf(j));
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
