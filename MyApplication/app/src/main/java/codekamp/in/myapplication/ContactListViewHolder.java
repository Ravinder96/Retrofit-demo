package codekamp.in.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp1 on 06-07-2016.
 */
public class ContactListViewHolder extends RecyclerView.ViewHolder {

    public static List<ContactList> contactLists;



    private TextView emailTextView;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView phoneNumberTextView;
    private EditText emailEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneNumberEditText;
   // private int size ;
    public int getposition;


    public ContactListViewHolder(View itemView, List<ContactList> contactLists) {
        super(itemView);
        this.contactLists = contactLists;


        emailTextView = (TextView) itemView.findViewById(R.id.email_textview);
        firstNameTextView = (TextView) itemView.findViewById(R.id.fname_textview);
        lastNameTextView = (TextView) itemView.findViewById(R.id.lname_textview);
        phoneNumberTextView = (TextView) itemView.findViewById(R.id.phoneNumber_textview);

        emailEditText = (EditText) itemView.findViewById(R.id.email_editview);
        firstNameEditText = (EditText) itemView.findViewById(R.id.fname_editview);
        lastNameEditText = (EditText) itemView.findViewById(R.id.lname_editview);
        phoneNumberEditText = (EditText) itemView.findViewById(R.id.phoneNumber_editview);
    }

    public void bindContact(int position ) {
      //  position=getposition;
        emailEditText.setText(contactLists.get(position).getProfile().getEmail());
        firstNameEditText.setText(contactLists.get(position).getProfile().getFirstName());
        lastNameEditText.setText(contactLists.get(position).getProfile().getLastName());
        phoneNumberEditText.setText(contactLists.get(position).getProfile().getPhoneNumber());

    }


}
