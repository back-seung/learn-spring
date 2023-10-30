package learningspring.chap08.service;import learningspring.chap08.dao.MemberDao;import learningspring.chap08.domain.Member;import learningspring.chap08.dto.RegisterRequest;import learningspring.chap08.exception.DuplicateMemberException;import java.time.LocalDateTime;public class MemberRegisterService {    private MemberDao memberDao;    public MemberRegisterService(MemberDao memberDao) {        this.memberDao = memberDao;    }    public Long regist(RegisterRequest request) {        Member member = memberDao.selectByEmail(request.getEmail());        if (member != null) {            throw new DuplicateMemberException("dup email" + request.getEmail());        }        Member newMember = new Member(                request.getEmail(),                request.getPassword(),                request.getName(),                LocalDateTime.now());        memberDao.insert(newMember);        return newMember.getId();    }}