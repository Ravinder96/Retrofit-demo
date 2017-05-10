package codekamp.in.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp1 on 05-07-2016.
 */
public interface MailchimpService {

    @GET("lists/list")
    Call<ListResponse> fetchLists(@Query("apikey") String apiKey);

    @GET("lists/members")
    Call<ContactResponse> fetchContact(@Query("apikey") String apiKey, @Query("id") String listId);
}
