package com.softtek.backend.src.presentation.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.EmailBEmailDto;
import com.softtek.backend.src.application.usecase.business_email.CreateBusinessEmailUseCase;
import com.softtek.backend.src.application.usecase.business_email.DeleteBusinessEmailUseCase;
import com.softtek.backend.src.application.usecase.business_email.FindAllBusinessEmailUseCase;
import com.softtek.backend.src.application.usecase.business_email.FindByEmailBusinessEmail;
import com.softtek.backend.src.domain.entity.BusinessEmail;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/business-email")
public class BusinessEmailController {

    @Autowired
    private FindAllBusinessEmailUseCase findAllBusinessEmailUseCase;

    @Autowired
    private FindByEmailBusinessEmail findByEmailBusinessEmail;

    @Autowired
    private CreateBusinessEmailUseCase createBusinessEmailUseCase;

    @Autowired DeleteBusinessEmailUseCase deleteBusinessEmailUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<BusinessEmail>> findAll() {
        return ResponseEntity.ok(this.findAllBusinessEmailUseCase.execute(null));
    }

    @GetMapping
    public ResponseEntity<BusinessEmail> findByEmail(@RequestBody @Valid EmailBEmailDto dto) {
        return this.findByEmailBusinessEmail.execute(dto.email)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid EmailBEmailDto dto) {
        this.createBusinessEmailUseCase.execute(dto);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid EmailBEmailDto dto) {
        this.deleteBusinessEmailUseCase.execute(dto.email);
        return ResponseEntity.noContent().build();
    }
}
