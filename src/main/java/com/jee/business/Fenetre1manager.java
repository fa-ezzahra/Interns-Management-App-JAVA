package com.jee.business;

import java.sql.SQLException;
import java.util.List;

import com.jee.beans.Stage;

public interface Fenetre1manager {

	public List<Stage> selectAllStages() throws SQLException ;
}
