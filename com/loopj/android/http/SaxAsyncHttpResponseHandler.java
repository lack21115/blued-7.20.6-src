package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/SaxAsyncHttpResponseHandler.class */
public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler> extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "SaxAsyncHttpResponseHandler";
    private T handler;

    public SaxAsyncHttpResponseHandler(T t) {
        this.handler = null;
        if (t == null) {
            throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
        }
        this.handler = t;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        InputStreamReader inputStreamReader;
        XMLReader xMLReader;
        InputStreamReader inputStreamReader2 = null;
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        try {
            if (content != null) {
                try {
                    xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this.handler);
                    inputStreamReader = new InputStreamReader(content, "UTF-8");
                    inputStreamReader2 = inputStreamReader;
                } catch (ParserConfigurationException e) {
                    e = e;
                    inputStreamReader = null;
                } catch (SAXException e2) {
                    e = e2;
                    inputStreamReader = null;
                } catch (Throwable th) {
                    th = th;
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
                try {
                    xMLReader.parse(new InputSource(inputStreamReader));
                    AsyncHttpClient.silentCloseInputStream(content);
                } catch (ParserConfigurationException e4) {
                    e = e4;
                    inputStreamReader2 = inputStreamReader;
                    Log.e(LOG_TAG, "getResponseData exception", e);
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader == null) {
                        return null;
                    }
                    inputStreamReader.close();
                    return null;
                } catch (SAXException e5) {
                    e = e5;
                    inputStreamReader2 = inputStreamReader;
                    Log.e(LOG_TAG, "getResponseData exception", e);
                    AsyncHttpClient.silentCloseInputStream(content);
                    if (inputStreamReader == null) {
                        return null;
                    }
                    inputStreamReader.close();
                    return null;
                }
                try {
                    inputStreamReader.close();
                    return null;
                } catch (IOException e6) {
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, T t);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onSuccess(i, headerArr, (Header[]) this.handler);
    }

    public abstract void onSuccess(int i, Header[] headerArr, T t);

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(i, headerArr, (Header[]) this.handler);
    }
}
