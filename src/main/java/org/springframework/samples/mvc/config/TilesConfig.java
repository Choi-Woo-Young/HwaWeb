package org.springframework.samples.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(1);
		return tilesViewResolver;
	}

	/*
	 * @Bean(name = "viewResolver") public TilesViewResolver tilesViewResolver() {
	 * TilesViewResolver resolver = new TilesViewResolver();
	 * resolver.setViewClass(TilesView.class); resolver.setOrder(1); return
	 * resolver; }
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] { "WEB-INF/views/tiles/tiles.xml" });
		return tiles;
	}

}
