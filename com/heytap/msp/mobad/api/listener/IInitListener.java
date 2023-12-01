package com.heytap.msp.mobad.api.listener;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/IInitListener.class */
public interface IInitListener {
    public static final IInitListener NONE = new IInitListener() { // from class: com.heytap.msp.mobad.api.listener.IInitListener.1
        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onFailed(String str) {
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onSuccess() {
        }
    };

    void onFailed(String str);

    void onSuccess();
}
