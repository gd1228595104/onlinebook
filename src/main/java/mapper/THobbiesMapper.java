package mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface THobbiesMapper {

    /**
     *描述：选择兴趣标签
     *参数：hobby
     *返回类型：int
     */
    int chooseHobbies(@Param("sid") Long sid, @Param("hobbies") String hobbies);

    //删除兴趣标签
    int deleteHobbies(@Param("sid") Long sid);

}