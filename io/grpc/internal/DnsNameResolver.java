package io.grpc.internal;

import android.net.ProxyInfo;
import android.security.KeyChain;
import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.uc.crashsdk.export.LogType;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver.class */
public class DnsNameResolver extends NameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    static final String SERVICE_CONFIG_PREFIX = "grpc_config=";
    private static String localHostname;
    private final String authority;
    private final long cacheTtlNanos;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    private final String host;
    private NameResolver.Listener2 listener;
    private final int port;
    final ProxyDetector proxyDetector;
    protected boolean resolved;
    private boolean resolving;
    private final NameResolver.ServiceConfigParser serviceConfigParser;
    private boolean shutdown;
    private final Stopwatch stopwatch;
    private final SynchronizationContext syncContext;
    private final boolean usingExecutorResource;
    private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY)));
    private static final String JNDI_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
    private static final String JNDI_LOCALHOST_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
    private static final String JNDI_TXT_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
    static boolean enableJndi = Boolean.parseBoolean(JNDI_PROPERTY);
    static boolean enableJndiLocalhost = Boolean.parseBoolean(JNDI_LOCALHOST_PROPERTY);
    protected static boolean enableTxt = Boolean.parseBoolean(JNDI_TXT_PROPERTY);
    private static final ResourceResolverFactory resourceResolverFactory = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    private final Random random = new Random();
    protected volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$AddressResolver.class */
    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$InternalResolutionResult.class */
    public static final class InternalResolutionResult {
        private List<EquivalentAddressGroup> addresses;
        public Attributes attributes;
        private NameResolver.ConfigOrError config;
        private Status error;

        private InternalResolutionResult() {
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$JdkAddressResolver.class */
    enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$Resolve.class */
    public final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            SynchronizationContext synchronizationContext;
            Runnable runnable;
            if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            InternalResolutionResult internalResolutionResult = null;
            boolean z = true;
            try {
                try {
                    EquivalentAddressGroup detectProxy = DnsNameResolver.this.detectProxy();
                    NameResolver.ResolutionResult.Builder newBuilder = NameResolver.ResolutionResult.newBuilder();
                    if (detectProxy != null) {
                        if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                            Logger logger = DnsNameResolver.logger;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Using proxy address ");
                            sb.append(detectProxy);
                            logger.finer(sb.toString());
                        }
                        newBuilder.setAddresses(Collections.singletonList(detectProxy));
                    } else {
                        InternalResolutionResult doResolve = DnsNameResolver.this.doResolve(false);
                        if (doResolve.error != null) {
                            this.savedListener.onError(doResolve.error);
                            if (doResolve == null || doResolve.error != null) {
                                z = false;
                            }
                            final boolean z2 = z;
                            DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (z2) {
                                        DnsNameResolver.this.resolved = true;
                                        if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                            DnsNameResolver.this.stopwatch.reset().start();
                                        }
                                    }
                                    DnsNameResolver.this.resolving = false;
                                }
                            });
                            return;
                        }
                        if (doResolve.addresses != null) {
                            newBuilder.setAddresses(doResolve.addresses);
                        }
                        if (doResolve.config != null) {
                            newBuilder.setServiceConfig(doResolve.config);
                        }
                        internalResolutionResult = doResolve;
                        if (doResolve.attributes != null) {
                            newBuilder.setAttributes(doResolve.attributes);
                            internalResolutionResult = doResolve;
                        }
                    }
                    this.savedListener.onResult(newBuilder.build());
                    boolean z3 = internalResolutionResult != null && internalResolutionResult.error == null;
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    final boolean z4 = z3;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z4) {
                                DnsNameResolver.this.resolved = true;
                                if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                } catch (IOException e) {
                    NameResolver.Listener2 listener2 = this.savedListener;
                    Status status = Status.UNAVAILABLE;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to resolve host ");
                    sb2.append(DnsNameResolver.this.host);
                    listener2.onError(status.withDescription(sb2.toString()).withCause(e));
                    boolean z5 = 0 != 0 && null.error == null;
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    final boolean z6 = z5;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z6) {
                                DnsNameResolver.this.resolved = true;
                                if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                }
                synchronizationContext.execute(runnable);
            } catch (Throwable th) {
                final boolean z7 = 0 != 0 && null.error == null;
                DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z7) {
                            DnsNameResolver.this.resolved = true;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        DnsNameResolver.this.resolving = false;
                    }
                });
                throw th;
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$ResourceResolver.class */
    public interface ResourceResolver {
        List<SrvRecord> resolveSrv(String str) throws Exception;

        List<String> resolveTxt(String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$ResourceResolverFactory.class */
    public interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolver$SrvRecord.class */
    public static final class SrvRecord {
        public final String host;
        public final int port;

        public SrvRecord(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SrvRecord srvRecord = (SrvRecord) obj;
            return this.port == srvRecord.port && this.host.equals(srvRecord.host);
        }

        public int hashCode() {
            return Objects.hashCode(this.host, Integer.valueOf(this.port));
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("host", this.host).add(KeyChain.EXTRA_PORT, this.port).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsNameResolver(@Nullable String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, Stopwatch stopwatch, boolean z) {
        Preconditions.checkNotNull(args, ProcessBridgeProvider.KEY_ARGS);
        this.executorResource = resource;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, "name")));
        Preconditions.checkArgument(create.getHost() != null, "Invalid DNS name: %s", str2);
        this.authority = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.host = create.getHost();
        if (create.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = create.getPort();
        }
        this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
        Executor offloadExecutor = args.getOffloadExecutor();
        this.executor = offloadExecutor;
        this.usingExecutorResource = offloadExecutor == null;
        this.serviceConfigParser = (NameResolver.ServiceConfigParser) Preconditions.checkNotNull(args.getServiceConfigParser(), "serviceConfigParser");
    }

    private boolean cacheRefreshRequired() {
        if (this.resolved) {
            long j = this.cacheTtlNanos;
            if (j != 0) {
                return j > 0 && this.stopwatch.elapsed(TimeUnit.NANOSECONDS) > this.cacheTtlNanos;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public EquivalentAddressGroup detectProxy() throws IOException {
        ProxiedSocketAddress proxyFor = this.proxyDetector.proxyFor(InetSocketAddress.createUnresolved(this.host, this.port));
        if (proxyFor != null) {
            return new EquivalentAddressGroup(proxyFor);
        }
        return null;
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return localHostname;
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z) {
        if (z) {
            return 0L;
        }
        String property = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long j = 30;
        if (property != null) {
            try {
                j = Long.parseLong(property);
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, property, Long.valueOf((long) DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
                j = 30;
            }
        }
        long j2 = j;
        if (j > 0) {
            j2 = TimeUnit.SECONDS.toNanos(j);
        }
        return j2;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        return JsonUtil.getNumber(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    @Nullable
    static ResourceResolverFactory getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    ResourceResolverFactory resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (resourceResolverFactory2.unavailabilityCause() != null) {
                        logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", resourceResolverFactory2.unavailabilityCause());
                        return null;
                    }
                    return resourceResolverFactory2;
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                    return null;
                }
            } catch (Exception e2) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e2);
                return null;
            }
        } catch (ClassCastException e3) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e3);
            return null;
        } catch (ClassNotFoundException e4) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e4);
            return null;
        }
    }

    @Nullable
    static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> map, Random random, String str) {
        boolean z;
        boolean z2;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Verify.verify(SERVICE_CONFIG_CHOICE_KEYS.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguagesFromChoice = getClientLanguagesFromChoice(map);
        if (clientLanguagesFromChoice != null && !clientLanguagesFromChoice.isEmpty()) {
            Iterator<String> it = clientLanguagesFromChoice.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (LogType.JAVA_TYPE.equalsIgnoreCase(it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                return null;
            }
        }
        Double percentageFromChoice = getPercentageFromChoice(map);
        if (percentageFromChoice != null) {
            int intValue = percentageFromChoice.intValue();
            Verify.verify(intValue >= 0 && intValue <= 100, "Bad percentage: %s", percentageFromChoice);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> hostnamesFromChoice = getHostnamesFromChoice(map);
        if (hostnamesFromChoice != null && !hostnamesFromChoice.isEmpty()) {
            Iterator<String> it2 = hostnamesFromChoice.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return null;
            }
        }
        Map<String, ?> object = JsonUtil.getObject(map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (object != null) {
            return object;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY));
    }

    @Nullable
    static NameResolver.ConfigOrError parseServiceConfig(List<String> list, Random random, String str) {
        try {
            Iterator<Map<String, ?>> it = parseTxtResults(list).iterator();
            Map<String, ?> map = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    Map<String, ?> maybeChooseServiceConfig = maybeChooseServiceConfig(it.next(), random, str);
                    map = maybeChooseServiceConfig;
                    if (maybeChooseServiceConfig != null) {
                        map = maybeChooseServiceConfig;
                        break;
                    }
                } catch (RuntimeException e) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e));
                }
            }
            if (map == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(map);
        } catch (IOException | RuntimeException e2) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e2));
        }
    }

    static List<Map<String, ?>> parseTxtResults(List<String> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith(SERVICE_CONFIG_PREFIX)) {
                Object parse = JsonParser.parse(str.substring(12));
                if (!(parse instanceof List)) {
                    throw new ClassCastException("wrong type " + parse);
                }
                arrayList.addAll(JsonUtil.checkObjectList((List) parse));
            } else {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    private void resolve() {
        if (this.resolving || this.shutdown || !cacheRefreshRequired()) {
            return;
        }
        this.resolving = true;
        this.executor.execute(new Resolve(this.listener));
    }

    private List<EquivalentAddressGroup> resolveAddresses() {
        Exception exc = null;
        try {
            try {
                List<InetAddress> resolveAddress = this.addressResolver.resolveAddress(this.host);
                ArrayList arrayList = new ArrayList(resolveAddress.size());
                for (InetAddress inetAddress : resolveAddress) {
                    arrayList.add(new EquivalentAddressGroup(new InetSocketAddress(inetAddress, this.port)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e) {
                Throwables.throwIfUnchecked(e);
                exc = e;
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (exc != null) {
                logger.log(Level.FINE, "Address resolution failure", (Throwable) exc);
            }
            throw th;
        }
    }

    @Nullable
    private NameResolver.ConfigOrError resolveServiceConfig() {
        List<String> emptyList = Collections.emptyList();
        ResourceResolver resourceResolver = getResourceResolver();
        List<String> list = emptyList;
        if (resourceResolver != null) {
            try {
                list = resourceResolver.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + this.host);
            } catch (Exception e) {
                logger.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e);
                list = emptyList;
            }
        }
        if (list.isEmpty()) {
            logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.host});
            return null;
        }
        NameResolver.ConfigOrError parseServiceConfig = parseServiceConfig(list, this.random, getLocalHostname());
        if (parseServiceConfig != null) {
            return parseServiceConfig.getError() != null ? NameResolver.ConfigOrError.fromError(parseServiceConfig.getError()) : this.serviceConfigParser.parseServiceConfig((Map) parseServiceConfig.getConfig());
        }
        return null;
    }

    protected static boolean shouldUseJndi(boolean z, boolean z2, String str) {
        if (!z) {
            return false;
        }
        if (ProxyInfo.LOCAL_HOST.equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        int i = 0;
        boolean z3 = true;
        while (true) {
            boolean z4 = z3;
            if (i >= str.length()) {
                return true ^ z4;
            }
            char charAt = str.charAt(i);
            boolean z5 = z4;
            if (charAt != '.') {
                z5 = z4 & (charAt >= '0' && charAt <= '9');
            }
            i++;
            z3 = z5;
        }
    }

    protected InternalResolutionResult doResolve(boolean z) {
        InternalResolutionResult internalResolutionResult = new InternalResolutionResult();
        try {
            internalResolutionResult.addresses = resolveAddresses();
        } catch (Exception e) {
            if (!z) {
                Status status = Status.UNAVAILABLE;
                internalResolutionResult.error = status.withDescription("Unable to resolve host " + this.host).withCause(e);
                return internalResolutionResult;
            }
        }
        if (enableTxt) {
            internalResolutionResult.config = resolveServiceConfig();
        }
        return internalResolutionResult;
    }

    protected String getHost() {
        return this.host;
    }

    final int getPort() {
        return this.port;
    }

    @Nullable
    protected ResourceResolver getResourceResolver() {
        if (shouldUseJndi(enableJndi, enableJndiLocalhost, this.host)) {
            ResourceResolver resourceResolver = this.resourceResolver.get();
            ResourceResolver resourceResolver2 = resourceResolver;
            if (resourceResolver == null) {
                ResourceResolverFactory resourceResolverFactory2 = resourceResolverFactory;
                resourceResolver2 = resourceResolver;
                if (resourceResolverFactory2 != null) {
                    resourceResolver2 = resourceResolverFactory2.newResourceResolver();
                }
            }
            return resourceResolver2;
        }
        return null;
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    protected void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
    }

    protected void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver.set(resourceResolver);
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        Executor executor = this.executor;
        if (executor == null || !this.usingExecutorResource) {
            return;
        }
        this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor);
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        if (this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        }
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "listener");
        resolve();
    }
}
