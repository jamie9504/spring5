package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.repository.MemberDao;
import spring.view.MemberPrinter;
import spring.view.MemberSummaryPrinter;
import spring.view.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring", "spring2"})
public class AppCtx {

	@Bean
	public MemberDao memberDao2() {
		MemberDao memberDao = new MemberDao();
		return memberDao;
	}

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
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
