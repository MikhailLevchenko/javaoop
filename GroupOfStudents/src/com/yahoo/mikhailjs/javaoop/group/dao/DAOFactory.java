package com.yahoo.mikhailjs.javaoop.group.dao;

public abstract class DAOFactory {
	
	public static final int SQLITE = 1;
	public static final int CSV = 2;
	
	public abstract GroupDAO getGroupDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case SQLITE:
			return new SqliteDAOFactory();
		case CSV:
			return new CsvDAOFactory();
		default:
			return null;
		}
		
	}
	
}
