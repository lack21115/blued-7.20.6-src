package io.grpc.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.internal.GrpcUtil;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: source-8303388-dex2jar.jar:io/grpc/android/AndroidChannelBuilder.class */
public final class AndroidChannelBuilder extends ForwardingChannelBuilder<AndroidChannelBuilder> {
    private static final String LOG_TAG = "AndroidChannelBuilder";
    @Nullable
    private static final Class<?> OKHTTP_CHANNEL_BUILDER_CLASS = findOkHttp();
    @Nullable
    private Context context;
    private final ManagedChannelBuilder<?> delegateBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:io/grpc/android/AndroidChannelBuilder$AndroidChannel.class */
    public static final class AndroidChannel extends ManagedChannel {
        @Nullable
        private final ConnectivityManager connectivityManager;
        @Nullable
        private final Context context;
        private final ManagedChannel delegate;
        private final Object lock = new Object();
        private Runnable unregisterRunnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8303388-dex2jar.jar:io/grpc/android/AndroidChannelBuilder$AndroidChannel$DefaultNetworkCallback.class */
        public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
            private boolean isConnected;

            private DefaultNetworkCallback() {
                this.isConnected = false;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                if (this.isConnected) {
                    AndroidChannel.this.delegate.enterIdle();
                } else {
                    AndroidChannel.this.delegate.resetConnectBackoff();
                }
                this.isConnected = true;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                this.isConnected = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8303388-dex2jar.jar:io/grpc/android/AndroidChannelBuilder$AndroidChannel$NetworkReceiver.class */
        public class NetworkReceiver extends BroadcastReceiver {
            private boolean isConnected;

            private NetworkReceiver() {
                this.isConnected = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                boolean z = this.isConnected;
                boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.isConnected = z2;
                if (!z2 || z) {
                    return;
                }
                AndroidChannel.this.delegate.resetConnectBackoff();
            }
        }

        AndroidChannel(ManagedChannel managedChannel, @Nullable Context context) {
            this.delegate = managedChannel;
            this.context = context;
            if (context == null) {
                this.connectivityManager = null;
                return;
            }
            this.connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            try {
                configureNetworkMonitoring();
            } catch (SecurityException e) {
                Log.w(AndroidChannelBuilder.LOG_TAG, "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e);
            }
        }

        private void configureNetworkMonitoring() {
            if (Build.VERSION.SDK_INT >= 24 && this.connectivityManager != null) {
                final DefaultNetworkCallback defaultNetworkCallback = new DefaultNetworkCallback();
                this.connectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback);
                this.unregisterRunnable = new Runnable() { // from class: io.grpc.android.AndroidChannelBuilder.AndroidChannel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AndroidChannel.this.connectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
                    }
                };
                return;
            }
            final NetworkReceiver networkReceiver = new NetworkReceiver();
            this.context.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.unregisterRunnable = new Runnable() { // from class: io.grpc.android.AndroidChannelBuilder.AndroidChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidChannel.this.context.unregisterReceiver(networkReceiver);
                }
            };
        }

        private void unregisterNetworkListener() {
            synchronized (this.lock) {
                if (this.unregisterRunnable != null) {
                    this.unregisterRunnable.run();
                    this.unregisterRunnable = null;
                }
            }
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.delegate.authority();
        }

        @Override // io.grpc.ManagedChannel
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j, timeUnit);
        }

        @Override // io.grpc.ManagedChannel
        public void enterIdle() {
            this.delegate.enterIdle();
        }

        @Override // io.grpc.ManagedChannel
        public ConnectivityState getState(boolean z) {
            return this.delegate.getState(z);
        }

        @Override // io.grpc.ManagedChannel
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // io.grpc.ManagedChannel
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // io.grpc.Channel
        public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
            return this.delegate.newCall(methodDescriptor, callOptions);
        }

        @Override // io.grpc.ManagedChannel
        public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
            this.delegate.notifyWhenStateChanged(connectivityState, runnable);
        }

        @Override // io.grpc.ManagedChannel
        public void resetConnectBackoff() {
            this.delegate.resetConnectBackoff();
        }

        @Override // io.grpc.ManagedChannel
        public ManagedChannel shutdown() {
            unregisterNetworkListener();
            return this.delegate.shutdown();
        }

        @Override // io.grpc.ManagedChannel
        public ManagedChannel shutdownNow() {
            unregisterNetworkListener();
            return this.delegate.shutdownNow();
        }
    }

    private AndroidChannelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
        this.delegateBuilder = (ManagedChannelBuilder) Preconditions.checkNotNull(managedChannelBuilder, "delegateBuilder");
    }

    private AndroidChannelBuilder(String str) {
        Class<?> cls = OKHTTP_CHANNEL_BUILDER_CLASS;
        if (cls == null) {
            throw new UnsupportedOperationException("No ManagedChannelBuilder found on the classpath");
        }
        try {
            this.delegateBuilder = (ManagedChannelBuilder) cls.getMethod("forTarget", String.class).invoke(null, str);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ManagedChannelBuilder", e);
        }
    }

    private static Class<?> findOkHttp() {
        try {
            return Class.forName("io.grpc.okhttp.OkHttpChannelBuilder");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static AndroidChannelBuilder forAddress(String str, int i) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(str, i));
    }

    public static AndroidChannelBuilder forTarget(String str) {
        return new AndroidChannelBuilder(str);
    }

    @Deprecated
    public static AndroidChannelBuilder fromBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
        return usingBuilder(managedChannelBuilder);
    }

    public static AndroidChannelBuilder usingBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
        return new AndroidChannelBuilder(managedChannelBuilder);
    }

    @Override // io.grpc.ForwardingChannelBuilder, io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return new AndroidChannel(this.delegateBuilder.build(), this.context);
    }

    public AndroidChannelBuilder context(Context context) {
        this.context = context;
        return this;
    }

    @Override // io.grpc.ForwardingChannelBuilder
    public ManagedChannelBuilder<?> delegate() {
        return this.delegateBuilder;
    }
}
