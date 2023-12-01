package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/support/jaxrs/FastJsonProvider.class */
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
    private Class<?>[] clazzes;
    public Feature[] features;
    public ParserConfig parserConfig;
    public SerializeConfig serializeConfig;
    public Map<Class<?>, SerializeFilter> serializeFilters;
    public SerializerFeature[] serializerFeatures;
    @Context
    UriInfo uriInfo;

    public FastJsonProvider() {
        this.clazzes = null;
        this.serializeConfig = SerializeConfig.getGlobalInstance();
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.serializerFeatures = new SerializerFeature[0];
        this.features = new Feature[0];
    }

    public FastJsonProvider(Class<?>[] clsArr) {
        this.clazzes = null;
        this.serializeConfig = SerializeConfig.getGlobalInstance();
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.serializerFeatures = new SerializerFeature[0];
        this.features = new Feature[0];
        this.clazzes = clsArr;
    }

    public long getSize(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        return -1L;
    }

    protected boolean hasMatchingMediaType(MediaType mediaType) {
        boolean z = true;
        if (mediaType != null) {
            String subtype = mediaType.getSubtype();
            z = true;
            if (!"json".equalsIgnoreCase(subtype)) {
                z = true;
                if (!subtype.endsWith("+json")) {
                    z = true;
                    if (!"javascript".equals(subtype)) {
                        if ("x-javascript".equals(subtype)) {
                            return true;
                        }
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public boolean isReadable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (hasMatchingMediaType(mediaType)) {
            return isValidType(cls, annotationArr);
        }
        return false;
    }

    protected boolean isValidType(Class<?> cls, Annotation[] annotationArr) {
        if (cls == null) {
            return false;
        }
        Class<?>[] clsArr = this.clazzes;
        if (clsArr == null) {
            return true;
        }
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (clsArr[i2] == cls) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (hasMatchingMediaType(mediaType)) {
            return isValidType(cls, annotationArr);
        }
        return false;
    }

    public Object readFrom(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        String str;
        try {
            str = IOUtils.toString(inputStream);
        } catch (Exception e) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return JSON.parseObject(str, cls, this.parserConfig, JSON.DEFAULT_PARSER_FEATURE, this.features);
    }

    public void writeTo(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        SerializerFeature[] serializerFeatureArr = this.serializerFeatures;
        UriInfo uriInfo = this.uriInfo;
        SerializerFeature[] serializerFeatureArr2 = serializerFeatureArr;
        if (uriInfo != null) {
            serializerFeatureArr2 = serializerFeatureArr;
            if (uriInfo.getQueryParameters().containsKey("pretty")) {
                if (serializerFeatureArr == null) {
                    serializerFeatureArr2 = new SerializerFeature[]{SerializerFeature.PrettyFormat};
                } else {
                    List asList = Arrays.asList(serializerFeatureArr);
                    asList.add(SerializerFeature.PrettyFormat);
                    serializerFeatureArr2 = (SerializerFeature[]) asList.toArray(serializerFeatureArr);
                }
            }
        }
        Map<Class<?>, SerializeFilter> map = this.serializeFilters;
        String jSONString = JSON.toJSONString(obj, map != null ? map.get(cls) : null, serializerFeatureArr2);
        if (jSONString != null) {
            outputStream.write(jSONString.getBytes());
        }
    }
}
