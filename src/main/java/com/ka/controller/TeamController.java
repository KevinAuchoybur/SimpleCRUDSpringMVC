package com.ka.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ka.model.Team;
import com.ka.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/")
	public ModelAndView listTeam(ModelAndView model) throws IOException {
		List<Team> listTeam = teamService.getAllTeams();
		model.addObject("listTeam", listTeam);
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = "/newTeam", method = RequestMethod.GET)
	public ModelAndView newTeam(ModelAndView model) throws IOException {
		Team team = new Team();
		model.addObject("team", team);
		model.setViewName("teamForm");
		return model;
	}

	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public ModelAndView saveTeam(@ModelAttribute Team team) {
		if (team.getId() == 0) {

			teamService.addTeam(team);
		} else {

			teamService.updateTeam(team);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteTeam", method = RequestMethod.GET)
	public ModelAndView deleteTeam(HttpServletRequest request) {
		int teamId = Integer.parseInt(request.getParameter("id"));
		teamService.deleteTeam(teamId);
		return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "/editTeam", method = RequestMethod.GET)
	public ModelAndView editTeam(HttpServletRequest request) {
		int teamId = Integer.parseInt(request.getParameter("id"));
		Team team = teamService.getTeam(teamId);
		ModelAndView model = new ModelAndView("teamForm");
		model.addObject("team", team);
		return model;

	}
}
