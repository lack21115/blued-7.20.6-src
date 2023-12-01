package com.mokee.volley;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/DefaultRetryPolicy.class */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;

    /* renamed from: a  reason: collision with root package name */
    private int f24231a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final float f24232c;
    private final int d;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.b = i;
        this.d = i2;
        this.f24232c = f;
    }

    @Override // com.mokee.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.f24231a;
    }

    @Override // com.mokee.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.b;
    }

    protected boolean hasAttemptRemaining() {
        return this.f24231a <= this.d;
    }

    @Override // com.mokee.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        try {
            this.f24231a++;
            this.b = (int) (this.b + (this.b * this.f24232c));
            if (hasAttemptRemaining()) {
                return;
            }
            throw volleyError;
        } catch (VolleyError e) {
            throw e;
        }
    }
}
