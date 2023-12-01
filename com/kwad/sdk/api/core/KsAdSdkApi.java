package com.kwad.sdk.api.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@KsAdSdkDynamicApi
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/KsAdSdkApi.class */
public @interface KsAdSdkApi {
}
