package com.ka.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ka.model.Team;

@Repository
public class TeamDaoImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTeam(Team team) {
		sessionFactory.getCurrentSession().saveOrUpdate(team);

	}

	@SuppressWarnings("unchecked")
	public List<Team> getAllTeams() {

		return sessionFactory.getCurrentSession().createQuery("from Team").list();
	}

	@Override
	public void deleteTeam(Integer teamId) {

		Team team = (Team) sessionFactory.getCurrentSession().load(Team.class, teamId);
		if (null != team) {

			this.sessionFactory.getCurrentSession().delete(team);
		}
	}

	@Override
	public Team updateTeam(Team team) {
		sessionFactory.getCurrentSession().update(team);
		return team;

	}

	public Team getTeam(int teamid) {
		return (Team) sessionFactory.getCurrentSession().get(Team.class, teamid);
	}

}
