package com.google.api;

import com.google.api.Billing;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/BillingOrBuilder.class */
public interface BillingOrBuilder extends MessageOrBuilder {
    Billing.BillingDestination getConsumerDestinations(int i);

    int getConsumerDestinationsCount();

    List<Billing.BillingDestination> getConsumerDestinationsList();

    Billing.BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i);

    List<? extends Billing.BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList();
}
