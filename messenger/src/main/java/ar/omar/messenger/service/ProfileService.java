package ar.omar.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ar.omar.messenger.database.DatabaseClass;
import ar.omar.messenger.model.Profile;

public class ProfileService {
	
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	public ProfileService() {
		profiles.put("Omar", new Profile(1L, "omar", "Omar", "Ag", new Date()));
		profiles.put("Armando", new Profile(2L, "armando", "Armando", "Ag", new Date()));
		profiles.put("Eve", new Profile(3L, "eve", "Eve", "Ag", new Date()));
	}

	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		String name = profile.getProfileName();
		profiles.put(name, profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		Profile res;
		
		if (profile.getId() <= 0) {
			res= null;
		}else{
			profiles.put(profile.getProfileName(), profile);
			res = profile;
		}
		return res;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
}
