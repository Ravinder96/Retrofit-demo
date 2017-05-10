package codekamp.in.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements Callback<ListResponse>,NameListRecyclerViewAdapter.ClickListener  {

    private RecyclerView nameListRecyclerView;
    public  String id;
    public  int positions;
    public  List<NameList> backresponse;



    @Override
    public void rowTapped(int position) {
        Log.d("CodeKamp", "Activity informed about click by Adapter");
        id=backresponse.get(position).getId();
       // Log.d("CodeKamp", "Activity informed about click by Adapter"+positions);
        Intent intent = ContactActivity.newIntent(this,id,positions);
        startActivity(intent);

    }

    public interface Listner {
        public void itemTapped(int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameListRecyclerView = (RecyclerView) findViewById(R.id.namelist_recyclerview);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us13.api.mailchimp.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MailchimpService mailchimpService = retrofit.create(MailchimpService.class);
        Call<ListResponse> call = mailchimpService.fetchLists("enter api kay here # not shared ");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {

        nameListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameListRecyclerView.setAdapter(new NameListRecyclerViewAdapter(response.body().getNameList(),this));

        backresponse = response.body().getNameList();

        for (int i = 0; i < response.body().getNameList().size(); i++) {

            Log.d("CodeKamp", response.body().getNameList().get(i).getName());
        }
    }

    @Override
    public void onFailure(Call<ListResponse> call, Throwable t) {
        Log.d("CodeKamp", t.getMessage());
        t.printStackTrace();

    }





}
