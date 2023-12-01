package com.blued.android.sdk;

import com.blued.android.sdk.a.c;
import com.blued.android.sdk.a.d;
import com.blued.android.sdk.a.e;
import com.blued.android.sdk.model.BluedEntity;
import com.blued.android.sdk.model.EmptyModel;
import com.blued.android.sdk.model.ModelCallback;
import com.blued.android.sdk.model.RelationshipModel;
import com.blued.android.sdk.model.UserModel;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/BluedUser.class */
public class BluedUser {
    /* JADX WARN: Type inference failed for: r3v1, types: [com.blued.android.sdk.BluedUser$5] */
    public static void followUser(String str, String str2, String str3, String str4, String str5, ModelCallback<RelationshipModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str5);
        c.a(e.a(d.a() + "/users/" + str + "/followed/" + str2, hashMap), e.a(str3, str4, str5, valueOf), null, new TypeToken<BluedEntity<RelationshipModel>>() { // from class: com.blued.android.sdk.BluedUser.5
        }.getType(), modelCallback);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.blued.android.sdk.BluedUser$3] */
    public static void getFriendList(int i, String str, String str2, String str3, String str4, ModelCallback<List<UserModel>> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str4);
        hashMap.put("page", String.valueOf(i));
        c.a(e.a(d.a() + "/users/" + str + "/friends", hashMap), e.a(str2, str3, str4, valueOf), new TypeToken<BluedEntity<UserModel>>() { // from class: com.blued.android.sdk.BluedUser.3
        }.getType(), modelCallback);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.blued.android.sdk.BluedUser$1] */
    public static void getUserInfo(String str, String str2, String str3, ModelCallback<UserModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str3);
        c.a(e.a(d.a() + "/users/self", hashMap), e.a(str, str2, str3, valueOf), new TypeToken<BluedEntity<UserModel>>() { // from class: com.blued.android.sdk.BluedUser.1
        }.getType(), modelCallback);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.blued.android.sdk.BluedUser$2] */
    public static void getUserInfo(String str, String str2, String str3, String str4, ModelCallback<UserModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str4);
        c.a(e.a(d.a() + "/users/" + str, hashMap), e.a(str2, str3, str4, valueOf), new TypeToken<BluedEntity<UserModel>>() { // from class: com.blued.android.sdk.BluedUser.2
        }.getType(), modelCallback);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.blued.android.sdk.BluedUser$6] */
    public static void unfollowUser(String str, String str2, String str3, String str4, String str5, ModelCallback<RelationshipModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str5);
        c.a(e.a(d.a() + "/users/" + str + "/followed/" + str2 + "?http_method_override=DELETE", hashMap), e.a(str3, str4, str5, valueOf), null, new TypeToken<BluedEntity<RelationshipModel>>() { // from class: com.blued.android.sdk.BluedUser.6
        }.getType(), modelCallback);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.blued.android.sdk.BluedUser$4] */
    public static void updateGameStatus(String str, String str2, String str3, String str4, ModelCallback<EmptyModel> modelCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        HashMap hashMap = new HashMap();
        hashMap.put("T", valueOf);
        hashMap.put("access_token", str4);
        hashMap.put("operation", str);
        c.a(e.a(d.a() + "/game/" + str2 + "/status", hashMap), e.a(str2, str3, str4, valueOf), new TypeToken<BluedEntity<EmptyModel>>() { // from class: com.blued.android.sdk.BluedUser.4
        }.getType(), modelCallback);
    }
}
