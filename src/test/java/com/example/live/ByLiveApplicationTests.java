package com.example.live;

import com.example.live.entity.Merchant;
import com.example.live.mapper.MerchantMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ByLiveApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    MerchantMapper merchantMapper;

    @Test
    void merchantTest(){
        List<Merchant> merchant = merchantMapper.getMerchantListByParams(1, "", null, null);
        for (Merchant merchant1 : merchant) {
            System.out.println(merchant1);
        }
    }


}
