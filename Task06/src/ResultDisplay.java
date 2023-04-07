class ResultDisplay {
    public class TableResultDisplayFactory implements ResultDisplayFactory {
    @Override
    public ResultDisplay createResultDisplay(DivisionResult result) {
        return new TableResultDisplay(result);
    }
    @Override
    public String getDisplayName() {
        return "Table Display";
    }
}

public class ChartResultDisplayFactory implements ResultDisplayFactory {
    @Override
    public ResultDisplay createResultDisplay(DivisionResult result) {
        return new ChartResultDisplay(result);
    }
    @Override
    public String getDisplayName() {
        return "Chart Display";
    }
}

    
}
