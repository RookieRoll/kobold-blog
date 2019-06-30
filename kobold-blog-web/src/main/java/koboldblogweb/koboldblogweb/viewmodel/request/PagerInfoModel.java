package koboldblogweb.koboldblogweb.viewmodel.request;

import java.io.Serializable;

public class PagerInfoModel implements Serializable {
    private int pageIndex;
    private int pageeSize;
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }



    public int getPageeSize() {
        return pageeSize;
    }

    public void setPageeSize(int pageeSize) {
        this.pageeSize = pageeSize;
    }
}
