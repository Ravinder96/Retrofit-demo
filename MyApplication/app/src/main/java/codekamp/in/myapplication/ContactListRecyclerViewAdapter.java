package codekamp.in.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hp1 on 06-07-2016.
 */
public class ContactListRecyclerViewAdapter extends RecyclerView.Adapter<ContactListViewHolder> {

     public int positions;
    public List<ContactList> contactLists;

    public ContactListRecyclerViewAdapter( List<ContactList> contactLists,int positions) {
        this.contactLists =contactLists;
        this.positions=positions;
    }

    @Override
    public ContactListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ContactListViewHolder holder = new ContactListViewHolder(inflater.inflate(R.layout.show_contact, null),contactLists);
        //inflater convert xml into java
        return holder;

    }

    @Override
    public void onBindViewHolder(ContactListViewHolder holder, int position) {
        holder.getposition=positions;
        holder.bindContact(position);

    }

    @Override
    public int getItemCount() {
        return this.contactLists.size();
    }
}
