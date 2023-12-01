package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/support/spring/FastJsonJsonView.class */
public class FastJsonJsonView extends AbstractView {
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Set<String> renderedAttributes;
    private Charset charset = UTF8;
    private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
    private boolean disableCaching = true;
    private boolean updateContentLength = false;
    private boolean extractValueFromSingleKeyModel = false;

    public FastJsonJsonView() {
        setContentType("application/json");
        setExposePathVariables(false);
    }

    protected Object filterModel(Map<String, Object> map) {
        HashMap hashMap = new HashMap(map.size());
        Set<String> keySet = !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : map.keySet();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!(entry.getValue() instanceof BindingResult) && keySet.contains(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.extractValueFromSingleKeyModel && hashMap.size() == 1) {
            Iterator it = hashMap.entrySet().iterator();
            if (it.hasNext()) {
                return ((Map.Entry) it.next()).getValue();
            }
        }
        return hashMap;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public SerializerFeature[] getFeatures() {
        return this.serializerFeatures;
    }

    public boolean isExtractValueFromSingleKeyModel() {
        return this.extractValueFromSingleKeyModel;
    }

    protected void prepareResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        setResponseContentType(httpServletRequest, httpServletResponse);
        httpServletResponse.setCharacterEncoding(UTF8.name());
        if (this.disableCaching) {
            httpServletResponse.addHeader(HttpHeaders.PRAGMA, "no-cache");
            httpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
            httpServletResponse.addDateHeader("Expires", 1L);
        }
    }

    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] bytes = JSON.toJSONString(filterModel(map), this.serializerFeatures).getBytes(this.charset);
        ByteArrayOutputStream createTemporaryOutputStream = this.updateContentLength ? createTemporaryOutputStream() : httpServletResponse.getOutputStream();
        createTemporaryOutputStream.write(bytes);
        if (this.updateContentLength) {
            writeToResponse(httpServletResponse, createTemporaryOutputStream);
        }
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setDisableCaching(boolean z) {
        this.disableCaching = z;
    }

    public void setExtractValueFromSingleKeyModel(boolean z) {
        this.extractValueFromSingleKeyModel = z;
    }

    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
    }

    public void setRenderedAttributes(Set<String> set) {
        this.renderedAttributes = set;
    }

    @Deprecated
    public void setSerializerFeature(SerializerFeature... serializerFeatureArr) {
        setFeatures(serializerFeatureArr);
    }

    public void setUpdateContentLength(boolean z) {
        this.updateContentLength = z;
    }
}
