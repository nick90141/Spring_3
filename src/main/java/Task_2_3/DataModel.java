package Task_2_3;

import java.util.ArrayList;
import java.util.List;

public class DataModel {
    private List<String> data = new ArrayList<>();

    public void addData(String item) {
        data.add(item);
    }

    public int getTotalCount() {
        return data.size();
    }
}