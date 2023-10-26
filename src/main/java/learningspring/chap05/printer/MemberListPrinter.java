package learningspring.chap05.printer;import learningspring.chap05.dao.MemberDao;import learningspring.chap05.domain.Member;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;import java.util.Collection;@Component("listPrinter")public class MemberListPrinter {    private MemberDao memberDao;    private MemberPrinter memberPrinter;    public MemberListPrinter() {    }    public void printAll() {        Collection<Member> members = memberDao.selectAll();        members.forEach(m -> memberPrinter.print(m));    }    @Autowired    public void setMemberDao(MemberDao memberDao) {        this.memberDao = memberDao;    }    @Autowired    public void setMemberPrinter(MemberSummaryPrinter memberPrinter) {        this.memberPrinter = memberPrinter;    }}