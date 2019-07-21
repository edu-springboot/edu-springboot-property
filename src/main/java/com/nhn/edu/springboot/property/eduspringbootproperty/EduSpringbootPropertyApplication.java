package com.nhn.edu.springboot.property.eduspringbootproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(EduSpringbootPropertyApplication.YourProperties.class)
public class EduSpringbootPropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduSpringbootPropertyApplication.class, args);
    }
    
    // @Value 예제
    
    @Value("${number}")
    private String number;

    @GetMapping("/canIHaveYourNumber")
    public String canIHaveYourNumber() {
        return this.number;
    }


    // Type-Safe 예제

    @Autowired
    private YourProperties youProperties;

    @GetMapping("/canIHaveYourInfo")
    public YourProperties canIHaveYourInfo() {
        return youProperties;
    }
    
    
    @ConfigurationProperties(prefix = "nhn.edu.your")
    class YourProperties {
        private String name;
        private String number;
        private String address;
        private Integer age = 50;
        private List<String> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getChildren() {
            return children;
        }

        public void setChildren(List<String> children) {
            this.children = children;
        }
    }

}
