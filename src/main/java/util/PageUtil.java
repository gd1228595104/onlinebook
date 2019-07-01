package util;

import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-07 16:31
 */
public class PageUtil {

    public static List<Object> Page(int currPage, int pageSize, List list){
        //当前页数的第一条数据在list中的索引
        int firstIndex = (currPage-1)*pageSize;
        int lastIndex = currPage * pageSize;
        if(lastIndex>list.size()){
            lastIndex = list.size();
            return list.subList(firstIndex,lastIndex);
        }else{
            return list.subList(firstIndex,lastIndex);
        }
    }

}
