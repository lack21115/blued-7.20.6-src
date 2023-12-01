package com.loopj.android.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/MyRedirectHandler.class */
class MyRedirectHandler extends DefaultRedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final boolean enableRedirects;

    public MyRedirectHandler(boolean z) {
        this.enableRedirects = z;
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI rewriteURI;
        if (httpResponse != null) {
            Header firstHeader = httpResponse.getFirstHeader("location");
            if (firstHeader == null) {
                throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
            }
            String replaceAll = firstHeader.getValue().replaceAll(" ", "%20");
            try {
                URI uri = new URI(replaceAll);
                HttpParams params = httpResponse.getParams();
                URI uri2 = uri;
                if (!uri.isAbsolute()) {
                    if (params.isParameterTrue("http.protocol.reject-relative-redirect")) {
                        throw new ProtocolException("Relative redirect location '" + uri + "' not allowed");
                    }
                    HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                    if (httpHost == null) {
                        throw new IllegalStateException("Target host not available in the HTTP context");
                    }
                    try {
                        uri2 = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) httpContext.getAttribute("http.request")).getRequestLine().getUri()), httpHost, true), uri);
                    } catch (URISyntaxException e) {
                        throw new ProtocolException(e.getMessage(), e);
                    }
                }
                if (params.isParameterFalse("http.protocol.allow-circular-redirects")) {
                    RedirectLocations redirectLocations = (RedirectLocations) httpContext.getAttribute(REDIRECT_LOCATIONS);
                    RedirectLocations redirectLocations2 = redirectLocations;
                    if (redirectLocations == null) {
                        redirectLocations2 = new RedirectLocations();
                        httpContext.setAttribute(REDIRECT_LOCATIONS, redirectLocations2);
                    }
                    if (uri2.getFragment() != null) {
                        try {
                            rewriteURI = URIUtils.rewriteURI(uri2, new HttpHost(uri2.getHost(), uri2.getPort(), uri2.getScheme()), true);
                        } catch (URISyntaxException e2) {
                            throw new ProtocolException(e2.getMessage(), e2);
                        }
                    } else {
                        rewriteURI = uri2;
                    }
                    if (!redirectLocations2.contains(rewriteURI)) {
                        redirectLocations2.add(rewriteURI);
                        return uri2;
                    }
                    throw new CircularRedirectException("Circular redirect to '" + rewriteURI + "'");
                }
                return uri2;
            } catch (URISyntaxException e3) {
                throw new ProtocolException("Invalid redirect URI: " + replaceAll, e3);
            }
        }
        throw new IllegalArgumentException("HTTP response may not be null");
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        if (this.enableRedirects) {
            if (httpResponse != null) {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode != 307) {
                    switch (statusCode) {
                        case 301:
                        case 302:
                        case 303:
                            return true;
                        default:
                            return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        return false;
    }
}
