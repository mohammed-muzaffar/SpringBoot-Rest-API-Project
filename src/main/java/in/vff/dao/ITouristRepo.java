package in.vff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vff.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
