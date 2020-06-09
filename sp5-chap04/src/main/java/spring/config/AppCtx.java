package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.repository.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.view.MemberInfoPrinter;
import spring.view.MemberListPrinter;
import spring.view.MemberPrinter;
import spring.view.MemberSummaryPrinter;
import spring.view.VersionPrinter;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;
	}

//	@Bean
//	public MemberPrinter memberPrint() {
//		return new MemberPrinter();
//	}

//	@Bean
//	@Qualifier("printer")
//	public MemberPrinter memberPrint1() {
//		return new MemberPrinter();
//	}
//
//	@Bean
//	public MemberPrinter memberPrint2() {
//		return new MemberPrinter();
//	}

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrint1() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrint2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		MemberListPrinter listPrinter = new MemberListPrinter();
		listPrinter.setPrinter(memberPrint2());
		return listPrinter;
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
