package com.example.demo.batch;

import com.example.demo.model.User;
import com.example.demo.model.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemUserWriter implements ItemWriter<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void write(List<? extends User> items) throws Exception {
        System.out.println("data saved for users: "+ items);
        userRepository.save(items);
    }
}
