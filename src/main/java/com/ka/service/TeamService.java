package com.ka.service;

import java.util.List;

import com.ka.model.Team;

public interface TeamService {

	public void addTeam(Team team);

	public List<Team> getAllTeams();

	public void deleteTeam(Integer teamId);

	public Team updateTeam(Team team);

	public Team getTeam(int teamid);

}
