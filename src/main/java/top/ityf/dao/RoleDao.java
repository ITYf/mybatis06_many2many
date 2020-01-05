package top.ityf.dao;

import top.ityf.domain.Role;

import java.util.List;

/**
 * ClassName:RoleDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2019/11/20 19:01
 * @Author: YanFei
 */
public interface RoleDao {
    /**
     * 查询所有角色
     * */
    List<Role> findAll();
}
