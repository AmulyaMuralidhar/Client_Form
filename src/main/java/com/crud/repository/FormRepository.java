package com.crud.repository;
import com.crud.model.Form;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<Form, String> {
	List<Form> findByFormName(String formName);
}
