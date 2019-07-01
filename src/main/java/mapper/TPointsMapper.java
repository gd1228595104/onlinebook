package mapper;


import org.apache.ibatis.annotations.Param;


public interface TPointsMapper {

    //记录积分加变换表
    int insertAddTPoints(@Param("sid") Long sid);

    //记录积分减变化表
    int insertReduceTPoints(@Param("sid")Long sid);

}