package com.example.demo.service;

import org.kie.api.KieBase;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.rule.NewKieBase.rulekieBase;
import static com.example.demo.rule.RuleExecute.activityRule;

@Service
public class DroolsService {
    /**
     * 创建KieSession
     * @return
     */
    public KieBase newKieBase() {
        KieBase kieBase = rulekieBase(activityRule());
        return kieBase;
    }

}
