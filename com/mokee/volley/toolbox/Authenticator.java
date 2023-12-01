package com.mokee.volley.toolbox;

import com.mokee.volley.AuthFailureError;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/Authenticator.class */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
