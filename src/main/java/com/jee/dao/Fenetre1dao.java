package com.jee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jee.beans.Stage;

public interface Fenetre1dao {
	
	public List<Stage> SelectAllStages() throws SQLException;
}
