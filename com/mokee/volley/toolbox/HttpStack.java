package com.mokee.volley.toolbox;

import com.mokee.volley.AuthFailureError;
import com.mokee.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/HttpStack.class */
public interface HttpStack {
    HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
