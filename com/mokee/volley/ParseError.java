package com.mokee.volley;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/ParseError.class */
public class ParseError extends VolleyError {
    public ParseError() {
    }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable th) {
        super(th);
    }
}
