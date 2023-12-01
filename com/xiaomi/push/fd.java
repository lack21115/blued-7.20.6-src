package com.xiaomi.push;

import java.net.UnknownHostException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fd.class */
final class fd {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fd$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        ex f27709a;

        /* renamed from: a  reason: collision with other field name */
        String f388a;

        a() {
        }
    }

    static a a(Exception exc) {
        m8695a(exc);
        Exception exc2 = exc;
        if (exc instanceof gf) {
            gf gfVar = (gf) exc;
            exc2 = exc;
            if (gfVar.a() != null) {
                exc2 = gfVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fw.a(exc2);
        if (a2 != 0) {
            aVar.f27709a = ex.a(ex.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.f27709a == null) {
            aVar.f27709a = ex.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f27709a == ex.GSLB_TCP_ERR_OTHER) {
            aVar.f388a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m8695a(Exception exc) {
        if (exc == null) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Exception exc) {
        ex exVar;
        Throwable cause;
        m8695a(exc);
        Exception exc2 = exc;
        if (exc instanceof gf) {
            gf gfVar = (gf) exc;
            exc2 = exc;
            if (gfVar.a() != null) {
                exc2 = gfVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fw.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            aVar.f27709a = ex.a(ex.CONN_SUCCESS.a() + a2);
            if (aVar.f27709a == ex.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                exVar = ex.CONN_BOSH_UNKNOWNHOST;
            }
            if (aVar.f27709a != ex.CONN_TCP_ERR_OTHER || aVar.f27709a == ex.CONN_XMPP_ERR || aVar.f27709a == ex.CONN_BOSH_ERR) {
                aVar.f388a = str;
            }
            return aVar;
        }
        exVar = ex.CONN_XMPP_ERR;
        aVar.f27709a = exVar;
        if (aVar.f27709a != ex.CONN_TCP_ERR_OTHER) {
        }
        aVar.f388a = str;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(Exception exc) {
        ex exVar;
        m8695a(exc);
        Exception exc2 = exc;
        if (exc instanceof gf) {
            gf gfVar = (gf) exc;
            exc2 = exc;
            if (gfVar.a() != null) {
                exc2 = gfVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fw.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            exVar = ex.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            exVar = ex.BIND_TCP_ERR;
        } else if (a2 == 499) {
            aVar.f27709a = ex.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                exVar = ex.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar.f27709a != ex.BIND_TCP_ERR || aVar.f27709a == ex.BIND_XMPP_ERR || aVar.f27709a == ex.BIND_BOSH_ERR) {
                aVar.f388a = str;
            }
            return aVar;
        } else {
            exVar = a2 != 109 ? a2 != 110 ? ex.BIND_XMPP_ERR : ex.BIND_TCP_BROKEN_PIPE : ex.BIND_TCP_CONNRESET;
        }
        aVar.f27709a = exVar;
        if (aVar.f27709a != ex.BIND_TCP_ERR) {
        }
        aVar.f388a = str;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Exception exc) {
        ex exVar;
        m8695a(exc);
        Exception exc2 = exc;
        if (exc instanceof gf) {
            gf gfVar = (gf) exc;
            exc2 = exc;
            if (gfVar.a() != null) {
                exc2 = gfVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fw.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            exVar = ex.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            exVar = ex.CHANNEL_TCP_ERR;
        } else if (a2 == 499) {
            aVar.f27709a = ex.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                exVar = ex.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar.f27709a != ex.CHANNEL_TCP_ERR || aVar.f27709a == ex.CHANNEL_XMPPEXCEPTION || aVar.f27709a == ex.CHANNEL_BOSH_EXCEPTION) {
                aVar.f388a = str;
            }
            return aVar;
        } else {
            exVar = a2 != 109 ? a2 != 110 ? ex.CHANNEL_XMPPEXCEPTION : ex.CHANNEL_TCP_BROKEN_PIPE : ex.CHANNEL_TCP_CONNRESET;
        }
        aVar.f27709a = exVar;
        if (aVar.f27709a != ex.CHANNEL_TCP_ERR) {
        }
        aVar.f388a = str;
        return aVar;
    }
}
