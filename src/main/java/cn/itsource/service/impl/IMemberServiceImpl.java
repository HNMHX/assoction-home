package cn.itsource.service.impl;

import cn.itsource.domain.Member;
import cn.itsource.mapper.IMemberMapper;
import cn.itsource.query.MemberQuery;
import cn.itsource.service.IMemberService;
import cn.itsource.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create By  on 2022/12/22.
 */
@Service
@Transactional
public class IMemberServiceImpl implements IMemberService {

    @Autowired
    private IMemberMapper memberMapper;
    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public Member selectById(Long id) {
        return memberMapper.selectById(id);
    }

    @Override
    public void add(Member member) {
        memberMapper.add(member);
    }

    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    @Override
    public void deleteById(Long id) {
        memberMapper.deleteById(id);
    }

    @Override
    public PageList<Member> queryByPage(MemberQuery query) {
        //new一个PageList对象来接收参数
        PageList<Member> pageList = new PageList<>();
        //查询当前页的数据
        List<Member> rows = memberMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = memberMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        memberMapper.batchDelete(ids);
    }
}
