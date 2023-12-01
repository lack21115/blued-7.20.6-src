package android.telecom;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/Response.class */
public interface Response<IN, OUT> {
    void onError(IN in2, int i, String str);

    void onResult(IN in2, OUT... outArr);
}
