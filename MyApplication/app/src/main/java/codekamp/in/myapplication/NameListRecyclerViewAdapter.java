package codekamp.in.myapplication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp1 on 05-07-2016.
 */
public class NameListRecyclerViewAdapter extends RecyclerView.Adapter<NameListViewHolder> implements NameListViewHolder.ClickListener {

    public static List<NameList> response;
    private ClickListener listner;

    public NameListRecyclerViewAdapter(List<NameList> response,ClickListener listner){
        super();
        this.response =response;
        this.listner = listner;
    }



    @Override
    public NameListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NameListViewHolder holder = new NameListViewHolder(inflater.inflate(android.R.layout.simple_list_item_1, null));
        holder.setClickListener(this);
        //inflater convert xml into java
        return holder;
    }

    @Override
    public void onBindViewHolder(NameListViewHolder holder, int position)  {
        holder.currentRowNumber = position;
        holder.textView.setText(response.get(position).getName());

     //   Log.d("CodeKamp",result);
    }

    @Override
    public int getItemCount() {
       int size=response.size();
        return size;
    }


    @Override
    public void positionTapped(int position) {
        Log.d("CodeKamp", "Adapter informed about click by ViewHolder");
        this.listner.rowTapped(position);
    }



    public interface ClickListener {
        public void rowTapped(int position);
    }



}
