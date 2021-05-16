package com.recomecar.projeto.recomecar.projeto.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;

@Controller
public class IndexController {
	
	@Autowired
	private CompanyRepository repoComp;
	
	@Autowired
	private CandidateRepository repoCand;
	
	@GetMapping("/")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("auth", auth.getAuthorities());
		if(auth.getName() != "anonymousUser") {
			String tipoAuth = auth.getAuthorities().toString();
			if(tipoAuth.contains("[IMI]")) {
				Long id = repoCand.findByEmailCandidate(auth.getName()).getId();
				model.addAttribute("id", id.toString());
			}else if(tipoAuth.contains("[EMP]")) {
				Long id = repoComp.findByEmailCompany(auth.getName()).getId();
				model.addAttribute("id", id.toString());
			}
		}
		return "index";
	}

}
