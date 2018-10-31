package module.base.baseframwork.test.test_dagger2;

import module.base.baseframwork.base.response.BaseResponse;

public class WorkResponse extends BaseResponse {

    String work_type;
    int work_time;
    String work_address;
    int work_price;


    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public int getWork_time() {
        return work_time;
    }

    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }

    public String getWork_address() {
        return work_address;
    }

    public void setWork_address(String work_address) {
        this.work_address = work_address;
    }

    public int getWork_price() {
        return work_price;
    }

    public void setWork_price(int work_price) {
        this.work_price = work_price;
    }

    @Override
    public String toString() {
        return "WorkResponse{" +
                "work_type='" + work_type + '\'' +
                ", work_time=" + work_time +
                ", work_address='" + work_address + '\'' +
                ", work_price=" + work_price +
                '}';
    }
}
