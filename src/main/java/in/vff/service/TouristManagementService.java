package in.vff.service;

import java.util.List;

import in.vff.model.Tourist;

public interface TouristManagementService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristByDetails(Tourist tourist);  
	public String updateTouristById(Integer id, Float hikePercent);
	public String deleteTourist(Integer id);
}
