package com.pesonal.adsdk.apiClient;

import com.pesonal.adsdk.model.ResponseRoot;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {

  @FormUrlEncoded
  @POST("get_app.php")
  Call<ResponseRoot> responseCall(@Field("PHSUGSG6783019KG") String packagename, @Field("AFHJNTGDGD563200K") String keyhash,@Field("DTNHGNH7843DFGHBSA") String constant, @Field("DBMNBXRY4500991G") String constant2);
}