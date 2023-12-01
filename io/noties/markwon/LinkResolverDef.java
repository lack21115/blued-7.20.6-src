package io.noties.markwon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/LinkResolverDef.class */
public class LinkResolverDef implements LinkResolver {
    private static final String DEFAULT_SCHEME = "https";

    private static Uri parseLink(String str) {
        Uri parse = Uri.parse(str);
        Uri uri = parse;
        if (TextUtils.isEmpty(parse.getScheme())) {
            uri = parse.buildUpon().scheme("https").build();
        }
        return uri;
    }

    @Override // io.noties.markwon.LinkResolver
    public void resolve(View view, String str) {
        Uri parseLink = parseLink(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", parseLink);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w("LinkResolverDef", "Actvity was not found for the link: '" + str + "'");
        }
    }
}
