package com.hemangnh18.accomodation.API;



import com.hemangnh18.accomodation.POJO.PostRes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("exec")
    @FormUrlEncoded
    Call<PostRes> setData(@Field("action") String action, @Field("name") String name, @Field("email") String email,@Field("number") String phone,@Field("institute") String institute,@Field("id") String id,@Field("city") String city,@Field("days") String days);

}
