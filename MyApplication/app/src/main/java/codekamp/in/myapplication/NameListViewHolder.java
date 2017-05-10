package codekamp.in.myapplication;

import android.content.Intent;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hp1 on 05-07-2016.
 */
public class NameListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView textView;
    private ClickListener listner;
    public int currentRowNumber;

    public NameListViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView;
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("CodeKamp", "Holder informed about click by TextView");
        textView.setClickable(true);

        this.listner.positionTapped(this.currentRowNumber);
    }

    public void setClickListener(ClickListener listner) {
        this.listner = listner;
    }


    public interface ClickListener {
        public void positionTapped(int position);


    }
}
