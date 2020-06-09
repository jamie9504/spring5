package config;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtxWithCache {

	@Bean
	public Calculator calculator() {
		System.err.println("calculator");
		return new RecCalculator();
	}

	@Bean
	public CacheAspect cacheAspect() {
		System.err.println("cacheAspect");
		return new CacheAspect();
	}

	@Bean
	public ExeTimeAspect exeTimeAspect() {
		System.err.println("exeTimeAspect");
		return new ExeTimeAspect();
	}
}
