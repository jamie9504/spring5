package spring.view;

import spring.domain.Member;

public class MemberSummaryPrinter extends MemberPrinter {

	@Override
	public void print(Member member) {
		System.out.printf(
			"회원 정보 : 이메일 = %s, 이름 = %s%s",
			member.getEmail(), member.getName(), System.lineSeparator()
		);
	}
}
