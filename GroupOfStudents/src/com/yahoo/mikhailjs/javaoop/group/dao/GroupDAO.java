package com.yahoo.mikhailjs.javaoop.group.dao;

import com.yahoo.mikhailjs.javaoop.group.Group;

public interface GroupDAO {
	public void setGroup(Group group);
	public Group getGroup();
	public void updateGroup(Group group);
	public void deleteGroup();
}
