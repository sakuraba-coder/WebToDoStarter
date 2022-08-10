package com.example.demo.app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.app.collatz.Collatz;
import com.example.demo.app.collatz.DataBean;
import com.example.demo.app.collatz.Output;

@Controller
@RequestMapping("/")
public class SampleController {

	@GetMapping
	public String test(Model model) {

		return "test";
	}

	@PostMapping(value = "/hello", params="normal")
	public String postReqest(@RequestParam(name = "text1", required = false) String str1,
			@RequestParam(name = "text2", required = false) String str2, Model model) {

		Collatz collatz = new Collatz();
		List<?> list;

		if (str1!=null && str2!=null) {
			Output op = collatz.calcs(str1, str2);
			list = op.getList();

			String json = op.getJsonStr();

			model.addAttribute("json", json);
			model.addAttribute("list1", list);
		} else if (str1!=null) {

			Output ds = collatz.calc(str1);
			list = ds.getList();
			String json = ds.getJsonStr();

			DataBean data = collatz.getData();

			model.addAttribute("json", json);
			model.addAttribute("list2", list);
			model.addAttribute("d", data);

		} else {
			return "test";
		}

		return "response";
	}

	@PostMapping(value = "/hello", params="bignum")
	public String postReqest2(@RequestParam(name = "text1", required = false) String str1,
			@RequestParam(name = "text2", required = false) String str2, Model model) {

		Collatz collatz = new Collatz();
		List<?> list;
		if (str1!=null && str2!=null) {
			model.addAttribute("name", "元数値:"+str1);
			int retNum = Integer.valueOf(str2);
			Output op = collatz.calcs(str1, retNum);
			list = op.getList();
			String json = op.getJsonStr();

			model.addAttribute("json", json);

			model.addAttribute("list3", list);
		} else {
			return "test";
		}

		return "response";
	}


}
