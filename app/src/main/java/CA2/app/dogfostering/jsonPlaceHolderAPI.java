package CA2.app.dogfostering;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.PATCH;

import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface jsonPlaceHolderAPI {


    @PUT("/api/Dogs/{id}")
    Call<Dogs> putPost(@Path("id") String id, @Body Dogs dog);

}