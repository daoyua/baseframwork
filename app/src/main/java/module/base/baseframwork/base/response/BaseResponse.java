package module.base.baseframwork.base.response;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    @SerializedName("time_stamp")
    public String time_stamp;
    @SerializedName("msg")
    public String msg;
    @SerializedName("status")
    public String status;


}
