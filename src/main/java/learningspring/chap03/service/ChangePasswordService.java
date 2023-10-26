package learningspring.chap03.service;import learningspring.chap03.domain.Member;import learningspring.chap03.dao.MemberDao;import learningspring.chap03.exception.MemberNotFoundException;public class ChangePasswordService {    private MemberDao memberDao;    public void changePassword(String email, String oldPwd, String newPwd) {        Member member = memberDao.selectByEmail(email);        if (member == null) {            throw new MemberNotFoundException();        }        member.changePassword(oldPwd, newPwd);        memberDao.update(member);    }    public void setMemberDao(MemberDao memberDao) {        this.memberDao = memberDao;    }}