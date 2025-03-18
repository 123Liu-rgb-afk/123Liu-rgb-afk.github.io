package com.lrx.web.datavalid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author lrx
 * {@code @date} 2025/3/17 下午6:25
 */
@Controller
public class MonsterHandler {
    @RequestMapping(value = "/addMonster")
    public String addMonster(Map<String, Object> map) {
        map.put("monster", new Monster());
        return "datavalid/monster_addUI";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Monster monster , Errors errors,Map<String,Object>map) {
        //注意观察输出内容
        System.out.println("========== map =============");
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry.getKey() + " " + stringObjectEntry.getValue());

        }
        System.out.println("==================");
        if (errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError);
            }
            System.out.println("monster= " + monster);
            return "datavalid/monster_addUI";

        }
        return "datavalid/success";

    }

}
