package com.tencent.cos.xml.model.object;

import android.content.ContentResolver;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.COSStorageClass;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.utils.DateUtils;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.qcloud.core.auth.COSXmlSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudCredentials;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.MultipartStreamRequestBody;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import com.umeng.analytics.pro.bh;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/PostObjectRequest.class */
public class PostObjectRequest extends ObjectRequest implements TransferRequest {
    private long contentLength;
    private FormStruct formStruct;
    private long offset;
    private CosXmlProgressListener progressListener;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/PostObjectRequest$FormStruct.class */
    class FormStruct {
        String acl;
        byte[] data;
        InputStream inputStream;
        String key;
        Policy policy;
        String srcPath;
        String successActionRedirect;
        String successActionStatus;
        String xCosStorageClass;
        Map<String, String> headers = new LinkedHashMap();
        Map<String, String> customHeaders = new LinkedHashMap();

        public FormStruct() {
        }

        public void checkParameters() throws CosXmlClientException {
            if (PostObjectRequest.this.formStruct.key == null) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "cosPath = null ");
            }
            if (this.srcPath == null && this.data == null && this.inputStream == null) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "data souce = null");
            }
            if (this.srcPath != null) {
                File file = new File(this.srcPath);
                if (!file.exists() || !file.isFile()) {
                    throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "srcPath is invalid");
                }
            }
        }

        public Map<String, String> getFormParameters() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = this.acl;
            if (str != null) {
                linkedHashMap.put("acl", str);
            }
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put("key", this.key);
            String str2 = this.successActionRedirect;
            if (str2 != null) {
                linkedHashMap.put("success_action_redirect", str2);
            }
            String str3 = this.successActionStatus;
            if (str3 != null) {
                linkedHashMap.put("success_action_status", str3);
            } else {
                linkedHashMap.put("success_action_status", "204");
            }
            for (Map.Entry<String, String> entry2 : this.customHeaders.entrySet()) {
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
            String str4 = this.xCosStorageClass;
            if (str4 != null) {
                linkedHashMap.put("x-cos-storage-class", str4);
            }
            Policy policy = this.policy;
            if (policy != null) {
                try {
                    linkedHashMap.put(bh.bt, DigestUtils.getBase64(policy.content()));
                } catch (CosXmlClientException e) {
                    return linkedHashMap;
                }
            }
            return linkedHashMap;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/PostObjectRequest$Policy.class */
    public static class Policy {
        private JSONArray conditions = new JSONArray();
        private String expiration;

        public void addConditions(String str, String str2, boolean z) throws CosXmlClientException {
            if (z) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("starts-with");
                jSONArray.put(str);
                jSONArray.put(str2);
                this.conditions.put(jSONArray);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, str2);
                this.conditions.put(jSONObject);
            } catch (JSONException e) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
            }
        }

        public void addContentConditions(int i, int i2) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("content-length-range");
            jSONArray.put(i);
            jSONArray.put(i2);
            this.conditions.put(jSONArray);
        }

        public String content() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.expiration != null) {
                    jSONObject.put("expiration", this.expiration);
                }
                jSONObject.put("conditions", this.conditions);
                return jSONObject.toString();
            } catch (JSONException e) {
                return null;
            }
        }

        public void setExpiration(long j) {
            this.expiration = DateUtils.getFormatTime("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", j);
        }

        public void setExpiration(String str) {
            this.expiration = str;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/PostObjectRequest$PostCosXmlSignSourceProvider.class */
    static class PostCosXmlSignSourceProvider extends COSXmlSignSourceProvider {
        private PostCosXmlSignSourceProvider() {
        }

        @Override // com.tencent.qcloud.core.auth.COSXmlSignSourceProvider, com.tencent.qcloud.core.auth.QCloudSignSourceProvider
        public <T> void onSignRequestSuccess(HttpRequest<T> httpRequest, QCloudCredentials qCloudCredentials, String str) {
            super.onSignRequestSuccess(httpRequest, qCloudCredentials, str);
            ((MultipartStreamRequestBody) httpRequest.getRequestBody()).setSign(str);
            httpRequest.removeHeader("Authorization");
        }
    }

    private PostObjectRequest(String str, String str2) {
        super(str, "/");
        FormStruct formStruct = new FormStruct();
        this.formStruct = formStruct;
        this.offset = 0L;
        this.contentLength = -1L;
        formStruct.key = str2;
    }

    public PostObjectRequest(String str, String str2, InputStream inputStream) {
        this(str, str2);
        this.formStruct.inputStream = inputStream;
    }

    public PostObjectRequest(String str, String str2, String str3) {
        this(str, str2);
        this.formStruct.srcPath = str3;
    }

    public PostObjectRequest(String str, String str2, byte[] bArr) {
        this(str, str2);
        this.formStruct.data = bArr;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        this.formStruct.checkParameters();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        MultipartStreamRequestBody multipartStreamRequestBody = new MultipartStreamRequestBody();
        multipartStreamRequestBody.setBodyParameters(this.formStruct.getFormParameters());
        if (this.formStruct.srcPath != null) {
            File file = new File(this.formStruct.srcPath);
            multipartStreamRequestBody.setContent((String) null, ContentResolver.SCHEME_FILE, file.getName(), file, this.offset, this.contentLength);
            return RequestBodySerializer.multiPart(multipartStreamRequestBody);
        } else if (this.formStruct.data != null) {
            multipartStreamRequestBody.setContent((String) null, ContentResolver.SCHEME_FILE, "data.txt", this.formStruct.data, this.offset, this.contentLength);
            return RequestBodySerializer.multiPart(multipartStreamRequestBody);
        } else if (this.formStruct.inputStream != null) {
            try {
                File file2 = new File(CosXmlSimpleService.appCachePath, String.valueOf(System.currentTimeMillis()));
                multipartStreamRequestBody.setContent(null, ContentResolver.SCHEME_FILE, file2.getName(), file2, this.formStruct.inputStream, this.offset, this.contentLength);
                return RequestBodySerializer.multiPart(multipartStreamRequestBody);
            } catch (IOException e) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public QCloudSignSourceProvider getSignSourceProvider() {
        if (this.signSourceProvider == null) {
            this.signSourceProvider = new PostCosXmlSignSourceProvider();
            ((COSXmlSignSourceProvider) this.signSourceProvider).setHeaderPairsForSign(QCloudHttpUtils.transformToMultiMap(this.formStruct.getFormParameters()));
        }
        return this.signSourceProvider;
    }

    public void setAcl(String str) {
        this.formStruct.acl = str;
    }

    public void setCacheControl(String str) {
        this.formStruct.headers.put("Cache-Control", str);
    }

    public void setContentDisposition(String str) {
        this.formStruct.headers.put("Content-Disposition", str);
    }

    public void setContentEncoding(String str) {
        this.formStruct.headers.put("Content-Encoding", str);
    }

    public void setContentType(String str) {
        this.formStruct.headers.put("Content-Type", str);
    }

    public void setCosStorageClass(String str) {
        this.formStruct.xCosStorageClass = str;
    }

    public void setCustomerHeader(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.formStruct.customHeaders.put(str, str2);
    }

    public void setExpires(String str) {
        this.formStruct.headers.put("Expires", str);
    }

    public void setHeader(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.formStruct.headers.put(str, str2);
    }

    public void setPolicy(Policy policy) {
        this.formStruct.policy = policy;
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public void setRange(long j, long j2) {
        this.offset = j;
        this.contentLength = j2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public void setSignParamsAndHeaders(Set<String> set, Set<String> set2) {
        PostCosXmlSignSourceProvider postCosXmlSignSourceProvider = new PostCosXmlSignSourceProvider();
        postCosXmlSignSourceProvider.parameters(set);
        postCosXmlSignSourceProvider.headers(set2);
        postCosXmlSignSourceProvider.setHeaderPairsForSign(QCloudHttpUtils.transformToMultiMap(this.formStruct.getFormParameters()));
        setSignSourceProvider(postCosXmlSignSourceProvider);
    }

    public void setStroageClass(COSStorageClass cOSStorageClass) {
        this.formStruct.headers.put("x-cos-storage-class", cOSStorageClass.getStorageClass());
    }

    public void setSuccessActionRedirect(String str) {
        this.formStruct.successActionRedirect = str;
    }

    public void setSuccessActionStatus(int i) {
        this.formStruct.successActionStatus = String.valueOf(i);
    }

    @Override // com.tencent.cos.xml.model.object.TransferRequest
    public void setTrafficLimit(long j) {
        addHeader(Headers.COS_TRAFFIC_LIMIT, String.valueOf(j));
    }

    Map<String, String> testFormParameters() throws CosXmlClientException {
        return this.formStruct.getFormParameters();
    }
}
