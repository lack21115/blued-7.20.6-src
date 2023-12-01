package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/AuthenticationOrBuilder.class */
public interface AuthenticationOrBuilder extends MessageOrBuilder {
    AuthProvider getProviders(int i);

    int getProvidersCount();

    List<AuthProvider> getProvidersList();

    AuthProviderOrBuilder getProvidersOrBuilder(int i);

    List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList();

    AuthenticationRule getRules(int i);

    int getRulesCount();

    List<AuthenticationRule> getRulesList();

    AuthenticationRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList();
}
