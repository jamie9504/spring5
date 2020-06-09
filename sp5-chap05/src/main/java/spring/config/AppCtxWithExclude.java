package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.view.MemberSummaryPrinter;
import spring.view.VersionPrinter;

//@Configuration
//@ComponentScan(basePackages = {"spring"},
//	excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = {Configuration.class}))
public class AppCtxWithExclude {

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
