package com.oracle.project.layer3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.oracle.project.layer2.NewsPaper;

@Repository			//Department ->DepartmentDAO->DepartmentDAOImpl
public interface NewsPaperRepository extends CrudRepository<NewsPaper, Integer> 
{
	
}

//now spring would provide the implementation
//of TicketRepository interface
//as SimpleCrudRepository