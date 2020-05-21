package spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import spring.domain.Member;
import spring.repository.MemberDao;

public class MemberInfoPrinter {

    private MemberDao memDao;

    private MemberSummaryPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음" + System.lineSeparator());
            return;
        }
        printer.print(member);
        System.out.println();
    }

    @Autowired
    public void setMemDao(MemberDao memDao) {
        this.memDao = memDao;
    }

    @Autowired
    public void setPrinter(MemberSummaryPrinter printer) {
        this.printer = printer;
    }
}
