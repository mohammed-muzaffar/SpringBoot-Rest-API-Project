package in.vff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vff.dao.ITouristRepo;
import in.vff.exception.TouristNotFoundException;
import in.vff.model.Tourist;

@Service
public class TouristMgmtServiceImpl implements TouristManagementService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = repo.save(tourist).getTid();
		return "Tourist is registered and ticket id :: " + tid;
	}

	@Override
	public List<Tourist> fetchAllTourist() {

		List<Tourist> list = repo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else { 
			throw new TouristNotFoundException( " Tourist not found with " + id);
		}
	}
	
	@Override
	public String updateTouristByDetails(Tourist tourist) {
		  Optional<Tourist> optional = repo.findById(tourist.getTid());
		if(optional.isPresent()) {
			repo.save(tourist); //save method performs both insertion and update depends on id values
			return tourist.getTid()+" Updated";
		} else {
			throw new TouristNotFoundException("tourist with id " +tourist.getTid()+ " not available for updation");
		}
	}
	
	@Override
	public String updateTouristById(Integer id, Float hikePercent) {
		
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+ (tourist.getBudget()*(hikePercent / 100)));
			repo.save(tourist);
			return "Tourist budget is updated for the id :: " + tourist.getTid();
			} else {
				throw new TouristNotFoundException("Tourist not found for the id");
			}
	}
	
	@Override
	public String deleteTourist(Integer id) {
		
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Tourist is deleted from database";
		} else {
			throw new TouristNotFoundException("Tourist Not Found for the id"+ id);
		}
		
	}
	 
}
