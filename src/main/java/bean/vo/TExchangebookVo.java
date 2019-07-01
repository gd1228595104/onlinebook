package bean.vo;

import bean.TExchangebook;
import bean.TInactivebook;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-18 19:46
 */
public class TExchangebookVo extends TExchangebook {
    private TInactivebook tInactivebook;

    public TInactivebook gettInactivebook() {
        return tInactivebook;
    }

    public void settInactivebook(TInactivebook tInactivebook) {
        this.tInactivebook = tInactivebook;
    }
}
