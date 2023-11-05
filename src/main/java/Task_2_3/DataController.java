package Task_2_3;

public class DataController {
    private DataModel model = new DataModel();

    public void addData(String item) {
        model.addData(item);
    }

    public int getTotalCount() {
        return model.getTotalCount();
    }
}
