package com.crud.controller;

import com.crud.model.Form;
import com.crud.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @PostMapping
    public Form createForm(@RequestBody Form form) {
        form.setFormCreateDate(Instant.now());
        form.setFormModifiedDate(Instant.now());
        return formRepository.save(form);
    }

    @GetMapping("/{id}")
    public Form getForm(@PathVariable String id) {
        return formRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    @PutMapping("/{id}")
    public Form updateForm(@PathVariable String id, @RequestBody Form form) {
        form.setFormId(id);
        form.setFormModifiedDate(Instant.now());
        return formRepository.save(form);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable String id) {
        formRepository.deleteById(id);
    }
    
    @GetMapping("/name/{formName}")
    public List<Form> getFormsByName(@PathVariable String formName) {
        return formRepository.findByFormName(formName);
    }
    
    @PutMapping("/name/{formName}")
    public List<Form> updateFormsByName(@PathVariable String formName, @RequestBody Form updatedForm) {
        List<Form> forms = formRepository.findByFormName(formName);
        if (forms.isEmpty()) {
            throw new RuntimeException("No forms found with name: " + formName);
        }
        for (Form form : forms) {
            form.setFormName(updatedForm.getFormName());
            form.setFormJson(updatedForm.getFormJson());
            form.setFormModifiedDate(Instant.now());
            formRepository.save(form);
        }
        return forms; 
    }
    
    @DeleteMapping("/name/{formName}")
    public void deleteFormsByName(@PathVariable String formName) {
        List<Form> forms = formRepository.findByFormName(formName);
        if (forms.isEmpty()) {
            throw new RuntimeException("No forms found with name: " + formName);
        }
        for (Form form : forms) {
            formRepository.deleteById(form.getFormId());
        }
    }
}
