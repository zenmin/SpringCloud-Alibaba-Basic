package com.zm.zmweb.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.zm.zmweb.controller.GoodsFeignController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2019/11/13 17:32
 */
@Configuration
@Slf4j
public class SentinelConfig {

    /**
     * 初始化流控规则
     *
     * Field	说明	                                 默认值
     * resource	资源名，资源名是限流规则的作用对象
     * count	限流阈值
     * grade	限流阈值类型，QPS 或线程数模式       QPS 模式
     * limitApp	流控针对的调用来源	                default，代表不区分调用来源
     * strategy	调用关系限流策略：直接、链路、关联	    根据资源本身（直接）
     * controlBehavior	流控效果（直接拒绝 / 排队等待 / 慢启动模式），不支持按调用关系限流	        直接拒绝
     *
     */
    @PostConstruct
    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule(GoodsFeignController.GOODS_LIMIT_KEY);
        // set limit qps to 3
        rule.setCount(3);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        log.info("{}","流控规则初始化成功");
    }

    /**
     * 开启sentinel支持 扫描注解
     * @return
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }


}
