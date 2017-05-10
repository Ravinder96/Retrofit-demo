package codekamp.in.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp1 on 06-07-2016.
 */
public class ContactActivity extends AppCompatActivity implements Callback<ContactResponse> {

    private RecyclerView contactListRecyclerView;
    private int positions;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        positions = intent.getIntExtra("positions",0);

        contactListRecyclerView = (RecyclerView) findViewById(R.id.contactlist_recyclerview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us13.api.mailchimp.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MailchimpService mailchimpService = retrofit.create(MailchimpService.class);
        Call<ContactResponse> call1 = mailchimpService.fetchContact("c979b38608e545ae7e432e4ce19c357e-us13",id);
        Log.d("CodeKamp", "is is " + id);
        Log.d("CodeKamp",id);
        call1.enqueue(this);                             //"31bac5bce8"
    }


    public static Intent newIntent(Context context ,String id,int positions) {
        Intent intent = new Intent(context,ContactActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("positions",positions);
       // intent.putExtra("backresponse",backresponce);
        return intent;}


    @Override
    public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {

        contactListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactListRecyclerView.setAdapter(new ContactListRecyclerViewAdapter(response.body().getContacts(),positions));
      int size =response.body().getContacts().size();

        for (int i = 0; i <response.body().getContacts().size(); i++) {
            Log.d("CodeKamp",size+"");
            Log.d("CodeKamp", response.body().getContacts().get(i).getProfile().getEmail());
            Log.d("CodeKamp", response.body().getContacts().get(i).getProfile().getFirstName());
            Log.d("CodeKamp", response.body().getContacts().get(i).getProfile().getLastName());
            Log.d("CodeKamp", response.body().getContacts().get(i).getProfile().getPhoneNumber());
        }
    }

    @Override
    public void onFailure(Call<ContactResponse> call, Throwable t) {
        Log.d("CodeKamp", t.getMessage());
        t.printStackTrace();

    }
}
