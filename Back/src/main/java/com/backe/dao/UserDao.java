package com.backe.dao;
import java.util.List;

import com.backe.model.User;

public interface UserDao {
User registerUser(User user);
User login(User user);
void updateUser(User user);
User getUser(int id);
}
