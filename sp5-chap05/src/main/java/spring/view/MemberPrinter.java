package spring.view;

import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import spring.domain.Member;

public class MemberPrinter {

	private DateTimeFormatter dateTimeFormatter;

	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF%s",
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime(),
				System.lineSeparator());
		} else {
			System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s%s",
				member.getId(), member.getEmail(), member.getName(),
				dateTimeFormatter.format(member.getRegisterDateTime()), System.lineSeparator());
		}
	}

	@Autowired(required = false)
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
}
