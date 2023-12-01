package com.mokee.volley;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/DefaultRetryPolicy.class */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private int a;
    private int b;
    private final float c;
    private final int d;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.b = i;
        this.d = i2;
        this.c = f;
    }

    @Override // com.mokee.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.a;
    }

    @Override // com.mokee.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.b;
    }

    protected boolean hasAttemptRemaining() {
        return this.a <= this.d;
    }

    @Override // com.mokee.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        try {
            this.a++;
            this.b = (int) (this.b + (this.b * this.c));
            if (hasAttemptRemaining()) {
                return;
            }
            throw volleyError;
        } catch (VolleyError e) {
            throw e;
        }
    }
}
