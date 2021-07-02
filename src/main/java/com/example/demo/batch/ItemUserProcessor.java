package com.example.demo.batch;

import com.example.demo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ItemUserProcessor implements ItemProcessor<User, User> {

    HashMap<String, String> DEPT = new HashMap<>();

    public ItemUserProcessor(){
        DEPT.put("1", "Mobility");
        DEPT.put("2", "POS");
        DEPT.put("3", "ModernWorkplace");

    }

    @Override
    public User process(User item) throws Exception {
        String deptCode = item.getUserpassword();
        String dept = DEPT.get(deptCode);
        item.setUserpassword(dept);
        return item;
    }
}
