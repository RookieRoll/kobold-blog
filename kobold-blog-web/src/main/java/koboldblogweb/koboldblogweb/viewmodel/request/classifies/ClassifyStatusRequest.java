package koboldblogweb.koboldblogweb.viewmodel.request.classifies;

public class ClassifyStatusRequest {
    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private boolean stopped;
    private String id;
}
