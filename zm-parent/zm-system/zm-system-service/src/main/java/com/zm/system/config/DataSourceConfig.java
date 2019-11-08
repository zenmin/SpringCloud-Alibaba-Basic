package com.zm.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is 数据源配置
 * @Author ZengMin
 * @Date 2019/3/15 19:01
 */
@Configuration
@MapperScan("com.zm.system.mapper")
public class DataSourceConfig {

    /**
     * druid访问路径
     */
    private static final String PATTERN = "/druid/*";

    /**
     * 拦截路径
     */
    private static final String FILTER_PATTERN = "/api/*,/open/*";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置druid监控访问的servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), PATTERN);
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }

    /**
     * 配置druid监控的filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList(FILTER_PATTERN.split(",")));
        Map<String, String> stringStringMap = new HashMap<>(16);
        stringStringMap.put("exclusions", "*.js,*.html,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(stringStringMap);
        return filterRegistrationBean;
    }

    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
