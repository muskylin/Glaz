package com.app.cms;

import com.app.cms.ct.entity.CT_CONTENT_TBL_E;
import com.app.cms.ct.entity.dao.CT_CONTENT_TBL_D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private CT_CONTENT_TBL_D ind;
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        CT_CONTENT_TBL_E e = new CT_CONTENT_TBL_E();
        ind.insertContent(e);
		return "hello";
	}
}