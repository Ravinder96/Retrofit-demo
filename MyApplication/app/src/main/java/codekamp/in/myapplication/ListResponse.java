
package codekamp.in.myapplication;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ListResponse {



    @SerializedName("data")
    @Expose
    private List<NameList> nameList = new ArrayList<NameList>();



    public List<NameList> getNameList() {
        return nameList;
    }


    /*public void setData(List<ListResponse> data) {
        this.nameList = data;
    }
*/

}
