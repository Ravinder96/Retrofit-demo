package codekamp.in.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp1 on 06-07-2016.
 */
public class ContactResponse {



    @SerializedName("data")
    @Expose
    private List<ContactList> contacts = new ArrayList<ContactList>();


    public List<ContactList> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactList> contacts) {
        this.contacts = contacts;
    }
}
