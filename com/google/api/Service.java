package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/Service.class */
public final class Service extends GeneratedMessageV3 implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private static final long serialVersionUID = 0;
    private List<Api> apis_;
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private int bitField0_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private List<Endpoint> endpoints_;
    private List<Enum> enums_;
    private Http http_;
    private volatile Object id_;
    private Logging logging_;
    private List<LogDescriptor> logs_;
    private byte memoizedIsInitialized;
    private List<MetricDescriptor> metrics_;
    private List<MonitoredResourceDescriptor> monitoredResources_;
    private Monitoring monitoring_;
    private volatile Object name_;
    private volatile Object producerProjectId_;
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private volatile Object title_;
    private List<Type> types_;
    private Usage usage_;
    private static final Service DEFAULT_INSTANCE = new Service();
    private static final Parser<Service> PARSER = new AbstractParser<Service>() { // from class: com.google.api.Service.1
        @Override // com.google.protobuf.Parser
        public Service parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Service(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/Service$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServiceOrBuilder {
        private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> apisBuilder_;
        private List<Api> apis_;
        private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> authenticationBuilder_;
        private Authentication authentication_;
        private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> backendBuilder_;
        private Backend backend_;
        private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> billingBuilder_;
        private Billing billing_;
        private int bitField0_;
        private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> configVersionBuilder_;
        private UInt32Value configVersion_;
        private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> contextBuilder_;
        private Context context_;
        private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> controlBuilder_;
        private Control control_;
        private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> documentationBuilder_;
        private Documentation documentation_;
        private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> endpointsBuilder_;
        private List<Endpoint> endpoints_;
        private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> enumsBuilder_;
        private List<Enum> enums_;
        private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> httpBuilder_;
        private Http http_;
        private Object id_;
        private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> loggingBuilder_;
        private Logging logging_;
        private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> logsBuilder_;
        private List<LogDescriptor> logs_;
        private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> metricsBuilder_;
        private List<MetricDescriptor> metrics_;
        private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> monitoredResourcesBuilder_;
        private List<MonitoredResourceDescriptor> monitoredResources_;
        private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> monitoringBuilder_;
        private Monitoring monitoring_;
        private Object name_;
        private Object producerProjectId_;
        private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> quotaBuilder_;
        private Quota quota_;
        private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> sourceInfoBuilder_;
        private SourceInfo sourceInfo_;
        private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> systemParametersBuilder_;
        private SystemParameters systemParameters_;
        private Object title_;
        private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> typesBuilder_;
        private List<Type> types_;
        private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> usageBuilder_;
        private Usage usage_;

        private Builder() {
            this.name_ = "";
            this.id_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            this.apis_ = Collections.emptyList();
            this.types_ = Collections.emptyList();
            this.enums_ = Collections.emptyList();
            this.endpoints_ = Collections.emptyList();
            this.logs_ = Collections.emptyList();
            this.metrics_ = Collections.emptyList();
            this.monitoredResources_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.id_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            this.apis_ = Collections.emptyList();
            this.types_ = Collections.emptyList();
            this.enums_ = Collections.emptyList();
            this.endpoints_ = Collections.emptyList();
            this.logs_ = Collections.emptyList();
            this.metrics_ = Collections.emptyList();
            this.monitoredResources_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureApisIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.apis_ = new ArrayList(this.apis_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureEndpointsIsMutable() {
            if ((this.bitField0_ & 32768) == 0) {
                this.endpoints_ = new ArrayList(this.endpoints_);
                this.bitField0_ |= 32768;
            }
        }

        private void ensureEnumsIsMutable() {
            if ((this.bitField0_ & 128) == 0) {
                this.enums_ = new ArrayList(this.enums_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureLogsIsMutable() {
            if ((this.bitField0_ & 131072) == 0) {
                this.logs_ = new ArrayList(this.logs_);
                this.bitField0_ |= 131072;
            }
        }

        private void ensureMetricsIsMutable() {
            if ((this.bitField0_ & 262144) == 0) {
                this.metrics_ = new ArrayList(this.metrics_);
                this.bitField0_ |= 262144;
            }
        }

        private void ensureMonitoredResourcesIsMutable() {
            if ((this.bitField0_ & 524288) == 0) {
                this.monitoredResources_ = new ArrayList(this.monitoredResources_);
                this.bitField0_ |= 524288;
            }
        }

        private void ensureTypesIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.types_ = new ArrayList(this.types_);
                this.bitField0_ |= 64;
            }
        }

        private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> getApisFieldBuilder() {
            if (this.apisBuilder_ == null) {
                this.apisBuilder_ = new RepeatedFieldBuilderV3<>(this.apis_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.apis_ = null;
            }
            return this.apisBuilder_;
        }

        private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> getAuthenticationFieldBuilder() {
            if (this.authenticationBuilder_ == null) {
                this.authenticationBuilder_ = new SingleFieldBuilderV3<>(getAuthentication(), getParentForChildren(), isClean());
                this.authentication_ = null;
            }
            return this.authenticationBuilder_;
        }

        private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> getBackendFieldBuilder() {
            if (this.backendBuilder_ == null) {
                this.backendBuilder_ = new SingleFieldBuilderV3<>(getBackend(), getParentForChildren(), isClean());
                this.backend_ = null;
            }
            return this.backendBuilder_;
        }

        private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> getBillingFieldBuilder() {
            if (this.billingBuilder_ == null) {
                this.billingBuilder_ = new SingleFieldBuilderV3<>(getBilling(), getParentForChildren(), isClean());
                this.billing_ = null;
            }
            return this.billingBuilder_;
        }

        private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> getConfigVersionFieldBuilder() {
            if (this.configVersionBuilder_ == null) {
                this.configVersionBuilder_ = new SingleFieldBuilderV3<>(getConfigVersion(), getParentForChildren(), isClean());
                this.configVersion_ = null;
            }
            return this.configVersionBuilder_;
        }

        private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> getContextFieldBuilder() {
            if (this.contextBuilder_ == null) {
                this.contextBuilder_ = new SingleFieldBuilderV3<>(getContext(), getParentForChildren(), isClean());
                this.context_ = null;
            }
            return this.contextBuilder_;
        }

        private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> getControlFieldBuilder() {
            if (this.controlBuilder_ == null) {
                this.controlBuilder_ = new SingleFieldBuilderV3<>(getControl(), getParentForChildren(), isClean());
                this.control_ = null;
            }
            return this.controlBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ServiceProto.internal_static_google_api_Service_descriptor;
        }

        private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> getDocumentationFieldBuilder() {
            if (this.documentationBuilder_ == null) {
                this.documentationBuilder_ = new SingleFieldBuilderV3<>(getDocumentation(), getParentForChildren(), isClean());
                this.documentation_ = null;
            }
            return this.documentationBuilder_;
        }

        private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> getEndpointsFieldBuilder() {
            if (this.endpointsBuilder_ == null) {
                this.endpointsBuilder_ = new RepeatedFieldBuilderV3<>(this.endpoints_, (this.bitField0_ & 32768) != 0, getParentForChildren(), isClean());
                this.endpoints_ = null;
            }
            return this.endpointsBuilder_;
        }

        private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> getEnumsFieldBuilder() {
            if (this.enumsBuilder_ == null) {
                this.enumsBuilder_ = new RepeatedFieldBuilderV3<>(this.enums_, (this.bitField0_ & 128) != 0, getParentForChildren(), isClean());
                this.enums_ = null;
            }
            return this.enumsBuilder_;
        }

        private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> getHttpFieldBuilder() {
            if (this.httpBuilder_ == null) {
                this.httpBuilder_ = new SingleFieldBuilderV3<>(getHttp(), getParentForChildren(), isClean());
                this.http_ = null;
            }
            return this.httpBuilder_;
        }

        private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> getLoggingFieldBuilder() {
            if (this.loggingBuilder_ == null) {
                this.loggingBuilder_ = new SingleFieldBuilderV3<>(getLogging(), getParentForChildren(), isClean());
                this.logging_ = null;
            }
            return this.loggingBuilder_;
        }

        private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> getLogsFieldBuilder() {
            if (this.logsBuilder_ == null) {
                this.logsBuilder_ = new RepeatedFieldBuilderV3<>(this.logs_, (this.bitField0_ & 131072) != 0, getParentForChildren(), isClean());
                this.logs_ = null;
            }
            return this.logsBuilder_;
        }

        private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> getMetricsFieldBuilder() {
            if (this.metricsBuilder_ == null) {
                this.metricsBuilder_ = new RepeatedFieldBuilderV3<>(this.metrics_, (this.bitField0_ & 262144) != 0, getParentForChildren(), isClean());
                this.metrics_ = null;
            }
            return this.metricsBuilder_;
        }

        private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesFieldBuilder() {
            if (this.monitoredResourcesBuilder_ == null) {
                this.monitoredResourcesBuilder_ = new RepeatedFieldBuilderV3<>(this.monitoredResources_, (this.bitField0_ & 524288) != 0, getParentForChildren(), isClean());
                this.monitoredResources_ = null;
            }
            return this.monitoredResourcesBuilder_;
        }

        private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> getMonitoringFieldBuilder() {
            if (this.monitoringBuilder_ == null) {
                this.monitoringBuilder_ = new SingleFieldBuilderV3<>(getMonitoring(), getParentForChildren(), isClean());
                this.monitoring_ = null;
            }
            return this.monitoringBuilder_;
        }

        private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> getQuotaFieldBuilder() {
            if (this.quotaBuilder_ == null) {
                this.quotaBuilder_ = new SingleFieldBuilderV3<>(getQuota(), getParentForChildren(), isClean());
                this.quota_ = null;
            }
            return this.quotaBuilder_;
        }

        private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> getSourceInfoFieldBuilder() {
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfoBuilder_ = new SingleFieldBuilderV3<>(getSourceInfo(), getParentForChildren(), isClean());
                this.sourceInfo_ = null;
            }
            return this.sourceInfoBuilder_;
        }

        private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> getSystemParametersFieldBuilder() {
            if (this.systemParametersBuilder_ == null) {
                this.systemParametersBuilder_ = new SingleFieldBuilderV3<>(getSystemParameters(), getParentForChildren(), isClean());
                this.systemParameters_ = null;
            }
            return this.systemParametersBuilder_;
        }

        private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> getTypesFieldBuilder() {
            if (this.typesBuilder_ == null) {
                this.typesBuilder_ = new RepeatedFieldBuilderV3<>(this.types_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.types_ = null;
            }
            return this.typesBuilder_;
        }

        private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> getUsageFieldBuilder() {
            if (this.usageBuilder_ == null) {
                this.usageBuilder_ = new SingleFieldBuilderV3<>(getUsage(), getParentForChildren(), isClean());
                this.usage_ = null;
            }
            return this.usageBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (Service.alwaysUseFieldBuilders) {
                getApisFieldBuilder();
                getTypesFieldBuilder();
                getEnumsFieldBuilder();
                getEndpointsFieldBuilder();
                getLogsFieldBuilder();
                getMetricsFieldBuilder();
                getMonitoredResourcesFieldBuilder();
            }
        }

        public Builder addAllApis(Iterable<? extends Api> iterable) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureApisIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.apis_);
            onChanged();
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureEndpointsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.endpoints_);
            onChanged();
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> iterable) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureEnumsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.enums_);
            onChanged();
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureLogsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.logs_);
            onChanged();
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureMetricsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metrics_);
            onChanged();
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureMonitoredResourcesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.monitoredResources_);
            onChanged();
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> iterable) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureTypesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.types_);
            onChanged();
            return this;
        }

        public Builder addApis(int i, Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureApisIsMutable();
            this.apis_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addApis(int i, Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, api);
                return this;
            } else if (api != null) {
                ensureApisIsMutable();
                this.apis_.add(i, api);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addApis(Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureApisIsMutable();
            this.apis_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addApis(Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(api);
                return this;
            } else if (api != null) {
                ensureApisIsMutable();
                this.apis_.add(api);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Api.Builder addApisBuilder() {
            return getApisFieldBuilder().addBuilder(Api.getDefaultInstance());
        }

        public Api.Builder addApisBuilder(int i) {
            return getApisFieldBuilder().addBuilder(i, Api.getDefaultInstance());
        }

        public Builder addEndpoints(int i, Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureEndpointsIsMutable();
            this.endpoints_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addEndpoints(int i, Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, endpoint);
                return this;
            } else if (endpoint != null) {
                ensureEndpointsIsMutable();
                this.endpoints_.add(i, endpoint);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addEndpoints(Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureEndpointsIsMutable();
            this.endpoints_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addEndpoints(Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(endpoint);
                return this;
            } else if (endpoint != null) {
                ensureEndpointsIsMutable();
                this.endpoints_.add(endpoint);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Endpoint.Builder addEndpointsBuilder() {
            return getEndpointsFieldBuilder().addBuilder(Endpoint.getDefaultInstance());
        }

        public Endpoint.Builder addEndpointsBuilder(int i) {
            return getEndpointsFieldBuilder().addBuilder(i, Endpoint.getDefaultInstance());
        }

        public Builder addEnums(int i, Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureEnumsIsMutable();
            this.enums_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addEnums(int i, Enum r6) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, r6);
                return this;
            } else if (r6 != null) {
                ensureEnumsIsMutable();
                this.enums_.add(i, r6);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addEnums(Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureEnumsIsMutable();
            this.enums_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addEnums(Enum r4) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(r4);
                return this;
            } else if (r4 != null) {
                ensureEnumsIsMutable();
                this.enums_.add(r4);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Enum.Builder addEnumsBuilder() {
            return getEnumsFieldBuilder().addBuilder(Enum.getDefaultInstance());
        }

        public Enum.Builder addEnumsBuilder(int i) {
            return getEnumsFieldBuilder().addBuilder(i, Enum.getDefaultInstance());
        }

        public Builder addLogs(int i, LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureLogsIsMutable();
            this.logs_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addLogs(int i, LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, logDescriptor);
                return this;
            } else if (logDescriptor != null) {
                ensureLogsIsMutable();
                this.logs_.add(i, logDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addLogs(LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureLogsIsMutable();
            this.logs_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addLogs(LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(logDescriptor);
                return this;
            } else if (logDescriptor != null) {
                ensureLogsIsMutable();
                this.logs_.add(logDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public LogDescriptor.Builder addLogsBuilder() {
            return getLogsFieldBuilder().addBuilder(LogDescriptor.getDefaultInstance());
        }

        public LogDescriptor.Builder addLogsBuilder(int i) {
            return getLogsFieldBuilder().addBuilder(i, LogDescriptor.getDefaultInstance());
        }

        public Builder addMetrics(int i, MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureMetricsIsMutable();
            this.metrics_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addMetrics(int i, MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, metricDescriptor);
                return this;
            } else if (metricDescriptor != null) {
                ensureMetricsIsMutable();
                this.metrics_.add(i, metricDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addMetrics(MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureMetricsIsMutable();
            this.metrics_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addMetrics(MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(metricDescriptor);
                return this;
            } else if (metricDescriptor != null) {
                ensureMetricsIsMutable();
                this.metrics_.add(metricDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public MetricDescriptor.Builder addMetricsBuilder() {
            return getMetricsFieldBuilder().addBuilder(MetricDescriptor.getDefaultInstance());
        }

        public MetricDescriptor.Builder addMetricsBuilder(int i) {
            return getMetricsFieldBuilder().addBuilder(i, MetricDescriptor.getDefaultInstance());
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, monitoredResourceDescriptor);
                return this;
            } else if (monitoredResourceDescriptor != null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(i, monitoredResourceDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(monitoredResourceDescriptor);
                return this;
            } else if (monitoredResourceDescriptor != null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.add(monitoredResourceDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder() {
            return getMonitoredResourcesFieldBuilder().addBuilder(MonitoredResourceDescriptor.getDefaultInstance());
        }

        public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder(int i) {
            return getMonitoredResourcesFieldBuilder().addBuilder(i, MonitoredResourceDescriptor.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addTypes(int i, Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureTypesIsMutable();
            this.types_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addTypes(int i, Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, type);
                return this;
            } else if (type != null) {
                ensureTypesIsMutable();
                this.types_.add(i, type);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addTypes(Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureTypesIsMutable();
            this.types_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addTypes(Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(type);
                return this;
            } else if (type != null) {
                ensureTypesIsMutable();
                this.types_.add(type);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Type.Builder addTypesBuilder() {
            return getTypesFieldBuilder().addBuilder(Type.getDefaultInstance());
        }

        public Type.Builder addTypesBuilder(int i) {
            return getTypesFieldBuilder().addBuilder(i, Type.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Service build() {
            Service buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Service buildPartial() {
            Service service = new Service(this);
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                service.configVersion_ = this.configVersion_;
            } else {
                service.configVersion_ = singleFieldBuilderV3.build();
            }
            service.name_ = this.name_;
            service.id_ = this.id_;
            service.title_ = this.title_;
            service.producerProjectId_ = this.producerProjectId_;
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.apis_ = Collections.unmodifiableList(this.apis_);
                    this.bitField0_ &= -33;
                }
                service.apis_ = this.apis_;
            } else {
                service.apis_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV32 = this.typesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.types_ = Collections.unmodifiableList(this.types_);
                    this.bitField0_ &= -65;
                }
                service.types_ = this.types_;
            } else {
                service.types_ = repeatedFieldBuilderV32.build();
            }
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV33 = this.enumsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                if ((this.bitField0_ & 128) != 0) {
                    this.enums_ = Collections.unmodifiableList(this.enums_);
                    this.bitField0_ &= -129;
                }
                service.enums_ = this.enums_;
            } else {
                service.enums_ = repeatedFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV32 = this.documentationBuilder_;
            if (singleFieldBuilderV32 == null) {
                service.documentation_ = this.documentation_;
            } else {
                service.documentation_ = singleFieldBuilderV32.build();
            }
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV33 = this.backendBuilder_;
            if (singleFieldBuilderV33 == null) {
                service.backend_ = this.backend_;
            } else {
                service.backend_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV34 = this.httpBuilder_;
            if (singleFieldBuilderV34 == null) {
                service.http_ = this.http_;
            } else {
                service.http_ = singleFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV35 = this.quotaBuilder_;
            if (singleFieldBuilderV35 == null) {
                service.quota_ = this.quota_;
            } else {
                service.quota_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV36 = this.authenticationBuilder_;
            if (singleFieldBuilderV36 == null) {
                service.authentication_ = this.authentication_;
            } else {
                service.authentication_ = singleFieldBuilderV36.build();
            }
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV37 = this.contextBuilder_;
            if (singleFieldBuilderV37 == null) {
                service.context_ = this.context_;
            } else {
                service.context_ = singleFieldBuilderV37.build();
            }
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV38 = this.usageBuilder_;
            if (singleFieldBuilderV38 == null) {
                service.usage_ = this.usage_;
            } else {
                service.usage_ = singleFieldBuilderV38.build();
            }
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV34 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV34 == null) {
                if ((this.bitField0_ & 32768) != 0) {
                    this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
                    this.bitField0_ &= -32769;
                }
                service.endpoints_ = this.endpoints_;
            } else {
                service.endpoints_ = repeatedFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV39 = this.controlBuilder_;
            if (singleFieldBuilderV39 == null) {
                service.control_ = this.control_;
            } else {
                service.control_ = singleFieldBuilderV39.build();
            }
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV35 = this.logsBuilder_;
            if (repeatedFieldBuilderV35 == null) {
                if ((this.bitField0_ & 131072) != 0) {
                    this.logs_ = Collections.unmodifiableList(this.logs_);
                    this.bitField0_ &= -131073;
                }
                service.logs_ = this.logs_;
            } else {
                service.logs_ = repeatedFieldBuilderV35.build();
            }
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV36 = this.metricsBuilder_;
            if (repeatedFieldBuilderV36 == null) {
                if ((this.bitField0_ & 262144) != 0) {
                    this.metrics_ = Collections.unmodifiableList(this.metrics_);
                    this.bitField0_ &= -262145;
                }
                service.metrics_ = this.metrics_;
            } else {
                service.metrics_ = repeatedFieldBuilderV36.build();
            }
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV37 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV37 == null) {
                if ((this.bitField0_ & 524288) != 0) {
                    this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
                    this.bitField0_ &= -524289;
                }
                service.monitoredResources_ = this.monitoredResources_;
            } else {
                service.monitoredResources_ = repeatedFieldBuilderV37.build();
            }
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV310 = this.billingBuilder_;
            if (singleFieldBuilderV310 == null) {
                service.billing_ = this.billing_;
            } else {
                service.billing_ = singleFieldBuilderV310.build();
            }
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV311 = this.loggingBuilder_;
            if (singleFieldBuilderV311 == null) {
                service.logging_ = this.logging_;
            } else {
                service.logging_ = singleFieldBuilderV311.build();
            }
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV312 = this.monitoringBuilder_;
            if (singleFieldBuilderV312 == null) {
                service.monitoring_ = this.monitoring_;
            } else {
                service.monitoring_ = singleFieldBuilderV312.build();
            }
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV313 = this.systemParametersBuilder_;
            if (singleFieldBuilderV313 == null) {
                service.systemParameters_ = this.systemParameters_;
            } else {
                service.systemParameters_ = singleFieldBuilderV313.build();
            }
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV314 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV314 == null) {
                service.sourceInfo_ = this.sourceInfo_;
            } else {
                service.sourceInfo_ = singleFieldBuilderV314.build();
            }
            service.bitField0_ = 0;
            onBuilt();
            return service;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.configVersionBuilder_ == null) {
                this.configVersion_ = null;
            } else {
                this.configVersion_ = null;
                this.configVersionBuilder_ = null;
            }
            this.name_ = "";
            this.id_ = "";
            this.title_ = "";
            this.producerProjectId_ = "";
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.apis_ = Collections.emptyList();
                this.bitField0_ &= -33;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV32 = this.typesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.types_ = Collections.emptyList();
                this.bitField0_ &= -65;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV33 = this.enumsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                this.enums_ = Collections.emptyList();
                this.bitField0_ &= -129;
            } else {
                repeatedFieldBuilderV33.clear();
            }
            if (this.documentationBuilder_ == null) {
                this.documentation_ = null;
            } else {
                this.documentation_ = null;
                this.documentationBuilder_ = null;
            }
            if (this.backendBuilder_ == null) {
                this.backend_ = null;
            } else {
                this.backend_ = null;
                this.backendBuilder_ = null;
            }
            if (this.httpBuilder_ == null) {
                this.http_ = null;
            } else {
                this.http_ = null;
                this.httpBuilder_ = null;
            }
            if (this.quotaBuilder_ == null) {
                this.quota_ = null;
            } else {
                this.quota_ = null;
                this.quotaBuilder_ = null;
            }
            if (this.authenticationBuilder_ == null) {
                this.authentication_ = null;
            } else {
                this.authentication_ = null;
                this.authenticationBuilder_ = null;
            }
            if (this.contextBuilder_ == null) {
                this.context_ = null;
            } else {
                this.context_ = null;
                this.contextBuilder_ = null;
            }
            if (this.usageBuilder_ == null) {
                this.usage_ = null;
            } else {
                this.usage_ = null;
                this.usageBuilder_ = null;
            }
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV34 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV34 == null) {
                this.endpoints_ = Collections.emptyList();
                this.bitField0_ &= -32769;
            } else {
                repeatedFieldBuilderV34.clear();
            }
            if (this.controlBuilder_ == null) {
                this.control_ = null;
            } else {
                this.control_ = null;
                this.controlBuilder_ = null;
            }
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV35 = this.logsBuilder_;
            if (repeatedFieldBuilderV35 == null) {
                this.logs_ = Collections.emptyList();
                this.bitField0_ &= -131073;
            } else {
                repeatedFieldBuilderV35.clear();
            }
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV36 = this.metricsBuilder_;
            if (repeatedFieldBuilderV36 == null) {
                this.metrics_ = Collections.emptyList();
                this.bitField0_ &= -262145;
            } else {
                repeatedFieldBuilderV36.clear();
            }
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV37 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV37 == null) {
                this.monitoredResources_ = Collections.emptyList();
                this.bitField0_ &= -524289;
            } else {
                repeatedFieldBuilderV37.clear();
            }
            if (this.billingBuilder_ == null) {
                this.billing_ = null;
            } else {
                this.billing_ = null;
                this.billingBuilder_ = null;
            }
            if (this.loggingBuilder_ == null) {
                this.logging_ = null;
            } else {
                this.logging_ = null;
                this.loggingBuilder_ = null;
            }
            if (this.monitoringBuilder_ == null) {
                this.monitoring_ = null;
            } else {
                this.monitoring_ = null;
                this.monitoringBuilder_ = null;
            }
            if (this.systemParametersBuilder_ == null) {
                this.systemParameters_ = null;
            } else {
                this.systemParameters_ = null;
                this.systemParametersBuilder_ = null;
            }
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfo_ = null;
                return this;
            }
            this.sourceInfo_ = null;
            this.sourceInfoBuilder_ = null;
            return this;
        }

        public Builder clearApis() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.apis_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearAuthentication() {
            if (this.authenticationBuilder_ == null) {
                this.authentication_ = null;
                onChanged();
                return this;
            }
            this.authentication_ = null;
            this.authenticationBuilder_ = null;
            return this;
        }

        public Builder clearBackend() {
            if (this.backendBuilder_ == null) {
                this.backend_ = null;
                onChanged();
                return this;
            }
            this.backend_ = null;
            this.backendBuilder_ = null;
            return this;
        }

        public Builder clearBilling() {
            if (this.billingBuilder_ == null) {
                this.billing_ = null;
                onChanged();
                return this;
            }
            this.billing_ = null;
            this.billingBuilder_ = null;
            return this;
        }

        public Builder clearConfigVersion() {
            if (this.configVersionBuilder_ == null) {
                this.configVersion_ = null;
                onChanged();
                return this;
            }
            this.configVersion_ = null;
            this.configVersionBuilder_ = null;
            return this;
        }

        public Builder clearContext() {
            if (this.contextBuilder_ == null) {
                this.context_ = null;
                onChanged();
                return this;
            }
            this.context_ = null;
            this.contextBuilder_ = null;
            return this;
        }

        public Builder clearControl() {
            if (this.controlBuilder_ == null) {
                this.control_ = null;
                onChanged();
                return this;
            }
            this.control_ = null;
            this.controlBuilder_ = null;
            return this;
        }

        public Builder clearDocumentation() {
            if (this.documentationBuilder_ == null) {
                this.documentation_ = null;
                onChanged();
                return this;
            }
            this.documentation_ = null;
            this.documentationBuilder_ = null;
            return this;
        }

        public Builder clearEndpoints() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.endpoints_ = Collections.emptyList();
            this.bitField0_ &= -32769;
            onChanged();
            return this;
        }

        public Builder clearEnums() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.enums_ = Collections.emptyList();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHttp() {
            if (this.httpBuilder_ == null) {
                this.http_ = null;
                onChanged();
                return this;
            }
            this.http_ = null;
            this.httpBuilder_ = null;
            return this;
        }

        public Builder clearId() {
            this.id_ = Service.getDefaultInstance().getId();
            onChanged();
            return this;
        }

        public Builder clearLogging() {
            if (this.loggingBuilder_ == null) {
                this.logging_ = null;
                onChanged();
                return this;
            }
            this.logging_ = null;
            this.loggingBuilder_ = null;
            return this;
        }

        public Builder clearLogs() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.logs_ = Collections.emptyList();
            this.bitField0_ &= -131073;
            onChanged();
            return this;
        }

        public Builder clearMetrics() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.metrics_ = Collections.emptyList();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder clearMonitoredResources() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.monitoredResources_ = Collections.emptyList();
            this.bitField0_ &= -524289;
            onChanged();
            return this;
        }

        public Builder clearMonitoring() {
            if (this.monitoringBuilder_ == null) {
                this.monitoring_ = null;
                onChanged();
                return this;
            }
            this.monitoring_ = null;
            this.monitoringBuilder_ = null;
            return this;
        }

        public Builder clearName() {
            this.name_ = Service.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProducerProjectId() {
            this.producerProjectId_ = Service.getDefaultInstance().getProducerProjectId();
            onChanged();
            return this;
        }

        public Builder clearQuota() {
            if (this.quotaBuilder_ == null) {
                this.quota_ = null;
                onChanged();
                return this;
            }
            this.quota_ = null;
            this.quotaBuilder_ = null;
            return this;
        }

        public Builder clearSourceInfo() {
            if (this.sourceInfoBuilder_ == null) {
                this.sourceInfo_ = null;
                onChanged();
                return this;
            }
            this.sourceInfo_ = null;
            this.sourceInfoBuilder_ = null;
            return this;
        }

        public Builder clearSystemParameters() {
            if (this.systemParametersBuilder_ == null) {
                this.systemParameters_ = null;
                onChanged();
                return this;
            }
            this.systemParameters_ = null;
            this.systemParametersBuilder_ = null;
            return this;
        }

        public Builder clearTitle() {
            this.title_ = Service.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        public Builder clearTypes() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.types_ = Collections.emptyList();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearUsage() {
            if (this.usageBuilder_ == null) {
                this.usage_ = null;
                onChanged();
                return this;
            }
            this.usage_ = null;
            this.usageBuilder_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Api getApis(int i) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            return repeatedFieldBuilderV3 == null ? this.apis_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Api.Builder getApisBuilder(int i) {
            return getApisFieldBuilder().getBuilder(i);
        }

        public List<Api.Builder> getApisBuilderList() {
            return getApisFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getApisCount() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            return repeatedFieldBuilderV3 == null ? this.apis_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Api> getApisList() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.apis_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ApiOrBuilder getApisOrBuilder(int i) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            return repeatedFieldBuilderV3 == null ? this.apis_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends ApiOrBuilder> getApisOrBuilderList() {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.apis_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Authentication getAuthentication() {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Authentication authentication = this.authentication_;
                Authentication authentication2 = authentication;
                if (authentication == null) {
                    authentication2 = Authentication.getDefaultInstance();
                }
                return authentication2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Authentication.Builder getAuthenticationBuilder() {
            onChanged();
            return getAuthenticationFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public AuthenticationOrBuilder getAuthenticationOrBuilder() {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Authentication authentication = this.authentication_;
            Authentication authentication2 = authentication;
            if (authentication == null) {
                authentication2 = Authentication.getDefaultInstance();
            }
            return authentication2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Backend getBackend() {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 == null) {
                Backend backend = this.backend_;
                Backend backend2 = backend;
                if (backend == null) {
                    backend2 = Backend.getDefaultInstance();
                }
                return backend2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Backend.Builder getBackendBuilder() {
            onChanged();
            return getBackendFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public BackendOrBuilder getBackendOrBuilder() {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Backend backend = this.backend_;
            Backend backend2 = backend;
            if (backend == null) {
                backend2 = Backend.getDefaultInstance();
            }
            return backend2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Billing getBilling() {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Billing billing = this.billing_;
                Billing billing2 = billing;
                if (billing == null) {
                    billing2 = Billing.getDefaultInstance();
                }
                return billing2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Billing.Builder getBillingBuilder() {
            onChanged();
            return getBillingFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public BillingOrBuilder getBillingOrBuilder() {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Billing billing = this.billing_;
            Billing billing2 = billing;
            if (billing == null) {
                billing2 = Billing.getDefaultInstance();
            }
            return billing2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public UInt32Value getConfigVersion() {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 == null) {
                UInt32Value uInt32Value = this.configVersion_;
                UInt32Value uInt32Value2 = uInt32Value;
                if (uInt32Value == null) {
                    uInt32Value2 = UInt32Value.getDefaultInstance();
                }
                return uInt32Value2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public UInt32Value.Builder getConfigVersionBuilder() {
            onChanged();
            return getConfigVersionFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            UInt32Value uInt32Value = this.configVersion_;
            UInt32Value uInt32Value2 = uInt32Value;
            if (uInt32Value == null) {
                uInt32Value2 = UInt32Value.getDefaultInstance();
            }
            return uInt32Value2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Context getContext() {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 == null) {
                Context context = this.context_;
                Context context2 = context;
                if (context == null) {
                    context2 = Context.getDefaultInstance();
                }
                return context2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Context.Builder getContextBuilder() {
            onChanged();
            return getContextFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ContextOrBuilder getContextOrBuilder() {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Context context = this.context_;
            Context context2 = context;
            if (context == null) {
                context2 = Context.getDefaultInstance();
            }
            return context2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Control getControl() {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 == null) {
                Control control = this.control_;
                Control control2 = control;
                if (control == null) {
                    control2 = Control.getDefaultInstance();
                }
                return control2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Control.Builder getControlBuilder() {
            onChanged();
            return getControlFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ControlOrBuilder getControlOrBuilder() {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Control control = this.control_;
            Control control2 = control;
            if (control == null) {
                control2 = Control.getDefaultInstance();
            }
            return control2;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Service getDefaultInstanceForType() {
            return Service.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ServiceProto.internal_static_google_api_Service_descriptor;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Documentation getDocumentation() {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Documentation documentation = this.documentation_;
                Documentation documentation2 = documentation;
                if (documentation == null) {
                    documentation2 = Documentation.getDefaultInstance();
                }
                return documentation2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Documentation.Builder getDocumentationBuilder() {
            onChanged();
            return getDocumentationFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public DocumentationOrBuilder getDocumentationOrBuilder() {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Documentation documentation = this.documentation_;
            Documentation documentation2 = documentation;
            if (documentation == null) {
                documentation2 = Documentation.getDefaultInstance();
            }
            return documentation2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Endpoint getEndpoints(int i) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.endpoints_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Endpoint.Builder getEndpointsBuilder(int i) {
            return getEndpointsFieldBuilder().getBuilder(i);
        }

        public List<Endpoint.Builder> getEndpointsBuilderList() {
            return getEndpointsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEndpointsCount() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.endpoints_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Endpoint> getEndpointsList() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.endpoints_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public EndpointOrBuilder getEndpointsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.endpoints_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.endpoints_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Enum getEnums(int i) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.enums_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Enum.Builder getEnumsBuilder(int i) {
            return getEnumsFieldBuilder().getBuilder(i);
        }

        public List<Enum.Builder> getEnumsBuilderList() {
            return getEnumsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEnumsCount() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.enums_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Enum> getEnumsList() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.enums_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public EnumOrBuilder getEnumsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.enums_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.enums_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Http getHttp() {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 == null) {
                Http http = this.http_;
                Http http2 = http;
                if (http == null) {
                    http2 = Http.getDefaultInstance();
                }
                return http2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Http.Builder getHttpBuilder() {
            onChanged();
            return getHttpFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public HttpOrBuilder getHttpOrBuilder() {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Http http = this.http_;
            Http http2 = http;
            if (http == null) {
                http2 = Http.getDefaultInstance();
            }
            return http2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Logging getLogging() {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 == null) {
                Logging logging = this.logging_;
                Logging logging2 = logging;
                if (logging == null) {
                    logging2 = Logging.getDefaultInstance();
                }
                return logging2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Logging.Builder getLoggingBuilder() {
            onChanged();
            return getLoggingFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LoggingOrBuilder getLoggingOrBuilder() {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Logging logging = this.logging_;
            Logging logging2 = logging;
            if (logging == null) {
                logging2 = Logging.getDefaultInstance();
            }
            return logging2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptor getLogs(int i) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.logs_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public LogDescriptor.Builder getLogsBuilder(int i) {
            return getLogsFieldBuilder().getBuilder(i);
        }

        public List<LogDescriptor.Builder> getLogsBuilderList() {
            return getLogsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getLogsCount() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.logs_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<LogDescriptor> getLogsList() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.logs_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptorOrBuilder getLogsOrBuilder(int i) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.logs_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.logs_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptor getMetrics(int i) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metrics_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public MetricDescriptor.Builder getMetricsBuilder(int i) {
            return getMetricsFieldBuilder().getBuilder(i);
        }

        public List<MetricDescriptor.Builder> getMetricsBuilderList() {
            return getMetricsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMetricsCount() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metrics_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MetricDescriptor> getMetricsList() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.metrics_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptorOrBuilder getMetricsOrBuilder(int i) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.metrics_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.metrics_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptor getMonitoredResources(int i) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.monitoredResources_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public MonitoredResourceDescriptor.Builder getMonitoredResourcesBuilder(int i) {
            return getMonitoredResourcesFieldBuilder().getBuilder(i);
        }

        public List<MonitoredResourceDescriptor.Builder> getMonitoredResourcesBuilderList() {
            return getMonitoredResourcesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMonitoredResourcesCount() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.monitoredResources_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.monitoredResources_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.monitoredResources_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.monitoredResources_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Monitoring getMonitoring() {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 == null) {
                Monitoring monitoring = this.monitoring_;
                Monitoring monitoring2 = monitoring;
                if (monitoring == null) {
                    monitoring2 = Monitoring.getDefaultInstance();
                }
                return monitoring2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Monitoring.Builder getMonitoringBuilder() {
            onChanged();
            return getMonitoringFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoringOrBuilder getMonitoringOrBuilder() {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Monitoring monitoring = this.monitoring_;
            Monitoring monitoring2 = monitoring;
            if (monitoring == null) {
                monitoring2 = Monitoring.getDefaultInstance();
            }
            return monitoring2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getProducerProjectId() {
            Object obj = this.producerProjectId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.producerProjectId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getProducerProjectIdBytes() {
            Object obj = this.producerProjectId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.producerProjectId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Quota getQuota() {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 == null) {
                Quota quota = this.quota_;
                Quota quota2 = quota;
                if (quota == null) {
                    quota2 = Quota.getDefaultInstance();
                }
                return quota2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Quota.Builder getQuotaBuilder() {
            onChanged();
            return getQuotaFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public QuotaOrBuilder getQuotaOrBuilder() {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Quota quota = this.quota_;
            Quota quota2 = quota;
            if (quota == null) {
                quota2 = Quota.getDefaultInstance();
            }
            return quota2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfo getSourceInfo() {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                SourceInfo sourceInfo = this.sourceInfo_;
                SourceInfo sourceInfo2 = sourceInfo;
                if (sourceInfo == null) {
                    sourceInfo2 = SourceInfo.getDefaultInstance();
                }
                return sourceInfo2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public SourceInfo.Builder getSourceInfoBuilder() {
            onChanged();
            return getSourceInfoFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfoOrBuilder getSourceInfoOrBuilder() {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SourceInfo sourceInfo = this.sourceInfo_;
            SourceInfo sourceInfo2 = sourceInfo;
            if (sourceInfo == null) {
                sourceInfo2 = SourceInfo.getDefaultInstance();
            }
            return sourceInfo2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParameters getSystemParameters() {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 == null) {
                SystemParameters systemParameters = this.systemParameters_;
                SystemParameters systemParameters2 = systemParameters;
                if (systemParameters == null) {
                    systemParameters2 = SystemParameters.getDefaultInstance();
                }
                return systemParameters2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public SystemParameters.Builder getSystemParametersBuilder() {
            onChanged();
            return getSystemParametersFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParametersOrBuilder getSystemParametersOrBuilder() {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SystemParameters systemParameters = this.systemParameters_;
            SystemParameters systemParameters2 = systemParameters;
            if (systemParameters == null) {
                systemParameters2 = SystemParameters.getDefaultInstance();
            }
            return systemParameters2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Type getTypes(int i) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.types_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Type.Builder getTypesBuilder(int i) {
            return getTypesFieldBuilder().getBuilder(i);
        }

        public List<Type.Builder> getTypesBuilderList() {
            return getTypesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getTypesCount() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.types_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Type> getTypesList() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.types_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.ServiceOrBuilder
        public TypeOrBuilder getTypesOrBuilder(int i) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            return repeatedFieldBuilderV3 == null ? this.types_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.types_);
        }

        @Override // com.google.api.ServiceOrBuilder
        public Usage getUsage() {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 == null) {
                Usage usage = this.usage_;
                Usage usage2 = usage;
                if (usage == null) {
                    usage2 = Usage.getDefaultInstance();
                }
                return usage2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Usage.Builder getUsageBuilder() {
            onChanged();
            return getUsageFieldBuilder().getBuilder();
        }

        @Override // com.google.api.ServiceOrBuilder
        public UsageOrBuilder getUsageOrBuilder() {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Usage usage = this.usage_;
            Usage usage2 = usage;
            if (usage == null) {
                usage2 = Usage.getDefaultInstance();
            }
            return usage2;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasAuthentication() {
            return (this.authenticationBuilder_ == null && this.authentication_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBackend() {
            return (this.backendBuilder_ == null && this.backend_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBilling() {
            return (this.billingBuilder_ == null && this.billing_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasConfigVersion() {
            return (this.configVersionBuilder_ == null && this.configVersion_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasContext() {
            return (this.contextBuilder_ == null && this.context_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasControl() {
            return (this.controlBuilder_ == null && this.control_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasDocumentation() {
            return (this.documentationBuilder_ == null && this.documentation_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasHttp() {
            return (this.httpBuilder_ == null && this.http_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasLogging() {
            return (this.loggingBuilder_ == null && this.logging_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasMonitoring() {
            return (this.monitoringBuilder_ == null && this.monitoring_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasQuota() {
            return (this.quotaBuilder_ == null && this.quota_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSourceInfo() {
            return (this.sourceInfoBuilder_ == null && this.sourceInfo_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSystemParameters() {
            return (this.systemParametersBuilder_ == null && this.systemParameters_ == null) ? false : true;
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasUsage() {
            return (this.usageBuilder_ == null && this.usage_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServiceProto.internal_static_google_api_Service_fieldAccessorTable.ensureFieldAccessorsInitialized(Service.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAuthentication(Authentication authentication) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(authentication);
                return this;
            }
            Authentication authentication2 = this.authentication_;
            if (authentication2 != null) {
                this.authentication_ = Authentication.newBuilder(authentication2).mergeFrom(authentication).buildPartial();
            } else {
                this.authentication_ = authentication;
            }
            onChanged();
            return this;
        }

        public Builder mergeBackend(Backend backend) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(backend);
                return this;
            }
            Backend backend2 = this.backend_;
            if (backend2 != null) {
                this.backend_ = Backend.newBuilder(backend2).mergeFrom(backend).buildPartial();
            } else {
                this.backend_ = backend;
            }
            onChanged();
            return this;
        }

        public Builder mergeBilling(Billing billing) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(billing);
                return this;
            }
            Billing billing2 = this.billing_;
            if (billing2 != null) {
                this.billing_ = Billing.newBuilder(billing2).mergeFrom(billing).buildPartial();
            } else {
                this.billing_ = billing;
            }
            onChanged();
            return this;
        }

        public Builder mergeConfigVersion(UInt32Value uInt32Value) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(uInt32Value);
                return this;
            }
            UInt32Value uInt32Value2 = this.configVersion_;
            if (uInt32Value2 != null) {
                this.configVersion_ = UInt32Value.newBuilder(uInt32Value2).mergeFrom(uInt32Value).buildPartial();
            } else {
                this.configVersion_ = uInt32Value;
            }
            onChanged();
            return this;
        }

        public Builder mergeContext(Context context) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(context);
                return this;
            }
            Context context2 = this.context_;
            if (context2 != null) {
                this.context_ = Context.newBuilder(context2).mergeFrom(context).buildPartial();
            } else {
                this.context_ = context;
            }
            onChanged();
            return this;
        }

        public Builder mergeControl(Control control) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(control);
                return this;
            }
            Control control2 = this.control_;
            if (control2 != null) {
                this.control_ = Control.newBuilder(control2).mergeFrom(control).buildPartial();
            } else {
                this.control_ = control;
            }
            onChanged();
            return this;
        }

        public Builder mergeDocumentation(Documentation documentation) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(documentation);
                return this;
            }
            Documentation documentation2 = this.documentation_;
            if (documentation2 != null) {
                this.documentation_ = Documentation.newBuilder(documentation2).mergeFrom(documentation).buildPartial();
            } else {
                this.documentation_ = documentation;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(Service service) {
            if (service == Service.getDefaultInstance()) {
                return this;
            }
            if (service.hasConfigVersion()) {
                mergeConfigVersion(service.getConfigVersion());
            }
            if (!service.getName().isEmpty()) {
                this.name_ = service.name_;
                onChanged();
            }
            if (!service.getId().isEmpty()) {
                this.id_ = service.id_;
                onChanged();
            }
            if (!service.getTitle().isEmpty()) {
                this.title_ = service.title_;
                onChanged();
            }
            if (!service.getProducerProjectId().isEmpty()) {
                this.producerProjectId_ = service.producerProjectId_;
                onChanged();
            }
            if (this.apisBuilder_ == null) {
                if (!service.apis_.isEmpty()) {
                    if (this.apis_.isEmpty()) {
                        this.apis_ = service.apis_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureApisIsMutable();
                        this.apis_.addAll(service.apis_);
                    }
                    onChanged();
                }
            } else if (!service.apis_.isEmpty()) {
                if (this.apisBuilder_.isEmpty()) {
                    this.apisBuilder_.dispose();
                    this.apisBuilder_ = null;
                    this.apis_ = service.apis_;
                    this.bitField0_ &= -33;
                    this.apisBuilder_ = Service.alwaysUseFieldBuilders ? getApisFieldBuilder() : null;
                } else {
                    this.apisBuilder_.addAllMessages(service.apis_);
                }
            }
            if (this.typesBuilder_ == null) {
                if (!service.types_.isEmpty()) {
                    if (this.types_.isEmpty()) {
                        this.types_ = service.types_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureTypesIsMutable();
                        this.types_.addAll(service.types_);
                    }
                    onChanged();
                }
            } else if (!service.types_.isEmpty()) {
                if (this.typesBuilder_.isEmpty()) {
                    this.typesBuilder_.dispose();
                    this.typesBuilder_ = null;
                    this.types_ = service.types_;
                    this.bitField0_ &= -65;
                    this.typesBuilder_ = Service.alwaysUseFieldBuilders ? getTypesFieldBuilder() : null;
                } else {
                    this.typesBuilder_.addAllMessages(service.types_);
                }
            }
            if (this.enumsBuilder_ == null) {
                if (!service.enums_.isEmpty()) {
                    if (this.enums_.isEmpty()) {
                        this.enums_ = service.enums_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureEnumsIsMutable();
                        this.enums_.addAll(service.enums_);
                    }
                    onChanged();
                }
            } else if (!service.enums_.isEmpty()) {
                if (this.enumsBuilder_.isEmpty()) {
                    this.enumsBuilder_.dispose();
                    this.enumsBuilder_ = null;
                    this.enums_ = service.enums_;
                    this.bitField0_ &= -129;
                    this.enumsBuilder_ = Service.alwaysUseFieldBuilders ? getEnumsFieldBuilder() : null;
                } else {
                    this.enumsBuilder_.addAllMessages(service.enums_);
                }
            }
            if (service.hasDocumentation()) {
                mergeDocumentation(service.getDocumentation());
            }
            if (service.hasBackend()) {
                mergeBackend(service.getBackend());
            }
            if (service.hasHttp()) {
                mergeHttp(service.getHttp());
            }
            if (service.hasQuota()) {
                mergeQuota(service.getQuota());
            }
            if (service.hasAuthentication()) {
                mergeAuthentication(service.getAuthentication());
            }
            if (service.hasContext()) {
                mergeContext(service.getContext());
            }
            if (service.hasUsage()) {
                mergeUsage(service.getUsage());
            }
            if (this.endpointsBuilder_ == null) {
                if (!service.endpoints_.isEmpty()) {
                    if (this.endpoints_.isEmpty()) {
                        this.endpoints_ = service.endpoints_;
                        this.bitField0_ &= -32769;
                    } else {
                        ensureEndpointsIsMutable();
                        this.endpoints_.addAll(service.endpoints_);
                    }
                    onChanged();
                }
            } else if (!service.endpoints_.isEmpty()) {
                if (this.endpointsBuilder_.isEmpty()) {
                    this.endpointsBuilder_.dispose();
                    this.endpointsBuilder_ = null;
                    this.endpoints_ = service.endpoints_;
                    this.bitField0_ &= -32769;
                    this.endpointsBuilder_ = Service.alwaysUseFieldBuilders ? getEndpointsFieldBuilder() : null;
                } else {
                    this.endpointsBuilder_.addAllMessages(service.endpoints_);
                }
            }
            if (service.hasControl()) {
                mergeControl(service.getControl());
            }
            if (this.logsBuilder_ == null) {
                if (!service.logs_.isEmpty()) {
                    if (this.logs_.isEmpty()) {
                        this.logs_ = service.logs_;
                        this.bitField0_ &= -131073;
                    } else {
                        ensureLogsIsMutable();
                        this.logs_.addAll(service.logs_);
                    }
                    onChanged();
                }
            } else if (!service.logs_.isEmpty()) {
                if (this.logsBuilder_.isEmpty()) {
                    this.logsBuilder_.dispose();
                    this.logsBuilder_ = null;
                    this.logs_ = service.logs_;
                    this.bitField0_ &= -131073;
                    this.logsBuilder_ = Service.alwaysUseFieldBuilders ? getLogsFieldBuilder() : null;
                } else {
                    this.logsBuilder_.addAllMessages(service.logs_);
                }
            }
            if (this.metricsBuilder_ == null) {
                if (!service.metrics_.isEmpty()) {
                    if (this.metrics_.isEmpty()) {
                        this.metrics_ = service.metrics_;
                        this.bitField0_ &= -262145;
                    } else {
                        ensureMetricsIsMutable();
                        this.metrics_.addAll(service.metrics_);
                    }
                    onChanged();
                }
            } else if (!service.metrics_.isEmpty()) {
                if (this.metricsBuilder_.isEmpty()) {
                    this.metricsBuilder_.dispose();
                    this.metricsBuilder_ = null;
                    this.metrics_ = service.metrics_;
                    this.bitField0_ &= -262145;
                    this.metricsBuilder_ = Service.alwaysUseFieldBuilders ? getMetricsFieldBuilder() : null;
                } else {
                    this.metricsBuilder_.addAllMessages(service.metrics_);
                }
            }
            if (this.monitoredResourcesBuilder_ == null) {
                if (!service.monitoredResources_.isEmpty()) {
                    if (this.monitoredResources_.isEmpty()) {
                        this.monitoredResources_ = service.monitoredResources_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureMonitoredResourcesIsMutable();
                        this.monitoredResources_.addAll(service.monitoredResources_);
                    }
                    onChanged();
                }
            } else if (!service.monitoredResources_.isEmpty()) {
                if (this.monitoredResourcesBuilder_.isEmpty()) {
                    this.monitoredResourcesBuilder_.dispose();
                    this.monitoredResourcesBuilder_ = null;
                    this.monitoredResources_ = service.monitoredResources_;
                    this.bitField0_ &= -524289;
                    RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = null;
                    if (Service.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getMonitoredResourcesFieldBuilder();
                    }
                    this.monitoredResourcesBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.monitoredResourcesBuilder_.addAllMessages(service.monitoredResources_);
                }
            }
            if (service.hasBilling()) {
                mergeBilling(service.getBilling());
            }
            if (service.hasLogging()) {
                mergeLogging(service.getLogging());
            }
            if (service.hasMonitoring()) {
                mergeMonitoring(service.getMonitoring());
            }
            if (service.hasSystemParameters()) {
                mergeSystemParameters(service.getSystemParameters());
            }
            if (service.hasSourceInfo()) {
                mergeSourceInfo(service.getSourceInfo());
            }
            mergeUnknownFields(service.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.Service.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.Service.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.Service r0 = (com.google.api.Service) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.Service$Builder r0 = r0.mergeFrom(r1)
            L1a:
                r0 = r4
                return r0
            L1c:
                r6 = move-exception
                r0 = r7
                r5 = r0
                goto L31
            L22:
                r6 = move-exception
                r0 = r6
                com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                com.google.api.Service r0 = (com.google.api.Service) r0     // Catch: java.lang.Throwable -> L1c
                r5 = r0
                r0 = r6
                java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                throw r0     // Catch: java.lang.Throwable -> L30
            L30:
                r6 = move-exception
            L31:
                r0 = r5
                if (r0 == 0) goto L3b
                r0 = r4
                r1 = r5
                com.google.api.Service$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Service.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Service$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Service) {
                return mergeFrom((Service) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeHttp(Http http) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(http);
                return this;
            }
            Http http2 = this.http_;
            if (http2 != null) {
                this.http_ = Http.newBuilder(http2).mergeFrom(http).buildPartial();
            } else {
                this.http_ = http;
            }
            onChanged();
            return this;
        }

        public Builder mergeLogging(Logging logging) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(logging);
                return this;
            }
            Logging logging2 = this.logging_;
            if (logging2 != null) {
                this.logging_ = Logging.newBuilder(logging2).mergeFrom(logging).buildPartial();
            } else {
                this.logging_ = logging;
            }
            onChanged();
            return this;
        }

        public Builder mergeMonitoring(Monitoring monitoring) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(monitoring);
                return this;
            }
            Monitoring monitoring2 = this.monitoring_;
            if (monitoring2 != null) {
                this.monitoring_ = Monitoring.newBuilder(monitoring2).mergeFrom(monitoring).buildPartial();
            } else {
                this.monitoring_ = monitoring;
            }
            onChanged();
            return this;
        }

        public Builder mergeQuota(Quota quota) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(quota);
                return this;
            }
            Quota quota2 = this.quota_;
            if (quota2 != null) {
                this.quota_ = Quota.newBuilder(quota2).mergeFrom(quota).buildPartial();
            } else {
                this.quota_ = quota;
            }
            onChanged();
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo sourceInfo) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(sourceInfo);
                return this;
            }
            SourceInfo sourceInfo2 = this.sourceInfo_;
            if (sourceInfo2 != null) {
                this.sourceInfo_ = SourceInfo.newBuilder(sourceInfo2).mergeFrom(sourceInfo).buildPartial();
            } else {
                this.sourceInfo_ = sourceInfo;
            }
            onChanged();
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters systemParameters) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(systemParameters);
                return this;
            }
            SystemParameters systemParameters2 = this.systemParameters_;
            if (systemParameters2 != null) {
                this.systemParameters_ = SystemParameters.newBuilder(systemParameters2).mergeFrom(systemParameters).buildPartial();
            } else {
                this.systemParameters_ = systemParameters;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder mergeUsage(Usage usage) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(usage);
                return this;
            }
            Usage usage2 = this.usage_;
            if (usage2 != null) {
                this.usage_ = Usage.newBuilder(usage2).mergeFrom(usage).buildPartial();
            } else {
                this.usage_ = usage;
            }
            onChanged();
            return this;
        }

        public Builder removeApis(int i) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureApisIsMutable();
            this.apis_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeEndpoints(int i) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureEndpointsIsMutable();
            this.endpoints_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeEnums(int i) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureEnumsIsMutable();
            this.enums_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeLogs(int i) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureLogsIsMutable();
            this.logs_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeMetrics(int i) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureMetricsIsMutable();
            this.metrics_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeMonitoredResources(int i) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeTypes(int i) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureTypesIsMutable();
            this.types_.remove(i);
            onChanged();
            return this;
        }

        public Builder setApis(int i, Api.Builder builder) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureApisIsMutable();
            this.apis_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setApis(int i, Api api) {
            RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, api);
                return this;
            } else if (api != null) {
                ensureApisIsMutable();
                this.apis_.set(i, api);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setAuthentication(Authentication.Builder builder) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.authentication_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setAuthentication(Authentication authentication) {
            SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(authentication);
                return this;
            } else if (authentication != null) {
                this.authentication_ = authentication;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setBackend(Backend.Builder builder) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.backend_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setBackend(Backend backend) {
            SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(backend);
                return this;
            } else if (backend != null) {
                this.backend_ = backend;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setBilling(Billing.Builder builder) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.billing_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setBilling(Billing billing) {
            SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(billing);
                return this;
            } else if (billing != null) {
                this.billing_ = billing;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setConfigVersion(UInt32Value.Builder builder) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.configVersion_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setConfigVersion(UInt32Value uInt32Value) {
            SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(uInt32Value);
                return this;
            } else if (uInt32Value != null) {
                this.configVersion_ = uInt32Value;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setContext(Context.Builder builder) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.context_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setContext(Context context) {
            SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(context);
                return this;
            } else if (context != null) {
                this.context_ = context;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setControl(Control.Builder builder) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.control_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setControl(Control control) {
            SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(control);
                return this;
            } else if (control != null) {
                this.control_ = control;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setDocumentation(Documentation.Builder builder) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.documentation_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setDocumentation(Documentation documentation) {
            SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(documentation);
                return this;
            } else if (documentation != null) {
                this.documentation_ = documentation;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setEndpoints(int i, Endpoint.Builder builder) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureEndpointsIsMutable();
            this.endpoints_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setEndpoints(int i, Endpoint endpoint) {
            RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, endpoint);
                return this;
            } else if (endpoint != null) {
                ensureEndpointsIsMutable();
                this.endpoints_.set(i, endpoint);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setEnums(int i, Enum.Builder builder) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureEnumsIsMutable();
            this.enums_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setEnums(int i, Enum r6) {
            RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, r6);
                return this;
            } else if (r6 != null) {
                ensureEnumsIsMutable();
                this.enums_.set(i, r6);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHttp(Http.Builder builder) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.http_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setHttp(Http http) {
            SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(http);
                return this;
            } else if (http != null) {
                this.http_ = http;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setId(String str) {
            if (str != null) {
                this.id_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIdBytes(ByteString byteString) {
            if (byteString != null) {
                Service.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLogging(Logging.Builder builder) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.logging_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setLogging(Logging logging) {
            SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(logging);
                return this;
            } else if (logging != null) {
                this.logging_ = logging;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setLogs(int i, LogDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureLogsIsMutable();
            this.logs_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setLogs(int i, LogDescriptor logDescriptor) {
            RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, logDescriptor);
                return this;
            } else if (logDescriptor != null) {
                ensureLogsIsMutable();
                this.logs_.set(i, logDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setMetrics(int i, MetricDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureMetricsIsMutable();
            this.metrics_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setMetrics(int i, MetricDescriptor metricDescriptor) {
            RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, metricDescriptor);
                return this;
            } else if (metricDescriptor != null) {
                ensureMetricsIsMutable();
                this.metrics_.set(i, metricDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, monitoredResourceDescriptor);
                return this;
            } else if (monitoredResourceDescriptor != null) {
                ensureMonitoredResourcesIsMutable();
                this.monitoredResources_.set(i, monitoredResourceDescriptor);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setMonitoring(Monitoring.Builder builder) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.monitoring_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setMonitoring(Monitoring monitoring) {
            SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(monitoring);
                return this;
            } else if (monitoring != null) {
                this.monitoring_ = monitoring;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                Service.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setProducerProjectId(String str) {
            if (str != null) {
                this.producerProjectId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setProducerProjectIdBytes(ByteString byteString) {
            if (byteString != null) {
                Service.checkByteStringIsUtf8(byteString);
                this.producerProjectId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setQuota(Quota.Builder builder) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.quota_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setQuota(Quota quota) {
            SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(quota);
                return this;
            } else if (quota != null) {
                this.quota_ = quota;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setSourceInfo(SourceInfo.Builder builder) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.sourceInfo_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setSourceInfo(SourceInfo sourceInfo) {
            SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(sourceInfo);
                return this;
            } else if (sourceInfo != null) {
                this.sourceInfo_ = sourceInfo;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setSystemParameters(SystemParameters.Builder builder) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.systemParameters_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setSystemParameters(SystemParameters systemParameters) {
            SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(systemParameters);
                return this;
            } else if (systemParameters != null) {
                this.systemParameters_ = systemParameters;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setTitle(String str) {
            if (str != null) {
                this.title_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTitleBytes(ByteString byteString) {
            if (byteString != null) {
                Service.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypes(int i, Type.Builder builder) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureTypesIsMutable();
            this.types_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setTypes(int i, Type type) {
            RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, type);
                return this;
            } else if (type != null) {
                ensureTypesIsMutable();
                this.types_.set(i, type);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsage(Usage.Builder builder) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.usage_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setUsage(Usage usage) {
            SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(usage);
                return this;
            } else if (usage != null) {
                this.usage_ = usage;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    private Service() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.id_ = "";
        this.title_ = "";
        this.producerProjectId_ = "";
        this.apis_ = Collections.emptyList();
        this.types_ = Collections.emptyList();
        this.enums_ = Collections.emptyList();
        this.endpoints_ = Collections.emptyList();
        this.logs_ = Collections.emptyList();
        this.metrics_ = Collections.emptyList();
        this.monitoredResources_ = Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Service(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        SourceInfo.Builder builder;
        Documentation.Builder builder2;
        Backend.Builder builder3;
        Http.Builder builder4;
        Quota.Builder builder5;
        Authentication.Builder builder6;
        Context.Builder builder7;
        Usage.Builder builder8;
        UInt32Value.Builder builder9;
        Control.Builder builder10;
        Billing.Builder builder11;
        Logging.Builder builder12;
        Monitoring.Builder builder13;
        SystemParameters.Builder builder14;
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            boolean z3 = z2;
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.name_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            this.title_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.apis_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.apis_.add(codedInputStream.readMessage(Api.parser(), extensionRegistryLite));
                            z2 = z4;
                            continue;
                        case 34:
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.types_ = new ArrayList();
                                z5 = z2 | true;
                            }
                            this.types_.add(codedInputStream.readMessage(Type.parser(), extensionRegistryLite));
                            z2 = z5;
                            continue;
                        case 42:
                            boolean z6 = z2;
                            if (!(z2 & true)) {
                                this.enums_ = new ArrayList();
                                z6 = z2 | true;
                            }
                            this.enums_.add(codedInputStream.readMessage(Enum.parser(), extensionRegistryLite));
                            z2 = z6;
                            continue;
                        case 50:
                            if (this.documentation_ != null) {
                                boolean z7 = z2;
                                builder2 = this.documentation_.toBuilder();
                            } else {
                                builder2 = null;
                            }
                            Documentation documentation = (Documentation) codedInputStream.readMessage(Documentation.parser(), extensionRegistryLite);
                            boolean z8 = z2;
                            this.documentation_ = documentation;
                            if (builder2 != null) {
                                builder2.mergeFrom(documentation);
                                boolean z9 = z2;
                                this.documentation_ = builder2.buildPartial();
                            } else {
                                continue;
                            }
                        case 66:
                            if (this.backend_ != null) {
                                boolean z10 = z2;
                                builder3 = this.backend_.toBuilder();
                            } else {
                                builder3 = null;
                            }
                            Backend backend = (Backend) codedInputStream.readMessage(Backend.parser(), extensionRegistryLite);
                            boolean z11 = z2;
                            this.backend_ = backend;
                            if (builder3 != null) {
                                builder3.mergeFrom(backend);
                                boolean z12 = z2;
                                this.backend_ = builder3.buildPartial();
                            } else {
                                continue;
                            }
                        case 74:
                            if (this.http_ != null) {
                                boolean z13 = z2;
                                builder4 = this.http_.toBuilder();
                            } else {
                                builder4 = null;
                            }
                            Http http = (Http) codedInputStream.readMessage(Http.parser(), extensionRegistryLite);
                            boolean z14 = z2;
                            this.http_ = http;
                            if (builder4 != null) {
                                builder4.mergeFrom(http);
                                boolean z15 = z2;
                                this.http_ = builder4.buildPartial();
                            } else {
                                continue;
                            }
                        case 82:
                            if (this.quota_ != null) {
                                boolean z16 = z2;
                                builder5 = this.quota_.toBuilder();
                            } else {
                                builder5 = null;
                            }
                            Quota quota = (Quota) codedInputStream.readMessage(Quota.parser(), extensionRegistryLite);
                            boolean z17 = z2;
                            this.quota_ = quota;
                            if (builder5 != null) {
                                builder5.mergeFrom(quota);
                                boolean z18 = z2;
                                this.quota_ = builder5.buildPartial();
                            } else {
                                continue;
                            }
                        case 90:
                            if (this.authentication_ != null) {
                                boolean z19 = z2;
                                builder6 = this.authentication_.toBuilder();
                            } else {
                                builder6 = null;
                            }
                            Authentication authentication = (Authentication) codedInputStream.readMessage(Authentication.parser(), extensionRegistryLite);
                            boolean z20 = z2;
                            this.authentication_ = authentication;
                            if (builder6 != null) {
                                builder6.mergeFrom(authentication);
                                boolean z21 = z2;
                                this.authentication_ = builder6.buildPartial();
                            } else {
                                continue;
                            }
                        case 98:
                            if (this.context_ != null) {
                                boolean z22 = z2;
                                builder7 = this.context_.toBuilder();
                            } else {
                                builder7 = null;
                            }
                            Context context = (Context) codedInputStream.readMessage(Context.parser(), extensionRegistryLite);
                            boolean z23 = z2;
                            this.context_ = context;
                            if (builder7 != null) {
                                builder7.mergeFrom(context);
                                boolean z24 = z2;
                                this.context_ = builder7.buildPartial();
                            } else {
                                continue;
                            }
                        case 122:
                            if (this.usage_ != null) {
                                boolean z25 = z2;
                                builder8 = this.usage_.toBuilder();
                            } else {
                                builder8 = null;
                            }
                            Usage usage = (Usage) codedInputStream.readMessage(Usage.parser(), extensionRegistryLite);
                            boolean z26 = z2;
                            this.usage_ = usage;
                            if (builder8 != null) {
                                builder8.mergeFrom(usage);
                                boolean z27 = z2;
                                this.usage_ = builder8.buildPartial();
                            } else {
                                continue;
                            }
                        case 146:
                            boolean z28 = z2;
                            if (!(z2 & true)) {
                                this.endpoints_ = new ArrayList();
                                z28 = z2 | true;
                            }
                            this.endpoints_.add(codedInputStream.readMessage(Endpoint.parser(), extensionRegistryLite));
                            z2 = z28;
                            continue;
                        case 162:
                            if (this.configVersion_ != null) {
                                boolean z29 = z2;
                                builder9 = this.configVersion_.toBuilder();
                            } else {
                                builder9 = null;
                            }
                            UInt32Value uInt32Value = (UInt32Value) codedInputStream.readMessage(UInt32Value.parser(), extensionRegistryLite);
                            boolean z30 = z2;
                            this.configVersion_ = uInt32Value;
                            if (builder9 != null) {
                                builder9.mergeFrom(uInt32Value);
                                boolean z31 = z2;
                                this.configVersion_ = builder9.buildPartial();
                            } else {
                                continue;
                            }
                        case 170:
                            if (this.control_ != null) {
                                boolean z32 = z2;
                                builder10 = this.control_.toBuilder();
                            } else {
                                builder10 = null;
                            }
                            Control control = (Control) codedInputStream.readMessage(Control.parser(), extensionRegistryLite);
                            boolean z33 = z2;
                            this.control_ = control;
                            if (builder10 != null) {
                                builder10.mergeFrom(control);
                                boolean z34 = z2;
                                this.control_ = builder10.buildPartial();
                            } else {
                                continue;
                            }
                        case 178:
                            this.producerProjectId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 186:
                            boolean z35 = z2;
                            if (!(z2 & true)) {
                                this.logs_ = new ArrayList();
                                z35 = z2 | true;
                            }
                            this.logs_.add(codedInputStream.readMessage(LogDescriptor.parser(), extensionRegistryLite));
                            z2 = z35;
                            continue;
                        case 194:
                            boolean z36 = z2;
                            if (!(z2 & true)) {
                                this.metrics_ = new ArrayList();
                                z36 = z2 | true;
                            }
                            this.metrics_.add(codedInputStream.readMessage(MetricDescriptor.parser(), extensionRegistryLite));
                            z2 = z36;
                            continue;
                        case 202:
                            boolean z37 = z2;
                            if (!(z2 & true)) {
                                this.monitoredResources_ = new ArrayList();
                                z37 = z2 | true;
                            }
                            this.monitoredResources_.add(codedInputStream.readMessage(MonitoredResourceDescriptor.parser(), extensionRegistryLite));
                            z2 = z37;
                            continue;
                        case 210:
                            if (this.billing_ != null) {
                                boolean z38 = z2;
                                builder11 = this.billing_.toBuilder();
                            } else {
                                builder11 = null;
                            }
                            Billing billing = (Billing) codedInputStream.readMessage(Billing.parser(), extensionRegistryLite);
                            boolean z39 = z2;
                            this.billing_ = billing;
                            if (builder11 != null) {
                                builder11.mergeFrom(billing);
                                boolean z40 = z2;
                                this.billing_ = builder11.buildPartial();
                            } else {
                                continue;
                            }
                        case 218:
                            if (this.logging_ != null) {
                                boolean z41 = z2;
                                builder12 = this.logging_.toBuilder();
                            } else {
                                builder12 = null;
                            }
                            Logging logging = (Logging) codedInputStream.readMessage(Logging.parser(), extensionRegistryLite);
                            boolean z42 = z2;
                            this.logging_ = logging;
                            if (builder12 != null) {
                                builder12.mergeFrom(logging);
                                boolean z43 = z2;
                                this.logging_ = builder12.buildPartial();
                            } else {
                                continue;
                            }
                        case 226:
                            if (this.monitoring_ != null) {
                                boolean z44 = z2;
                                builder13 = this.monitoring_.toBuilder();
                            } else {
                                builder13 = null;
                            }
                            Monitoring monitoring = (Monitoring) codedInputStream.readMessage(Monitoring.parser(), extensionRegistryLite);
                            boolean z45 = z2;
                            this.monitoring_ = monitoring;
                            if (builder13 != null) {
                                builder13.mergeFrom(monitoring);
                                boolean z46 = z2;
                                this.monitoring_ = builder13.buildPartial();
                            } else {
                                continue;
                            }
                        case 234:
                            if (this.systemParameters_ != null) {
                                boolean z47 = z2;
                                builder14 = this.systemParameters_.toBuilder();
                            } else {
                                builder14 = null;
                            }
                            SystemParameters systemParameters = (SystemParameters) codedInputStream.readMessage(SystemParameters.parser(), extensionRegistryLite);
                            boolean z48 = z2;
                            this.systemParameters_ = systemParameters;
                            if (builder14 != null) {
                                builder14.mergeFrom(systemParameters);
                                boolean z49 = z2;
                                this.systemParameters_ = builder14.buildPartial();
                            } else {
                                continue;
                            }
                        case 266:
                            this.id_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 298:
                            if (this.sourceInfo_ != null) {
                                boolean z50 = z2;
                                builder = this.sourceInfo_.toBuilder();
                            } else {
                                builder = null;
                            }
                            SourceInfo sourceInfo = (SourceInfo) codedInputStream.readMessage(SourceInfo.parser(), extensionRegistryLite);
                            boolean z51 = z2;
                            this.sourceInfo_ = sourceInfo;
                            if (builder != null) {
                                builder.mergeFrom(sourceInfo);
                                boolean z52 = z2;
                                this.sourceInfo_ = builder.buildPartial();
                            } else {
                                continue;
                            }
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.apis_ = Collections.unmodifiableList(this.apis_);
                }
                if (z3 & true) {
                    this.types_ = Collections.unmodifiableList(this.types_);
                }
                if (z3 & true) {
                    this.enums_ = Collections.unmodifiableList(this.enums_);
                }
                if (z3 & true) {
                    this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
                }
                if (z3 & true) {
                    this.logs_ = Collections.unmodifiableList(this.logs_);
                }
                if (z3 & true) {
                    this.metrics_ = Collections.unmodifiableList(this.metrics_);
                }
                if (z3 & true) {
                    this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.apis_ = Collections.unmodifiableList(this.apis_);
        }
        if (z2 & true) {
            this.types_ = Collections.unmodifiableList(this.types_);
        }
        if (z2 & true) {
            this.enums_ = Collections.unmodifiableList(this.enums_);
        }
        if (z2 & true) {
            this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
        }
        if (z2 & true) {
            this.logs_ = Collections.unmodifiableList(this.logs_);
        }
        if (z2 & true) {
            this.metrics_ = Collections.unmodifiableList(this.metrics_);
        }
        if (z2 & true) {
            this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private Service(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ServiceProto.internal_static_google_api_Service_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(service);
    }

    public static Service parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Service parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Service parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<Service> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Service) {
            Service service = (Service) obj;
            if (hasConfigVersion() != service.hasConfigVersion()) {
                return false;
            }
            if ((!hasConfigVersion() || getConfigVersion().equals(service.getConfigVersion())) && getName().equals(service.getName()) && getId().equals(service.getId()) && getTitle().equals(service.getTitle()) && getProducerProjectId().equals(service.getProducerProjectId()) && getApisList().equals(service.getApisList()) && getTypesList().equals(service.getTypesList()) && getEnumsList().equals(service.getEnumsList()) && hasDocumentation() == service.hasDocumentation()) {
                if ((!hasDocumentation() || getDocumentation().equals(service.getDocumentation())) && hasBackend() == service.hasBackend()) {
                    if ((!hasBackend() || getBackend().equals(service.getBackend())) && hasHttp() == service.hasHttp()) {
                        if ((!hasHttp() || getHttp().equals(service.getHttp())) && hasQuota() == service.hasQuota()) {
                            if ((!hasQuota() || getQuota().equals(service.getQuota())) && hasAuthentication() == service.hasAuthentication()) {
                                if ((!hasAuthentication() || getAuthentication().equals(service.getAuthentication())) && hasContext() == service.hasContext()) {
                                    if ((!hasContext() || getContext().equals(service.getContext())) && hasUsage() == service.hasUsage()) {
                                        if ((!hasUsage() || getUsage().equals(service.getUsage())) && getEndpointsList().equals(service.getEndpointsList()) && hasControl() == service.hasControl()) {
                                            if ((!hasControl() || getControl().equals(service.getControl())) && getLogsList().equals(service.getLogsList()) && getMetricsList().equals(service.getMetricsList()) && getMonitoredResourcesList().equals(service.getMonitoredResourcesList()) && hasBilling() == service.hasBilling()) {
                                                if ((!hasBilling() || getBilling().equals(service.getBilling())) && hasLogging() == service.hasLogging()) {
                                                    if ((!hasLogging() || getLogging().equals(service.getLogging())) && hasMonitoring() == service.hasMonitoring()) {
                                                        if ((!hasMonitoring() || getMonitoring().equals(service.getMonitoring())) && hasSystemParameters() == service.hasSystemParameters()) {
                                                            if ((!hasSystemParameters() || getSystemParameters().equals(service.getSystemParameters())) && hasSourceInfo() == service.hasSourceInfo()) {
                                                                return (!hasSourceInfo() || getSourceInfo().equals(service.getSourceInfo())) && this.unknownFields.equals(service.unknownFields);
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Api getApis(int i) {
        return this.apis_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Api> getApisList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ApiOrBuilder getApisOrBuilder(int i) {
        return this.apis_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        Authentication authentication2 = authentication;
        if (authentication == null) {
            authentication2 = Authentication.getDefaultInstance();
        }
        return authentication2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public AuthenticationOrBuilder getAuthenticationOrBuilder() {
        return getAuthentication();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Backend getBackend() {
        Backend backend = this.backend_;
        Backend backend2 = backend;
        if (backend == null) {
            backend2 = Backend.getDefaultInstance();
        }
        return backend2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public BackendOrBuilder getBackendOrBuilder() {
        return getBackend();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Billing getBilling() {
        Billing billing = this.billing_;
        Billing billing2 = billing;
        if (billing == null) {
            billing2 = Billing.getDefaultInstance();
        }
        return billing2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public BillingOrBuilder getBillingOrBuilder() {
        return getBilling();
    }

    @Override // com.google.api.ServiceOrBuilder
    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        UInt32Value uInt32Value2 = uInt32Value;
        if (uInt32Value == null) {
            uInt32Value2 = UInt32Value.getDefaultInstance();
        }
        return uInt32Value2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
        return getConfigVersion();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Context getContext() {
        Context context = this.context_;
        Context context2 = context;
        if (context == null) {
            context2 = Context.getDefaultInstance();
        }
        return context2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ContextOrBuilder getContextOrBuilder() {
        return getContext();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Control getControl() {
        Control control = this.control_;
        Control control2 = control;
        if (control == null) {
            control2 = Control.getDefaultInstance();
        }
        return control2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ControlOrBuilder getControlOrBuilder() {
        return getControl();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Service getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        Documentation documentation2 = documentation;
        if (documentation == null) {
            documentation2 = Documentation.getDefaultInstance();
        }
        return documentation2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public DocumentationOrBuilder getDocumentationOrBuilder() {
        return getDocumentation();
    }

    @Override // com.google.api.ServiceOrBuilder
    public Endpoint getEndpoints(int i) {
        return this.endpoints_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public EndpointOrBuilder getEndpointsOrBuilder(int i) {
        return this.endpoints_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Enum getEnums(int i) {
        return this.enums_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEnumsCount() {
        return this.enums_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public EnumOrBuilder getEnumsOrBuilder(int i) {
        return this.enums_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Http getHttp() {
        Http http = this.http_;
        Http http2 = http;
        if (http == null) {
            http2 = Http.getDefaultInstance();
        }
        return http2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public HttpOrBuilder getHttpOrBuilder() {
        return getHttp();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getId() {
        Object obj = this.id_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.id_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getIdBytes() {
        Object obj = this.id_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.id_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Logging getLogging() {
        Logging logging = this.logging_;
        Logging logging2 = logging;
        if (logging == null) {
            logging2 = Logging.getDefaultInstance();
        }
        return logging2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LoggingOrBuilder getLoggingOrBuilder() {
        return getLogging();
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptor getLogs(int i) {
        return this.logs_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptorOrBuilder getLogsOrBuilder(int i) {
        return this.logs_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptor getMetrics(int i) {
        return this.metrics_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptorOrBuilder getMetricsOrBuilder(int i) {
        return this.metrics_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptor getMonitoredResources(int i) {
        return this.monitoredResources_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i) {
        return this.monitoredResources_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        Monitoring monitoring2 = monitoring;
        if (monitoring == null) {
            monitoring2 = Monitoring.getDefaultInstance();
        }
        return monitoring2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoringOrBuilder getMonitoringOrBuilder() {
        return getMonitoring();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Service> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getProducerProjectId() {
        Object obj = this.producerProjectId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.producerProjectId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getProducerProjectIdBytes() {
        Object obj = this.producerProjectId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.producerProjectId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Quota getQuota() {
        Quota quota = this.quota_;
        Quota quota2 = quota;
        if (quota == null) {
            quota2 = Quota.getDefaultInstance();
        }
        return quota2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public QuotaOrBuilder getQuotaOrBuilder() {
        return getQuota();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        int i4 = computeStringSize;
        if (!getTitleBytes().isEmpty()) {
            i4 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.title_);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.apis_.size()) {
                break;
            }
            i4 += CodedOutputStream.computeMessageSize(3, this.apis_.get(i6));
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.types_.size()) {
                break;
            }
            i4 += CodedOutputStream.computeMessageSize(4, this.types_.get(i8));
            i7 = i8 + 1;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.enums_.size()) {
                break;
            }
            i4 += CodedOutputStream.computeMessageSize(5, this.enums_.get(i10));
            i9 = i10 + 1;
        }
        int i11 = i4;
        if (this.documentation_ != null) {
            i11 = i4 + CodedOutputStream.computeMessageSize(6, getDocumentation());
        }
        int i12 = i11;
        if (this.backend_ != null) {
            i12 = i11 + CodedOutputStream.computeMessageSize(8, getBackend());
        }
        int i13 = i12;
        if (this.http_ != null) {
            i13 = i12 + CodedOutputStream.computeMessageSize(9, getHttp());
        }
        int i14 = i13;
        if (this.quota_ != null) {
            i14 = i13 + CodedOutputStream.computeMessageSize(10, getQuota());
        }
        int i15 = i14;
        if (this.authentication_ != null) {
            i15 = i14 + CodedOutputStream.computeMessageSize(11, getAuthentication());
        }
        int i16 = i15;
        if (this.context_ != null) {
            i16 = i15 + CodedOutputStream.computeMessageSize(12, getContext());
        }
        int i17 = i16;
        if (this.usage_ != null) {
            i17 = i16 + CodedOutputStream.computeMessageSize(15, getUsage());
        }
        int i18 = 0;
        while (true) {
            int i19 = i18;
            if (i19 >= this.endpoints_.size()) {
                break;
            }
            i17 += CodedOutputStream.computeMessageSize(18, this.endpoints_.get(i19));
            i18 = i19 + 1;
        }
        int i20 = i17;
        if (this.configVersion_ != null) {
            i20 = i17 + CodedOutputStream.computeMessageSize(20, getConfigVersion());
        }
        int i21 = i20;
        if (this.control_ != null) {
            i21 = i20 + CodedOutputStream.computeMessageSize(21, getControl());
        }
        int i22 = i21;
        if (!getProducerProjectIdBytes().isEmpty()) {
            i22 = i21 + GeneratedMessageV3.computeStringSize(22, this.producerProjectId_);
        }
        int i23 = 0;
        while (true) {
            int i24 = i23;
            if (i24 >= this.logs_.size()) {
                break;
            }
            i22 += CodedOutputStream.computeMessageSize(23, this.logs_.get(i24));
            i23 = i24 + 1;
        }
        int i25 = 0;
        int i26 = i22;
        while (true) {
            i = i26;
            if (i25 >= this.metrics_.size()) {
                break;
            }
            i26 += CodedOutputStream.computeMessageSize(24, this.metrics_.get(i25));
            i25++;
        }
        for (i2 = 0; i2 < this.monitoredResources_.size(); i2++) {
            i += CodedOutputStream.computeMessageSize(25, this.monitoredResources_.get(i2));
        }
        int i27 = i;
        if (this.billing_ != null) {
            i27 = i + CodedOutputStream.computeMessageSize(26, getBilling());
        }
        int i28 = i27;
        if (this.logging_ != null) {
            i28 = i27 + CodedOutputStream.computeMessageSize(27, getLogging());
        }
        int i29 = i28;
        if (this.monitoring_ != null) {
            i29 = i28 + CodedOutputStream.computeMessageSize(28, getMonitoring());
        }
        int i30 = i29;
        if (this.systemParameters_ != null) {
            i30 = i29 + CodedOutputStream.computeMessageSize(29, getSystemParameters());
        }
        int i31 = i30;
        if (!getIdBytes().isEmpty()) {
            i31 = i30 + GeneratedMessageV3.computeStringSize(33, this.id_);
        }
        int i32 = i31;
        if (this.sourceInfo_ != null) {
            i32 = i31 + CodedOutputStream.computeMessageSize(37, getSourceInfo());
        }
        int serializedSize = i32 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        SourceInfo sourceInfo2 = sourceInfo;
        if (sourceInfo == null) {
            sourceInfo2 = SourceInfo.getDefaultInstance();
        }
        return sourceInfo2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfoOrBuilder getSourceInfoOrBuilder() {
        return getSourceInfo();
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        SystemParameters systemParameters2 = systemParameters;
        if (systemParameters == null) {
            systemParameters2 = SystemParameters.getDefaultInstance();
        }
        return systemParameters2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParametersOrBuilder getSystemParametersOrBuilder() {
        return getSystemParameters();
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Type getTypes(int i) {
        return this.types_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getTypesCount() {
        return this.types_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Type> getTypesList() {
        return this.types_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public TypeOrBuilder getTypesOrBuilder(int i) {
        return this.types_.get(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Usage getUsage() {
        Usage usage = this.usage_;
        Usage usage2 = usage;
        if (usage == null) {
            usage2 = Usage.getDefaultInstance();
        }
        return usage2;
    }

    @Override // com.google.api.ServiceOrBuilder
    public UsageOrBuilder getUsageOrBuilder() {
        return getUsage();
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBackend() {
        return this.backend_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBilling() {
        return this.billing_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasContext() {
        return this.context_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasControl() {
        return this.control_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasHttp() {
        return this.http_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasLogging() {
        return this.logging_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasQuota() {
        return this.quota_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasUsage() {
        return this.usage_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasConfigVersion()) {
            i = (((hashCode * 37) + 20) * 53) + getConfigVersion().hashCode();
        }
        int hashCode2 = (((((((((((((((i * 37) + 1) * 53) + getName().hashCode()) * 37) + 33) * 53) + getId().hashCode()) * 37) + 2) * 53) + getTitle().hashCode()) * 37) + 22) * 53) + getProducerProjectId().hashCode();
        int i2 = hashCode2;
        if (getApisCount() > 0) {
            i2 = (((hashCode2 * 37) + 3) * 53) + getApisList().hashCode();
        }
        int i3 = i2;
        if (getTypesCount() > 0) {
            i3 = (((i2 * 37) + 4) * 53) + getTypesList().hashCode();
        }
        int i4 = i3;
        if (getEnumsCount() > 0) {
            i4 = (((i3 * 37) + 5) * 53) + getEnumsList().hashCode();
        }
        int i5 = i4;
        if (hasDocumentation()) {
            i5 = (((i4 * 37) + 6) * 53) + getDocumentation().hashCode();
        }
        int i6 = i5;
        if (hasBackend()) {
            i6 = (((i5 * 37) + 8) * 53) + getBackend().hashCode();
        }
        int i7 = i6;
        if (hasHttp()) {
            i7 = (((i6 * 37) + 9) * 53) + getHttp().hashCode();
        }
        int i8 = i7;
        if (hasQuota()) {
            i8 = (((i7 * 37) + 10) * 53) + getQuota().hashCode();
        }
        int i9 = i8;
        if (hasAuthentication()) {
            i9 = (((i8 * 37) + 11) * 53) + getAuthentication().hashCode();
        }
        int i10 = i9;
        if (hasContext()) {
            i10 = (((i9 * 37) + 12) * 53) + getContext().hashCode();
        }
        int i11 = i10;
        if (hasUsage()) {
            i11 = (((i10 * 37) + 15) * 53) + getUsage().hashCode();
        }
        int i12 = i11;
        if (getEndpointsCount() > 0) {
            i12 = (((i11 * 37) + 18) * 53) + getEndpointsList().hashCode();
        }
        int i13 = i12;
        if (hasControl()) {
            i13 = (((i12 * 37) + 21) * 53) + getControl().hashCode();
        }
        int i14 = i13;
        if (getLogsCount() > 0) {
            i14 = (((i13 * 37) + 23) * 53) + getLogsList().hashCode();
        }
        int i15 = i14;
        if (getMetricsCount() > 0) {
            i15 = (((i14 * 37) + 24) * 53) + getMetricsList().hashCode();
        }
        int i16 = i15;
        if (getMonitoredResourcesCount() > 0) {
            i16 = (((i15 * 37) + 25) * 53) + getMonitoredResourcesList().hashCode();
        }
        int i17 = i16;
        if (hasBilling()) {
            i17 = (((i16 * 37) + 26) * 53) + getBilling().hashCode();
        }
        int i18 = i17;
        if (hasLogging()) {
            i18 = (((i17 * 37) + 27) * 53) + getLogging().hashCode();
        }
        int i19 = i18;
        if (hasMonitoring()) {
            i19 = (((i18 * 37) + 28) * 53) + getMonitoring().hashCode();
        }
        int i20 = i19;
        if (hasSystemParameters()) {
            i20 = (((i19 * 37) + 29) * 53) + getSystemParameters().hashCode();
        }
        int i21 = i20;
        if (hasSourceInfo()) {
            i21 = (((i20 * 37) + 37) * 53) + getSourceInfo().hashCode();
        }
        int hashCode3 = (i21 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ServiceProto.internal_static_google_api_Service_fieldAccessorTable.ensureFieldAccessorsInitialized(Service.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.title_);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.apis_.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.apis_.get(i3));
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.types_.size()) {
                break;
            }
            codedOutputStream.writeMessage(4, this.types_.get(i5));
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.enums_.size()) {
                break;
            }
            codedOutputStream.writeMessage(5, this.enums_.get(i7));
            i6 = i7 + 1;
        }
        if (this.documentation_ != null) {
            codedOutputStream.writeMessage(6, getDocumentation());
        }
        if (this.backend_ != null) {
            codedOutputStream.writeMessage(8, getBackend());
        }
        if (this.http_ != null) {
            codedOutputStream.writeMessage(9, getHttp());
        }
        if (this.quota_ != null) {
            codedOutputStream.writeMessage(10, getQuota());
        }
        if (this.authentication_ != null) {
            codedOutputStream.writeMessage(11, getAuthentication());
        }
        if (this.context_ != null) {
            codedOutputStream.writeMessage(12, getContext());
        }
        if (this.usage_ != null) {
            codedOutputStream.writeMessage(15, getUsage());
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= this.endpoints_.size()) {
                break;
            }
            codedOutputStream.writeMessage(18, this.endpoints_.get(i9));
            i8 = i9 + 1;
        }
        if (this.configVersion_ != null) {
            codedOutputStream.writeMessage(20, getConfigVersion());
        }
        if (this.control_ != null) {
            codedOutputStream.writeMessage(21, getControl());
        }
        if (!getProducerProjectIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 22, this.producerProjectId_);
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= this.logs_.size()) {
                break;
            }
            codedOutputStream.writeMessage(23, this.logs_.get(i11));
            i10 = i11 + 1;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= this.metrics_.size()) {
                break;
            }
            codedOutputStream.writeMessage(24, this.metrics_.get(i13));
            i12 = i13 + 1;
        }
        for (i = 0; i < this.monitoredResources_.size(); i++) {
            codedOutputStream.writeMessage(25, this.monitoredResources_.get(i));
        }
        if (this.billing_ != null) {
            codedOutputStream.writeMessage(26, getBilling());
        }
        if (this.logging_ != null) {
            codedOutputStream.writeMessage(27, getLogging());
        }
        if (this.monitoring_ != null) {
            codedOutputStream.writeMessage(28, getMonitoring());
        }
        if (this.systemParameters_ != null) {
            codedOutputStream.writeMessage(29, getSystemParameters());
        }
        if (!getIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 33, this.id_);
        }
        if (this.sourceInfo_ != null) {
            codedOutputStream.writeMessage(37, getSourceInfo());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
