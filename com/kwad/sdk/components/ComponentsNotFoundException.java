package com.kwad.sdk.components;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/components/ComponentsNotFoundException.class */
public class ComponentsNotFoundException extends IllegalStateException {
    private static final String MESSAGE = "组件未集成/未加载，如需要该部分的功能，请集成后重试";
    private static final long serialVersionUID = -2648461538415997941L;

    public ComponentsNotFoundException(String str) {
        this(str, null);
    }

    public ComponentsNotFoundException(String str, Throwable th) {
        super(str + MESSAGE, th);
    }
}
