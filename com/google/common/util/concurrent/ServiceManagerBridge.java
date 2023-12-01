package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.util.concurrent.Service;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/ServiceManagerBridge.class */
interface ServiceManagerBridge {
    ImmutableMultimap<Service.State, Service> servicesByState();
}
