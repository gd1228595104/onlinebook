package mapper;


import bean.TAdmin;
import bean.TStudent;

public interface TAdminMapper {
    TAdmin findByUsername(String admin);

    int updateStuInfo(TStudent tStudent);
}