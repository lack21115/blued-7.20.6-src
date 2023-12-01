package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/SelectObjectContentEventException.class */
public class SelectObjectContentEventException extends Exception {
    private String errorCode;
    private String errorMessage;

    public SelectObjectContentEventException(String str) {
        super(str);
    }

    public SelectObjectContentEventException(String str, Exception exc) {
        super(str, exc);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
