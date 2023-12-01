package com.igexin.assist;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/MessageBean.class */
public class MessageBean {

    /* renamed from: a  reason: collision with root package name */
    private String f9566a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Object f9567c;
    private Context d;
    public final Bundle extra = new Bundle();

    public MessageBean(Context context, String str, Object obj) {
        this.b = str;
        this.f9567c = obj;
        this.d = context;
    }

    public Context getContext() {
        return this.d;
    }

    public Object getMessage() {
        return this.f9567c;
    }

    public String getMessageSource() {
        return this.f9566a;
    }

    public String getMessageType() {
        return this.b;
    }

    public Object getObjectMessage() {
        return this.f9567c;
    }

    public String getStringMessage() {
        Object obj = this.f9567c;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void setMessageSource(String str) {
        this.f9566a = str;
    }
}
