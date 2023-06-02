package cn.itsource.mapper;

import cn.itsource.domain.Member;
import cn.itsource.query.MemberQuery;
import org.apache.ibatis.annotations.Mapper;;

import java.util.List;

/**
 * Create By  on 2022/12/16.
 */
@Mapper
public interface IMemberMapper {
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
    //分页+条件查询
    List<Member> selectByPage(MemberQuery query);
    //计算总条数
    Long count(MemberQuery query);

    void batchDelete(List<Long> ids);
}
