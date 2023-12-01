package com.squareup.wire;

import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/KotlinConstructorBuilderKt.class */
public final class KotlinConstructorBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMap(WireField wireField) {
        return wireField.keyAdapter().length() > 0;
    }
}
