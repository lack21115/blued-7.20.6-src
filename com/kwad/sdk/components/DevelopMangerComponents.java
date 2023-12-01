package com.kwad.sdk.components;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/components/DevelopMangerComponents.class */
public interface DevelopMangerComponents extends a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/components/DevelopMangerComponents$DevelopValue.class */
    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public <T> T getValue() {
            T t = (T) this.mValue;
            if (t != null) {
                return t;
            }
            return null;
        }
    }

    String tO();
}
