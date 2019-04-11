package com.nhn.edu.springboot.property.eduspringbootproperty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduSpringbootPropertyApplicationTests {
    
    @Autowired
    private EduSpringbootPropertyApplication.YourProperties yourProperties;

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void testRandomValue() {
        assertThat(yourProperties.getAge(), is(lessThan(100)));
    }

}
