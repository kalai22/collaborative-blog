package com.backe.dao;

import com.backe.model.ProfilePicture;

public interface ProfileUploadDao {
void save(ProfilePicture profilePicture);
ProfilePicture getProfilePic(String username);
}

