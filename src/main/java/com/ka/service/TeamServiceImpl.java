package com.ka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ka.dao.TeamDAO;
import com.ka.model.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	
	@Autowired
	private TeamDAO teamDAO;
	


	@Override
	@Transactional
	public void addTeam(Team team) {
		teamDAO.addTeam(team);
		
	}

	@Override
	public List<Team> getAllTeams() {
		return teamDAO.getAllTeams();
	}

	@Override
	public void deleteTeam(Integer teamId) {
		 teamDAO.deleteTeam(teamId);
		
	}

	@Override
	public Team updateTeam(Team team) {
		return teamDAO.updateTeam(team);
	}

	@Override
	public Team getTeam(int teamid) {
		
		return teamDAO.getTeam(teamid);
	}

	
	

}
