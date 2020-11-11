package com.example.demo.service;

import com.example.demo.dao.PersonMapper;
import com.example.demo.model.Person;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersionService {

    @Resource
    private PersonMapper personMapper;

    @Resource
    private DroolsService droolsService;


    public List<Person> listPerson(){
        KieBase kieBase = droolsService.newKieBase();
        List<Person> list=personMapper.selectAll();
        for(Person person:list){
            KieSession kieSession = kieBase.newKieSession();
            kieSession.insert(person);
            int i = kieSession.fireAllRules();
            kieSession.dispose();
        }
        return list;
    }

}
