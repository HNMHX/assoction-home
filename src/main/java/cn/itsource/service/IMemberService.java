package cn.itsource.service;

import cn.itsource.domain.Member;
import cn.itsource.query.MemberQuery;
import cn.itsource.until.PageList;

import java.util.List;

/**
 * Create By  on 2022/12/16.
 */

public interface IMemberService {
    //查询全部
    List<Member> selectAll();
    //根据id查询单条数据
    Member selectById(Long id);
    //新增
    void add(Member member);
    //编辑
    void update(Member member);
    //删除
    void deleteById(Long id);
    //分页查询+查询总条数
    PageList<Member> queryByPage(MemberQuery query);

    void batchDelete(List<Long> ids);
}
