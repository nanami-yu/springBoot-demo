package com.example.demo.rule;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

public class NewKieBase {

    //将业务规则写到规则库中
    public static KieBase rulekieBase(String rule){//rule值为动态的规则
        KieHelper helper = new KieHelper();
        KieBase kieBase = null;
        try {
            helper.addContent(rule, ResourceType.DRL);
            kieBase = helper.build();
        } catch (Exception e){
            e.printStackTrace();
        }
        return kieBase;
    }
}
