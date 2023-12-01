package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter.class */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Charset charset;
    protected String dateFormat;
    private SerializerFeature[] features;
    protected SerializeFilter[] serialzeFilters;

    public FastJsonHttpMessageConverter() {
        super(new MediaType[]{new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8)});
        this.charset = UTF8;
        this.features = new SerializerFeature[0];
        this.serialzeFilters = new SerializeFilter[0];
    }

    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        SerializeFilter[] serializeFilterArr = this.serialzeFilters;
        int length = serializeFilterArr.length + 1;
        SerializeFilter[] serializeFilterArr2 = new SerializeFilter[length];
        System.arraycopy(serializeFilterArr, 0, serializeFilter, 0, serializeFilterArr.length);
        serializeFilterArr2[length - 1] = serializeFilter;
        this.serialzeFilters = serializeFilterArr2;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public SerializerFeature[] getFeatures() {
        return this.features;
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream body = httpInputMessage.getBody();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = body.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return JSON.parseObject(byteArray, 0, byteArray.length, this.charset.newDecoder(), cls, new Feature[0]);
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.features = serializerFeatureArr;
    }

    protected boolean supports(Class<?> cls) {
        return true;
    }

    protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = httpOutputMessage.getHeaders();
        byte[] bytes = JSON.toJSONString(obj, SerializeConfig.globalInstance, this.serialzeFilters, this.dateFormat, JSON.DEFAULT_GENERATE_FEATURE, this.features).getBytes(this.charset);
        headers.setContentLength(bytes.length);
        httpOutputMessage.getBody().write(bytes);
    }
}
